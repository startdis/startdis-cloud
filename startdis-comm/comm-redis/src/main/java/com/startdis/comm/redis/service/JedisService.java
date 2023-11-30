package com.startdis.comm.redis.service;

import cn.hutool.core.util.SerializeUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Component
public class JedisService {
    private static Logger logger = LoggerFactory.getLogger(JedisService.class);

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    @Resource
    private JedisPool jedisPool;

    @Value("${spring.redis.database}")
    private int database;

    public Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 库存初始化
     * 大于等于0:剩余库存（新增之后剩余的库存）
     */
    private static final String INIT_INVENTORY =
            "if (tonumber(redis.call('hget', KEYS[1], KEYS[2])) == nil) then"
                    + "    return tonumber(redis.call('hset', KEYS[1], KEYS[2], ARGV[1]));"
                    + "else"
                    + "    if (redis.call('hdel', KEYS[1], KEYS[2]) == 1) then"
                    + "        return tonumber(redis.call('hset', KEYS[1], KEYS[2], ARGV[1]));"
                    + "    end;"
                    + "end;";

    /**
     * 库存重置
     * -3:库存未初始化
     */
    private static final String RESET_INVENTORY =
            "if (redis.call('exists', KEYS[1]) == 1) then"
                    + "    local occStock = tonumber(redis.call('hget', KEYS[1], KEYS[2]));"
                    + "    if (occStock == nil) then"
                    + "        return tonumber(redis.call('hset', KEYS[1], KEYS[2], ARGV[1]));"
                    + "    end;"
                    + "    if (redis.call('hdel', KEYS[1], KEYS[2]) == 1) then"
                    + "        return redis.call('hincrby', KEYS[1], KEYS[2], ARGV[1]);"
                    + "    end;"
                    + "    return tonumber(redis.call('hget', KEYS[1], ARGV[1]));"
                    + "end;"
                    + "return -3;";

    /**
     * 回写库存
     * -5:库存操作失败
     * -4:代表库存传进来的值是负数（非法值）
     * -3:库存未初始化
     * -2:预占库存不足
     * -1:预占库存为0
     * 大于等于0:剩余库存（扣减之后剩余的库存)
     */
    private static final String REBACK_INVENTORY =
            "if (redis.call('exists', KEYS[1]) == 1) then"
                    + "    local stock = tonumber(redis.call('hget',KEYS[3],KEYS[4]));"
                    + "    local num = tonumber(ARGV[1]);"
                    + "    if (num <= 0) then"
                    + "        return -4;"
                    + "    end;"
                    + "    if (stock <= 0) then"
                    + "        return -1;"
                    + "    end;"
                    + "    if (stock >= num) then"
                    + "        if (redis.call('hset', KEYS[3], KEYS[4], stock - num) == 1) then"
                    + "            return redis.call('hincrby', KEYS[1], KEYS[2], num);"
                    + "        else"
                    + "            return -5;"
                    + "        end;"
                    + "    end;"
                    + "    return -2;"
                    + "end;"
                    + "return -3;";

    /**
     * 扣减库存
     * -5:库存操作失败
     * -4:代表库存传进来的值是负数（非法值）
     * -3:库存未初始化
     * -2:可用库存不足
     * -1:库存为0
     * 大于等于0:剩余库存（扣减之后剩余的库存)
     */
    public static final String REDUCE_INVENTORY =
            "if (redis.call('exists', KEYS[1]) == 1) then"
                    + "    local stock = tonumber(redis.call('hget',KEYS[1],ARGV[1]));"
                    + "    local num = tonumber(ARGV[3]);"
                    + "    if (num <= 0) then"
                    + "        return -4;"
                    + "    end;"
                    + "    if (stock <= 0) then"
                    + "        return -1;"
                    + "    end;"
                    + "    if (stock >= num) then"
                    + "        if (redis.call('hset', KEYS[2], ARGV[2], num) == 1) then"
                    + "            return redis.call('hincrby', KEYS[1], ARGV[1], 0 - num);"
                    + "        else"
                    + "            return -5;"
                    + "        end;"
                    + "    end;"
                    + "    return -2;"
                    + "end;"
                    + "return -3;";

    /**
     * 初始缓存库存:
     *
     * @param stockKey
     * @param stockNum
     * @return
     */
    public Boolean initCacheStock(String productKey, String stockKey, String stockNum) {
        Jedis jedis = this.getJedis();
        String initCacheStockScript = jedis.scriptLoad(INIT_INVENTORY);
        Long result = (Long) jedis.evalsha(initCacheStockScript, Arrays.asList(productKey, stockKey), Arrays.asList(stockNum));
        if (result >= 0) {
            log.info("增加产品[{}] 缓存库存:[{}]成功。", productKey, result);
            return Boolean.TRUE;
        }
        log.error("增加产品[{}]缓存库存失败！", productKey);
        return Boolean.FALSE;
    }

    /**
     * 重置缓存库存:
     *
     * @param stockKey
     * @param stockNum
     * @return
     */
    public Boolean resetCacheStock(String productKey, String stockKey, String stockNum) {
        Jedis jedis = this.getJedis();
        String resetCacheStockScript = jedis.scriptLoad(RESET_INVENTORY);
        Long result = (Long) jedis.evalsha(resetCacheStockScript, Arrays.asList(productKey, stockKey), Arrays.asList(stockNum));
        if (result >= 0) {
            log.info("重置产品[{}] 缓存库存:[{}]成功。", productKey, result);
            return Boolean.TRUE;
        }
        if (-3L == result) {
            log.error("重置产品[{}] 缓存库存时，发现产品缓存未初始化！", productKey);
            return Boolean.FALSE;
        }
        log.error("重置产品[{}]缓存库存失败！", productKey);
        return Boolean.FALSE;

    }

    /**
     * 回写库存
     *
     * @param productInventoryKey
     * @param stockKey
     * @param productConsumKey
     * @param consumKey
     * @param stockNum
     * @return
     */
    public boolean addCacheStock(String productInventoryKey, String stockKey, String productConsumKey, String consumKey, String stockNum) {
        Jedis jedis = this.getJedis();
        String rebackCacheStockScript = jedis.scriptLoad(REBACK_INVENTORY);
        Long result = (Long) jedis.evalsha(rebackCacheStockScript, Arrays.asList(productInventoryKey, stockKey, productConsumKey,consumKey), Arrays.asList(stockNum));
        if (result >= 0) {
            log.info("回写产品[{}] 缓存库存:[{}]成功。", productInventoryKey, result);
            return Boolean.TRUE;
        }
        if (-1L == result) {
            log.error("回写产品[{}] 缓存库存时，预占库存为0！", productInventoryKey);
            return Boolean.FALSE;
        }
        if (-2L == result) {
            log.error("回写产品[{}] 缓存库存时，预占库存不足！", productInventoryKey);
            return Boolean.FALSE;
        }
        if (-3L == result) {
            log.error("回写产品[{}] 缓存库存时，发现产品缓存未初始化！", productInventoryKey);
            return Boolean.FALSE;
        }
        if (-4L == result) {
            log.error("回写产品[{}] 缓存库存时，库存传进来的值是负数（非法值）！", productInventoryKey);
            return Boolean.FALSE;
        }
        if (-5L == result) {
            log.error("回写产品[{}] 缓存库存时，库存操作失败！", productInventoryKey);
            return Boolean.FALSE;
        }
        log.error("回写产品[{}]缓存库存失败！", productInventoryKey);
        return Boolean.FALSE;
    }

    /**
     * 扣减库存
     *
     * @param productInventoryKey
     * @param stockKey
     * @param productConsumKey
     * @param consumKey
     * @param stockNum
     * @return
     */
    public Boolean reduceCacheStock(String productInventoryKey, String stockKey, String productConsumKey, String consumKey, String stockNum) {
        Jedis jedis = this.getJedis();
        String reduceCacheStockScript = jedis.scriptLoad(REDUCE_INVENTORY);
        Long result = (Long) jedis.evalsha(reduceCacheStockScript, Arrays.asList(productInventoryKey, stockKey, productConsumKey,consumKey), Arrays.asList(stockNum));
        if (result >= 0) {
            log.info("扣减产品[{}] 缓存库存:[{}]成功。", productInventoryKey, result);
            return Boolean.TRUE;
        }
        if (-1L == result) {
            log.error("扣减产品[{}] 缓存库存时，预占库存为0！", productInventoryKey);
            return Boolean.FALSE;
        }
        if (-2L == result) {
            log.error("扣减产品[{}] 缓存库存时，预占库存不足！", productInventoryKey);
            return Boolean.FALSE;
        }
        if (-3L == result) {
            log.error("扣减产品[{}] 缓存库存时，发现产品缓存未初始化！", productInventoryKey);
            return Boolean.FALSE;
        }
        if (-4L == result) {
            log.error("扣减产品[{}] 缓存库存时，库存传进来的值是负数（非法值）！", productInventoryKey);
            return Boolean.FALSE;
        }
        if (-5L == result) {
            log.error("扣减产品[{}] 缓存库存时，库存操作失败！", productInventoryKey);
            return Boolean.FALSE;
        }
        log.error("扣减产品[{}]缓存库存失败！", productInventoryKey);
        return Boolean.FALSE;
    }

    public boolean lpush(String key, String value, int expire) {
        return this.lpush(key, value, expire, database);
    }

    public boolean lpush(String key, String value, int expire, int dataBase) {
        Jedis jedis = null;

        boolean var7;
        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            jedis.lpush(key, new String[]{value});
            if (expire > 0) {
                jedis.expire(key.getBytes(), expire);
            }

            return true;
        } catch (Exception var11) {
            logger.error("插入key为" + key + "的操作产生异常：", var11);
            var7 = false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var7;
    }

    public String lpop(String key) {
        return this.lpop(key, database);
    }

    public String lpop(String key, int dataBase) {
        Jedis jedis = null;
        String obj = null;

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            obj = jedis.lpop(key);
        } catch (Exception var9) {
            logger.error("根据" + key + "获取对象的操作产生异常：", var9);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return obj;
    }

    public boolean hput(String tableName, String key, Object object) {
        return this.hput(tableName, key, object, database);
    }

    public boolean hput(String tableName, String key, Object object, int dataBase) {
        Jedis jedis = null;

        boolean var7;
        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            jedis.hset(tableName.getBytes(), key.getBytes(), SerializeUtil.serialize(object));
            return true;
        } catch (Exception var11) {
            logger.error(tableName + "哈希表put操作产生异常：", var11);
            var7 = false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var7;
    }

    public boolean hset(String tableName, String key, Object object, int expire) {
        return this.hset(tableName, key, object, expire, database);
    }

    public boolean hset(String tableName, String key, Object object, int expire, int dataBase) {
        Jedis jedis = null;

        boolean var8;
        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            jedis.hset(tableName.getBytes(), key.getBytes(), SerializeUtil.serialize(object));
            if (expire > 0) {
                jedis.expire(tableName.getBytes(), expire);
            }

            return true;
        } catch (Exception var12) {
            logger.error(tableName + "哈希表hset操作产生异常", var12);
            var8 = false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var8;
    }

    public Object hget(String tableName, String key) {
        return this.hget(tableName, key, database);
    }

    public Object hget(String tableName, String key, int dataBase) {
        Jedis jedis = null;
        Object obj = null;

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            obj = SerializeUtil.deserialize(jedis.hget(tableName.getBytes(), key.getBytes()));
        } catch (Exception var10) {
            logger.error(tableName + "哈希表get操作产生异常：", var10);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return obj;
    }

    public void hdel(String tableName, String key) {
        this.hdel(tableName, key, database);
    }

    public void hdel(String tableName, String key, int dataBase) {
        Jedis jedis = null;

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            jedis.hdel(tableName.getBytes(), new byte[][]{key.getBytes()});
        } catch (Exception var9) {
            logger.error(tableName + "哈希表del操作产生异常：", var9);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

    }

    public Map<String, Object> hgetAll(String tableName) {
        return this.hgetAll(tableName, database);
    }

    public Map<String, Object> hgetAll(String tableName, int dataBase) {
        Jedis jedis = null;
        Hashtable map = new Hashtable();

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            Map<byte[], byte[]> map1 = jedis.hgetAll(tableName.getBytes());
            Iterator var6 = map1.entrySet().iterator();

            while(var6.hasNext()) {
                Map.Entry<byte[], byte[]> entry = (Map.Entry)var6.next();
                map.put(new String((byte[])entry.getKey()), SerializeUtil.deserialize((byte[])entry.getValue()));
            }
        } catch (Exception var11) {
            logger.error(tableName + "哈希表getAll操作产生异常：", var11);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return map;
    }

    public Long getHashCount(String tableName) {
        return this.getHashCount(tableName, database);
    }

    public Long getHashCount(String tableName, int dataBase) {
        Jedis jedis = null;
        Long result = null;

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            result = jedis.hlen(tableName);
        } catch (Exception var9) {
            logger.error(tableName + "哈希表len操作产生异常：", var9);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return result;
    }

    public long llen(String tableName) {
        return this.llen(tableName, database);
    }

    public long llen(String tableName, int dataBase) {
        Jedis jedis = null;
        long re = 0L;

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            re = jedis.llen(tableName.getBytes());
        } catch (Exception var10) {
            logger.error(tableName + "队列len操作产生异常：", var10);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return re;
    }

    public boolean lput(String tableName, Object object) {
        return this.lput(tableName, object, database);
    }

    public boolean lput(String tableName, Object object, int dataBase) {
        Jedis jedis = null;

        boolean var6;
        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            jedis.lpush(tableName.getBytes(), new byte[][]{SerializeUtil.serialize(object)});
            return true;
        } catch (Exception var10) {
            logger.error(tableName + "队列put的操作产生异常：", var10);
            var6 = false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var6;
    }

    public Object get(String key) {
        return this.get(key, database);
    }

    public Object get(String key, int dataBase) {
        Jedis jedis = null;
        Object obj = null;

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            obj = SerializeUtil.deserialize(jedis.get(key.getBytes()));
        } catch (Exception var9) {
            logger.error("根据" + key + "获取对象的操作产生异常：", var9);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return obj;
    }

    public String getString(String key) {
        return this.getString(key, database);
    }

    public String getString(String key, int dataBase) {
        Jedis jedis = null;
        String obj = null;

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            obj = jedis.get(key);
        } catch (Exception var9) {
            logger.error("根据" + key + "获取对象的操作产生异常：", var9);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return obj;
    }

    public boolean set(String key, Object object) {
        return this.set(key, object, 0, database);
    }

    public boolean set(String key, Object object, int expire, int dataBase) {
        Jedis jedis = null;

        boolean var7;
        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            jedis.set(key.getBytes(), SerializeUtil.serialize(object));
            if (expire > 0) {
                jedis.expire(key.getBytes(), expire);
            }

            return true;
        } catch (Exception var11) {
            logger.error("插入key为" + key + "的操作产生异常：", var11);
            var7 = false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var7;
    }

    public boolean set(String key, Object object, int expire) {
        Jedis jedis = null;

        boolean var6;
        try {
            jedis = this.getJedis();
            jedis.select(database);
            jedis.set(key.getBytes(), SerializeUtil.serialize(object));
            if (expire > 0) {
                jedis.expire(key.getBytes(), expire);
            }

            return true;
        } catch (Exception var10) {
            logger.error("插入key为" + key + "的操作产生异常：", var10);
            var6 = false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var6;
    }

    /**
     * 加锁, value会被设为1, 使用默认数据库
     *
     * @param lockKey lockKey
     * @param expire  过期毫秒数
     * @return 是否加锁成功, 加锁不成功意味着已经存在锁
     */
    public boolean lock(String lockKey, int expire) {
        try (Jedis jedis = getJedis()) {
            jedis.select(database);
            String setResult = jedis.setex(lockKey, expire,"1");
            return LOCK_SUCCESS.equals(setResult);
        }
    }

    public void setStringByDataBase(String key, String str, int dataBase) {
        this.setString(key, str, 0, dataBase);
    }

    public boolean setString(String key, String str) {
        return this.setString(key, str, 0, database);
    }

    public boolean setString(String key, String str, int expire) {
        Jedis jedis = null;

        boolean var6;
        try {
            jedis = this.getJedis();
            jedis.select(database);
            jedis.set(key, str);
            if (expire > 0) {
                jedis.expire(key, expire);
            }

            return true;
        } catch (Exception var10) {
            logger.error("插入key为" + key + "的操作产生异常：", var10);
            var6 = false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var6;
    }

    public boolean setString(String key, String str, int expire, int dataBase) {
        Jedis jedis = null;

        boolean var7;
        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            jedis.set(key, str);
            if (expire > 0) {
                jedis.expire(key.getBytes(), expire);
            }

            return true;
        } catch (Exception var11) {
            logger.error("插入key为" + key + "的操作产生异常：", var11);
            var7 = false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var7;
    }

    public void setByDataBase(String key, Object object, int dataBase) {
        this.set(key, object, 0, dataBase);
    }

    public Set<String> keys(String pre) {
        return this.keys(pre, database);
    }

    public Set<String> keys(String pre, int dataBase) {
        Jedis jedis = null;
        Set re = null;

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            re = jedis.keys(pre);
        } catch (Exception var9) {
            logger.error("获取正则符合" + pre + "的所有redis键操作产生异常：", var9);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return re;
    }

    public boolean delete(String key) {
        return this.delete(key, database);
    }

    public boolean delete(String key, int dataBase) {
        Jedis jedis = null;

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            jedis.del(key.getBytes());
        } catch (Exception var8) {
            logger.error("删除key为" + key + "的操作产生异常：", var8);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return true;
    }

    public boolean deleteString(String key) {
        return this.deleteString(key, database);
    }

    public boolean deleteString(String key, int dataBase) {
        Jedis jedis = null;

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            jedis.del(key);
        } catch (Exception var8) {
            logger.error("删除key为" + key + "的操作产生异常：", var8);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return true;
    }

    public Long incr(String key) {
        return this.incr(key, database);
    }

    public Long incr(String key, int dataBase) {
        Jedis jedis = null;
        Long incr = null;

        Long var6;
        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            incr = jedis.incr(key.getBytes());
            return incr;
        } catch (Exception var10) {
            logger.error("执行key为" + key + "的自增长操作产生异常：", var10);
            var6 = new Long(0L);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var6;
    }


    public Long setnx(String key,int expire) {
        Jedis jedis = null;
        Long resultnx = null;

        Long var6;
        try {
            jedis = this.getJedis();
            jedis.select(database);
            resultnx = jedis.setnx(key.getBytes(),key.getBytes());
            logger.info("防重复提交结果"+resultnx);
            if(resultnx.equals(Long.parseLong("0"))){
                jedis.expire(key, expire);
            }
            return resultnx;
        } catch (Exception var10) {
            logger.error("执行key为" + key + "的自增长操作产生异常：", var10);
            var6 = new Long(0L);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }
        return var6;
    }

    public Long incrExpire(String key, int expire) {
        return this.incrExpirev1(key, database,expire);
    }

    public Long incrExpirev1(String key, int dataBase,int expire) {
        Jedis jedis = null;
        Long incr = null;

        Long var6;
        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            incr = jedis.incr(key.getBytes());
            if(incr==1){
                jedis.expire(key, expire);
            }
            return incr;
        } catch (Exception var10) {
            logger.error("执行key为" + key + "的自增长操作产生异常：", var10);
            var6 = new Long(0L);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var6;
    }

    public Long decr(String key) {
        return this.decr(key, database);
    }

    public Long decr(String key, int dataBase) {
        Jedis jedis = null;
        Long decr = null;

        Long var6;
        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            decr = jedis.decr(key.getBytes());
            return decr;
        } catch (Exception var10) {
            logger.error("执行key为" + key + "的自减操作产生异常：", var10);
            var6 = new Long(0L);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var6;
    }

    public Long setKeyExpireTime(String key, int expire) {
        return this.setKeyExpireTime(key, expire, database);
    }

    public Long setKeyExpireTime(String key, int expire, int dataBase) {
        Jedis jedis = null;
        Long result = null;

        Long var7;
        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            result = jedis.expire(key, expire);
            return result;
        } catch (Exception var11) {
            logger.error("设置key为" + key + "的expire操作产生异常：", var11);
            var7 = new Long(0L);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var7;
    }

    public Long getKeyExpireTime(String key) {
        return this.getKeyExpireTime(key, database);
    }

    public Long getKeyExpireTime(String key, int dataBase) {
        Jedis jedis = null;
        Long result = null;

        Long var6;
        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            result = jedis.ttl(key);
            return result;
        } catch (Exception var10) {
            logger.error("获取key为" + key + "的操作产生异常：", var10);
            var6 = new Long(0L);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var6;
    }

    public void hashcounter(String tableName, String key, int number) {
        this.hashcounter(tableName, key, number, number);
    }

    public void hashcounter(String tableName, String key, int number, int dataBase) {
        Jedis jedis = null;

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            jedis.hincrBy(tableName.getBytes(), key.getBytes(), (long)number);
        } catch (Exception var10) {
            logger.error(tableName + "哈希表计数操作产生异常：", var10);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

    }

    public void delLock(String key) {
        this.delete(key, database);
    }

    public void delLock(String key, int dataBase) {
        Jedis jedis = null;

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            long oldtime = Long.parseLong(jedis.get(key));
            long current = (new Date()).getTime();
            if (current < oldtime) {
                jedis.del(key);
            }
        } catch (Exception var11) {
            logger.error("key:" + key + " 释放同步锁异常：", var11);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

    }

    public int getLock(String key, long timeout) {
        return this.getLock(key, timeout, database);
    }

    public int getLock(String key, long timeout, int dataBase) {
        Jedis jedis = null;

        byte var12;
        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            long now = (new Date()).getTime();
            long timestamp = now + timeout;
            long lock = jedis.setnx(key, String.valueOf(timestamp));
            if (lock != 1L && (now <= Long.parseLong(jedis.get(key)) || now <= Long.parseLong(jedis.getSet(key, String.valueOf(timestamp))))) {
                var12 = 0;
                return var12;
            }

            var12 = 1;
        } catch (Exception var16) {
            logger.error("key:" + key + " 获得同步锁异常：", var16);
            return 0;
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var12;
    }

    public Set<String> hkeys(String tableName) {
        return this.hkeys(tableName, database);
    }

    public Set<String> hkeys(String tableName, int dataBase) {
        Jedis jedis = null;
        HashSet keys = new HashSet();

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            Set<byte[]> keysbytes = jedis.hkeys(tableName.getBytes());
            Iterator var6 = keysbytes.iterator();

            while(var6.hasNext()) {
                byte[] b = (byte[])var6.next();
                if (b.length != 0) {
                    keys.add(new String(b));
                }
            }
        } catch (Exception var11) {
            logger.error(tableName + "哈希表del操作产生异常", var11);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return keys;
    }

    public boolean exists(String key) {
        return this.exists(key, database);
    }

    public boolean exists(String key, int dataBase) {
        Jedis jedis = null;
        boolean flag = false;

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            flag = jedis.exists(key);
        } catch (Exception var9) {
            logger.error("判断key是否存在操作产生异常", var9);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return flag;
    }

    public Long incrBy(String key, long integer) {
        return this.incrBy(key, integer, database);
    }

    public Long incrBy(String key, long integer, int dataBase) {
        Jedis jedis = null;
        long result = 0L;

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            result = jedis.incrBy(key, integer);
            Long var8 = result;
            return var8;
        } catch (Exception var12) {
            logger.error("类型错误", var12);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return result;
    }

    public boolean sadd(String key, List<String> values) {
        return this.sadd(key, values, 0, database);
    }

    public boolean sadd(String key, List<String> values, int expire, int dataBase) {
        Jedis jedis = null;

        boolean var7;
        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            jedis.sadd(key, values.toArray(new String[values.size()]));
            if (expire > 0) {
                jedis.expire(key.getBytes(), expire);
            }

            return true;
        } catch (Exception var11) {
            logger.error("插入key为" + key + "的操作产生异常：", var11);
            var7 = false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var7;
    }

    public boolean sadd(String key, List<String> values, int expire) {
        Jedis jedis = null;

        boolean var6;
        try {
            jedis = this.getJedis();
            jedis.select(database);
            jedis.sadd(key, values.toArray(new String[values.size()]));
            if (expire > 0) {
                jedis.expire(key.getBytes(), expire);
            }

            return true;
        } catch (Exception var10) {
            logger.error("插入key为" + key + "的操作产生异常：", var10);
            var6 = false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var6;
    }

    public boolean sismember(String key, String field) {
        return this.sismember(key, field, database);
    }

    public boolean sismember(String key, String field, int dataBase) {
        Jedis jedis = null;
        boolean flag = false;

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            flag = jedis.sismember(key, field);
        } catch (Exception var9) {
            logger.error("判断key中是否存在"+field+"存在操作产生异常", var9);
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return flag;
    }

    public Set<String> smembers(String key) {
        return this.smembers(key, database);
    }

    public Set<String> smembers(String key, int dataBase) {
        Jedis jedis = null;
        Set<String> smembers = null;

        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            smembers = jedis.smembers(key);
        } catch (Exception var9) {
            logger.error("查询集合key为"+key+"的元素smembers产生异常", var9);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        return smembers;
    }


    public boolean srem(String key, List<String> values) {
        return this.srem(key, values, 0, database);
    }

    public boolean srem(String key, List<String> values, int expire, int dataBase) {
        Jedis jedis = null;

        boolean var7;
        try {
            jedis = this.getJedis();
            jedis.select(dataBase);
            jedis.srem(key, values.toArray(new String[values.size()]));
            if (expire > 0) {
                jedis.expire(key.getBytes(), expire);
            }

            return true;
        } catch (Exception var11) {
            logger.error("srem异常, key:{},values:{},exception:{}", key, values, var11);
            var7 = false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var7;
    }

    public boolean srem(String key, List<String> values, int expire) {
        Jedis jedis = null;

        boolean var6;
        try {
            jedis = this.getJedis();
            jedis.select(database);
            jedis.srem(key, values.toArray(new String[values.size()]));
            if (expire > 0) {
                jedis.expire(key.getBytes(), expire);
            }

            return true;
        } catch (Exception var10) {
            logger.error("srem异常, key:{},values:{},exception:{}", key, values, var10);
            var6 = false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

        return var6;
    }

}

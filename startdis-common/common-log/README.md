# 工程简介
基于AOP切面实现日志记录
# SQL脚本
```sql
DROP TABLE IF EXISTS t_system_log;
CREATE TABLE t_system_log(
                             id VARCHAR(32) NOT NULL   COMMENT '日志编号' ,
                             user_id VARCHAR(255)    COMMENT '用户ID' ,
                             user_name VARCHAR(255)    COMMENT '用户名称' ,
                             role_name VARCHAR(255)    COMMENT '角色名称' ,
                             system_module VARCHAR(255)    COMMENT '操作模块' ,
                             business_type VARCHAR(255)    COMMENT '业务类型' ,
                             business_no VARCHAR(255)    COMMENT '业务流水号' ,
                             request_url VARCHAR(255)    COMMENT '请求地址' ,
                             request_desc VARCHAR(255)    COMMENT '请求描述' ,
                             request_body LONGTEXT    COMMENT '请求报文' ,
                             request_ip VARCHAR(255)    COMMENT '请求IP' ,
                             request_type VARCHAR(255)    COMMENT '请求类型（POST、PUT、OPTIONS、DELETE）' ,
                             content_type VARCHAR(255)    COMMENT '请求报文类型（map、json）' ,
                             user_agent VARCHAR(255)    COMMENT '浏览器、操作系统、UI引擎标识' ,
                             request_time DATETIME   COMMENT '请求时间' ,
                             response_body LONGTEXT    COMMENT '响应报文' ,
                             response_time DATETIME   COMMENT '响应时间' ,
                             consum_time BIGINT    COMMENT '请求耗时' ,
                             error_info LONGTEXT    COMMENT '异常信息' ,
                             revision INTEGER(11)    COMMENT '乐观锁' ,
                             is_deleted INTEGER(1)    COMMENT '逻辑删除;0-未删除 1-已删除' ,
                             created_by VARCHAR(32)    COMMENT '创建人' ,
                             created_at DATETIME    COMMENT '创建时间' ,
                             updated_by VARCHAR(32)    COMMENT '更新人' ,
                             updated_at DATETIME    COMMENT '更新时间' ,
                             PRIMARY KEY (id)
)  COMMENT = '系统日志表';
```
# 延伸阅读
https://tech.meituan.com/2021/09/16/operational-logbook.html
http://mysql.taobao.org/monthly/2017/09/08/



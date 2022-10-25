```mysql
DROP TABLE IF EXISTS t_demo;
CREATE TABLE t_demo(
    id VARCHAR(32)    COMMENT 'ID' ,
    name VARCHAR(255)    COMMENT '用户名' ,
    email VARCHAR(255)    COMMENT '邮箱' ,
    revision INTEGER(11)    COMMENT '乐观锁' ,
    is_deleted INTEGER(1)    COMMENT '逻辑删除;0-未删除 1-已删除' ,
    created_by VARCHAR(32)    COMMENT '创建人' ,
    created_at DATETIME    COMMENT '创建时间' ,
    updated_by VARCHAR(32)    COMMENT '更新人' ,
    updated_at DATETIME    COMMENT '更新时间' 
)  COMMENT = '测试生成表';
```
DROP TABLE IF EXISTS sys_grade;
CREATE TABLE sys_grade(
                          id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
                          grade_code VARCHAR(64)    COMMENT '职系编码' ,
                          grade_name VARCHAR(128)    COMMENT '职系名称' ,
                          grade_remark VARCHAR(255)    COMMENT '职系描述' ,
                          grade_sort INT    COMMENT '显示顺序' ,
                          status INT    COMMENT '是否启用（0停用 1启用）' ,
                          deleted INT    COMMENT '是否删除（0正常 1删除）' ,
                          revision INT    COMMENT '乐观锁' ,
                          group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
                          company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
                          created_by VARCHAR(64)    COMMENT '创建人' ,
                          created_at DATETIME    COMMENT '创建时间' ,
                          updated_by VARCHAR(64)    COMMENT '更新人' ,
                          updated_at DATETIME    COMMENT '更新时间' ,
                          PRIMARY KEY (id)
)  COMMENT = '职系表';

DROP TABLE IF EXISTS sys_title;
CREATE TABLE sys_title(
                          id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
                          grade_id VARCHAR(19)    COMMENT '职系ID' ,
                          grade_code VARCHAR(64)    COMMENT '职系编码' ,
                          title_code VARCHAR(64)    COMMENT '职位编码' ,
                          title_name VARCHAR(128)    COMMENT '职位名称' ,
                          title_remark VARCHAR(255)    COMMENT '职位描述' ,
                          title_sort INT    COMMENT '显示顺序' ,
                          status INT    COMMENT '是否启用（0停用 1启用）' ,
                          deleted INT    COMMENT '是否删除（0正常 1删除）' ,
                          revision INT    COMMENT '乐观锁' ,
                          group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
                          company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
                          created_by VARCHAR(64)    COMMENT '创建人' ,
                          created_at DATETIME    COMMENT '创建时间' ,
                          updated_by VARCHAR(64)    COMMENT '更新人' ,
                          updated_at DATETIME    COMMENT '更新时间' ,
                          PRIMARY KEY (id)
)  COMMENT = '职位表';
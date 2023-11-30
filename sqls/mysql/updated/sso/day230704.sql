DROP TABLE IF EXISTS sso_oauth_code;
CREATE TABLE sso_oauth_code(
                               id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
                               auth_code VARCHAR(255)    COMMENT '授权码' ,
                               expires_at DATETIME    COMMENT '过期时间' ,
                               used INT    COMMENT '是否已用（0正常 1已用）' ,
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
)  COMMENT = '授权码表';

DROP TABLE IF EXISTS sso_access_token;
CREATE TABLE sso_access_token(
                                 id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
                                 app_key VARCHAR(255)    COMMENT '应用标识' ,
                                 app_secret VARCHAR(255)    COMMENT '应用密钥' ,
                                 access_token VARCHAR(255)    COMMENT '鉴权令牌' ,
                                 refresh_token VARCHAR(255)    COMMENT '刷新令牌' ,
                                 expires_at DATETIME    COMMENT '过期时间' ,
                                 token_type VARCHAR(64)    COMMENT '令牌类型（bearer mac）' ,
                                 token_scope VARCHAR(255)    COMMENT '权限范围' ,
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
)  COMMENT = '鉴权令牌表';

DROP TABLE IF EXISTS sso_refresh_token;
CREATE TABLE sso_refresh_token(
                                  id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
                                  app_key VARCHAR(64)    COMMENT '应用标识' ,
                                  app_secret VARCHAR(255)    COMMENT '应用密钥' ,
                                  access_token VARCHAR(255)    COMMENT '鉴权令牌' ,
                                  refresh_token VARCHAR(255)    COMMENT '刷新令牌' ,
                                  latest_refresh_token VARCHAR(255)    COMMENT '最新的刷新令牌' ,
                                  used INT    COMMENT '是否已用（0正常 1已用）' ,
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
)  COMMENT = '刷新令牌表';

DROP TABLE IF EXISTS sso_app_info;
CREATE TABLE sso_app_info(
                             id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
                             app_code VARCHAR(64)    COMMENT '应用编码（唯一标识）' ,
                             app_name VARCHAR(128)    COMMENT '应用名称' ,
                             app_key VARCHAR(255)    COMMENT '应用公匙（系统生成）' ,
                             app_secret VARCHAR(255)    COMMENT '应用私匙（系统生成）' ,
                             app_type INT    COMMENT '应用类型（1内部应用 2三方服务）' ,
                             app_domain VARCHAR(255)    COMMENT '应用域名' ,
                             resource_ids VARCHAR(255)    COMMENT '客户端所能访问的资源id集合，多个资源时用逗号(,)分隔' ,
                             grant_types VARCHAR(255)    COMMENT '授权许可类型(grant_type)，可选值包括authorization_code,password,refresh_token,implicit,client_credentials,若支持多个授权许可类型用逗号(,)分隔' ,
                             redirect_url VARCHAR(255)    COMMENT '重定向URI，当grant_type为authorization_code或implicit时, 在OAuth的流程中会使用并检查与数据库内的redirect_uri是否一致' ,
                             authorities VARCHAR(255)    COMMENT '所拥有的Spring Security的权限值,可选, 若有多个权限值,用逗号(,)分隔' ,
                             access_token_validity INT    COMMENT 'access_token的有效时间值(单位:秒)，若不设定值则使用默认的有效时间值(60 * 60 * 12, 12小时)' ,
                             refresh_token_validity INT    COMMENT 'refresh_token的有效时间值(单位:秒)，若不设定值则使用默认的有效时间值(60 * 60 * 24 * 30, 30天)' ,
                             verify_status INT    COMMENT '审核状态（0-审核中 1-已发布）' ,
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
)  COMMENT = '应用中心表';
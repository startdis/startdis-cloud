CREATE TABLE SYS_DEPT
(
    "id"               VARCHAR2(32) NOT NULL,
    "parent_id"        VARCHAR2(32),
    "dept_code"        VARCHAR2(64),
    "dept_name"        VARCHAR2(128),
    "leader_user_id"   VARCHAR2(32),
    "leader_user_name" VARCHAR2(128),
    "dept_sort"        INT,
    "phone"            VARCHAR2(255),
    "email"            VARCHAR2(255),
    "status"           INT,
    "deleted"          INT,
    "revision"         VARCHAR2(32),
    "tenant_id"        VARCHAR2(32),
    "created_by"       VARCHAR2(32),
    "created_at"       DATE,
    "updated_by"       VARCHAR2(32),
    "updated_at"       DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_DEPT IS '部门表';
COMMENT
ON COLUMN SYS_DEPT."id" IS 'ID';
COMMENT
ON COLUMN SYS_DEPT."parent_id" IS '父部门ID';
COMMENT
ON COLUMN SYS_DEPT."dept_code" IS '部门编码';
COMMENT
ON COLUMN SYS_DEPT."dept_name" IS '部门名称';
COMMENT
ON COLUMN SYS_DEPT."leader_user_id" IS '部门负责人ID';
COMMENT
ON COLUMN SYS_DEPT."leader_user_name" IS '部门负责人名称';
COMMENT
ON COLUMN SYS_DEPT."dept_sort" IS '显示顺序';
COMMENT
ON COLUMN SYS_DEPT."phone" IS '联系电话';
COMMENT
ON COLUMN SYS_DEPT."email" IS '联系邮箱';
COMMENT
ON COLUMN SYS_DEPT."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_DEPT."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_DEPT."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_DEPT."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_DEPT."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_DEPT."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_DEPT."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_DEPT."updated_at" IS '更新时间';

CREATE TABLE SYS_DICT_TYPE
(
    "id"          VARCHAR2(32) NOT NULL,
    "dict_code"   VARCHAR2(64),
    "dict_name"   VARCHAR2(128),
    "dict_type"   INT,
    "dict_remark" VARCHAR2(255),
    "status"      INT,
    "deleted"     INT,
    "revision"    VARCHAR2(32),
    "tenant_id"   VARCHAR2(32),
    "created_by"  VARCHAR2(32),
    "created_at"  DATE,
    "updated_by"  VARCHAR2(32),
    "updated_at"  DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_DICT_TYPE IS '字典类型表';
COMMENT
ON COLUMN SYS_DICT_TYPE."id" IS 'ID';
COMMENT
ON COLUMN SYS_DICT_TYPE."dict_code" IS '字典编码';
COMMENT
ON COLUMN SYS_DICT_TYPE."dict_name" IS '字典名称';
COMMENT
ON COLUMN SYS_DICT_TYPE."dict_type" IS '字典类型（0字符串 1数字）';
COMMENT
ON COLUMN SYS_DICT_TYPE."dict_remark" IS '字典描述';
COMMENT
ON COLUMN SYS_DICT_TYPE."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_DICT_TYPE."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_DICT_TYPE."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_DICT_TYPE."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_DICT_TYPE."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_DICT_TYPE."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_DICT_TYPE."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_DICT_TYPE."updated_at" IS '更新时间';

CREATE TABLE SYS_DICT_ITEM
(
    "id"          VARCHAR2(32) NOT NULL,
    "dict_code"   VARCHAR2(64),
    "item_value"  VARCHAR2(255),
    "item_label"  VARCHAR2(255),
    "item_remark" VARCHAR2(255),
    "item_sort"   INT,
    "item_style"  VARCHAR2(255),
    "item_css"    CLOB,
    "status"      INT,
    "deleted"     INT,
    "revision"    VARCHAR2(32),
    "tenant_id"   VARCHAR2(32),
    "created_by"  VARCHAR2(32),
    "created_at"  DATE,
    "updated_by"  VARCHAR2(32),
    "updated_at"  DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_DICT_ITEM IS '字典数据表';
COMMENT
ON COLUMN SYS_DICT_ITEM."id" IS 'ID';
COMMENT
ON COLUMN SYS_DICT_ITEM."dict_code" IS '字典编码';
COMMENT
ON COLUMN SYS_DICT_ITEM."item_value" IS '字典项值';
COMMENT
ON COLUMN SYS_DICT_ITEM."item_label" IS '字典项标签';
COMMENT
ON COLUMN SYS_DICT_ITEM."item_remark" IS '字典项描述';
COMMENT
ON COLUMN SYS_DICT_ITEM."item_sort" IS '字典项排序';
COMMENT
ON COLUMN SYS_DICT_ITEM."item_style" IS '字典项样式';
COMMENT
ON COLUMN SYS_DICT_ITEM."item_css" IS '字典项CSS';
COMMENT
ON COLUMN SYS_DICT_ITEM."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_DICT_ITEM."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_DICT_ITEM."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_DICT_ITEM."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_DICT_ITEM."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_DICT_ITEM."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_DICT_ITEM."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_DICT_ITEM."updated_at" IS '更新时间';

CREATE TABLE SYS_ERROR_CODE
(
    "id"               VARCHAR2(32) NOT NULL,
    "application_id"   VARCHAR2(255),
    "application_name" VARCHAR2(128),
    "error_type"       VARCHAR2(255),
    "error_code"       VARCHAR2(255),
    "error_message"    VARCHAR2(255),
    "error_remark"     VARCHAR2(255),
    "status"           INT,
    "deleted"          INT,
    "revision"         VARCHAR2(32),
    "tenant_id"        VARCHAR2(32),
    "created_by"       VARCHAR2(32),
    "created_at"       DATE,
    "updated_by"       VARCHAR2(32),
    "updated_at"       DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_ERROR_CODE IS '错误码表';
COMMENT
ON COLUMN SYS_ERROR_CODE."id" IS 'ID';
COMMENT
ON COLUMN SYS_ERROR_CODE."application_id" IS '应用ID';
COMMENT
ON COLUMN SYS_ERROR_CODE."application_name" IS '应用名称';
COMMENT
ON COLUMN SYS_ERROR_CODE."error_type" IS '错误码类型';
COMMENT
ON COLUMN SYS_ERROR_CODE."error_code" IS '错误码编码';
COMMENT
ON COLUMN SYS_ERROR_CODE."error_message" IS '错误码提示';
COMMENT
ON COLUMN SYS_ERROR_CODE."error_remark" IS '错误码描述';
COMMENT
ON COLUMN SYS_ERROR_CODE."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_ERROR_CODE."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_ERROR_CODE."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_ERROR_CODE."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_ERROR_CODE."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_ERROR_CODE."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_ERROR_CODE."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_ERROR_CODE."updated_at" IS '更新时间';

CREATE TABLE SYS_LOGIN_LOG
(
    "id"           VARCHAR2(32) NOT NULL,
    "trace_id"     VARCHAR2(255),
    "user_id"      VARCHAR2(255),
    "user_type"    VARCHAR2(255),
    "user_name"    VARCHAR2(128),
    "user_ip"      VARCHAR2(255),
    "user_agent"   VARCHAR2(255),
    "login_result" VARCHAR2(255),
    "log_type"     VARCHAR2(255),
    "log_request"  CLOB,
    "log_response" CLOB,
    "status"       INT,
    "deleted"      INT,
    "revision"     VARCHAR2(32),
    "tenant_id"    VARCHAR2(32),
    "created_by"   VARCHAR2(32),
    "created_at"   DATE,
    "updated_by"   VARCHAR2(32),
    "updated_at"   DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_LOGIN_LOG IS '系统登录日志';
COMMENT
ON COLUMN SYS_LOGIN_LOG."id" IS 'ID';
COMMENT
ON COLUMN SYS_LOGIN_LOG."trace_id" IS '链路追踪编号';
COMMENT
ON COLUMN SYS_LOGIN_LOG."user_id" IS '用户编号';
COMMENT
ON COLUMN SYS_LOGIN_LOG."user_type" IS '用户类型';
COMMENT
ON COLUMN SYS_LOGIN_LOG."user_name" IS '用户名称';
COMMENT
ON COLUMN SYS_LOGIN_LOG."user_ip" IS '用户 IP';
COMMENT
ON COLUMN SYS_LOGIN_LOG."user_agent" IS '浏览器 UA';
COMMENT
ON COLUMN SYS_LOGIN_LOG."login_result" IS '登陆结果';
COMMENT
ON COLUMN SYS_LOGIN_LOG."log_type" IS '日志类型';
COMMENT
ON COLUMN SYS_LOGIN_LOG."log_request" IS '请求日志';
COMMENT
ON COLUMN SYS_LOGIN_LOG."log_response" IS '响应日志';
COMMENT
ON COLUMN SYS_LOGIN_LOG."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_LOGIN_LOG."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_LOGIN_LOG."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_LOGIN_LOG."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_LOGIN_LOG."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_LOGIN_LOG."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_LOGIN_LOG."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_LOGIN_LOG."updated_at" IS '更新时间';

CREATE TABLE SYS_MENU
(
    "id"              VARCHAR2(32) NOT NULL,
    "parent_id"       VARCHAR2(255),
    "menu_code"       VARCHAR2(64),
    "menu_name"       VARCHAR2(128),
    "menu_type"       VARCHAR2(255),
    "menu_path"       VARCHAR2(255),
    "menu_icon"       VARCHAR2(255),
    "menu_component"  VARCHAR2(255),
    "menu_sort"       INT,
    "menu_permission" VARCHAR2(255),
    "keep_alive"      INT,
    "visible"         INT,
    "status"          INT,
    "deleted"         INT,
    "revision"        VARCHAR2(32),
    "tenant_id"       VARCHAR2(32),
    "created_by"      VARCHAR2(32),
    "created_at"      DATE,
    "updated_by"      VARCHAR2(32),
    "updated_at"      DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_MENU IS '菜单表';
COMMENT
ON COLUMN SYS_MENU."id" IS 'ID';
COMMENT
ON COLUMN SYS_MENU."parent_id" IS '父菜单ID';
COMMENT
ON COLUMN SYS_MENU."menu_code" IS '菜单编码';
COMMENT
ON COLUMN SYS_MENU."menu_name" IS '菜单名称';
COMMENT
ON COLUMN SYS_MENU."menu_type" IS '菜单类型';
COMMENT
ON COLUMN SYS_MENU."menu_path" IS '路由地址';
COMMENT
ON COLUMN SYS_MENU."menu_icon" IS '菜单图标';
COMMENT
ON COLUMN SYS_MENU."menu_component" IS '组件路径';
COMMENT
ON COLUMN SYS_MENU."menu_sort" IS '显示顺序';
COMMENT
ON COLUMN SYS_MENU."menu_permission" IS '权限标识';
COMMENT
ON COLUMN SYS_MENU."keep_alive" IS '是否缓存（0不缓存 1缓存）';
COMMENT
ON COLUMN SYS_MENU."visible" IS '是否可见（0正常 1隐藏）';
COMMENT
ON COLUMN SYS_MENU."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_MENU."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_MENU."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_MENU."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_MENU."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_MENU."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_MENU."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_MENU."updated_at" IS '更新时间';

CREATE TABLE SYS_OPERATE_LOG
(
    "id"              VARCHAR2(32) NOT NULL,
    "trace_id"        VARCHAR2(32),
    "user_id"         VARCHAR2(32),
    "user_type"       VARCHAR2(255),
    "user_ip"         VARCHAR2(255),
    "user_agent"      VARCHAR2(255),
    "system_module"   VARCHAR2(255),
    "operate_name"    VARCHAR2(128),
    "operate_type"    VARCHAR2(255),
    "operate_content" VARCHAR2(255),
    "operate_at"      DATE,
    "cost_time"       VARCHAR2(255),
    "operate_exts"    VARCHAR2(255),
    "request_method"  VARCHAR2(255),
    "request_url"     VARCHAR2(255),
    "request_body"    CLOB,
    "response_code"   VARCHAR2(255),
    "response_msg"    VARCHAR2(255),
    "response_data"   CLOB,
    "status"          INT,
    "deleted"         INT,
    "revision"        VARCHAR2(32),
    "tenant_id"       VARCHAR2(32),
    "created_by"      VARCHAR2(32),
    "created_at"      DATE,
    "updated_by"      VARCHAR2(32),
    "updated_at"      DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_OPERATE_LOG IS '操作日志记录表';
COMMENT
ON COLUMN SYS_OPERATE_LOG."id" IS 'ID';
COMMENT
ON COLUMN SYS_OPERATE_LOG."trace_id" IS '链路追踪ID';
COMMENT
ON COLUMN SYS_OPERATE_LOG."user_id" IS '用户ID';
COMMENT
ON COLUMN SYS_OPERATE_LOG."user_type" IS '用户类型';
COMMENT
ON COLUMN SYS_OPERATE_LOG."user_ip" IS '用户 IP';
COMMENT
ON COLUMN SYS_OPERATE_LOG."user_agent" IS '浏览器 UA';
COMMENT
ON COLUMN SYS_OPERATE_LOG."system_module" IS '系统模块';
COMMENT
ON COLUMN SYS_OPERATE_LOG."operate_name" IS '操作名称';
COMMENT
ON COLUMN SYS_OPERATE_LOG."operate_type" IS '操作分类';
COMMENT
ON COLUMN SYS_OPERATE_LOG."operate_content" IS '操作内容';
COMMENT
ON COLUMN SYS_OPERATE_LOG."operate_at" IS '操作时间';
COMMENT
ON COLUMN SYS_OPERATE_LOG."cost_time" IS '请求耗时';
COMMENT
ON COLUMN SYS_OPERATE_LOG."operate_exts" IS '拓展字段';
COMMENT
ON COLUMN SYS_OPERATE_LOG."request_method" IS '请求方法名';
COMMENT
ON COLUMN SYS_OPERATE_LOG."request_url" IS '请求地址';
COMMENT
ON COLUMN SYS_OPERATE_LOG."request_body" IS '请求入参';
COMMENT
ON COLUMN SYS_OPERATE_LOG."response_code" IS '响应状态码';
COMMENT
ON COLUMN SYS_OPERATE_LOG."response_msg" IS '响应提示语';
COMMENT
ON COLUMN SYS_OPERATE_LOG."response_data" IS '响应出参';
COMMENT
ON COLUMN SYS_OPERATE_LOG."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_OPERATE_LOG."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_OPERATE_LOG."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_OPERATE_LOG."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_OPERATE_LOG."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_OPERATE_LOG."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_OPERATE_LOG."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_OPERATE_LOG."updated_at" IS '更新时间';

CREATE TABLE SYS_POST
(
    "id"          VARCHAR2(32) NOT NULL,
    "post_code"   VARCHAR2(64),
    "post_name"   VARCHAR2(128),
    "post_remark" VARCHAR2(255),
    "post_sort"   INT,
    "status"      INT,
    "deleted"     INT,
    "revision"    VARCHAR2(32),
    "tenant_id"   VARCHAR2(32),
    "created_by"  VARCHAR2(32),
    "created_at"  DATE,
    "updated_by"  VARCHAR2(32),
    "updated_at"  DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_POST IS '岗位表';
COMMENT
ON COLUMN SYS_POST."id" IS 'ID';
COMMENT
ON COLUMN SYS_POST."post_code" IS '岗位编码';
COMMENT
ON COLUMN SYS_POST."post_name" IS '岗位名称';
COMMENT
ON COLUMN SYS_POST."post_remark" IS '岗位描述';
COMMENT
ON COLUMN SYS_POST."post_sort" IS '显示顺序';
COMMENT
ON COLUMN SYS_POST."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_POST."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_POST."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_POST."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_POST."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_POST."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_POST."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_POST."updated_at" IS '更新时间';

CREATE TABLE SYS_ROLE
(
    "id"          VARCHAR2(32) NOT NULL,
    "role_code"   VARCHAR2(64),
    "role_name"   VARCHAR2(128),
    "role_remark" VARCHAR2(255),
    "role_type"   VARCHAR2(255),
    "role_sort"   INT,
    "role_scope"  INT,
    "status"      INT,
    "deleted"     INT,
    "revision"    VARCHAR2(32),
    "tenant_id"   VARCHAR2(32),
    "created_by"  VARCHAR2(32),
    "created_at"  DATE,
    "updated_by"  VARCHAR2(32),
    "updated_at"  DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_ROLE IS '角色表';
COMMENT
ON COLUMN SYS_ROLE."id" IS 'ID';
COMMENT
ON COLUMN SYS_ROLE."role_code" IS '角色代码';
COMMENT
ON COLUMN SYS_ROLE."role_name" IS '角色名称';
COMMENT
ON COLUMN SYS_ROLE."role_remark" IS '角色描述';
COMMENT
ON COLUMN SYS_ROLE."role_type" IS '角色类型';
COMMENT
ON COLUMN SYS_ROLE."role_sort" IS '显示顺序';
COMMENT
ON COLUMN SYS_ROLE."role_scope" IS '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）';
COMMENT
ON COLUMN SYS_ROLE."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_ROLE."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_ROLE."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_ROLE."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_ROLE."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_ROLE."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_ROLE."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_ROLE."updated_at" IS '更新时间';

CREATE TABLE SYS_ROLE_MENU
(
    "id"         VARCHAR2(32) NOT NULL,
    "role_id"    VARCHAR2(255),
    "menu_id"    VARCHAR2(255),
    "status"     INT,
    "deleted"    INT,
    "revision"   VARCHAR2(32),
    "tenant_id"  VARCHAR2(32),
    "created_by" VARCHAR2(32),
    "created_at" DATE,
    "updated_by" VARCHAR2(32),
    "updated_at" DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_ROLE_MENU IS '角色菜单中间表';
COMMENT
ON COLUMN SYS_ROLE_MENU."id" IS 'ID';
COMMENT
ON COLUMN SYS_ROLE_MENU."role_id" IS '角色ID';
COMMENT
ON COLUMN SYS_ROLE_MENU."menu_id" IS '菜单ID';
COMMENT
ON COLUMN SYS_ROLE_MENU."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_ROLE_MENU."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_ROLE_MENU."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_ROLE_MENU."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_ROLE_MENU."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_ROLE_MENU."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_ROLE_MENU."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_ROLE_MENU."updated_at" IS '更新时间';

CREATE TABLE SYS_USER_ROLE
(
    "id"         VARCHAR2(32) NOT NULL,
    "user_id"    VARCHAR2(255),
    "role_id"    VARCHAR2(255),
    "status"     INT,
    "deleted"    INT,
    "revision"   VARCHAR2(32),
    "tenant_id"  VARCHAR2(32),
    "created_by" VARCHAR2(32),
    "created_at" DATE,
    "updated_by" VARCHAR2(32),
    "updated_at" DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_USER_ROLE IS '用户角色中间表';
COMMENT
ON COLUMN SYS_USER_ROLE."id" IS 'ID';
COMMENT
ON COLUMN SYS_USER_ROLE."user_id" IS '用户ID';
COMMENT
ON COLUMN SYS_USER_ROLE."role_id" IS '角色ID';
COMMENT
ON COLUMN SYS_USER_ROLE."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_USER_ROLE."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_USER_ROLE."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_USER_ROLE."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_USER_ROLE."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_USER_ROLE."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_USER_ROLE."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_USER_ROLE."updated_at" IS '更新时间';

CREATE TABLE SYS_SENSITIVE_WORD
(
    "id"          VARCHAR2(32) NOT NULL,
    "word_name"   VARCHAR2(255),
    "word_tags"   VARCHAR2(255),
    "word_remark" VARCHAR2(255),
    "status"      INT,
    "deleted"     INT,
    "revision"    VARCHAR2(32),
    "tenant_id"   VARCHAR2(32),
    "created_by"  VARCHAR2(32),
    "created_at"  DATE,
    "updated_by"  VARCHAR2(32),
    "updated_at"  DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_SENSITIVE_WORD IS '系统敏感词表';
COMMENT
ON COLUMN SYS_SENSITIVE_WORD."id" IS 'ID';
COMMENT
ON COLUMN SYS_SENSITIVE_WORD."word_name" IS '敏感词';
COMMENT
ON COLUMN SYS_SENSITIVE_WORD."word_tags" IS '敏感词标签';
COMMENT
ON COLUMN SYS_SENSITIVE_WORD."word_remark" IS '敏感词描述';
COMMENT
ON COLUMN SYS_SENSITIVE_WORD."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_SENSITIVE_WORD."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_SENSITIVE_WORD."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_SENSITIVE_WORD."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_SENSITIVE_WORD."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_SENSITIVE_WORD."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_SENSITIVE_WORD."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_SENSITIVE_WORD."updated_at" IS '更新时间';

CREATE TABLE SYS_SOCIAL_USER
(
    "id"             VARCHAR2(32) NOT NULL,
    "social_type"    INT,
    "social_open_id" VARCHAR2(255),
    "social_token"   VARCHAR2(255),
    "raw_token_info" VARCHAR2(255),
    "raw_user_info"  VARCHAR2(255),
    "nick_name"      VARCHAR2(128),
    "user_avatar"    VARCHAR2(255),
    "social_code"    VARCHAR2(255),
    "social_state"   VARCHAR2(255),
    "status"         INT,
    "deleted"        INT,
    "revision"       VARCHAR2(32),
    "tenant_id"      VARCHAR2(32),
    "created_by"     VARCHAR2(32),
    "created_at"     DATE,
    "updated_by"     VARCHAR2(32),
    "updated_at"     DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_SOCIAL_USER IS '社交用户表';
COMMENT
ON COLUMN SYS_SOCIAL_USER."id" IS 'ID';
COMMENT
ON COLUMN SYS_SOCIAL_USER."social_type" IS '社交平台的类型';
COMMENT
ON COLUMN SYS_SOCIAL_USER."social_open_id" IS '社交 openid';
COMMENT
ON COLUMN SYS_SOCIAL_USER."social_token" IS '社交 token';
COMMENT
ON COLUMN SYS_SOCIAL_USER."raw_token_info" IS '原始 Token 数据，一般是 JSON 格式';
COMMENT
ON COLUMN SYS_SOCIAL_USER."raw_user_info" IS '原始用户数据，一般是 JSON 格式';
COMMENT
ON COLUMN SYS_SOCIAL_USER."nick_name" IS '用户昵称';
COMMENT
ON COLUMN SYS_SOCIAL_USER."user_avatar" IS '用户头像';
COMMENT
ON COLUMN SYS_SOCIAL_USER."social_code" IS '最后一次的认证 code';
COMMENT
ON COLUMN SYS_SOCIAL_USER."social_state" IS '最后一次的认证 state';
COMMENT
ON COLUMN SYS_SOCIAL_USER."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_SOCIAL_USER."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_SOCIAL_USER."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_SOCIAL_USER."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_SOCIAL_USER."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_SOCIAL_USER."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_SOCIAL_USER."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_SOCIAL_USER."updated_at" IS '更新时间';

CREATE TABLE SYS_SOCIAL_USER_BIND
(
    "id"             VARCHAR2(32) NOT NULL,
    "user_id"        VARCHAR2(255),
    "user_type"      VARCHAR2(255),
    "social_user_id" VARCHAR2(255),
    "social_type"    VARCHAR2(255),
    "status"         INT,
    "deleted"        INT,
    "revision"       VARCHAR2(32),
    "tenant_id"      VARCHAR2(32),
    "created_by"     VARCHAR2(32),
    "created_at"     DATE,
    "updated_by"     VARCHAR2(32),
    "updated_at"     DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_SOCIAL_USER_BIND IS '社交用户绑定表';
COMMENT
ON COLUMN SYS_SOCIAL_USER_BIND."id" IS 'ID';
COMMENT
ON COLUMN SYS_SOCIAL_USER_BIND."user_id" IS '系统用户ID';
COMMENT
ON COLUMN SYS_SOCIAL_USER_BIND."user_type" IS '用户类型';
COMMENT
ON COLUMN SYS_SOCIAL_USER_BIND."social_user_id" IS '社交用户ID';
COMMENT
ON COLUMN SYS_SOCIAL_USER_BIND."social_type" IS '社交平台的类型';
COMMENT
ON COLUMN SYS_SOCIAL_USER_BIND."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_SOCIAL_USER_BIND."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_SOCIAL_USER_BIND."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_SOCIAL_USER_BIND."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_SOCIAL_USER_BIND."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_SOCIAL_USER_BIND."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_SOCIAL_USER_BIND."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_SOCIAL_USER_BIND."updated_at" IS '更新时间';

CREATE TABLE SYS_TENANT
(
    "id"              VARCHAR2(32) NOT NULL,
    "tenant_code"     VARCHAR2(64),
    "tenant_name"     VARCHAR2(128),
    "contact_user_id" VARCHAR2(255),
    "contact_name"    VARCHAR2(128),
    "contact_phone"   VARCHAR2(255),
    "tenant_domain"   VARCHAR2(255),
    "package_id"      VARCHAR2(255),
    "expire_at"       VARCHAR2(255),
    "account_count"   VARCHAR2(255),
    "status"          INT,
    "deleted"         INT,
    "revision"        VARCHAR2(32),
    "tenant_id"       VARCHAR2(32),
    "created_by"      VARCHAR2(32),
    "created_at"      DATE,
    "updated_by"      VARCHAR2(32),
    "updated_at"      DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_TENANT IS '租户表';
COMMENT
ON COLUMN SYS_TENANT."id" IS 'ID';
COMMENT
ON COLUMN SYS_TENANT."tenant_code" IS '租户编码';
COMMENT
ON COLUMN SYS_TENANT."tenant_name" IS '租户名';
COMMENT
ON COLUMN SYS_TENANT."contact_user_id" IS '联系人的用户ID';
COMMENT
ON COLUMN SYS_TENANT."contact_name" IS '联系人';
COMMENT
ON COLUMN SYS_TENANT."contact_phone" IS '联系手机';
COMMENT
ON COLUMN SYS_TENANT."tenant_domain" IS '绑定域名';
COMMENT
ON COLUMN SYS_TENANT."package_id" IS '租户套餐编号';
COMMENT
ON COLUMN SYS_TENANT."expire_at" IS '过期时间';
COMMENT
ON COLUMN SYS_TENANT."account_count" IS '账号数量';
COMMENT
ON COLUMN SYS_TENANT."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_TENANT."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_TENANT."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_TENANT."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_TENANT."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_TENANT."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_TENANT."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_TENANT."updated_at" IS '更新时间';

CREATE TABLE SYS_PACKAGE
(
    "id"             VARCHAR2(32) NOT NULL,
    "package_code"   VARCHAR2(64),
    "package_name"   VARCHAR2(128),
    "package_remark" VARCHAR2(255),
    "package_exes"   DECIMAL(24, 6),
    "status"         INT,
    "deleted"        INT,
    "revision"       VARCHAR2(32),
    "tenant_id"      VARCHAR2(32),
    "created_by"     VARCHAR2(32),
    "created_at"     DATE,
    "updated_by"     VARCHAR2(32),
    "updated_at"     DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_PACKAGE IS '套餐表';
COMMENT
ON COLUMN SYS_PACKAGE."id" IS 'ID';
COMMENT
ON COLUMN SYS_PACKAGE."package_code" IS '套餐代码';
COMMENT
ON COLUMN SYS_PACKAGE."package_name" IS '套餐名称';
COMMENT
ON COLUMN SYS_PACKAGE."package_remark" IS '套餐描述';
COMMENT
ON COLUMN SYS_PACKAGE."package_exes" IS '套餐费用';
COMMENT
ON COLUMN SYS_PACKAGE."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_PACKAGE."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_PACKAGE."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_PACKAGE."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_PACKAGE."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_PACKAGE."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_PACKAGE."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_PACKAGE."updated_at" IS '更新时间';

CREATE TABLE SYS_USER_POST
(
    "id"         VARCHAR2(32) NOT NULL,
    "user_id"    VARCHAR2(32),
    "post_id"    VARCHAR2(32),
    "status"     INT,
    "deleted"    INT,
    "revision"   VARCHAR2(32),
    "tenant_id"  VARCHAR2(32),
    "created_by" VARCHAR2(32),
    "created_at" DATE,
    "updated_by" VARCHAR2(32),
    "updated_at" DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_USER_POST IS '用户岗位表';
COMMENT
ON COLUMN SYS_USER_POST."id" IS 'ID';
COMMENT
ON COLUMN SYS_USER_POST."user_id" IS '用户ID';
COMMENT
ON COLUMN SYS_USER_POST."post_id" IS '岗位ID';
COMMENT
ON COLUMN SYS_USER_POST."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_USER_POST."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_USER_POST."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_USER_POST."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_USER_POST."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_USER_POST."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_USER_POST."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_USER_POST."updated_at" IS '更新时间';

CREATE TABLE SYS_USERS
(
    "id"          VARCHAR2(32) NOT NULL,
    "user_code"   VARCHAR2(64),
    "user_name"   VARCHAR2(128),
    "nick_name"   VARCHAR2(128),
    "user_remark" VARCHAR2(255),
    "password"    VARCHAR2(255),
    "email"       VARCHAR2(255),
    "phone"       VARCHAR2(255),
    "sex"         INT,
    "avatar"      VARCHAR2(255),
    "login_ip"    VARCHAR2(255),
    "login_date"  DATE,
    "status"      INT,
    "deleted"     INT,
    "revision"    VARCHAR2(32),
    "tenant_id"   VARCHAR2(32),
    "created_by"  VARCHAR2(128),
    "created_at"  DATE,
    "updated_by"  VARCHAR2(128),
    "updated_at"  DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_USERS IS '用户表';
COMMENT
ON COLUMN SYS_USERS."id" IS 'ID';
COMMENT
ON COLUMN SYS_USERS."user_code" IS '用户编码';
COMMENT
ON COLUMN SYS_USERS."user_name" IS '用户名称';
COMMENT
ON COLUMN SYS_USERS."nick_name" IS '用户昵称';
COMMENT
ON COLUMN SYS_USERS."user_remark" IS '用户描述';
COMMENT
ON COLUMN SYS_USERS."password" IS '登录密码';
COMMENT
ON COLUMN SYS_USERS."email" IS '用户邮箱';
COMMENT
ON COLUMN SYS_USERS."phone" IS '手机号码';
COMMENT
ON COLUMN SYS_USERS."sex" IS '用户性别（0女性 1男性）';
COMMENT
ON COLUMN SYS_USERS."avatar" IS '头像地址';
COMMENT
ON COLUMN SYS_USERS."login_ip" IS '最后登录IP';
COMMENT
ON COLUMN SYS_USERS."login_date" IS '最后登录时间';
COMMENT
ON COLUMN SYS_USERS."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_USERS."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_USERS."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_USERS."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_USERS."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_USERS."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_USERS."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_USERS."updated_at" IS '更新时间';

CREATE TABLE SYS_COMPANY
(
    "id"               VARCHAR2(32) NOT NULL,
    "parent_id"        VARCHAR2(32),
    "company_code"     VARCHAR2(64),
    "company_name"     VARCHAR2(128),
    "leader_user_id"   VARCHAR2(32),
    "leader_user_name" VARCHAR2(128),
    "company_sort"     INT,
    "phone"            VARCHAR2(255),
    "email"            VARCHAR2(255),
    "status"           INT,
    "deleted"          INT,
    "revision"         VARCHAR2(32),
    "tenant_id"        VARCHAR2(32),
    "created_by"       VARCHAR2(32),
    "created_at"       DATE,
    "updated_by"       VARCHAR2(32),
    "updated_at"       DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_COMPANY IS '公司表';
COMMENT
ON COLUMN SYS_COMPANY."id" IS 'ID';
COMMENT
ON COLUMN SYS_COMPANY."parent_id" IS '父公司ID';
COMMENT
ON COLUMN SYS_COMPANY."company_code" IS '公司编码';
COMMENT
ON COLUMN SYS_COMPANY."company_name" IS '公司名称';
COMMENT
ON COLUMN SYS_COMPANY."leader_user_id" IS '公司负责人ID';
COMMENT
ON COLUMN SYS_COMPANY."leader_user_name" IS '公司负责人名称';
COMMENT
ON COLUMN SYS_COMPANY."company_sort" IS '显示顺序';
COMMENT
ON COLUMN SYS_COMPANY."phone" IS '联系电话';
COMMENT
ON COLUMN SYS_COMPANY."email" IS '联系邮箱';
COMMENT
ON COLUMN SYS_COMPANY."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_COMPANY."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_COMPANY."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_COMPANY."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_COMPANY."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_COMPANY."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_COMPANY."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_COMPANY."updated_at" IS '更新时间';

CREATE TABLE SYS_COMPANY_DEPT
(
    "id"         VARCHAR2(32) NOT NULL,
    "company_id" VARCHAR2(32),
    "dept_id"    VARCHAR2(32),
    "status"     INT,
    "deleted"    INT,
    "revision"   VARCHAR2(32),
    "tenant_id"  VARCHAR2(32),
    "created_by" VARCHAR2(32),
    "created_at" DATE,
    "updated_by" VARCHAR2(32),
    "updated_at" DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_COMPANY_DEPT IS '公司部门表';
COMMENT
ON COLUMN SYS_COMPANY_DEPT."id" IS 'ID';
COMMENT
ON COLUMN SYS_COMPANY_DEPT."company_id" IS '公司ID';
COMMENT
ON COLUMN SYS_COMPANY_DEPT."dept_id" IS '部门ID';
COMMENT
ON COLUMN SYS_COMPANY_DEPT."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_COMPANY_DEPT."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_COMPANY_DEPT."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_COMPANY_DEPT."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_COMPANY_DEPT."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_COMPANY_DEPT."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_COMPANY_DEPT."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_COMPANY_DEPT."updated_at" IS '更新时间';

CREATE TABLE SYS_COMPANY_POST
(
    "id"         VARCHAR2(32) NOT NULL,
    "company_id" VARCHAR2(32),
    "post_id"    VARCHAR2(32),
    "status"     INT,
    "deleted"    INT,
    "revision"   VARCHAR2(32),
    "tenant_id"  VARCHAR2(32),
    "created_by" VARCHAR2(32),
    "created_at" DATE,
    "updated_by" VARCHAR2(32),
    "updated_at" DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_COMPANY_POST IS '公司岗位表';
COMMENT
ON COLUMN SYS_COMPANY_POST."id" IS 'ID';
COMMENT
ON COLUMN SYS_COMPANY_POST."company_id" IS '公司ID';
COMMENT
ON COLUMN SYS_COMPANY_POST."post_id" IS '岗位ID';
COMMENT
ON COLUMN SYS_COMPANY_POST."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_COMPANY_POST."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_COMPANY_POST."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_COMPANY_POST."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_COMPANY_POST."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_COMPANY_POST."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_COMPANY_POST."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_COMPANY_POST."updated_at" IS '更新时间';

CREATE TABLE SYS_DEPT_POST
(
    "id"         VARCHAR2(32) NOT NULL,
    "dept_id"    VARCHAR2(32),
    "post_id"    VARCHAR2(32),
    "status"     INT,
    "deleted"    INT,
    "revision"   VARCHAR2(32),
    "tenant_id"  VARCHAR2(32),
    "created_by" VARCHAR2(32),
    "created_at" DATE,
    "updated_by" VARCHAR2(32),
    "updated_at" DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_DEPT_POST IS '部门岗位表';
COMMENT
ON COLUMN SYS_DEPT_POST."id" IS 'ID';
COMMENT
ON COLUMN SYS_DEPT_POST."dept_id" IS '部门ID';
COMMENT
ON COLUMN SYS_DEPT_POST."post_id" IS '岗位ID';
COMMENT
ON COLUMN SYS_DEPT_POST."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_DEPT_POST."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_DEPT_POST."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_DEPT_POST."tenant_id" IS '租户号';
COMMENT
ON COLUMN SYS_DEPT_POST."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_DEPT_POST."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_DEPT_POST."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_DEPT_POST."updated_at" IS '更新时间';

CREATE TABLE SYS_TENANT_PACKAGE
(
    "id"         VARCHAR2(32) NOT NULL,
    "tenant_id"  VARCHAR2(32),
    "package_id" VARCHAR2(32),
    "status"     INT,
    "deleted"    INT,
    "revision"   VARCHAR2(32),
    "created_by" VARCHAR2(32),
    "created_at" DATE,
    "updated_by" VARCHAR2(32),
    "updated_at" DATE,
    PRIMARY KEY (ID)
);

COMMENT
ON TABLE SYS_TENANT_PACKAGE IS '租户套餐表';
COMMENT
ON COLUMN SYS_TENANT_PACKAGE."id" IS 'ID';
COMMENT
ON COLUMN SYS_TENANT_PACKAGE."tenant_id" IS '租户ID';
COMMENT
ON COLUMN SYS_TENANT_PACKAGE."package_id" IS '套餐ID';
COMMENT
ON COLUMN SYS_TENANT_PACKAGE."status" IS '数据状态（0正常 1停用）';
COMMENT
ON COLUMN SYS_TENANT_PACKAGE."deleted" IS '是否删除（0正常 1删除）';
COMMENT
ON COLUMN SYS_TENANT_PACKAGE."revision" IS '乐观锁';
COMMENT
ON COLUMN SYS_TENANT_PACKAGE."created_by" IS '创建人';
COMMENT
ON COLUMN SYS_TENANT_PACKAGE."created_at" IS '创建时间';
COMMENT
ON COLUMN SYS_TENANT_PACKAGE."updated_by" IS '更新人';
COMMENT
ON COLUMN SYS_TENANT_PACKAGE."updated_at" IS '更新时间';
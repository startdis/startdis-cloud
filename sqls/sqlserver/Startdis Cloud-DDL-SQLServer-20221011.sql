IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_dept]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_DEPT];

CREATE TABLE [DBO].[SYS_DEPT]
(
    ID VARCHAR
(
    32
) NOT NULL,
    PARENT_ID VARCHAR
(
    32
),
    DEPT_CODE VARCHAR
(
    64
),
    DEPT_NAME VARCHAR
(
    128
),
    LEADER_USER_ID VARCHAR
(
    32
),
    LEADER_USER_NAME VARCHAR
(
    128
),
    DEPT_SORT INT,
    PHONE VARCHAR
(
    255
),
    EMAIL VARCHAR
(
    255
),
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '部门表', 'SCHEMA', DBO, 'table', SYS_DEPT, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_DEPT, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '父部门ID', 'SCHEMA', DBO, 'table', SYS_DEPT, 'column', PARENT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '部门编码', 'SCHEMA', DBO, 'table', SYS_DEPT, 'column', DEPT_CODE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '部门名称', 'SCHEMA', DBO, 'table', SYS_DEPT, 'column', DEPT_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '部门负责人ID', 'SCHEMA', DBO, 'table', SYS_DEPT, 'column', LEADER_USER_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '部门负责人名称', 'SCHEMA', DBO, 'table', SYS_DEPT, 'column', LEADER_USER_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '显示顺序', 'SCHEMA', DBO, 'table', SYS_DEPT, 'column', DEPT_SORT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '联系电话', 'SCHEMA', DBO, 'table', SYS_DEPT, 'column', PHONE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '联系邮箱', 'SCHEMA', DBO, 'table', SYS_DEPT, 'column', EMAIL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_DEPT, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_DEPT, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_DEPT, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_DEPT, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_DEPT, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_DEPT, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_DEPT, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_DEPT, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_dict_type]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_DICT_TYPE];

CREATE TABLE [DBO].[SYS_DICT_TYPE]
(
    ID VARCHAR
(
    32
) NOT NULL,
    DICT_CODE VARCHAR
(
    64
),
    DICT_NAME VARCHAR
(
    128
),
    DICT_TYPE INT,
    DICT_REMARK VARCHAR
(
    255
),
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '字典类型表', 'SCHEMA', DBO, 'table', SYS_DICT_TYPE, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_DICT_TYPE, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '字典编码', 'SCHEMA', DBO, 'table', SYS_DICT_TYPE, 'column', DICT_CODE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '字典名称', 'SCHEMA', DBO, 'table', SYS_DICT_TYPE, 'column', DICT_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '字典类型（0字符串 1数字）', 'SCHEMA', DBO, 'table', SYS_DICT_TYPE, 'column', DICT_TYPE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '字典描述', 'SCHEMA', DBO, 'table', SYS_DICT_TYPE, 'column', DICT_REMARK;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_DICT_TYPE, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_DICT_TYPE, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_DICT_TYPE, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_DICT_TYPE, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_DICT_TYPE, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_DICT_TYPE, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_DICT_TYPE, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_DICT_TYPE, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_dict_item]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_DICT_ITEM];

CREATE TABLE [DBO].[SYS_DICT_ITEM]
(
    ID VARCHAR
(
    32
) NOT NULL,
    DICT_CODE VARCHAR
(
    64
),
    ITEM_VALUE VARCHAR
(
    255
),
    ITEM_LABEL VARCHAR
(
    255
),
    ITEM_REMARK VARCHAR
(
    255
),
    ITEM_SORT INT,
    ITEM_STYLE VARCHAR
(
    255
),
    ITEM_CSS TEXT,
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '字典数据表', 'SCHEMA', DBO, 'table', SYS_DICT_ITEM, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_DICT_ITEM, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '字典编码', 'SCHEMA', DBO, 'table', SYS_DICT_ITEM, 'column', DICT_CODE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '字典项值', 'SCHEMA', DBO, 'table', SYS_DICT_ITEM, 'column', ITEM_VALUE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '字典项标签', 'SCHEMA', DBO, 'table', SYS_DICT_ITEM, 'column', ITEM_LABEL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '字典项描述', 'SCHEMA', DBO, 'table', SYS_DICT_ITEM, 'column', ITEM_REMARK;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '字典项排序', 'SCHEMA', DBO, 'table', SYS_DICT_ITEM, 'column', ITEM_SORT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '字典项样式', 'SCHEMA', DBO, 'table', SYS_DICT_ITEM, 'column', ITEM_STYLE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '字典项CSS', 'SCHEMA', DBO, 'table', SYS_DICT_ITEM, 'column', ITEM_CSS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_DICT_ITEM, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_DICT_ITEM, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_DICT_ITEM, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_DICT_ITEM, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_DICT_ITEM, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_DICT_ITEM, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_DICT_ITEM, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_DICT_ITEM, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_error_code]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_ERROR_CODE];

CREATE TABLE [DBO].[SYS_ERROR_CODE]
(
    ID VARCHAR
(
    32
) NOT NULL,
    APPLICATION_ID VARCHAR
(
    255
),
    APPLICATION_NAME VARCHAR
(
    128
),
    ERROR_TYPE VARCHAR
(
    255
),
    ERROR_CODE VARCHAR
(
    255
),
    ERROR_MESSAGE VARCHAR
(
    255
),
    ERROR_REMARK VARCHAR
(
    255
),
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '错误码表', 'SCHEMA', DBO, 'table', SYS_ERROR_CODE, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_ERROR_CODE, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '应用ID', 'SCHEMA', DBO, 'table', SYS_ERROR_CODE, 'column', APPLICATION_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '应用名称', 'SCHEMA', DBO, 'table', SYS_ERROR_CODE, 'column', APPLICATION_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '错误码类型', 'SCHEMA', DBO, 'table', SYS_ERROR_CODE, 'column', ERROR_TYPE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '错误码编码', 'SCHEMA', DBO, 'table', SYS_ERROR_CODE, 'column', ERROR_CODE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '错误码提示', 'SCHEMA', DBO, 'table', SYS_ERROR_CODE, 'column', ERROR_MESSAGE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '错误码描述', 'SCHEMA', DBO, 'table', SYS_ERROR_CODE, 'column', ERROR_REMARK;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_ERROR_CODE, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_ERROR_CODE, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_ERROR_CODE, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_ERROR_CODE, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_ERROR_CODE, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_ERROR_CODE, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_ERROR_CODE, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_ERROR_CODE, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_login_log]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_LOGIN_LOG];

CREATE TABLE [DBO].[SYS_LOGIN_LOG]
(
    ID VARCHAR
(
    32
) NOT NULL,
    TRACE_ID VARCHAR
(
    255
),
    USER_ID VARCHAR
(
    255
),
    USER_TYPE VARCHAR
(
    255
),
    USER_NAME VARCHAR
(
    128
),
    USER_IP VARCHAR
(
    255
),
    USER_AGENT VARCHAR
(
    255
),
    LOGIN_RESULT VARCHAR
(
    255
),
    LOG_TYPE VARCHAR
(
    255
),
    LOG_REQUEST TEXT,
    LOG_RESPONSE TEXT,
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '系统登录日志', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '链路追踪编号', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', TRACE_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户编号', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', USER_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户类型', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', USER_TYPE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户名称', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', USER_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户 IP', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', USER_IP;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '浏览器 UA', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', USER_AGENT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '登陆结果', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', LOGIN_RESULT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '日志类型', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', LOG_TYPE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '请求日志', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', LOG_REQUEST;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '响应日志', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', LOG_RESPONSE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_LOGIN_LOG, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_menu]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_MENU];

CREATE TABLE [DBO].[SYS_MENU]
(
    ID VARCHAR
(
    32
) NOT NULL,
    PARENT_ID VARCHAR
(
    255
),
    MENU_CODE VARCHAR
(
    64
),
    MENU_NAME VARCHAR
(
    128
),
    MENU_TYPE VARCHAR
(
    255
),
    MENU_PATH VARCHAR
(
    255
),
    MENU_ICON VARCHAR
(
    255
),
    MENU_COMPONENT VARCHAR
(
    255
),
    MENU_SORT INT,
    MENU_PERMISSION VARCHAR
(
    255
),
    KEEP_ALIVE INT,
    VISIBLE INT,
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '菜单表', 'SCHEMA', DBO, 'table', SYS_MENU, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '父菜单ID', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', PARENT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '菜单编码', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', MENU_CODE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '菜单名称', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', MENU_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '菜单类型', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', MENU_TYPE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '路由地址', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', MENU_PATH;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '菜单图标', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', MENU_ICON;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '组件路径', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', MENU_COMPONENT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '显示顺序', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', MENU_SORT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '权限标识', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', MENU_PERMISSION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否缓存（0不缓存 1缓存）', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', KEEP_ALIVE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否可见（0正常 1隐藏）', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', VISIBLE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_MENU, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_operate_log]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_OPERATE_LOG];

CREATE TABLE [DBO].[SYS_OPERATE_LOG]
(
    ID VARCHAR
(
    32
) NOT NULL,
    TRACE_ID VARCHAR
(
    32
),
    USER_ID VARCHAR
(
    32
),
    USER_TYPE VARCHAR
(
    255
),
    USER_IP VARCHAR
(
    255
),
    USER_AGENT VARCHAR
(
    255
),
    SYSTEM_MODULE VARCHAR
(
    255
),
    OPERATE_NAME VARCHAR
(
    128
),
    OPERATE_TYPE VARCHAR
(
    255
),
    OPERATE_CONTENT VARCHAR
(
    255
),
    OPERATE_AT DATETIME,
    COST_TIME VARCHAR
(
    255
),
    OPERATE_EXTS VARCHAR
(
    255
),
    REQUEST_METHOD VARCHAR
(
    255
),
    REQUEST_URL VARCHAR
(
    255
),
    REQUEST_BODY TEXT,
    RESPONSE_CODE VARCHAR
(
    255
),
    RESPONSE_MSG VARCHAR
(
    255
),
    RESPONSE_DATA TEXT,
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '操作日志记录表', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '链路追踪ID', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', TRACE_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户ID', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', USER_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户类型', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', USER_TYPE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户 IP', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', USER_IP;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '浏览器 UA', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', USER_AGENT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '系统模块', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', SYSTEM_MODULE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '操作名称', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', OPERATE_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '操作分类', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', OPERATE_TYPE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '操作内容', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', OPERATE_CONTENT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '操作时间', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', OPERATE_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '请求耗时', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', COST_TIME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '拓展字段', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', OPERATE_EXTS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '请求方法名', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', REQUEST_METHOD;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '请求地址', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', REQUEST_URL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '请求入参', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', REQUEST_BODY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '响应状态码', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', RESPONSE_CODE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '响应提示语', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', RESPONSE_MSG;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '响应出参', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', RESPONSE_DATA;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_OPERATE_LOG, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_post]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_POST];

CREATE TABLE [DBO].[SYS_POST]
(
    ID VARCHAR
(
    32
) NOT NULL,
    POST_CODE VARCHAR
(
    64
),
    POST_NAME VARCHAR
(
    128
),
    POST_REMARK VARCHAR
(
    255
),
    POST_SORT INT,
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '岗位表', 'SCHEMA', DBO, 'table', SYS_POST, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_POST, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '岗位编码', 'SCHEMA', DBO, 'table', SYS_POST, 'column', POST_CODE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '岗位名称', 'SCHEMA', DBO, 'table', SYS_POST, 'column', POST_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '岗位描述', 'SCHEMA', DBO, 'table', SYS_POST, 'column', POST_REMARK;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '显示顺序', 'SCHEMA', DBO, 'table', SYS_POST, 'column', POST_SORT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_POST, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_POST, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_POST, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_POST, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_POST, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_POST, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_POST, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_POST, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_role]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_ROLE];

CREATE TABLE [DBO].[SYS_ROLE]
(
    ID VARCHAR
(
    32
) NOT NULL,
    ROLE_CODE VARCHAR
(
    64
),
    ROLE_NAME VARCHAR
(
    128
),
    ROLE_REMARK VARCHAR
(
    255
),
    ROLE_TYPE VARCHAR
(
    255
),
    ROLE_SORT INT,
    ROLE_SCOPE INT,
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '角色表', 'SCHEMA', DBO, 'table', SYS_ROLE, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_ROLE, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '角色代码', 'SCHEMA', DBO, 'table', SYS_ROLE, 'column', ROLE_CODE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '角色名称', 'SCHEMA', DBO, 'table', SYS_ROLE, 'column', ROLE_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '角色描述', 'SCHEMA', DBO, 'table', SYS_ROLE, 'column', ROLE_REMARK;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '角色类型', 'SCHEMA', DBO, 'table', SYS_ROLE, 'column', ROLE_TYPE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '显示顺序', 'SCHEMA', DBO, 'table', SYS_ROLE, 'column', ROLE_SORT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）', 'SCHEMA', DBO, 'table', SYS_ROLE, 'column', ROLE_SCOPE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_ROLE, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_ROLE, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_ROLE, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_ROLE, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_ROLE, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_ROLE, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_ROLE, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_ROLE, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_role_menu]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_ROLE_MENU];

CREATE TABLE [DBO].[SYS_ROLE_MENU]
(
    ID VARCHAR
(
    32
) NOT NULL,
    ROLE_ID VARCHAR
(
    255
),
    MENU_ID VARCHAR
(
    255
),
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '角色菜单中间表', 'SCHEMA', DBO, 'table', SYS_ROLE_MENU, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_ROLE_MENU, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '角色ID', 'SCHEMA', DBO, 'table', SYS_ROLE_MENU, 'column', ROLE_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '菜单ID', 'SCHEMA', DBO, 'table', SYS_ROLE_MENU, 'column', MENU_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_ROLE_MENU, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_ROLE_MENU, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_ROLE_MENU, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_ROLE_MENU, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_ROLE_MENU, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_ROLE_MENU, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_ROLE_MENU, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_ROLE_MENU, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_user_role]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_USER_ROLE];

CREATE TABLE [DBO].[SYS_USER_ROLE]
(
    ID VARCHAR
(
    32
) NOT NULL,
    USER_ID VARCHAR
(
    255
),
    ROLE_ID VARCHAR
(
    255
),
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户角色中间表', 'SCHEMA', DBO, 'table', SYS_USER_ROLE, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_USER_ROLE, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户ID', 'SCHEMA', DBO, 'table', SYS_USER_ROLE, 'column', USER_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '角色ID', 'SCHEMA', DBO, 'table', SYS_USER_ROLE, 'column', ROLE_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_USER_ROLE, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_USER_ROLE, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_USER_ROLE, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_USER_ROLE, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_USER_ROLE, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_USER_ROLE, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_USER_ROLE, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_USER_ROLE, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_sensitive_word]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_SENSITIVE_WORD];

CREATE TABLE [DBO].[SYS_SENSITIVE_WORD]
(
    ID VARCHAR
(
    32
) NOT NULL,
    WORD_NAME VARCHAR
(
    255
),
    WORD_TAGS VARCHAR
(
    255
),
    WORD_REMARK VARCHAR
(
    255
),
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '系统敏感词表', 'SCHEMA', DBO, 'table', SYS_SENSITIVE_WORD, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_SENSITIVE_WORD, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '敏感词', 'SCHEMA', DBO, 'table', SYS_SENSITIVE_WORD, 'column', WORD_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '敏感词标签', 'SCHEMA', DBO, 'table', SYS_SENSITIVE_WORD, 'column', WORD_TAGS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '敏感词描述', 'SCHEMA', DBO, 'table', SYS_SENSITIVE_WORD, 'column', WORD_REMARK;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_SENSITIVE_WORD, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_SENSITIVE_WORD, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_SENSITIVE_WORD, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_SENSITIVE_WORD, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_SENSITIVE_WORD, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_SENSITIVE_WORD, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_SENSITIVE_WORD, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_SENSITIVE_WORD, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_social_user]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_SOCIAL_USER];

CREATE TABLE [DBO].[SYS_SOCIAL_USER]
(
    ID VARCHAR
(
    32
) NOT NULL,
    SOCIAL_TYPE INT,
    SOCIAL_OPEN_ID VARCHAR
(
    255
),
    SOCIAL_TOKEN VARCHAR
(
    255
),
    RAW_TOKEN_INFO VARCHAR
(
    255
),
    RAW_USER_INFO VARCHAR
(
    255
),
    NICK_NAME VARCHAR
(
    128
),
    USER_AVATAR VARCHAR
(
    255
),
    SOCIAL_CODE VARCHAR
(
    255
),
    SOCIAL_STATE VARCHAR
(
    255
),
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '社交用户表', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '社交平台的类型', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', SOCIAL_TYPE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '社交 openid', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', SOCIAL_OPEN_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '社交 token', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', SOCIAL_TOKEN;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '原始 Token 数据，一般是 JSON 格式', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', RAW_TOKEN_INFO;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '原始用户数据，一般是 JSON 格式', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', RAW_USER_INFO;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户昵称', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', NICK_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户头像', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', USER_AVATAR;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '最后一次的认证 code', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', SOCIAL_CODE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '最后一次的认证 state', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', SOCIAL_STATE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_social_user_bind]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_SOCIAL_USER_BIND];

CREATE TABLE [DBO].[SYS_SOCIAL_USER_BIND]
(
    ID VARCHAR
(
    32
) NOT NULL,
    USER_ID VARCHAR
(
    255
),
    USER_TYPE VARCHAR
(
    255
),
    SOCIAL_USER_ID VARCHAR
(
    255
),
    SOCIAL_TYPE VARCHAR
(
    255
),
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '社交用户绑定表', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER_BIND, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER_BIND, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '系统用户ID', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER_BIND, 'column', USER_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户类型', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER_BIND, 'column', USER_TYPE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '社交用户ID', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER_BIND, 'column', SOCIAL_USER_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '社交平台的类型', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER_BIND, 'column', SOCIAL_TYPE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER_BIND, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER_BIND, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER_BIND, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER_BIND, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER_BIND, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER_BIND, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER_BIND, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_SOCIAL_USER_BIND, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_tenant]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_TENANT];

CREATE TABLE [DBO].[SYS_TENANT]
(
    ID VARCHAR
(
    32
) NOT NULL,
    TENANT_CODE VARCHAR
(
    64
),
    TENANT_NAME VARCHAR
(
    128
),
    CONTACT_USER_ID VARCHAR
(
    255
),
    CONTACT_NAME VARCHAR
(
    128
),
    CONTACT_PHONE VARCHAR
(
    255
),
    TENANT_DOMAIN VARCHAR
(
    255
),
    PACKAGE_ID VARCHAR
(
    255
),
    EXPIRE_AT VARCHAR
(
    255
),
    ACCOUNT_COUNT VARCHAR
(
    255
),
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户表', 'SCHEMA', DBO, 'table', SYS_TENANT, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户编码', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', TENANT_CODE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户名', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', TENANT_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '联系人的用户ID', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', CONTACT_USER_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '联系人', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', CONTACT_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '联系手机', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', CONTACT_PHONE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '绑定域名', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', TENANT_DOMAIN;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户套餐编号', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', PACKAGE_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '过期时间', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', EXPIRE_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '账号数量', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', ACCOUNT_COUNT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_TENANT, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_package]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_PACKAGE];

CREATE TABLE [DBO].[SYS_PACKAGE]
(
    ID VARCHAR
(
    32
) NOT NULL,
    PACKAGE_CODE VARCHAR
(
    64
),
    PACKAGE_NAME VARCHAR
(
    128
),
    PACKAGE_REMARK VARCHAR
(
    255
),
    PACKAGE_EXES DECIMAL
(
    24,
    6
),
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '套餐表', 'SCHEMA', DBO, 'table', SYS_PACKAGE, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_PACKAGE, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '套餐代码', 'SCHEMA', DBO, 'table', SYS_PACKAGE, 'column', PACKAGE_CODE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '套餐名称', 'SCHEMA', DBO, 'table', SYS_PACKAGE, 'column', PACKAGE_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '套餐描述', 'SCHEMA', DBO, 'table', SYS_PACKAGE, 'column', PACKAGE_REMARK;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '套餐费用', 'SCHEMA', DBO, 'table', SYS_PACKAGE, 'column', PACKAGE_EXES;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_PACKAGE, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_PACKAGE, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_PACKAGE, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_PACKAGE, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_PACKAGE, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_PACKAGE, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_PACKAGE, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_PACKAGE, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_user_post]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_USER_POST];

CREATE TABLE [DBO].[SYS_USER_POST]
(
    ID VARCHAR
(
    32
) NOT NULL,
    USER_ID VARCHAR
(
    32
),
    POST_ID VARCHAR
(
    32
),
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户岗位表', 'SCHEMA', DBO, 'table', SYS_USER_POST, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_USER_POST, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户ID', 'SCHEMA', DBO, 'table', SYS_USER_POST, 'column', USER_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '岗位ID', 'SCHEMA', DBO, 'table', SYS_USER_POST, 'column', POST_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_USER_POST, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_USER_POST, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_USER_POST, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_USER_POST, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_USER_POST, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_USER_POST, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_USER_POST, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_USER_POST, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_users]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_USERS];

CREATE TABLE [DBO].[SYS_USERS]
(
    ID VARCHAR
(
    32
) NOT NULL,
    USER_CODE VARCHAR
(
    64
),
    USER_NAME VARCHAR
(
    128
),
    NICK_NAME VARCHAR
(
    128
),
    USER_REMARK VARCHAR
(
    255
),
    PASSWORD VARCHAR
(
    255
),
    EMAIL VARCHAR
(
    255
),
    PHONE VARCHAR
(
    255
),
    SEX INT,
    AVATAR VARCHAR
(
    255
),
    LOGIN_IP VARCHAR
(
    255
),
    LOGIN_DATE DATETIME,
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    128
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    128
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户表', 'SCHEMA', DBO, 'table', SYS_USERS, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户编码', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', USER_CODE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户名称', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', USER_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户昵称', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', NICK_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户描述', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', USER_REMARK;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '登录密码', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', PASSWORD;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户邮箱', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', EMAIL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '手机号码', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', PHONE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '用户性别（0女性 1男性）', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', SEX;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '头像地址', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', AVATAR;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '最后登录IP', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', LOGIN_IP;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '最后登录时间', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', LOGIN_DATE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_USERS, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_company]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_COMPANY];

CREATE TABLE [DBO].[SYS_COMPANY]
(
    ID VARCHAR
(
    32
) NOT NULL,
    PARENT_ID VARCHAR
(
    32
),
    COMPANY_CODE VARCHAR
(
    64
),
    COMPANY_NAME VARCHAR
(
    128
),
    LEADER_USER_ID VARCHAR
(
    32
),
    LEADER_USER_NAME VARCHAR
(
    128
),
    COMPANY_SORT INT,
    PHONE VARCHAR
(
    255
),
    EMAIL VARCHAR
(
    255
),
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '公司表', 'SCHEMA', DBO, 'table', SYS_COMPANY, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_COMPANY, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '父公司ID', 'SCHEMA', DBO, 'table', SYS_COMPANY, 'column', PARENT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '公司编码', 'SCHEMA', DBO, 'table', SYS_COMPANY, 'column', COMPANY_CODE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '公司名称', 'SCHEMA', DBO, 'table', SYS_COMPANY, 'column', COMPANY_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '公司负责人ID', 'SCHEMA', DBO, 'table', SYS_COMPANY, 'column', LEADER_USER_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '公司负责人名称', 'SCHEMA', DBO, 'table', SYS_COMPANY, 'column', LEADER_USER_NAME;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '显示顺序', 'SCHEMA', DBO, 'table', SYS_COMPANY, 'column', COMPANY_SORT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '联系电话', 'SCHEMA', DBO, 'table', SYS_COMPANY, 'column', PHONE;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '联系邮箱', 'SCHEMA', DBO, 'table', SYS_COMPANY, 'column', EMAIL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_COMPANY, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_COMPANY, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_COMPANY, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_COMPANY, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_COMPANY, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_COMPANY, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_COMPANY, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_COMPANY, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_company_dept]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_COMPANY_DEPT];

CREATE TABLE [DBO].[SYS_COMPANY_DEPT]
(
    ID VARCHAR
(
    32
) NOT NULL,
    COMPANY_ID VARCHAR
(
    32
),
    DEPT_ID VARCHAR
(
    32
),
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '公司部门表', 'SCHEMA', DBO, 'table', SYS_COMPANY_DEPT, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_COMPANY_DEPT, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '公司ID', 'SCHEMA', DBO, 'table', SYS_COMPANY_DEPT, 'column', COMPANY_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '部门ID', 'SCHEMA', DBO, 'table', SYS_COMPANY_DEPT, 'column', DEPT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_COMPANY_DEPT, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_COMPANY_DEPT, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_COMPANY_DEPT, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_COMPANY_DEPT, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_COMPANY_DEPT, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_COMPANY_DEPT, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_COMPANY_DEPT, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_COMPANY_DEPT, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_company_post]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_COMPANY_POST];

CREATE TABLE [DBO].[SYS_COMPANY_POST]
(
    ID VARCHAR
(
    32
) NOT NULL,
    COMPANY_ID VARCHAR
(
    32
),
    POST_ID VARCHAR
(
    32
),
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '公司岗位表', 'SCHEMA', DBO, 'table', SYS_COMPANY_POST, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_COMPANY_POST, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '公司ID', 'SCHEMA', DBO, 'table', SYS_COMPANY_POST, 'column', COMPANY_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '岗位ID', 'SCHEMA', DBO, 'table', SYS_COMPANY_POST, 'column', POST_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_COMPANY_POST, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_COMPANY_POST, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_COMPANY_POST, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_COMPANY_POST, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_COMPANY_POST, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_COMPANY_POST, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_COMPANY_POST, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_COMPANY_POST, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_dept_post]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_DEPT_POST];

CREATE TABLE [DBO].[SYS_DEPT_POST]
(
    ID VARCHAR
(
    32
) NOT NULL,
    DEPT_ID VARCHAR
(
    32
),
    POST_ID VARCHAR
(
    32
),
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    TENANT_ID VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '部门岗位表', 'SCHEMA', DBO, 'table', SYS_DEPT_POST, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_DEPT_POST, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '部门ID', 'SCHEMA', DBO, 'table', SYS_DEPT_POST, 'column', DEPT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '岗位ID', 'SCHEMA', DBO, 'table', SYS_DEPT_POST, 'column', POST_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_DEPT_POST, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_DEPT_POST, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_DEPT_POST, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户号', 'SCHEMA', DBO, 'table', SYS_DEPT_POST, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_DEPT_POST, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_DEPT_POST, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_DEPT_POST, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_DEPT_POST, 'column', UPDATED_AT;

IF
EXISTS (
    SELECT
        *
    FROM
        SYS.OBJECTS
    WHERE
        OBJECT_ID = OBJECT_ID(N'[dbo].[sys_tenant_package]')
        AND TYPE IN (N'U')
)
DROP TABLE [DBO].[SYS_TENANT_PACKAGE];

CREATE TABLE [DBO].[SYS_TENANT_PACKAGE]
(
    ID VARCHAR
(
    32
) NOT NULL,
    TENANT_ID VARCHAR
(
    32
),
    PACKAGE_ID VARCHAR
(
    32
),
    STATUS INT,
    DELETED INT,
    REVISION VARCHAR
(
    32
),
    CREATED_BY VARCHAR
(
    32
),
    CREATED_AT DATETIME,
    UPDATED_BY VARCHAR
(
    32
),
    UPDATED_AT DATETIME,
    PRIMARY KEY
(
    ID
)
    );

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户套餐表', 'SCHEMA', DBO, 'table', SYS_TENANT_PACKAGE, NULL, NULL;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', 'ID', 'SCHEMA', DBO, 'table', SYS_TENANT_PACKAGE, 'column', ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '租户ID', 'SCHEMA', DBO, 'table', SYS_TENANT_PACKAGE, 'column', TENANT_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '套餐ID', 'SCHEMA', DBO, 'table', SYS_TENANT_PACKAGE, 'column', PACKAGE_ID;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '数据状态（0正常 1停用）', 'SCHEMA', DBO, 'table', SYS_TENANT_PACKAGE, 'column', STATUS;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '是否删除（0正常 1删除）', 'SCHEMA', DBO, 'table', SYS_TENANT_PACKAGE, 'column', DELETED;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '乐观锁', 'SCHEMA', DBO, 'table', SYS_TENANT_PACKAGE, 'column', REVISION;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建人', 'SCHEMA', DBO, 'table', SYS_TENANT_PACKAGE, 'column', CREATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '创建时间', 'SCHEMA', DBO, 'table', SYS_TENANT_PACKAGE, 'column', CREATED_AT;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新人', 'SCHEMA', DBO, 'table', SYS_TENANT_PACKAGE, 'column', UPDATED_BY;

EXEC SP_ADDEXTENDEDPROPERTY 'MS_Description', '更新时间', 'SCHEMA', DBO, 'table', SYS_TENANT_PACKAGE, 'column', UPDATED_AT;
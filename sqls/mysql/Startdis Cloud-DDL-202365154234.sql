DROP TABLE IF EXISTS sys_dept;
CREATE TABLE sys_dept(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    parent_id VARCHAR(19)    COMMENT '父部门ID' ,
    dept_code VARCHAR(64)    COMMENT '部门编码' ,
    dept_name VARCHAR(128)    COMMENT '部门名称' ,
    leader_user_id VARCHAR(19)    COMMENT '部门负责人ID' ,
    leader_user_name VARCHAR(128)    COMMENT '部门负责人名称' ,
    dept_sort INT4    COMMENT '显示顺序' ,
    phone VARCHAR(255)    COMMENT '联系电话' ,
    email VARCHAR(255)    COMMENT '联系邮箱' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '部门表';

DROP TABLE IF EXISTS sys_dict;
CREATE TABLE sys_dict(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    dict_code VARCHAR(64)    COMMENT '字典编码' ,
    dict_name VARCHAR(128)    COMMENT '字典名称' ,
    dict_remark VARCHAR(255)    COMMENT '字典描述' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '字典主表';

DROP TABLE IF EXISTS sys_dict_item;
CREATE TABLE sys_dict_item(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    dict_code VARCHAR(64)    COMMENT '字典编码' ,
    item_value VARCHAR(255)    COMMENT '字典项值' ,
    item_label VARCHAR(255)    COMMENT '字典项标签' ,
    item_remark VARCHAR(255)    COMMENT '字典项描述' ,
    item_sort INT4    COMMENT '字典项排序' ,
    item_style VARCHAR(255)    COMMENT '字典项样式' ,
    item_css TEXT    COMMENT '字典项CSS' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '字典项表';

DROP TABLE IF EXISTS sys_login_log;
CREATE TABLE sys_login_log(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    trace_id VARCHAR(255)    COMMENT '链路追踪编号' ,
    user_id VARCHAR(255)    COMMENT '用户编号' ,
    user_type VARCHAR(255)    COMMENT '用户类型' ,
    user_name VARCHAR(128)    COMMENT '用户名称' ,
    user_ip VARCHAR(255)    COMMENT '用户 IP' ,
    user_agent VARCHAR(255)    COMMENT '浏览器 UA' ,
    login_result VARCHAR(255)    COMMENT '登陆结果' ,
    log_type VARCHAR(255)    COMMENT '日志类型' ,
    log_request TEXT    COMMENT '请求日志' ,
    log_response TEXT    COMMENT '响应日志' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(255)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(255)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '系统登录日志';

DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    parent_id VARCHAR(255)    COMMENT '父菜单ID' ,
    menu_code VARCHAR(64)    COMMENT '菜单编码' ,
    menu_name VARCHAR(128)    COMMENT '菜单名称' ,
    menu_type VARCHAR(255)    COMMENT '菜单类型' ,
    menu_path VARCHAR(255)    COMMENT '路由地址' ,
    menu_icon VARCHAR(255)    COMMENT '菜单图标' ,
    menu_component VARCHAR(255)    COMMENT '组件路径' ,
    menu_sort INT4    COMMENT '显示顺序' ,
    menu_permission VARCHAR(255)    COMMENT '权限标识' ,
    menu_shortcut INT2    COMMENT '是否创建快捷方式（0停用 1启用）' ,
    keep_alive INT2    COMMENT '是否缓存（0不缓存 1缓存）' ,
    visible INT2    COMMENT '是否可见（0隐藏 1显示）' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '菜单表';

DROP TABLE IF EXISTS sys_operate_log;
CREATE TABLE sys_operate_log(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    system_module VARCHAR(255)    COMMENT '系统模块' ,
    trace_id VARCHAR(19)    COMMENT '链路追踪ID' ,
    logger_level VARCHAR(64)    COMMENT '日志级别' ,
    logger_info TEXT    COMMENT '日志详情' ,
    operate_name VARCHAR(128)    COMMENT '操作名称' ,
    operate_action VARCHAR(255)    COMMENT '操作类型' ,
    operate_content VARCHAR(255)    COMMENT '操作内容（接口描述）' ,
    operate_at TIMESTAMP    COMMENT '操作时间' ,
    operate_exts VARCHAR(255)    COMMENT '拓展字段' ,
    cost_time VARCHAR(255)    COMMENT '请求耗时' ,
    request_url VARCHAR(255)    COMMENT '请求地址' ,
    request_method VARCHAR(255)    COMMENT '请求方法' ,
    request_body TEXT    COMMENT '请求入参' ,
    response_code VARCHAR(255)    COMMENT '响应状态码' ,
    response_msg VARCHAR(255)    COMMENT '响应提示语' ,
    response_data TEXT    COMMENT '响应出参' ,
    user_id VARCHAR(19)    COMMENT '用户ID' ,
    user_type VARCHAR(255)    COMMENT '用户类型' ,
    user_ip VARCHAR(255)    COMMENT '用户 IP' ,
    user_agent VARCHAR(255)    COMMENT '浏览器 UA' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '操作日志记录表';

DROP TABLE IF EXISTS sys_post;
CREATE TABLE sys_post(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    post_code VARCHAR(64)    COMMENT '岗位编码' ,
    post_name VARCHAR(128)    COMMENT '岗位名称' ,
    post_remark VARCHAR(255)    COMMENT '岗位描述' ,
    post_sort INT4    COMMENT '显示顺序' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '岗位表';

DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    role_code VARCHAR(64)    COMMENT '角色代码' ,
    role_name VARCHAR(128)    COMMENT '角色名称' ,
    role_remark VARCHAR(255)    COMMENT '角色描述' ,
    role_type VARCHAR(255)    COMMENT '角色类型' ,
    role_sort INT4    COMMENT '显示顺序' ,
    role_scope INT2    COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '角色表';

DROP TABLE IF EXISTS sys_role_menu;
CREATE TABLE sys_role_menu(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    role_id VARCHAR(19)    COMMENT '角色ID' ,
    menu_id VARCHAR(19)    COMMENT '菜单ID' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '角色菜单表';

DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    user_id VARCHAR(19)    COMMENT '用户ID' ,
    role_id VARCHAR(19)    COMMENT '角色ID' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '用户角色表';

DROP TABLE IF EXISTS sys_sensitive_word;
CREATE TABLE sys_sensitive_word(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    word_name VARCHAR(255)    COMMENT '敏感词' ,
    word_tags VARCHAR(255)    COMMENT '敏感词标签' ,
    word_remark VARCHAR(255)    COMMENT '敏感词描述' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '系统敏感词表';

DROP TABLE IF EXISTS sys_user_post;
CREATE TABLE sys_user_post(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    user_id VARCHAR(19)    COMMENT '用户ID' ,
    post_id VARCHAR(19)    COMMENT '岗位ID' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '用户岗位表';

DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    user_code VARCHAR(64)    COMMENT '用户编码' ,
    user_name VARCHAR(64)    COMMENT '用户名称' ,
    nick_name VARCHAR(128)    COMMENT '用户昵称' ,
    user_remark VARCHAR(255)    COMMENT '用户描述' ,
    password VARCHAR(255)    COMMENT '登录密码' ,
    mobile VARCHAR(19)    COMMENT '手机号码' ,
    phone VARCHAR(255)    COMMENT '电话号码' ,
    email VARCHAR(255)    COMMENT '电子邮箱' ,
    sex INT2    COMMENT '用户性别（0女性 1男性）' ,
    head_pic VARCHAR(255)    COMMENT '头像地址' ,
    login_ip VARCHAR(255)    COMMENT '最后登录IP' ,
    login_date TIMESTAMP    COMMENT '最后登录时间' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '用户表';

DROP TABLE IF EXISTS sys_company;
CREATE TABLE sys_company(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    parent_id VARCHAR(19)    COMMENT '父公司ID' ,
    company_code VARCHAR(64)    COMMENT '公司编码' ,
    company_name VARCHAR(128)    COMMENT '公司名称' ,
    company_remark VARCHAR(255)    COMMENT '公司介绍' ,
    company_address VARCHAR(255)    COMMENT '公司地址' ,
    company_postcode VARCHAR(128)    COMMENT '公司邮编' ,
    company_fax VARCHAR(128)    COMMENT '传真号码' ,
    company_wechat VARCHAR(128)    COMMENT '微信二维码' ,
    company_blicense VARCHAR(128)    COMMENT '统一信用社会代码' ,
    company_other VARCHAR(255)    COMMENT '其它信息' ,
    leader_user_id VARCHAR(19)    COMMENT '公司负责人ID' ,
    leader_user_name VARCHAR(128)    COMMENT '公司负责人名称' ,
    company_sort INT4    COMMENT '显示顺序' ,
    mobile VARCHAR(19)    COMMENT '手机号码' ,
    phone VARCHAR(255)    COMMENT '电话号码' ,
    email VARCHAR(255)    COMMENT '电子邮箱' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '公司表';

DROP TABLE IF EXISTS sys_user_field;
CREATE TABLE sys_user_field(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    field_code VARCHAR(64)    COMMENT '字段编码' ,
    field_name VARCHAR(128)    COMMENT '字段名称' ,
    field_length INT8    COMMENT '字段长度' ,
    field_remark VARCHAR(255)    COMMENT '字段描述' ,
    field_sort INT4    COMMENT '显示顺序' ,
    required VARCHAR(19)    COMMENT '是否必填（0正常 1必填）' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '用户字段表';

DROP TABLE IF EXISTS sys_notice;
CREATE TABLE sys_notice(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    notice_code VARCHAR(64)    COMMENT '公告编码' ,
    notice_title VARCHAR(128)    COMMENT '公告标题' ,
    notice_content TEXT    COMMENT '公告内容' ,
    notice_type INT2    COMMENT '公告类型（1公告 2通知）' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '通知公告表';

DROP TABLE IF EXISTS sys_variable;
CREATE TABLE sys_variable(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    variable_code VARCHAR(64)    COMMENT '变量编码' ,
    variable_name VARCHAR(128)    COMMENT '变量名称' ,
    variable_key VARCHAR(255)    COMMENT '变量键名' ,
    variable_value TEXT    COMMENT '变量键值' ,
    variable_type INT2    COMMENT '是否内置（0用户定义 1系统内置）' ,
    variable_remark VARCHAR(255)    COMMENT '变量描述' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '全局变量表';

DROP TABLE IF EXISTS sys_user_dept;
CREATE TABLE sys_user_dept(
    id VARCHAR(19) NOT NULL   COMMENT 'ID' ,
    user_id VARCHAR(19)    COMMENT '用户ID' ,
    dept_id VARCHAR(19)    COMMENT '部门ID' ,
    status INT2    COMMENT '是否启用（0停用 1启用）' ,
    deleted INT2    COMMENT '是否删除（0正常 1删除）' ,
    revision INT8    COMMENT '乐观锁' ,
    group_tenant_id VARCHAR(19)    COMMENT '集团租户ID' ,
    company_tenant_id VARCHAR(19)    COMMENT '公司租户ID' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_at TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_at TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '用户部门表';


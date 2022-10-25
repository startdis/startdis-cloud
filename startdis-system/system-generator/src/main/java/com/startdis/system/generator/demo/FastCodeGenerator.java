package com.startdis.system.generator.demo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.startdis.common.domain.model.BaseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * 代码生成器（快速版本）
 * </p>
 *
 * @author 点九
 * @since 2022-07-10
 */
public class FastCodeGenerator {
    
    // 基础信息配置
    // 数据库连接字符
    //private static final String URL = "jdbc:mysql://192.168.1.31:3306/startdis-cloud?useUnicode=true&serverTimezone=UTC&useSSL=false&characterEncoding=utf8";
    private static final String URL = "jdbc:postgresql://192.168.1.31:5432/startdis-cloud?useUnicode=true&serverTimezone=UTC&useSSL=false&characterEncoding=utf8";
    
    // 数据库用户名
    //private static final String USERNAME = "root";
    private static final String USERNAME = "postgres";
    
    // 数据库密码
    private static final String PASSWORD = "123456";
    
    // 项目根路径。生成结果如：D:\MyProject\spring-boot
    //private static final String projectRootPath = System.getProperty("user.dir");
    // 项目根路径（测试用，非通用）（此句是本项目测试用的。实际项目中，包括多模块项目，请注释掉此句，使用上句）
    private static final String projectRootPath = System.getProperty("user.dir");
    
    // 父包名。用于生成的java文件的import。
    private static final String parentPackageName = "com.startdis";
    
    /**
     * 执行此处
     */
    public static void main(String[] args) {
        // 简单示例，适用于单模块项目
        //simpleGenerator();
        // 完整示例，适用于多模块项目
        completeGenerator();
    }
    
    /**
     * 【单模块】简单的实现方案
     */
    protected static void simpleGenerator() {
        
        //String moduleName = scanner("请输入模块名：");
        String moduleName = "/startdis-system/system-generator";
        // 包路径
        String packagePath = projectRootPath + moduleName + "/src/main/java";
        // XML文件的路径
        String mapperXmlPath = projectRootPath + moduleName + "/src/main/resources/mapper";
        
        // 开始执行代码生成
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                // 1. 全局配置
                .globalConfig(builder -> builder
                        // 作者名称
                        .author("Startdis")
                        // 开启覆盖已生成的文件。注释掉则关闭覆盖。
                        .fileOverride()
                        // 禁止打开输出目录。注释掉则生成完毕后，自动打开生成的文件目录。
                        .disableOpenDir()
                        // 指定输出目录。如果指定，Windows生成至D盘根目录下，Linux or MAC 生成至 /tmp 目录下。
                        .outputDir(packagePath)
                        // 开启swagger2.注释掉则默认关闭。
                        // .enableSwagger()
                        // 指定时间策略。
                        .dateType(DateType.TIME_PACK)
                        // 注释时间策略。
                        .commentDate("yyyy-MM-dd"))
                
                // 2. 包配置
                .packageConfig((scanner, builder) -> builder
                        // 设置父表名
                        .parent(parentPackageName + ".system.generator")
                        // mapper.xml 文件的路径。单模块下，其他文件路径默认即可。
                        .pathInfo(Collections.singletonMap(OutputFile.xml, mapperXmlPath)))
                
                //t_system_log,t_system_dict,t_system_dict_item,t_roll_site,t_roll_line,t_chip_equipment,t_chip_config,t_roll_distinguish,t_extend_pe_config,t_pn_wide_config,t_pn_bom,t_pn_bom_log,t_extend_bom,t_extend_bom_log,t_coating_bom,t_coating_bom_log
                //t_roll_distinguish,t_extend_pe_config,t_pn_wide_config,t_pn_bom,t_extend_bom,t_pn_bom_log,t_extend_bom_log,t_coating_bom,t_coating_bom_log,t_purchase_arrival_plan,t_purchase_arrival_plan_log,t_purchase_arrival_day_detail,t_purchase_arrival_day_detail_log,t_purchase_invite_plan,t_purchase_invite_plan_log,t_purchase_invite_day_detail,t_purchase_invite_day_detail_log,t_chip_inventory,t_roll_inventory,t_material_inventory,t_chip_margin,t_chip_margin_day_detail,t_slit_margin,t_coat_margin,t_extend_margin,t_slit_margin_day_detail,t_coat_margin_day_detail,t_extend_margin_day_detail,t_chip_schedule,t_coat_arrange,t_extend_arrange,t_chip_schedule_day_detail,t_coat_schedule_day_detail,t_extend_schedule_day_detail
                // 3. 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(
                                getTables(scanner.apply("请输入表名，多个英文逗号分隔？生成所有表，请输入[all]：")))
                        // 阶段0：过滤表名前缀，如t_user,我们生成的实体只需要user
                        .addTablePrefix("sys_")
                        // 阶段1：Entity实体类策略配置
                        .entityBuilder()
                        // 全局主键类型。如果MySQL主键设置为自增，则不需要设置此项。
                        .idType(IdType.ASSIGN_ID)
                        // 数据库表映射到实体的命名策略(默认下划线转驼峰)。一般不用设置
                        // .naming(NamingStrategy.underline_to_camel)
                        // 数据库表字段映射到实体的命名策略(默认为 null，未指定按照 naming 执行)。一般不用设置
                        // .columnNaming(NamingStrategy.underline_to_camel)
                        // 禁用生成 serialVersionUID。（不推荐禁用）
                        // .disableSerialVersionUID()
                        // 开启生成字段常量。
                        // 会在实体类末尾生成一系列 [public static final String NICKNAME = "nickname";] 的语句。（一般在写wapper时，会用到）
                        // .enableColumnConstant()
                        // 继承哪个父类
                        .superClass(BaseEntity.class)
                        // 添加忽略字段。
                        // 这些字段不会出现在新增的实体类中。
                        // .addIgnoreColumns("password")
                        // 添加父类公共字段。
                        // 这些字段不会出现在新增的实体类中。
                        //                        .addSuperEntityColumns("id", "updated_by", "updated_at", "created_by", "created_at")
                        // 是否支持乐观锁和假删除
                        .addSuperEntityColumns("id", "revision", "is_deleted", "updated_by", "updated_at", "created_by",
                                "created_at")
                        // 开启链式模型。
                        // 会在实体类前添加 [@Accessors(chain = true)] 注解。用法如 [User user=new User().setAge(31).setName("snzl");]（这是Lombok的注解，需要添加Lombok依赖）
                        .enableChainModel()
                        // 开启 lombok 模型。
                        // 会在实体类前添加 [@Getter] 和 [@Setter] 注解。（这是Lombok的注解，需要添加Lombok依赖）
                        .enableLombok()
                        // 开启 Boolean 类型字段移除 is 前缀。
                        .enableRemoveIsPrefix()
                        // 开启生成实体时生成字段注解。
                        // 会在实体类的属性前，添加[@TableField("nickname")]
                        .enableTableFieldAnnotation()
                        // 开启生成实体时生成字段注解。
                        // 会在实体类的属性前，添加[@TableField("nickname")]
                        .enableTableFieldAnnotation()
                        // 乐观锁字段名(数据库)。
                        .versionColumnName("revision")
                        // 乐观锁属性名(实体)。
                        .versionPropertyName("revision")
                        // 逻辑删除字段名(数据库)。
                        .logicDeleteColumnName("deleted")
                        // 逻辑删除属性名(实体)。
                        // 会在实体类的该字段属性前加注解[@TableLogic]
                        .logicDeletePropertyName("deleted")
                        // 会在实体类的该字段上追加注解[@TableField(value = "created_at", fill = FieldFill.INSERT)]
                        .addTableFills(new Column("created_at", FieldFill.INSERT))
                        // 会在实体类的该字段上追加注解[@TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)]
                        .addTableFills(new Column("updated_at", FieldFill.INSERT_UPDATE))
                        // 格式化文件名称。
                        // 如果不设置，如表[t_user]的实体类名是[TUser]。设置成下面这样，将是[TUserEntity]
                        //.formatFileName("%sEntity")
                        
                        // 阶段2：Mapper策略配置
                        .mapperBuilder()
                        // 继承哪个父类
                        .superClass(BaseMapper.class)
                        // 开启 @Mapper 注解。
                        // 会在mapper接口上添加注解[@Mapper]
                        .enableMapperAnnotation()
                        // 启用 BaseResultMap 生成。
                        // 会在mapper.xml文件生成[通用查询映射结果]配置。
                        .enableBaseResultMap()
                        // 启用 BaseColumnList。
                        // 会在mapper.xml文件生成[通用查询结果列 ]配置
                        .enableBaseColumnList()
                        // 设置缓存实现类
                        // .cache(MyMapperCache.class)
                        // 格式化 mapper 文件名称。
                        // 如果不设置，如表[t_user]，默认的文件名是[TUserMapper]。写成下面这种形式后，将变成[TUserDao]。
                        // .formatMapperFileName("%sDao")
                        // 格式化 xml 实现类文件名称。
                        // 如果不设置，如表[t_user]，默认的文件名是[TUserMapper.xml]，写成下面这种形式后，将变成[TUserXml.xml]。
                        // .formatXmlFileName("%sXml")
                        
                        // 阶段3：Service策略配置
                        //.serviceBuilder()
                        // 设置 service 接口父类
                        // .superServiceClass(BaseService.class)
                        // 设置 service 实现类父类
                        // .superServiceImplClass(BaseServiceImpl.class)
                        // 格式化 service 接口文件名称
                        // 如果不设置，如表[t_user]，默认的是[ITUserService]。写成下面这种形式后，将变成[tUserService]。
                        //.formatServiceFileName("%sService")
                        // 格式化 service 实现类文件名称
                        // 如果不设置，如表[t_user]，默认的是[TUserServiceImpl]。
                        //.formatServiceImplFileName("%sServiceImpl")
                        
                        // 阶段4：Controller策略配置
                        //.controllerBuilder()
                        // 设置父类。
                        // 会集成此父类。
                        // .superClass(BaseController.class)
                        // 会在控制类中加[@RestController]注解。
                        //.enableRestStyle()
                        // 开启驼峰转连字符
                        //.enableHyphenStyle()
                        // 格式化 Controller文件名称
                        //.formatFileName("%sController")
                        
                        // 最后：构建
                        .build())
                
                // 4. 模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                //.templateEngine(new BeetlTemplateEngine())
                .templateEngine(new FreemarkerTemplateEngine())
                
                // 5. 执行
                .execute();
    }
    
    /**
     * 【多模块使用】完整的实现方案
     */
    protected static void completeGenerator() {
        //【1】基础信息配置
        // 指定模块名，用于生成的java文件的import。
        //String moduleName = scanner("请输入模块名：");
        // 六个文件的路径。多模块项目下，一般来说每个文件的路径都是不同的（根据项目实际，可能在不同的模块下）。
        String moduleName = "/startdis-system";
        String entityPath =
                projectRootPath + moduleName + "/system-domain/src/main/java/com/startdis/system/domain/model/entity/";
        String mapperPath =
                projectRootPath + moduleName + "/system-infra/src/main/java/com/startdis/system/infra/mapper/";
        String mapperXmlPath = projectRootPath + moduleName + "/system-infra/src/main/resources/mapper/";
        String servicePath =
                projectRootPath + moduleName + "/system-server/src/main/java/com/startdis/system/server/service/";
        String serviceImplPath =
                projectRootPath + moduleName + "/system-server/src/main/java/com/startdis/system/server/service/impl";
        String controllerPath =
                projectRootPath + moduleName + "/system-web/src/main/java/com/startdis/system/web/controller/";
        
        String modulePackage = "system";
        String entityPackage = modulePackage + ".domain.model.entity";
        String mapperPackage = modulePackage + ".infra.mapper";
        String servicePackage = modulePackage + ".server.service";
        String serviceImplPackage = modulePackage + ".server.service.impl";
        String controllerPackage = modulePackage + ".web.controller";
        // 关于以上写法的解释：
        // --- 假设我们的项目有四个模块：system-domain、system-infra、system-server、system-web
        // --- system-domain 的包路径：co.dianjiu.system.domain.model.entity，
        //   ---则生成system模块下的t_user表，生成的实体文件将放在：co.dianjiu.system.domain.model.entity包下，User.java。
        // --- system-infra 的包路径：co.dianjiu.system.infra.mapper，
        //   ---则生成system模块下的t_user表，生成的mapper接口文件将放在：co.dianjiu.system.infra.mapper包下，类名为：UserMapper.java。
        // --- 其他文件以此类推，即每个模块放MVC结构中对应的类型文件。
        // --- 注意：这里最后的文件路径修改了，下文配置中的【2 包配置】中的包路径也要同步修改！否则生成的java文件，首句import会报错。原因是路径错误。
        
        // 【2】开始执行代码生成
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                // 1. 全局配置
                .globalConfig(builder -> builder
                        // 作者名称
                        .author("Startdis")
                        // 开启覆盖已生成的文件。已弃用，默认开启覆盖，3.5.3版本会删除此方法！
                        .fileOverride()
                        // 禁止打开输出目录。注释掉则生成完毕后，自动打开生成的文件目录。
                        .disableOpenDir()
                        // 指定输出目录。多模块下，每个类型的文件输出目录不一致，在包配置阶段配置。
                        // .outputDir(packagePath)
                        // 开启swagger2。注释掉则默认关闭。
                        // .enableSwagger()
                        // 开启 kotlin 模式。注释掉则关闭此模式
                        // .enableKotlin()
                        // 指定时间策略。
                        .dateType(DateType.TIME_PACK)
                        // 注释时间策略。
                        .commentDate("yyyy-MM-dd"))
                
                // 2. 包配置
                .packageConfig((scanner, builder) -> builder
                        // 阶段1：各个文件的包名设置，用来拼接每个java文件的第一句：package com.XXX.XXX.XXX.xxx;
                        // 父包名配置
                        .parent(parentPackageName)
                        // 输入模块名。此模块名会在下面的几个包名前加。多模块项目，请根据实际选择是否添加。
                        // .moduleName(moduleName)
                        .entity(entityPackage).mapper(mapperPackage).service(servicePackage)
                        .serviceImpl(serviceImplPackage).controller(controllerPackage).other("other")
                        // 阶段2：所有文件的生成路径配置
                        .pathInfo(new HashMap<OutputFile, String>() {{
                            // 实体类的保存路径
                            put(OutputFile.entity, entityPath);
                            // mapper接口的保存路径
                            put(OutputFile.mapper, mapperPath);
                            // mapper.xml文件的保存路径
                            put(OutputFile.xml, mapperXmlPath);
                            // service层接口的保存路径
                            put(OutputFile.service, servicePath);
                            // service层接口实现类的保存路径
                            put(OutputFile.serviceImpl, serviceImplPath);
                            // 控制类的保存路径
                            put(OutputFile.controller, controllerPath);
                        }}))
                
                // 3. 策略配置【请仔细阅读每一行，根据项目实际项目需求，修改、增删！！！】
                .strategyConfig((scanner, builder) -> builder.addInclude(
                                getTables(scanner.apply("请输入表名，多个英文逗号分隔？生成所有表，请输入[all]：")))
                        // 阶段0：过滤表名前缀，如t_user,我们生成的实体只需要user
                        .addTablePrefix("sys_")
                        // 阶段1：Entity实体类策略配置
                        .entityBuilder()
                        // 全局主键类型。如果MySQL主键设置为自增，则不需要设置此项。
                        // .idType(IdType.INPUT)
                        // 数据库表映射到实体的命名策略(默认下划线转驼峰)。一般不用设置
                        // .naming(NamingStrategy.underline_to_camel)
                        // 数据库表字段映射到实体的命名策略(默认为 null，未指定按照 naming 执行)。一般不用设置
                        // .columnNaming(NamingStrategy.underline_to_camel)
                        // 禁用生成 serialVersionUID。（不推荐禁用）
                        // .disableSerialVersionUID()
                        // 开启生成字段常量。
                        // 会在实体类末尾生成一系列 [public static final String NICKNAME = "nickname";] 的语句。（一般在写wapper时，会用到）
                        // .enableColumnConstant()
                        // 继承哪个父类
                        .superClass(BaseEntity.class)
                        // 添加忽略字段。
                        // 这些字段不会出现在新增的实体类中。
                        // .addIgnoreColumns("password")
                        // 添加父类公共字段。
                        // 这些字段不会出现在新增的实体类中。
                        //                        .addSuperEntityColumns("id", "updated_by", "updated_at", "created_by", "created_at")
                        // 是否支持乐观锁和假删除
                        .addSuperEntityColumns("id", "revision", "is_deleted", "updated_by", "updated_at", "created_by",
                                "created_at")
                        // 开启链式模型。
                        // 会在实体类前添加 [@Accessors(chain = true)] 注解。用法如 [User user=new User().setAge(31).setName("snzl");]（这是Lombok的注解，需要添加Lombok依赖）
                        .enableChainModel()
                        // 开启 lombok 模型。
                        // 会在实体类前添加 [@Getter] 和 [@Setter] 注解。（这是Lombok的注解，需要添加Lombok依赖）
                        .enableLombok()
                        // 开启 Boolean 类型字段移除 is 前缀。
                        .enableRemoveIsPrefix()
                        // 开启生成实体时生成字段注解。
                        // 会在实体类的属性前，添加[@TableField("nickname")]
                        .enableTableFieldAnnotation()
                        // 开启生成实体时生成字段注解。
                        // 会在实体类的属性前，添加[@TableField("nickname")]
                        .enableTableFieldAnnotation()
                        // 乐观锁字段名(数据库)。
                        .versionColumnName("revision")
                        // 乐观锁属性名(实体)。
                        .versionPropertyName("revision")
                        // 逻辑删除字段名(数据库)。
                        .logicDeleteColumnName("deleted")
                        // 逻辑删除属性名(实体)。
                        // 会在实体类的该字段属性前加注解[@TableLogic]
                        .logicDeletePropertyName("deleted")
                        // 会在实体类的该字段上追加注解[@TableField(value = "created_at", fill = FieldFill.INSERT)]
                        .addTableFills(new Column("created_at", FieldFill.INSERT))
                        // 会在实体类的该字段上追加注解[@TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)]
                        .addTableFills(new Column("updated_at", FieldFill.INSERT_UPDATE))
                        // 格式化文件名称。
                        // 如果不设置，如表[t_user]的实体类名是[TUser]。设置成下面这样，将是[TUserEntity]
                        //.formatFileName("%sEntity")
                        
                        // 阶段2：Mapper策略配置
                        .mapperBuilder()
                        // 继承哪个父类
                        .superClass(BaseMapper.class)
                        // 开启 @Mapper 注解。
                        // 会在mapper接口上添加注解[@Mapper]
                        .enableMapperAnnotation()
                        // 启用 BaseResultMap 生成。
                        // 会在mapper.xml文件生成[通用查询映射结果]配置。
                        .enableBaseResultMap()
                        // 启用 BaseColumnList。
                        // 会在mapper.xml文件生成[通用查询结果列 ]配置
                        .enableBaseColumnList()
                        // 设置缓存实现类
                        // .cache(MyMapperCache.class)
                        // 格式化 mapper 文件名称。
                        // 如果不设置，如表[t_user]，默认的文件名是[TUserMapper]。写成下面这种形式后，将变成[TUserDao]。
                        // .formatMapperFileName("%sDao")
                        // 格式化 xml 实现类文件名称。
                        // 如果不设置，如表[t_user]，默认的文件名是[TUserMapper.xml]，写成下面这种形式后，将变成[TUserXml.xml]。
                        // .formatXmlFileName("%sXml")
                        
                        // 阶段3：Service策略配置
                        .serviceBuilder()
                        // 设置 service 接口父类
                        // .superServiceClass(BaseService.class)
                        // 设置 service 实现类父类
                        // .superServiceImplClass(BaseServiceImpl.class)
                        // 格式化 service 接口文件名称
                        // 如果不设置，如表[t_user]，默认的是[ITUserService]。写成下面这种形式后，将变成[tUserService]。
                        .formatServiceFileName("%sService")
                        // 格式化 service 实现类文件名称
                        // 如果不设置，如表[t_user]，默认的是[TUserServiceImpl]。
                        .formatServiceImplFileName("%sServiceImpl")
                        
                        // 阶段4：Controller策略配置
                        .controllerBuilder()
                        // 设置父类。
                        // 会集成此父类。
                        // .superClass(BaseController.class)
                        // 会在控制类中加[@RestController]注解。
                        .enableRestStyle()
                        // 开启驼峰转连字符
                        .enableHyphenStyle()
                        // 格式化 Controller文件名称
                        .formatFileName("%sController")
                        
                        // 最后：构建
                        .build())
                
                //模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                //.templateEngine(new BeetlTemplateEngine())
                .templateEngine(new FreemarkerTemplateEngine())
                
                // 执行
                .execute();
    }
    
    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
    
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入").append(tip).append("：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}



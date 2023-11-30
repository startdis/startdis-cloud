package com.startdis.comm.swagger.aspect;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.startdis.comm.core.constant.HeaderConstant;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableKnife4j
@EnableSwagger2
@EnableAutoConfiguration
@ConditionalOnProperty(name = "swagger.enabled", matchIfMissing = true)
public class SwaggerAutoConfiguration {
    @Bean(value = "restApi")
    @Order(value = 1)
    public Docket groupRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(groupApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.startdis"))
                .paths(PathSelectors.any())
                .build()
                .globalRequestParameters(setHeaderParam());
    }

    private ApiInfo groupApiInfo() {
        return new ApiInfoBuilder()
                .title("Startdis Cloud Swagger")
                .description("<div style='font-size:14px;color:red;'>Startdis RESTful APIs</div>")
                .termsOfServiceUrl("https://startdis.com/")
                .contact(new Contact("点九科技","https://dianjiu.cc","startdis@dianjiu.cc"))
                .version("1.0")
                .build();
    }

    /**
     * JWT token
     */
    private List<RequestParameter> setHeaderParam() {
        List<RequestParameter> pars = new ArrayList<>();
        RequestParameterBuilder serviceType = new RequestParameterBuilder();
        serviceType.name(HeaderConstant.X_SERVICE_TYPE).description("公共-服务类型").in(ParameterType.HEADER).required(false).build();
        RequestParameterBuilder groupTenantId = new RequestParameterBuilder();
        groupTenantId.name(HeaderConstant.X_GROUP_TENANT_ID).description("公共-集团租户Id").in(ParameterType.HEADER).required(false).build();
        RequestParameterBuilder companyTenantId = new RequestParameterBuilder();
        companyTenantId.name(HeaderConstant.X_COMPANY_TENANT_ID).description("公共-公司租户Id").in(ParameterType.HEADER).required(false).build();

        RequestParameterBuilder uniqueId = new RequestParameterBuilder();
        uniqueId.name(HeaderConstant.X_UNIQUE_ID).description("公共-用户唯一ID").in(ParameterType.HEADER).required(false).build();
        RequestParameterBuilder authToken = new RequestParameterBuilder();
        authToken.name(HeaderConstant.X_ACCESS_TOKEN).description("公共-用户鉴权Token").in(ParameterType.HEADER).required(false).build();
        RequestParameterBuilder distinctId = new RequestParameterBuilder();
        distinctId.name(HeaderConstant.X_DISTINCT_ID).description("公共-设备唯一标识").in(ParameterType.HEADER).required(false).build();

        RequestParameterBuilder permissionScope = new RequestParameterBuilder();
        permissionScope.name(HeaderConstant.X_PERMISSION_SCOPE).description("B端-权限类型").in(ParameterType.HEADER).required(false).build();
        RequestParameterBuilder companyIds = new RequestParameterBuilder();
        companyIds.name(HeaderConstant.X_COMPANY_IDS).description("B端-公司ID集合").in(ParameterType.HEADER).required(false).build();
        //companyIds.name(HeaderConstant.X_COMPANY_IDS).description("B端-公司ID集合").defaultValue("company").modelRef(new ModelRef("string")).parameterType("header").required(false).build();


        pars.add(serviceType.build());
        pars.add(groupTenantId.build());
        pars.add(companyTenantId.build());
        pars.add(uniqueId.build());
        pars.add(distinctId.build());
        pars.add(authToken.build());
        pars.add(distinctId.build());
        pars.add(permissionScope.build());
        pars.add(companyIds.build());
        return pars;
    }
}

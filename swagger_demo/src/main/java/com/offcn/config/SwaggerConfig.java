package com.offcn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerConfig
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/18 22:03
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //接口所在controller包路径
                .apis(RequestHandlerSelectors.basePackage("com.offcn.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    //文档的说明对象
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springBoot中项目生成的接口文档")
                .description("java程序员必备技能")
                .termsOfServiceUrl("http://www.ujiuye.com/")
                .contact("guoxin")
                .version("1.0")
                .build();
    }
}

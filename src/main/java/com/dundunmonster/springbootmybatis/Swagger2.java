/*
* 文件名: com.dundunmonster.springbootmybatis
* 文件编号: 
* 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
* 描述: 
* 创建人: ghaoxiang
* 创建时间: 2019年01月07日 15:13
* 修改人:
* 修改时间: 2019年01月07日 15:13
* 修改变更号: 
* 修改内容: 
*/
package com.dundunmonster.springbootmybatis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ghaoxiang
 * @version V1.0
 * @Title Swagger2
 * @Description
 * @date 2019年01月07日 15:13
 * @since V1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * 创建客户信息接口文档
     * @return
     */
    @Bean
    public Docket createRestCusApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("cus")
                .apiInfo(createCusApiInfo())
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.dundunmonster.springbootmybatis.cus"))
                .build();
    }

    /**
     * 创建客户信息接口信息
     * @return
     */
    private ApiInfo createCusApiInfo(){
        return new ApiInfoBuilder()
                .title("客户信息接口")
                .description("与客户所有相关操作接口")
                .contact(new Contact("ghaoxiangzZ","https://github.com/ghaoxiangzZ","784390929@qq.com"))
                .version("1.0")
                .build();
    }
}

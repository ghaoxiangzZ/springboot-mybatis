/*
* 文件名: com.dundunmonster.springbootmybatis
* 文件编号: 
* 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
* 描述: 
* 创建人: ghaoxiang
* 创建时间: 2019年01月07日 15:11
* 修改人:
* 修改时间: 2019年01月07日 15:11
* 修改变更号: 
* 修改内容: 
*/
package com.dundunmonster.springbootmybatis;

import java.util.Properties;

import org.springframework.context.annotation.Bean;

import com.github.pagehelper.PageInterceptor;

/**
 * @author ghaoxiang
 * @version V1.0
 * @Title MybatisConfig
 * @Description mybatis分页配置
 * @date 2019年01月07日 15:11
 * @since V1.0
 */
public class MybatisConfig {

    @Bean
    public PageInterceptor pageHelper() {
        // 创建分页拦截器
        PageInterceptor pageInterceptor = new PageInterceptor();
        // 创建分页配置
        Properties properties = new Properties();
        // 默认值为 false，该参数对使用 RowBounds 作为分页参数时有效。 当该参数设置为 true 时，会将 RowBounds 中的 offset 参数当成 pageNum 使用，可以用页码和页面大小两个参数进行分页。
        properties.setProperty("offsetAsPageNum","true");
        // 默认值为false，该参数对使用 RowBounds 作为分页参数时有效。 当该参数设置为true时，使用 RowBounds 分页会进行 count 查询。
        properties.setProperty("rowBoundsWithCount","true");
        // 分页合理化参数，默认值为false。当该参数设置为 true 时，pageNum<=0 时会查询第一页， pageNum>pages（超过总数时），会查询最后一页。默认false 时，直接根据参数进行查询。
        properties.setProperty("reasonable","true");
        // 设置分页参数
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}

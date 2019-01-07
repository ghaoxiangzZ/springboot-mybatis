/*
* 文件名: com.dundunmonster.springbootmybatis.rest
* 文件编号: 
* 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
* 描述: 
* 创建人: ghaoxiang
* 创建时间: 2019年01月07日 15:25
* 修改人:
* 修改时间: 2019年01月07日 15:25
* 修改变更号: 
* 修改内容: 
*/
package com.dundunmonster.springbootmybatis.rest;

/**
 * @author ghaoxiang
 * @version V1.0
 * @Title DefaultStatusEnum
 * @Description 默认状态码枚举类
 * @date 2019年01月07日 15:25
 * @since V1.0
 */
public enum DefaultStatusEnum {

    SUC("S", "success"),
    ERROR("E","error"),
    SERVER_ERROR("50000", "server error, please ask admin for help");

    private String code;

    private String name;

    private DefaultStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}

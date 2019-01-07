/*
* 文件名: com.dundunmonster.springbootmybatis.rest
* 文件编号: 
* 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
* 描述: 
* 创建人: ghaoxiang
* 创建时间: 2019年01月07日 15:24
* 修改人:
* 修改时间: 2019年01月07日 15:24
* 修改变更号: 
* 修改内容: 
*/
package com.dundunmonster.springbootmybatis.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ghaoxiang
 * @version V1.0
 * @Title AbsResponse
 * @Description 基本消息响应
 * @date 2019年01月07日 15:24
 * @since V1.0
 */
@ApiModel(value = "基本消息响应", description = "处理简单的消息")
public class AbsResponse {

    @ApiModelProperty(value = "消息编码", name = "code", dataType = "String")
    private String status;

    @ApiModelProperty(value = "简单消息", name = "message", dataType = "String")
    private String message;

    public AbsResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public AbsResponse() {
        this.status = DefaultStatusEnum.SUC.getCode();
        this.message = DefaultStatusEnum.SUC.getName();
    }

    public String getStatus() {
        return status;
    }

    public AbsResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public AbsResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}

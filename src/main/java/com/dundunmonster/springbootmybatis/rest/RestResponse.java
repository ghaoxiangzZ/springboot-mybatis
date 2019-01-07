/*
* 文件名: com.dundunmonster.springbootmybatis.rest
* 文件编号: 
* 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
* 描述: 
* 创建人: ghaoxiang
* 创建时间: 2019年01月07日 15:27
* 修改人:
* 修改时间: 2019年01月07日 15:27
* 修改变更号: 
* 修改内容: 
*/
package com.dundunmonster.springbootmybatis.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ghaoxiang
 * @version V1.0
 * @Title RestResponse
 * @Description 消息结果响应实体
 * @date 2019年01月07日 15:27
 * @since V1.0
 */
@ApiModel(value = "响应消息结果",description = "统一处理消息")
public class RestResponse extends AbsResponse{

    @ApiModelProperty(value = "复杂消息", name = "data", dataType = "Map")
    private Object data;

    public Object getData() {
        return data;
    }

    public RestResponse(String status, String message) {
        super(status, message);
    }

    public RestResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public RestResponse() {

    }
}

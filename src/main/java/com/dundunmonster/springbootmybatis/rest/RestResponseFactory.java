/*
* 文件名: com.dundunmonster.springbootmybatis.rest
* 文件编号: 
* 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
* 描述: 
* 创建人: ghaoxiang
* 创建时间: 2019年01月07日 15:28
* 修改人:
* 修改时间: 2019年01月07日 15:28
* 修改变更号: 
* 修改内容: 
*/
package com.dundunmonster.springbootmybatis.rest;

import java.util.Map;

/**
 * @author ghaoxiang
 * @version V1.0
 * @Title RestResponseFactory
 * @Description 消息响应工厂类
 * @date 2019年01月07日 15:28
 * @since V1.0
 */
public class RestResponseFactory {

    private RestResponseFactory(){}

    public static RestResponse getSucResponse(String message){
        return buildResponse(message);
    }

    public static RestResponse getSucResponse(Map<String,Object> data){
        return getResponse().setData(data);
    }

    public static RestResponse getSucResponse(Object obj){
        return getResponse().setData(obj);
    }

    public static RestResponse getSucResponse(String message, Object obj){
        RestResponse restResponse=getResponse();
        restResponse.setMessage(message);
        restResponse.setData(obj);
        return restResponse;
    }

    public static RestResponse getErrorResponse(String message){
        return buildResponse(DefaultStatusEnum.ERROR.getCode(), message);
    }

    private static RestResponse buildResponse(String message){
        RestResponse restResponse=new RestResponse();
        restResponse.setMessage(message);
        return restResponse;
    }

    public static RestResponse buildResponse(String status, String message){
        RestResponse restResponse=new RestResponse();
        restResponse.setStatus(status);
        restResponse.setMessage(message);
        return restResponse;
    }

    public static RestResponse buildResponse(String status, String message, Object data){
        RestResponse restResponse=new RestResponse();
        restResponse.setStatus(status);
        restResponse.setMessage(message);
        restResponse.setData(data);
        return restResponse;
    }

    private static RestResponse getResponse() {
        return new RestResponse();
    }
}

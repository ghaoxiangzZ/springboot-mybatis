/*
* 文件名: com.dundunmonster.springbootmybatis.cus.domain
* 文件编号: 
* 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
* 描述: 
* 创建人: ghaoxiang
* 创建时间: 2019年01月07日 15:19
* 修改人:
* 修改时间: 2019年01月07日 15:19
* 修改变更号: 
* 修改内容: 
*/
package com.dundunmonster.springbootmybatis.cus.domain;

import java.util.Date;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author ghaoxiang
 * @version V1.0
 * @Title CusBaseInfo
 * @Description
 * @date 2019年01月07日 15:19
 * @since V1.0
 */
@Api(value = "客户基础信息",description = "客户基础信息")
@Alias(value = "CusBaseInfo")
public class CusBaseInfo {

    @ApiModelProperty(value = "客户ID", name = "cusId", dataType = "String", readOnly = true)
    private String cusId;

    @ApiModelProperty(value = "客户编码", name = "cusCode", dataType = "String", readOnly = true)
    private String cusCode;

    @ApiModelProperty(value = "客户名称", name = "cusName", dataType = "String", readOnly = true)
    private String cusName;

    @ApiModelProperty(value = "客户简称", name = "cusAbbr", dataType = "String")
    private String cusAbbr;

    @ApiModelProperty(value = "客户地址", name = "address", dataType = "String")
    private String address;

    @ApiModelProperty(value = "创建时间", name = "crtTime", dataType = "java.sql.Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date crtTime;


    public CusBaseInfo() {
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAbbr() {
        return cusAbbr;
    }

    public void setCusAbbr(String cusAbbr) {
        this.cusAbbr = cusAbbr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }
}

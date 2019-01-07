/*
* 文件名: com.dundunmonster.springbootmybatis.cus.controller
* 文件编号: 
* 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
* 描述: 
* 创建人: ghaoxiang
* 创建时间: 2019年01月07日 15:18
* 修改人:
* 修改时间: 2019年01月07日 15:18
* 修改变更号: 
* 修改内容: 
*/
package com.dundunmonster.springbootmybatis.cus.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dundunmonster.springbootmybatis.cus.domain.CusBaseInfo;
import com.dundunmonster.springbootmybatis.cus.service.CusBaseInfoService;
import com.dundunmonster.springbootmybatis.rest.RestResponse;
import com.dundunmonster.springbootmybatis.rest.RestResponseFactory;

/**
 * @author ghaoxiang
 * @version V1.0
 * @Title CusBaseInfoController
 * @Description
 * @date 2019年01月07日 15:18
 * @since V1.0
 */
@RestController
@RequestMapping(value = "/cus")
@Api(value = "客户基础信息控制接口", description = "处理客户基础信息")
public class CusBaseInfoController {

    @Autowired
    private CusBaseInfoService cusBaseInfoService;

    /**
     * 获取所有客户基础信息
     * @return
     */
    @RequestMapping(value = "/all/{page}/{size}", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有客户信息", notes = "获取所有客户信息")
    RestResponse getAllCusBaseInfo(CusBaseInfo cusBaseInfo,
                                   @ApiParam(value = "当前页",name = "page",defaultValue = "1") @PathVariable("page") int currentPage,
                                   @ApiParam(value = "每页显示数量",defaultValue = "2") @PathVariable("size") int pageSize){
        return cusBaseInfoService.getAllCusBaseInfo(cusBaseInfo, currentPage, pageSize);
    }

    /**
     * 保存客户基础信息
     * @param cusBaseInfo 客户基础信息
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存客户信息", notes = "保存客户信息")
    RestResponse saveCusBaseInfo(@ApiParam(value = "客户信息", name = "cusBaseInfo") CusBaseInfo cusBaseInfo){
        return cusBaseInfoService.saveCusBaseInfo(cusBaseInfo);
    }

    /**
     * 根据客户ID获取客户基础信息
     * @param cusId 客户ID
     * @return
     */
    @RequestMapping(value = "/get/{cusId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据客户ID获取客户信息", notes = "根据客户ID获取客户信息")
    @ApiImplicitParam(value = "客户ID", name = "cusId", required = true, dataType = "String", paramType = "path")
    RestResponse getCusBaseInfoById(@PathVariable("cusId")  String cusId){
        return cusBaseInfoService.getCusBaseInfoById(cusId);
    }

    /**
     * 修改客户基础信息
     * @param cusBaseInfo 客户基础信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ApiOperation(value = "更新客户信息", notes = "根据客户ID更新客户信息")
    RestResponse updateCusBaseInfo(@ApiParam(value = "客户信息", name = "cusBaseInfo") CusBaseInfo cusBaseInfo){
        return cusBaseInfoService.updateCusBaseInfo(cusBaseInfo);
    }

    /**
     * 根据客户ID删除客户信息
     * @param cusId 客户ID
     * @return
     */
    @RequestMapping(value = "/delete/{cusId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除客户基础信息", notes = "根据客户ID删除基础信息")
    @ApiImplicitParam(value = "客户ID", name = "cusId", dataType = "String", paramType = "path", required = true)
    RestResponse deleteCusBaseInfo(@PathVariable(value = "cusId") String cusId){
        return cusBaseInfoService.deleteCusBaseInfo(cusId);
    }

    /**
     * 批量删除客户信息
     * @param cusIds 客户ID
     * @return
     */
    @RequestMapping(value = "/delete/batch/{cusIds}", method = RequestMethod.DELETE)
    @ApiOperation(value = "批量删除客户基础信息", notes = "根据客户ID批量删除基础信息")
    @ApiImplicitParam(value = "客户ID", name = "cusIds", dataType = "String", paramType = "path", required = true)
    RestResponse deleteBatchCusBaseInfo(@PathVariable(value = "cusIds") String cusIds){
        return cusBaseInfoService.deleteBatchCusBaseInfo(cusIds.split(","));
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ApiOperation(value = "测试")
    RestResponse getTest(@RequestParam String id, @RequestParam String itemCode, @RequestParam String softwareCode){
        List<Map<String,Object>> list = new ArrayList<>();
        String[] ids = id.split(",");
        String[] itemCodes = itemCode.split(",");
        String[] softwareCodes = softwareCode.split(",");
        for(int i = 0; i < ids.length; i++){
            Map<String,Object> map = new HashMap<>(5);
            map.put("id", ids[i]);
            map.put("itemCode", itemCodes[i]);
            map.put("softwareCode", softwareCodes[i]);
            map.put("is_sw_standard", "是");
            map.put("operate_system", "WINDOW10 OP");
            list.add(map);
        }
        return RestResponseFactory.getSucResponse(list);
    }
}

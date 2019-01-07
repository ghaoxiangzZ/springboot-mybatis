/*
* 文件名: com.dundunmonster.springbootmybatis.cus.service.impl
* 文件编号: 
* 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
* 描述: 
* 创建人: ghaoxiang
* 创建时间: 2019年01月07日 15:34
* 修改人:
* 修改时间: 2019年01月07日 15:34
* 修改变更号: 
* 修改内容: 
*/
package com.dundunmonster.springbootmybatis.cus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dundunmonster.springbootmybatis.cus.domain.CusBaseInfo;
import com.dundunmonster.springbootmybatis.cus.mapper.CusBaseInfoMapper;
import com.dundunmonster.springbootmybatis.cus.service.CusBaseInfoService;
import com.dundunmonster.springbootmybatis.rest.RestResponse;
import com.dundunmonster.springbootmybatis.rest.RestResponseFactory;
import com.dundunmonster.springbootmybatis.util.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author ghaoxiang
 * @version V1.0
 * @Title CusBaseInfoServiceImpl
 * @Description
 * @date 2019年01月07日 15:34
 * @since V1.0
 */
@Service
public class CusBaseInfoServiceImpl implements CusBaseInfoService {

    @Autowired
    private CusBaseInfoMapper cusBaseInfoMapper;

    @Override
    public RestResponse getAllCusBaseInfo(CusBaseInfo cusBaseInfo, int currentPage, int pageSize) {
        // 设置分页
        PageHelper.startPage(currentPage, pageSize);
        List<CusBaseInfo> cusBaseInfoList = cusBaseInfoMapper.getAllCusBaseInfo(cusBaseInfo);
        return RestResponseFactory.getSucResponse(new PageBean<>(new PageInfo<>(cusBaseInfoList)));
    }

    @Override
    public RestResponse saveCusBaseInfo(CusBaseInfo cusBaseInfo) {
        // 根据客户名称获取客户信息
        CusBaseInfo oldCusBaseInfo = cusBaseInfoMapper.getCusBaseInfoByName(cusBaseInfo.getCusName());
        if(null != oldCusBaseInfo){
            return RestResponseFactory.getErrorResponse("客户【" + cusBaseInfo.getCusName() + "】已存在！");
        }
        // 保存客户信息
        int result = cusBaseInfoMapper.saveCusBaseInfo(cusBaseInfo);
        if(result > 0){
            return RestResponseFactory.getSucResponse(cusBaseInfo);
        }
        return RestResponseFactory.getErrorResponse("客户【" + cusBaseInfo.getCusName() + "】保存失败！");
    }

    @Override
    public RestResponse getCusBaseInfoById(String cusId) {
        return RestResponseFactory.getSucResponse(cusBaseInfoMapper.getCusBaseInfoById(cusId));
    }

    @Override
    public RestResponse updateCusBaseInfo(CusBaseInfo cusBaseInfo) {
        // 检查客户是否存在
        CusBaseInfo oldCusBaseInfo = cusBaseInfoMapper.getCusBaseInfoById(cusBaseInfo.getCusId());
        if(null == oldCusBaseInfo){
            return RestResponseFactory.getErrorResponse("客户【" + cusBaseInfo.getCusName() + "】不存在！");
        }
        // 更新客户信息
        int result = cusBaseInfoMapper.updateCusBaseInfo(cusBaseInfo);
        if(result > 0){
            return RestResponseFactory.getSucResponse("更新成功！");
        }
        return RestResponseFactory.getErrorResponse("更新失败！");
    }

    @Override
    public RestResponse deleteCusBaseInfo(String cusId) {
        int result = cusBaseInfoMapper.deleteCusBaseInfo(cusId);
        return result > 0 ? RestResponseFactory.getSucResponse("删除成功！") : RestResponseFactory.getErrorResponse("删除失败！");
    }

    @Override
    public RestResponse deleteBatchCusBaseInfo(String[] cusIds) {
        int result = cusBaseInfoMapper.deleteBatchCusBaseInfo(cusIds);
        return result > 0 ? RestResponseFactory.getSucResponse("删除成功！") : RestResponseFactory.getErrorResponse("删除失败！");
    }
}

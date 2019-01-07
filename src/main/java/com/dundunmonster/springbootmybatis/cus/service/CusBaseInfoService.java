/*
* 文件名: com.dundunmonster.springbootmybatis.cus.service
* 文件编号: 
* 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
* 描述: 
* 创建人: ghaoxiang
* 创建时间: 2019年01月07日 15:23
* 修改人:
* 修改时间: 2019年01月07日 15:23
* 修改变更号: 
* 修改内容: 
*/
package com.dundunmonster.springbootmybatis.cus.service;

import com.dundunmonster.springbootmybatis.cus.domain.CusBaseInfo;
import com.dundunmonster.springbootmybatis.rest.RestResponse;

/**
 * @author ghaoxiang
 * @version V1.0
 * @Title CusBaseInfoService
 * @Description
 * @date 2019年01月07日 15:23
 * @since V1.0
 */
public interface CusBaseInfoService {

    /**
     * 获取所有客户基础信息
     * @param cusBaseInfo
     * @param currentPage
     * @param pageSize
     * @return
     */
    RestResponse getAllCusBaseInfo(CusBaseInfo cusBaseInfo, int currentPage, int pageSize);

    /**
     * 保存客户基础信息
     * @param cusBaseInfo 客户基础信息
     * @return
     */
    RestResponse saveCusBaseInfo(CusBaseInfo cusBaseInfo);

    /**
     * 根据客户ID获取客户基础信息
     * @param cusId 客户ID
     * @return
     */
    RestResponse getCusBaseInfoById(String cusId);

    /**
     * 修改客户基础信息
     * @param cusBaseInfo 客户基础信息
     * @return
     */
    RestResponse updateCusBaseInfo(CusBaseInfo cusBaseInfo);

    /**
     * 根据客户ID删除客户信息
     * @param cusId 客户ID
     * @return
     */
    RestResponse deleteCusBaseInfo(String cusId);

    /**
     * 批量删除客户信息
     * @param cusIds 客户ID
     * @return
     */
    RestResponse deleteBatchCusBaseInfo(String[] cusIds);
}

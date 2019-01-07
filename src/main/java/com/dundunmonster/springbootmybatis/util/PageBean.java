/*
* 文件名: com.dundunmonster.springbootmybatis.util
* 文件编号: 
* 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
* 描述: 
* 创建人: ghaoxiang
* 创建时间: 2019年01月07日 15:15
* 修改人:
* 修改时间: 2019年01月07日 15:15
* 修改变更号: 
* 修改内容: 
*/
package com.dundunmonster.springbootmybatis.util;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.github.pagehelper.PageInfo;

/**
 * @author ghaoxiang
 * @version V1.0
 * @Title PageBean
 * @Description
 * @date 2019年01月07日 15:15
 * @since V1.0
 */
@ApiModel(value = "分页信息", description = "分页信息")
public class PageBean<T> {

    @ApiModelProperty(value = "当前页数", name = "currentPage", dataType = "int")
    private int currentPage = 1;

    @ApiModelProperty(value = "每页显示数量", name = "pageSize", dataType = "int")
    private int pageSize = 10;

    @ApiModelProperty(value = "总数量", name = "totalNum", dataType = "long")
    private long totalNum;

    @ApiModelProperty(value = "总页数", name = "totalPageSize", dataType = "int")
    private int totalPageSize;

    private List<T> dataResult = new ArrayList<>();

    public PageBean(PageInfo<T> pageInfo) {
        this.currentPage = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.totalNum = pageInfo.getTotal();
        this.totalPageSize = pageInfo.getPages();
        this.dataResult = pageInfo.getList();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getTotalNum() {
        return totalNum;
    }

    public int getTotalPageSize() {
        return totalPageSize;
    }

    public List<T> getDataResult() {
        return dataResult;
    }
}

/*
* 文件名: com.dundunmonster.springbootmybatis.cus.mapper
* 文件编号: 
* 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
* 描述: 
* 创建人: ghaoxiang
* 创建时间: 2019年01月07日 15:22
* 修改人:
* 修改时间: 2019年01月07日 15:22
* 修改变更号: 
* 修改内容: 
*/
package com.dundunmonster.springbootmybatis.cus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dundunmonster.springbootmybatis.cus.domain.CusBaseInfo;

/**
 * @author ghaoxiang
 * @version V1.0
 * @Title CusBaseInfoMapper
 * @Description
 * @date 2019年01月07日 15:22
 * @since V1.0
 */
@Mapper
public interface CusBaseInfoMapper {

    /**
     * 获取所有客户信息
     * @param cusBaseInfo 客户基础信息
     * @return
     */
    @Select("select * from cus_base_info")
    List<CusBaseInfo> getAllCusBaseInfo(CusBaseInfo cusBaseInfo);

    /**
     * 保存客户基础信息
     * @param cusBaseInfo 客户基础信息
     * @return
     */
    @Insert("insert into cus_base_info(cus_id,cus_code,cus_name,cus_abbr,address,crt_time)" +
            " values(#{cusId},#{cusCode},#{cusName},#{cusAbbr},#{address},#{crtTime})")
    int saveCusBaseInfo(CusBaseInfo cusBaseInfo);

    /**
     * 根据客户ID获取客户基础信息
     * @param cusId 客户ID
     * @return
     */
    @Select("select * from cus_base_info where cus_id=#{cusId}")
    CusBaseInfo getCusBaseInfoById(String cusId);

    /**
     * 根据客户名称获取客户基础信息
     * @param cusName 客户名称
     * @return
     */
    @Select("select * from cus_base_info where cus_name=#{cusName}")
    CusBaseInfo getCusBaseInfoByName(String cusName);

    /**
     * 修改客户基础信息
     * @param cusBaseInfo 客户基础信息
     * @return
     */
    @Update("update cus_base_info set cus_code=#{cusCode,jdbcType=VARCHAR}," +
            "cus_name=#{cusName,jdbcType=VARCHAR}," +
            "cus_abbr=#{cusAbbr,jdbcType=VARCHAR}," +
            "address=#{address,jdbcType=VARCHAR}," +
            "crt_time=#{crtTime,jdbcType=DATE}" +
            "where cus_id=#{cusId,jdbcType=VARCHAR}")
    int updateCusBaseInfo(CusBaseInfo cusBaseInfo);

    /**
     * 根据客户ID删除客户信息
     * @param cusId 客户ID
     * @return
     */
    @Delete("delete from cus_base_info where cus_id=#{cusId}")
    int deleteCusBaseInfo(String cusId);

    /**
     * 批量删除客户信息
     * @param cusIds 客户ID
     * @return
     */
    @Delete("<script>"
                + "delete from cus_base_info where cus_id in"
                + "<foreach collection='array' item='id' open='(' separator=',' close=')'>"
                    + "#{id}"
                + "</foreach>"
            +"</script>")
    int deleteBatchCusBaseInfo(String[] cusIds);
}

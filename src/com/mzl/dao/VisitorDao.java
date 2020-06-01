package com.mzl.dao;

import com.mzl.po.Visitor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName :   VisitorDao
 * @Description: 访客
 * @Author: 21989
 * @CreateDate: 2020/6/1 15:53
 * @Version: 1.0
 */
public interface VisitorDao {

    //查询访客记录数
    public Integer totalCount(@Param("v_name") String v_name, @Param("v_phone") Integer v_phone);

    //查询访客信息
    public List<Visitor> getVisitorList(@Param("v_name") String v_name, @Param("v_phone") Integer v_phone, @Param("currentPage")Integer currentPage,  @Param("pageSize") Integer pageSize);

    //添加访客
    public int addVisitor(Visitor visitor);

    //导出Excel
    public List<Visitor> getAll();
}

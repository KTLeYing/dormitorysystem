package com.mzl.dao;

import com.mzl.po.Dormitory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Dao层
 */
public interface DormitoryDao {

    //查询总记录数
    public Integer totalCount(@Param("a_name") String a_name, @Param("s_dormitoryid") Integer s_dormitoryid, @Param("d_dormbuilding") String d_dormbuilding);

    //获取宿舍的信息
    public List<Dormitory> getDormitoryList(@Param("a_name") String a_name, @Param("s_dormitoryid") Integer s_dormitoryid, @Param("d_dormbuilding") String d_dormbuilding, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    //添加宿舍
    public int addDormitory(Dormitory dormitory);

    //查找宿舍
    public Dormitory findDormitoryById(Integer d_id);

    //修改宿舍信息
    public int updateDormitory(Dormitory dormitory);

    //删除宿舍信息
    public int deleteDormitory(Integer d_id);

    //导出Excel
    public List<Dormitory> getAll();

    //查询宿舍的所有人员信息
    public List<Dormitory> findDormitoryStudent(Dormitory dormitory);
}

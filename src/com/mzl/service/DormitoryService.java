package com.mzl.service;

import com.mzl.po.Dormitory;
import com.mzl.po.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Service层接口
 */
public interface DormitoryService {

    //分页查询
    public PageInfo<Dormitory> findPageInfo(String a_name, Integer s_dormitoryid,String d_dormbuilding, Integer pageIndex, Integer pageSize);

    //添加宿舍信息
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

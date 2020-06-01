package com.mzl.dao;

import com.mzl.po.DormClean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 宿舍卫生
 * @author: Joyrocky
 * @create: 2019-04-24 14:37
 **/
public interface DormCleanDao {

    /**
     * 进行分页查询
     */
    //获取总条数
    public Integer totalCount(@Param("d_id") Integer d_id, @Param("d_dormbuilding") String d_dormbuilding);

    //查询每一位内容
    public List<DormClean> getDormCleanList(@Param("d_id") Integer d_id, @Param("d_dormbuilding") String d_dormbuilding, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    //添加宿舍卫生信息
    public int addDormClean(DormClean dormclean);

    //查找宿舍卫生
    public DormClean findDormCleanById(Integer g_id);

    //修改卫生信息
    public int updateDormClean(DormClean dormclean);

    //删除宿舍卫生
    public int deleteDormClean(Integer g_id);

    //导出Excel
    public List<DormClean> getAll();
}

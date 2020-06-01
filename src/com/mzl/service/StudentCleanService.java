package com.mzl.service;

import com.mzl.po.PageInfo;
import com.mzl.po.StudentClean;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 学生卫生服务接口
 * @author: Joyrocky
 * @create: 2019-04-25 12:15
 **/
public interface StudentCleanService {

    //分页查询
    public PageInfo<StudentClean> findPageInfo(Integer s_studentid, String s_name, Integer s_dormitoryid, Integer pageIndex, Integer pageSize);

    //添加学生卫生
    public int addStudentClean(StudentClean studentClean);

    //查询学生卫生
    public StudentClean findStudentCleanById(Integer g_id);

    //修改学生卫生
    public int updateStudentClean(StudentClean studentclean);

    //删除学生卫生
    public int deleteStudentClean(Integer g_id);

    //导出Excel
    public List<StudentClean> getAll();
}

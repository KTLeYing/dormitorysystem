package com.mzl.dao;

import com.mzl.po.StudentClean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 学生卫生
 * @author: Joyrocky
 * @create: 2019-04-25 12:14
 **/
public interface StudentCleanDao {

    //查询总记录数
    public Integer totalCount(@Param("s_studentid") Integer s_studentid, @Param("s_name") String s_name, @Param("s_dormitoryid") Integer s_dormitoryid);

    //获取用户列表
    public List<StudentClean> getStudentCleanList(@Param("s_studentid") Integer s_studentid, @Param("s_name") String s_name, @Param("s_dormitoryid") Integer s_dormitoryid, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

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

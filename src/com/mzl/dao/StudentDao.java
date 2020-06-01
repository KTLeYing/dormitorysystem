package com.mzl.dao;

import com.mzl.po.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员DAO层接口
 */
public interface StudentDao {
    //获取总条数
    public Integer totalCount(@Param("s_name") String s_name, @Param("s_studentid")Integer s_studentid, @Param("s_classid")Integer s_classid, @Param("s_classname")String s_classname);

    //获取用户列表
    public List<Student> getStudentList(@Param("s_name") String s_name, @Param("s_studentid")Integer s_studentid,@Param("s_classid")Integer s_classid, @Param("s_classname")String s_classname, @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    //添加学生
    public int addStudent(Student student);

    //修改学生
    public int updateStudent(Student student);

    //查找学生
    public Student findStudentById(Integer s_id);

    //删除学生
    public int deleteStudent(Integer s_id);

    //获取所有学生
    public List<Student> getAll();
}

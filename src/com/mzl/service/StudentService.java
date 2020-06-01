package com.mzl.service;

import com.mzl.po.PageInfo;
import com.mzl.po.Student;

import java.util.List;

public interface StudentService {

    //分页查询
    public PageInfo<Student> findPageInfo(String s_name, Integer s_studentid, Integer s_classid, String s_classname, Integer pageIndex, Integer pageSize);

    //添加学生信息
    public int addStudent(Student student);

    //修改学生信息
    public int updateStudent(Student student);

    //查找学生
    public Student findStudentById(Integer s_id);

    //删除学生信息
    public int deleteStudent(Integer s_id);

    //获取所有学生
    public List<Student> getAll();
}

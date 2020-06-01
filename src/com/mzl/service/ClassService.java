package com.mzl.service;

import com.mzl.po.Class;
import com.mzl.po.Class1;
import com.mzl.po.PageInfo;
import com.mzl.po.Student;

import java.util.List;

public interface ClassService {

    //分页查询
    public PageInfo<Class> findPageInfo(String c_classname, String c_counsellor, Integer c_classid, Integer pageIndex, Integer pageSize);

    //添加班级信息
    public int addClass(Class uclass);

    //查找班级信息
    public Class findClassById(Integer c_id);

    //修改班级
    public int updateClass(Class uclass);

    //删除班级信息
    public int deleteClass(Integer c_id);

    //导出Excel
    public List<Class> getAll();

    //查询班级的学生信息
    public List<Class> findClassStudent(Class uclass);
}

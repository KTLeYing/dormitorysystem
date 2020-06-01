package com.mzl.dao;

import com.mzl.po.Class;
import com.mzl.po.Class1;
import com.mzl.po.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员DAO层接口
 */
public interface ClassDao {

    /**
     * 进行分页查询
     */
    //获取总条数
    public Integer totalCount(@Param("c_classname") String c_classname, @Param("c_classid") Integer c_classid, @Param("c_counsellor") String c_counsellor);


    //获取班级信息列表
    public List<Class> getClassList(@Param("c_classname") String c_classname, @Param("c_classid") Integer c_classid, @Param("c_counsellor") String c_counsellor, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    //添加班级信息
    public int addClass(Class uclass);

    //查询班级
    public Class findClassById(Integer c_id);

    //修改班级信息
    public int updateClass(Class uclass);

    //删除班级信息
    public int deleteClass(Integer c_id);

    //获取所有班级
    public List<Class> getAll();

    //查询班级的学生信息
    public List<Class> findClassStudent(Class uclass);

}

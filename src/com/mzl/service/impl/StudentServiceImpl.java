package com.mzl.service.impl;

import com.mzl.dao.StudentDao;
import com.mzl.po.PageInfo;
import com.mzl.po.Student;
import com.mzl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service接口实现类
 */
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

    // 注入studentDao
    @Autowired
    private StudentDao studentDao;

    //分页查询
    @Override
    public PageInfo<Student> findPageInfo(String s_name, Integer s_studentid,Integer s_classid, String s_classname, Integer pageIndex, Integer pageSize) {
        PageInfo<Student> pi = new PageInfo<Student>();

        if (pageIndex == null){
            System.out.println("yyyyy");
            pi.setPageIndex(1);
        }else {
             pi.setPageIndex(pageIndex);
        }

        if (pageSize == null){
            pi.setPageSize(3);
        }else {
            pi.setPageSize(pageSize);
        }

        //获取总条数
        Integer totalCount = studentDao.totalCount(s_name,s_studentid,s_classid,s_classname);
        System.out.println(totalCount);

        //设置总页数
        if (totalCount % pi.getPageSize() == 0){
            pi.setPageTotalCount(totalCount / pi.getPageSize());
        }else {
            pi.setPageTotalCount(totalCount / pi.getPageSize() + 1);
        }
        System.out.println(pi.getPageTotalCount());

        if (totalCount > 0){
            System.out.println(s_name);
            System.out.println(s_studentid);
            System.out.println(s_classid);
            System.out.println(s_classname);
            System.out.println((pi.getPageIndex()-1)*pi.getPageSize());
            System.out.println( pi.getPageSize());
            pi.setTotalCount(totalCount);
            //每一页显示学生信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Student> studentList =	studentDao.getStudentList(s_name,s_studentid,s_classid,s_classname, (pi.getPageIndex()-1)*pi.getPageSize(), pi.getPageSize());
            pi.setList(studentList);
        }
        return pi;
    }

    //添加学生信息
    @Override
    public int addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    //修改学生信息
    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    //查找学生
    @Override
    public Student findStudentById(Integer s_id) {
        return studentDao.findStudentById(s_id);
    }

    //删除学生信息
    @Override
    public int deleteStudent(Integer s_id) {
        return studentDao.deleteStudent(s_id);
    }

    //获取所有学生
    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }


}

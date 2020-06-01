package com.mzl.service.impl;

import com.mzl.dao.StudentCleanDao;
import com.mzl.po.PageInfo;
import com.mzl.po.StudentClean;
import com.mzl.service.StudentCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 学生卫生接口实现
 * @author: Joyrocky
 * @create: 2019-04-25 12:16
 **/
@Service("studentCleanService")
@Transactional
public class StudentCleanServiceImpl implements StudentCleanService {

    // classDao
    @Autowired
    private StudentCleanDao studentCleanDao;

    @Override
    public PageInfo<StudentClean> findPageInfo(Integer s_studentid, String s_name, Integer s_dormitoryid, Integer pageIndex, Integer pageSize) {
        PageInfo<StudentClean> pi = new PageInfo<StudentClean>();
        if (pageIndex == null){
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
        Integer totalCount = studentCleanDao.totalCount(s_studentid,s_name,s_dormitoryid);

        //设置总页数
        if (totalCount % pi.getPageSize() == 0){
            pi.setPageTotalCount(totalCount / pi.getPageSize());
        }else {
            pi.setPageTotalCount(totalCount / pi.getPageSize() + 1);
        }
        System.out.println(pi.getPageTotalCount());

        if (totalCount > 0){
            pi.setTotalCount(totalCount);
            //每一页显示宿舍信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<StudentClean> studentCleanList = studentCleanDao.getStudentCleanList(s_studentid,s_name,s_dormitoryid, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(studentCleanList);
        }

        return pi;
    }

    //添加学生卫生
    @Override
    public int addStudentClean(StudentClean studentClean) {
        return studentCleanDao.addStudentClean(studentClean);
    }

    //查找学生卫生
    @Override
    public StudentClean findStudentCleanById(Integer g_id) {
        return studentCleanDao.findStudentCleanById(g_id);
    }

    //修改学生卫生
    @Override
    public int updateStudentClean(StudentClean studentclean) {
        return studentCleanDao.updateStudentClean(studentclean);
    }

    //删除学生卫生
    @Override
    public int deleteStudentClean(Integer g_id) {
        return studentCleanDao.deleteStudentClean(g_id);
    }

    //导出Excel
    @Override
    public List<StudentClean> getAll() {
        return studentCleanDao.getAll();
    }


}

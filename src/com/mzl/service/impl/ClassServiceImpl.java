package com.mzl.service.impl;

import com.mzl.dao.ClassDao;
import com.mzl.po.Class;
import com.mzl.po.Class1;
import com.mzl.po.PageInfo;
import com.mzl.po.Student;
import com.mzl.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service接口实现类
 */
@Service("classService")
@Transactional
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    //分页查询
    @Override
    public PageInfo<Class> findPageInfo(String c_classname, String c_counsellor, Integer c_classid, Integer pageIndex, Integer pageSize) {
        PageInfo<Class> pi = new PageInfo<Class>();
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
        Integer totalCount = classDao.totalCount(c_classname,c_classid,c_counsellor);
        System.out.println(totalCount);

        //设置总页数
        if (totalCount % pi.getPageSize() == 0){
            pi.setPageTotalCount(totalCount / pi.getPageSize());
        }else {
            pi.setPageTotalCount(totalCount / pi.getPageSize() + 1);
        }
        System.out.println(pi.getPageTotalCount());

        if (totalCount > 0){
            System.out.println(c_classname);
            System.out.println(c_classid);
            System.out.println(c_counsellor);

            pi.setTotalCount(totalCount);
            //每一页显示班级信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Class> classList =	classDao.getClassList(c_classname,c_classid,c_counsellor, (pi.getPageIndex()-1)*pi.getPageSize(), pi.getPageSize());
            pi.setList(classList);
        }
        return pi;
    }

    //添加班级信息
    @Override
    public int addClass(Class uclass) {
        return classDao.addClass(uclass);
    }

    //查找班级信息
    @Override
    public Class findClassById(Integer c_id) {
        return classDao.findClassById(c_id);
    }

    //修改班级
    @Override
    public int updateClass(Class uclass) {
        return classDao.updateClass(uclass);
    }

    //删除班级信息
    @Override
    public int deleteClass(Integer c_id) {
        return classDao.deleteClass(c_id);
    }

    //导出数据
    @Override
    public List<Class> getAll() {
        return classDao.getAll();
    }

    //查询班级的学生信息
    @Override
    public List<Class> findClassStudent(Class uclass) {
        return classDao. findClassStudent(uclass);
    }


}

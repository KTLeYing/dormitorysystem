package com.mzl.service.impl;

import com.mzl.dao.VisitorDao;
import com.mzl.po.PageInfo;
import com.mzl.po.Visitor;
import com.mzl.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName :   VisitorServiceImpl
 * @Description: 访客接口实现
 * @Author: 21989
 * @CreateDate: 2020/6/1 15:53
 * @Version: 1.0
 */
@Service("visitorService")
@Transactional
public class VisitorServiceImpl implements VisitorService {

    // 注入studentDao
    @Autowired
    private VisitorDao visitorDao;

    //分页查询
    @Override
    public PageInfo<Visitor> findPageInfo(String v_name, Integer v_phone, Integer pageIndex, Integer pageSize) {
        PageInfo<Visitor> pi = new PageInfo<Visitor>();

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
        Integer totalCount = visitorDao.totalCount(v_name, v_phone);

        //设置总页数
        if (totalCount % pi.getPageSize() == 0){
            pi.setPageTotalCount(totalCount / pi.getPageSize());
        }else {
            pi.setPageTotalCount(totalCount / pi.getPageSize() + 1);
        }
        System.out.println(pi.getPageTotalCount());

        if (totalCount > 0){
            pi.setTotalCount(totalCount);
            //每一页显示学生信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Visitor> visitorList = visitorDao.getVisitorList(v_name,v_phone, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(visitorList);
        }

        return pi;
    }

    //添加访客
    @Override
    public int addVisitor(Visitor visitor) {
        return visitorDao.addVisitor(visitor);
    }

    //导出Excel
    @Override
    public List<Visitor> getAll() {
        return visitorDao.getAll();
    }


}

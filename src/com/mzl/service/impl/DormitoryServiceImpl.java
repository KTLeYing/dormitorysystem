package com.mzl.service.impl;

import com.mzl.dao.DormitoryDao;
import com.mzl.po.Dormitory;
import com.mzl.po.PageInfo;
import com.mzl.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service接口实现类
 */
@Service("dormitoryService")
@Transactional
public class DormitoryServiceImpl implements DormitoryService {

    // classDao
    @Autowired
    private DormitoryDao dormitoryDao;

    //分页查询
    @Override
    public PageInfo<Dormitory> findPageInfo(String a_name, Integer s_dormitoryid, String d_dormbuilding, Integer pageIndex, Integer pageSize) {
        PageInfo<Dormitory> pi = new PageInfo<Dormitory>();
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
        Integer totalCount = dormitoryDao.totalCount(a_name,s_dormitoryid,d_dormbuilding);

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
            List<Dormitory> dormitoryList = dormitoryDao.getDormitoryList(a_name,s_dormitoryid,d_dormbuilding, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(dormitoryList);
        }
        return pi;
    }

    //添加宿舍信息
    @Override
    public int addDormitory(Dormitory dormitory) {
        return dormitoryDao.addDormitory(dormitory);
    }

    //查找宿舍
    @Override
    public Dormitory findDormitoryById(Integer d_id) {
        return dormitoryDao.findDormitoryById(d_id);
    }

    //修改宿舍信息
    @Override
    public int updateDormitory(Dormitory dormitory) {
        return dormitoryDao.updateDormitory(dormitory);
    }

    //删除宿舍信息
    @Override
    public int deleteDormitory(Integer d_id) {
        return dormitoryDao.deleteDormitory(d_id);
    }

    //导出Excel
    @Override
    public List<Dormitory> getAll() {
        return dormitoryDao.getAll();
    }

    //查询宿舍的人员信息
    @Override
    public List<Dormitory> findDormitoryStudent(Dormitory dormitory) {
        return dormitoryDao.findDormitoryStudent(dormitory);
    }


}

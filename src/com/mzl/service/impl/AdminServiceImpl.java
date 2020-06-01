package com.mzl.service.impl;

import com.mzl.dao.AdminDao;
import com.mzl.po.Admin;
import com.mzl.po.PageInfo;
import com.mzl.po.StudentClean;
import com.mzl.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service接口实现类
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

    // 注入UserDao
    @Autowired
    private AdminDao adminDao;

    //管理登陆查询
    @Override
    public Admin findAdmin(Admin admin) {
        Admin a = adminDao.findAdmin(admin);
        return a;
    }

    //分页查询
    @Override
    public PageInfo<Admin> findPageInfo(String a_username, String a_describe, Integer a_id, Integer pageIndex, Integer pageSize) {
        PageInfo<Admin> pi = new PageInfo<Admin>();
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
        Integer totalCount = adminDao.totalCount(a_username, a_describe, a_id);

        //设置总页数
        if (totalCount % pi.getPageSize() == 0){
            pi.setPageTotalCount(totalCount / pi.getPageSize());
        }else {
            pi.setPageTotalCount(totalCount / pi.getPageSize() + 1);
        }
        System.out.println(pi.getPageTotalCount());

        if (totalCount > 0){
            pi.setTotalCount(totalCount);
            //每一页显示管理员信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Admin> adminList = adminDao.getAdminList(a_username, a_describe, a_id, (pi.getPageIndex()-1)*pi.getPageSize(), pi.getPageSize());
            pi.setList(adminList);
        }
        return pi;
    }

    //添加管理员
    @Override
    public int addAdmin(Admin admin) {
        return adminDao.addAdmin(admin);
    }

    //查找管理员
    @Override
    public Admin findAdminById(Integer a_id) {
        return adminDao.findAdminById(a_id);
    }

    //修改管理员信息
    @Override
    public int updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    //删除管理员
    @Override
    public int deleteAdmin(Integer a_id) {
        return adminDao.deleteAdmin(a_id);
    }

    //导出Excel
    @Override
    public List<Admin> getAll() {
        return adminDao.getAll();
    }


}

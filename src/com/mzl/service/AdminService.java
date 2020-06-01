package com.mzl.service;

import com.mzl.po.Admin;
import com.mzl.po.PageInfo;

import java.util.List;

/**
 * 用户Service层接口
 */
public interface AdminService {

    // 通过账号和密码查询用户
    public Admin findAdmin(Admin admin);

    //分页查询
    public PageInfo<Admin> findPageInfo(String a_username, String a_describe, Integer a_id, Integer pageIndex, Integer pageSize);

    //添加管理员
    public int addAdmin(Admin admin);

    //查找管理员
    public Admin findAdminById(Integer a_id);

    //修改管理员信息
    public int updateAdmin(Admin admin);

    //删除管理员
    public int deleteAdmin(Integer a_id);

    //导出Excel
    public List<Admin> getAll();
}

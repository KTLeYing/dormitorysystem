package com.mzl.dao;

import com.mzl.po.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员DAO层接口
 */
public interface AdminDao {

    /**
     * 通过账号和密码查询管理员
     */
    public Admin findAdmin(Admin admin);

    //查询总记录数
    public Integer totalCount(@Param("a_username") String a_username, @Param("a_describe") String a_describe, @Param("a_id") Integer a_id);

    //分页查询
    public List<Admin> getAdminList(@Param("a_username") String a_username, @Param("a_describe") String a_describe, @Param("a_id") Integer a_id, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

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

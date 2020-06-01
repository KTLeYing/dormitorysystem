package com.mzl.service;

import com.mzl.po.PageInfo;
import com.mzl.po.Visitor;

import java.util.List;

/**
 * @InterfaceName :   VisitorService
 * @Description: 访客接口
 * @Author: 21989
 * @CreateDate: 2020/6/1 15:52
 * @Version: 1.0
 */
public interface VisitorService {

    //分页查询
    PageInfo<Visitor> findPageInfo(String v_name, Integer v_phone, Integer pageIndex, Integer pageSize);

    //添加访客
    public int addVisitor(Visitor visitor);

    //导出Excel
    public List<Visitor> getAll();
}

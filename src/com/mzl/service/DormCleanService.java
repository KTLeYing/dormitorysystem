package com.mzl.service;

import com.mzl.po.DormClean;
import com.mzl.po.PageInfo;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 宿舍卫生服务接口
 * @author: Joyrocky
 * @create: 2019-04-24 15:18
 **/
public interface DormCleanService {

    //分页查询
    public PageInfo<DormClean> findPageInfo(Integer d_id, String d_dormbuilding, Integer pageIndex, Integer pageSize);

    //添加宿舍卫生
    public int addDormClean(DormClean dormclean);

    //查找宿舍卫生
    public DormClean findDormCleanById(Integer g_id);

    //修改宿舍卫生信息
    public int updateDormClean(DormClean dormclean);

    //删除宿舍卫生
    public int deleteDormClean(Integer g_id);

    //导出Excel
    public List<DormClean> getAll();
}

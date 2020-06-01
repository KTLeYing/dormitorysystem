package com.mzl.service;

import com.mzl.po.DormRepair;
import com.mzl.po.PageInfo;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 维修登记
 * @author: Joyrocky
 * @create: 2019-04-28 00:25
 **/
public interface DormRepairService {

    //分页查询
    public PageInfo<DormRepair> findPageInfo(Integer d_id, String d_dormbuilding, Integer pageIndex, Integer pageSize);

    //添加宿舍维修
    public int addDormRepair(DormRepair dormRepair);

    //查找宿舍维修信息
    public DormRepair findDormRepairById(Integer r_id);

    //修改维修信息
    public int updateDormRepair(DormRepair dormrepair);

    //删除维修信息
    public int deleteDormRepair(Integer r_id);

    //导出Excel
    public List<DormRepair> getAll();
}

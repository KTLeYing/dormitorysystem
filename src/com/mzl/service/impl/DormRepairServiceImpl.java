package com.mzl.service.impl;

import com.mzl.dao.DormRepairDao;
import com.mzl.po.DormRepair;
import com.mzl.po.PageInfo;
import com.mzl.service.DormRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("dormRepairService")
@Transactional
public class DormRepairServiceImpl implements DormRepairService {

    // classDao
    @Autowired
    private DormRepairDao dormRepairDao;

    //分页查询
    @Override
    public PageInfo<DormRepair> findPageInfo(Integer d_id, String d_dormbuilding, Integer pageIndex, Integer pageSize) {
        PageInfo<DormRepair> pi = new PageInfo<DormRepair>();

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
        Integer totalCount = dormRepairDao.totalCount(d_id,d_dormbuilding);

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
            List<DormRepair> dormRepairList = dormRepairDao.getDormRepairList(d_id,d_dormbuilding, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(dormRepairList);
        }

        System.out.println(pi);

        return pi;
    }

    //添加宿舍维修
    @Override
    public int addDormRepair(DormRepair dormRepair) {
        return dormRepairDao.addDormRepair(dormRepair);
    }

    //查询宿舍维修嘻嘻嘻
    @Override
    public DormRepair findDormRepairById(Integer r_id) {
        return dormRepairDao.findDormRepairById(r_id);
    }

    //更新维修信息
    @Override
    public int updateDormRepair(DormRepair dormrepair) {
        return dormRepairDao.updateDormRepair(dormrepair);
    }

    //删除维修信息
    @Override
    public int deleteDormRepair(Integer r_id) {
        return dormRepairDao.deleteDormRepair(r_id);
    }

    //导出Excel
    @Override
    public List<DormRepair> getAll() {
        return dormRepairDao.getAll();
    }


}

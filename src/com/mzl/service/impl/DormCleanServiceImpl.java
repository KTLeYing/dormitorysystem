package com.mzl.service.impl;

import com.mzl.dao.DormCleanDao;
import com.mzl.po.DormClean;
import com.mzl.po.PageInfo;
import com.mzl.service.DormCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 宿舍卫生服务接口实现
 * @author: Joyrocky
 * @create: 2019-04-24 15:19
 **/
@Service("dormCleanService")
@Transactional
public class DormCleanServiceImpl implements DormCleanService {

    //classDao
    @Autowired
    private DormCleanDao dormCleanDao;

    @Override
    public PageInfo<DormClean> findPageInfo(Integer d_id, String d_dormbuilding, Integer pageIndex, Integer pageSize) {
        PageInfo<DormClean> pi = new PageInfo<DormClean>();
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
        Integer totalCount = dormCleanDao.totalCount(d_id,d_dormbuilding);

        //设置总页数
        if (totalCount % pi.getPageSize() == 0){
            pi.setPageTotalCount(totalCount / pi.getPageSize());
        }else {
            pi.setPageTotalCount(totalCount / pi.getPageSize() + 1);
        }

        if (totalCount > 0){
            pi.setTotalCount(totalCount);
            //每一页显示宿舍信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<DormClean> dormCleanList = dormCleanDao.getDormCleanList(d_id,d_dormbuilding, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(dormCleanList);
        }

        return pi;
    }

    //添加宿舍卫生
    @Override
    public int addDormClean(DormClean dormclean) {
        return dormCleanDao.addDormClean(dormclean);
    }

    //查找宿舍卫生
    @Override
    public DormClean findDormCleanById(Integer g_id) {
        return dormCleanDao.findDormCleanById(g_id);
    }

    //修改宿舍卫生信息
    @Override
    public int updateDormClean(DormClean dormclean) {
        return dormCleanDao.updateDormClean(dormclean);
    }

    //删除宿舍卫生
    @Override
    public int deleteDormClean(Integer g_id) {
        return dormCleanDao.deleteDormClean(g_id);
    }

    //导出Excel
    @Override
    public List<DormClean> getAll() {
        return dormCleanDao.getAll();
    }


}

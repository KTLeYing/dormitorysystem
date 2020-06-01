package com.mzl.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageInfo<T> implements Serializable {

    private Integer pageIndex =1;//页码
    private Integer pageSize =3;//显示条数
    private Integer totalCount =0; //总条数
    private Integer pageTotalCount =0; //总页数
    //每页显示的数据集合
    private List<T> list = new ArrayList<T>();

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    //获取总页数
    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public List<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", pageTotalCount=" + pageTotalCount +
                ", list=" + list +
                '}';
    }
}

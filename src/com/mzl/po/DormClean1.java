package com.mzl.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @program: dormitorySystem
 * @description: 宿舍卫生
 * @author: Joyrocky
 * @create: 2019-04-24 11:21
 **/
public class DormClean1 {

    private Integer g_id;
    private String d_id;
    private String  d_dormbuilding;
    private String d_grade;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date update_time;

    public void setG_id(Integer g_id) {
        this.g_id = g_id;
    }

    public void setD_dormbuilding(String d_dormbuilding) {
        this.d_dormbuilding = d_dormbuilding;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public void setD_grade(String d_grade) {
        this.d_grade = d_grade;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getG_id() {
        return g_id;
    }


    public String getD_dormbuilding() {
        return d_dormbuilding;
    }

    public String getD_id() {
        return d_id;
    }

    public String getD_grade() {
        return d_grade;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    @Override
    public String toString() {
        return "DormClean{" +
                "g_id=" + g_id +
                ", d_id=" + d_id +
                ", d_dormbuilding='" + d_dormbuilding + '\'' +
                ", d_grade=" + d_grade +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}

package com.mzl.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @program: dormitorySystem
 * @description: 学生卫生
 * @author: Joyrocky
 * @create: 2019-04-25 12:12
 **/
public class StudentClean1 {

    private Integer g_id;
    private String s_studentid;
    private String s_name;
    private String s_grade;
    private String s_classid;
    private String s_dormitoryid;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date update_time;

    public void setG_id(Integer g_id) {
        this.g_id = g_id;
    }

    public void setS_studentid(String s_studentid) {
        this.s_studentid = s_studentid;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public void setS_grade(String s_grade) {
        this.s_grade = s_grade;
    }

    public void setS_classid(String s_classid) {
        this.s_classid = s_classid;
    }

    public void setS_dormitoryid(String s_dormitoryid) {
        this.s_dormitoryid = s_dormitoryid;
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

    public String getS_studentid() {
        return s_studentid;
    }

    public String getS_name() {
        return s_name;
    }

    public String getS_grade() {
        return s_grade;
    }

    public String getS_classid() {
        return s_classid;
    }

    public String getS_dormitoryid() {
        return s_dormitoryid;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    @Override
    public String toString() {
        return "StudentClean{" +
                "g_id=" + g_id +
                ", s_studentid=" + s_studentid +
                ", s_name='" + s_name + '\'' +
                ", s_grade=" + s_grade +
                ", s_classid=" + s_classid +
                ", s_dormitoryid=" + s_dormitoryid +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}

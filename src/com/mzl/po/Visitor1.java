package com.mzl.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ClassName :   Visitor1
 * @Description: 访客
 * @Author: 21989
 * @CreateDate: 2020/6/1 16:01
 * @Version: 1.0
 */
public class Visitor1 {

    private Integer v_id;
    private String v_name;
    private String v_phone;
    private String v_dormitoryid;
    private String v_dormbuilding;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;

    public void setV_id(Integer v_id) {
        this.v_id = v_id;
    }

    public void setV_name(String v_name) {
        this.v_name = v_name;
    }

    public void setV_phone(String v_phone) {
        this.v_phone = v_phone;
    }

    public void setV_dormitoryid(String v_dormitoryid) {
        this.v_dormitoryid = v_dormitoryid;
    }

    public void setV_dormbuilding(String v_dormbuilding) {
        this.v_dormbuilding = v_dormbuilding;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getV_id() {
        return v_id;
    }

    public String getV_name() {
        return v_name;
    }

    public String getV_phone() {
        return v_phone;
    }

    public String getV_dormitoryid() {
        return v_dormitoryid;
    }

    public String getV_dormbuilding() {
        return v_dormbuilding;
    }

    public Date getCreate_time() {
        return create_time;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "v_id=" + v_id +
                ", v_name='" + v_name + '\'' +
                ", v_phone=" + v_phone +
                ", v_dormitoryid=" + v_dormitoryid +
                ", v_dormbuilding='" + v_dormbuilding + '\'' +
                ", create_time=" + create_time +
                '}';
    }

}

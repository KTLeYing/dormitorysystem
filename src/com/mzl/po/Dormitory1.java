package com.mzl.po;

import java.util.List;

public class Dormitory1 {

    private static final long serialVersionUID = 1L;
    private  Integer d_id;
    private  String s_dormitoryid;
    private  String  d_dormbuilding;
    private  String  d_bedtotal;
    private  String  d_bed;
    private  String  a_name;

    private List<Student> students;

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }


    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public void setS_dormitoryid(String s_dormitoryid) {
        this.s_dormitoryid = s_dormitoryid;
    }

    public void setD_dormbuilding(String d_dormbuilding) {
        this.d_dormbuilding = d_dormbuilding;
    }

    public void setD_bedtotal(String d_bedtotal) {
        this.d_bedtotal = d_bedtotal;
    }

    public void setD_bed(String d_bed) {
        this.d_bed = d_bed;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getD_id() {
        return d_id;
    }

    public String getS_dormitoryid() {
        return s_dormitoryid;
    }

    public String getD_dormbuilding() {
        return d_dormbuilding;
    }

    public String getD_bedtotal() {
        return d_bedtotal;
    }

    public String getD_bed() {
        return d_bed;
    }

    public String getA_name() {
        return a_name;
    }

    @Override
    public String toString() {
        return "Dormitory{" +
                "d_id=" + d_id +
                ", s_dormitoryid=" + s_dormitoryid +
                ", d_dormbuilding='" + d_dormbuilding + '\'' +
                ", d_bedtotal='" + d_bedtotal + '\'' +
                ", d_bed='" + d_bed + '\'' +
                ", a_name='" + a_name + '\'' +
                '}';
    }
}

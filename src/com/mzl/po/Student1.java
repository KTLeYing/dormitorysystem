package com.mzl.po;

public class Student1 {
    private static final long serialVersionUID = 1L;
    private  String s_id;
    private  String s_studentid;
    private  String  s_name;
    private  String  s_sex;
    private  String  s_age;
    private  String  s_phone;
    private  String  s_classid;
    private  String s_classname;
    private  String  s_dormitoryid;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public void setS_studentid(String s_studentid) {
        this.s_studentid = s_studentid;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public void setS_age(String s_age) {
        this.s_age = s_age;
    }

    public void setS_phone(String s_phone) {
        this.s_phone = s_phone;
    }

    public void setS_classid(String s_classid) {
        this.s_classid = s_classid;
    }

    public void setS_classname(String s_classname) {
        this.s_classname = s_classname;
    }

    public void setS_dormitoryid(String s_dormitoryid) {
        this.s_dormitoryid = s_dormitoryid;
    }

    public String getS_id() {
        return s_id;
    }

    public String getS_studentid() {
        return s_studentid;
    }

    public String getS_name() {
        return s_name;
    }

    public String getS_sex() {
        return s_sex;
    }

    public String getS_age() {
        return s_age;
    }

    public String getS_phone() {
        return s_phone;
    }

    public String getS_classid() {
        return s_classid;
    }

    public String getS_classname() {
        return s_classname;
    }

    public String getS_dormitoryid() {
        return s_dormitoryid;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "s_id='" + s_id + '\'' +
                ", s_studentid='" + s_studentid + '\'' +
                ", s_name='" + s_name + '\'' +
                ", s_sex='" + s_sex + '\'' +
                ", s_age='" + s_age + '\'' +
                ", s_phone='" + s_phone + '\'' +
                ", s_classid='" + s_classid + '\'' +
                ", s_classname='" + s_classname + '\'' +
                ", s_dormitoryid='" + s_dormitoryid + '\'' +
                '}';
    }

}

package com.mzl.po;

import java.util.List;

public class Class1 {
    private  Integer c_id;
    private  String c_classid;
    private  String  c_classname;
    private  String  c_counsellor;
    //班级与学生为一对多关系，使用链表
    private List<Student>  students;

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public void setC_classid(String c_classid) {
        this.c_classid = c_classid;
    }

    public String getC_classid() {
        return c_classid;
    }

    public String getC_classname() {
        return c_classname;
    }

    public void setC_classname(String c_classname) {
        this.c_classname = c_classname;
    }

    public String getC_counsellor() {
        return c_counsellor;
    }

    public void setC_counsellor(String c_counsellor) {
        this.c_counsellor = c_counsellor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Class1{" +
                "c_id=" + c_id +
                ", c_classid='" + c_classid + '\'' +
                ", c_classname='" + c_classname + '\'' +
                ", c_counsellor='" + c_counsellor + '\'' +
                ", students=" + students +
                '}';
    }
}

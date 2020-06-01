package com.mzl.controller;

import com.mzl.po.PageInfo;
import com.mzl.po.Student;
import com.mzl.po.Student1;
import com.mzl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户控制器类
 */
@Controller
public class StudentController {

    // 依赖注入
    @Autowired
    private StudentService studentService;

    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findStudent")
    public String findStudent(String s_name, Integer s_studentid,Integer s_classid, String s_classname, Integer pageIndex, Integer pageSize, Model model) {

        PageInfo<Student> pi = studentService.findPageInfo(s_name,s_studentid,s_classid, s_classname,pageIndex,pageSize);
        model.addAttribute("pi",pi);
        model.addAttribute("s_name",s_name);
        model.addAttribute("s_studentid",s_studentid);
        model.addAttribute("s_classid",s_classid);
        model.addAttribute("s_classname",s_classname);
        return "student_list";
    }

    /**
     * 添加学生信息
     */
    @RequestMapping(value = "/addStudent" ,method = RequestMethod.POST)
    @ResponseBody
    public String addStudent(@RequestBody Student1 student1) {
        Student student = new Student();
        student.setS_studentid(Integer.parseInt(student1.getS_studentid()));
        student.setS_name(student1.getS_name());
        student.setS_sex(student1.getS_sex());
        student.setS_age(Integer.parseInt(student1.getS_age()));
        student.setS_phone(Integer.parseInt(student1.getS_phone()));
        student.setS_classid(Integer.parseInt(student1.getS_classid()));
        student.setS_classname(student1.getS_classname());
        student.setS_dormitoryid(Integer.parseInt(student1.getS_dormitoryid()));
        int s = studentService.addStudent(student);
        return "student_list";
    }

    /**
     * 修改学生信息
     */
    @RequestMapping(value = "/updateStudent" ,method = RequestMethod.POST )
    public String updateStudent( Student student) {
        int s = studentService.updateStudent(student);
        System.out.println(s);
        return "redirect:/findStudent";
    }

    /**
     * 查找学生，修改前回显信息
     */
    @RequestMapping( "/findStudentById")
    public String findStudentById(Integer s_id, HttpSession session) {
        Student s = studentService.findStudentById(s_id);
        session.setAttribute("s", s);
        return "student_edit";
    }

    /**
     * 删除学生信息
     */
    @RequestMapping("/deleteStudent")
    @ResponseBody
    public String deleteStudent(Integer s_id,HttpSession session) {
        int s = studentService.deleteStudent(s_id);
        return "student_list";
    }

    /**
     * 导出数据
     */
    @RequestMapping(value = "/exportstudentlist", method = RequestMethod.POST)
    @ResponseBody
    public List<Student> exportStudent(){
        List<Student> studentList = studentService.getAll();
        return studentList;
    }


}

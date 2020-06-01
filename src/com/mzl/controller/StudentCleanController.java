package com.mzl.controller;

import com.mzl.po.PageInfo;
import com.mzl.po.StudentClean;
import com.mzl.po.StudentClean1;
import com.mzl.service.StudentCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 学生卫生控制器
 * @author: Joyrocky
 * @create: 2019-04-25 12:13
 **/
@Controller
public class StudentCleanController {

    @Autowired
    private StudentCleanService studentCleanService;

    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findStudentClean")
    public String findDormClean(Integer s_studentid, String s_name, Integer s_dormitoryid, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<StudentClean> di = studentCleanService.findPageInfo(s_studentid,s_name,s_dormitoryid,pageIndex,pageSize);
        model.addAttribute("di",di);
        model.addAttribute("s_studentid",s_studentid);
        model.addAttribute("s_dormitoryid",s_dormitoryid);
        model.addAttribute("s_name",s_name);
        return "studentclean_list";
    }

    /**
     * 添加宿舍卫生信息
     */
    @RequestMapping(value = "/addStudentClean" ,method = RequestMethod.POST)
    @ResponseBody
    public String addDormClean( @RequestBody StudentClean1 studentclean1) {
        StudentClean studentClean = new StudentClean();
        studentClean.setS_studentid(Integer.parseInt(studentclean1.getS_studentid()));
        studentClean.setS_name(studentclean1.getS_name());
        studentClean.setS_grade(Integer.parseInt(studentclean1.getS_grade()));
        studentClean.setS_classid(Integer.parseInt(studentclean1.getS_classid()));
        studentClean.setS_dormitoryid(Integer.parseInt(studentclean1.getS_dormitoryid()));

        int d = studentCleanService.addStudentClean(studentClean);
        return "studentclean_list";
    }

    /**
     * 修改宿舍卫生信息
     */
    @RequestMapping( "/findStudentCleanById")
    public String findDormCleanById(Integer g_id, HttpSession session) {
        StudentClean d= studentCleanService.findStudentCleanById(g_id);
        session.setAttribute("d",d);
        return "studentclean_edit";
    }

    @RequestMapping( "/updateStudentClean")
    public String updateDormClean( StudentClean studentclean) {
        int d = studentCleanService.updateStudentClean(studentclean);
        return "redirect:/findStudentClean";
    }

    /**
     * 删除学生卫生
     */
    @RequestMapping("/deleteStudentClean")
    @ResponseBody
    public String deleteStudentClean(Integer g_id){
        int d = studentCleanService.deleteStudentClean(g_id);
        return "studentclean_list";
    }

    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportstudentcleanlist", method = RequestMethod.POST)
    @ResponseBody
    public List<StudentClean> exportStudentclean(){
        List<StudentClean> studentCleanList = studentCleanService.getAll();
        return studentCleanList;
    }




}

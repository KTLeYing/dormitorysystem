package com.mzl.controller;

import com.mzl.po.Class;
import com.mzl.po.Class1;
import com.mzl.po.PageInfo;
import com.mzl.po.Student;
import com.mzl.service.ClassService;
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
public class ClassController {

    // 依赖注入
    @Autowired
    private ClassService classService;

    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findClass")
    public String findClass(Integer c_classid, String c_classname, String c_counsellor, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<Class> ci = classService.findPageInfo(c_classname,c_counsellor, c_classid,pageIndex,pageSize);
        model.addAttribute("ci", ci);
        model.addAttribute("c_classid", c_classid);
        model.addAttribute("c_classname", c_classname);
        model.addAttribute("c_counsellor", c_counsellor);
        return "class_list";
    }


    /**
     * 添加班级信息
     */
    @RequestMapping(value = "/addClass", method = RequestMethod.POST)
    @ResponseBody
    public String addClass(@RequestBody Class1 uclass1){
        Class uclass = new Class();
        uclass.setC_classid(Integer.parseInt(uclass1.getC_classid()));
        uclass.setC_classname(uclass1.getC_classname());
        uclass.setC_counsellor(uclass1.getC_counsellor());
        int c = classService.addClass(uclass);
        return "class_list";
    }

    /**
     * 修改班级信息
     */
    @RequestMapping( "/findClassById")
    public String findClassById(Integer c_id, HttpSession session) {
        Class c= classService.findClassById(c_id);
        session.setAttribute("c",c);
        return "class_edit";
    }

    @RequestMapping(value = "/updateClass", method = RequestMethod.POST)
    public String updateClass(Class uclass){
        int c = classService.updateClass(uclass);
        return "redirect:/findClass";
    }

    /**
     * 删除班级信息
     */
    @RequestMapping(value = "/deleteClass")
    @ResponseBody
    public String deleteClass(Integer c_id, HttpSession session){
        int c = classService.deleteClass(c_id);
        return "class_list";
    }

    /**
     * 导出班级数据Excel
     */
    @RequestMapping(value = "/exportclasslist", method = RequestMethod.POST)
    @ResponseBody
    public List<Class> exportClass(){
        List<Class> classList = classService.getAll();
        return classList;
    }

    /**
     * 班级人员信息查询
     */
    @RequestMapping(value = "/findClassStudent")
    public String findClassStudent(Class uclass,Model model) {
        List<Class> c = classService.findClassStudent(uclass);
        model.addAttribute("cs",c);
        model.addAttribute("c_classname", uclass.getC_classname());
        model.addAttribute("c_classid", uclass.getC_classid());
        return "class_Studentlist";
    }


}

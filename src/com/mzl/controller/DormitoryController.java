package com.mzl.controller;

import com.mzl.po.Dormitory;
import com.mzl.po.Dormitory1;
import com.mzl.po.PageInfo;
import com.mzl.service.DormitoryService;
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
public class DormitoryController {

    // 依赖注入
    @Autowired
    private DormitoryService dormitoryService;

    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findDormitory")
    public String findDormitory(String a_name,Integer s_dormitoryid,String d_dormbuilding, Integer pageIndex, Integer pageSize, Model model){
        PageInfo<Dormitory> di = dormitoryService.findPageInfo(a_name,s_dormitoryid, d_dormbuilding,pageIndex,pageSize);
        model.addAttribute("di",di);
        model.addAttribute("a_name", a_name);
        model.addAttribute("s_dormitoryid", s_dormitoryid);
        model.addAttribute("d_dormbuilding", d_dormbuilding);
        return "dormitory_list";
    }

    /**
     * 添加宿舍信息
     */
    @RequestMapping(value = "/addDormitory" ,method = RequestMethod.POST)
    @ResponseBody
    public String addDormitory( @RequestBody Dormitory1 dormitory1) {
        Dormitory dormitory = new Dormitory();
        dormitory.setS_dormitoryid(Integer.parseInt(dormitory1.getS_dormitoryid()));
        dormitory.setD_dormbuilding(dormitory1.getD_dormbuilding());
        dormitory.setD_bedtotal(dormitory1.getD_bedtotal());
        dormitory.setD_bed(dormitory1.getD_bed());
        dormitory.setA_name(dormitory1.getA_name());

        int d = dormitoryService.addDormitory(dormitory);
        return "dormitory_list";
    }

    /**
     * 修改学生信息
     */
    @RequestMapping( "/findDormitoryById")
    public String findDormitoryById(Integer d_id, HttpSession session) {
        Dormitory d = dormitoryService.findDormitoryById(d_id);
        session.setAttribute("d", d);
        return "dormitory_edit";
    }

    @RequestMapping(value = "/updateDormitory", method = RequestMethod.POST)
    public String updateDormitory( Dormitory dormitory) {
        int d = dormitoryService.updateDormitory(dormitory);
        return "redirect:/findDormitory";
    }

    /**
     * 删除宿舍信息
     */
    @RequestMapping( "/deleteDormitory")
    @ResponseBody
    public String deleteDormitory(Integer d_id) {
        int d = dormitoryService.deleteDormitory(d_id);
        return "dormitory_list";
    }

    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportdormitorylist", method = RequestMethod.POST)
    @ResponseBody
    public List<Dormitory> exportDormitory(){
        List<Dormitory> dormitoryList = dormitoryService.getAll();
        return dormitoryList;
    }

    /**
     * 宿舍人员信息查询
     */
    @RequestMapping("/findDormitoryStudent")
    public String findDormitoryStudent(Dormitory dormitory,Model model) {
        List<Dormitory> d = dormitoryService.findDormitoryStudent(dormitory);
        model.addAttribute("ds",d);
        model.addAttribute("s_dormitoryid", dormitory.getS_dormitoryid());
        return "dormitory_Studentlist";
    }


}

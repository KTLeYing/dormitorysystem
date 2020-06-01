package com.mzl.controller;

import com.mzl.po.PageInfo;
import com.mzl.po.Visitor;
import com.mzl.po.Visitor1;
import com.mzl.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName :   VisitorController
 * @Description: 访客管理
 * @Author: 21989
 * @CreateDate: 2020/6/1 15:48
 * @Version: 1.0
 */
@Controller
public class VisitorController {

    //依赖注入
    @Autowired
    private VisitorService visitorService;

    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findVisitor")
    public String findVisitor(String v_name, Integer v_phone , Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<Visitor> pi = visitorService.findPageInfo(v_name,v_phone, pageIndex,pageSize);
        model.addAttribute("pi",pi);
        model.addAttribute("v_name",v_name);
        model.addAttribute("v_phone",v_phone);
        return "visitor_list";
    }

    /**
     * 添加学生信息
     */
    @RequestMapping(value = "/addVisitor" ,method = RequestMethod.POST)
    @ResponseBody
    public String addStudent(@RequestBody Visitor1 visitor1) {
        Visitor visitor = new Visitor();
        visitor.setV_name(visitor1.getV_name());
        visitor.setV_phone(Integer.parseInt(visitor1.getV_phone()));
        visitor.setV_dormitoryid(Integer.parseInt(visitor1.getV_dormitoryid()));
        visitor.setV_dormbuilding(visitor1.getV_dormbuilding());
        int v = visitorService.addVisitor(visitor);
        return "visitor_list";
    }

    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportvisitorlist", method = RequestMethod.POST)
    @ResponseBody
    public List<Visitor> exportVisitor(){
        List<Visitor> visitorList = visitorService.getAll();
        return visitorList;
    }


}

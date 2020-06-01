package com.mzl.controller;

import com.mzl.po.DormRepair;
import com.mzl.po.DormRepair1;
import com.mzl.po.PageInfo;
import com.mzl.service.DormRepairService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
 * @program: dormitorySystem
 * @description: 维修登记
 * @author: Joyrocky
 * @create: 2019-04-27 17:13
 **/
@Controller
public class DormRepairController {

    @Autowired
    private DormRepairService dormRepairService;

    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findDormRepair")
    public String findDormRepair(Integer d_id,String d_dormbuilding, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<DormRepair> di = dormRepairService.findPageInfo(d_id,d_dormbuilding, pageIndex,pageSize);
        model.addAttribute("di",di);
        model.addAttribute("d_id", d_id);
        model.addAttribute("d_dormbuilding", d_dormbuilding);
        return "dormrepair_list";
    }

    /**
     * 添加宿舍维修信息
     */
    @RequestMapping(value = "/addDormRepair" ,method = RequestMethod.POST)
    @ResponseBody
    public String addDormitory( @RequestBody DormRepair1 dormrepair1) {
        DormRepair dormRepair = new DormRepair();
        dormRepair.setD_id(Integer.parseInt(dormrepair1.getD_id()));
        dormRepair.setD_dormbuilding(dormrepair1.getD_dormbuilding());
        dormRepair.setR_name(dormrepair1.getR_name());
        dormRepair.setReason(dormrepair1.getReason());
        dormRepair.setCreate_time(dormrepair1.getCreate_time());
        dormRepair.setUpdate_time(dormrepair1.getUpdate_time());

        int d = dormRepairService.addDormRepair(dormRepair);
        return "dormrepair_list";
    }

    /**
     * 修改宿舍维修信息
     */
    @RequestMapping( "/updateDormRepair")
    public String updateDormRepair(DormRepair dormrepair) {
        int d = dormRepairService.updateDormRepair(dormrepair);
        return "redirect:/findDormRepair";
    }

    @RequestMapping( "/findDormRepairById")
    public String findDormRepairById(Integer r_id, Model model) {
        DormRepair d = dormRepairService.findDormRepairById(r_id);
        model.addAttribute("d", d);
        return "dormrepair_edit";
    }

    /**
     * 删除维修信息
     */
    @RequestMapping("/deleteDormRepair")
    @ResponseBody
    public String deleteDormRepair(Integer r_id){
        int d = dormRepairService.deleteDormRepair(r_id);
        return "dormrepair_list";
    }

    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportdormrepairlist", method = RequestMethod.POST)
    @ResponseBody
    public List<DormRepair> exportDormrepair(){
        List<DormRepair> dormRepairList = dormRepairService.getAll();
        return dormRepairList;
    }



}

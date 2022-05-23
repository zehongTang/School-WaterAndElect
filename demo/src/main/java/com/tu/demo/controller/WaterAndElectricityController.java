package com.tu.demo.controller;


import com.tu.demo.entity.Electricity;
import com.tu.demo.entity.Student;
import com.tu.demo.entity.VO.RallVo;
import com.tu.demo.entity.Water;
import com.tu.demo.service.ElectricityService;
import com.tu.demo.service.StudentService;
import com.tu.demo.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@Controller
public class WaterAndElectricityController  {
    @Resource
    private WaterService waterService;
    @Resource
    private ElectricityService electricityService;
    @Resource
    private StudentService studentService;
    @RequestMapping("/")
    public String index(){return "water";}
    @GetMapping("/query")
    public String query(HttpSession session,String year,String month,String choose){
       session.setAttribute("year",year);
        session.setAttribute("month",month);
        if (choose.equals("water")) {
            System.out.println("water以运行！");
            return "forward:/water";
        }else if (choose.equals("elect")){
            System.out.println("elect以运行！");
            return "redirect:/elect";
        }
        else{System.out.println("rall以运行！");
            return "redirect:/rall";}

    }
    @RequestMapping("/water")
    public String  water(Model model,HttpSession session){
        String date=(String)session.getAttribute("year")+(String)session.getAttribute("month");
        Water water=waterService.getById(date);
        List<Water> waterlist = new LinkedList<>();
        waterlist.add(water);
        model.addAttribute("waterlist",waterlist);
        return "water";
    }
    @RequestMapping("/elect")
    public String  elect(Model model,HttpSession session){
        String date=(String)session.getAttribute("year")+(String)session.getAttribute("month");
        Electricity electricity=electricityService.getById(date);
        List<Electricity> electricityList = new LinkedList<>();
        electricityList.add(electricity);
        model.addAttribute("electricityList",electricityList);
        return "water";
    }
    @RequestMapping("/rall")
    public String  rall(Model model,HttpSession session){
        String date=(String)session.getAttribute("year")+session.getAttribute("month");
        RallVo rall=waterService.getRall(date);
        List<RallVo> ralllist =new LinkedList<>();
        System.out.println(rall.getDate()+rall.getPerPrice());
        ralllist.add(rall);
        model.addAttribute("ralllist",ralllist);
        return "water";
    }

    @GetMapping("/student/{studentid}")
    public String student(@PathVariable("studentid") String studentid, Model model){
        Student student=studentService.getById(studentid);
        String roomid=student.getRoomID();
       model.addAttribute("roomid",student);
        return "RoomId";
    }
}

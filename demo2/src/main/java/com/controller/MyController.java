package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Emp;
import com.service.EmpService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-11-24-15:25
 */
@Controller
public class MyController {
    @Autowired
    EmpService es;
    @GetMapping("/page/{pageNum}")
    public String getAll(@PathVariable("pageNum")int pageNum, Model model){
        PageHelper.startPage(pageNum,6);
        List<Emp> emps = es.getAll();
        PageInfo<Emp> page=new PageInfo<>(emps,5);
        model.addAttribute("page",page);
        return "page";
    }
    @DeleteMapping("/page/{id}")
    public String deleteById(@PathVariable("id")int id){
        System.out.println("come in!");
        es.deleteById(id);
        return "redirect:/page/1";
    }
}

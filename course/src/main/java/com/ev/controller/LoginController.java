package com.ev.controller;

import com.ev.pojo.Student;
import com.ev.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class LoginController {

    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping({"/","/index"})
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String register(Student student){
        studentService.addStudent(student);
        return "redirect:/toLogin";
    }

}

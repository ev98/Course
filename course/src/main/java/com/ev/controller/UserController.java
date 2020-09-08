package com.ev.controller;

import com.ev.pojo.Course;
import com.ev.pojo.Student;
import com.ev.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/toInfo")
    public String toInfo(Model model) {
        //获取当前用户的信息
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student userInfo = studentService.findByUsername(userDetails.getUsername());
        model.addAttribute("userInfo", userInfo);
        return "/user/info";
    }

    //更改用户信息
    @PostMapping("/updateUser")
    public String updateUser(Student student) {
        studentService.updateStudent(student);
        return "redirect:/toInfo";
    }

    //查看全部学生信息
    @RequestMapping("/studentList")
    public String studentInfo(Model model) {
        List<Student> students = studentService.findAllStudent();
        model.addAttribute("students", students);
        return "/user/admin/studentlist";
    }

    //删除学生信息
    @RequestMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/studentList";
    }

    //修改学生信息
    @GetMapping("/updateStudent/{id}")
    public String toUpdateCourse(@PathVariable("id") Integer id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        return "user/admin/studentUpdate";
    }

    @PostMapping("/updateStudent")
    public String updateCourse(Student student){
        studentService.updateStudent(student);
        return "redirect:/studentList";
    }


}

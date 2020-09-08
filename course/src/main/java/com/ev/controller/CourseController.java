package com.ev.controller;

import com.ev.pojo.Course;
import com.ev.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseServiceImpl courseService;

    //查询所有课程信息返回列表页面
    @RequestMapping("/courses")
    public String list(Model model){
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses",courses);
        return "user/list";
    }

    //添加课程
    @GetMapping("/addCourse")
    public String toAddCourse(){
        return "user/admin/add";
    }

    @PostMapping("/addCourse")
    public String addCourse(Course course){
        courseService.addCourse(course);
        return "redirect:/courses";
    }

    //修改课程
    @GetMapping("/updateCourse/{id}")
    public String toUpdateCourse(@PathVariable("id") Integer id, Model model){
        Course course = courseService.findById(id);
        model.addAttribute("course",course);
        return "user/admin/update";
    }

    @PostMapping("/updateCourse")
    public String updateCourse(Course course){
        courseService.updateCourse(course);
        return "redirect:/courses";
    }

    //删除课程
    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable("id") Integer id){
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }

}

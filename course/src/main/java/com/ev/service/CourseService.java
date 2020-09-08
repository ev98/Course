package com.ev.service;

import com.ev.pojo.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseService {

    //查询所有课程
    List<Course> findAll();

    //根据课程id查找课程
    Course findById(Integer id);

    //添加课程
    void addCourse(Course course);

    //修改课程
    void updateCourse(Course course);

    //删除课程
    void deleteCourse(Integer id);

}

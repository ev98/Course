package com.ev.service;

import com.ev.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentService {

    //查询所有学生
    List<Student> findAllStudent();

    //查询所有用户
    List<Student> findAll();

    //根据id查找学生
    Student findById(Integer id);

    //根据username查找学生
    Student findByUsername(String username);

    //添加学生
    void addStudent(Student student);

    //修改学生
    void updateStudent(Student student);

    //删除学生
    void deleteStudent(Integer id);

}

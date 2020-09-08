package com.ev.mapper;

import com.ev.pojo.Course;
import com.ev.pojo.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

    //查询所有学生
    @Select("select * from student where role='student'")
    List<Student> findAllStudent();

    //查询所有用户
    @Select("select * from student")
    List<Student> findAll();

    //根据id查找学生
    @Select("select * from student where id=#{id}")
    Student findById(Integer id);

    //根据username查找学生
    @Select("select * from student where username=#{username}")
    Student findByUsername(String username);

    //添加学生
    @Insert("insert into student (username,name,gender,major,college,address,password,role) value (#{username},#{name},#{gender},#{major},#{college},#{address},#{password},#{role})")
    void addStudent(Student student);

    //修改学生
    @Update("update student set username=username,name=#{name},gender=#{gender},major=#{major},college=#{college},address=#{address},password=#{password},role=#{role} where id=#{id}")
    void updateStudent(Student student);

    //删除学生
    @Delete("delete from student where id=#{id}")
    void deleteStudent(Integer id);

}

package com.ev.mapper;

import com.ev.pojo.Course;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {

    //查询所有课程
    @Select("select * from course")
    List<Course> findAll();

    //根据课程id查找课程
    @Select("select * from course where id=#{id}")
    Course findById(Integer id);

    //添加课程
    @Insert("insert into course (name,teacher,date,classroom,lesson) value (#{name},#{teacher},#{date},#{classroom},#{lesson})")
    void addCourse(Course course);

    //修改课程
    @Update("update course set name=#{name},teacher=#{teacher},date=#{date},classroom=#{classroom},lesson=#{lesson} where id=#{id}")
    void updateCourse(Course course);

    //删除课程
    @Delete("delete from course where id=#{id}")
    void deleteCourse(Integer id);

}

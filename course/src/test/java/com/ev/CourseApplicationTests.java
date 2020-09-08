package com.ev;

import com.ev.service.impl.CourseServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseApplicationTests {

    @Autowired
    CourseServiceImpl courseService;

    @Test
    void contextLoads() {
        System.out.println(courseService.findAll());
    }

}

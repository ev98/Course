package com.ev.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String username;
    private String name;
    private String gender;
    private String major;
    private String college;
    private String address;
    private String password;
    private Roles role;

    public enum Roles{
        student,admin;
    }
}

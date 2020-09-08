package com.ev.config;

import com.ev.pojo.Student;
import com.ev.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*
        * 1.通过username 获取到userInfo信息
        * 2.通过User(UserDetails)返回UserDetails
        * */

        Student studentInfo  = studentService.findByUsername(username);
        if (studentInfo == null){
            throw new UsernameNotFoundException("not found");
        }

        //定义权限列表
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+studentInfo.getRole().name()));

        User userDetails = new User(studentInfo.getUsername(), passwordEncoder.encode(studentInfo.getPassword()), authorities);

        return userDetails;

    }
}

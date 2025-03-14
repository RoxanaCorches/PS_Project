package com.example.project_ps_real;

import com.example.project_ps_real.entity.User;
import com.example.project_ps_real.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.project_ps_real")
public class ProjectPsRealApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectPsRealApplication.class, args);
        User user= new User();
        User user1= new User();
        user.setPassword("password");
        user1.setPassword("ana");
        System.out.println(user.getPassword());
        System.out.println(user1.getPassword());
    }
}




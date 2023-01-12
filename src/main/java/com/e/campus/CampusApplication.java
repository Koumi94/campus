package com.e.campus;

import com.e.campus.model.User;
import com.e.campus.model.UserRole;
import com.e.campus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@Slf4j

public class CampusApplication {


    public static void main(String[] args) {

         SpringApplication.run(CampusApplication.class, args);
        /*System.out.println(Arrays.asList(applicaticationContext.getBeanDefinitionNames()));*/


    }

    @Bean
    BCryptPasswordEncoder passwordEncoder()
    {
        return  new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner run(UserService userService){
        return  args -> {
            userService.saveUserRole(new UserRole(null , "ROLE_ADMIN"));//this one is user for human resources
            userService.saveUserRole(new UserRole(null , "ROLE_USER"));//this for students
            userService.saveUserRole(new UserRole(null , "ROLE_MANAGER"));//this one is use for teachers
            userService.saveUserRole(new UserRole(null , "ROLE_SUPER_ADMIN"));//this for Authorizes

            userService.saveUser(new User("koumi1", "koumi", "1234" , "test@test.com"));

            userService.addRoleToUser("koumi1","ROLE_SUPER_ADMIN");
            userService.addRoleToUser("koumi1","ROLE_ADMIN");
            userService.addRoleToUser("koumi1","ROLE_MANAGER");
        };
    }
}

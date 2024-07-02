package org.ds.spring_security_2;

import org.ds.spring_security_2.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringSecurity1Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurity1Application.class, args);
    }
}

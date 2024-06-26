package org.ds.spring_security_1;

import jakarta.annotation.PostConstruct;
import org.ds.spring_security_1.bean.EmployeeBean;
import org.ds.spring_security_1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringSecurity1Application {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public SpringSecurity1Application(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurity1Application.class, args);
    }

    @PostConstruct
    public void populateInitialData() {
        List<EmployeeBean> employeeBeanList = new ArrayList<>();
        employeeBeanList.add(new EmployeeBean(0, "Sandeera", "Jayampathi", "sandeera@gmail.com"));
        employeeBeanList.add(new EmployeeBean(0, "Uthpala", "Hewage", "uthpala@gmail.com"));
        employeeBeanList.add(new EmployeeBean(0, "Nadun", "Dhananjaya", "nadun@gmail.com"));
        employeeRepository.saveAll(employeeBeanList);
    }

}

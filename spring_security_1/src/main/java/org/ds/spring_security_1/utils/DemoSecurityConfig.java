//package org.ds.spring_security_1.utils;
//
//import jakarta.persistence.criteria.CriteriaBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//public class DemoSecurityConfig {
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails sandeeraJ = User.builder()
//                .username("sandeera")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//        UserDetails uthpalaH = User.builder()
//                .username("uthpala")
//                .password("{noop}test1234")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//        UserDetails nadunD = User.builder()
//                .username("nadun")
//                .password("{noop}test12345")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        return new InMemoryUserDetailsManager(sandeeraJ, uthpalaH,nadunD);
//    }
//}

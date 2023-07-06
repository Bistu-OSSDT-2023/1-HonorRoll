package com.example.dbemp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//启动类，帮我们配置好，所需的一切东西，包括DispatcherServlet等
@SpringBootApplication
public class DbEmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbEmpApplication.class, args);
    }

}

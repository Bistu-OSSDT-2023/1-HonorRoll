package com.example.dbemp.demos.web;

import lombok.Data;

import java.io.Serializable;

//与数据库一一对应
@Data
public class Emp implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private String gender;

    private String department;

    private Double salary;

    private String phone;

    private String position;

    private String address;

    private static final long serialVersionUID = 1L;
}

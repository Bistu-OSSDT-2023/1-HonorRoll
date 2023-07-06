package com.example.dbemp.demos.web;


import java.util.ArrayList;
//Mapper功能测试
public class Test {
    private static EmpMapper EmpMapper = new EmpMapper();

    public static void main(String[] args) {
        list(1,100);
//        add();
//        delete();
    }

    public static void list(int i ,int j) {
        ArrayList<Emp> listInfo = EmpMapper.list(i, j);
        for (Emp employee : listInfo) {
            System.out.println(employee);
        }
    }
    public static void add() {
        Emp employee = new Emp();
        employee.setName("a4");
        employee.setAge(23);
        employee.setGender("f");
        employee.setDepartment("开发部");
        employee.setSalary(9000.0);
        employee.setPhone("19988887777");
        employee.setPosition("python");
        EmpMapper.addEmp(employee);
        list(1,100);
    }
    public static void delete() {
        EmpMapper.deleteEmp(2);
        list(1,100);
    }
}

package com.example.dbemp.demos.web;

import java.sql.*;
import java.util.ArrayList;

//数据库操作，api调用，调用mysql提供给java的api
public class EmpMapper {

    public void addEmp(Emp employee) {
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into " +
                "emp(name,age,gender,department,salary,phone,position,address) " +
                "values(?,?,?,?,?,?,?,?)";

        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, employee.getName());
            stm.setInt(2, employee.getAge());
            stm.setString(3, employee.getGender());
            stm.setString(4, employee.getDepartment());
            stm.setDouble(5, employee.getSalary());
            stm.setString(6, employee.getPhone());
            stm.setString(7, employee.getPosition());
            stm.setString(8, employee.getAddress());
            stm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.CloseConnection(conn);
        }
    }

/*    public void updateEmp(Employee employee) {
        Connection conn = JDBCUtils.getConnection();
        String sql = null;
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(sql);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.CloseConnection(conn);
        }
    }*/


    public void deleteEmp(int id) {
        Connection conn = JDBCUtils.getConnection();
        String sql = "delete from emp " +
                "where id = ?";
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            stm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.CloseConnection(conn);
        }
    }

    public ArrayList<Emp> list(int page, int pageSize) {
        ArrayList<Emp> tag_Array = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from emp " +
                "limit ?,?";
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, (page - 1) * pageSize);
            stm.setInt(2, pageSize);
            rs = stm.executeQuery();
            while (rs.next()) {
                Emp tag = new Emp();
                tag.setId(rs.getInt("id"));
                tag.setName(rs.getString("name"));
                tag.setAge(rs.getInt("age"));
                tag.setGender(rs.getString("gender"));
                tag.setDepartment(rs.getString("department"));
                tag.setSalary(rs.getDouble("salary"));
                tag.setPhone(rs.getString("phone"));
                tag.setPosition(rs.getString("position"));
                tag.setAddress(rs.getString("address"));
                tag_Array.add(tag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.CloseConnection(conn);
        }
        return tag_Array;
    }
}

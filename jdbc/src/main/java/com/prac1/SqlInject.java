package com.prac1;

import java.sql.*;
import java.sql.ResultSet;

public class SqlInject {
    public static void main(String[] args) throws Exception{
        Connection con = DriverManager.getConnection("Jdbc:mysql:///db1", "root", "root");
        Statement statement = con.createStatement();
        String username = "cjiehong906";
        String password = "kSRnZp4xru";
        String sql = "select * from customer where user ='" + username + "' and password = '" + password +"'";
        System.out.println(sql);
        java.sql.ResultSet rs = statement.executeQuery(sql);
        if (rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }

        // sql注入攻击演示
        String user_fake = "fakeuser";
        String password_fake = "' or '1' = '1";
        String sql2 = "select * from customer where user ='" + user_fake + "' and password = '" + password_fake +"'";
        System.out.println(sql2);
        ResultSet resultSet = statement.executeQuery(sql2);
        if (resultSet.next()){
            System.out.println("注入攻击登录成功");
        }else{
            System.out.println("注入攻击登录失败");
        }

        statement.close();
        con.close();
    }
}

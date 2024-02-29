package com.prac1;

import com.mysql.cj.x.protobuf.MysqlxCursor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
    public static void main(String[] args) throws Exception {
//        可以不用写注册驱动这一步
//        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
//        Jdbc:mysql://hostname:port/databasename
//        若使用本机地址，端口是默认的3306，可以简化书写
//        Connection conn = DriverManager.getConnection("Jdbc:mysql://localhost:3306/db1", "root", "root");
        Connection conn = DriverManager.getConnection("Jdbc:mysql:///db1", "root", "root");
        Statement statement = conn.createStatement();

        String sql = "UPDATE stu SET stu.score = 37.00 WHERE stu.id = 1;";
        statement.executeUpdate(sql);

        statement.close();
        conn.close();
    }

}
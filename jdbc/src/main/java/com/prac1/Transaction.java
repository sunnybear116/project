package com.prac1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction  {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("Jdbc:mysql:///db1", "root", "root");
        Statement statement = conn.createStatement();
        try {
//            开启事务，关闭自动提交，置为false
            conn.setAutoCommit(false);
//            sql1和sql2两条sql子句，绑定为一个事务
            String sql1 = "UPDATE stu SET stu.score = 23.00 WHERE stu.id = 1;";
            String sql2 = "UPDATE stu SET stu.score = 7.00 WHERE stu.id = 2;";
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
//            提交事务
            conn.commit();
        } catch (Exception e) {
//            事务回滚
            conn.rollback();
        }

    }
}

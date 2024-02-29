package com.prac1;

import java.sql.*;
import java.sql.ResultSet;

/**
 * 演示 preparedStatement 语句 ，用来预防 sql 注入攻击
 */
public class PreparedStatement {
    public static void main(String[] args) throws Exception{
        Connection con = DriverManager.getConnection("Jdbc:mysql:///db1", "root", "root");
//        Statement statement = con.createStatement();
        String user_fake = "fakeuser";
        String password_fake = "' or '1' = '1";
//        sql参数是需要占位符用？代替的
        String sql = "select * from customer where user = ? and password = ?;";
//        preparedStatement()在创建的时候就需要传入sql参数
        java.sql.PreparedStatement sta = con.prepareStatement(sql);
//        preparedStatement对象通过setXxx()来防止对应空位的参数，参数1为？的顺序，从1开始，参数2为替换的字符串
//        Xxx为该位置在数据库中的数据类型
        sta.setString(1,user_fake);
        sta.setString(2,password_fake);

//        注意：preparedStatement() 的excuteQuery()方法里面是不用传参数的
        ResultSet resultSet = sta.executeQuery();
        if (resultSet.next()){
            System.out.println("注入攻击登录成功");
        }else{
            System.out.println("注入攻击登录失败");
        }
        resultSet.close();
        sta.close();
        con.close();
    }
}

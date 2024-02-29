package com.prac1;

import java.sql.*;

public class ResultSet {
    public static void main(String[] args) throws Exception{
        Connection con = DriverManager.getConnection("Jdbc:mysql:///db1", "root", "root");
        Statement statement = con.createStatement();
        String sql = "select * from stu;";
        java.sql.ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            int stu_id = rs.getInt("id");
            String stu_name = rs.getString("name");
            double stu_score = rs.getDouble(4);
            System.out.print(stu_id + " ");
            System.out.print(stu_name + " ");
            System.out.println(stu_score + " ");
        }
        statement.close();
        con.close();
    }
}

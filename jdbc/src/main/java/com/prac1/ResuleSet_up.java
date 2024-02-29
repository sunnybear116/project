package com.prac1;

import com.prac1.pojo.Stu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResuleSet_up {
    public static void main(String[] args) throws Exception{
        Connection con = DriverManager.getConnection("Jdbc:mysql:///db1", "root", "root");
        Statement statement = con.createStatement();
        String sql = "select * from stu;";
        java.sql.ResultSet rs = statement.executeQuery(sql);

        List<Stu> list = new ArrayList<>();

        while (rs.next()){
            Stu stu = new Stu();
            int stu_id = rs.getInt("id");
            String stu_name = rs.getString("name");
            double stu_score = rs.getDouble(4);

            stu.setId(stu_id);
            stu.setName(stu_name);
            stu.setScore(stu_score);

            list.add(stu);
        }
        System.out.println(list);
        statement.close();
        con.close();

    }
}

package com.cxw.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {
    // 3、方法中使用其他的局部变量，将其变量上升为全局变量
    private static SqlSessionFactory sqlSessionFactory;
//  静态代码块随类创建自动执行，且只执行一次
    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 2、方法中使用其他的局部变量，将其变量上升为全局变量，赋值变量
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
//      1、方法中使用其他的局部变量，将其变量上升为全局变量
        return sqlSessionFactory;
    }
}

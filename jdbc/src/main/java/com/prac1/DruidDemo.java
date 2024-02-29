package com.prac1;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * driud连接池技术使用
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception{
//        1、导入jar包
//        2、定义配置文件，写properties
//        3、加载配置文件
        Properties prop = new Properties();
//        参数应该写文件地址+文件名称，文件地址有的时候比较棘手，可通过打印本项目的user.dir进行拼接
//        D:\space\src\com\prac1
        prop.load(new FileInputStream("src/com/prac1/driud.properties"));
//      通过德鲁伊工厂方法创建datasource()
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
//        通过datasource获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
//        System.out.println(System.getProperty("user.dir"));
    }
}

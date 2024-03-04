package com.cxw.jdbc.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.util.Properties;

//使用druid管理数据库连接池

/*
* 1. 导入jar包，此处用maven
* 2.定义配置文件durid.properties
* 3.加载配置文件
* 4.获取连接池对象
* */
public class druiddemo {
    public static void main(String[] args) throws Exception {
        //    配置文件是druid.properties
//    加载配置文件
        Properties prop = new Properties();
//        使用System.getProperty("user.dir")查看该程序的位置，方便定位到与目标位置的相对距离
//        System.out.println(System.getProperty("user.dir"));
        prop.load(new FileInputStream("../brand-demo/src/main/resources/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }

}

package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
//        1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
//        接收参数
        int id = 1;
//        1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        System.out.println(brand);
        sqlSession.close();
    }


    @Test
    public void selectByCondition() throws IOException {
//        接收参数
        int status = 1;
        String companyName = "%华为%";
        String brandName = "%华为%";

//        方法二传递参数
//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

//        方法三：map传递,map 里的键对应的是 Mapper 映射文件里的#{}里面的值
        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);

//        1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

//        方法一：参数 @Param 传递
//        List<Brand> brands = mapper.selectByCondition(status, companyName, brandName);
//        方法二：对象传递
//        List<Brand> brands = mapper.selectByCondition(brand);
//        方法三：map传递
        List<Brand> brands = mapper.selectByCondition(map);

        System.out.println(brands);
        sqlSession.close();
    }


    @Test
    public void selectByConditionSingle() throws IOException {
//        接收参数
        int status = 0;
//        String companyName = "%华为%";
//        String brandName = "%华为%";

//        方法二传递参数
        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand1 = mapper.selectByConditonSingle(brand);

        System.out.println(brand1);
        sqlSession.close();
    }

    @Test
    public void addTest() throws IOException {
//        接收参数
        String companyName = "波导通讯公司";
        String brandName = "波导手机";
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setOrdered(20);
        brand.setDescription("手机中的战斗机");
        brand.setStatus(0);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//      openSession 传参为true，开启自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);

        Integer id = brand.getId();
        System.out.println(id);

//        若sqlSessionFactory.openSession(true) 不传值，则需要手动提交
//        sqlSession.commit();
        System.out.println(brand);
        sqlSession.close();
    }


    @Test
    public void updateTest() throws IOException {
//        接收参数
        String companyName = "波导通讯公司";
        String brandName = "波导手机";
        Brand brand = new Brand();
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setOrdered(20);
        brand.setDescription("手机中的战斗机");
//        brand.setStatus(0);
        brand.setId(7);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//      openSession 传参为true，开启自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int count = mapper.update(brand);
        System.out.println(count);
        sqlSession.close();
    }

    @Test
    public void deleteById() throws IOException {
//        接收参数
        int id = 7;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//      openSession 传参为true，开启自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int i = mapper.deleteById(id);
        System.out.println(i);
        sqlSession.close();
    }

    @Test
    public void deleteByIds() throws IOException {
//        接收参数
        int[] ids = {8,9,10,11};
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//      openSession 传参为true，开启自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int i = mapper.deleteByIds(ids);
        System.out.println(i);
        sqlSession.close();
    }




}

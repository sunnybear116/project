package com.cxw.service;

import com.cxw.mapper.BrandMapper;
import com.cxw.pojo.Brand;
import com.cxw.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Brand> selectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }
    public Brand selectById(String id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    public void update(Brand brand){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.update(brand);
        sqlSession.close();
    }

    public void deleteById(String id){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.close();
    }



    public void add(Brand brand){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlSession.commit();
        sqlSession.close();

    }
}

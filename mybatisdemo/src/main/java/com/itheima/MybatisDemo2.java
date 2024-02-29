package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo2 {
    public static void main(String[] args) throws IOException {
//        加载mybatis核心配置文件。这段程序使用率不高。不需特别记住
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        获取session对象，用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        执行sql,selectList()表示查询多个，还有selectOne() 查询一个
//        参数：namespace + id 因为可能有多个mapper.xml，e.g,OrderMapper.xml,所以需要命名空间当作类似包名来区分id
//        List<User> users = sqlSession.selectList("test.selectAll");

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();

        System.out.println(users);
//        释放资源
        sqlSession.close();

    }
}

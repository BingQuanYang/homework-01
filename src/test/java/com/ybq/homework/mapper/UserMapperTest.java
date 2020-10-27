package com.ybq.homework.mapper;

import com.ybq.homewok.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserMapperTest {
    SqlSession sqlSession;
    UserMapper mapper;

    @Before
    public void before(){
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(UserMapperTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml"));
        sqlSession = factory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }
    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void selectUserByUserId(){
        System.out.println(mapper.selectUserByUserId(1));
    }

}

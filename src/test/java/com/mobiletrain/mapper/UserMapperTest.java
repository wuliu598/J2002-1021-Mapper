package com.mobiletrain.mapper;

import com.mobiletrain.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserMapperTest {
    private SqlSession sqlSession;
    private UserMapper mapper;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        sqlSession = build.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void destory(){
        sqlSession.close();
    }

    @Test
    public void testQuery(){
        User user = mapper.queryByUsernameAndPassword("mobiletrain", "670b14728ad9902aecba32e22fa4f6bd");
        System.out.println(user);
    }
}

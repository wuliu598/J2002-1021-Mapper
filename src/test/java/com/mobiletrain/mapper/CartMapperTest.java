package com.mobiletrain.mapper;

import com.mobiletrain.domain.Cart;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartMapperTest {
    private SqlSession sqlSession;
    private  CartMapper mapper;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        sqlSession = build.openSession(true);
        mapper = sqlSession.getMapper(CartMapper.class);
    }

    @After
    public void destory(){
        sqlSession.close();
    }

    @Test
    public void testQueryByUid(){
        List<Cart>carts=mapper.queryByUid("1");
        System.out.println(carts);
    }

    @Test
    public void testDelete(){
        String[] ids={"1","2"};
        List<String>strings= Arrays.asList(ids);

        int delete = mapper.delete(strings);
        System.out.println(delete);
    }
}

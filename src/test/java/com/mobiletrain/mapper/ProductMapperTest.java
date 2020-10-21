package com.mobiletrain.mapper;

import com.mobiletrain.domain.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProductMapperTest {
    private SqlSession sqlSession;
    private  ProductMapper mapper;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        sqlSession = build.openSession(true);
        mapper = sqlSession.getMapper(ProductMapper.class);
    }

    @After
    public void destory(){
        sqlSession.close();
    }

    @Test
    public void testSearch(){
        List<Product> search = mapper.search(9100,null);
        System.out.println(search);

        List<Product> search1 = mapper.search(null, 10000);
        System.out.println(search1);

        List<Product> search2 = mapper.search(5000,20000);
        System.out.println(search2);

    }
}

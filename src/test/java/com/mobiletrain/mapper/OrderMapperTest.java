package com.mobiletrain.mapper;

import com.mobiletrain.domain.Order;
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

public class OrderMapperTest {
    private SqlSession sqlSession;
    private OrderMapper mapper;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        sqlSession = build.openSession(true);
        mapper = sqlSession.getMapper(OrderMapper.class);
    }

    @After
    public void destory(){
        sqlSession.close();
    }

    @Test
    public void testqueryByUid() throws IOException {

        List<Order> orders = mapper.queryByUid("1");
        System.out.println(orders);

    }

    @Test
    public void testinsert(){
        Order order = new Order();
        order.setTotalAmount("13200");
        order.setState("1");
        order.setCreationTime("2020-10-21");
        order.setUid("1");

        int insert = mapper.insert(order);
        System.out.println(insert);
    }

    @Test
    public void testdelete(){
        int delete = mapper.delete(4);
        System.out.println(delete);

    }

    @Test
    public void testupdate(){
        Order order = new Order();
        order.setId("1");
        order.setState("6");

        int update = mapper.update(order);
        System.out.println(update);

    }
}

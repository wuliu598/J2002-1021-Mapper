package com.mobiletrain.mapper;

import com.mobiletrain.domain.Order;

import java.util.List;

public interface OrderMapper {
    //查询某用户的所有订单
    public List<Order> queryByUid(String uid);

    //添加一个订单
    public int insert(Order order);

    //删除一个订单
    public int delete(int oid);

    //更新一个订单
    public int update(Order order);
}


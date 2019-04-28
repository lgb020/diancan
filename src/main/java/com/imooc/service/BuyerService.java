package com.imooc.service;

import com.imooc.dto.OrderDTO;

import java.util.List;

/**
 * 买家
 * Created by wwd
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //查询某个用户的所有订单
    List<OrderDTO> findOrderList(String openid, Integer status);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}

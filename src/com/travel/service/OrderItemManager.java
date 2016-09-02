package com.travel.service;

import com.travel.dao.OrderItemDao;
import com.travel.model.OrderItem;

import javax.annotation.Resource;

/**
 * Created by tage on 8/31/16.
 */
public class OrderItemManager {
    private OrderItemDao orderItemDao;

    public OrderItemDao getOrderItemDao() {
        return orderItemDao;
    }

    @Resource
    public void setOrderItemDao(OrderItemDao orderItemDao) {
        this.orderItemDao = orderItemDao;
    }

    public void save(OrderItem orderItem) {
        orderItemDao.add(orderItem);
    }

    public OrderItem loadById(int id) {
        return orderItemDao.loadById(id);
    }

    public void deleteById(int id) {
        orderItemDao.deleteById(id);
    }
}

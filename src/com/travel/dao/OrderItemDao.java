package com.travel.dao;

import com.travel.model.OrderItem;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 8/31/16.
 */
public class OrderItemDao {
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    public OrderItem loadById(int id) {

        List<OrderItem> orderItems = (List<OrderItem>) hibernateTemplate.find("from OrderItem oi where oi.id = ?", id);

        if (orderItems.size() != 0) {
            return orderItems.get(0);
        }
        return null;
    }

    public List<OrderItem> getAll() {
        return (List<OrderItem>) hibernateTemplate.find("from OrderItem oi ");
    }

    public void add(OrderItem orderitem) {
        hibernateTemplate.save(orderitem);
    }

    public void deleteById(int id) {
        OrderItem orderitem = loadById(id);
        hibernateTemplate.delete(orderitem);
    }

    public void update(OrderItem orderitem) {
        hibernateTemplate.update(orderitem);
    }


}

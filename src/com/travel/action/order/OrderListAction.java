package com.travel.action.order;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.model.OrderItem;
import com.travel.model.User;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

/**
 * Created by tage on 8/31/16.
 */
public class OrderListAction extends ActionSupport implements SessionAware {


    private Map<String, Object> session;

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    private List<OrderItem> orderItems;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }


    public String execute() {
        User user = (User) session.get("user");

        if (user == null) {
            session.put("error_message", "Please login in first!");
            return "login";
        } else {
            this.setOrderItems(user.getOrderItems());
            return SUCCESS;
        }
    }


}



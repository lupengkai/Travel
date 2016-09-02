package com.travel.action.order;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.model.OrderItem;
import com.travel.model.User;
import com.travel.service.OrderItemManager;
import com.travel.service.UserManager;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by tage on 8/31/16.
 */
public class OrderDeleteAction extends ActionSupport implements SessionAware {

    private int orderId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    private OrderItemManager orderItemManager;

    public OrderItemManager getOrderManager() {
        return orderItemManager;
    }


    public void setOrderItemManager(OrderItemManager orderItemManager) {
        this.orderItemManager = orderItemManager;
    }

    private Map<String, Object> session;

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }


    private UserManager userManager;

    public OrderItemManager getOrderItemManager() {
        return orderItemManager;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public String execute() {


        User user = (User) session.get("user");
        OrderItem order = orderItemManager.loadById(orderId);
        if (user == null) {
            session.put("error_message", "Please login in first!");
            return "login";
        } else if (order == null) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getSession().setAttribute("error_message", "not found");
            return ERROR;
        } else {


            user = userManager.loadById(user.getId());
            System.out.println("delete order " + order.getId());
     /*       user.getOrderItems().remove(order);*/
            if (user.getOrderItems().contains(order)) {
                orderItemManager.deleteById(orderId);
            }
        /*    orderItemManager.deleteById(orderId);*/


            return SUCCESS;
        }
    }

}
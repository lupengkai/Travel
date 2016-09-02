package com.travel.action.order;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.model.Holiday;
import com.travel.model.OrderItem;
import com.travel.model.Retailer;
import com.travel.model.User;
import com.travel.service.HolidayManager;
import com.travel.service.RetailerManager;
import com.travel.service.UserManager;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

/**
 * Created by tage on 8/31/16.
 */
public class OrderListAction extends ActionSupport implements SessionAware {
    private UserManager userManager;
    private HolidayManager holidayManager;
    private RetailerManager retailerManager;

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public HolidayManager getHolidayManager() {
        return holidayManager;
    }

    public void setHolidayManager(HolidayManager holidayManager) {
        this.holidayManager = holidayManager;
    }

    public RetailerManager getRetailerManager() {
        return retailerManager;
    }

    public void setRetailerManager(RetailerManager retailerManager) {
        this.retailerManager = retailerManager;
    }

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

            user = userManager.loadById(user.getId());


            this.setOrderItems(user.getOrderItems());
            return SUCCESS;
        }
    }


}



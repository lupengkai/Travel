package com.travel.action.holiday;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.model.Holiday;
import com.travel.model.OrderItem;
import com.travel.model.Retailer;
import com.travel.model.User;
import com.travel.service.HolidayManager;
import com.travel.service.OrderItemManager;
import com.travel.service.RetailerManager;
import com.travel.service.UserManager;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by tage on 8/31/16.
 */
public class HolidayAction extends ActionSupport implements SessionAware {

    public int holiday_id;
    public int retailer_id;

    public int getHoliday_id() {
        return holiday_id;
    }

    public void setHoliday_id(int holiday_id) {
        this.holiday_id = holiday_id;
    }

    public int getRetailer_id() {
        return retailer_id;
    }

    public void setRetailer_id(int retailer_id) {
        this.retailer_id = retailer_id;
    }

    private HolidayManager holidayManager;

    public HolidayManager getHolidayManager() {
        return holidayManager;
    }

    public void setHolidayManager(HolidayManager holidayManager) {
        this.holidayManager = holidayManager;
    }


    private OrderItemManager orderItemManager;

    public OrderItemManager getOrderItemManager() {
        return orderItemManager;
    }

    public void setOrderItemManager(OrderItemManager orderItemManager) {
        this.orderItemManager = orderItemManager;
    }


    private RetailerManager retailerManager;


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

    public String in() {
        User user = (User) session.get("user");

        if (user == null) {
            session.put("error_message", "Please login in first!");
            return "login";
        } else {


            Holiday holiday = holidayManager.loadById(holiday_id);
            Retailer retailer = retailerManager.loadById(retailer_id);


            OrderItem orderItem = new OrderItem();
            orderItem.setHoliday(holiday);
            orderItem.setRetailer(retailer);
            orderItem.setUser(user);
            orderItem.setTimestamp(new Timestamp(System.currentTimeMillis()));
            orderItemManager.save(orderItem);


            return "success";
        }
    }


}

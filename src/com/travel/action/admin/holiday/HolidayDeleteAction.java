package com.travel.action.admin.holiday;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.service.HolidayManager;

/**
 * Created by tage on 8/31/16.
 */
public class HolidayDeleteAction extends ActionSupport {

    private int holidayId;

    public int getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(int holidayId) {
        this.holidayId = holidayId;
    }


    private HolidayManager holidayManager;

    public HolidayManager getHolidayManager() {
        return holidayManager;
    }


    public void setHolidayManager(HolidayManager holidayManager) {
        this.holidayManager = holidayManager;
    }


    public String execute() {


        holidayManager.deleteById(holidayId);


        return SUCCESS;
    }

}

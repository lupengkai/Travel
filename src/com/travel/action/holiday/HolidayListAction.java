package com.travel.action.holiday;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.service.HolidayManager;

/**
 * Created by tage on 8/31/16.
 */
public class HolidayListAction extends ActionSupport {
    private HolidayManager holidayManager;

    public HolidayManager getHolidayManager() {
        return holidayManager;
    }

    public void setHolidayManager(HolidayManager holidayManager) {
        this.holidayManager = holidayManager;
    }

}

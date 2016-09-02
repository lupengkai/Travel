package com.travel.action.admin.holiday;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.model.Holiday;
import com.travel.service.HolidayManager;

import java.util.List;

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


    private List<Holiday> allHolidays;

    public List<Holiday> getAllHolidays() {
        return allHolidays;
    }

    public void setAllHolidays(List<Holiday> allHolidays) {
        this.allHolidays = allHolidays;
    }

    @Override
    public String execute() throws Exception {

        this.allHolidays = holidayManager.getAll();
        return SUCCESS;

    }
}

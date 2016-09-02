package com.travel.action.admin.holiday;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.model.Holiday;
import com.travel.service.HolidayManager;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tage on 8/31/16.
 */
public class HolidayDetailAction extends ActionSupport {
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


    private Holiday holiday;


    public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }


    @Override
    public String execute() throws Exception {
        this.holiday = holidayManager.loadById(holidayId);

        if (holiday == null) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getSession().setAttribute("error_message", "not found");

            return ERROR;
        } else {
            return SUCCESS;
        }


    }
}

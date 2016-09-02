package com.travel.action.admin.holiday;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.model.Holiday;
import com.travel.service.HolidayManager;
import com.travel.session.Route;
import com.travel.vo.HolidayInfo;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by tage on 9/1/16.
 */
public class HolidayUpdateInputAction extends ActionSupport {
    private int holidayId;


    public int getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(int holidayId) {
        this.holidayId = holidayId;
    }


    private HolidayInfo holidayInfo;

    public HolidayInfo getHolidayInfo() {
        return holidayInfo;
    }

    public void setHolidayInfo(HolidayInfo holidayInfo) {
        this.holidayInfo = holidayInfo;
    }

    private HolidayManager holidayManager;

    public HolidayManager getHolidayManager() {
        return holidayManager;
    }

    public void setHolidayManager(HolidayManager holidayManager) {
        this.holidayManager = holidayManager;
    }


    @Override
    public String execute() throws Exception {
        Holiday holiday = holidayManager.loadById(holidayId);
        if (holiday == null) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getSession().setAttribute("error_message", "not found");

            return ERROR;
        } else {
            this.holidayInfo = holidayManager.toHolidayInfo(holiday);

            return SUCCESS;

        }


    }
}

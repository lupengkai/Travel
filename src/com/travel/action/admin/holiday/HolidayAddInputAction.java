package com.travel.action.admin.holiday;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.model.Holiday;
import com.travel.service.HolidayManager;
import com.travel.session.Route;
import com.travel.vo.HolidayInfo;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by tage on 9/2/16.
 */
public class HolidayAddInputAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
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
        HolidayInfo holidayInfo = (HolidayInfo) session.get("holidayInfo");
        if (holidayInfo == null) {

            holidayInfo = new HolidayInfo();
            session.put("holidayInfo", holidayInfo);

        }


        return SUCCESS;


    }
}

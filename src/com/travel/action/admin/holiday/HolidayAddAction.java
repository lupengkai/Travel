package com.travel.action.admin.holiday;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.travel.model.Holiday;
import com.travel.service.HolidayManager;

import com.travel.session.Route;
import com.travel.vo.HolidayInfo;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by tage on 8/31/16.
 */
public class HolidayAddAction extends ActionSupport implements SessionAware {


    private HolidayManager holidayManager;

    public HolidayManager getHolidayManager() {
        return holidayManager;
    }


    public void setHolidayManager(HolidayManager holidayManager) {
        this.holidayManager = holidayManager;
    }


    private Map<String, Object> session;

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String execute() {


        HolidayInfo holidayInfo = (HolidayInfo) session.get("holidayInfo");

        if (holidayInfo.getH_theme() == null || holidayInfo.getH_theme().trim().equals("")) {
            System.out.println(holidayInfo.getH_theme());
            System.out.println(holidayInfo.getDays());
            session.put("error_message", "theme is empty");
            return INPUT;
        } else if (holidayInfo.getSceneries().size() == 0) {
            session.put("error_message", "route is empty");
            return "route";
        } else {


            Holiday holiday = new Holiday();
            holiday.setTheme(holidayInfo.getH_theme());
            holiday.setChildPrice(holidayInfo.getChildPrice());
            holiday.setDays(holidayInfo.getDays());
            holiday.setDestination(holidayInfo.getDestination());
            if (holidayInfo.getTimestamp() != null) {
                holiday.setTimestamp(Timestamp.valueOf(holidayInfo.getTimestamp()));
            }

            holiday.setSceneries(holidayInfo.getSceneries());
            session.remove("route");
            holiday.setRetailPrice(holidayInfo.getRetailPrice());
            holiday.setTheme(holidayInfo.getH_theme());
            holiday.setExplanation(holidayInfo.getExplanation());
            holiday.setStudentPrice(holidayInfo.getStudentPrice());
            holiday.setTraffic(holidayInfo.getTraffic());
            session.remove("holidayInfo");


            holidayManager.save(holiday);


            return SUCCESS;
        }
    }

}

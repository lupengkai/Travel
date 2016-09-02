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
public class HolidayUpdateAction extends ActionSupport implements ModelDriven, SessionAware {

    private HolidayInfo holidayInfo = new HolidayInfo();


    public HolidayInfo getHolidayInfo() {
        return holidayInfo;
    }

    public void setHolidayInfo(HolidayInfo holidayInfo) {
        this.holidayInfo = holidayInfo;
    }

    @Override
    public Object getModel() {
        return holidayInfo;
    }

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


    private Route route;

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public String execute() {

        Holiday holiday = holidayManager.loadById(holidayInfo.getId());
        if (holiday == null) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getSession().setAttribute("error_message", "not found");

            return ERROR;
        } else {
            holiday.setTheme(holidayInfo.getH_theme());
            holiday.setChildPrice(holidayInfo.getChildPrice());
            holiday.setDays(holidayInfo.getDays());
            holiday.setDestination(holidayInfo.getDestination());
            holiday.setTimestamp(Timestamp.valueOf(holidayInfo.getTimestamp()));
            holiday.setSceneries(((Route) session.get("route")).getSceneries());
            session.remove("route");
            holiday.setRetailPrice(holidayInfo.getRetailPrice());
            holiday.setTheme(holidayInfo.getH_theme());
            holiday.setExplanation(holidayInfo.getExplanation());
            holiday.setStudentPrice(holidayInfo.getStudentPrice());

            holidayManager.update(holiday);


            return SUCCESS;
        }
    }

}

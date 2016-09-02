package com.travel.action.admin.holiday.route;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.session.Route;
import com.travel.vo.HolidayInfo;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by tage on 9/2/16.
 */
public class RouteAddAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }


    @Override
    public String execute() throws Exception {
        Route route = (Route) session.get("route");
        HolidayInfo holidayInfo = (HolidayInfo) session.get("holidayInfo");
        holidayInfo.setSceneries(route.getSceneries());
        session.put("holidayInfo", holidayInfo);
        session.remove(route);

        return SUCCESS;
    }
}

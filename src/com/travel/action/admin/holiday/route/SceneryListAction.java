package com.travel.action.admin.holiday.route;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.travel.model.Holiday;
import com.travel.model.Scenery;
import com.travel.service.SceneryManager;
import com.travel.session.Route;
import com.travel.vo.HolidayInfo;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

/**
 * Created by tage on 8/31/16.
 */
public class SceneryListAction extends ActionSupport implements ModelDriven, SessionAware {

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

    private Map<String, Object> session;

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }


    private SceneryManager sceneryManager;

    public SceneryManager getSceneryManager() {
        return sceneryManager;
    }

    public void setSceneryManager(SceneryManager sceneryManager) {
        this.sceneryManager = sceneryManager;
    }


    private List<Scenery> allSceneries;

    public List<Scenery> getAllSceneries() {
        return allSceneries;
    }

    public void setAllSceneries(List<Scenery> allSceneries) {
        this.allSceneries = allSceneries;
    }

    @Override
    public String execute() throws Exception {

        HolidayInfo holidayInfo = (HolidayInfo) session.get("holidayInfo");


        holidayInfo = this.holidayInfo;
        session.put("holidayInfo", holidayInfo);
        System.out.println("list" + holidayInfo.getH_theme());

        Route route = (Route) session.get("route");
        if (route == null) {
            route = new Route();
            session.put("route", route);
        }


        this.allSceneries = sceneryManager.getAll();
        return SUCCESS;

    }
}

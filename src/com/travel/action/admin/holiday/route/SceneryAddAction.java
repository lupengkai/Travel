package com.travel.action.admin.holiday.route;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.model.Scenery;
import com.travel.service.SceneryManager;
import com.travel.session.Route;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by tage on 9/2/16.
 */
public class SceneryAddAction extends ActionSupport implements SessionAware {

    private int sceneryId;

    public int getSceneryId() {
        return sceneryId;
    }

    public void setSceneryId(int sceneryId) {
        this.sceneryId = sceneryId;
    }


    private SceneryManager sceneryManager;

    public SceneryManager getSceneryManager() {
        return sceneryManager;
    }

    public void setSceneryManager(SceneryManager sceneryManager) {
        this.sceneryManager = sceneryManager;
    }

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

        Scenery scenery = sceneryManager.loadById(sceneryId);

        if (scenery == null) {
            return ERROR;
        } else {
            Route route = (Route) session.get("route");

            route.add(scenery);

            session.put("route", route);
            return SUCCESS;
        }


    }
}

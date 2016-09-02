package com.travel.action.admin.scenery;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.model.Scenery;
import com.travel.service.SceneryManager;

import java.util.List;

/**
 * Created by tage on 8/31/16.
 */
public class SceneryListAction extends ActionSupport {
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

        this.allSceneries = sceneryManager.getAll();
        return SUCCESS;

    }
}

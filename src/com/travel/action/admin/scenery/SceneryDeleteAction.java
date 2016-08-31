package com.travel.action.admin.scenery;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.travel.model.Scenery;
import com.travel.model.SceneryLevel;
import com.travel.model.SceneryType;
import com.travel.service.SceneryLevelManager;
import com.travel.service.SceneryManager;
import com.travel.service.SceneryTypeManager;
import com.travel.vo.SceneryInfo;

/**
 * Created by tage on 8/31/16.
 */
public class SceneryDeleteAction extends ActionSupport {

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


    public String execute() {


        sceneryManager.deleteById(sceneryId);


        return SUCCESS;
    }

}

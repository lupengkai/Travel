package com.travel.action.admin.scenery;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.model.SceneryLevel;
import com.travel.model.SceneryType;
import com.travel.service.SceneryLevelManager;
import com.travel.service.SceneryTypeManager;

import java.util.List;

/**
 * Created by tage on 9/1/16.
 */
public class SceneryAddInputAction extends ActionSupport {
    private SceneryTypeManager sceneryTypeManager;
    private SceneryLevelManager sceneryLevelManager;

    public SceneryTypeManager getSceneryTypeManager() {
        return sceneryTypeManager;
    }

    public void setSceneryTypeManager(SceneryTypeManager sceneryTypeManager) {
        this.sceneryTypeManager = sceneryTypeManager;
    }

    public SceneryLevelManager getSceneryLevelManager() {
        return sceneryLevelManager;
    }

    public void setSceneryLevelManager(SceneryLevelManager sceneryLevelManager) {
        this.sceneryLevelManager = sceneryLevelManager;
    }


    private List<SceneryLevel> sceneryLevels;

    private List<SceneryType> sceneryTypes;

    public List<SceneryLevel> getSceneryLevels() {
        return sceneryLevels;
    }

    public void setSceneryLevels(List<SceneryLevel> sceneryLevels) {
        this.sceneryLevels = sceneryLevels;
    }

    public List<SceneryType> getSceneryTypes() {
        return sceneryTypes;
    }

    public void setSceneryTypes(List<SceneryType> sceneryTypes) {
        this.sceneryTypes = sceneryTypes;
    }

    @Override
    public String execute() throws Exception {
        this.sceneryLevels = sceneryLevelManager.getAll();
        this.sceneryTypes = sceneryTypeManager.getAll();
        return SUCCESS;
    }
}

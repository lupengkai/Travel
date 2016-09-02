package com.travel.action.admin.scenery;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.model.Scenery;
import com.travel.model.SceneryLevel;
import com.travel.model.SceneryType;
import com.travel.service.SceneryLevelManager;
import com.travel.service.SceneryManager;
import com.travel.service.SceneryTypeManager;
import com.travel.vo.SceneryInfo;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by tage on 9/1/16.
 */
public class SceneryUpdateInputAction extends ActionSupport {
    private int sceneryId;


    public int getSceneryId() {
        return sceneryId;
    }

    public void setSceneryId(int sceneryId) {
        this.sceneryId = sceneryId;
    }


    private SceneryInfo sceneryInfo;

    public SceneryInfo getSceneryInfo() {
        return sceneryInfo;
    }

    public void setSceneryInfo(SceneryInfo sceneryInfo) {
        this.sceneryInfo = sceneryInfo;
    }

    private SceneryManager sceneryManager;

    public SceneryManager getSceneryManager() {
        return sceneryManager;
    }

    public void setSceneryManager(SceneryManager sceneryManager) {
        this.sceneryManager = sceneryManager;
    }

    private SceneryTypeManager sceneryTypeManager;
    private SceneryLevelManager sceneryLevelManager;

    public SceneryLevelManager getSceneryLevelManager() {
        return sceneryLevelManager;
    }

    public void setSceneryLevelManager(SceneryLevelManager sceneryLevelManager) {
        this.sceneryLevelManager = sceneryLevelManager;
    }

    public SceneryTypeManager getSceneryTypeManager() {

        return sceneryTypeManager;
    }

    public void setSceneryTypeManager(SceneryTypeManager sceneryTypeManager) {
        this.sceneryTypeManager = sceneryTypeManager;
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
        Scenery scenery = sceneryManager.loadById(sceneryId);
        if (scenery == null) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getSession().setAttribute("error_message", "not found");

            return ERROR;
        } else {
            this.sceneryInfo = sceneryManager.toSceneryInfo(scenery);

            this.sceneryLevels = sceneryLevelManager.getAll();
            this.sceneryTypes = sceneryTypeManager.getAll();

            return SUCCESS;

        }


    }
}

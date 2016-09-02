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
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

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


        Scenery scenery = sceneryManager.loadById(sceneryId);
        if (scenery == null) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getSession().setAttribute("error_message", "not found");
            return ERROR;
        }


        sceneryManager.deleteById(sceneryId);


        return SUCCESS;
    }

}

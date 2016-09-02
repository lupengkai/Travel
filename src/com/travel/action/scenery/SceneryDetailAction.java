package com.travel.action.scenery;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.model.Scenery;
import com.travel.service.SceneryManager;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tage on 8/31/16.
 */
public class SceneryDetailAction extends ActionSupport {
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


    private Scenery scenery;


    public Scenery getScenery() {
        return scenery;
    }

    public void setScenery(Scenery scenery) {
        this.scenery = scenery;
    }


    @Override
    public String execute() throws Exception {
        this.scenery = sceneryManager.loadById(sceneryId);

        if (scenery == null) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getSession().setAttribute("error_message", "not found");

            return ERROR;
        } else {
            return SUCCESS;
        }


    }
}

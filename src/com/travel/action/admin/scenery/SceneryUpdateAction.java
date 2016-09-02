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
public class SceneryUpdateAction extends ActionSupport implements ModelDriven {

    private SceneryInfo sceneryInfo = new SceneryInfo();


    public SceneryInfo getSceneryInfo() {
        return sceneryInfo;
    }

    public void setSceneryInfo(SceneryInfo sceneryInfo) {
        this.sceneryInfo = sceneryInfo;
    }

    @Override
    public Object getModel() {
        return sceneryInfo;
    }

    private SceneryManager sceneryManager;

    public SceneryManager getSceneryManager() {
        return sceneryManager;
    }


    private SceneryLevelManager sceneryLevelManager;
    private SceneryTypeManager sceneryTypeManager;

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

    public void setSceneryManager(SceneryManager sceneryManager) {
        this.sceneryManager = sceneryManager;
    }


    public String execute() {

        Scenery scenery = sceneryManager.loadById(sceneryInfo.getId());
        if (scenery == null) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getSession().setAttribute("error_message", "not found");

            return ERROR;
        } else if (sceneryInfo.getName() == null || sceneryInfo.getName().trim().equals("")) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getSession().setAttribute("error_message", "name is empty");
            return INPUT;
        } else {
            scenery.setName(sceneryInfo.getName());
            scenery.setCity(sceneryInfo.getCity());
            scenery.setProv(sceneryInfo.getProv());
            scenery.setCoun(sceneryInfo.getCoun());
            scenery.setPrice(sceneryInfo.getPrice());

            SceneryType sceneryType = sceneryTypeManager.loadById(sceneryInfo.getTypeId());
            scenery.setType(sceneryType);

            SceneryLevel sceneryLevel = sceneryLevelManager.loadById(sceneryInfo.getLevelId());


            scenery.setLevel(sceneryLevel);


            scenery.setIntroduction(sceneryInfo.getIntroduction());
            scenery.setPhoto(sceneryInfo.getPhoto());

            sceneryManager.update(scenery);


            return SUCCESS;
        }
    }

}

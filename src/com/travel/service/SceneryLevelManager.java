package com.travel.service;


import com.travel.dao.SceneryLevelDao;
import com.travel.model.SceneryLevel;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 8/30/16.
 */
public class SceneryLevelManager {
    private SceneryLevelDao sceneryLevelDao;


    public SceneryLevelDao getSceneryLevelDao() {
        return sceneryLevelDao;
    }

    @Resource
    public void setSceneryLevelDao(SceneryLevelDao documentTypeDao) {
        this.sceneryLevelDao = sceneryLevelDao;
    }

    public List<SceneryLevel> getAll() {
        return sceneryLevelDao.getAll();
    }

    public SceneryLevel loadById(int id) {
        return sceneryLevelDao.loadById(id);
    }

}

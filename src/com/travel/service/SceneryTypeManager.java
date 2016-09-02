package com.travel.service;


import com.travel.dao.SceneryTypeDao;
import com.travel.model.SceneryType;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 8/30/16.
 */
public class SceneryTypeManager {
    private SceneryTypeDao sceneryTypeDao;


    public SceneryTypeDao getSceneryTypeDao() {
        return sceneryTypeDao;
    }

    @Resource
    public void setSceneryTypeDao(SceneryTypeDao sceneryTypeDao) {
        this.sceneryTypeDao = sceneryTypeDao;
    }

    public List<SceneryType> getAll() {
        return sceneryTypeDao.getAll();
    }

    public SceneryType loadById(int id) {
        return sceneryTypeDao.loadById(id);
    }

}

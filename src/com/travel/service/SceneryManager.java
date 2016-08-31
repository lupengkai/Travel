package com.travel.service;

import com.travel.dao.SceneryDao;
import com.travel.model.Scenery;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 8/31/16.
 */
public class SceneryManager {
    private SceneryDao sceneryDao;


    public SceneryDao getSceneryDao() {
        return sceneryDao;
    }

    @Resource
    public void setSceneryDao(SceneryDao sceneryDao) {
        this.sceneryDao = sceneryDao;
    }

    public List<Scenery> getAll() {
        return sceneryDao.getAll();
    }

    public Scenery loadById(int id) {
        return sceneryDao.loadById(id);
    }

    public void add(Scenery scenery) {
        sceneryDao.add(scenery);
    }


    public void deleteById(int id) {
        sceneryDao.deleteById(id);
    }

    public void update(Scenery scenery) {
        sceneryDao.update(scenery);
    }


}

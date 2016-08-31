package com.travel.service;

import com.travel.dao.HolidayDao;
import com.travel.model.Holiday;
import com.travel.model.Scenery;

import javax.annotation.Resource;

/**
 * Created by tage on 8/31/16.
 */
public class HolidayManager {

    private HolidayDao holidayDao;

    public HolidayDao getHolidayDao() {
        return holidayDao;
    }

    @Resource
    public void setHolidayDao(HolidayDao holidayDao) {
        this.holidayDao = holidayDao;
    }


    public Holiday loadById(int id) {
        return holidayDao.loadById(id);
    }

    public void save(Holiday holiday) {
        holidayDao.add(holiday);
    }

    public void update(Holiday holiday) {
        holidayDao.update(holiday);
    }


    public void addScenery(int holidayId, Scenery scenery) {
        Holiday holiday = this.loadById(holidayId);
        holiday.getSceneries().add(scenery);
    }


}

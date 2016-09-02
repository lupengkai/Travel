package com.travel.service;

import com.travel.dao.HolidayDao;
import com.travel.model.Holiday;
import com.travel.model.Scenery;
import com.travel.vo.HolidayInfo;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

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


    public List<Holiday> getAll() {
        return holidayDao.getAll();
    }


    public HolidayInfo toHolidayInfo(Holiday holiday) {
        HolidayInfo holidayInfo = new HolidayInfo();
        holidayInfo.setId(holiday.getId());
        holidayInfo.setH_theme(holiday.getTheme());
        holidayInfo.setDays(holiday.getDays());
        holidayInfo.setChildPrice(holiday.getChildPrice());
        holidayInfo.setDestination(holiday.getDestination());
        holidayInfo.setStudentPrice(holiday.getStudentPrice());
        holidayInfo.setExplanation(holiday.getExplanation());
        holidayInfo.setRetailPrice(holiday.getRetailPrice());
        holidayInfo.setTimestamp(holiday.getTimestamp().toString());
        holidayInfo.setTraffic(holiday.getTraffic());
        holidayInfo.setSceneries(holiday.getSceneries());
        return holidayInfo;

    }


    public void deleteById(int holidayId) {
        holidayDao.deleteById(holidayId);
    }
}

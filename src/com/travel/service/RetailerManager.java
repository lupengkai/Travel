package com.travel.service;

import com.travel.dao.RetailerDao;
import com.travel.model.Retailer;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 8/31/16.
 */
public class RetailerManager {
    private RetailerDao retailerDao;

    public RetailerDao getRetailerDao() {
        return retailerDao;
    }

    @Resource
    public void setRetailerDao(RetailerDao retailerDao) {
        this.retailerDao = retailerDao;
    }


    public Retailer loadById(int id) {
        return retailerDao.loadById(id);
    }

    public List<Retailer> getAll() {
        return retailerDao.getAll();
    }
}

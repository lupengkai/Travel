package com.travel.dao;

import com.travel.model.Holiday;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 8/31/16.
 */
public class HolidayDao {
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    public Holiday loadById(int id) {
        List<Holiday> holidays = (List<Holiday>) hibernateTemplate.find("from Holiday h where h.id = ?", id);

        if (holidays.size() != 0) {
            return holidays.get(0);
        }
        return null;
    }

    public List<Holiday> getAll() {
        return (List<Holiday>) hibernateTemplate.find("from Holiday h ");
    }

    public void add(Holiday holiday) {
        hibernateTemplate.save(holiday);
    }

    public void deleteById(int id) {
        Holiday holiday = this.loadById(id);
        hibernateTemplate.delete(holiday);
    }

    public void update(Holiday holiday) {
        hibernateTemplate.update(holiday);
    }


}

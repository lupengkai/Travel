package com.travel.dao;

import com.travel.model.Scenery;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 8/31/16.
 */
public class SceneryDao {
    HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }


    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public Scenery loadById(int id) {

        List<Scenery> sceneries = (List<Scenery>) hibernateTemplate.find("from Scenery s where s.id = ?", id);

        if (sceneries.size() != 0) {
            return sceneries.get(0);
        }
        return null;
    }

    public List<Scenery> getAll() {
        return (List<Scenery>) hibernateTemplate.find("from Scenery s ");
    }

    public void add(Scenery scenery) {
        hibernateTemplate.save(scenery);
    }

    public void deleteById(int id) {
        Scenery scenery = loadById(id);
        hibernateTemplate.delete(scenery);
    }

    public void update(Scenery scenery) {
        hibernateTemplate.update(scenery);
    }


}

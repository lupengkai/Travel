package com.travel.dao;

import com.travel.model.DocumentType;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 8/30/16.
 */
public class DocumentTypeDao {
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    public DocumentType loadById(int id) {
        return ((List<DocumentType>)hibernateTemplate.find("from DocumentType dt where dt.id = ?", id)).get(0);
    }

    public List<DocumentType> getAll() {
        return (List<DocumentType>)hibernateTemplate.find("from DocumentType dt ");
    }

}

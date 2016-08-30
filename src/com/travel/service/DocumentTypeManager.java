package com.travel.service;

import com.travel.dao.DocumentTypeDao;
import com.travel.model.DocumentType;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 8/30/16.
 */
public class DocumentTypeManager {
    private DocumentTypeDao documentTypeDao;


    public DocumentTypeDao getDocumentTypeDao() {
        return documentTypeDao;
    }

    @Resource
    public void setDocumentTypeDao(DocumentTypeDao documentTypeDao) {
        this.documentTypeDao = documentTypeDao;
    }

    public List<DocumentType> getAll() {
        return documentTypeDao.getAll();
    }

    public DocumentType loadById(int id) {
        return documentTypeDao.loadById(id);
    }

}

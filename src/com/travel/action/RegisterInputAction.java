package com.travel.action;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.model.DocumentType;
import com.travel.service.DocumentTypeManager;


import java.util.List;

/**
 * Created by tage on 8/30/16.
 */
public class RegisterInputAction extends ActionSupport {
    private DocumentTypeManager documentTypeManager;

    public DocumentTypeManager getDocumentTypeManager() {
        return documentTypeManager;
    }

    public void setDocumentTypeManager(DocumentTypeManager documentTypeManager) {
        this.documentTypeManager = documentTypeManager;
    }


    private List<DocumentType> allDocumentTypes;

    public List<DocumentType> getAllDocumentTypes() {
        return allDocumentTypes;
    }

    public void setAllDocumentTypes(List<DocumentType> allDocumentTypes) {
        this.allDocumentTypes = allDocumentTypes;
    }

    public String execute() {
        this.allDocumentTypes = documentTypeManager.getAll();
        return SUCCESS;
    }



}

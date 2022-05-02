package com.adobe.aem.guides.wknd.core.models;

import org.apache.sling.api.resource.Resource;

public class NastedHalper {
    private String bookEditon;
    private String editonDate;
    public NastedHalper(Resource resource){
        if(resource.getValueMap().get("bookediton", String.class)!=null) {
            this.bookEditon = resource.getValueMap().get("bookediton", String.class);
        }
        if(resource.getValueMap().get("editondate",String.class)!=null){
            this.editonDate=resource.getValueMap().get("editondate",String.class);
        }

    }

    public String getBookEditon() {
        return bookEditon;
    }

    public String getEditonDate() {
        return editonDate;
    }
}

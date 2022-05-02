package com.adobe.aem.guides.wknd.core.models;

import java.util.List;
import java.util.Map;

public interface Author {
	
    String getFname();
    String getLname();
    
    List<Map<String, String>> getBookDetailsWithMap();
}

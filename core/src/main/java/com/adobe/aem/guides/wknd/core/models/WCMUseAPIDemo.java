package com.adobe.aem.guides.wknd.core.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;

public class WCMUseAPIDemo extends WCMUsePojo {
	
	private String currentNodeProperty;
	private String otherResourceProperty;
	private String currentPageTitle;
	private String differentPageTitle;
	
	private Map<String,Object> currentResourceProperties = new HashMap<String, Object>();

	@Override
	public void activate() throws Exception {

		// Fetch Single Property of current resource / component / node
		currentNodeProperty = getProperties().get("fnname", String.class);
		
		// Second way to fetch single property
		ValueMap prop = getResource().adaptTo(ValueMap.class);
		currentNodeProperty += prop.get("textfield",String.class);
		
		// third way to fetch single property
		currentNodeProperty += getResource().getValueMap().get("textfield",String.class);
		
		// Fetch all the properties of component
		ValueMap properties = getResource().adaptTo(ValueMap.class);
		for(Entry<String, Object> entry : properties.entrySet()) {
			currentResourceProperties.put(entry.getKey(),entry.getValue());
		}
		
		// Access different Resource
		ResourceResolver resourceResolver = getResourceResolver();
		Resource resource = resourceResolver.getResource("/content/wknd/us/en/jcr:content/root/container/container/task1");
	
		// first way
		otherResourceProperty = resource.getValueMap().get("check1",String.class);
		
		// Page API
		currentPageTitle = getCurrentPage().getPageTitle().toString();
		
		// Page API -different page title
		Resource res = resourceResolver.getResource("/content/wknd/fr");
		Page page = res.adaptTo(Page.class);
		differentPageTitle = page.getTitle();
	}

	public String getCurrentNodeProperty() {
		return currentNodeProperty;
	}
	
	public Map<String, Object> getCurrentResourceProperties() {
		return currentResourceProperties;
	}

	public String getOtherResourceProperty() {
		return otherResourceProperty;
	}

	public String getCurrentPageTitle() {
		return currentPageTitle;
	}

	public String getDifferentPageTitle() {
		return differentPageTitle;
	}

}

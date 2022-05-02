package com.adobe.aem.guides.wknd.core.models;

import com.adobe.aem.guides.wknd.core.models.Fields;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables = SlingHttpServletRequest.class, adapters=Fields.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FieldsImpl implements Fields {

	@ValueMapValue
	String text1;
	@ValueMapValue 
	String path1;
	@ValueMapValue
	Boolean check1;
	
	
	@Override 
	public String getText1() {
		return text1;
	}

	@Override 
	public String getPath1() {
		return path1;
	}

	@Override
	public Boolean getCheck1() {
		return check1;
	}


}

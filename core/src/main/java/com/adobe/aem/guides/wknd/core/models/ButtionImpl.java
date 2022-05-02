package com.adobe.aem.guides.wknd.core.models;

import javax.inject.Inject;

import com.adobe.aem.guides.wknd.core.models.Button;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
 
@Model(adaptables = Resource.class, adapters=Button.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ButtionImpl implements Button{

	@Inject
	String buttonid;
	
	@Inject
	String buttonpath;
	
	@Override
	public String getButtonone() {
		return buttonid;
	}

	@Override
	public String getButtontwo() {
		return buttonpath;
	}

}

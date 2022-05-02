package com.adobe.aem.guides.wknd.core.models;

import javax.inject.Inject;

import com.adobe.aem.guides.wknd.core.models.Text;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, adapters=Text.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TextImpl implements Text{

	@Inject
	String textid;
	
	@Inject
	String richtext;
	
	@Override
	public String getTextone() {
		return textid;
	}

	@Override
	public String getTexttwo() {
		return richtext;
	}

}

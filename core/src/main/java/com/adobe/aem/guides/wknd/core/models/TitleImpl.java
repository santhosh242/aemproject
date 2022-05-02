package com.adobe.aem.guides.wknd.core.models;

import javax.inject.Inject;

import com.adobe.aem.guides.wknd.core.models.Title;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, adapters=Title.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TitleImpl implements Title{

	@Inject
	String titlesdes;
	
	@Inject
	String titleid;
	
	@Override
	public String getTitleone() {
		return titlesdes;
	}

	@Override
	public String getTitletwo() {
		return titleid;
	}

}

package com.adobe.aem.guides.wknd.core.models;

import javax.inject.Inject;

import com.adobe.aem.guides.wknd.core.models.Supercomp;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, adapters=Supercomp.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SupercompImpl implements Supercomp{

	@Inject
	String buttonid;
	
	@Inject
	String buttonpath;
	
	@Inject
	String textid;
	
	@Inject
	String richtext;
	
	@Inject
	String titlesdes;
	
	@Inject
	String titleid;
	
	@Override
	public String getButtonone() {
		return buttonid;
	}

	@Override
	public String getButtontwo() {
		return buttonpath;
	}

	@Override
	public String getTextone() {
		return textid;
	}

	@Override
	public String getTexttwo() {
		return richtext;
	}
	
	@Override
	public String getTitleone() {
		return titlesdes;
	}

	@Override
	public String getTitletwo() {
		return titleid;
	}
}

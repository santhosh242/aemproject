package com.adobe.aem.guides.wknd.core.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables = SlingHttpServletRequest.class, adapters = Nestedfield.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NestedfieldImpl implements Nestedfield{
	
	private static Logger logger = LoggerFactory.getLogger(NestedfieldImpl.class);

	@ValueMapValue
	private List<String> nastedmultione;
	
	@ValueMapValue
	private List<String> nastedmultitwo;
	
	@ValueMapValue
	private List<String> nastedmultithree;

    @ValueMapValue
	private List<String> nastedmultifour;

	@Override
	public List<Map<String, String>> getNestedMulti() {

		if(nastedmultione !=null) {
			List<Map<String,String>> nest = new ArrayList<>();
			for(int i=0;i<nastedmultione.size();i++) {
				Map<String, String> nestone = new HashMap<>();
				logger.error("repeating-one");
				nestone.put("Nastedmultione",nastedmultione.get(i));
				nestone.put("Nastedmultitwo",nastedmultitwo.get(i));
					for(int j=0;j<5;j++) {
						logger.error("repeating-two");
							nestone.put("Nastedmultithree",nastedmultithree.get(j));
							nestone.put("Nastedmultifour",nastedmultifour.get(j));
							nest.add(nestone);
					}
					nest.add(nestone);
					}
			return nest;
		}
		else {
			return Collections.emptyList();
			}
	}
}

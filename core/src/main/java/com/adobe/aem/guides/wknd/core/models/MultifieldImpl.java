package com.adobe.aem.guides.wknd.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class, adapters = Multifield.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultifieldImpl implements Multifield{

	
	
	@ValueMapValue
	private List<String> bookone;
	
	@ValueMapValue
	private List<String> subjectone;
	
	@ValueMapValue
	private List<String> publishone;

	@Override
	public List<Map<String, String>> getMultiOne() {

		if(bookone !=null) {
			List<Map<String,String>> multi = new ArrayList<>();
			for(int i=0;i<bookone.size();i++) {
				Map<String, String> multione = new HashMap<>();
				multione.put("Bookone",bookone.get(i));
				multione.put("Subjectone",subjectone.get(i));
				multione.put("Publishone",publishone.get(i));
				multi.add(multione);
			}
			return multi;
		}
		else {
			
			return Collections.emptyList();
			}
	}
}

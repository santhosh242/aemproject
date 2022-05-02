package com.adobe.aem.guides.wknd.core.models;

import org.osgi.service.component.annotations.Component;
import static com.adobe.aem.guides.wknd.core.models.AppConstants.URL;
import com.adobe.aem.guides.wknd.core.models.Network;
import com.adobe.aem.guides.wknd.core.models.ReadJsonService;


@Component(immediate = true, service = ReadJsonService.class)
public class ReadJsonDataImpl implements ReadJsonService{


	@Override
    public String getData() {
        String response = Network.readJson(URL);
		
		return response;
    }
    

}

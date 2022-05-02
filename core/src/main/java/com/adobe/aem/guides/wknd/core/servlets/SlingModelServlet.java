package com.adobe.aem.guides.wknd.core.servlets;

import javax.servlet.Servlet;
import org.osgi.framework.Constants;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.guides.wknd.core.models.UserModel;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Sling Demo Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/slingmodel/user" })
public class SlingModelServlet extends SlingSafeMethodsServlet {
	
	private static final long serialVersionUID = 7558680464517017317L;
	
	private static final Logger log = LoggerFactory.getLogger(SlingModelServlet.class);

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {

		try {

			log.info("----------< Processing starts >----------");
			ResourceResolver resourceResolver = request.getResourceResolver();
			Resource resource = resourceResolver.getResource("/content/wknd/us/en/jcr:content/root/container/container/user");
			UserModel model = resource.adaptTo(UserModel.class);
			response.getWriter().print("Data stored in the resource is:\nFirst Name: " + model.getFirstName() + "\nLast Name: " + model.getLastName() + "\nGender: " + model.getGender() + "\nCountry: " + model.getCountry());
			
			resourceResolver.close();

		} catch (Exception e) {

			log.error(e.getMessage(), e);
		}

	}

}
<%@include file="/libs/foundation/global.jsp"%>

<%
com.adobe.aem.guides.wknd.core.models.ReadJsonService service = sling.getService(com.adobe.aem.guides.wknd.core.models.ReadJsonService.class);
String result = service.getData();
%>

<h2>This page invokes the AEM ReadJsonService</h2>
<h3>RESPONSE: <%=result%></h3>
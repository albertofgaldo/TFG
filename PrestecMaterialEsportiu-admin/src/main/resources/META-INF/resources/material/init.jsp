<%@page import="cat.diba.materialesportiu.admin.portlet.display.context.MaterialDisplayContext"%>
<%@page import="cat.diba.materialesportiu.model.Activity"%>
<%@page import="cat.diba.materialesportiu.model.ActivityModel"%>
<%@page import="cat.diba.materialesportiu.model.Material"%>
<%@page import="cat.diba.materialesportiu.model.MaterialModel"%>
<%@page import="cat.diba.materialesportiu.service.MaterialLocalServiceUtil"%>
<%@page import="cat.diba.materialesportiu.service.ActivityLocalServiceUtil"%>
<%@ include file="../init.jsp" %>
<%
MaterialDisplayContext materialDisplayContext = new MaterialDisplayContext(renderRequest, renderResponse);
%>
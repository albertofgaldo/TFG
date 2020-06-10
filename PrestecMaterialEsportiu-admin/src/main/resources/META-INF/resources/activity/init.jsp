<%@page import="cat.diba.materialesportiu.admin.portlet.display.context.ActivityDisplayContext"%>
<%@page import="cat.diba.materialesportiu.model.Activity"%>
<%@page import="cat.diba.materialesportiu.model.ActivityModel"%>
<%@page import="cat.diba.materialesportiu.model.ActivityDependsOn"%>
<%@page import="cat.diba.materialesportiu.service.ActivityLocalServiceUtil"%>
<%@page import="cat.diba.materialesportiu.service.ActivityDependsOnLocalServiceUtil"%>
<%@page import="cat.diba.materialesportiu.service.MaterialLocalServiceUtil"%>
<%@ include file="../init.jsp" %>
<%
ActivityDisplayContext activityDisplayContext = new ActivityDisplayContext(renderRequest, renderResponse);
%>
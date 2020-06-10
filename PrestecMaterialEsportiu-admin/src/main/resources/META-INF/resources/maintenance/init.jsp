<%@page import="cat.diba.materialesportiu.admin.portlet.display.context.MaintenanceDisplayContext"%>
<%@page import="cat.diba.materialesportiu.model.Maintenance"%>
<%@page import="cat.diba.materialesportiu.model.MaintenanceModel"%>
<%@page import="cat.diba.materialesportiu.model.LoanModel"%>
<%@page import="cat.diba.materialesportiu.model.Activity"%>
<%@page import="cat.diba.materialesportiu.model.LocalEntity"%>
<%@page import="cat.diba.materialesportiu.model.Loan"%>
<%@page import="cat.diba.materialesportiu.service.MaintenanceLocalServiceUtil"%>
<%@page import="cat.diba.materialesportiu.service.MaintenanceLocalService"%>
<%@page import="cat.diba.materialesportiu.service.ActivityLocalServiceUtil"%>
<%@page import="cat.diba.materialesportiu.service.LocalEntityLocalServiceUtil"%>
<%@page import="cat.diba.materialesportiu.service.LoanLocalServiceUtil"%>
<%@ include file="../init.jsp" %>
<%
MaintenanceDisplayContext maintenanceDisplayContext = new MaintenanceDisplayContext(renderRequest, renderResponse);
%>
<%@page import="cat.diba.materialesportiu.admin.portlet.display.context.LoanDisplayContext"%>
<%@page import="cat.diba.materialesportiu.model.Loan"%>
<%@page import="cat.diba.materialesportiu.model.LoanModel"%>
<%@page import="cat.diba.materialesportiu.model.LocalEntity"%>
<%@page import="cat.diba.materialesportiu.service.LoanLocalServiceUtil"%>
<%@page import="cat.diba.materialesportiu.service.LocalEntityLocalServiceUtil"%>
<%@page import="cat.diba.materialesportiu.model.Activity"%>
<%@page import="cat.diba.materialesportiu.model.ActivityModel"%>
<%@page import="cat.diba.materialesportiu.model.LoanActivity"%>
<%@page import="cat.diba.materialesportiu.service.ActivityLocalServiceUtil"%>
<%@page import="cat.diba.materialesportiu.service.LoanActivityLocalServiceUtil"%>
<%@page import="java.text.DateFormat"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%@ include file="../init.jsp" %>
<%
LoanDisplayContext loanDisplayContext = new LoanDisplayContext(renderRequest, renderResponse);
%>
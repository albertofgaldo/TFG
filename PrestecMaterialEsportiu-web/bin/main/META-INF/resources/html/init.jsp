<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@

taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@page import="com.liferay.portal.kernel.model.Company"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.taglib.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>




<%@page import="com.liferay.calendar.service.CalendarLocalServiceUtil"%>

<%@page import="cat.diba.materialesportiu.constants.Fields"%>

<%@page import="cat.diba.materialesportiu.model.Loan"%>
<%@page import="cat.diba.materialesportiu.model.LoanModel"%>
<%@page import="cat.diba.materialesportiu.model.LocalEntity"%>
<%@page import="cat.diba.materialesportiu.model.Activity"%>
<%@page import="cat.diba.materialesportiu.model.ActivityModel"%>
<%@page import="cat.diba.materialesportiu.model.LoanActivity"%>

<%@page import="cat.diba.materialesportiu.service.LoanLocalServiceUtil"%>
<%@page import="cat.diba.materialesportiu.service.LocalEntityLocalServiceUtil"%>
<%@page import="cat.diba.materialesportiu.service.ActivityLocalServiceUtil"%>
<%@page import="cat.diba.materialesportiu.service.LoanActivityLocalServiceUtil"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.Format"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>


<liferay-theme:defineObjects />

<portlet:defineObjects />
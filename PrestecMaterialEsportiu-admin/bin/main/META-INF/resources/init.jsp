<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@
taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@page import="cat.diba.materialesportiu.constants.Fields"%>
<%@page import="com.liferay.portal.kernel.portlet.DynamicRenderRequest"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.model.Company"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.LocalizationUtil"%>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatConstants"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePairComparator"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.calendar.service.CalendarLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ResourceURL" %>
<%@page import="java.text.Format"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.time.LocalDate"%>


<%@page import="com.liferay.taglib.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

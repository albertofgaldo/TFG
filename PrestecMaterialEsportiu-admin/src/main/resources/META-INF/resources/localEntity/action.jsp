<%@ include file="./init.jsp" %>
<%@page import="com.liferay.taglib.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
LocalEntity localEntity = null;
		 
if (Validator.isNotNull(row)) {
	localEntity = (LocalEntity)row.getObject();
}
%>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>

		<portlet:renderURL var="editURL">
			<portlet:param name="mvcPath" value="/localEntity/editLocalEntity.jsp" />
			<portlet:param name="<%=Fields.LOCALENTITYID%>" value="<%= String.valueOf(localEntity.getLocalEntityId()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="edit"
			url="<%= editURL %>"
		/>					
		<portlet:actionURL var="deleteLocalEntityURL" name="deleteLocalEntity">
			<portlet:param name="<%=Fields.LOCALENTITYID%>" value="<%= String.valueOf(localEntity.getLocalEntityId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon-delete showIcon="<%= Boolean.TRUE %>"  url="<%= deleteLocalEntityURL %>" />

</liferay-ui:icon-menu>
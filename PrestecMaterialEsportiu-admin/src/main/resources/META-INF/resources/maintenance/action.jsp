<%@ include file="./init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Maintenance maintenance = null;
		 
if (Validator.isNotNull(row)) {
	maintenance = (Maintenance)row.getObject();
}
Date today = new SimpleDateFormat("dd/MM/yyyy").parse(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
%>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
<c:if test="<%= permissionChecker.isOmniadmin() %>">
	
		<c:if test="<%=!maintenance.getIsDone()%>" >	
			<portlet:actionURL var="setMaintenanceDoneURL" name="setMaintenanceDone">	
				<portlet:param name="<%=Fields.MAINTENANCEID%>" value="<%= String.valueOf(maintenance.getMaintenanceId()) %>" />
			</portlet:actionURL>
			<liferay-ui:icon image="check" url="<%= setMaintenanceDoneURL %>" message="message-done-action"/>
		</c:if>
		
		<portlet:renderURL var="editURL">
			<portlet:param name="mvcPath" value="/maintenance/editMaintenance.jsp" />
			<portlet:param name="<%=Fields.MAINTENANCEID%>" value="<%= String.valueOf(maintenance.getMaintenanceId()) %>" />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" url="<%= editURL %>"/>		
		
		<c:if test="<%=maintenance.getIsDone() || (maintenance.getStartDate().before(today) && maintenance.getEndDate().after(today))%>">		
			<portlet:actionURL var="deleteMaintenanceURL" name="deleteMaintenance">
				<portlet:param name="<%=Fields.MAINTENANCEID%>" value="<%= String.valueOf(maintenance.getMaintenanceId()) %>" />
			</portlet:actionURL>
			<liferay-ui:icon-delete showIcon="<%= Boolean.TRUE %>"  url="<%= deleteMaintenanceURL %>" />
		</c:if>
</c:if>
</liferay-ui:icon-menu>
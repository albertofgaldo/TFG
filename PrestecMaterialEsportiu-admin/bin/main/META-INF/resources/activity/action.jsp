
<%@ include file="./init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Activity activity = null;
		 
if (Validator.isNotNull(row)) {
	activity = (Activity)row.getObject();
}
%>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<c:if test="<%= permissionChecker.isOmniadmin() %>">
	
	<portlet:renderURL var="viewMaterialURL">
			<portlet:param name="mvcPath" value="/material/viewMaterial.jsp" />
			<portlet:param name="<%=Fields.ACTIVITYID%>" value="<%= String.valueOf(activity.getActivityId()) %>" />
	</portlet:renderURL>
		<liferay-ui:icon image="manage_task" url="<%= viewMaterialURL %>" message='materials'/>	
		
	<%
	if(!ActivityDependsOnLocalServiceUtil.getActivityDependsOnByParentActivityId(activity.getActivityId()).isEmpty()){
	%>
		<portlet:renderURL var="unitActivityURL">
			<portlet:param name="mvcPath" value="/activity/unitActivity.jsp" />
			<portlet:param name="<%=Fields.ACTIVITYID%>" value="<%= String.valueOf(activity.getActivityId()) %>" />
		</portlet:renderURL>
		<liferay-ui:icon image="manage_task" url="<%= unitActivityURL %>" message="quantity-activity-activity"/>
	<%
	}
	%>		
		<portlet:renderURL var="editURL">
			<portlet:param name="mvcPath" value="/activity/editActivity.jsp" />
			<portlet:param name="<%=Fields.ACTIVITYID%>" value="<%= String.valueOf(activity.getActivityId()) %>" />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" url="<%= editURL %>"/>		
					
		<portlet:actionURL var="deleteActivityURL" name="deleteActivity">
			<portlet:param name="<%=Fields.ACTIVITYID%>" value="<%= String.valueOf(activity.getActivityId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon-delete showIcon="<%= Boolean.TRUE %>"  url="<%= deleteActivityURL %>" />
</c:if>
</liferay-ui:icon-menu>
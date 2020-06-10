<%@ include file="./init.jsp" %>
<% 
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("mvcRenderCommandName", "/maintenance/viewMaintenance");

String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();

Format dateFormatDate = FastDateFormatFactoryUtil.getDate(FastDateFormatConstants.MEDIUM, locale, timeZone); 
Group grupo = GroupLocalServiceUtil.getGroup(portletGroupId);
long grupoId = grupo.getGroupId();
boolean staging = false;
if(grupo.getLiveGroupId()>0){
	grupoId = grupo.getLiveGroupId();
	staging=true;
}

%>

<%
if (staging) {
%>
	<div class="portlet-msg-alert">
		<liferay-ui:message key="mesage-staging" /><br/>
	</div>
<%
}
%>
<%-- ACCIONES --%>
<liferay-portlet:renderURL var="mantenimientos">
    <liferay-portlet:param name="mvcPath" value="/maintenance/viewMaintenance.jsp"/>
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="prestamos">
    <liferay-portlet:param name="mvcPath" value="/loan/viewLoan.jsp"/>
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="materiales">
    <liferay-portlet:param name="mvcPath" value="/material/viewMaterial.jsp"/>
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="actividades">
    <liferay-portlet:param name="mvcPath" value="/activity/viewActivity.jsp"/>
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="entes">
    <liferay-portlet:param name="mvcPath" value="/localEntity/viewLocalEntity.jsp"/>
</liferay-portlet:renderURL>

<div class="container-fluid-1280 main-content-body">
	<div class="row" align="center">		
		<div class="col"><a	class="btn btn-primary btn-block" href="<%=entes%>">Ens Locals</a></div>
		<div class="col"><a class="btn btn-primary btn-block" href="<%=prestamos%>">Préstecs</a></div>		
		<div class="col"><a class="btn btn-primary btn-block" href="<%=actividades%>">Activitats</a></div>
		<div class="col"><a class="btn btn-primary btn-block" href="<%=materiales%>">Materials</a></div>
		<div class="col"><a class="btn btn-primary btn-block disabled" href="<%=mantenimientos%>">Manteniment</a></div>
	</div>
	<h2 class="titol"><%=LanguageUtil.get(request, "title-maintenance")%></h2>
<liferay-util:include page="/maintenance/managementBar.jsp" servletContext="<%= application %>" />
	<aui:form method="post" name="fm">

		<liferay-ui:search-container
			cssClass=""
			id="<%= maintenanceDisplayContext.getSearchContainerId() %>"
			searchContainer="<%= maintenanceDisplayContext.getSearch() %>"
			emptyResultsMessage="no-results-maintenance"
		>
			<liferay-ui:search-container-row
				className="cat.diba.materialesportiu.model.Maintenance"
				keyProperty="<%=Fields.MAINTENANCEID%>"
				modelVar="maintenance"
			>						
				<liferay-ui:search-container-column-text name="activity-id"><%= ActivityLocalServiceUtil.getActivity(maintenance.getActivityId()).getName(locale) %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.LABEL%>">	<%= maintenance.getLabel() %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.DESCRIPTION%>"><%= maintenance.getDescription() %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.START_DATE%>"><%=dateFormatDate.format(maintenance.getStartDate()) %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.END_DATE%>"><%=dateFormatDate.format(maintenance.getEndDate()) %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.ISDONE%>" align="center">	
				<c:if test="<%=maintenance.getIsDone() %>">
					<img src="<%=renderRequest.getContextPath()%>/images/maintenanceDone.png" alt="<%=LanguageUtil.get(request, "alt-maintenance-done")%>" title="<%=LanguageUtil.get(request, "alt-maintenance-done")%>"/>
				</c:if>
				<c:if test="<%=!maintenance.getIsDone() %>">
					<img src="<%=renderRequest.getContextPath()%>/images/maintenance.png" alt="<%=LanguageUtil.get(request, "alt-maintenance")%>" title="<%=LanguageUtil.get(request, "alt-maintenance")%>"/>
				</c:if>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.LOANID%>" >
				<%
				if(maintenance.getLoanId()!=0){
				%>				
					<%=LocalEntityLocalServiceUtil.getLocalEntity(LoanLocalServiceUtil.getLoan(maintenance.getLoanId()).getLocalEntityId()).getName()%>
				<%
				}
				%>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.CREATEDATE%>">	<%=dateFormatDate.format(maintenance.getCreateDate()) %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.MODIFIEDDATE%>"><%=dateFormatDate.format(maintenance.getModifiedDate()) %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-jsp  path="/maintenance/action.jsp"/>
				
			</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator
				displayStyle="list"
				markupView="lexicon"
				searchContainer="<%= searchContainer %>"
			/>
		</liferay-ui:search-container>
	</aui:form>
</div>
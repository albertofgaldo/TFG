<%@ include file="./init.jsp"%>
<% 
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("mvcRenderCommandName", "/activity/viewActivity");

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
		<div class="col"><a class="btn btn-primary btn-block disabled" href="<%=actividades%>">Activitats</a></div>
		<div class="col"><a class="btn btn-primary btn-block" href="<%=materiales%>">Materials</a></div>
		<div class="col"><a class="btn btn-primary btn-block" href="<%=mantenimientos%>">Manteniment</a></div>
	</div>
	<h2 class="titol"><%=LanguageUtil.get(request, "title-activity")%></h2>
	<liferay-util:include page="/activity/managementBar.jsp" servletContext="<%= application %>" />
	<aui:form method="post" name="fm">

		<liferay-ui:search-container
			cssClass=""
			id="<%= activityDisplayContext.getSearchContainerId() %>"
			searchContainer="<%= activityDisplayContext.getSearch() %>"
			emptyResultsMessage="no-results-activity"
		>
			<liferay-ui:search-container-row
				className="cat.diba.materialesportiu.model.Activity"
				keyProperty="<%=Fields.ACTIVITYID%>"
				modelVar="activity"
			>						
				<liferay-ui:search-container-column-text name="<%=Fields.NAME%>">
					<%= activity.getName(locale) %>
					<c:if test="<%=!ActivityDependsOnLocalServiceUtil.getActivityDependsOnByParentActivityId(activity.getActivityId()).isEmpty() %>">
						<i title="<%=LanguageUtil.get(request, "help-activity-hasChilds")%>" class="icon-sitemap"style="font-size:24px"></i>
					</c:if>					
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.TOTAL_STOCK%>">	<%= activity.getTotalStock() %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.AVAILABLE_STOCK%>">	<%= activity.getAvailableStock() %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.DAYSBEFORELOAN%>"><%= activity.getDaysBeforeLoan() + " " + LanguageUtil.get(request, "days") %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.DAYSBOOKING%>"><%= activity.getDaysBooking() + " " + LanguageUtil.get(request, "days") %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.DAYSAFTERLOAN%>">	<%=activity.getDaysAfterLoan() + " " + LanguageUtil.get(request, "days") %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.AGE%>">	<%= activity.getAge() %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.MINPARTICIPANTS%>"><%= activity.getMinParticipants() %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.MAXPARTICIPANTS%>"><%= activity.getMaxParticipants() %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.TITULATIONISREQUIRED%>" align="center">	
				<c:if test='<%=activity.isTitulationIsRequired() %>'>
				<%-- 	<i title="<%=LanguageUtil.get(request, "required-titulation")%>" class="icon-book"style="font-size:24px"></i>--%>
					<img src="<%=renderRequest.getContextPath()%>/images/titulation.png" alt="<%=LanguageUtil.get(request, "required-titulation")%>" title="<%=LanguageUtil.get(request, "required-titulation")%>"/>
				</c:if>
				
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.CREATEDATE%>">	<%=dateFormatDate.format(activity.getCreateDate()) %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.MODIFIEDDATE%>"><%=dateFormatDate.format(activity.getModifiedDate()) %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-jsp  path="/activity/action.jsp"/>
				
			</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator
				displayStyle="list"
				markupView="lexicon"
				searchContainer="<%= searchContainer %>"
			/>
		</liferay-ui:search-container>
	</aui:form>
</div>
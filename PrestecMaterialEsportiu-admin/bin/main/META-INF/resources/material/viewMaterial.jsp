<%@ include file="./init.jsp"%>
<% 
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("mvcRenderCommandName", "/material/viewMaterial");

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
Activity activity= null;
String activityString= "";
long activityId = ParamUtil.getLong(request, Fields.ACTIVITYID, -1);
if(activityId!=-1){
	activity = ActivityLocalServiceUtil.getActivity(activityId);
	activityString = " \"" + activity.getName(locale) + "\"";
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
		<div class="col"><a class="btn btn-primary btn-block disabled" href="<%=materiales%>">Materials</a></div>
		<div class="col"><a class="btn btn-primary btn-block" href="<%=mantenimientos%>">Manteniment</a></div>
	</div>	
	<h2 class="titol"><%=LanguageUtil.get(request, "title-material") + activityString %></h2>
	<liferay-util:include page="/material/managementBar.jsp" servletContext="<%= application %>" />
	
	<aui:form method="post" name="fm">
	<liferay-ui:search-container
			cssClass=""
			id="<%= materialDisplayContext.getSearchContainerId() %>"
			searchContainer="<%= materialDisplayContext.getSearch() %>"
			emptyResultsMessage="no-results-material"
		>
		
		<liferay-ui:search-container-row
				className="cat.diba.materialesportiu.model.Material"
				keyProperty="<%=Fields.MATERIALID%>"
				modelVar="material"
			>	
			<c:if test='<%=activityId==material.getActivityId() || activityId==-1%>'>
					
				<aui:input name="<%=Fields.ACTIVITYID%>" type="hidden"/>				
				<liferay-ui:search-container-column-text name="<%=Fields.NAME%>">		<%= material.getName(locale) %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.VOLUME%>"><%= material.getHeigh()*material.getWidth()*material.getLongitude() + LanguageUtil.get(request, "cubic-meters") %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.HEIGH%>"><%= material.getHeigh() + LanguageUtil.get(request, "centimeters")%></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.WIDTH%>"><%= material.getWidth() + LanguageUtil.get(request, "centimeters") %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.LONGITUDE%>">	<%=material.getLongitude() + LanguageUtil.get(request, "centimeters") %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.WEIGHT%>">	<%=material.getWeight() + LanguageUtil.get(request, "kilograms") %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.CREATEDATE%>">	<%=dateFormatDate.format(material.getCreateDate()) %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.MODIFIEDDATE%>"><%=dateFormatDate.format(material.getModifiedDate()) %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-jsp  path="/material/action.jsp"/>
			</c:if>
</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator
				displayStyle="list"
				markupView="lexicon"
				searchContainer="<%= searchContainer %>"
			/>
		</liferay-ui:search-container>
	</aui:form>
</div>

<%@ include file="./init.jsp"%>
<%
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("mvcRenderCommandName", "/localEntity/viewLocalEntity");

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

<%-- 
<liferay-util:include page="/navigationBar.jsp" servletContext="<%= application %>" />
 --%>
 
<div class="container-fluid-1280 main-content-body">
	<div class="row" align="center">		
		<div class="col"><a	class="btn btn-primary btn-block disabled" href="<%=entes%>">Ens Locals</a></div>
		<div class="col"><a class="btn btn-primary btn-block" href="<%=prestamos%>">Préstecs</a></div>
		<div class="col"><a class="btn btn-primary btn-block" href="<%=actividades%>">Activitats</a></div>	
		<div class="col"><a class="btn btn-primary btn-block" href="<%=materiales%>">Materials</a></div>
		<div class="col"><a class="btn btn-primary btn-block" href="<%=mantenimientos%>">Manteniment</a></div>
	</div>
	<h2 class="titol"><%=LanguageUtil.get(request, "title-local-entity")%></h2>
<liferay-util:include page="/localEntity/managementBar.jsp" servletContext="<%= application %>" />
	<aui:form method="post" name="fm">

		<liferay-ui:search-container
			cssClass=""
			id="<%= localEntityDisplayContext.getSearchContainerId() %>"
			searchContainer="<%= localEntityDisplayContext.getSearch() %>"
			emptyResultsMessage="no-results-localEntity"
		>
			<liferay-ui:search-container-row
				className="cat.diba.materialesportiu.model.LocalEntity"
				keyProperty="<%=Fields.LOCALENTITYID%>"
				modelVar="localEntity"
			>				
		
				<liferay-ui:search-container-column-text name="<%=Fields.CIF%>"> 		<%= localEntity.getCif() %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.NAME%>">		<%= localEntity.getName() %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.TELEPHONE%>">	<%= localEntity.getTelephone() %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.EMAIL%>"><a class="mail" href="mailto:<%= localEntity.getEmail() %>"><%= localEntity.getEmail() %></a></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.CREATEDATE%>">	<%=dateFormatDate.format(localEntity.getCreateDate()) %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.MODIFIEDDATE%>"><%=dateFormatDate.format(localEntity.getModifiedDate()) %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-jsp  path="/localEntity/action.jsp"/>
				
			</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator
				displayStyle="list"
				markupView="lexicon"
				searchContainer="<%= searchContainer %>"
			/>
		</liferay-ui:search-container>
	</aui:form>
</div>
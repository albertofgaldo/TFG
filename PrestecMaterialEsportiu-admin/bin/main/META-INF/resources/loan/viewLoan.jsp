<%@ include file="./init.jsp" %>
<% 
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("mvcRenderCommandName", "/loan/viewLoan");

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
Date today = new SimpleDateFormat("dd/MM/yyyy").parse(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

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
		<div class="col"><a class="btn btn-primary btn-block disabled" href="<%=prestamos%>">Préstecs</a></div>		
		<div class="col"><a class="btn btn-primary btn-block" href="<%=actividades%>">Activitats</a></div>
		<div class="col"><a class="btn btn-primary btn-block" href="<%=materiales%>">Materials</a></div>
		<div class="col"><a class="btn btn-primary btn-block" href="<%=mantenimientos%>">Manteniment</a></div>
	</div>
	<h2 class="titol"><%=LanguageUtil.get(request, "title-loan")%></h2>
	<liferay-util:include page="/loan/managementBar.jsp" servletContext="<%= application %>" />
	
	<aui:form method="post" name="fm">
	<liferay-ui:search-container
			cssClass=""
			id="<%= loanDisplayContext.getSearchContainerId() %>"
			searchContainer="<%= loanDisplayContext.getSearch() %>"
			emptyResultsMessage="no-results-loan"
		>
		
		<liferay-ui:search-container-row
				className="cat.diba.materialesportiu.model.Loan"
				keyProperty="<%=Fields.LOANID%>"
				modelVar="loan"
			>				
				<liferay-ui:search-container-column-text name="<%="local-entity-id"%>">		<%= LocalEntityLocalServiceUtil.getLocalEntity(loan.getLocalEntityId()).getName() %></liferay-ui:search-container-column-text>				
				<liferay-ui:search-container-column-text name="<%=Fields.STATUS%>" align="center">
				<c:choose>
					<c:when test="<%=loan.getStatus().equals(Fields.LoanStatus.NOTCONFIRMED.toString()) %>">											
						<img src="<%=renderRequest.getContextPath()%>/images/notConfirmed.png" alt="<%=LanguageUtil.get(request, "alt-loan-not-confirmed")%>" title="<%=LanguageUtil.get(request, "alt-loan-not-confirmed")%>" />
					</c:when>
					<c:when test="<%=loan.getStatus().equals(Fields.LoanStatus.EXPIRED.toString()) %>">
						<img src="<%=renderRequest.getContextPath()%>/images/expired.png" alt="<%=LanguageUtil.get(request, "alt-loan-expired")%>" title="<%=LanguageUtil.get(request, "alt-loan-expired")%>" />
					</c:when>
					<c:when test="<%=loan.getStatus().equals(Fields.LoanStatus.CONFIRMED.toString()) && loan.getPickupDate().equals(today)%>">
						<img src="<%=renderRequest.getContextPath()%>/images/pickupToday.png" alt="<%=LanguageUtil.get(request, "alt-loan-pickupToday")%>" title="<%=LanguageUtil.get(request, "alt-loan-pickupToday")%>" />
					</c:when>
					<c:when test="<%=loan.getStatus().equals(Fields.LoanStatus.CONFIRMED.toString()) %>">
						<img src="<%=renderRequest.getContextPath()%>/images/confirmed.png" alt="<%=LanguageUtil.get(request, "alt-loan-confirmed")%>" title="<%=LanguageUtil.get(request, "alt-loan-confirmed")%>" />
					</c:when>		
					<c:when test="<%=loan.getStatus().equals(Fields.LoanStatus.BORROWED.toString()) && loan.getReturnDate().equals(today)%>">
						<img src="<%=renderRequest.getContextPath()%>/images/returnDay.png" alt="<%=LanguageUtil.get(request, "alt-loan-returnDay")%>" title="<%=LanguageUtil.get(request, "alt-loan-returnDay")%>" />
					</c:when>			
					<c:when test="<%=loan.getStatus().equals(Fields.LoanStatus.BORROWED.toString()) %>">
						<img src="<%=renderRequest.getContextPath()%>/images/borrowing.png" alt="<%=LanguageUtil.get(request, "alt-loan-borrowing")%>" title="<%=LanguageUtil.get(request, "alt-loan-borrowing")%>" />
					</c:when>					
					<c:when test="<%=loan.getStatus().equals(Fields.LoanStatus.MAINTENANCE.toString())%>">
						<img src="<%=renderRequest.getContextPath()%>/images/revision.png" alt="<%=LanguageUtil.get(request, "alt-loan-revision")%>" title="<%=LanguageUtil.get(request, "alt-loan-revision")%>" />
					</c:when>
					<c:when test="<%=loan.getStatus().equals(Fields.LoanStatus.RETURNED.toString()) %>">
						<img src="<%=renderRequest.getContextPath()%>/images/returned.png" alt="<%=LanguageUtil.get(request, "alt-loan-returned")%>" title="<%=LanguageUtil.get(request, "alt-loan-returned")%>" />
					</c:when>
				</c:choose>				
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.PICKUP_DATE%>">	<%= dateFormatDate.format(loan.getPickupDate()) %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.ACTIVITY_DATE%>"><%= dateFormatDate.format(loan.getActivityDate()) %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.RETURN_DATE%>"><%= dateFormatDate.format(loan.getReturnDate()) %></liferay-ui:search-container-column-text>				
				<liferay-ui:search-container-column-text name="<%=Fields.CONTACT_PERSON%>">	<%=loan.getContactPerson() %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.TELEPHONE%>"><%= loan.getTelephone() %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.EMAIL%>"><a class="mail" href="mailto:<%= loan.getEmail() %>"><%= loan.getEmail() %></a></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.PMT%>">	<%=loan.getPmt() %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.CREATEDATE%>">	<%=dateFormatDate.format(loan.getCreateDate()) %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="<%=Fields.MODIFIEDDATE%>"><%=dateFormatDate.format(loan.getModifiedDate()) %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-jsp  path="/loan/action.jsp"/>
</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator
				displayStyle="list"
				markupView="lexicon"
				searchContainer="<%= searchContainer %>"
			/>
		</liferay-ui:search-container>
	</aui:form>

<footer>
<div id="leyenda" class="row">
	<div >	
		<%--<i title="<%=LanguageUtil.get(request, "help-loan-not-confirmed")%>" class="icon-calendar-empty"style="font-size:24px"></i> --%>	
		<img src="<%=renderRequest.getContextPath()%>/images/notConfirmed.png" alt="<%=LanguageUtil.get(request, "alt-loan-not-confirmed")%>" title="<%=LanguageUtil.get(request, "help-loan-not-confirmed")%>" /><%=LanguageUtil.get(request, "alt-loan-not-confirmed")%>
	</div>
	<div>
		<%--<i title="<%=LanguageUtil.get(request, "help-loan-expired")%>" class="icon-exclamation"style="font-size:24px"></i>--%>
		<img src="<%=renderRequest.getContextPath()%>/images/expired.png" alt="<%=LanguageUtil.get(request, "alt-loan-expired")%>" title="<%=LanguageUtil.get(request, "help-loan-expired")%>"/><%=LanguageUtil.get(request, "alt-loan-expired")%>
	</div>
	<div>
		<%--<i title="<%=LanguageUtil.get(request, "help-loan-confirmed")%>" class="icon-ok"style="font-size:24px"></i>--%>
		<img src="<%=renderRequest.getContextPath()%>/images/confirmed.png" alt="<%=LanguageUtil.get(request, "alt-loan-confirmed")%>" title="<%=LanguageUtil.get(request, "help-loan-confirmed")%>" /><%=LanguageUtil.get(request, "alt-loan-confirmed")%>
	</div>
	<div>
		<%--<i title="<%=LanguageUtil.get(request, "help-loan-pickupToday")%>" class="icon-arrow-down"style="font-size:24px"></i>--%>
		<img src="<%=renderRequest.getContextPath()%>/images/pickupToday.png" alt="<%=LanguageUtil.get(request, "alt-loan-pickupToday")%>" title="<%=LanguageUtil.get(request, "help-loan-pickupToday")%>" /><%=LanguageUtil.get(request, "alt-loan-pickupToday")%>
	</div>
	<div >
		<%--<i title="<%=LanguageUtil.get(request, "help-loan-borrowed")%>" class="icon-suitcase"style="font-size:24px"></i>--%>
		<img src="<%=renderRequest.getContextPath()%>/images/borrowing.png" alt="<%=LanguageUtil.get(request, "alt-loan-borrowing")%>" title="<%=LanguageUtil.get(request, "help-loan-borrowing")%>" /><%=LanguageUtil.get(request, "alt-loan-borrowing")%>
	</div>
	<div >
		<%--<i title="<%=LanguageUtil.get(request, "help-loan-returnToday")%>" class="icon-arrow-up"style="font-size:24px"></i>--%>
		<img src="<%=renderRequest.getContextPath()%>/images/returnDay.png" alt="<%=LanguageUtil.get(request, "alt-loan-returnDay")%>" title="<%=LanguageUtil.get(request, "help-loan-returnDay")%>" /><%=LanguageUtil.get(request, "alt-loan-returnDay")%>
	</div>	
	<div >
	<%--	<i title="<%=LanguageUtil.get(request, "help-loan-revision")%>" class="icon-cogs"style="font-size:24px"></i>--%>
		<img src="<%=renderRequest.getContextPath()%>/images/revision.png" alt="<%=LanguageUtil.get(request, "alt-loan-revision")%>" title="<%=LanguageUtil.get(request, "help-loan-revision")%>" /><%=LanguageUtil.get(request, "alt-loan-revision")%>
	</div>
	<div >
	<%--	<i title="<%=LanguageUtil.get(request, "help-loan-returned")%>" class="icon-home"style="font-size:24px"></i>--%>
		<img src="<%=renderRequest.getContextPath()%>/images/returned.png" alt="<%=LanguageUtil.get(request, "alt-loan-returned")%>" title="<%=LanguageUtil.get(request, "help-loan-returned")%>" /><%=LanguageUtil.get(request, "alt-loan-returned")%>
	</div>
</div>
</footer>
</div>

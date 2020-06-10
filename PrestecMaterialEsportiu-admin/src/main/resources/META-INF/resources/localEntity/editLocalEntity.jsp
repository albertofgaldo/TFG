<%@ include file="./init.jsp"%>

<%
    LocalEntity localEntity = null;

    long localEntityId = ParamUtil.getLong(request, Fields.LOCALENTITYID);

    if (localEntityId > 0) {
        localEntity = LocalEntityLocalServiceUtil.getLocalEntity(Long.valueOf(localEntityId));
    }
%>

<liferay-portlet:renderURL var="cancel">
    <liferay-portlet:param name="mvcPath" value="/localEntity/viewLocalEntity.jsp"/>
</liferay-portlet:renderURL>

<portlet:actionURL var="saveLocalEntityURL" name="saveLocalEntity"/>

<div class="container-fluid-1280 main-content-body">

 <aui:form name="fm" action="<%=saveLocalEntityURL%>" method="post">
 	<aui:model-context bean="<%=localEntity%>" model="<%=LocalEntity.class%>"/>
            <aui:input name="<%=Fields.LOCALENTITYID%>" type="hidden"/>
            
            <% if (localEntity != null) { %>
            <label class="edit"><%=LanguageUtil.get(request, Fields.LOCALENTITYID) + " " + localEntity.getLocalEntityId()%>
            </label>
            <%}%>

			<aui:input name="<%=Fields.CIF%>" ><aui:validator name="required"/></aui:input>
			<aui:input name="<%=Fields.NAME%>" ><aui:validator name="required"/></aui:input>
			<aui:input name="<%=Fields.TELEPHONE%>" ><aui:validator name="required"/></aui:input>
			<aui:input name="<%=Fields.EMAIL%>" type="email"><aui:validator name="required"/></aui:input>

		 <aui:button name="submit" type="submit" value="save"/>
         <aui:button href="<%=cancel%>" type="cancel"/>
	</aui:form>
</div>
<%@ include file="./init.jsp"%>

<%
Group grupo = GroupLocalServiceUtil.getGroup(portletGroupId);
long grupoId = grupo.getGroupId();
if(grupo.getLiveGroupId()>0){
	   grupoId = grupo.getLiveGroupId();
}	  
   long activityId = ParamUtil.getLong(request, Fields.ACTIVITYID);   
   Activity parentActivity = ActivityLocalServiceUtil.getActivity(activityId);
   Activity childActivity = null;		   
   List<ActivityDependsOn> childActivities = ActivityDependsOnLocalServiceUtil.getActivityDependsOnByParentActivityId(activityId); 
%>

<liferay-portlet:renderURL var="cancel">
    <liferay-portlet:param name="mvcPath" value="/activity/viewActivity.jsp"/>
</liferay-portlet:renderURL>

<portlet:actionURL var="saveActivityDependsOnURL" name="saveActivityDependsOn"/>

<div class="container-fluid-1280 main-content-body">

 <aui:form name="fm" action="<%=saveActivityDependsOnURL%>" method="post">
 	<aui:model-context bean="<%=childActivities%>" model="<%=ActivityDependsOn.class%>"/>
 	<aui:input name="<%=Fields.ACTIVITYID%>" type="hidden" value="<%=parentActivity.getActivityId()%>"/>
 			<div align="right">
            <label class="edit"><%=LanguageUtil.get(request, Fields.ACTIVITYID) + ": " + parentActivity.getActivityId()%></label><br>
            <label class="edit"><%=LanguageUtil.get(request, Fields.NAME) + ": " + parentActivity.getName()%></label><br>            
            </div>
            <%
            	for(ActivityDependsOn a : childActivities){
            		childActivity=ActivityLocalServiceUtil.getActivity(a.getActivityId());
            %>           
            <label class="edit"><%=childActivity.getName()%></label><br>    
            <label class="edit"><%=LanguageUtil.get(request, Fields.TOTAL_STOCK) + ": " + childActivity.getTotalStock()%></label><br>
            <aui:input label="<%="quantity-activity"%>" name="<%=String.valueOf(a.getActivityDependsOnId())%>" type="number" value="<%=a.getQuantity()%>" helpMessage="<%=LanguageUtil.get(request, "quantity-max")%>">
            	<aui:validator name="required"/><aui:validator name="required"/>  
            	<aui:validator name="max" errorMessage="error-quantity-total-stock"><%=childActivity.getTotalStock()%></aui:validator>
            </aui:input>           		
		 	<%
            	}
            %>
		 	
		 <aui:button name="submit" type="submit" value="save"/>
         <aui:button href="<%=cancel%>" type="cancel"/>
	</aui:form>
</div>
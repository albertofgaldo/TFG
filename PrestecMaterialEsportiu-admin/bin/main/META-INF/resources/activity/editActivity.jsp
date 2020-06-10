<%@ include file="./init.jsp"%>

<%
Group grupo = GroupLocalServiceUtil.getGroup(portletGroupId);
long grupoId = grupo.getGroupId();
if(grupo.getLiveGroupId()>0){
	   grupoId = grupo.getLiveGroupId();
}	

    Activity activity = null;
    int minStock=0;
    long activityId = ParamUtil.getLong(request, Fields.ACTIVITYID);   
    List<Activity> actualActivities=null;
    boolean exist;
    if (activityId > 0) {
        activity = ActivityLocalServiceUtil.getActivity(Long.valueOf(activityId));  
        actualActivities = ActivityLocalServiceUtil.getChildActivityByActivityId(activityId); 
        minStock=activity.getTotalStock()-activity.getAvailableStock();                   			
    }
    List<Activity> availableActivities = ActivityLocalServiceUtil.getAvailableActivities(activityId, company.getCompanyId(), grupoId);    
%>

<liferay-portlet:renderURL var="cancel">
    <liferay-portlet:param name="mvcPath" value="/activity/viewActivity.jsp"/>
</liferay-portlet:renderURL>

<portlet:actionURL var="saveActivityURL" name="saveActivity"/>

<div class="container-fluid-1280 main-content-body">

 <aui:form name="fm" action="<%=saveActivityURL%>" method="post">
 	<aui:model-context bean="<%=activity%>" model="<%=Activity.class%>"/>
            <aui:input name="<%=Fields.ACTIVITYID%>" type="hidden"/>
            
            <% if (activity != null) { %>
            <label class="edit"><%=LanguageUtil.get(request, Fields.ACTIVITYID) + " " + activity.getActivityId()%></label>
            <%            
            }%>

			<aui:input name="<%=Fields.NAME%>" localized="true"><aui:validator name="required"/></aui:input>           
			<aui:input type="textarea"name="<%=Fields.DESCRIPTION%>" localized="true"><aui:validator name="required"/></aui:input>
			<aui:input type="textarea" name="<%=Fields.USAGERULES%>" localized="true"></aui:input>
			<aui:input type="textarea" name="<%=Fields.LOANCONDITIONS%>" localized="true"></aui:input>
			<div class="row">
			<div class="col-2"><aui:input name="<%=Fields.AGE%>" type="number" helpMessage="<%=LanguageUtil.get(request, "default-value") + String.valueOf(Fields.DEFAULT_AGE)%>"></aui:input></div>
			<div class="col-2"><aui:input name="<%=Fields.MINPARTICIPANTS%>" type="number" helpMessage="<%=LanguageUtil.get(request, "default-value") + String.valueOf(Fields.DEFAULT_MIN_PARTICIPANTS)%>"></aui:input></div>
			<div class="col-2"><aui:input name="<%=Fields.MAXPARTICIPANTS%>" type="number" helpMessage="<%=LanguageUtil.get(request, "default-value") + String.valueOf(Fields.DEFAULT_MAX_PARTICIPANTS)%>"></aui:input></div>
			<div class="col-2"><aui:input name="<%=Fields.TOTAL_STOCK%>" type="number"><aui:validator name="required"/><aui:validator name="required"/><aui:validator name="min" errorMessage="error-quantity-total-stock"><%=minStock %></aui:validator></aui:input></div>
			<div class="col-2"><aui:input name="<%=Fields.TITULATIONISREQUIRED%>" ></aui:input></div>
			</div>
			<div class="row">	
			<div class="col-4"><aui:input name="<%=Fields.DAYSBEFORELOAN%>" type="number" helpMessage="<%=LanguageUtil.get(request, "default-value") + String.valueOf(Fields.DEFAULT_DAYS_BEFORE_LOAN)%>"></aui:input></div>
			<div class="col-4"><aui:input name="<%=Fields.DAYSBOOKING%>" type="number" helpMessage="<%=LanguageUtil.get(request, "default-value") + String.valueOf(Fields.DEFAULT_DAYS_BOOKING)%>"></aui:input></div>
			<div class="col-4"><aui:input name="<%=Fields.DAYSAFTERLOAN%>" type="number" helpMessage="<%=LanguageUtil.get(request, "default-value") + String.valueOf(Fields.DEFAULT_DAYS_AFTER_LOAN)%>"></aui:input></div>
			</div>		
		 	<aui:fieldset collapsed="false" collapsible="true" label="activities-activityDependsOn">	
				<aui:select label="currentChildActivities"  multiple="true" name="currentChildActivities" helpMessage="<%=LanguageUtil.get(request, "material-activity-list-help")%>">	
				<%				
				for(Activity a : availableActivities){	
					exist=false;
					if(actualActivities!=null){
						for(Activity c : actualActivities){							
							if(a.getActivityId()==c.getActivityId()){
								exist=true;
							}
						}
					}
				%>
					<aui:option name="<%=a.getActivityId()%>" localizeLabel="true" selected="<%=exist%>" value="<%=a.getActivityId()%>"><%=a.getName(locale)%></aui:option>
				<%						
				}
				%>
				</aui:select>
			</aui:fieldset>	
		 	
		 <aui:button name="submit" type="submit" value="save"/>
         <aui:button href="<%=cancel%>" type="cancel"/>
	</aui:form>
</div>
<%@ include file="./init.jsp"%>

<%
Group grupo = GroupLocalServiceUtil.getGroup(portletGroupId);
long grupoId = grupo.getGroupId();
if(grupo.getLiveGroupId()>0){
	   grupoId = grupo.getLiveGroupId();
}	

    Maintenance maintenance = null;
    long maintenanceId = ParamUtil.getLong(request, Fields.MAINTENANCEID);
    
    List<Loan> loanList = LoanLocalServiceUtil.getLoanByCompanyGroup(company.getCompanyId(), grupoId);
    //List<Activity> activityList = ActivityLocalServiceUtil.getAvailableStockActivity(company.getCompanyId(), grupoId);    
    List<Activity> activityList = ActivityLocalServiceUtil.getAllActivities();
    if (maintenanceId > 0) {
        maintenance = MaintenanceLocalServiceUtil.getMaintenance(Long.valueOf(maintenanceId));
        //Activity activity = ActivityLocalServiceUtil.getActivity(maintenance.getActivityId());
       // if(!activityList.contains(activity))
       // 	activityList.add(activity);
    }       
    Calendar actualDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
    Date today = new SimpleDateFormat("dd/MM/yyyy").parse(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
%>

<liferay-portlet:renderURL var="cancel">
    <liferay-portlet:param name="mvcPath" value="/maintenance/viewMaintenance.jsp"/>
</liferay-portlet:renderURL>

<portlet:actionURL var="saveMaintenanceURL" name="saveMaintenance"/>

<div class="container-fluid-1280 main-content-body">

 <aui:form name="fm" action="<%=saveMaintenanceURL%>" method="post">
 	<aui:model-context bean="<%=maintenance%>" model="<%=Maintenance.class%>"/>
            <aui:input name="<%=Fields.MAINTENANCEID%>" type="hidden"/>
            
            <% if (maintenance != null) { %>
            <label class="edit"><%=LanguageUtil.get(request, Fields.MAINTENANCEID) + " " + maintenance.getMaintenanceId()%> </label>
            <%}%>			
            <aui:select name="<%=Fields.ACTIVITYID%>" showEmptyOption="true" helpMessage="<%=LanguageUtil.get(request, "help-maintenance-activity")%>"><aui:validator  name="required" />
            <%
            for(Activity m : activityList){	        
            %>
            <aui:option name="<%=m.getActivityId()%>" localizeLabel="true" value="<%=m.getActivityId()%>"><%=m.getName(locale)%></aui:option>
            <%
            }
            %>
    		</aui:select>					
			<aui:input name="<%=Fields.LABEL%>"  helpMessage="<%=LanguageUtil.get(request, "label-text")%>"></aui:input>
			<aui:input name="<%=Fields.DESCRIPTION%>" type="textarea"><aui:validator name="required"/></aui:input>			
			<aui:input type="hidden" name="<%=Fields.START_DATE%>" value="<%=today %>"></aui:input>
			<label><%=LanguageUtil.get(request, Fields.START_DATE)%></label>
			<liferay-ui:input-date disabled="true" name="<%=Fields.START_DATE%>" dayValue="<%=actualDate.get(Calendar.DAY_OF_MONTH)%>" monthValue="<%=actualDate.get(Calendar.MONTH)%>" yearValue="<%=actualDate.get(Calendar.YEAR)%>"/><br>
			<label><%=LanguageUtil.get(request, Fields.END_DATE)%></label>
			<liferay-ui:input-date name="<%=Fields.END_DATE%>" required="true" firstEnabledDate="<%=actualDate.getTime()%>" dayValue="<%=actualDate.get(Calendar.DAY_OF_MONTH)%>" monthValue="<%=actualDate.get(Calendar.MONTH)%>" yearValue="<%=actualDate.get(Calendar.YEAR)%>"/><br>			
			<aui:select name="<%=Fields.LOANID%>" label="<%="entitat-prestec"%>" showEmptyOption="true" helpMessage="<%=LanguageUtil.get(request, "help-maintenance-local-entity")%>">
            <%
            for(Loan l : loanList){	        
            %>
            <aui:option name="<%=l.getLoanId()%>" value="<%=l.getLoanId()%>"><%=LocalEntityLocalServiceUtil.getLocalEntity(l.getLocalEntityId()).getName() + " - " + l.getActivityName()%></aui:option>
            <%
            }
            %>
    		</aui:select>		
		 <aui:button name="submit" type="submit" value="save"/>
         <aui:button href="<%=cancel%>" type="cancel"/>
	</aui:form>
</div>
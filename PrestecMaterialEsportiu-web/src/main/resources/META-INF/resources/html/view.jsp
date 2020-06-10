<%@ include file="./init.jsp" %>

<%   
Group grupo = GroupLocalServiceUtil.getGroup(portletGroupId);
Loan loan=null;
long grupoId = grupo.getGroupId();
int checkBoxCount=0;
if(grupo.getLiveGroupId()>0){
	   grupoId = grupo.getLiveGroupId();
}	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");   
    Calendar actualDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());   
    
    Calendar activityDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());    
    activityDate.add(Calendar.DATE, Fields.DEFAULT_DAYS_CALENDAR_ACTIVITY);
	if(ParamUtil.getDate(renderRequest, Fields.ACTIVITY_DATE, sdf)!=null){
    	activityDate.setTime(ParamUtil.getDate(renderRequest, Fields.ACTIVITY_DATE, sdf));
    }	
       
    Calendar returnDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
    returnDate.add(Calendar.DATE, Fields.DEFAULT_DAYS_CALENDAR_RETURN);    
    if(ParamUtil.getDate(renderRequest, Fields.RETURN_DATE, sdf)!=null){
    	returnDate.setTime(ParamUtil.getDate(renderRequest, Fields.RETURN_DATE, sdf));
    }
       
    Calendar lastLoanDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
    lastLoanDate.add(Calendar.DATE, Fields.DEFAULT_LAST_DAY_LOAN_PERMIT);
    
    List<Activity> allActivities = ActivityLocalServiceUtil.getAllActivities(); 
    
    String tab = ParamUtil.getString(request, "jsp", "loan-date");
    
%>

<liferay-portlet:renderURL var="searchByDates">
    <liferay-portlet:param name="jsp" value="loan-date"/>
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="searchByActivities">			
    <liferay-portlet:param name="jsp" value="loan-material"/>
</liferay-portlet:renderURL>
<liferay-ui:error key="error-loan-dates" message="error-loan-dates" />
<div id="searchTabs">         
            <liferay-ui:tabs  names="loan-date,loan-material" type="tabs" refresh="false" value="<%=tab%>">	
             <aui:form name="fm" action="<%=searchByDates%>" method="post"> 
             <aui:model-context bean="<%=loan%>" model="<%=Loan.class%>"/>              
             <br>
            	<liferay-ui:section>            	
            	<div class="row">
            	<div class="col-5">
            		<label><%=LanguageUtil.get(request, Fields.ACTIVITY_DATE)%></label>       
    				<liferay-ui:input-date name="<%=Fields.ACTIVITY_DATE%>" required="true" firstEnabledDate="<%=actualDate.getTime()%>" lastEnabledDate="<%=lastLoanDate.getTime()%>" dayValue="<%=activityDate.get(Calendar.DAY_OF_MONTH)%>" monthValue="<%=activityDate.get(Calendar.MONTH)%>" yearValue="<%=activityDate.get(Calendar.YEAR)%>"/>
    			</div>
    			<div class="col-5">
    				<label><%=LanguageUtil.get(request, Fields.RETURN_DATE)%></label> 
    				<liferay-ui:input-date  name="<%=Fields.RETURN_DATE%>"  required="true" firstEnabledDate="<%=actualDate.getTime()%>" lastEnabledDate="<%=lastLoanDate.getTime()%>" dayValue="<%=returnDate.get(Calendar.DAY_OF_MONTH)%>" monthValue="<%=returnDate.get(Calendar.MONTH)%>" yearValue="<%=returnDate.get(Calendar.YEAR)%>"/>
    			</div>
    			<div class="col-2" style="margin-top:25px;">
    				<aui:button name="searchByDates" type="submit" value="search"/>
    			</div>
    			</div>
            	</liferay-ui:section>	 
            </aui:form>	
            <aui:form name="fm" action="<%=searchByActivities%>" method="post"> 
            <aui:model-context bean="<%=loan%>" model="<%=Loan.class%>"/>
            	<liferay-ui:section>	
            		<div class="row">           		
    				<center><%=LanguageUtil.get(request, Fields.MATERIALID)%></center>    								
    				</div><br>
    				<div class="row">  
            	<%
            	for(Activity a : allActivities){
            		checkBoxCount++;            		
            	%>   
            		<div class="col-6"><aui:input name="checkbox" label="<%=a.getName() %>" type="checkbox" value="<%=a.getActivityId()%>"></aui:input></div>   			
    				 
    			<%
            	}
    			%>
    			</div>
    			<br>
    			<center>
    			<aui:button name="searchByActivities" type="submit" value="search"/>
    			</center>
    			</liferay-ui:section>	 
    			</aui:form>	
    		</liferay-ui:tabs>	
		<br>	
		<c:if test='<%=activityDate.before(returnDate) || activityDate.equals(returnDate)%>'>
			<c:if test='<%=ParamUtil.getString(request, "jsp").equals("loan-date") %>'>
				<liferay-util:include page="/html/searchByDates.jsp" servletContext="<%= application %>">
					<liferay-util:param name="actualDate" value="<%=sdf.format(actualDate.getTime())%>"/>				
				</liferay-util:include>				
			</c:if>
			<c:if test='<%=ParamUtil.getString(request, "jsp").equals("loan-material") %>'>
				<liferay-util:include page="/html/searchByActivities.jsp" servletContext="<%= application %>">
					<liferay-util:param name="actualDate" value="<%=sdf.format(actualDate.getTime())%>"/>
					<liferay-util:param name="lastLoanDate" value="<%=sdf.format(lastLoanDate.getTime())%>"/>
				</liferay-util:include>				
			</c:if>
		</c:if>
</div>
<aui:script use="node">
   A.all("#searchTabs > ul").addClass('nav-justified');
    
</aui:script>
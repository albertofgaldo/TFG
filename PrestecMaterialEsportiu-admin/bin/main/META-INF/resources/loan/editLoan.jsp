<%@ include file="./init.jsp"%>

<%
Group grupo = GroupLocalServiceUtil.getGroup(portletGroupId);
long grupoId = grupo.getGroupId();
if(grupo.getLiveGroupId()>0){
	   grupoId = grupo.getLiveGroupId();
}	
    Loan loan = null;    
    long loanId = ParamUtil.getLong(request, Fields.LOANID);
    List<LocalEntity> localEntityList = LocalEntityLocalServiceUtil.getLocalEntityByCompanyGroup(company.getCompanyId(), grupoId);
   
    Calendar actualDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());   
    
    Calendar activityDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
    activityDate.add(Calendar.DATE, Fields.DEFAULT_DAYS_CALENDAR_ACTIVITY);
       
    Calendar returnDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
    returnDate.add(Calendar.DATE, Fields.DEFAULT_DAYS_CALENDAR_RETURN);
       
    Calendar lastLoanDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
    lastLoanDate.add(Calendar.DATE, Fields.DEFAULT_LAST_DAY_LOAN_PERMIT);    
    
    int max=ParamUtil.getInteger(request, Fields.ACTIVITYID,1);
    if (loanId > 0) {
    	loan = LoanLocalServiceUtil.getLoan(Long.valueOf(loanId));     
    	activityDate.setTime(loan.getActivityDate());
        returnDate.setTime(loan.getReturnDate());        
    }       
%>

<liferay-portlet:renderURL var="cancel">
    <liferay-portlet:param name="mvcPath" value="/loan/viewLoan.jsp"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="next">
    <liferay-portlet:param name="mvcPath" value="/loan/editLoan2.jsp"/>
</liferay-portlet:renderURL>

<div class="container-fluid-1280 main-content-body">

 <aui:form name="fm" action="<%=next%>" method="post">
 	<aui:model-context bean="<%=loan%>" model="<%=Loan.class%>"/>
            <aui:input name="<%=Fields.LOANID%>" type="hidden"/>
            
            <% if (loan != null) { %>
            <label class="edit"><%=LanguageUtil.get(request, Fields.LOANID) + " " + loan.getLoanId()%></label>            
            <%            
            }%>			 	
            <aui:fieldset collapsed="false" collapsible="true" label="loan-data">			
			 		<aui:select name="<%=Fields.LOCALENTITYID%>" showEmptyOption="true"><aui:validator  name="required"/>
            		<%for(LocalEntity le : localEntityList){              			
            		%>
            			<aui:option name="<%=le.getLocalEntityId()%>" value="<%=le.getLocalEntityId()%>"><%=le.getName()%></aui:option>
            		<% } %>
    				</aui:select>
    				<label><%=LanguageUtil.get(request, Fields.ACTIVITY_DATE)%></label>       
    				<liferay-ui:input-date name="<%=Fields.ACTIVITY_DATE%>" required="true" firstEnabledDate="<%=actualDate.getTime()%>" lastEnabledDate="<%=lastLoanDate.getTime()%>" dayValue="<%=activityDate.get(Calendar.DAY_OF_MONTH)%>" monthValue="<%=activityDate.get(Calendar.MONTH)%>" yearValue="<%=activityDate.get(Calendar.YEAR)%>"/>
    				<label><%=LanguageUtil.get(request, Fields.RETURN_DATE)%></label> 
    				<liferay-ui:input-date  name="<%=Fields.RETURN_DATE%>"  required="true" firstEnabledDate="<%=actualDate.getTime()%>" lastEnabledDate="<%=lastLoanDate.getTime()%>" dayValue="<%=returnDate.get(Calendar.DAY_OF_MONTH)%>" monthValue="<%=returnDate.get(Calendar.MONTH)%>" yearValue="<%=returnDate.get(Calendar.YEAR)%>"/>
    				<br>	
    		</aui:fieldset>	
		<br>		 		 	
		<aui:button name="next" type="submit" value="next"/>
        <aui:button href="<%=cancel%>" type="cancel"/>
	</aui:form>
</div>
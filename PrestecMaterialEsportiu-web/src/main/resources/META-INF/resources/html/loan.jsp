 <%@ include file="./init.jsp" %>
 <%

 	Calendar actualDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());

	Calendar activityDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(),
			themeDisplay.getLocale());
	activityDate.setTime(ParamUtil.getDate(renderRequest, Fields.ACTIVITY_DATE, new SimpleDateFormat("dd/MM/yyyy")));

	Calendar returnDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
	returnDate.setTime(ParamUtil.getDate(renderRequest, Fields.RETURN_DATE, new SimpleDateFormat("dd/MM/yyyy")));

	Calendar lastLoanDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(),
			themeDisplay.getLocale());
	lastLoanDate.add(Calendar.DATE, Fields.DEFAULT_LAST_DAY_LOAN_PERMIT);
	
	String activities[] = ParamUtil.getStringValues(request, Fields.ACTIVITYID);
	String units [] = ParamUtil.getStringValues(request, Fields.QUANTITY);	
	
	int daysBeforeLoan=0;
	for(String s : activities){
		if(!s.isEmpty()){
			if(ActivityLocalServiceUtil.getActivity(Long.parseLong(s)).getDaysBeforeLoan()>daysBeforeLoan){
				daysBeforeLoan=ActivityLocalServiceUtil.getActivity(Long.parseLong(s)).getDaysBeforeLoan();
			}
		}
	}
	Calendar pickupDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(),
			themeDisplay.getLocale());
	pickupDate.setTime(ParamUtil.getDate(renderRequest, Fields.ACTIVITY_DATE, new SimpleDateFormat("dd/MM/yyyy")));
	pickupDate.add(Calendar.DAY_OF_MONTH, -daysBeforeLoan);
    if(pickupDate.before(actualDate)){
    	pickupDate.setTime(actualDate.getTime());
    }
	float totalVolume = 0;
	float totalWeight = 0;
%>

<liferay-portlet:renderURL var="cancel">
    <liferay-portlet:param name="mvcPath" value="/html/view.jsp"/>
</liferay-portlet:renderURL>

 
 <portlet:actionURL var="saveLoanURL" name="saveLoan"/>
  <liferay-ui:error key="error-loan-cif" message="error-loan-cif" />

<div class="container-fluid-1280 main-content-body">
 <aui:form name="fm" action="<%=saveLoanURL%>" method="post">   
           	
					<aui:fieldset collapsed="false" collapsible="true" label="loan-dates">
						<div class="row">
						<div class="col-4">
		    				<label><%=LanguageUtil.get(request, Fields.PICKUP_DATE)%></label> 
		    				<liferay-ui:input-date disabled="true"  name="<%=Fields.PICKUP_DATE%>"  required="true" firstEnabledDate="<%=actualDate.getTime()%>" lastEnabledDate="<%=lastLoanDate.getTime()%>" dayValue="<%=pickupDate.get(Calendar.DAY_OF_MONTH)%>" monthValue="<%=pickupDate.get(Calendar.MONTH)%>" yearValue="<%=pickupDate.get(Calendar.YEAR)%>"/>
		    			</div>		 
		            	<div class="col-4">	            	
		            		<label><%=LanguageUtil.get(request, Fields.ACTIVITY_DATE)%></label>       
		    				<liferay-ui:input-date  disabled="true" name="<%=Fields.ACTIVITY_DATE%>" required="true" firstEnabledDate="<%=actualDate.getTime()%>" lastEnabledDate="<%=lastLoanDate.getTime()%>" dayValue="<%=activityDate.get(Calendar.DAY_OF_MONTH)%>" monthValue="<%=activityDate.get(Calendar.MONTH)%>" yearValue="<%=activityDate.get(Calendar.YEAR)%>"/>
		    			</div>
		    			<div class="col-4">
		    				<label><%=LanguageUtil.get(request, Fields.RETURN_DATE)%></label> 
		    				<liferay-ui:input-date disabled="true"  name="<%=Fields.RETURN_DATE%>"  required="true" firstEnabledDate="<%=actualDate.getTime()%>" lastEnabledDate="<%=lastLoanDate.getTime()%>" dayValue="<%=returnDate.get(Calendar.DAY_OF_MONTH)%>" monthValue="<%=returnDate.get(Calendar.MONTH)%>" yearValue="<%=returnDate.get(Calendar.YEAR)%>"/>
		    			</div>		    			   			
		    			</div>
		    			<div class="hide row">
		    			<div class="col-4">
		    				<label><%=LanguageUtil.get(request, Fields.PICKUP_DATE)%></label> 
		    				<liferay-ui:input-date name="<%=Fields.PICKUP_DATE%>"  required="true" firstEnabledDate="<%=actualDate.getTime()%>" lastEnabledDate="<%=lastLoanDate.getTime()%>" dayValue="<%=pickupDate.get(Calendar.DAY_OF_MONTH)%>" monthValue="<%=pickupDate.get(Calendar.MONTH)%>" yearValue="<%=pickupDate.get(Calendar.YEAR)%>"/>
		    			</div>	
		            	<div class="col-4">
		            		<label><%=LanguageUtil.get(request, Fields.ACTIVITY_DATE)%></label>       
		    				<liferay-ui:input-date name="<%=Fields.ACTIVITY_DATE%>" required="true" firstEnabledDate="<%=actualDate.getTime()%>" lastEnabledDate="<%=lastLoanDate.getTime()%>" dayValue="<%=activityDate.get(Calendar.DAY_OF_MONTH)%>" monthValue="<%=activityDate.get(Calendar.MONTH)%>" yearValue="<%=activityDate.get(Calendar.YEAR)%>"/>
		    			</div>
		    			<div class="col-4">
		    				<label><%=LanguageUtil.get(request, Fields.RETURN_DATE)%></label> 
		    				<liferay-ui:input-date name="<%=Fields.RETURN_DATE%>"  required="true" firstEnabledDate="<%=actualDate.getTime()%>" lastEnabledDate="<%=lastLoanDate.getTime()%>" dayValue="<%=returnDate.get(Calendar.DAY_OF_MONTH)%>" monthValue="<%=returnDate.get(Calendar.MONTH)%>" yearValue="<%=returnDate.get(Calendar.YEAR)%>"/>
		    			</div>		    				    			
		    			</div>
		    			<br>
					</aui:fieldset>				
			 		<aui:fieldset collapsed="false" collapsible="true" label="loan-materials">
			 		<div id="loan-material" class="row">			 		
			 		<%
			 		for(int i=0;i<activities.length;i++){
			 			if(!activities[i].isEmpty()){
			 		%>			 					 		
			 		<div class="col-1">
			 			<label><%=units[i]%></label>
				 	</div>				 	
			 		<div class="col-7">			 			
			 			<label><%=ActivityLocalServiceUtil.getActivity(Long.parseLong(activities[i])).getName(locale)%></label>
				 	</div>	
				 	<div class="col-2">	
				 		<%totalVolume+= ActivityLocalServiceUtil.getTotalVolume(Long.parseLong(activities[i]));%>		 			
			 			<label><%=ActivityLocalServiceUtil.getTotalVolume(Long.parseLong(activities[i]))%><%=LanguageUtil.get(request, "cubic-meters")%></label>
				 	</div>	
				 	<div class="col-2">	
				 		<%totalWeight+= ActivityLocalServiceUtil.getTotalWeight(Long.parseLong(activities[i]));%>		 			
			 			<label><%=ActivityLocalServiceUtil.getTotalWeight(Long.parseLong(activities[i]))%><%=LanguageUtil.get(request, "kilograms")%></label>
				 	</div>		
				 	<div class="col-2">
						<aui:input type="hidden" ignoreRequestValue="true" name="<%=Fields.QUANTITY %>" value="<%=units[i]%>"></aui:input>
					</div>				 	
			 		<div class="col-10">
			 			<aui:input type="hidden" ignoreRequestValue="true" name="<%=Fields.ACTIVITYID %>" value="<%=activities[i]%>"></aui:input>		 			
				 	</div> 						 		 					 		 
				 	<% 
			 		totalVolume=totalVolume*Integer.parseInt(units[i]);
			 		totalWeight=totalWeight*Integer.parseInt(units[i]);
			 			}
			 		}
				 	%>
				 	<div class="col-1">					 		
				 	</div>
				 	<div class="col-7">					 				 			
			 			<label><%=LanguageUtil.get(request, "total-measure")%></label>
				 	</div>
				 	<div class="col-2">					 				 			
			 			<label><%=totalVolume%><%=LanguageUtil.get(request, "cubic-meters")%></label>
				 	</div>	
				 	<div class="col-2">					 			 			
			 			<label><%=totalWeight%><%=LanguageUtil.get(request, "kilograms")%></label>
				 	</div>		
				 	</div>				 	
				 	<br><br>
			 		</aui:fieldset>			 				
			    		<div class="row">	    	
			    		<div class="col-6">
				    	<aui:fieldset collapsed="false" collapsible="true" label="loan-activity" >						    						 			
							<aui:input name="<%=Fields.ACTIVITY_NAME%>" ><aui:validator name="required"/></aui:input>
							<aui:input name="<%=Fields.PARTICIPANTS%>" type="number"></aui:input>
							<aui:input name="<%=Fields.PARTICIPANTS_KIDS%>" type="number"></aui:input>
							<aui:input name="<%=Fields.DESCRIPTION%>" type="textarea"></aui:input>
						</aui:fieldset>
						</div>						
						<div class="col-6">
						<aui:fieldset collapsed="false" collapsible="true" label="loan-contact" >
							<aui:input name="<%=Fields.CIF%>" helpMessage="help-loan-cif" value=""><aui:validator name="required"/></aui:input>
							<aui:input name="<%=Fields.CONTACT_PERSON%>" ><aui:validator name="required"/></aui:input>
							<aui:input name="<%=Fields.POSITION_PERSON%>" ><aui:validator name="required"/></aui:input>
							<aui:input name="<%=Fields.TELEPHONE%>" ><aui:validator name="required"/></aui:input>
							<aui:input name="<%=Fields.EMAIL%>" type="email"><aui:validator name="required"/></aui:input>							
						</aui:fieldset>
						</div>	
						</div>					
					
		<br>		 		 	
		<aui:button name="submit" type="submit" value="booking" onClick="viewFun();" />
        <aui:button href="<%=cancel%>" type="cancel"/>
	</aui:form>
</div>
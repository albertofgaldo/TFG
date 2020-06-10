<%@ include file="./init.jsp" %>
<%
Loan loan = null;
Calendar actualDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());

Calendar activityDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(),
		themeDisplay.getLocale());
activityDate.setTime(ParamUtil.getDate(renderRequest, Fields.ACTIVITY_DATE, new SimpleDateFormat("dd/MM/yyyy")));

Calendar returnDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
returnDate.setTime(ParamUtil.getDate(renderRequest, Fields.RETURN_DATE, new SimpleDateFormat("dd/MM/yyyy")));

Calendar lastLoanDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(),
		themeDisplay.getLocale());
lastLoanDate.add(Calendar.DATE, Fields.DEFAULT_LAST_DAY_LOAN_PERMIT);

	List<Activity> availableActivities = ActivityLocalServiceUtil
			.getActivitiesWithStockBetweenDates(activityDate.getTime(), returnDate.getTime());
	Map<Long, Integer> stockAvailable = new HashMap<>();
	int maxQuantity = 0;	
%>
<liferay-portlet:renderURL var="save">
	<liferay-portlet:param name="mvcPath" value="/html/loan.jsp" />
</liferay-portlet:renderURL>
<div>		
	<aui:form name="fm" action="<%=save%>" method="post">
		<aui:model-context bean="<%=loan%>" model="<%=Loan.class%>"/>
		<div id="dates" class="row">
			<div class="col-6">
				<label><%=LanguageUtil.get(request, Fields.ACTIVITY_DATE)%></label>
				<liferay-ui:input-date name="<%=Fields.ACTIVITY_DATE%>"
					required="true" firstEnabledDate="<%=actualDate.getTime()%>"
					lastEnabledDate="<%=lastLoanDate.getTime()%>"
					dayValue="<%=activityDate.get(Calendar.DAY_OF_MONTH)%>"
					monthValue="<%=activityDate.get(Calendar.MONTH)%>"
					yearValue="<%=activityDate.get(Calendar.YEAR)%>" />
			</div>
			<div class="col-6">
				<label><%=LanguageUtil.get(request, Fields.RETURN_DATE)%></label>
				<liferay-ui:input-date name="<%=Fields.RETURN_DATE%>"
					required="true" firstEnabledDate="<%=actualDate.getTime()%>"
					lastEnabledDate="<%=lastLoanDate.getTime()%>"
					dayValue="<%=returnDate.get(Calendar.DAY_OF_MONTH)%>"
					monthValue="<%=returnDate.get(Calendar.MONTH)%>"
					yearValue="<%=returnDate.get(Calendar.YEAR)%>" />
			</div>
		</div>
		<aui:fieldset collapsed="false" collapsible="true"
			label="loan-materials">
			<div id="member-fields">
				<div class="lfr-form-row lfr-form-row-inline row">
					<div class="col-2">
					<aui:input value="1" min="1" Label="<%=Fields.QUANTITY%>" name="<%=Fields.QUANTITY%>" type="number" helpMessage="<%=LanguageUtil.get(request, "help-loan-quantity")%>"></aui:input>					
					<aui:input disabled="true" name="maxQuantity" value="0"	type="hidden"></aui:input>
					</div>
					<div class="col-9">
					<aui:select 
						showEmptyOption="true"
						label="<%=LanguageUtil.get(request, "combo-materials")%>"
						name="<%=Fields.ACTIVITYID%>" 
						helpMessage="<%=LanguageUtil.get(request, "help-loan-activity")%>">						
						<%
							for (Activity m : availableActivities) {
											stockAvailable.put(m.getActivityId(), LoanLocalServiceUtil.getStockAvailableBetweenDates(
													m.getActivityId(), activityDate.getTime(), returnDate.getTime()));
						%>
						<aui:option data-activity="<%=m.getActivityId()%>"
							data-quantity="<%=stockAvailable.get(m.getActivityId())%>"
							name="<%=Fields.ACTIVITYID%>" localizeLabel="true"
							value="<%=m.getActivityId()%>"><%=m.getName(locale) + " (" + stockAvailable.get(m.getActivityId()) + ")"%></aui:option>
						<%
							}
						%>
					</aui:select>
					</div>					
				</div>
			</div>
		</aui:fieldset>
		<aui:button name="submit" type="submit" value="next" />
	</aui:form>
<aui:script use="event, node, aui-base, liferay-form">
var i=0;
var act;	
var quant;
A.one('#<portlet:namespace />quantity').set('required','true');	
AUI().use('liferay-auto-fields',function(A) {
 new Liferay.AutoFields(
       {
           contentBox: '#member-fields',           
           fieldIndexes: '<portlet:namespace />rowIndexes',           
        on: {
			'clone': function(event) {		
						A.all('#<portlet:namespace />quantity').each(
							function(){
								//this.set('disabled',true);
							}
						);
						A.all('#<portlet:namespace />activityId').each(
			       			function(){
			       				if(this.val()===""){
			       					this.set('value',act);			       					
			       					//this.set('disabled', 'true');
			       				}
			       			}
			       		); 				       			       				
			       		//A.one('#<portlet:namespace />activityId').set('required','true')		       		
			       		A.one('#<portlet:namespace />activityId').set('value','');	
			       		A.one('#<portlet:namespace />maxQuantity').set('value','0');
			       		A.one('#<portlet:namespace />quantity').set('value','1');
			       		//A.one('#<portlet:namespace />quantity').set('disabled',false);				       		
			       			i++;          		 			
			       			//alert("-- Add --");
			 },
       		'delete': function(event) {
       			i--;
       			A.one('#<portlet:namespace />activityId').set('required','false')	
       			A.one('#<portlet:namespace />activityId').set('value','');	
       			A.one('#<portlet:namespace />quantity').set('required','false');
       			A.one('#<portlet:namespace />quantity').set('value','');
       			
       			//alert("-- Delete --");
       		}       		
       	},
       	sortable: true,       	
 }
   ).render();
});	   
 
AUI().use('aui-base', function(A){	
  	//funciona con one y all
	A.all("#<portlet:namespace />activityId").on('change',function(){			 		
	 	act = A.one('#<portlet:namespace />activityId').val();
	 	//A.one('#<portlet:namespace />activityId').set('required','true')	 	
	 	//tiene que ser all 	
	 	A.all('#<portlet:namespace />activityId > option').each(
	 		function(){
	 			if(this.attr('data-activity')===act){
	 				quant = this.attr('data-quantity');	 				
	 				A.one('#<portlet:namespace />maxQuantity').set('value',quant);
	 				A.one('#<portlet:namespace />quantity').set('max',quant);
	 					 				
	 			};
	 		}
	 	);		 		
	})
});
</aui:script>
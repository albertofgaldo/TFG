<%@ include file="./init.jsp"%>
<%
	long loanId = ParamUtil.getLong(request, Fields.LOANID);
	Loan loan = LoanLocalServiceUtil.getLoan(loanId);
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Calendar activityDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(),
			themeDisplay.getLocale());
	activityDate.setTime(ParamUtil.getDate(request, Fields.ACTIVITY_DATE, new SimpleDateFormat("dd/MM/yyyy")));

	Calendar returnDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
	returnDate.setTime(ParamUtil.getDate(request, Fields.RETURN_DATE, new SimpleDateFormat("dd/MM/yyyy")));

	Calendar pickupDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
	pickupDate.setTime(ParamUtil.getDate(request, Fields.PICKUP_DATE, new SimpleDateFormat("dd/MM/yyyy")));

	List <LoanActivity> activities = LoanActivityLocalServiceUtil.getActivityByLoanId(loanId);
	
	//String localEntityName = ParamUtil.getStringValues(request, "localEntityName");

	float totalVolume = 0;
	float totalWeight = 0;
%>

<div class="container-fluid-1280 main-content-body" style="width:fit-content;">
<div align="right">Ref: <%=ParamUtil.getString(request, "loanId")%><br>
<liferay-ui:icon image="print" label="<%= true %>" method="get" url="javascript:print();" />
</div>
<aui:fieldset collapsed="false" collapsible="true" label="loan-dates">
	<div class="row">
		<div class="col-4">
			<label><%=LanguageUtil.get(request, Fields.PICKUP_DATE)%></label><br> <label><%=sdf.format(loan.getPickupDate())%></label>
		</div>
		<div class="col-4">
			<label><%=LanguageUtil.get(request, Fields.ACTIVITY_DATE)%></label><br> <label><%=sdf.format(loan.getActivityDate())%></label>
		</div>
		<div class="col-4">
			<label><%=LanguageUtil.get(request, Fields.RETURN_DATE)%></label><br> <label><%=sdf.format(loan.getReturnDate())%></label>
		</div>
	</div>
	<br>
</aui:fieldset>
<aui:fieldset collapsed="false" collapsible="true"
	label="loan-materials">
	<div id="loan-material" class="row">
		<%
			for (LoanActivity la : activities) {
		%>
		<div class="col-1">
			<label><%=la.getQuantity()%></label>
		</div>
		<div class="col-7">
			<label><%=ActivityLocalServiceUtil.getActivity(la.getActivityId()).getName(locale)%></label>
		</div>
		<div class="col-2">
			<%
				totalVolume += ActivityLocalServiceUtil.getTotalVolume(la.getActivityId());
			%>
			<label><%=ActivityLocalServiceUtil.getTotalVolume(la.getActivityId())%><%=LanguageUtil.get(request, "cubic-meters")%></label>
		</div>
		<div class="col-2">
			<%
				totalWeight += ActivityLocalServiceUtil.getTotalWeight(la.getActivityId());
			%>
			<label><%=ActivityLocalServiceUtil.getTotalWeight(la.getActivityId())%><%=LanguageUtil.get(request, "kilograms")%></label>
		</div>
		<%
			totalVolume = totalVolume * la.getQuantity();
					totalWeight = totalWeight * la.getQuantity();
				}
		%>
		<div class="col-1"></div>
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
	<br>
</aui:fieldset>
<div class="row">
	<div class="col-6">
		<aui:fieldset collapsed="false" collapsible="true" label="loan-activity">
			<div class="resum-header"><%=LanguageUtil.get(request, "activity-name")%>:</div>
			<div class="reum-data"><%=loan.getActivityName()%></div>
			<hr>
			<div class="resum-header"><%=LanguageUtil.get(request, "participants-num")%>:</div>				
			<div class="reum-data"><%=loan.getParticipantsNum()%></div>
			<hr>
			<div class="resum-header"><%=LanguageUtil.get(request, "participants-kids-num")%>:</div>
			<div class="reum-data"><%=loan.getParticipantsKidsNum()%></div>
			<hr>
			<div class="resum-header"><%=LanguageUtil.get(request, Fields.DESCRIPTION)%>:</div>
			<div class="reum-data"><%=loan.getDescription()%></div>			
		</aui:fieldset>
	</div>
	<div class="col-6">
		<aui:fieldset collapsed="false" collapsible="true"
			label="loan-contact">
			<div class="resum-header"><%=LanguageUtil.get(request, "entitat")%>:</div>
			<div class="reum-data"><%=LocalEntityLocalServiceUtil.getLocalEntity(loan.getLocalEntityId()).getName()%></div>
			<hr>
			<div class="resum-header"><%=LanguageUtil.get(request, "contact-person")%>:</div>
			<div class="reum-data"><%=loan.getContactPerson()%></div>
			<hr>
			<div class="resum-header"><%=LanguageUtil.get(request, "position-person")%>:</div>
			<div class="reum-data"><%=loan.getPositionPerson()%></div>
			<hr>
			<div class="resum-header"><%=LanguageUtil.get(request, Fields.TELEPHONE)%>:</div>
			<div class="reum-data"><%=loan.getTelephone()%></div>
			<hr>
			<div class="resum-header"><%=LanguageUtil.get(request, Fields.EMAIL)%>:</div>
			<div class="reum-data"><%=loan.getEmail()%></div>			
		</aui:fieldset>
	</div>	
</div>
</div>
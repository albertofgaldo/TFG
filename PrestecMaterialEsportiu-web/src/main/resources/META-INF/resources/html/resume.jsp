<%@ include file="./init.jsp"%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Calendar activityDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(),
			themeDisplay.getLocale());
	activityDate.setTime(ParamUtil.getDate(request, Fields.ACTIVITY_DATE, new SimpleDateFormat("dd/MM/yyyy")));

	Calendar returnDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
	returnDate.setTime(ParamUtil.getDate(request, Fields.RETURN_DATE, new SimpleDateFormat("dd/MM/yyyy")));

	Calendar pickupDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
	pickupDate.setTime(ParamUtil.getDate(request, Fields.PICKUP_DATE, new SimpleDateFormat("dd/MM/yyyy")));

	String activities[] = ParamUtil.getStringValues(request, Fields.ACTIVITYID);
	String units[] = ParamUtil.getStringValues(request, Fields.QUANTITY);

	//String localEntityName = ParamUtil.getStringValues(request, "localEntityName");

	float totalVolume = 0;
	float totalWeight = 0;
%>
<h2 class="titol"><%=LanguageUtil.get(request, "booked")%></h2>
<div align="right">Ref: <%=ParamUtil.getString(request, "loanId")%><br>
<liferay-ui:icon image="print" label="<%= true %>" method="get" url="javascript:print();" />
</div>
<aui:fieldset collapsed="false" collapsible="true" label="loan-dates">
	<div class="row">
		<div class="col-4">
			<label><%=LanguageUtil.get(request, Fields.PICKUP_DATE)%></label><br> <label><%=sdf.format(pickupDate.getTime())%></label>
		</div>
		<div class="col-4">
			<label><%=LanguageUtil.get(request, Fields.ACTIVITY_DATE)%></label><br> <label><%=sdf.format(activityDate.getTime())%></label>
		</div>
		<div class="col-4">
			<label><%=LanguageUtil.get(request, Fields.RETURN_DATE)%></label><br> <label><%=sdf.format(returnDate.getTime())%></label>
		</div>
	</div>
	<br>
</aui:fieldset>
<aui:fieldset collapsed="false" collapsible="true"
	label="loan-materials">
	<div id="loan-material" class="row">
		<%
			for (int i = 0; i < activities.length; i++) {
		%>
		<div class="col-1">
			<label><%=units[i]%></label>
		</div>
		<div class="col-7">
			<label><%=ActivityLocalServiceUtil.getActivity(Long.parseLong(activities[i])).getName(locale)%></label>
		</div>
		<div class="col-2">
			<%
				totalVolume += ActivityLocalServiceUtil.getTotalVolume(Long.parseLong(activities[i]));
			%>
			<label><%=ActivityLocalServiceUtil.getTotalVolume(Long.parseLong(activities[i]))%><%=LanguageUtil.get(request, "cubic-meters")%></label>
		</div>
		<div class="col-2">
			<%
				totalWeight += ActivityLocalServiceUtil.getTotalWeight(Long.parseLong(activities[i]));
			%>
			<label><%=ActivityLocalServiceUtil.getTotalWeight(Long.parseLong(activities[i]))%><%=LanguageUtil.get(request, "kilograms")%></label>
		</div>
		<%
			totalVolume = totalVolume * Integer.parseInt(units[i]);
					totalWeight = totalWeight * Integer.parseInt(units[i]);
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
			<div class="reum-data"><%=ParamUtil.getString(request, Fields.ACTIVITY_NAME)%></div>
			<hr>
			<div class="resum-header"><%=LanguageUtil.get(request, "participants-num")%>:</div>				
			<div class="reum-data"><%=ParamUtil.getString(request, Fields.PARTICIPANTS)%></div>
			<hr>
			<div class="resum-header"><%=LanguageUtil.get(request, "participants-kids-num")%>:</div>
			<div class="reum-data"><%=ParamUtil.getString(request, Fields.PARTICIPANTS_KIDS)%></div>
			<hr>
			<div class="resum-header"><%=LanguageUtil.get(request, Fields.DESCRIPTION)%>:</div>
			<div class="reum-data"><%=ParamUtil.getString(request, Fields.DESCRIPTION)%></div>			
		</aui:fieldset>
	</div>
	<div class="col-6">
		<aui:fieldset collapsed="false" collapsible="true"
			label="loan-contact">
			<div class="resum-header"><%=LanguageUtil.get(request, "entitat")%>:</div>
			<div class="reum-data"><%=ParamUtil.getString(request, "localEntityName")%></div>
			<hr>
			<div class="resum-header"><%=LanguageUtil.get(request, "contact-person")%>:</div>
			<div class="reum-data"><%=ParamUtil.getString(request,Fields.CONTACT_PERSON )%></div>
			<hr>
			<div class="resum-header"><%=LanguageUtil.get(request, "position-person")%>:</div>
			<div class="reum-data"><%=ParamUtil.getString(request,Fields.POSITION_PERSON)%></div>
			<hr>
			<div class="resum-header"><%=LanguageUtil.get(request, Fields.TELEPHONE)%>:</div>
			<div class="reum-data"><%=ParamUtil.getString(request, Fields.TELEPHONE)%></div>
			<hr>
			<div class="resum-header"><%=LanguageUtil.get(request, Fields.EMAIL)%>:</div>
			<div class="reum-data"><%=ParamUtil.getString(request, Fields.EMAIL)%></div>			
		</aui:fieldset>
	</div>	
</div>
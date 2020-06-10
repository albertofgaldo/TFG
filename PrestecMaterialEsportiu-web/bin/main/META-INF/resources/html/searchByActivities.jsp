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

List<Activity> availableActivities = ActivityLocalServiceUtil.getActivitiesWithStockBetweenDates(activityDate.getTime(), returnDate.getTime());
Map<Long, Integer> stockAvailable = new HashMap<>();
	int maxQuantity = 0;	
//Calendarios	
int firstMonth = actualDate.get(Calendar.MONTH);
int lastMonth = lastLoanDate.get(Calendar.MONTH);
String headerPattern = "MMMM yyyy"; 
Format dateFormat = FastDateFormatFactoryUtil.getSimpleDateFormat(headerPattern, locale);

%>
<div class="taglib-calendar">
	<table class="lfr-table calendar-panel">
		<tr class="calendar-header">           
            <th colspan="5">
              <%=StringUtil.upperCaseFirstLetter(dateFormat.format(actualDate.getTime()).replaceAll("^de ", ""))%>
            </th>      
            <tr class="portlet-section-header results-header">
        	<%
        	for (int i = 0; i < 7; i++) {
        		int daysIndex = (actualDate.getFirstDayOfWeek() + i - 1) % 7;

        		String className = StringPool.BLANK;

        		if (i == 0) {
        			className = "first";
        		} else if (i == 5) {
        			className = "festivo";
        		} else if (i == 6) {
        			className = "festivo";
        		}
        	%>
            <th class="<%=className%>">
                <%=StringUtil.lowerCase(LanguageUtil.get(request,CalendarUtil.DAYS_ABBREVIATION[daysIndex]))%>
            </th>
        	<%
        	}
        	%>
    		</tr>      
        </tr>
	</table>
</div>
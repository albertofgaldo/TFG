<%@ include file="./init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Loan loan = null;
		 
if (Validator.isNotNull(row)) {
	loan = (Loan)row.getObject();
}
Date today = new SimpleDateFormat("dd/MM/yyyy").parse(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
%>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<c:if test="<%= permissionChecker.isOmniadmin() %>">
		<c:if test="<%=loan.getStatus().equals(Fields.LoanStatus.CONFIRMED.toString()) && loan.getPickupDate().equals(today)%>">
			<portlet:actionURL var="pickupedLoanURL" name="pickupedLoan">			
				<portlet:param name="<%=Fields.LOANID%>" value="<%= String.valueOf(loan.getLoanId()) %>" />
			</portlet:actionURL>
			<liferay-ui:icon image="join" url="<%= pickupedLoanURL %>" message="action-pickuped-loan"/>
		</c:if>		
		
		<c:if test="<%=LoanLocalServiceUtil.getLoan(loan.getLoanId()).getStatus().equals(Fields.LoanStatus.NOTCONFIRMED.toString()) %>">		
			<portlet:renderURL var="popup" windowState="<%=LiferayWindowState.POP_UP.toString()%>">			
				<portlet:param name="mvcPath" value="/loan/pmt.jsp"/>
				<portlet:param name="<%=Fields.LOANID%>" value="<%= String.valueOf(loan.getLoanId()) %>" />			
			</portlet:renderURL >
			<aui:input name="<%=Fields.PMT%>" type="hidden" ><aui:validator name="required"/></aui:input>
			<% String urlPopupPmt = "javascript:showPmt('" + popup + "')"; %>
			<liferay-ui:icon url="<%=urlPopupPmt%>" image="checked" message="action-confirm-loan"/>
		</c:if> 	
		
		<c:if test="<%=LoanLocalServiceUtil.getLoan(loan.getLoanId()).getStatus().equals(Fields.LoanStatus.BORROWED.toString()) %>">	
			<portlet:actionURL var="returnLoanURL" name="returnLoan">			
				<portlet:param name="<%=Fields.LOANID%>" value="<%= String.valueOf(loan.getLoanId()) %>" />
			</portlet:actionURL>
			<liferay-ui:icon image="home" url="<%= returnLoanURL %>" message="action-return-loan"/>
		</c:if>		
		<portlet:renderURL var="popup" windowState="<%=LiferayWindowState.POP_UP.toString()%>">			
			<portlet:param name="mvcPath" value="/loan/resume.jsp" />
			<portlet:param name="<%=Fields.LOANID%>" value="<%= String.valueOf(loan.getLoanId()) %>" />
		</portlet:renderURL>
		<% String urlPopupResume = "javascript:showResume('" + popup + "', '" + LanguageUtil.get(request, loan.getStatus().toString().toLowerCase()) + "')"; %>
		<liferay-ui:icon image="view" url="<%= urlPopupResume %>" message="action-resume-loan"/>	
	
			
		<c:if test="<%=
		LoanLocalServiceUtil.getLoan(loan.getLoanId()).getStatus().equals(Fields.LoanStatus.NOTCONFIRMED.toString()) ||
		LoanLocalServiceUtil.getLoan(loan.getLoanId()).getStatus().equals(Fields.LoanStatus.EXPIRED.toString()) ||
		LoanLocalServiceUtil.getLoan(loan.getLoanId()).getStatus().equals(Fields.LoanStatus.CONFIRMED.toString()) ||
		LoanLocalServiceUtil.getLoan(loan.getLoanId()).getStatus().equals(Fields.LoanStatus.RETURNED.toString())
		%>">	
			<portlet:renderURL var="editURL">
				<portlet:param name="mvcPath" value="/loan/editLoan.jsp" />
				<portlet:param name="<%=Fields.LOANID%>" value="<%= String.valueOf(loan.getLoanId()) %>" />
			</portlet:renderURL>
			<liferay-ui:icon image="edit" url="<%= editURL %>"/>					
			<portlet:actionURL var="deleteLoanURL" name="deleteLoan">
				<portlet:param name="<%=Fields.LOANID%>" value="<%= String.valueOf(loan.getLoanId()) %>" />
			</portlet:actionURL>
			<liferay-ui:icon-delete showIcon="<%= Boolean.TRUE %>"  url="<%= deleteLoanURL %>" />
		</c:if>
</c:if>
</liferay-ui:icon-menu>
<!-- AUI Script For IFrame POPUP -->
<aui:script>
    function showPmt(url)
    {
    Liferay.Util.openWindow(
    {
    dialog: {
    cache: false,
    width:300,
    height: 280,
    destroyOnClose: true,
    centered: true,
    resizable: false,

    modal: true
    },
    title: '<%=LanguageUtil.get(request, "action-confirm-loan")%>',
    id: '<portlet:namespace/>popUpDialog',
    uri: url
    }


    );

    Liferay.provide(
    window,
    '<portlet:namespace/>closePopup',
    function(popupIdToClose) {
    var popupDialog = Liferay.Util.Window.getById(popupIdToClose);
    popupDialog.destroy();
    location.reload();
    },
    ['liferay-util-window']
    );

    }
    
    function showResume(url, status)
    {
    Liferay.Util.openWindow(
    {
    dialog: {
    cache: false,
    width:800,
    height: 1200,
    destroyOnClose: true,
    centered: true,
    resizable: false,

    modal: true
    },
    title: status,
    id: '<portlet:namespace/>popUpDialog',
    uri: url
    }


    );

    Liferay.provide(
    window,
    '<portlet:namespace/>closePopup',
    function(popupIdToClose) {
    var popupDialog = Liferay.Util.Window.getById(popupIdToClose);
    popupDialog.destroy();
    location.reload();
    },
    ['liferay-util-window']
    );

    }
</aui:script>
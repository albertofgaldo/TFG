<%@ include file="./init.jsp"%>
<div class="container-fluid-1280 main-content-body">
	<portlet:renderURL var="viewLoanURL">
			<portlet:param name="mvcPath" value="/loan/viewLoan.jsp" />
			<portlet:param name="<%=Fields.LOANID%>" value="<%=ParamUtil.getString(request,Fields.LOANID) %>" />
			<portlet:param name="<%=Fields.PMT%>" value="<%=ParamUtil.getString(request,Fields.PMT) %>" />
			
	</portlet:renderURL>
<portlet:actionURL var="savePmtURL" name="savePmt"/>	
	 <aui:form name="fm" action="<%=savePmtURL.toString()%>" method="post">	 			
	            <aui:input name="<%=Fields.LOANID%>" value="<%=ParamUtil.getString(request,Fields.LOANID) %>" type="hidden"/>
	            <aui:input name="<%=Fields.PMT%>"/>	            
	            <aui:button name="submit" type="submit" value="save"/>         
	</aui:form>
</div>

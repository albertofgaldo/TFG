<%@ include file="../init.jsp" %>
<%@ include file="./init.jsp" %>
<clay:management-toolbar
	clearResultsURL="<%= loanDisplayContext.getClearResultsURL() %>"
	creationMenu="<%= loanDisplayContext.getCreationMenu() %>"
	disabled="<%= loanDisplayContext.isDisabledManagementBar() %>"
	filterDropdownItems="<%= loanDisplayContext.getFilterItemsDropdownItems() %>"
	itemsTotal="<%= loanDisplayContext.getTotalItems() %>"
	namespace="<%= renderResponse.getNamespace() %>"
	searchActionURL="<%= loanDisplayContext.getSearchActionURL() %>"
	searchContainerId="<%= loanDisplayContext.getSearchContainerId() %>"
	searchFormName="fm1"
	selectable="false"
	sortingOrder="<%= loanDisplayContext.getOrderByType() %>"
	sortingURL="<%= loanDisplayContext.getSortingURL() %>"
/>
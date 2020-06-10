<%@ include file="../init.jsp" %>
<%@ include file="./init.jsp" %>
<clay:management-toolbar
	clearResultsURL="<%= localEntityDisplayContext.getClearResultsURL() %>"
	creationMenu="<%= localEntityDisplayContext.getCreationMenu() %>"
	disabled="<%= localEntityDisplayContext.isDisabledManagementBar() %>"
	filterDropdownItems="<%= localEntityDisplayContext.getFilterItemsDropdownItems() %>"
	itemsTotal="<%= localEntityDisplayContext.getTotalItems() %>"
	namespace="<%= renderResponse.getNamespace() %>"
	searchActionURL="<%= localEntityDisplayContext.getSearchActionURL() %>"
	searchContainerId="<%= localEntityDisplayContext.getSearchContainerId() %>"
	searchFormName="fm1"
	selectable="false"
	sortingOrder="<%= localEntityDisplayContext.getOrderByType() %>"
	sortingURL="<%= localEntityDisplayContext.getSortingURL() %>"
/>
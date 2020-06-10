<%@ include file="../init.jsp" %>
<%@ include file="./init.jsp" %>
<clay:management-toolbar
	clearResultsURL="<%= materialDisplayContext.getClearResultsURL() %>"
	creationMenu="<%= materialDisplayContext.getCreationMenu() %>"
	disabled="<%= materialDisplayContext.isDisabledManagementBar() %>"
	filterDropdownItems="<%= materialDisplayContext.getFilterItemsDropdownItems() %>"
	itemsTotal="<%= materialDisplayContext.getTotalItems() %>"
	namespace="<%= renderResponse.getNamespace() %>"
	searchActionURL="<%= materialDisplayContext.getSearchActionURL() %>"
	searchContainerId="<%= materialDisplayContext.getSearchContainerId() %>"
	searchFormName="fm1"
	selectable="false"
	sortingOrder="<%= materialDisplayContext.getOrderByType() %>"
	sortingURL="<%= materialDisplayContext.getSortingURL() %>"
/>
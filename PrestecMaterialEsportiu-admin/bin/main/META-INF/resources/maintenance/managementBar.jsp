<%@ include file="../init.jsp" %>
<%@ include file="./init.jsp" %>
<clay:management-toolbar
	clearResultsURL="<%= maintenanceDisplayContext.getClearResultsURL() %>"
	creationMenu="<%= maintenanceDisplayContext.getCreationMenu() %>"
	disabled="<%= maintenanceDisplayContext.isDisabledManagementBar() %>"
	filterDropdownItems="<%= maintenanceDisplayContext.getFilterItemsDropdownItems() %>"
	itemsTotal="<%= maintenanceDisplayContext.getTotalItems() %>"
	namespace="<%= renderResponse.getNamespace() %>"
	searchActionURL="<%= maintenanceDisplayContext.getSearchActionURL() %>"
	searchContainerId="<%= maintenanceDisplayContext.getSearchContainerId() %>"
	searchFormName="fm1"
	selectable="false"
	sortingOrder="<%= maintenanceDisplayContext.getOrderByType() %>"
	sortingURL="<%= maintenanceDisplayContext.getSortingURL() %>"
/>
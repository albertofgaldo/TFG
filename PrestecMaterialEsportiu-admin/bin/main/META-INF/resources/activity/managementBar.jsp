<%@ include file="../init.jsp" %>
<%@ include file="./init.jsp" %>
<clay:management-toolbar
	clearResultsURL="<%= activityDisplayContext.getClearResultsURL() %>"
	creationMenu="<%= activityDisplayContext.getCreationMenu() %>"
	disabled="<%= activityDisplayContext.isDisabledManagementBar() %>"
	filterDropdownItems="<%= activityDisplayContext.getFilterItemsDropdownItems() %>"
	itemsTotal="<%= activityDisplayContext.getTotalItems() %>"
	namespace="<%= renderResponse.getNamespace() %>"
	searchActionURL="<%= activityDisplayContext.getSearchActionURL() %>"
	searchContainerId="<%= activityDisplayContext.getSearchContainerId() %>"
	searchFormName="fm1"
	selectable="false"
	sortingOrder="<%= activityDisplayContext.getOrderByType() %>"
	sortingURL="<%= activityDisplayContext.getSortingURL() %>"
/>
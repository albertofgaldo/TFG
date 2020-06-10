<%@ include file="./init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Material material = null;
		 
if (Validator.isNotNull(row)) {
	material = (Material)row.getObject();
}
%>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<c:if test="<%= permissionChecker.isOmniadmin() %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="mvcPath" value="/material/editMaterial.jsp" />
			<portlet:param name="<%=Fields.MATERIALID%>" value="<%= String.valueOf(material.getMaterialId()) %>" />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" url="<%= editURL %>"/>		
					
		<portlet:actionURL var="deleteMaterialURL" name="deleteMaterial">
			<portlet:param name="<%=Fields.MATERIALID%>" value="<%= String.valueOf(material.getMaterialId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon-delete showIcon="<%= Boolean.TRUE %>"  url="<%= deleteMaterialURL %>" />
</c:if>
</liferay-ui:icon-menu>
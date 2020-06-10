<%@page import="cat.diba.materialesportiu.model.MaterialActivity"%>
<%@page import="cat.diba.materialesportiu.model.MaterialActivityModel"%>
<%@page import="cat.diba.materialesportiu.service.MaterialActivityLocalServiceUtil"%>
<%@ include file="./init.jsp"%>

<%

Group grupo = GroupLocalServiceUtil.getGroup(portletGroupId);
long grupoId = grupo.getGroupId();
if(grupo.getLiveGroupId()>0){
	   grupoId = grupo.getLiveGroupId();
}	  
   long materialId = ParamUtil.getLong(request, Fields.MATERIALID);   
   Material material = MaterialLocalServiceUtil.getMaterial(materialId);
   List<MaterialActivity> materialActivity = MaterialActivityLocalServiceUtil.getActivityByMaterialId(materialId);
   Activity activity = null;
   if(materialActivity==null){	   
	   %><liferay-portlet:param name="mvcPath" value="/material/viewMaterial.jsp"/><%
   }
%>

<liferay-portlet:renderURL var="cancel">
    <liferay-portlet:param name="mvcPath" value="/material/viewMaterial.jsp"/>
</liferay-portlet:renderURL>

<portlet:actionURL var="saveMaterialActivityURL" name="saveMaterialActivity"/>

<div class="container-fluid-1280 main-content-body">

 <aui:form name="fm" action="<%=saveMaterialActivityURL%>" method="post">
 	<aui:model-context bean="<%=materialActivity%>" model="<%=MaterialActivity.class%>"/>
 	<aui:input name="<%=Fields.MATERIALID%>" type="hidden" value="<%=material.getMaterialId()%>"/>
 			<div align="right">
            <label class="edit"><%=LanguageUtil.get(request, Fields.MATERIALID) + ": " + material.getMaterialId()%></label><br>
            <label class="edit"><%=LanguageUtil.get(request, Fields.NAME) + ": " + material.getName()%></label><br>
            <label class="edit"><%=LanguageUtil.get(request, Fields.TOTAL_STOCK) + ": " + material.getTotalStock()%></label><br>
            </div>
            <%
            	for(MaterialActivity ma : materialActivity){
            	activity=MaterialActivityLocalServiceUtil.getActivityByActivityId(ma.getActivityId());
            %>           
            <label class="edit"><%=activity.getName()%></label><br>
           <aui:input label="<%="quantity-activity"%>" name="<%=String.valueOf(ma.getMaterialActivityId())%>" type="number" value="<%=ma.getQuantity()%>" helpMessage="<%=LanguageUtil.get(request, "quantity-max")%>"><aui:validator name="required"/><aui:validator name="max" errorMessage="error-quantity"><%=material.getTotalStock() %></aui:validator></aui:input>		
		 	<%
            	}
            %>
		 	
		 <aui:button name="submit" type="submit" value="save"/>
         <aui:button href="<%=cancel%>" type="cancel"/>
	</aui:form>
</div>
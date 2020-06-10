<%@ include file="./init.jsp"%>

<%

Group grupo = GroupLocalServiceUtil.getGroup(portletGroupId);
long grupoId = grupo.getGroupId();
if(grupo.getLiveGroupId()>0){
	   grupoId = grupo.getLiveGroupId();
}	

    Material material = null;    
    long materialId = ParamUtil.getLong(request, Fields.MATERIALID);       
    if (materialId > 0) {
        material = MaterialLocalServiceUtil.getMaterial(Long.valueOf(materialId));             	
    }
    List<Activity> activityList = ActivityLocalServiceUtil.getAllActivities();   
%>

<liferay-portlet:renderURL var="cancel">
    <liferay-portlet:param name="mvcPath" value="/material/viewMaterial.jsp"/>
</liferay-portlet:renderURL>

<portlet:actionURL var="saveMaterialURL" name="saveMaterial"/>

<div class="container-fluid-1280 main-content-body">

 <aui:form name="fm" action="<%=saveMaterialURL%>" method="post">
 	<aui:model-context bean="<%=material%>" model="<%=Material.class%>"/>
            <aui:input name="<%=Fields.MATERIALID%>" type="hidden"/>
            
            <% if (material != null) { %>
            <label class="edit"><%=LanguageUtil.get(request, Fields.MATERIALID) + " " + material.getMaterialId()%></label><br>            
            <%}%>

			<aui:input name="<%=Fields.NAME%>" localized="true"><aui:validator name="required"/></aui:input>			
	        <aui:select name="<%=Fields.ACTIVITYID%>" showEmptyOption="true" helpMessage="<%=LanguageUtil.get(request, "help-material-activity")%>"><aui:validator  name="required" />
	            <%
	            for(Activity a : activityList){	        
	            %>
	            <aui:option name="<%=a.getActivityId()%>" localizeLabel="true" value="<%=a.getActivityId()%>"><%=a.getName(locale)%></aui:option>
	            <%
	            }
	            %>
	    	</aui:select>	           					
			<aui:input name="<%=Fields.QUANTITY%>" type="number"><aui:validator name="required"/><aui:validator name="required"/>  </aui:input> 
			<aui:input name="<%=Fields.HEIGH%>" type="number" step="0.01" helpMessage="<%=LanguageUtil.get(request, "default-value") + String.valueOf(Fields.DEFAULT_HEIGH)%>"></aui:input>
			<aui:input name="<%=Fields.WIDTH%>" type="number" step="0.01" helpMessage="<%=LanguageUtil.get(request, "default-value") + String.valueOf(Fields.DEFAULT_WIDTH)%>" ></aui:input>
			<aui:input name="<%=Fields.LONGITUDE%>" type="number" step="0.01" helpMessage="<%=LanguageUtil.get(request, "default-value") + String.valueOf(Fields.DEFAULT_LONGITUDE)%>"></aui:input>
			<aui:input name="<%=Fields.WEIGHT%>" type="number" step="0.01" helpMessage="<%=LanguageUtil.get(request, "default-value") + String.valueOf(Fields.DEFAULT_WEIGHT)%>" ></aui:input>			 	
		 <aui:button name="submit" type="submit" value="save"/>
         <aui:button href="<%=cancel%>" type="cancel"/>
	</aui:form>
</div>
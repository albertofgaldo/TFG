<%@page import="java.text.DateFormat"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@ include file="./init.jsp"%>

<%
Group grupo = GroupLocalServiceUtil.getGroup(portletGroupId);
long grupoId = grupo.getGroupId();
if(grupo.getLiveGroupId()>0){
	   grupoId = grupo.getLiveGroupId();
}	
    Loan loan = null;    
    long loanId = ParamUtil.getLong(request, Fields.LOANID);
    long localEntityId = ParamUtil.getLong(request, Fields.LOCALENTITYID,-1);
    boolean exist=false;   
    int maxQuantity=0;

    Calendar actualDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());   
    
    Calendar activityDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
    activityDate.setTime(ParamUtil.getDate(request, Fields.ACTIVITY_DATE, new SimpleDateFormat("dd/MM/yyyy")));
    
    Calendar returnDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
    returnDate.setTime(ParamUtil.getDate(request, Fields.RETURN_DATE, new SimpleDateFormat("dd/MM/yyyy")));
    
    Calendar firstPickupDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
    firstPickupDate.setTime(activityDate.getTime());    
    firstPickupDate.add(Calendar.DATE, Fields.DEFAULT_DAYS_PICKUP); 
    
    Calendar lastLoanDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
    lastLoanDate.setTime(activityDate.getTime());    
    lastLoanDate.add(Calendar.DATE, -2);
    
    Calendar pickupDate = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
    pickupDate.setTime(activityDate.getTime());
    pickupDate.add(Calendar.DATE, Fields.DEFAULT_DAYS_PICKUP);
    
    if(pickupDate.before(actualDate)){
    	pickupDate.setTime(actualDate.getTime());
    }
    
    List<LoanActivity> currentLoanActivity=null;    
    List<LocalEntity> localEntityList = LocalEntityLocalServiceUtil.getLocalEntityByCompanyGroup(company.getCompanyId(), grupoId);
    List<Activity> availableActivities = ActivityLocalServiceUtil.getActivitiesWithStockBetweenDates(activityDate.getTime(), returnDate.getTime());
    Map<Long, Integer> stockAvailable=new HashMap<>();
    
    if (loanId > 0) {
    	loan = LoanLocalServiceUtil.getLoan(Long.valueOf(loanId));     
    	activityDate.setTime(loan.getActivityDate());
        returnDate.setTime(loan.getReturnDate());  
        pickupDate.setTime(loan.getPickupDate());
        firstPickupDate.setTime(activityDate.getTime());    
        firstPickupDate.add(Calendar.DATE, Fields.DEFAULT_DAYS_PICKUP); 
        lastLoanDate.setTime(activityDate.getTime());    
        lastLoanDate.add(Calendar.DATE, -2);
        currentLoanActivity = LoanActivityLocalServiceUtil.getActivityByLoanId(loanId);         
    	for(LoanActivity la : currentLoanActivity){
    		if(!availableActivities.contains(ActivityLocalServiceUtil.getActivity(la.getActivityId()))){
    			availableActivities.add(ActivityLocalServiceUtil.getActivity(la.getActivityId()));
    		}
    	} 
    }       
%>

<liferay-portlet:renderURL var="cancel">
    <liferay-portlet:param name="mvcPath" value="/loan/viewLoan.jsp"/>
</liferay-portlet:renderURL>

<portlet:actionURL var="saveLoanURL" name="saveLoan"/>

<div class="container-fluid-1280 main-content-body">

 <aui:form name="fm" action="<%=saveLoanURL%>" method="post">
 	<aui:model-context bean="<%=loan%>" model="<%=Loan.class%>"/>
            <aui:input name="<%=Fields.LOANID%>" type="hidden"/>
            
            <% if (loan != null) { %>
            <label class="edit"><%=LanguageUtil.get(request, Fields.LOANID) + " " + loan.getLoanId()%></label>            
            <%            
            }%>		
            <div id="loan-data">	
             <aui:fieldset collapsed="false" collapsible="true" label="loan-data">
 			 <aui:select name="<%=Fields.LOCALENTITYID%>" showEmptyOption="true" type="hidden"><aui:validator  name="required" />
            		<%for(LocalEntity le : localEntityList){              			
            		%>
            			<aui:option name="<%=le.getLocalEntityId()%>" value="<%=le.getLocalEntityId()%>" selected="<%=localEntityId==le.getLocalEntityId() %>" ><%=le.getName()%></aui:option>
            		<% } %>
    				</aui:select>
    				<label><%=LanguageUtil.get(request, Fields.ACTIVITY_DATE)%></label>       
    				<liferay-ui:input-date  name="<%=Fields.ACTIVITY_DATE%>" required="true" firstEnabledDate="<%=actualDate.getTime()%>" lastEnabledDate="<%=lastLoanDate.getTime()%>" dayValue="<%=activityDate.get(Calendar.DAY_OF_MONTH)%>" monthValue="<%=activityDate.get(Calendar.MONTH)%>" yearValue="<%=activityDate.get(Calendar.YEAR)%>"/>
    				<label><%=LanguageUtil.get(request, Fields.RETURN_DATE)%></label> 
    				<liferay-ui:input-date  name="<%=Fields.RETURN_DATE%>"  required="true" firstEnabledDate="<%=actualDate.getTime()%>" lastEnabledDate="<%=lastLoanDate.getTime()%>" dayValue="<%=returnDate.get(Calendar.DAY_OF_MONTH)%>" monthValue="<%=returnDate.get(Calendar.MONTH)%>" yearValue="<%=returnDate.get(Calendar.YEAR)%>"/>
    				<br>
    				</aui:fieldset>
				</div>
				
			 		<aui:fieldset collapsed="false" collapsible="true" label="loan-materials">										
		 			<div id="member-fields" >						
									<%
							            if(loan==null){	        
							        %>			
							        <div class="lfr-form-row lfr-form-row-inline row">
									<aui:select label="<%=LanguageUtil.get(request, "loan-material")%>" name="<%=Fields.ACTIVITYID%>" showEmptyOption="true" helpMessage="<%=LanguageUtil.get(request, "help-loan-activity")%>" ><aui:validator  name="required" />
							            <%
							            for(Activity m : availableActivities){	 
							            	stockAvailable.put(m.getActivityId(),LoanLocalServiceUtil.getStockAvailableBetweenDates(m.getActivityId(),activityDate.getTime(),returnDate.getTime()));        					            	
							            %>
							            <aui:option data-activity="<%=m.getActivityId()%>" data-quantity="<%=stockAvailable.get(m.getActivityId())%>" name="<%=Fields.ACTIVITYID%>" localizeLabel="true" value="<%=m.getActivityId()%>" ><%=m.getName(locale) + " (" + stockAvailable.get(m.getActivityId()) + ")"%></aui:option>
							            <%
							            }
							            %>
						    		</aui:select>						    								    						    						    		  		
					    			<aui:input Label="<%=Fields.QUANTITY%>" name="<%=Fields.QUANTITY%>" value="<%=Fields.DEFAULT_QUANTITY%>" type="number" helpMessage="<%=LanguageUtil.get(request, "help-loan-quantity")%>">
					    			<aui:validator  name="required" />	
					    			<aui:validator  name="min" errorMessage="error-loan-min-quantity">1</aui:validator>	
			    					<aui:validator name="max" errorMessage="error-loan-max-quantity">			    					
			    					 function() {
					                        return AUI.$('#<portlet:namespace />maxQuantity').val();
					                }
			    					</aui:validator>			    					
					    			</aui:input>
					    			<aui:input disabled="true" name="maxQuantity" value="0" type="number"></aui:input>	
					    			</div>
					    			<%
							        }else{    
							        	for(LoanActivity l : currentLoanActivity){							        		
							        %>
							        <div class="lfr-form-row lfr-form-row-inline row">
							        <aui:select name="<%=Fields.ACTIVITYID%>" showEmptyOption="true" helpMessage="<%=LanguageUtil.get(request, "help-loan-activity")%>"><aui:validator  name="required" />
							        	<%
							            for(Activity m : availableActivities){	
							            	stockAvailable.put(m.getActivityId(),LoanLocalServiceUtil.getStockAvailableBetweenDates(m.getActivityId(),activityDate.getTime(),returnDate.getTime()));
							            	
							            	exist=false;
							            	if(l.getActivityId()==m.getActivityId()){							            		
							            		exist=true;
							            		maxQuantity=stockAvailable.get(m.getActivityId());
							            		if(maxQuantity<l.getQuantity()){
							            			maxQuantity=l.getQuantity();
							            		}
							            	}
							            %>
							            <aui:option data-activity="<%=m.getActivityId()%>" data-quantity="<%=maxQuantity%>" name="<%=m.getActivityId()%>" localizeLabel="true" value="<%=m.getActivityId()%>" selected="<%=exist%>"><%=m.getName(locale) + " (" + stockAvailable.get(m.getActivityId()) + ")"%></aui:option>					       							            
							            <%
							            }
							            %>
							        	</aui:select>
							        	<aui:input label="<%=Fields.QUANTITY%>" name="<%=Fields.QUANTITY%>" value="<%=l.getQuantity()%>" type="number" helpMessage="<%=LanguageUtil.get(request, "help-loan-quantity")%>">
							        		<aui:validator  name="required" />
							        		<aui:validator  name="min" errorMessage="error-loan-min-quantity">1</aui:validator>	
							        		<aui:validator name="max" errorMessage="error-loan-max-quantity">			    					
					    					 function() {
							                        return AUI.$('#<portlet:namespace />maxQuantity').val();
							                }
			    							</aui:validator>						        
							        	</aui:input>
							        	<aui:input disabled="true" name="maxQuantity" value="<%=maxQuantity%>" type="number"></aui:input>	
							        	</div>
							        <%
							        	}
							        }        
							        %>			    		
			    	</div>
			    		<div class="row">	    	
			    		<div class="col-6">
				    	<aui:fieldset collapsed="false" collapsible="true" label="loan-activity" >
							<label><%=LanguageUtil.get(request, Fields.PICKUP_DATE)%></label> 
						 	<liferay-ui:input-date name="<%=Fields.PICKUP_DATE%>" required="true" firstEnabledDate="<%=firstPickupDate.getTime()%>" lastEnabledDate="<%=activityDate.getTime()%>" dayValue="<%=pickupDate.get(Calendar.DAY_OF_MONTH)%>" monthValue="<%=pickupDate.get(Calendar.MONTH)%>" yearValue="<%=pickupDate.get(Calendar.YEAR)%>"/>
						 	<br>		
							<aui:input name="<%=Fields.ACTIVITY_NAME%>" ><aui:validator name="required"/></aui:input>
							<aui:input name="<%=Fields.PARTICIPANTS%>" type="number"></aui:input>
							<aui:input name="<%=Fields.PARTICIPANTS_KIDS%>" type="number"></aui:input>
							<aui:input name="<%=Fields.DESCRIPTION%>" type="textarea"></aui:input>
						</aui:fieldset>
						</div>						
						<div class="col-6">
						<aui:fieldset collapsed="false" collapsible="true" label="loan-contact" >
							<aui:input name="<%=Fields.CONTACT_PERSON%>" ><aui:validator name="required"/></aui:input>
							<aui:input name="<%=Fields.POSITION_PERSON%>" ><aui:validator name="required"/></aui:input>
							<aui:input name="<%=Fields.TELEPHONE%>" ><aui:validator name="required"/></aui:input>
							<aui:input name="<%=Fields.EMAIL%>" type="email"><aui:validator name="required"/></aui:input>
							<aui:input name="<%=Fields.PMT%>" ></aui:input>								
						</aui:fieldset>
						</div>	
						</div>					
					</aui:fieldset>	
		<br>		 		 	
		<aui:button name="submit" type="submit"/>
        <aui:button href="<%=cancel%>" type="cancel"/>
	</aui:form>
</div>
<aui:script use="event, node, aui-base, liferay-form">
var i=0;
var act;	
var quant;
AUI().use('liferay-auto-fields',function(A) {
 new Liferay.AutoFields(
       {
           contentBox: '#member-fields',           
           fieldIndexes: '<portlet:namespace />rowIndexes',           
        on: {
			'clone': function(event) {		
						A.all('#<portlet:namespace/>quantity').each(
							function(){
								//this.set('disabled',true);
							}
						);
						A.all('#<portlet:namespace/>activityId').each(
			       			function(){
			       				if(this.val()===""){
			       					this.set('value',act);
			       					//this.set('disabled', 'true');
			       				}
			       			}
			       		); 				       			       						       		
			       		A.one('#<portlet:namespace/>activityId').set('value','');	
			       		A.one('#<portlet:namespace/>maxQuantity').set('value','0');
			       		A.one('#<portlet:namespace/>quantity').set('value','1');
			       		//A.one('#<portlet:namespace/>quantity').set('disabled',false);				       		
			       			i++;          		 			
			       			//alert("-- Add --");
			 },
       		'delete': function(event) {
       			i--;
       			//alert("-- Delete --");
       		}       		
       	},
       	sortable: true,       	
 }
   ).render();
});	   
 
AUI().use('aui-base', function(A){	
  	//funciona con one y all
	A.all("#<portlet:namespace/>activityId").on('change',function(){			 		
	 	act = A.one('#<portlet:namespace/>activityId').val();	 	
	 	//tiene que ser all 	
	 	A.all('#<portlet:namespace/>activityId > option').each(
	 		function(){
	 			if(this.attr('data-activity')===act){
	 				quant = this.attr('data-quantity');
	 				A.one('#<portlet:namespace/>maxQuantity').set('value',quant);
	 			};
	 		}
	 	);		 		
	})
});
</aui:script>
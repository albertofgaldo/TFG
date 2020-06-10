package cat.diba.materialesportiu.admin.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

import cat.diba.materialesportiu.admin.constants.PrestecMaterialEsportiuAdminPortletKeys;
import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Activity;
import cat.diba.materialesportiu.model.ActivityDependsOn;
import cat.diba.materialesportiu.model.Loan;
import cat.diba.materialesportiu.model.LoanActivity;
import cat.diba.materialesportiu.model.LocalEntity;
import cat.diba.materialesportiu.model.Maintenance;
import cat.diba.materialesportiu.model.Material;
import cat.diba.materialesportiu.service.ActivityDependsOnLocalServiceUtil;
import cat.diba.materialesportiu.service.ActivityLocalServiceUtil;
import cat.diba.materialesportiu.service.LoanActivityLocalServiceUtil;
import cat.diba.materialesportiu.service.LoanLocalServiceUtil;
import cat.diba.materialesportiu.service.LocalEntityLocalServiceUtil;
import cat.diba.materialesportiu.service.MaintenanceLocalServiceUtil;
import cat.diba.materialesportiu.service.MaterialLocalServiceUtil;

/**
 * @author alberto
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=Prestec de Material Esportiu",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/loan/viewLoan.jsp",
		"javax.portlet.name=" + PrestecMaterialEsportiuAdminPortletKeys.PRESTECMATERIALESPORTIUADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator",
		"javax.portlet.supports.mime-type=text/html"

	},
	service = Portlet.class
)
public class PrestecMaterialEsportiuAdminPortlet extends MVCPortlet {	
		
	private static Log LOG = LogFactoryUtil
            .getLog(PrestecMaterialEsportiuAdminPortlet.class);
		
	@ProcessAction(name = "deleteLocalEntity")
	public void deleteLocalEntity(ActionRequest arq, ActionResponse arp) throws Exception {
		String localEntityId = ParamUtil.get(arq, Fields.LOCALENTITYID, "-1");
		if (localEntityId != null && !localEntityId.equals(StringPool.BLANK)) {
			LocalEntity localEntity = LocalEntityLocalServiceUtil.getLocalEntity(Long.valueOf(localEntityId));
			if (localEntity != null) {
				LocalEntityLocalServiceUtil.deleteLocalEntity(localEntity);
			}
		}
		arp.getRenderParameters().setValue("mvcPath", "/localEntity/viewLocalEntity.jsp");
	}
	
	@ProcessAction(name = "saveLocalEntity")
	public void saveLocalEntity(ActionRequest arq, ActionResponse arp)throws Exception {
		
		long localEntityId = ParamUtil.get(arq, Fields.LOCALENTITYID,  -1);		
		
		LocalEntity localEntity = null;			
		
			if(localEntityId == -1) {// new local entity
				localEntity = new LocalEntityLocalServiceUtil().createLocalEntity(0);	
				localEntity.setCreateDate(new Date());				
				LocalEntityLocalServiceUtil.addLocalEntity(setLocalEntity(arq, localEntity));
			}else {// update local entity		
				localEntity= LocalEntityLocalServiceUtil.getLocalEntity(localEntityId);				
				LocalEntityLocalServiceUtil.updateLocalEntity(setLocalEntity(arq, localEntity));
			}				
			PortalUtil.copyRequestParameters(arq, arp);				
			arp.getRenderParameters().setValue("mvcPath", "/localEntity/viewLocalEntity.jsp");			
	}

	private LocalEntity setLocalEntity(ActionRequest arq, LocalEntity localEntity) throws PortalException {
		localEntity.setName(ParamUtil.get(arq, Fields.NAME, StringPool.BLANK));
		localEntity.setCif(ParamUtil.get(arq, Fields.CIF, StringPool.BLANK));
		localEntity.setTelephone(ParamUtil.get(arq, Fields.TELEPHONE, StringPool.BLANK));
		localEntity.setEmail(ParamUtil.get(arq, Fields.EMAIL, StringPool.BLANK));	
		localEntity.setCompanyId(PortalUtil.getCompanyId(arq));
		localEntity.setGroupId(PortalUtil.getScopeGroupId(arq));
		localEntity.setUserId(PortalUtil.getUserId(arq));
		localEntity.setUserName(PortalUtil.getUserName(PortalUtil.getUserId(arq), StringPool.BLANK));				
		localEntity.setModifiedDate(new Date());
		return localEntity;
	}
	
	@ProcessAction(name = "saveActivity")
	public void saveActivity(ActionRequest arq, ActionResponse arp)throws Exception {
		
		long activityId = ParamUtil.get(arq, Fields.ACTIVITYID,  -1);		
		LOG.debug("activityId=" + activityId);			
		Activity activity = null;			
		boolean isNew;
			if(activityId == -1) {// new activity
				activity = new ActivityLocalServiceUtil().createActivity(0);
				isNew=true;					
				activity = setActivity(arq, activity, isNew);				
				ActivityLocalServiceUtil.addActivity(activity);				
				String[] childActivities = ParamUtil.getParameterValues(arq, "currentChildActivities");
				for(String a :childActivities) {
					setActivityDependsOn(arq, activity, a);
				}		
			}else {// update activity	
				isNew=false;
				activity = ActivityLocalServiceUtil.getActivity(activityId);									
				activity = setActivity(arq, activity, isNew);							
				ActivityLocalServiceUtil.updateActivity(activity);
				String[] updateActivities = ParamUtil.getParameterValues(arq, "currentChildActivities");
				List<ActivityDependsOn> actualChildActivities = ActivityDependsOnLocalServiceUtil.getActivityDependsOnByParentActivityId(activityId);
				if(!actualChildActivities.isEmpty()) {
					boolean exist=false;
					for (ActivityDependsOn a : actualChildActivities) {
						exist=false;
						for(String s : updateActivities) {
							if(a.getActivityId()==Long.parseLong(s))
							exist=true;
						}
						if (!exist) {
							ActivityDependsOnLocalServiceUtil.deleteActivityDependsOn(a.getActivityDependsOnId());
						}
					}
				}
				if (updateActivities.length>0) {					
					for(String a :updateActivities) {						
						if(ActivityDependsOnLocalServiceUtil.getActivityDependsOnByActivityIdParentActivityId(Long.parseLong(a), activity.getActivityId())==null) {
							setActivityDependsOn(arq, activity, a);
						}					
					}	
				}
			}			
			PortalUtil.copyRequestParameters(arq, arp);
			arp.getRenderParameters().setValue("mvcPath", "/activity/viewActivity.jsp");	
	}

	private void setActivityDependsOn(ActionRequest arq, Activity activity, String a) throws PortalException {
		ActivityDependsOn activityDependsOn = new ActivityDependsOnLocalServiceUtil().createActivityDependsOn(0);
		activityDependsOn.setActivityId(Long.parseLong(a));
		activityDependsOn.setCompanyId(PortalUtil.getCompanyId(arq));
		activityDependsOn.setGroupId(PortalUtil.getScopeGroupId(arq));
		activityDependsOn.setUserId(PortalUtil.getUserId(arq));
		activityDependsOn.setUserName(PortalUtil.getUserName(PortalUtil.getUserId(arq), StringPool.BLANK));
		activityDependsOn.setCreateDate(new Date());
		activityDependsOn.setModifiedDate(new Date());
		activityDependsOn.setParentActivityId(activity.getActivityId());
		ActivityDependsOnLocalServiceUtil.addActivityDependsOn(activityDependsOn);
	}

	private Activity setActivity(ActionRequest arq, Activity activity, Boolean isNew) throws PortalException {
		activity.setNameMap(LocalizationUtil.getLocalizationMap(arq, Fields.NAME));
		if(isNew) {
			activity.setTotalStock(ParamUtil.get(arq, Fields.TOTAL_STOCK, Fields.DEFAULT_STOCK));
			activity.setAvailableStock(ParamUtil.get(arq, Fields.TOTAL_STOCK, Fields.DEFAULT_STOCK));
			activity.setCreateDate(new Date());
		}else {
			int oldTotalStock = activity.getTotalStock();
			activity.setTotalStock(ParamUtil.get(arq, Fields.TOTAL_STOCK, Fields.DEFAULT_STOCK));
			int newAvailableStock =ParamUtil.get(arq, Fields.TOTAL_STOCK, Fields.DEFAULT_STOCK);				
			activity.setAvailableStock(newAvailableStock - (oldTotalStock - activity.getAvailableStock()));
		}		
		activity.setDaysBeforeLoan(ParamUtil.get(arq, Fields.DAYSBEFORELOAN, Fields.DEFAULT_DAYS_BEFORE_LOAN));
		activity.setDaysBooking(ParamUtil.get(arq, Fields.DAYSBOOKING, Fields.DEFAULT_DAYS_BOOKING));
		activity.setDaysAfterLoan(ParamUtil.get(arq, Fields.DAYSAFTERLOAN, Fields.DEFAULT_DAYS_AFTER_LOAN));
		activity.setDescriptionMap(LocalizationUtil.getLocalizationMap(arq, Fields.DESCRIPTION));
		activity.setAge(ParamUtil.get(arq, Fields.AGE, Fields.DEFAULT_AGE));
		activity.setMinParticipants(ParamUtil.get(arq, Fields.MINPARTICIPANTS, Fields.DEFAULT_MIN_PARTICIPANTS));
		activity.setMaxParticipants(ParamUtil.get(arq, Fields.MAXPARTICIPANTS, Fields.DEFAULT_MAX_PARTICIPANTS));
		activity.setUsageRulesMap(LocalizationUtil.getLocalizationMap(arq, Fields.USAGERULES));
		activity.setLoanConditionsMap(LocalizationUtil.getLocalizationMap(arq, Fields.LOANCONDITIONS));		
		activity.setTitulationIsRequired(ParamUtil.getBoolean(arq, Fields.TITULATIONISREQUIRED));
		activity.setCompanyId(PortalUtil.getCompanyId(arq));
		activity.setGroupId(PortalUtil.getScopeGroupId(arq));
		activity.setUserId(PortalUtil.getUserId(arq));
		activity.setUserName(PortalUtil.getUserName(PortalUtil.getUserId(arq), StringPool.BLANK));				
		activity.setModifiedDate(new Date());		
		return activity;
	}
	
	@ProcessAction(name = "deleteActivity")
	public void deleteActitivy(ActionRequest arq, ActionResponse arp) throws Exception {
		String activityId = ParamUtil.get(arq, Fields.ACTIVITYID, "-1");
		if (activityId != null && !activityId.equals(StringPool.BLANK)) {
			Activity activity = ActivityLocalServiceUtil.getActivity(Long.valueOf(activityId));
			if (activity != null) {
				ActivityDependsOnLocalServiceUtil.deleteActivityDependsOnByActivityId(activity.getActivityId());
				ActivityDependsOnLocalServiceUtil.deleteActivityDependsOnByParentActivityId(activity.getActivityId());
				ActivityLocalServiceUtil.deleteActivity(activity);
			}
		}
		arp.getRenderParameters().setValue("mvcPath", "/activity/viewActivity.jsp");
	}
	
	@ProcessAction(name = "saveMaterial")
	public void saveMaterial(ActionRequest arq, ActionResponse arp)throws Exception {
		
		long materialId = ParamUtil.get(arq, Fields.MATERIALID,  -1);		
		LOG.debug("materialId=" + materialId);			
		Material material = null;			

			if(materialId == -1) {// new material
				material = new MaterialLocalServiceUtil().createMaterial(0);
				material.setCreateDate(new Date());				
				material = setMaterial(arq, material);				
				MaterialLocalServiceUtil.addMaterial(material);		
			}else {// update material	
				material = MaterialLocalServiceUtil.getMaterial(materialId);				
				material = setMaterial(arq, material);				
				MaterialLocalServiceUtil.updateMaterial(material);	
			}			
			PortalUtil.copyRequestParameters(arq, arp);
			arp.getRenderParameters().setValue("mvcPath", "/material/viewMaterial.jsp");	
	}

	private Material setMaterial(ActionRequest arq, Material material) throws PortalException {
		material.setNameMap(LocalizationUtil.getLocalizationMap(arq, Fields.NAME));				
		material.setHeigh(ParamUtil.get(arq, Fields.HEIGH, Fields.DEFAULT_HEIGH));
		material.setWidth(ParamUtil.get(arq, Fields.WIDTH, Fields.DEFAULT_WIDTH));
		material.setLongitude(ParamUtil.get(arq, Fields.LONGITUDE, Fields.DEFAULT_LONGITUDE));
		material.setWeight(ParamUtil.get(arq, Fields.WEIGHT, Fields.DEFAULT_WEIGHT));
		material.setActivityId(ParamUtil.get(arq, Fields.ACTIVITYID, 0));	
		material.setQuantity(ParamUtil.get(arq, Fields.QUANTITY, Fields.DEFAULT_QUANTITY));				
		material.setCompanyId(PortalUtil.getCompanyId(arq));
		material.setGroupId(PortalUtil.getScopeGroupId(arq));
		material.setUserId(PortalUtil.getUserId(arq));
		material.setUserName(PortalUtil.getUserName(PortalUtil.getUserId(arq), StringPool.BLANK));				
		material.setModifiedDate(new Date());		
		return material;
	}
	
	@ProcessAction(name = "deleteMaterial")
	public void deleteMaterial(ActionRequest arq, ActionResponse arp) throws Exception {
		String materialId = ParamUtil.get(arq, Fields.MATERIALID, "-1");
		if (materialId != null && !materialId.equals(StringPool.BLANK)) {
			Material material = MaterialLocalServiceUtil.getMaterial(Long.valueOf(materialId));
			if (material != null) {					
				MaterialLocalServiceUtil.deleteMaterial(material);
			}
		}
		arp.getRenderParameters().setValue("mvcPath", "/material/viewMaterial.jsp");
	}
	
	@ProcessAction(name = "saveActivityDependsOn")
	public void saveActivityDependsOn(ActionRequest arq, ActionResponse arp) throws Exception {
		String activityId = ParamUtil.get(arq, Fields.ACTIVITYID, "-1");
		if(activityId!="-1") {
			int quantity;
			for(ActivityDependsOn a : ActivityDependsOnLocalServiceUtil.getActivityDependsOnByParentActivityId(Long.parseLong(activityId))){
				quantity=ParamUtil.getInteger(arq, String.valueOf(a.getActivityDependsOnId()), -1);
				if(quantity!=-1 && ActivityDependsOnLocalServiceUtil.getActivityDependsOn(a.getActivityDependsOnId()).getQuantity()!=quantity) {
					a.setQuantity(quantity);
					ActivityDependsOnLocalServiceUtil.updateActivityDependsOn(a);
				}
			}
		}		
		arp.getRenderParameters().setValue("mvcPath", "/activity/viewActivity.jsp");
	}	
	
	@ProcessAction(name = "saveMaintenance")
	public void saveMaintenance(ActionRequest arq, ActionResponse arp)throws Exception {
		
		long maintenanceId = ParamUtil.get(arq, Fields.MAINTENANCEID,  -1);				
		Date date=null;	
		String activity=null;
		Maintenance maintenance = null;			
			if(maintenanceId == -1) {// new maintenance
				maintenance = new MaintenanceLocalServiceUtil().createMaintenance(0);
				maintenance.setCreateDate(new Date());				
				maintenance = setMaintenance(arq, maintenance);				
				MaintenanceLocalServiceUtil.addMaintenance(maintenance);				
				ActivityLocalServiceUtil.decreaseAvailableStock(maintenance.getActivityId(), 1);
			}else {// update maintenance
				maintenance = MaintenanceLocalServiceUtil.getMaintenance(maintenanceId);
				maintenance = setMaintenance(arq, maintenance);	
				MaintenanceLocalServiceUtil.updateMaintenance(maintenance);
			}				
			PortalUtil.copyRequestParameters(arq, arp);				
			arp.getRenderParameters().setValue("mvcPath", "/maintenance/viewMaintenance.jsp");			
	}

	private Maintenance setMaintenance(ActionRequest arq, Maintenance maintenance) throws PortalException, ParseException {
		String activity;
		maintenance.setActivityId(ParamUtil.get(arq, Fields.ACTIVITYID, 0));	
		activity=ActivityLocalServiceUtil.getActivity(maintenance.getActivityId()).getName(arq.getLocale());
		maintenance.setLabel(ParamUtil.get(arq, Fields.LABEL, activity));
		if(maintenance.getLabel().isEmpty())maintenance.setLabel(activity);
		maintenance.setDescription(ParamUtil.get(arq, Fields.DESCRIPTION, StringPool.BLANK));			
		maintenance.setStartDate(ParamUtil.getDate(arq, Fields.START_DATE, new SimpleDateFormat("dd/MM/yyyy")));				
		maintenance.setEndDate(new SimpleDateFormat("dd/MM/yyyy").parse(ParamUtil.get(arq, Fields.END_DATE, "")));
		maintenance.setIsDone(ParamUtil.get(arq, Fields.ISDONE, false));
		maintenance.setLoanId(ParamUtil.get(arq, Fields.LOANID, 0));
		maintenance.setCompanyId(PortalUtil.getCompanyId(arq));
		maintenance.setGroupId(PortalUtil.getScopeGroupId(arq));
		maintenance.setUserId(PortalUtil.getUserId(arq));
		maintenance.setUserName(PortalUtil.getUserName(PortalUtil.getUserId(arq), StringPool.BLANK));				
		maintenance.setModifiedDate(new Date());		
		return maintenance;
	}
	
	@ProcessAction(name = "deleteMaintenance")
	public void deleteMaintenance(ActionRequest arq, ActionResponse arp) throws Exception {
		String maintenanceId = ParamUtil.get(arq, Fields.MAINTENANCEID, "-1");
		if (maintenanceId != null && !maintenanceId.equals(StringPool.BLANK)) {
			Maintenance maintenance = MaintenanceLocalServiceUtil.getMaintenance(Long.valueOf(maintenanceId));
			if (maintenance != null) {				
				MaintenanceLocalServiceUtil.deleteMaintenance(maintenance);				
			}
		}
		arp.getRenderParameters().setValue("mvcPath", "/maintenance/viewMaintenance.jsp");
	}
	
	@ProcessAction(name = "setMaintenanceDone")
	public void setMaintenanceDone(ActionRequest arq, ActionResponse arp) throws Exception {
		String maintenanceId = ParamUtil.get(arq, Fields.MAINTENANCEID, "-1");
		if (maintenanceId != null && !maintenanceId.equals(StringPool.BLANK)) {
			Maintenance maintenance = MaintenanceLocalServiceUtil.getMaintenance(Long.valueOf(maintenanceId));
			if (maintenance != null) {	
				maintenance.setIsDone(true);
				maintenance.setEndDate(new Date());	
				maintenance.setCompanyId(PortalUtil.getCompanyId(arq));
				maintenance.setGroupId(PortalUtil.getScopeGroupId(arq));
				maintenance.setUserId(PortalUtil.getUserId(arq));
				maintenance.setUserName(PortalUtil.getUserName(PortalUtil.getUserId(arq), StringPool.BLANK));				
				maintenance.setModifiedDate(new Date());				
				MaintenanceLocalServiceUtil.updateMaintenance(maintenance);	
				ActivityLocalServiceUtil.increaseAvailableStock(maintenance.getActivityId(), 1);				
				LoanLocalServiceUtil.updateStatusMaintenanceToReturned(new Date());
			}
		}
		arp.getRenderParameters().setValue("mvcPath", "/maintenance/viewMaintenance.jsp");
	}
	
	@ProcessAction(name = "saveLoan")
	public void saveLoan(ActionRequest arq, ActionResponse arp)throws Exception {
		
		long loanId = ParamUtil.get(arq, Fields.LOANID,  -1);		
		LOG.debug("loanId=" + loanId);			
		Loan loan = null;			

			if(loanId == -1) {// new loan
				loan = new LoanLocalServiceUtil().createLoan(0);
				loan.setCreateDate(new Date());				
				loan = setLoan(arq, loan);				
				LoanLocalServiceUtil.addLoan(loan);				
				long[] activities = ParamUtil.getLongValues(arq, Fields.ACTIVITYID);
				int[] quantity = ParamUtil.getIntegerValues(arq, Fields.QUANTITY);					
				 for(int i =0; i<activities.length;i++) {					 					 
					setLoanActivity(arq, loan, activities, quantity, i);
				 }	
			}else {// update loan	
				loan = LoanLocalServiceUtil.getLoan(loanId);				
				loan = setLoan(arq, loan);				
				LoanLocalServiceUtil.updateLoan(loan);	
				long[] activities = ParamUtil.getLongValues(arq, Fields.ACTIVITYID);
				int[] quantity = ParamUtil.getIntegerValues(arq, Fields.QUANTITY);									
				List<LoanActivity> currentLoanActivities = LoanActivityLocalServiceUtil.getActivityByLoanId(loan.getLoanId());
				if(!currentLoanActivities.isEmpty()) {
					boolean exist=false;
					for (LoanActivity a : currentLoanActivities) {
						exist=false;
						for(int i=0; i< activities.length;i++) {
							if(a.getActivityId()==activities[i]) {
								exist=true;
								a.setQuantity(quantity[i]);
								LoanActivityLocalServiceUtil.updateLoanActivity(a);
							}							
						}
						if (!exist) {
							LoanActivityLocalServiceUtil.deleteLoanActivity(a.getLoanActivityId());
						}
					}
				}				
				if (activities.length>0) {					
					for(int i =0; i<activities.length;i++) {
						if(LoanActivityLocalServiceUtil.getLoanActivityByLoanIdActivityId(loan.getLoanId(), activities[i])==null) {
							setLoanActivity(arq, loan, activities, quantity, i);
						}
					 }		
				}				
			}		
			PortalUtil.copyRequestParameters(arq, arp);
			arp.getRenderParameters().setValue("mvcPath", "/loan/viewLoan.jsp");	
	}

	private void setLoanActivity(ActionRequest arq, Loan loan, long[] activities, int[] quantity, int i)
			throws PortalException {
		LoanActivity loanActivity = new LoanActivityLocalServiceUtil().createLoanActivity(0);
		loanActivity.setLoanId(loan.getLoanId());
		loanActivity.setActivityId(activities[i]);
		loanActivity.setQuantity(quantity[i]);
		loanActivity.setCompanyId(PortalUtil.getCompanyId(arq));
		loanActivity.setGroupId(PortalUtil.getScopeGroupId(arq));
		loanActivity.setUserId(PortalUtil.getUserId(arq));
		loanActivity.setUserName(PortalUtil.getUserName(PortalUtil.getUserId(arq), StringPool.BLANK));
		loanActivity.setCreateDate(new Date());
		loanActivity.setModifiedDate(new Date());
		LoanActivityLocalServiceUtil.addLoanActivity(loanActivity);
	}

	private Loan setLoan(ActionRequest arq, Loan loan) throws ParseException, PortalException {
		loan.setLocalEntityId(ParamUtil.get(arq, Fields.LOCALENTITYID, 0));
		loan.setPickupDate(new SimpleDateFormat("dd/MM/yyyy").parse(ParamUtil.get(arq, Fields.PICKUP_DATE, "")));
		loan.setReturnDate(new SimpleDateFormat("dd/MM/yyyy").parse(ParamUtil.get(arq, Fields.RETURN_DATE, "")));
		loan.setActivityDate(new SimpleDateFormat("dd/MM/yyyy").parse(ParamUtil.get(arq, Fields.ACTIVITY_DATE, "")));
		loan.setActivityName(ParamUtil.get(arq, Fields.ACTIVITY_NAME, StringPool.BLANK));
		loan.setParticipantsNum(ParamUtil.get(arq, Fields.PARTICIPANTS, Fields.DEFAULT_PARTICIPANTS));
		loan.setParticipantsKidsNum(ParamUtil.get(arq, Fields.PARTICIPANTS_KIDS, Fields.DEFAULT_PARTICIPANTS_KIDS));
		loan.setDescription(ParamUtil.get(arq, Fields.DESCRIPTION, StringPool.BLANK));
		loan.setContactPerson(ParamUtil.get(arq, Fields.CONTACT_PERSON, StringPool.BLANK));
		loan.setPositionPerson(ParamUtil.get(arq, Fields.POSITION_PERSON, StringPool.BLANK));
		loan.setTelephone(ParamUtil.get(arq, Fields.TELEPHONE, StringPool.BLANK));
		loan.setEmail(ParamUtil.get(arq, Fields.EMAIL, StringPool.BLANK));
		loan.setPmt(ParamUtil.get(arq, Fields.PMT, StringPool.BLANK));				
		loan.setStatus(Fields.LoanStatus.NOTCONFIRMED.toString());	
		if(loan.getStatus().equals(Fields.LoanStatus.NOTCONFIRMED.toString())&&!loan.getPmt().isEmpty())
			loan.setStatus(Fields.LoanStatus.CONFIRMED.toString());
		loan.setCompanyId(PortalUtil.getCompanyId(arq));
		loan.setGroupId(PortalUtil.getScopeGroupId(arq));
		loan.setUserId(PortalUtil.getUserId(arq));
		loan.setUserName(PortalUtil.getUserName(PortalUtil.getUserId(arq), StringPool.BLANK));				
		loan.setModifiedDate(new Date());
		return loan;
	}
	
	@ProcessAction(name = "savePmt")
	public void savePmt(ActionRequest arq, ActionResponse arp)throws Exception {
		
		long loanId = ParamUtil.get(arq, Fields.LOANID, 0);
		Loan loan = LoanLocalServiceUtil.getLoan(loanId);
		loan.setPmt(ParamUtil.getString(arq, Fields.PMT));
		if(loan.getStatus().equals(Fields.LoanStatus.NOTCONFIRMED.toString()))
			loan.setStatus(Fields.LoanStatus.CONFIRMED.toString());
		LoanLocalServiceUtil.updateLoan(loan);
		
		 PortalUtil.copyRequestParameters(arq, arp);
		 arp.getRenderParameters().setValue("mvcPath", "/loan/cerrarPopUp.jsp");		
	}
	
	@ProcessAction(name = "pickupedLoan")
	public void pickupedLoan(ActionRequest arq, ActionResponse arp) throws Exception {
		String loanId = ParamUtil.get(arq, Fields.LOANID, "-1");
		if (loanId != null && !loanId.equals(StringPool.BLANK)) {
			Loan loan = LoanLocalServiceUtil.getLoan(Long.valueOf(loanId));
			if (loan != null) {				
				loan.setStatus(Fields.LoanStatus.BORROWED.toString());
				loan.setCompanyId(PortalUtil.getCompanyId(arq));
				loan.setGroupId(PortalUtil.getScopeGroupId(arq));
				loan.setUserId(PortalUtil.getUserId(arq));
				loan.setUserName(PortalUtil.getUserName(PortalUtil.getUserId(arq), StringPool.BLANK));						
				LoanLocalServiceUtil.updateLoan(loan);
				Activity activity;
				int activityDependsOnQuantity;
				for(LoanActivity la : LoanActivityLocalServiceUtil.getActivityByLoanId(loan.getLoanId())) {											
					activity=ActivityLocalServiceUtil.getActivity(la.getActivityId());					
					activity.setAvailableStock(activity.getTotalStock()-la.getQuantity());					
					//gestionar ActivityDependsOn		
					ActivityLocalServiceUtil.updateActivity(activity);				
				}				
			}
		}
		arp.getRenderParameters().setValue("mvcPath", "/loan/viewLoan.jsp");
	}
	
	@ProcessAction(name = "returnLoan")
	public void returnLoan(ActionRequest arq, ActionResponse arp) throws Exception {
		String loanId = ParamUtil.get(arq, Fields.LOANID, "-1");
		if (loanId != null && !loanId.equals(StringPool.BLANK)) {
			Loan loan = LoanLocalServiceUtil.getLoan(Long.valueOf(loanId));
			if (loan != null) {		
				Calendar today = Calendar.getInstance();
				today.setTime(new Date());
				loan.setReturnDate(today.getTime());
				loan.setStatus(Fields.LoanStatus.MAINTENANCE.toString());
				loan.setCompanyId(PortalUtil.getCompanyId(arq));
				loan.setGroupId(PortalUtil.getScopeGroupId(arq));
				loan.setUserId(PortalUtil.getUserId(arq));
				loan.setUserName(PortalUtil.getUserName(PortalUtil.getUserId(arq), StringPool.BLANK));				
				loan.setModifiedDate(today.getTime());	
				LoanLocalServiceUtil.updateLoan(loan);				
				Activity activity;					
				Maintenance maintenance=null;
				for(LoanActivity la : LoanActivityLocalServiceUtil.getActivityByLoanId(loan.getLoanId())) {	
					//Si no es padre	
						activity=ActivityLocalServiceUtil.getActivity(la.getActivityId());
						for(int i=0; i<la.getQuantity();i++) {								
							maintenance = new MaintenanceLocalServiceUtil().createMaintenance(0);							
							maintenance.setActivityId(activity.getActivityId());
							maintenance.setLabel(activity.getName(arq.getLocale()));					
							maintenance.setDescription(LocalEntityLocalServiceUtil.getLocalEntity(loan.getLocalEntityId()).getName()+" - "+loan.getDescription());								
							today.setTime(new Date());
							maintenance.setCreateDate(today.getTime());
							maintenance.setModifiedDate(today.getTime());
							maintenance.setStartDate(today.getTime());
							today.add(Calendar.DAY_OF_MONTH, activity.getDaysAfterLoan());						
							maintenance.setEndDate(today.getTime());
							maintenance.setIsDone(false);
							maintenance.setLoanId(loan.getLoanId());
							maintenance.setCompanyId(PortalUtil.getCompanyId(arq));
							maintenance.setGroupId(PortalUtil.getScopeGroupId(arq));
							maintenance.setUserId(PortalUtil.getUserId(arq));
							maintenance.setUserName(PortalUtil.getUserName(PortalUtil.getUserId(arq), StringPool.BLANK));					
							MaintenanceLocalServiceUtil.addMaintenance(maintenance);
						}
				}				
			}
		}
		arp.getRenderParameters().setValue("mvcPath", "/loan/viewLoan.jsp");
	}
	
	@ProcessAction(name = "deleteLoan")
	public void deleteLoan(ActionRequest arq, ActionResponse arp) throws Exception {
		String loanId = ParamUtil.get(arq, Fields.LOANID, "-1");
		if (loanId != null && !loanId.equals(StringPool.BLANK)) {
			Loan loan = LoanLocalServiceUtil.getLoan(Long.valueOf(loanId));
			if (loan != null) {
				MaintenanceLocalServiceUtil.deleteMaintenanceByLoanId(loan.getLoanId());
				LoanActivityLocalServiceUtil.deleteLoanActivityByLoanlId(loan.getLoanId());				
				LoanLocalServiceUtil.deleteLoan(loan);
			}
		}
		arp.getRenderParameters().setValue("mvcPath", "/loan/viewLoan.jsp");
	}		
}
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package cat.diba.materialesportiu.service.impl;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Activity;
import cat.diba.materialesportiu.model.ActivityDependsOn;
import cat.diba.materialesportiu.model.Loan;
import cat.diba.materialesportiu.model.LoanActivity;
import cat.diba.materialesportiu.model.Maintenance;
import cat.diba.materialesportiu.service.ActivityDependsOnLocalServiceUtil;
import cat.diba.materialesportiu.service.ActivityLocalServiceUtil;
import cat.diba.materialesportiu.service.LoanActivityLocalServiceUtil;
import cat.diba.materialesportiu.service.LoanLocalServiceUtil;
import cat.diba.materialesportiu.service.LocalEntityLocalServiceUtil;
import cat.diba.materialesportiu.service.MaintenanceLocalServiceUtil;
import cat.diba.materialesportiu.service.base.LoanLocalServiceBaseImpl;

/**
 * The implementation of the loan local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cat.diba.materialesportiu.service.LoanLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoanLocalServiceBaseImpl
 * @see cat.diba.materialesportiu.service.LoanLocalServiceUtil
 */
public class LoanLocalServiceImpl extends LoanLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link cat.diba.materialesportiu.service.LoanLocalServiceUtil} to access the loan local service.
	 */
	public Loan addLoan(Loan loan)throws SystemException{
		CounterLocalService counterLocalService = getCounterLocalService();
		loan.setLoanId(counterLocalService.increment());
		return super.addLoan(loan);
	}
	
	public Loan updateLoan(Loan loan)throws SystemException{
		return super.updateLoan(loan);
	}
	
	public List<Loan> getLoanByCompanyGroup(long companyId, long groupId, int start, int end, OrderByComparator<Loan> obc) throws SystemException{
		return getLoanPersistence().findByCompanyGroup(companyId, groupId, start, end, obc);
	}
	
	public List<Loan> getLoanByCompanyGroup(long companyId, long groupId) throws SystemException{
		return getLoanPersistence().findByCompanyGroup(companyId, groupId);
	}
	
	public int getCountByCompanyGroup(long companyId, long groupId)throws SystemException{
		return getLoanPersistence().countByCompanyGroup(companyId, groupId);
	}
	
	public Loan getLoanId(long loanId){		
		try {
			return super.getLoan(loanId);	
			
		} catch (PortalException e) {
			return null;
		}
	}

	public int getStockAvailableBetweenDates(long activityId, Date startDate, Date endDate) throws PortalException {
		int stockOut = loanFinder.findByStockOutActivityIdBetweenDates(activityId, startDate, endDate);
		int stockOutActivityDependsOn = loanFinder.findByStockOutActivityDependsOn(activityId, startDate, endDate);		
		int inMaintenance = loanFinder.findByCountActivitiesMaintenanceBetweenDates(activityId, startDate, endDate);
		int inMaintenanceDependsOn = loanFinder.findByCountActivitiesMaintenanceDependsOn(activityId, startDate, endDate);
		int totalStockOut = (stockOut + stockOutActivityDependsOn) + (inMaintenance + inMaintenanceDependsOn);	
		
		return ActivityLocalServiceUtil.getActivity(activityId).getTotalStock() - totalStockOut;
	}		
	
	public void checkExpiredLoans() {
		loanFinder.updateLoanStatusToExpired();		
	}
	
	public void updateStatusConfirmedToBorrowed(Date today) throws PortalException {	
		if(!getLoanPersistence().findByStatusPastPickupDate(Fields.LoanStatus.CONFIRMED.toString(), today).isEmpty()){
			List <Loan> loanList = getLoanPersistence().findByStatusPastPickupDate(Fields.LoanStatus.CONFIRMED.toString(), today);
			List <LoanActivity> loanActivityList;
			Activity activity;			
			for(Loan loan : loanList) {	
				loanActivityList=LoanActivityLocalServiceUtil.getActivityByLoanId(loan.getLoanId());
				for(LoanActivity la : loanActivityList) {
					activity = ActivityLocalServiceUtil.getActivityById(la.getActivityId());
					activity.setAvailableStock(activity.getAvailableStock()-la.getQuantity());
					ActivityLocalServiceUtil.updateActivity(activity);
					//actualiza el stock de actividades hijo cuando hay actividades padre prestadas
					if(!ActivityDependsOnLocalServiceUtil.getActivityDependsOnByParentActivityId(activity.getActivityId()).isEmpty()) {
						List <ActivityDependsOn> adList=ActivityDependsOnLocalServiceUtil.getActivityDependsOnByParentActivityId(activity.getActivityId());
						for (ActivityDependsOn ad : adList ) {
							activity=ActivityLocalServiceUtil.getActivity(ad.getActivityId());
							activity.setAvailableStock(activity.getAvailableStock()-(la.getQuantity()*ad.getQuantity()));
							ActivityLocalServiceUtil.updateActivity(activity);
						}						
					}
				}
				loan.setStatus(Fields.LoanStatus.BORROWED.toString());
				LoanLocalServiceUtil.updateLoan(loan);
			}			
		}			
	}
	
	public void updateStatusBorrowedToMaintenance(Calendar today) throws PortalException {
		if(!getLoanPersistence().findByStatusPastReturnDate(Fields.LoanStatus.BORROWED.toString(), today.getTime()).isEmpty()) {
			List<Loan> loanList = getLoanPersistence().findByStatusPastReturnDate(Fields.LoanStatus.BORROWED.toString(), today.getTime());
			List <LoanActivity> loanActivityList;
			Activity activity;	
			for(Loan loan : loanList) {			
				loanActivityList=LoanActivityLocalServiceUtil.getActivityByLoanId(loan.getLoanId());
				for(LoanActivity la : loanActivityList) {
					//Si no hay actividades padre añade las prestadas
					if(ActivityDependsOnLocalServiceUtil.getActivityDependsOnByParentActivityId(la.getActivityId()).isEmpty()) {
						for(int i=0; i<la.getQuantity();i++) {
							activity=ActivityLocalServiceUtil.getActivity(la.getActivityId());
							addFromLoanToMaintenance(today, activity, loan);
						}		
					}else {//si hay actividades padre, añade únicamente las hijo
						List <ActivityDependsOn> adList=ActivityDependsOnLocalServiceUtil.getActivityDependsOnByParentActivityId(la.getActivityId());
						for (ActivityDependsOn ad : adList ) {
							for(int i=0; i<ad.getQuantity();i++) {
								activity=ActivityLocalServiceUtil.getActivity(ad.getActivityId());
								addFromLoanToMaintenance(today, activity, loan);
							}							
						}
					}													
				}
				loan.setStatus(Fields.LoanStatus.MAINTENANCE.toString());
				LoanLocalServiceUtil.updateLoan(loan);
			}
		}
	}		

	public void updateStatusMaintenanceToReturned(Date today) throws PortalException {		
		if(!getLoanPersistence().findByStatus(Fields.LoanStatus.MAINTENANCE.toString()).isEmpty()) {
			List<Loan> loanList = getLoanPersistence().findByStatus(Fields.LoanStatus.MAINTENANCE.toString());
			for(Loan loan : loanList) {
				LoanLocalServiceUtil.updateStatusMaintenanceIsDone(loan, today);
				if(MaintenanceLocalServiceUtil.getMaintenanceByLoanIdIsDone(loan.getLoanId(), Boolean.FALSE).isEmpty()) {
					loan.setStatus(Fields.LoanStatus.RETURNED.toString());
					LoanLocalServiceUtil.updateLoan(loan);
				}
			}
			
		}
	}
	
	public void updateStatusMaintenanceIsDone(Loan loan, Date today) throws PortalException {					
			Activity activity;			
				if(!MaintenanceLocalServiceUtil.getMaintenanceByLoanIdIsDone(loan.getLoanId(), Boolean.FALSE).isEmpty()) {
					List <Maintenance> maintenanceList = MaintenanceLocalServiceUtil.getMaintenanceByLoanIdIsDone(loan.getLoanId(), Boolean.FALSE);
						for(Maintenance maintenance : maintenanceList) {
							if(maintenance.getEndDate().before(today)) {
								maintenance.setIsDone(Boolean.TRUE);
								MaintenanceLocalServiceUtil.updateMaintenance(maintenance);
								activity = ActivityLocalServiceUtil.getActivity(maintenance.getActivityId());
								ActivityLocalServiceUtil.increaseAvailableStock(activity.getActivityId(), 1);
							}
						}
				}
				//Para actividades padre en mantenimiendo
				List <LoanActivity> laList = LoanActivityLocalServiceUtil.getActivityByLoanId(loan.getLoanId());
				for(LoanActivity la : laList) {
					boolean isDone=true;
					//Si existen actividades padre en mantenimiento se verifica que las actividades hijo estén isDone
					if(!ActivityDependsOnLocalServiceUtil.getActivityDependsOnByParentActivityId(la.getActivityId()).isEmpty()) {
						List <ActivityDependsOn> adList = ActivityDependsOnLocalServiceUtil.getActivityDependsOnByParentActivityId(la.getActivityId());
						for(ActivityDependsOn ad : adList) {
							if(MaintenanceLocalServiceUtil.getCountByLoanIdActivityIdIsDone(loan.getLoanId(), ad.getActivityId(), Boolean.TRUE)!=ad.getQuantity()) {
								isDone=false;
							}
						}						
					}
					if(!ActivityDependsOnLocalServiceUtil.getActivityDependsOnByParentActivityId(la.getActivityId()).isEmpty() && isDone) {//Si alguna actividad hijo está sin revisar no se actualiza el stock para la activiad padre
						activity = ActivityLocalServiceUtil.getActivity(la.getActivityId());
						ActivityLocalServiceUtil.increaseAvailableStock(activity.getActivityId(), 1);
					}
				}				
	}
	
	private void addFromLoanToMaintenance(Calendar today, Activity activity, Loan loan) throws PortalException {
		Maintenance maintenance = new MaintenanceLocalServiceUtil().createMaintenance(0);						
		maintenance.setActivityId(activity.getActivityId());
		maintenance.setLabel(activity.getName(LocaleUtil.getDefault()));					
		maintenance.setDescription(LocalEntityLocalServiceUtil.getLocalEntity(loan.getLocalEntityId()).getName()+" - "+loan.getDescription());								
		today.setTime(new Date());
		maintenance.setCreateDate(today.getTime());
		maintenance.setModifiedDate(today.getTime());
		maintenance.setStartDate(today.getTime());
		today.add(Calendar.DAY_OF_MONTH, activity.getDaysAfterLoan());						
		maintenance.setEndDate(today.getTime());
		maintenance.setIsDone(false);
		maintenance.setLoanId(loan.getLoanId());	
		maintenance.setCompanyId(loan.getCompanyId());
		maintenance.setGroupId(loan.getGroupId());
		maintenance.setUserId(loan.getUserId());
		maintenance.setUserName(loan.getUserName());
		MaintenanceLocalServiceUtil.addMaintenance(maintenance);
	}		
	
}
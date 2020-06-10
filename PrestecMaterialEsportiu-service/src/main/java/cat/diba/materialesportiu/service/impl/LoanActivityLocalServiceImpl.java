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

import java.util.List;

import cat.diba.materialesportiu.exception.NoSuchLoanActivityException;
import cat.diba.materialesportiu.model.LoanActivity;
import cat.diba.materialesportiu.model.Material;
import cat.diba.materialesportiu.service.MaterialLocalServiceUtil;
import cat.diba.materialesportiu.service.base.LoanActivityLocalServiceBaseImpl;

/**
 * The implementation of the loan activity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cat.diba.materialesportiu.service.LoanActivityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoanActivityLocalServiceBaseImpl
 * @see cat.diba.materialesportiu.service.LoanActivityLocalServiceUtil
 */
public class LoanActivityLocalServiceImpl
	extends LoanActivityLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link cat.diba.materialesportiu.service.LoanActivityLocalServiceUtil} to access the loan activity local service.
	 */
	public LoanActivity addLoanActivity(LoanActivity loanActivity)throws SystemException{
		CounterLocalService counterLocalService = getCounterLocalService();
		loanActivity.setLoanActivityId(counterLocalService.increment());
		return super.addLoanActivity(loanActivity);
	}
	
	public LoanActivity updateLoanActivity(LoanActivity loanActivity)throws SystemException{
		return super.updateLoanActivity(loanActivity);
	}
	
	public LoanActivity getLoanActivityByLoanIdActivityId (Long loanId, Long activityId)throws SystemException{
		try {
			return getLoanActivityPersistence().findByLoanIdActivityId(loanId, activityId);	
		} catch(NoSuchLoanActivityException e) {
			return null;
		}		
	}
	
	public List<LoanActivity> getActivityByLoanId(Long loanId) throws SystemException {
		return getLoanActivityPersistence().findByLoanId(loanId);
	}
	
	public List<LoanActivity> getLoanByActivityId(Long activityId) throws SystemException {
		return getLoanActivityPersistence().findByActivityId(activityId);
	}
	
	public void deleteLoanActivityByActivityId(long activityId)throws SystemException, PortalException{
		for(LoanActivity a : getLoanByActivityId(activityId)) {
			super.deleteLoanActivity(a.getLoanActivityId());
		}	
	}
	
	public void deleteLoanActivityByLoanlId(long loanId)throws SystemException, PortalException{
		for(LoanActivity a : getActivityByLoanId(loanId)) {
			super.deleteLoanActivity(a.getLoanActivityId());
		}		
	}
	
	public Material getMaterialByActivityId(long activityId)throws SystemException, PortalException{
		return MaterialLocalServiceUtil.getMaterial(activityId);
	}
}
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
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import cat.diba.materialesportiu.exception.NoSuchMaintenanceException;
import cat.diba.materialesportiu.model.Maintenance;
import cat.diba.materialesportiu.service.base.MaintenanceLocalServiceBaseImpl;

/**
 * The implementation of the maintenance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cat.diba.materialesportiu.service.MaintenanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MaintenanceLocalServiceBaseImpl
 * @see cat.diba.materialesportiu.service.MaintenanceLocalServiceUtil
 */
public class MaintenanceLocalServiceImpl extends MaintenanceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link cat.diba.materialesportiu.service.MaintenanceLocalServiceUtil} to access the maintenance local service.
	 */
	public Maintenance addMaintenance(Maintenance maintenance)throws SystemException {
		CounterLocalService counterLocalService = getCounterLocalService();
		maintenance.setMaintenanceId(counterLocalService.increment());		
		return super.addMaintenance(maintenance);
	}
	
	public List<Maintenance> getMaintenanceByActivityId(long activityId, int start, int end)throws SystemException{
		return getMaintenancePersistence().findByActivityId(activityId, start, end);
	}
	
	public Maintenance getMaintenanceByActivityIdAndLabel(long activityId, String label)throws SystemException, NoSuchMaintenanceException{
			return getMaintenancePersistence().findByActivityId_Label(activityId, label);
	}
	
	public Maintenance updateMaintenance(Maintenance maintenance)throws SystemException{
		return super.updateMaintenance(maintenance);
	}	
	
	public List<Maintenance> getMaintenanceByCompanyGroup(long companyId, long groupId, int start, int end, OrderByComparator<Maintenance> obc) throws SystemException{
		return getMaintenancePersistence().findByCompanyGroup(companyId, groupId, start, end, obc);
	}
	
	public int getCountByCompanyGroup(long companyId, long groupId)throws SystemException{
		return getMaintenancePersistence().countByCompanyGroup(companyId, groupId);
	}
	
	public int getCountByActivityId(long activityId)throws SystemException{
		return getMaintenancePersistence().countByActivityId(activityId);
	}
	
	public List<Maintenance> getMaintenanceByLoanIdIsDone(long loanId, boolean isDone){
		return getMaintenancePersistence().findByLoanIdIsDone(loanId, isDone);
	}
	
	public void deleteMaintenanceByLoanId(long loanId) throws PortalException {
		for(Maintenance m : getMaintenanceByLoanIdIsDone(loanId, Boolean.TRUE)) {
			super.deleteMaintenance(m.getMaintenanceId());
		}
	}
	
	public int getCountByLoanIdActivityIdIsDone(long loanId, long activityId, boolean isDone) {
		return getMaintenancePersistence().countByLoanIdActivityIdIsDone(loanId, activityId, isDone);
	}

}
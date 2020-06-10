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

import cat.diba.materialesportiu.exception.NoSuchActivityDependsOnException;
import cat.diba.materialesportiu.model.ActivityDependsOn;
import cat.diba.materialesportiu.service.base.ActivityDependsOnLocalServiceBaseImpl;

/**
 * The implementation of the activity depends on local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cat.diba.materialesportiu.service.ActivityDependsOnLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityDependsOnLocalServiceBaseImpl
 * @see cat.diba.materialesportiu.service.ActivityDependsOnLocalServiceUtil
 */
public class ActivityDependsOnLocalServiceImpl
	extends ActivityDependsOnLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link cat.diba.materialesportiu.service.ActivityDependsOnLocalServiceUtil} to access the activity depends on local service.
	 */
	public ActivityDependsOn addActivityDependsOn(ActivityDependsOn activityDependsOn)throws SystemException{
		CounterLocalService counterLocalService = getCounterLocalService();
		activityDependsOn.setActivityDependsOnId(counterLocalService.increment());
		return super.addActivityDependsOn(activityDependsOn);
	}

	public ActivityDependsOn updateActivityDependsOn(ActivityDependsOn activityDependsOn)throws SystemException{
		return super.updateActivityDependsOn(activityDependsOn);
	}
	public List<ActivityDependsOn> getActivityDependsOnByCompanyGroup(long companyId, long groupId, int start, int end, OrderByComparator<ActivityDependsOn> obc) throws SystemException{
		return getActivityDependsOnPersistence().findByCompanyGroup(companyId, groupId, start, end, obc);
	}
	
	public int getCountByCompanyGroup(long companyId, long groupId)throws SystemException{
		return getActivityDependsOnPersistence().countByCompanyGroup(companyId, groupId);
	}
	
	public ActivityDependsOn getActivityDependsOnByActivityIdParentActivityId(long activityId, long parentActivityId)throws SystemException{
		try {
			return getActivityDependsOnPersistence().findByActivityIdParentActivityId(activityId, parentActivityId);
		} catch (NoSuchActivityDependsOnException e) {						
			return null;
		}		
	}
	
	public List<ActivityDependsOn> getActivityDependsOnByActivityId(long activityId)throws SystemException{
		return getActivityDependsOnPersistence().findByActivityId(activityId);
	}
	
	public List<ActivityDependsOn> getActivityDependsOnByParentActivityId(long parentActivityId)throws SystemException{
		return getActivityDependsOnPersistence().findByParentActivityId(parentActivityId);
	}
	
	public void deleteActivityDependsOnByActivityId(long activityId)throws SystemException, PortalException{
		for(ActivityDependsOn a : getActivityDependsOnByActivityId(activityId)) {
			super.deleteActivityDependsOn(a.getActivityDependsOnId());
		}	
	}
	public void deleteActivityDependsOnByParentActivityId(long parentActivityId)throws SystemException, PortalException{
		for(ActivityDependsOn a : getActivityDependsOnByParentActivityId(parentActivityId)) {
			super.deleteActivityDependsOn(a.getActivityDependsOnId());
		}		
	}
}
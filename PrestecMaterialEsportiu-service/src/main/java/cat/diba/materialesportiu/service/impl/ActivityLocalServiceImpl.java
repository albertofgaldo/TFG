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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cat.diba.materialesportiu.exception.NoSuchActivityException;
import cat.diba.materialesportiu.model.Activity;
import cat.diba.materialesportiu.model.ActivityDependsOn;
import cat.diba.materialesportiu.model.Material;
import cat.diba.materialesportiu.service.ActivityDependsOnLocalServiceUtil;
import cat.diba.materialesportiu.service.LoanLocalServiceUtil;
import cat.diba.materialesportiu.service.MaterialLocalServiceUtil;
import cat.diba.materialesportiu.service.base.ActivityLocalServiceBaseImpl;

/**
 * The implementation of the activity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cat.diba.materialesportiu.service.ActivityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityLocalServiceBaseImpl
 * @see cat.diba.materialesportiu.service.ActivityLocalServiceUtil
 */
public class ActivityLocalServiceImpl extends ActivityLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link cat.diba.materialesportiu.service.ActivityLocalServiceUtil} to access the activity local service.
	 */
	public Activity addActivity(Activity activity)throws SystemException {
		CounterLocalService counterLocalService = getCounterLocalService();
		activity.setActivityId(counterLocalService.increment());
		return super.addActivity(activity);
	}
	
	public Activity getActivityById(long activityId)throws SystemException, NoSuchActivityException{
		return getActivityPersistence().findByActivityId(activityId);
	}
	
	public Activity updateActivity(Activity activity)throws SystemException{
		return super.updateActivity(activity);
	}
	
	public List<Activity> getActivityByCompanyGroup(long companyId, long groupId, int start, int end, OrderByComparator<Activity> obc) throws SystemException{
		return getActivityPersistence().findByCompanyGroup(companyId, groupId, start, end, obc);
	}
	
	public int getCountByCompanyGroup(long companyId, long groupId)throws SystemException{
		return getActivityPersistence().countByCompanyGroup(companyId, groupId);
	}
	
	public List<Activity> getActivityByCompanyGroup(long companyId, long groupId) throws SystemException{
		return getActivityPersistence().findByCompanyGroup(companyId, groupId);
	}	
	
	public List<Activity> getChildActivityByActivityId(long activityId)throws SystemException, NoSuchActivityException{
		List<ActivityDependsOn> activityDependsOn = ActivityDependsOnLocalServiceUtil.getActivityDependsOnByParentActivityId(activityId);
		List<Activity> activitiesChild = new ArrayList<>();
		if(!activityDependsOn.isEmpty()) {
			for(ActivityDependsOn a : activityDependsOn) {				
				activitiesChild.add(getActivityById(a.getActivityId()));			
			}		
		}		
		return activitiesChild;
	}
	
	public List<Activity> getAvailableActivities(long activityId,long companyId, long groupId)throws SystemException, NoSuchActivityException{
		
		List<Activity> activitiesAvailable = new ArrayList<>();
		for(Activity a : getActivityPersistence().findByCompanyGroup(companyId, groupId)) {
			if (a.getActivityId()!=activityId) {
				activitiesAvailable.add(a);
			}
		}	
		return activitiesAvailable;
	}
	
	public List<Activity> getAllActivities()throws SystemException{
		return getActivityPersistence().findAll();
	}
	
	public List<Activity> getAvailableStockActivity(long companyId, long groupId)throws SystemException{		
		return getActivityPersistence().findByAvailableStock(0);		
	}
	
	public void decreaseAvailableStock(long activityId, int units) throws NoSuchActivityException {
		Activity activity = getActivityPersistence().findByActivityId(activityId);
		activity.setAvailableStock(activity.getAvailableStock() - units);
		super.updateActivity(activity);
	}
	public void increaseAvailableStock(long activityId, int units) throws NoSuchActivityException {
		Activity activity = getActivityPersistence().findByActivityId(activityId);
		activity.setAvailableStock(activity.getAvailableStock() + units);
		super.updateActivity(activity);
	}
	
	public List<Activity> getActivitiesWithStockBetweenDates(Date startDate, Date endDate){
		List<Activity> list = new ArrayList<>();
		for (Activity a : getActivityPersistence().findAll()) {
			try {
				if(LoanLocalServiceUtil.getStockAvailableBetweenDates(a.getActivityId(), startDate, endDate)>0) {
					list.add(a);
				}
			} catch (PortalException e) {
				// TODO Auto-generated catch block				
				e.printStackTrace();				
			}
		}
		return list;
	}
	
	public float getTotalVolume(long activityId) {
		List <Material> materials = MaterialLocalServiceUtil.getMaterialbyActivityId(activityId);
		float volume=0;
		for (Material m : materials) {
			volume+=(m.getLongitude()*m.getWidth()*m.getHeigh());
		}
		return volume;
	}
	
	public float getTotalWeight(long activityId) {
		List <Material> materials = MaterialLocalServiceUtil.getMaterialbyActivityId(activityId);
		float weight=0;
		for (Material m : materials) {
			weight+=m.getWeight();
		}
		return weight;
	}

}
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

package cat.diba.materialesportiu.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ActivityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityLocalService
 * @generated
 */
@ProviderType
public class ActivityLocalServiceWrapper implements ActivityLocalService,
	ServiceWrapper<ActivityLocalService> {
	public ActivityLocalServiceWrapper(
		ActivityLocalService activityLocalService) {
		_activityLocalService = activityLocalService;
	}

	/**
	* Adds the activity to the database. Also notifies the appropriate model listeners.
	*
	* @param activity the activity
	* @return the activity that was added
	* @throws SystemException
	*/
	@Override
	public cat.diba.materialesportiu.model.Activity addActivity(
		cat.diba.materialesportiu.model.Activity activity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityLocalService.addActivity(activity);
	}

	/**
	* Creates a new activity with the primary key. Does not add the activity to the database.
	*
	* @param activityId the primary key for the new activity
	* @return the new activity
	*/
	@Override
	public cat.diba.materialesportiu.model.Activity createActivity(
		long activityId) {
		return _activityLocalService.createActivity(activityId);
	}

	@Override
	public void decreaseAvailableStock(long activityId, int units)
		throws cat.diba.materialesportiu.exception.NoSuchActivityException {
		_activityLocalService.decreaseAvailableStock(activityId, units);
	}

	/**
	* Deletes the activity from the database. Also notifies the appropriate model listeners.
	*
	* @param activity the activity
	* @return the activity that was removed
	*/
	@Override
	public cat.diba.materialesportiu.model.Activity deleteActivity(
		cat.diba.materialesportiu.model.Activity activity) {
		return _activityLocalService.deleteActivity(activity);
	}

	/**
	* Deletes the activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activityId the primary key of the activity
	* @return the activity that was removed
	* @throws PortalException if a activity with the primary key could not be found
	*/
	@Override
	public cat.diba.materialesportiu.model.Activity deleteActivity(
		long activityId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _activityLocalService.deleteActivity(activityId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _activityLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _activityLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _activityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _activityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _activityLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _activityLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _activityLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public cat.diba.materialesportiu.model.Activity fetchActivity(
		long activityId) {
		return _activityLocalService.fetchActivity(activityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _activityLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns a range of all the activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @return the range of activities
	*/
	@Override
	public java.util.List<cat.diba.materialesportiu.model.Activity> getActivities(
		int start, int end) {
		return _activityLocalService.getActivities(start, end);
	}

	/**
	* Returns the number of activities.
	*
	* @return the number of activities
	*/
	@Override
	public int getActivitiesCount() {
		return _activityLocalService.getActivitiesCount();
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.Activity> getActivitiesWithStockBetweenDates(
		java.util.Date startDate, java.util.Date endDate) {
		return _activityLocalService.getActivitiesWithStockBetweenDates(startDate,
			endDate);
	}

	/**
	* Returns the activity with the primary key.
	*
	* @param activityId the primary key of the activity
	* @return the activity
	* @throws PortalException if a activity with the primary key could not be found
	*/
	@Override
	public cat.diba.materialesportiu.model.Activity getActivity(long activityId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _activityLocalService.getActivity(activityId);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.Activity> getActivityByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityLocalService.getActivityByCompanyGroup(companyId,
			groupId);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.Activity> getActivityByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<cat.diba.materialesportiu.model.Activity> obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityLocalService.getActivityByCompanyGroup(companyId,
			groupId, start, end, obc);
	}

	@Override
	public cat.diba.materialesportiu.model.Activity getActivityById(
		long activityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			cat.diba.materialesportiu.exception.NoSuchActivityException {
		return _activityLocalService.getActivityById(activityId);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.Activity> getAllActivities()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityLocalService.getAllActivities();
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.Activity> getAvailableActivities(
		long activityId, long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			cat.diba.materialesportiu.exception.NoSuchActivityException {
		return _activityLocalService.getAvailableActivities(activityId,
			companyId, groupId);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.Activity> getAvailableStockActivity(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityLocalService.getAvailableStockActivity(companyId,
			groupId);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.Activity> getChildActivityByActivityId(
		long activityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			cat.diba.materialesportiu.exception.NoSuchActivityException {
		return _activityLocalService.getChildActivityByActivityId(activityId);
	}

	@Override
	public int getCountByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityLocalService.getCountByCompanyGroup(companyId, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _activityLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _activityLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _activityLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public float getTotalVolume(long activityId) {
		return _activityLocalService.getTotalVolume(activityId);
	}

	@Override
	public float getTotalWeight(long activityId) {
		return _activityLocalService.getTotalWeight(activityId);
	}

	@Override
	public void increaseAvailableStock(long activityId, int units)
		throws cat.diba.materialesportiu.exception.NoSuchActivityException {
		_activityLocalService.increaseAvailableStock(activityId, units);
	}

	/**
	* Updates the activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param activity the activity
	* @return the activity that was updated
	* @throws SystemException
	*/
	@Override
	public cat.diba.materialesportiu.model.Activity updateActivity(
		cat.diba.materialesportiu.model.Activity activity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityLocalService.updateActivity(activity);
	}

	@Override
	public ActivityLocalService getWrappedService() {
		return _activityLocalService;
	}

	@Override
	public void setWrappedService(ActivityLocalService activityLocalService) {
		_activityLocalService = activityLocalService;
	}

	private ActivityLocalService _activityLocalService;
}
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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Activity. This utility wraps
 * {@link cat.diba.materialesportiu.service.impl.ActivityLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityLocalService
 * @see cat.diba.materialesportiu.service.base.ActivityLocalServiceBaseImpl
 * @see cat.diba.materialesportiu.service.impl.ActivityLocalServiceImpl
 * @generated
 */
@ProviderType
public class ActivityLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link cat.diba.materialesportiu.service.impl.ActivityLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the activity to the database. Also notifies the appropriate model listeners.
	*
	* @param activity the activity
	* @return the activity that was added
	* @throws SystemException
	*/
	public static cat.diba.materialesportiu.model.Activity addActivity(
		cat.diba.materialesportiu.model.Activity activity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addActivity(activity);
	}

	/**
	* Creates a new activity with the primary key. Does not add the activity to the database.
	*
	* @param activityId the primary key for the new activity
	* @return the new activity
	*/
	public static cat.diba.materialesportiu.model.Activity createActivity(
		long activityId) {
		return getService().createActivity(activityId);
	}

	public static void decreaseAvailableStock(long activityId, int units)
		throws cat.diba.materialesportiu.exception.NoSuchActivityException {
		getService().decreaseAvailableStock(activityId, units);
	}

	/**
	* Deletes the activity from the database. Also notifies the appropriate model listeners.
	*
	* @param activity the activity
	* @return the activity that was removed
	*/
	public static cat.diba.materialesportiu.model.Activity deleteActivity(
		cat.diba.materialesportiu.model.Activity activity) {
		return getService().deleteActivity(activity);
	}

	/**
	* Deletes the activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activityId the primary key of the activity
	* @return the activity that was removed
	* @throws PortalException if a activity with the primary key could not be found
	*/
	public static cat.diba.materialesportiu.model.Activity deleteActivity(
		long activityId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteActivity(activityId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static cat.diba.materialesportiu.model.Activity fetchActivity(
		long activityId) {
		return getService().fetchActivity(activityId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
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
	public static java.util.List<cat.diba.materialesportiu.model.Activity> getActivities(
		int start, int end) {
		return getService().getActivities(start, end);
	}

	/**
	* Returns the number of activities.
	*
	* @return the number of activities
	*/
	public static int getActivitiesCount() {
		return getService().getActivitiesCount();
	}

	public static java.util.List<cat.diba.materialesportiu.model.Activity> getActivitiesWithStockBetweenDates(
		java.util.Date startDate, java.util.Date endDate) {
		return getService()
				   .getActivitiesWithStockBetweenDates(startDate, endDate);
	}

	/**
	* Returns the activity with the primary key.
	*
	* @param activityId the primary key of the activity
	* @return the activity
	* @throws PortalException if a activity with the primary key could not be found
	*/
	public static cat.diba.materialesportiu.model.Activity getActivity(
		long activityId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getActivity(activityId);
	}

	public static java.util.List<cat.diba.materialesportiu.model.Activity> getActivityByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getActivityByCompanyGroup(companyId, groupId);
	}

	public static java.util.List<cat.diba.materialesportiu.model.Activity> getActivityByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<cat.diba.materialesportiu.model.Activity> obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getActivityByCompanyGroup(companyId, groupId, start, end,
			obc);
	}

	public static cat.diba.materialesportiu.model.Activity getActivityById(
		long activityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			cat.diba.materialesportiu.exception.NoSuchActivityException {
		return getService().getActivityById(activityId);
	}

	public static java.util.List<cat.diba.materialesportiu.model.Activity> getAllActivities()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllActivities();
	}

	public static java.util.List<cat.diba.materialesportiu.model.Activity> getAvailableActivities(
		long activityId, long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			cat.diba.materialesportiu.exception.NoSuchActivityException {
		return getService()
				   .getAvailableActivities(activityId, companyId, groupId);
	}

	public static java.util.List<cat.diba.materialesportiu.model.Activity> getAvailableStockActivity(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAvailableStockActivity(companyId, groupId);
	}

	public static java.util.List<cat.diba.materialesportiu.model.Activity> getChildActivityByActivityId(
		long activityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			cat.diba.materialesportiu.exception.NoSuchActivityException {
		return getService().getChildActivityByActivityId(activityId);
	}

	public static int getCountByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountByCompanyGroup(companyId, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static float getTotalVolume(long activityId) {
		return getService().getTotalVolume(activityId);
	}

	public static float getTotalWeight(long activityId) {
		return getService().getTotalWeight(activityId);
	}

	public static void increaseAvailableStock(long activityId, int units)
		throws cat.diba.materialesportiu.exception.NoSuchActivityException {
		getService().increaseAvailableStock(activityId, units);
	}

	/**
	* Updates the activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param activity the activity
	* @return the activity that was updated
	* @throws SystemException
	*/
	public static cat.diba.materialesportiu.model.Activity updateActivity(
		cat.diba.materialesportiu.model.Activity activity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateActivity(activity);
	}

	public static ActivityLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ActivityLocalService, ActivityLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ActivityLocalService.class);

		ServiceTracker<ActivityLocalService, ActivityLocalService> serviceTracker =
			new ServiceTracker<ActivityLocalService, ActivityLocalService>(bundle.getBundleContext(),
				ActivityLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
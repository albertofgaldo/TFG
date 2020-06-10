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
 * Provides the local service utility for ActivityDependsOn. This utility wraps
 * {@link cat.diba.materialesportiu.service.impl.ActivityDependsOnLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityDependsOnLocalService
 * @see cat.diba.materialesportiu.service.base.ActivityDependsOnLocalServiceBaseImpl
 * @see cat.diba.materialesportiu.service.impl.ActivityDependsOnLocalServiceImpl
 * @generated
 */
@ProviderType
public class ActivityDependsOnLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link cat.diba.materialesportiu.service.impl.ActivityDependsOnLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the activity depends on to the database. Also notifies the appropriate model listeners.
	*
	* @param activityDependsOn the activity depends on
	* @return the activity depends on that was added
	* @throws SystemException
	*/
	public static cat.diba.materialesportiu.model.ActivityDependsOn addActivityDependsOn(
		cat.diba.materialesportiu.model.ActivityDependsOn activityDependsOn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addActivityDependsOn(activityDependsOn);
	}

	/**
	* Creates a new activity depends on with the primary key. Does not add the activity depends on to the database.
	*
	* @param activityDependsOnId the primary key for the new activity depends on
	* @return the new activity depends on
	*/
	public static cat.diba.materialesportiu.model.ActivityDependsOn createActivityDependsOn(
		long activityDependsOnId) {
		return getService().createActivityDependsOn(activityDependsOnId);
	}

	/**
	* Deletes the activity depends on from the database. Also notifies the appropriate model listeners.
	*
	* @param activityDependsOn the activity depends on
	* @return the activity depends on that was removed
	*/
	public static cat.diba.materialesportiu.model.ActivityDependsOn deleteActivityDependsOn(
		cat.diba.materialesportiu.model.ActivityDependsOn activityDependsOn) {
		return getService().deleteActivityDependsOn(activityDependsOn);
	}

	/**
	* Deletes the activity depends on with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activityDependsOnId the primary key of the activity depends on
	* @return the activity depends on that was removed
	* @throws PortalException if a activity depends on with the primary key could not be found
	*/
	public static cat.diba.materialesportiu.model.ActivityDependsOn deleteActivityDependsOn(
		long activityDependsOnId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteActivityDependsOn(activityDependsOnId);
	}

	public static void deleteActivityDependsOnByActivityId(long activityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		getService().deleteActivityDependsOnByActivityId(activityId);
	}

	public static void deleteActivityDependsOnByParentActivityId(
		long parentActivityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		getService().deleteActivityDependsOnByParentActivityId(parentActivityId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static cat.diba.materialesportiu.model.ActivityDependsOn fetchActivityDependsOn(
		long activityDependsOnId) {
		return getService().fetchActivityDependsOn(activityDependsOnId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the activity depends on with the primary key.
	*
	* @param activityDependsOnId the primary key of the activity depends on
	* @return the activity depends on
	* @throws PortalException if a activity depends on with the primary key could not be found
	*/
	public static cat.diba.materialesportiu.model.ActivityDependsOn getActivityDependsOn(
		long activityDependsOnId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getActivityDependsOn(activityDependsOnId);
	}

	public static java.util.List<cat.diba.materialesportiu.model.ActivityDependsOn> getActivityDependsOnByActivityId(
		long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getActivityDependsOnByActivityId(activityId);
	}

	public static cat.diba.materialesportiu.model.ActivityDependsOn getActivityDependsOnByActivityIdParentActivityId(
		long activityId, long parentActivityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getActivityDependsOnByActivityIdParentActivityId(activityId,
			parentActivityId);
	}

	public static java.util.List<cat.diba.materialesportiu.model.ActivityDependsOn> getActivityDependsOnByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<cat.diba.materialesportiu.model.ActivityDependsOn> obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getActivityDependsOnByCompanyGroup(companyId, groupId,
			start, end, obc);
	}

	public static java.util.List<cat.diba.materialesportiu.model.ActivityDependsOn> getActivityDependsOnByParentActivityId(
		long parentActivityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getActivityDependsOnByParentActivityId(parentActivityId);
	}

	/**
	* Returns a range of all the activity depends ons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of activity depends ons
	* @param end the upper bound of the range of activity depends ons (not inclusive)
	* @return the range of activity depends ons
	*/
	public static java.util.List<cat.diba.materialesportiu.model.ActivityDependsOn> getActivityDependsOns(
		int start, int end) {
		return getService().getActivityDependsOns(start, end);
	}

	/**
	* Returns the number of activity depends ons.
	*
	* @return the number of activity depends ons
	*/
	public static int getActivityDependsOnsCount() {
		return getService().getActivityDependsOnsCount();
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

	/**
	* Updates the activity depends on in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param activityDependsOn the activity depends on
	* @return the activity depends on that was updated
	* @throws SystemException
	*/
	public static cat.diba.materialesportiu.model.ActivityDependsOn updateActivityDependsOn(
		cat.diba.materialesportiu.model.ActivityDependsOn activityDependsOn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateActivityDependsOn(activityDependsOn);
	}

	public static ActivityDependsOnLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ActivityDependsOnLocalService, ActivityDependsOnLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ActivityDependsOnLocalService.class);

		ServiceTracker<ActivityDependsOnLocalService, ActivityDependsOnLocalService> serviceTracker =
			new ServiceTracker<ActivityDependsOnLocalService, ActivityDependsOnLocalService>(bundle.getBundleContext(),
				ActivityDependsOnLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
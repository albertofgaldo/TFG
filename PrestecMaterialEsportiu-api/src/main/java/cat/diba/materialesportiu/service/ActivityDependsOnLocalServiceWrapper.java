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
 * Provides a wrapper for {@link ActivityDependsOnLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityDependsOnLocalService
 * @generated
 */
@ProviderType
public class ActivityDependsOnLocalServiceWrapper
	implements ActivityDependsOnLocalService,
		ServiceWrapper<ActivityDependsOnLocalService> {
	public ActivityDependsOnLocalServiceWrapper(
		ActivityDependsOnLocalService activityDependsOnLocalService) {
		_activityDependsOnLocalService = activityDependsOnLocalService;
	}

	/**
	* Adds the activity depends on to the database. Also notifies the appropriate model listeners.
	*
	* @param activityDependsOn the activity depends on
	* @return the activity depends on that was added
	* @throws SystemException
	*/
	@Override
	public cat.diba.materialesportiu.model.ActivityDependsOn addActivityDependsOn(
		cat.diba.materialesportiu.model.ActivityDependsOn activityDependsOn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityDependsOnLocalService.addActivityDependsOn(activityDependsOn);
	}

	/**
	* Creates a new activity depends on with the primary key. Does not add the activity depends on to the database.
	*
	* @param activityDependsOnId the primary key for the new activity depends on
	* @return the new activity depends on
	*/
	@Override
	public cat.diba.materialesportiu.model.ActivityDependsOn createActivityDependsOn(
		long activityDependsOnId) {
		return _activityDependsOnLocalService.createActivityDependsOn(activityDependsOnId);
	}

	/**
	* Deletes the activity depends on from the database. Also notifies the appropriate model listeners.
	*
	* @param activityDependsOn the activity depends on
	* @return the activity depends on that was removed
	*/
	@Override
	public cat.diba.materialesportiu.model.ActivityDependsOn deleteActivityDependsOn(
		cat.diba.materialesportiu.model.ActivityDependsOn activityDependsOn) {
		return _activityDependsOnLocalService.deleteActivityDependsOn(activityDependsOn);
	}

	/**
	* Deletes the activity depends on with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activityDependsOnId the primary key of the activity depends on
	* @return the activity depends on that was removed
	* @throws PortalException if a activity depends on with the primary key could not be found
	*/
	@Override
	public cat.diba.materialesportiu.model.ActivityDependsOn deleteActivityDependsOn(
		long activityDependsOnId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _activityDependsOnLocalService.deleteActivityDependsOn(activityDependsOnId);
	}

	@Override
	public void deleteActivityDependsOnByActivityId(long activityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		_activityDependsOnLocalService.deleteActivityDependsOnByActivityId(activityId);
	}

	@Override
	public void deleteActivityDependsOnByParentActivityId(long parentActivityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		_activityDependsOnLocalService.deleteActivityDependsOnByParentActivityId(parentActivityId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _activityDependsOnLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _activityDependsOnLocalService.dynamicQuery();
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
		return _activityDependsOnLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _activityDependsOnLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _activityDependsOnLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _activityDependsOnLocalService.dynamicQueryCount(dynamicQuery);
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
		return _activityDependsOnLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public cat.diba.materialesportiu.model.ActivityDependsOn fetchActivityDependsOn(
		long activityDependsOnId) {
		return _activityDependsOnLocalService.fetchActivityDependsOn(activityDependsOnId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _activityDependsOnLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the activity depends on with the primary key.
	*
	* @param activityDependsOnId the primary key of the activity depends on
	* @return the activity depends on
	* @throws PortalException if a activity depends on with the primary key could not be found
	*/
	@Override
	public cat.diba.materialesportiu.model.ActivityDependsOn getActivityDependsOn(
		long activityDependsOnId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _activityDependsOnLocalService.getActivityDependsOn(activityDependsOnId);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.ActivityDependsOn> getActivityDependsOnByActivityId(
		long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityDependsOnLocalService.getActivityDependsOnByActivityId(activityId);
	}

	@Override
	public cat.diba.materialesportiu.model.ActivityDependsOn getActivityDependsOnByActivityIdParentActivityId(
		long activityId, long parentActivityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityDependsOnLocalService.getActivityDependsOnByActivityIdParentActivityId(activityId,
			parentActivityId);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.ActivityDependsOn> getActivityDependsOnByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<cat.diba.materialesportiu.model.ActivityDependsOn> obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityDependsOnLocalService.getActivityDependsOnByCompanyGroup(companyId,
			groupId, start, end, obc);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.ActivityDependsOn> getActivityDependsOnByParentActivityId(
		long parentActivityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityDependsOnLocalService.getActivityDependsOnByParentActivityId(parentActivityId);
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
	@Override
	public java.util.List<cat.diba.materialesportiu.model.ActivityDependsOn> getActivityDependsOns(
		int start, int end) {
		return _activityDependsOnLocalService.getActivityDependsOns(start, end);
	}

	/**
	* Returns the number of activity depends ons.
	*
	* @return the number of activity depends ons
	*/
	@Override
	public int getActivityDependsOnsCount() {
		return _activityDependsOnLocalService.getActivityDependsOnsCount();
	}

	@Override
	public int getCountByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityDependsOnLocalService.getCountByCompanyGroup(companyId,
			groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _activityDependsOnLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _activityDependsOnLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _activityDependsOnLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the activity depends on in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param activityDependsOn the activity depends on
	* @return the activity depends on that was updated
	* @throws SystemException
	*/
	@Override
	public cat.diba.materialesportiu.model.ActivityDependsOn updateActivityDependsOn(
		cat.diba.materialesportiu.model.ActivityDependsOn activityDependsOn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityDependsOnLocalService.updateActivityDependsOn(activityDependsOn);
	}

	@Override
	public ActivityDependsOnLocalService getWrappedService() {
		return _activityDependsOnLocalService;
	}

	@Override
	public void setWrappedService(
		ActivityDependsOnLocalService activityDependsOnLocalService) {
		_activityDependsOnLocalService = activityDependsOnLocalService;
	}

	private ActivityDependsOnLocalService _activityDependsOnLocalService;
}
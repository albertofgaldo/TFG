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

import cat.diba.materialesportiu.model.ActivityDependsOn;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for ActivityDependsOn. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityDependsOnLocalServiceUtil
 * @see cat.diba.materialesportiu.service.base.ActivityDependsOnLocalServiceBaseImpl
 * @see cat.diba.materialesportiu.service.impl.ActivityDependsOnLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ActivityDependsOnLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ActivityDependsOnLocalServiceUtil} to access the activity depends on local service. Add custom service methods to {@link cat.diba.materialesportiu.service.impl.ActivityDependsOnLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the activity depends on to the database. Also notifies the appropriate model listeners.
	*
	* @param activityDependsOn the activity depends on
	* @return the activity depends on that was added
	* @throws SystemException
	*/
	@Indexable(type = IndexableType.REINDEX)
	public ActivityDependsOn addActivityDependsOn(
		ActivityDependsOn activityDependsOn) throws SystemException;

	/**
	* Creates a new activity depends on with the primary key. Does not add the activity depends on to the database.
	*
	* @param activityDependsOnId the primary key for the new activity depends on
	* @return the new activity depends on
	*/
	@Transactional(enabled = false)
	public ActivityDependsOn createActivityDependsOn(long activityDependsOnId);

	/**
	* Deletes the activity depends on from the database. Also notifies the appropriate model listeners.
	*
	* @param activityDependsOn the activity depends on
	* @return the activity depends on that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public ActivityDependsOn deleteActivityDependsOn(
		ActivityDependsOn activityDependsOn);

	/**
	* Deletes the activity depends on with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activityDependsOnId the primary key of the activity depends on
	* @return the activity depends on that was removed
	* @throws PortalException if a activity depends on with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public ActivityDependsOn deleteActivityDependsOn(long activityDependsOnId)
		throws PortalException;

	public void deleteActivityDependsOnByActivityId(long activityId)
		throws SystemException, PortalException;

	public void deleteActivityDependsOnByParentActivityId(long parentActivityId)
		throws SystemException, PortalException;

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActivityDependsOn fetchActivityDependsOn(long activityDependsOnId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	* Returns the activity depends on with the primary key.
	*
	* @param activityDependsOnId the primary key of the activity depends on
	* @return the activity depends on
	* @throws PortalException if a activity depends on with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActivityDependsOn getActivityDependsOn(long activityDependsOnId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ActivityDependsOn> getActivityDependsOnByActivityId(
		long activityId) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActivityDependsOn getActivityDependsOnByActivityIdParentActivityId(
		long activityId, long parentActivityId) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ActivityDependsOn> getActivityDependsOnByCompanyGroup(
		long companyId, long groupId, int start, int end,
		OrderByComparator<ActivityDependsOn> obc) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ActivityDependsOn> getActivityDependsOnByParentActivityId(
		long parentActivityId) throws SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ActivityDependsOn> getActivityDependsOns(int start, int end);

	/**
	* Returns the number of activity depends ons.
	*
	* @return the number of activity depends ons
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getActivityDependsOnsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCountByCompanyGroup(long companyId, long groupId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Updates the activity depends on in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param activityDependsOn the activity depends on
	* @return the activity depends on that was updated
	* @throws SystemException
	*/
	@Indexable(type = IndexableType.REINDEX)
	public ActivityDependsOn updateActivityDependsOn(
		ActivityDependsOn activityDependsOn) throws SystemException;
}
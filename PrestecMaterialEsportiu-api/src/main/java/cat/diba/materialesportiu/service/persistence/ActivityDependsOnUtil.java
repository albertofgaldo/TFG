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

package cat.diba.materialesportiu.service.persistence;

import aQute.bnd.annotation.ProviderType;

import cat.diba.materialesportiu.model.ActivityDependsOn;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the activity depends on service. This utility wraps {@link cat.diba.materialesportiu.service.persistence.impl.ActivityDependsOnPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityDependsOnPersistence
 * @see cat.diba.materialesportiu.service.persistence.impl.ActivityDependsOnPersistenceImpl
 * @generated
 */
@ProviderType
public class ActivityDependsOnUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ActivityDependsOn activityDependsOn) {
		getPersistence().clearCache(activityDependsOn);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ActivityDependsOn> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ActivityDependsOn> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ActivityDependsOn> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ActivityDependsOn> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ActivityDependsOn update(ActivityDependsOn activityDependsOn) {
		return getPersistence().update(activityDependsOn);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ActivityDependsOn update(
		ActivityDependsOn activityDependsOn, ServiceContext serviceContext) {
		return getPersistence().update(activityDependsOn, serviceContext);
	}

	/**
	* Returns all the activity depends ons where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching activity depends ons
	*/
	public static List<ActivityDependsOn> findByCompanyGroup(long companyId,
		long groupId) {
		return getPersistence().findByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the activity depends ons where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of activity depends ons
	* @param end the upper bound of the range of activity depends ons (not inclusive)
	* @return the range of matching activity depends ons
	*/
	public static List<ActivityDependsOn> findByCompanyGroup(long companyId,
		long groupId, int start, int end) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the activity depends ons where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of activity depends ons
	* @param end the upper bound of the range of activity depends ons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching activity depends ons
	*/
	public static List<ActivityDependsOn> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<ActivityDependsOn> orderByComparator) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the activity depends ons where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of activity depends ons
	* @param end the upper bound of the range of activity depends ons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching activity depends ons
	*/
	public static List<ActivityDependsOn> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<ActivityDependsOn> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first activity depends on in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity depends on
	* @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	*/
	public static ActivityDependsOn findByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator<ActivityDependsOn> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchActivityDependsOnException {
		return getPersistence()
				   .findByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first activity depends on in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	*/
	public static ActivityDependsOn fetchByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator<ActivityDependsOn> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last activity depends on in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity depends on
	* @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	*/
	public static ActivityDependsOn findByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator<ActivityDependsOn> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchActivityDependsOnException {
		return getPersistence()
				   .findByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last activity depends on in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	*/
	public static ActivityDependsOn fetchByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator<ActivityDependsOn> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the activity depends ons before and after the current activity depends on in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param activityDependsOnId the primary key of the current activity depends on
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next activity depends on
	* @throws NoSuchActivityDependsOnException if a activity depends on with the primary key could not be found
	*/
	public static ActivityDependsOn[] findByCompanyGroup_PrevAndNext(
		long activityDependsOnId, long companyId, long groupId,
		OrderByComparator<ActivityDependsOn> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchActivityDependsOnException {
		return getPersistence()
				   .findByCompanyGroup_PrevAndNext(activityDependsOnId,
			companyId, groupId, orderByComparator);
	}

	/**
	* Removes all the activity depends ons where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public static void removeByCompanyGroup(long companyId, long groupId) {
		getPersistence().removeByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns the number of activity depends ons where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching activity depends ons
	*/
	public static int countByCompanyGroup(long companyId, long groupId) {
		return getPersistence().countByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns all the activity depends ons where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the matching activity depends ons
	*/
	public static List<ActivityDependsOn> findByActivityId(long activityId) {
		return getPersistence().findByActivityId(activityId);
	}

	/**
	* Returns a range of all the activity depends ons where activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activityId the activity ID
	* @param start the lower bound of the range of activity depends ons
	* @param end the upper bound of the range of activity depends ons (not inclusive)
	* @return the range of matching activity depends ons
	*/
	public static List<ActivityDependsOn> findByActivityId(long activityId,
		int start, int end) {
		return getPersistence().findByActivityId(activityId, start, end);
	}

	/**
	* Returns an ordered range of all the activity depends ons where activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activityId the activity ID
	* @param start the lower bound of the range of activity depends ons
	* @param end the upper bound of the range of activity depends ons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching activity depends ons
	*/
	public static List<ActivityDependsOn> findByActivityId(long activityId,
		int start, int end,
		OrderByComparator<ActivityDependsOn> orderByComparator) {
		return getPersistence()
				   .findByActivityId(activityId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the activity depends ons where activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activityId the activity ID
	* @param start the lower bound of the range of activity depends ons
	* @param end the upper bound of the range of activity depends ons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching activity depends ons
	*/
	public static List<ActivityDependsOn> findByActivityId(long activityId,
		int start, int end,
		OrderByComparator<ActivityDependsOn> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByActivityId(activityId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first activity depends on in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity depends on
	* @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	*/
	public static ActivityDependsOn findByActivityId_First(long activityId,
		OrderByComparator<ActivityDependsOn> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchActivityDependsOnException {
		return getPersistence()
				   .findByActivityId_First(activityId, orderByComparator);
	}

	/**
	* Returns the first activity depends on in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	*/
	public static ActivityDependsOn fetchByActivityId_First(long activityId,
		OrderByComparator<ActivityDependsOn> orderByComparator) {
		return getPersistence()
				   .fetchByActivityId_First(activityId, orderByComparator);
	}

	/**
	* Returns the last activity depends on in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity depends on
	* @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	*/
	public static ActivityDependsOn findByActivityId_Last(long activityId,
		OrderByComparator<ActivityDependsOn> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchActivityDependsOnException {
		return getPersistence()
				   .findByActivityId_Last(activityId, orderByComparator);
	}

	/**
	* Returns the last activity depends on in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	*/
	public static ActivityDependsOn fetchByActivityId_Last(long activityId,
		OrderByComparator<ActivityDependsOn> orderByComparator) {
		return getPersistence()
				   .fetchByActivityId_Last(activityId, orderByComparator);
	}

	/**
	* Returns the activity depends ons before and after the current activity depends on in the ordered set where activityId = &#63;.
	*
	* @param activityDependsOnId the primary key of the current activity depends on
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next activity depends on
	* @throws NoSuchActivityDependsOnException if a activity depends on with the primary key could not be found
	*/
	public static ActivityDependsOn[] findByActivityId_PrevAndNext(
		long activityDependsOnId, long activityId,
		OrderByComparator<ActivityDependsOn> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchActivityDependsOnException {
		return getPersistence()
				   .findByActivityId_PrevAndNext(activityDependsOnId,
			activityId, orderByComparator);
	}

	/**
	* Removes all the activity depends ons where activityId = &#63; from the database.
	*
	* @param activityId the activity ID
	*/
	public static void removeByActivityId(long activityId) {
		getPersistence().removeByActivityId(activityId);
	}

	/**
	* Returns the number of activity depends ons where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the number of matching activity depends ons
	*/
	public static int countByActivityId(long activityId) {
		return getPersistence().countByActivityId(activityId);
	}

	/**
	* Returns the activity depends on where activityId = &#63; and parentActivityId = &#63; or throws a {@link NoSuchActivityDependsOnException} if it could not be found.
	*
	* @param activityId the activity ID
	* @param parentActivityId the parent activity ID
	* @return the matching activity depends on
	* @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	*/
	public static ActivityDependsOn findByActivityIdParentActivityId(
		long activityId, long parentActivityId)
		throws cat.diba.materialesportiu.exception.NoSuchActivityDependsOnException {
		return getPersistence()
				   .findByActivityIdParentActivityId(activityId,
			parentActivityId);
	}

	/**
	* Returns the activity depends on where activityId = &#63; and parentActivityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param activityId the activity ID
	* @param parentActivityId the parent activity ID
	* @return the matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	*/
	public static ActivityDependsOn fetchByActivityIdParentActivityId(
		long activityId, long parentActivityId) {
		return getPersistence()
				   .fetchByActivityIdParentActivityId(activityId,
			parentActivityId);
	}

	/**
	* Returns the activity depends on where activityId = &#63; and parentActivityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param activityId the activity ID
	* @param parentActivityId the parent activity ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	*/
	public static ActivityDependsOn fetchByActivityIdParentActivityId(
		long activityId, long parentActivityId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByActivityIdParentActivityId(activityId,
			parentActivityId, retrieveFromCache);
	}

	/**
	* Removes the activity depends on where activityId = &#63; and parentActivityId = &#63; from the database.
	*
	* @param activityId the activity ID
	* @param parentActivityId the parent activity ID
	* @return the activity depends on that was removed
	*/
	public static ActivityDependsOn removeByActivityIdParentActivityId(
		long activityId, long parentActivityId)
		throws cat.diba.materialesportiu.exception.NoSuchActivityDependsOnException {
		return getPersistence()
				   .removeByActivityIdParentActivityId(activityId,
			parentActivityId);
	}

	/**
	* Returns the number of activity depends ons where activityId = &#63; and parentActivityId = &#63;.
	*
	* @param activityId the activity ID
	* @param parentActivityId the parent activity ID
	* @return the number of matching activity depends ons
	*/
	public static int countByActivityIdParentActivityId(long activityId,
		long parentActivityId) {
		return getPersistence()
				   .countByActivityIdParentActivityId(activityId,
			parentActivityId);
	}

	/**
	* Returns all the activity depends ons where parentActivityId = &#63;.
	*
	* @param parentActivityId the parent activity ID
	* @return the matching activity depends ons
	*/
	public static List<ActivityDependsOn> findByParentActivityId(
		long parentActivityId) {
		return getPersistence().findByParentActivityId(parentActivityId);
	}

	/**
	* Returns a range of all the activity depends ons where parentActivityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentActivityId the parent activity ID
	* @param start the lower bound of the range of activity depends ons
	* @param end the upper bound of the range of activity depends ons (not inclusive)
	* @return the range of matching activity depends ons
	*/
	public static List<ActivityDependsOn> findByParentActivityId(
		long parentActivityId, int start, int end) {
		return getPersistence()
				   .findByParentActivityId(parentActivityId, start, end);
	}

	/**
	* Returns an ordered range of all the activity depends ons where parentActivityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentActivityId the parent activity ID
	* @param start the lower bound of the range of activity depends ons
	* @param end the upper bound of the range of activity depends ons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching activity depends ons
	*/
	public static List<ActivityDependsOn> findByParentActivityId(
		long parentActivityId, int start, int end,
		OrderByComparator<ActivityDependsOn> orderByComparator) {
		return getPersistence()
				   .findByParentActivityId(parentActivityId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the activity depends ons where parentActivityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentActivityId the parent activity ID
	* @param start the lower bound of the range of activity depends ons
	* @param end the upper bound of the range of activity depends ons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching activity depends ons
	*/
	public static List<ActivityDependsOn> findByParentActivityId(
		long parentActivityId, int start, int end,
		OrderByComparator<ActivityDependsOn> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByParentActivityId(parentActivityId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first activity depends on in the ordered set where parentActivityId = &#63;.
	*
	* @param parentActivityId the parent activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity depends on
	* @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	*/
	public static ActivityDependsOn findByParentActivityId_First(
		long parentActivityId,
		OrderByComparator<ActivityDependsOn> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchActivityDependsOnException {
		return getPersistence()
				   .findByParentActivityId_First(parentActivityId,
			orderByComparator);
	}

	/**
	* Returns the first activity depends on in the ordered set where parentActivityId = &#63;.
	*
	* @param parentActivityId the parent activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	*/
	public static ActivityDependsOn fetchByParentActivityId_First(
		long parentActivityId,
		OrderByComparator<ActivityDependsOn> orderByComparator) {
		return getPersistence()
				   .fetchByParentActivityId_First(parentActivityId,
			orderByComparator);
	}

	/**
	* Returns the last activity depends on in the ordered set where parentActivityId = &#63;.
	*
	* @param parentActivityId the parent activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity depends on
	* @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	*/
	public static ActivityDependsOn findByParentActivityId_Last(
		long parentActivityId,
		OrderByComparator<ActivityDependsOn> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchActivityDependsOnException {
		return getPersistence()
				   .findByParentActivityId_Last(parentActivityId,
			orderByComparator);
	}

	/**
	* Returns the last activity depends on in the ordered set where parentActivityId = &#63;.
	*
	* @param parentActivityId the parent activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	*/
	public static ActivityDependsOn fetchByParentActivityId_Last(
		long parentActivityId,
		OrderByComparator<ActivityDependsOn> orderByComparator) {
		return getPersistence()
				   .fetchByParentActivityId_Last(parentActivityId,
			orderByComparator);
	}

	/**
	* Returns the activity depends ons before and after the current activity depends on in the ordered set where parentActivityId = &#63;.
	*
	* @param activityDependsOnId the primary key of the current activity depends on
	* @param parentActivityId the parent activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next activity depends on
	* @throws NoSuchActivityDependsOnException if a activity depends on with the primary key could not be found
	*/
	public static ActivityDependsOn[] findByParentActivityId_PrevAndNext(
		long activityDependsOnId, long parentActivityId,
		OrderByComparator<ActivityDependsOn> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchActivityDependsOnException {
		return getPersistence()
				   .findByParentActivityId_PrevAndNext(activityDependsOnId,
			parentActivityId, orderByComparator);
	}

	/**
	* Removes all the activity depends ons where parentActivityId = &#63; from the database.
	*
	* @param parentActivityId the parent activity ID
	*/
	public static void removeByParentActivityId(long parentActivityId) {
		getPersistence().removeByParentActivityId(parentActivityId);
	}

	/**
	* Returns the number of activity depends ons where parentActivityId = &#63;.
	*
	* @param parentActivityId the parent activity ID
	* @return the number of matching activity depends ons
	*/
	public static int countByParentActivityId(long parentActivityId) {
		return getPersistence().countByParentActivityId(parentActivityId);
	}

	/**
	* Caches the activity depends on in the entity cache if it is enabled.
	*
	* @param activityDependsOn the activity depends on
	*/
	public static void cacheResult(ActivityDependsOn activityDependsOn) {
		getPersistence().cacheResult(activityDependsOn);
	}

	/**
	* Caches the activity depends ons in the entity cache if it is enabled.
	*
	* @param activityDependsOns the activity depends ons
	*/
	public static void cacheResult(List<ActivityDependsOn> activityDependsOns) {
		getPersistence().cacheResult(activityDependsOns);
	}

	/**
	* Creates a new activity depends on with the primary key. Does not add the activity depends on to the database.
	*
	* @param activityDependsOnId the primary key for the new activity depends on
	* @return the new activity depends on
	*/
	public static ActivityDependsOn create(long activityDependsOnId) {
		return getPersistence().create(activityDependsOnId);
	}

	/**
	* Removes the activity depends on with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activityDependsOnId the primary key of the activity depends on
	* @return the activity depends on that was removed
	* @throws NoSuchActivityDependsOnException if a activity depends on with the primary key could not be found
	*/
	public static ActivityDependsOn remove(long activityDependsOnId)
		throws cat.diba.materialesportiu.exception.NoSuchActivityDependsOnException {
		return getPersistence().remove(activityDependsOnId);
	}

	public static ActivityDependsOn updateImpl(
		ActivityDependsOn activityDependsOn) {
		return getPersistence().updateImpl(activityDependsOn);
	}

	/**
	* Returns the activity depends on with the primary key or throws a {@link NoSuchActivityDependsOnException} if it could not be found.
	*
	* @param activityDependsOnId the primary key of the activity depends on
	* @return the activity depends on
	* @throws NoSuchActivityDependsOnException if a activity depends on with the primary key could not be found
	*/
	public static ActivityDependsOn findByPrimaryKey(long activityDependsOnId)
		throws cat.diba.materialesportiu.exception.NoSuchActivityDependsOnException {
		return getPersistence().findByPrimaryKey(activityDependsOnId);
	}

	/**
	* Returns the activity depends on with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param activityDependsOnId the primary key of the activity depends on
	* @return the activity depends on, or <code>null</code> if a activity depends on with the primary key could not be found
	*/
	public static ActivityDependsOn fetchByPrimaryKey(long activityDependsOnId) {
		return getPersistence().fetchByPrimaryKey(activityDependsOnId);
	}

	public static java.util.Map<java.io.Serializable, ActivityDependsOn> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the activity depends ons.
	*
	* @return the activity depends ons
	*/
	public static List<ActivityDependsOn> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the activity depends ons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of activity depends ons
	* @param end the upper bound of the range of activity depends ons (not inclusive)
	* @return the range of activity depends ons
	*/
	public static List<ActivityDependsOn> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the activity depends ons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of activity depends ons
	* @param end the upper bound of the range of activity depends ons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of activity depends ons
	*/
	public static List<ActivityDependsOn> findAll(int start, int end,
		OrderByComparator<ActivityDependsOn> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the activity depends ons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of activity depends ons
	* @param end the upper bound of the range of activity depends ons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of activity depends ons
	*/
	public static List<ActivityDependsOn> findAll(int start, int end,
		OrderByComparator<ActivityDependsOn> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the activity depends ons from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of activity depends ons.
	*
	* @return the number of activity depends ons
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ActivityDependsOnPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ActivityDependsOnPersistence, ActivityDependsOnPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ActivityDependsOnPersistence.class);

		ServiceTracker<ActivityDependsOnPersistence, ActivityDependsOnPersistence> serviceTracker =
			new ServiceTracker<ActivityDependsOnPersistence, ActivityDependsOnPersistence>(bundle.getBundleContext(),
				ActivityDependsOnPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
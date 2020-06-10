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

import cat.diba.materialesportiu.model.Activity;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the activity service. This utility wraps {@link cat.diba.materialesportiu.service.persistence.impl.ActivityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityPersistence
 * @see cat.diba.materialesportiu.service.persistence.impl.ActivityPersistenceImpl
 * @generated
 */
@ProviderType
public class ActivityUtil {
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
	public static void clearCache(Activity activity) {
		getPersistence().clearCache(activity);
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
	public static List<Activity> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Activity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Activity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Activity> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Activity update(Activity activity) {
		return getPersistence().update(activity);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Activity update(Activity activity,
		ServiceContext serviceContext) {
		return getPersistence().update(activity, serviceContext);
	}

	/**
	* Returns the activity where activityId = &#63; or throws a {@link NoSuchActivityException} if it could not be found.
	*
	* @param activityId the activity ID
	* @return the matching activity
	* @throws NoSuchActivityException if a matching activity could not be found
	*/
	public static Activity findByActivityId(long activityId)
		throws cat.diba.materialesportiu.exception.NoSuchActivityException {
		return getPersistence().findByActivityId(activityId);
	}

	/**
	* Returns the activity where activityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param activityId the activity ID
	* @return the matching activity, or <code>null</code> if a matching activity could not be found
	*/
	public static Activity fetchByActivityId(long activityId) {
		return getPersistence().fetchByActivityId(activityId);
	}

	/**
	* Returns the activity where activityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param activityId the activity ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching activity, or <code>null</code> if a matching activity could not be found
	*/
	public static Activity fetchByActivityId(long activityId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByActivityId(activityId, retrieveFromCache);
	}

	/**
	* Removes the activity where activityId = &#63; from the database.
	*
	* @param activityId the activity ID
	* @return the activity that was removed
	*/
	public static Activity removeByActivityId(long activityId)
		throws cat.diba.materialesportiu.exception.NoSuchActivityException {
		return getPersistence().removeByActivityId(activityId);
	}

	/**
	* Returns the number of activities where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the number of matching activities
	*/
	public static int countByActivityId(long activityId) {
		return getPersistence().countByActivityId(activityId);
	}

	/**
	* Returns all the activities where availableStock &gt; &#63;.
	*
	* @param availableStock the available stock
	* @return the matching activities
	*/
	public static List<Activity> findByAvailableStock(int availableStock) {
		return getPersistence().findByAvailableStock(availableStock);
	}

	/**
	* Returns a range of all the activities where availableStock &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param availableStock the available stock
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @return the range of matching activities
	*/
	public static List<Activity> findByAvailableStock(int availableStock,
		int start, int end) {
		return getPersistence().findByAvailableStock(availableStock, start, end);
	}

	/**
	* Returns an ordered range of all the activities where availableStock &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param availableStock the available stock
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching activities
	*/
	public static List<Activity> findByAvailableStock(int availableStock,
		int start, int end, OrderByComparator<Activity> orderByComparator) {
		return getPersistence()
				   .findByAvailableStock(availableStock, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the activities where availableStock &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param availableStock the available stock
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching activities
	*/
	public static List<Activity> findByAvailableStock(int availableStock,
		int start, int end, OrderByComparator<Activity> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByAvailableStock(availableStock, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first activity in the ordered set where availableStock &gt; &#63;.
	*
	* @param availableStock the available stock
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity
	* @throws NoSuchActivityException if a matching activity could not be found
	*/
	public static Activity findByAvailableStock_First(int availableStock,
		OrderByComparator<Activity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchActivityException {
		return getPersistence()
				   .findByAvailableStock_First(availableStock, orderByComparator);
	}

	/**
	* Returns the first activity in the ordered set where availableStock &gt; &#63;.
	*
	* @param availableStock the available stock
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity, or <code>null</code> if a matching activity could not be found
	*/
	public static Activity fetchByAvailableStock_First(int availableStock,
		OrderByComparator<Activity> orderByComparator) {
		return getPersistence()
				   .fetchByAvailableStock_First(availableStock,
			orderByComparator);
	}

	/**
	* Returns the last activity in the ordered set where availableStock &gt; &#63;.
	*
	* @param availableStock the available stock
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity
	* @throws NoSuchActivityException if a matching activity could not be found
	*/
	public static Activity findByAvailableStock_Last(int availableStock,
		OrderByComparator<Activity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchActivityException {
		return getPersistence()
				   .findByAvailableStock_Last(availableStock, orderByComparator);
	}

	/**
	* Returns the last activity in the ordered set where availableStock &gt; &#63;.
	*
	* @param availableStock the available stock
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity, or <code>null</code> if a matching activity could not be found
	*/
	public static Activity fetchByAvailableStock_Last(int availableStock,
		OrderByComparator<Activity> orderByComparator) {
		return getPersistence()
				   .fetchByAvailableStock_Last(availableStock, orderByComparator);
	}

	/**
	* Returns the activities before and after the current activity in the ordered set where availableStock &gt; &#63;.
	*
	* @param activityId the primary key of the current activity
	* @param availableStock the available stock
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next activity
	* @throws NoSuchActivityException if a activity with the primary key could not be found
	*/
	public static Activity[] findByAvailableStock_PrevAndNext(long activityId,
		int availableStock, OrderByComparator<Activity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchActivityException {
		return getPersistence()
				   .findByAvailableStock_PrevAndNext(activityId,
			availableStock, orderByComparator);
	}

	/**
	* Removes all the activities where availableStock &gt; &#63; from the database.
	*
	* @param availableStock the available stock
	*/
	public static void removeByAvailableStock(int availableStock) {
		getPersistence().removeByAvailableStock(availableStock);
	}

	/**
	* Returns the number of activities where availableStock &gt; &#63;.
	*
	* @param availableStock the available stock
	* @return the number of matching activities
	*/
	public static int countByAvailableStock(int availableStock) {
		return getPersistence().countByAvailableStock(availableStock);
	}

	/**
	* Returns all the activities where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching activities
	*/
	public static List<Activity> findByCompanyGroup(long companyId, long groupId) {
		return getPersistence().findByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the activities where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @return the range of matching activities
	*/
	public static List<Activity> findByCompanyGroup(long companyId,
		long groupId, int start, int end) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the activities where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching activities
	*/
	public static List<Activity> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<Activity> orderByComparator) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the activities where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching activities
	*/
	public static List<Activity> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<Activity> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity
	* @throws NoSuchActivityException if a matching activity could not be found
	*/
	public static Activity findByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator<Activity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchActivityException {
		return getPersistence()
				   .findByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity, or <code>null</code> if a matching activity could not be found
	*/
	public static Activity fetchByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator<Activity> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity
	* @throws NoSuchActivityException if a matching activity could not be found
	*/
	public static Activity findByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator<Activity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchActivityException {
		return getPersistence()
				   .findByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity, or <code>null</code> if a matching activity could not be found
	*/
	public static Activity fetchByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator<Activity> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the activities before and after the current activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param activityId the primary key of the current activity
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next activity
	* @throws NoSuchActivityException if a activity with the primary key could not be found
	*/
	public static Activity[] findByCompanyGroup_PrevAndNext(long activityId,
		long companyId, long groupId,
		OrderByComparator<Activity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchActivityException {
		return getPersistence()
				   .findByCompanyGroup_PrevAndNext(activityId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the activities where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public static void removeByCompanyGroup(long companyId, long groupId) {
		getPersistence().removeByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns the number of activities where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching activities
	*/
	public static int countByCompanyGroup(long companyId, long groupId) {
		return getPersistence().countByCompanyGroup(companyId, groupId);
	}

	/**
	* Caches the activity in the entity cache if it is enabled.
	*
	* @param activity the activity
	*/
	public static void cacheResult(Activity activity) {
		getPersistence().cacheResult(activity);
	}

	/**
	* Caches the activities in the entity cache if it is enabled.
	*
	* @param activities the activities
	*/
	public static void cacheResult(List<Activity> activities) {
		getPersistence().cacheResult(activities);
	}

	/**
	* Creates a new activity with the primary key. Does not add the activity to the database.
	*
	* @param activityId the primary key for the new activity
	* @return the new activity
	*/
	public static Activity create(long activityId) {
		return getPersistence().create(activityId);
	}

	/**
	* Removes the activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activityId the primary key of the activity
	* @return the activity that was removed
	* @throws NoSuchActivityException if a activity with the primary key could not be found
	*/
	public static Activity remove(long activityId)
		throws cat.diba.materialesportiu.exception.NoSuchActivityException {
		return getPersistence().remove(activityId);
	}

	public static Activity updateImpl(Activity activity) {
		return getPersistence().updateImpl(activity);
	}

	/**
	* Returns the activity with the primary key or throws a {@link NoSuchActivityException} if it could not be found.
	*
	* @param activityId the primary key of the activity
	* @return the activity
	* @throws NoSuchActivityException if a activity with the primary key could not be found
	*/
	public static Activity findByPrimaryKey(long activityId)
		throws cat.diba.materialesportiu.exception.NoSuchActivityException {
		return getPersistence().findByPrimaryKey(activityId);
	}

	/**
	* Returns the activity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param activityId the primary key of the activity
	* @return the activity, or <code>null</code> if a activity with the primary key could not be found
	*/
	public static Activity fetchByPrimaryKey(long activityId) {
		return getPersistence().fetchByPrimaryKey(activityId);
	}

	public static java.util.Map<java.io.Serializable, Activity> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the activities.
	*
	* @return the activities
	*/
	public static List<Activity> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @return the range of activities
	*/
	public static List<Activity> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of activities
	*/
	public static List<Activity> findAll(int start, int end,
		OrderByComparator<Activity> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of activities
	*/
	public static List<Activity> findAll(int start, int end,
		OrderByComparator<Activity> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the activities from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of activities.
	*
	* @return the number of activities
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ActivityPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ActivityPersistence, ActivityPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ActivityPersistence.class);

		ServiceTracker<ActivityPersistence, ActivityPersistence> serviceTracker = new ServiceTracker<ActivityPersistence, ActivityPersistence>(bundle.getBundleContext(),
				ActivityPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
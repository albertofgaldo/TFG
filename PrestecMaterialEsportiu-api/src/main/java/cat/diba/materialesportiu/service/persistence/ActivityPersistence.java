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

import cat.diba.materialesportiu.exception.NoSuchActivityException;
import cat.diba.materialesportiu.model.Activity;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see cat.diba.materialesportiu.service.persistence.impl.ActivityPersistenceImpl
 * @see ActivityUtil
 * @generated
 */
@ProviderType
public interface ActivityPersistence extends BasePersistence<Activity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ActivityUtil} to access the activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the activity where activityId = &#63; or throws a {@link NoSuchActivityException} if it could not be found.
	*
	* @param activityId the activity ID
	* @return the matching activity
	* @throws NoSuchActivityException if a matching activity could not be found
	*/
	public Activity findByActivityId(long activityId)
		throws NoSuchActivityException;

	/**
	* Returns the activity where activityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param activityId the activity ID
	* @return the matching activity, or <code>null</code> if a matching activity could not be found
	*/
	public Activity fetchByActivityId(long activityId);

	/**
	* Returns the activity where activityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param activityId the activity ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching activity, or <code>null</code> if a matching activity could not be found
	*/
	public Activity fetchByActivityId(long activityId, boolean retrieveFromCache);

	/**
	* Removes the activity where activityId = &#63; from the database.
	*
	* @param activityId the activity ID
	* @return the activity that was removed
	*/
	public Activity removeByActivityId(long activityId)
		throws NoSuchActivityException;

	/**
	* Returns the number of activities where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the number of matching activities
	*/
	public int countByActivityId(long activityId);

	/**
	* Returns all the activities where availableStock &gt; &#63;.
	*
	* @param availableStock the available stock
	* @return the matching activities
	*/
	public java.util.List<Activity> findByAvailableStock(int availableStock);

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
	public java.util.List<Activity> findByAvailableStock(int availableStock,
		int start, int end);

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
	public java.util.List<Activity> findByAvailableStock(int availableStock,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Activity> orderByComparator);

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
	public java.util.List<Activity> findByAvailableStock(int availableStock,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Activity> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first activity in the ordered set where availableStock &gt; &#63;.
	*
	* @param availableStock the available stock
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity
	* @throws NoSuchActivityException if a matching activity could not be found
	*/
	public Activity findByAvailableStock_First(int availableStock,
		com.liferay.portal.kernel.util.OrderByComparator<Activity> orderByComparator)
		throws NoSuchActivityException;

	/**
	* Returns the first activity in the ordered set where availableStock &gt; &#63;.
	*
	* @param availableStock the available stock
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity, or <code>null</code> if a matching activity could not be found
	*/
	public Activity fetchByAvailableStock_First(int availableStock,
		com.liferay.portal.kernel.util.OrderByComparator<Activity> orderByComparator);

	/**
	* Returns the last activity in the ordered set where availableStock &gt; &#63;.
	*
	* @param availableStock the available stock
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity
	* @throws NoSuchActivityException if a matching activity could not be found
	*/
	public Activity findByAvailableStock_Last(int availableStock,
		com.liferay.portal.kernel.util.OrderByComparator<Activity> orderByComparator)
		throws NoSuchActivityException;

	/**
	* Returns the last activity in the ordered set where availableStock &gt; &#63;.
	*
	* @param availableStock the available stock
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity, or <code>null</code> if a matching activity could not be found
	*/
	public Activity fetchByAvailableStock_Last(int availableStock,
		com.liferay.portal.kernel.util.OrderByComparator<Activity> orderByComparator);

	/**
	* Returns the activities before and after the current activity in the ordered set where availableStock &gt; &#63;.
	*
	* @param activityId the primary key of the current activity
	* @param availableStock the available stock
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next activity
	* @throws NoSuchActivityException if a activity with the primary key could not be found
	*/
	public Activity[] findByAvailableStock_PrevAndNext(long activityId,
		int availableStock,
		com.liferay.portal.kernel.util.OrderByComparator<Activity> orderByComparator)
		throws NoSuchActivityException;

	/**
	* Removes all the activities where availableStock &gt; &#63; from the database.
	*
	* @param availableStock the available stock
	*/
	public void removeByAvailableStock(int availableStock);

	/**
	* Returns the number of activities where availableStock &gt; &#63;.
	*
	* @param availableStock the available stock
	* @return the number of matching activities
	*/
	public int countByAvailableStock(int availableStock);

	/**
	* Returns all the activities where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching activities
	*/
	public java.util.List<Activity> findByCompanyGroup(long companyId,
		long groupId);

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
	public java.util.List<Activity> findByCompanyGroup(long companyId,
		long groupId, int start, int end);

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
	public java.util.List<Activity> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Activity> orderByComparator);

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
	public java.util.List<Activity> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Activity> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity
	* @throws NoSuchActivityException if a matching activity could not be found
	*/
	public Activity findByCompanyGroup_First(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Activity> orderByComparator)
		throws NoSuchActivityException;

	/**
	* Returns the first activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity, or <code>null</code> if a matching activity could not be found
	*/
	public Activity fetchByCompanyGroup_First(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Activity> orderByComparator);

	/**
	* Returns the last activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity
	* @throws NoSuchActivityException if a matching activity could not be found
	*/
	public Activity findByCompanyGroup_Last(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Activity> orderByComparator)
		throws NoSuchActivityException;

	/**
	* Returns the last activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity, or <code>null</code> if a matching activity could not be found
	*/
	public Activity fetchByCompanyGroup_Last(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Activity> orderByComparator);

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
	public Activity[] findByCompanyGroup_PrevAndNext(long activityId,
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Activity> orderByComparator)
		throws NoSuchActivityException;

	/**
	* Removes all the activities where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public void removeByCompanyGroup(long companyId, long groupId);

	/**
	* Returns the number of activities where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching activities
	*/
	public int countByCompanyGroup(long companyId, long groupId);

	/**
	* Caches the activity in the entity cache if it is enabled.
	*
	* @param activity the activity
	*/
	public void cacheResult(Activity activity);

	/**
	* Caches the activities in the entity cache if it is enabled.
	*
	* @param activities the activities
	*/
	public void cacheResult(java.util.List<Activity> activities);

	/**
	* Creates a new activity with the primary key. Does not add the activity to the database.
	*
	* @param activityId the primary key for the new activity
	* @return the new activity
	*/
	public Activity create(long activityId);

	/**
	* Removes the activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activityId the primary key of the activity
	* @return the activity that was removed
	* @throws NoSuchActivityException if a activity with the primary key could not be found
	*/
	public Activity remove(long activityId) throws NoSuchActivityException;

	public Activity updateImpl(Activity activity);

	/**
	* Returns the activity with the primary key or throws a {@link NoSuchActivityException} if it could not be found.
	*
	* @param activityId the primary key of the activity
	* @return the activity
	* @throws NoSuchActivityException if a activity with the primary key could not be found
	*/
	public Activity findByPrimaryKey(long activityId)
		throws NoSuchActivityException;

	/**
	* Returns the activity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param activityId the primary key of the activity
	* @return the activity, or <code>null</code> if a activity with the primary key could not be found
	*/
	public Activity fetchByPrimaryKey(long activityId);

	@Override
	public java.util.Map<java.io.Serializable, Activity> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the activities.
	*
	* @return the activities
	*/
	public java.util.List<Activity> findAll();

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
	public java.util.List<Activity> findAll(int start, int end);

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
	public java.util.List<Activity> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Activity> orderByComparator);

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
	public java.util.List<Activity> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Activity> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the activities from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of activities.
	*
	* @return the number of activities
	*/
	public int countAll();
}
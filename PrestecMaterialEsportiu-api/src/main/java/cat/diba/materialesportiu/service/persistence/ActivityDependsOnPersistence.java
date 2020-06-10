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

import cat.diba.materialesportiu.exception.NoSuchActivityDependsOnException;
import cat.diba.materialesportiu.model.ActivityDependsOn;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the activity depends on service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see cat.diba.materialesportiu.service.persistence.impl.ActivityDependsOnPersistenceImpl
 * @see ActivityDependsOnUtil
 * @generated
 */
@ProviderType
public interface ActivityDependsOnPersistence extends BasePersistence<ActivityDependsOn> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ActivityDependsOnUtil} to access the activity depends on persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the activity depends ons where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching activity depends ons
	*/
	public java.util.List<ActivityDependsOn> findByCompanyGroup(
		long companyId, long groupId);

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
	public java.util.List<ActivityDependsOn> findByCompanyGroup(
		long companyId, long groupId, int start, int end);

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
	public java.util.List<ActivityDependsOn> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator);

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
	public java.util.List<ActivityDependsOn> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first activity depends on in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity depends on
	* @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	*/
	public ActivityDependsOn findByCompanyGroup_First(long companyId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException;

	/**
	* Returns the first activity depends on in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	*/
	public ActivityDependsOn fetchByCompanyGroup_First(long companyId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator);

	/**
	* Returns the last activity depends on in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity depends on
	* @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	*/
	public ActivityDependsOn findByCompanyGroup_Last(long companyId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException;

	/**
	* Returns the last activity depends on in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	*/
	public ActivityDependsOn fetchByCompanyGroup_Last(long companyId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator);

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
	public ActivityDependsOn[] findByCompanyGroup_PrevAndNext(
		long activityDependsOnId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException;

	/**
	* Removes all the activity depends ons where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public void removeByCompanyGroup(long companyId, long groupId);

	/**
	* Returns the number of activity depends ons where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching activity depends ons
	*/
	public int countByCompanyGroup(long companyId, long groupId);

	/**
	* Returns all the activity depends ons where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the matching activity depends ons
	*/
	public java.util.List<ActivityDependsOn> findByActivityId(long activityId);

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
	public java.util.List<ActivityDependsOn> findByActivityId(long activityId,
		int start, int end);

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
	public java.util.List<ActivityDependsOn> findByActivityId(long activityId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator);

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
	public java.util.List<ActivityDependsOn> findByActivityId(long activityId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first activity depends on in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity depends on
	* @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	*/
	public ActivityDependsOn findByActivityId_First(long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException;

	/**
	* Returns the first activity depends on in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	*/
	public ActivityDependsOn fetchByActivityId_First(long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator);

	/**
	* Returns the last activity depends on in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity depends on
	* @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	*/
	public ActivityDependsOn findByActivityId_Last(long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException;

	/**
	* Returns the last activity depends on in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	*/
	public ActivityDependsOn fetchByActivityId_Last(long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator);

	/**
	* Returns the activity depends ons before and after the current activity depends on in the ordered set where activityId = &#63;.
	*
	* @param activityDependsOnId the primary key of the current activity depends on
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next activity depends on
	* @throws NoSuchActivityDependsOnException if a activity depends on with the primary key could not be found
	*/
	public ActivityDependsOn[] findByActivityId_PrevAndNext(
		long activityDependsOnId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException;

	/**
	* Removes all the activity depends ons where activityId = &#63; from the database.
	*
	* @param activityId the activity ID
	*/
	public void removeByActivityId(long activityId);

	/**
	* Returns the number of activity depends ons where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the number of matching activity depends ons
	*/
	public int countByActivityId(long activityId);

	/**
	* Returns the activity depends on where activityId = &#63; and parentActivityId = &#63; or throws a {@link NoSuchActivityDependsOnException} if it could not be found.
	*
	* @param activityId the activity ID
	* @param parentActivityId the parent activity ID
	* @return the matching activity depends on
	* @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	*/
	public ActivityDependsOn findByActivityIdParentActivityId(long activityId,
		long parentActivityId) throws NoSuchActivityDependsOnException;

	/**
	* Returns the activity depends on where activityId = &#63; and parentActivityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param activityId the activity ID
	* @param parentActivityId the parent activity ID
	* @return the matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	*/
	public ActivityDependsOn fetchByActivityIdParentActivityId(
		long activityId, long parentActivityId);

	/**
	* Returns the activity depends on where activityId = &#63; and parentActivityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param activityId the activity ID
	* @param parentActivityId the parent activity ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	*/
	public ActivityDependsOn fetchByActivityIdParentActivityId(
		long activityId, long parentActivityId, boolean retrieveFromCache);

	/**
	* Removes the activity depends on where activityId = &#63; and parentActivityId = &#63; from the database.
	*
	* @param activityId the activity ID
	* @param parentActivityId the parent activity ID
	* @return the activity depends on that was removed
	*/
	public ActivityDependsOn removeByActivityIdParentActivityId(
		long activityId, long parentActivityId)
		throws NoSuchActivityDependsOnException;

	/**
	* Returns the number of activity depends ons where activityId = &#63; and parentActivityId = &#63;.
	*
	* @param activityId the activity ID
	* @param parentActivityId the parent activity ID
	* @return the number of matching activity depends ons
	*/
	public int countByActivityIdParentActivityId(long activityId,
		long parentActivityId);

	/**
	* Returns all the activity depends ons where parentActivityId = &#63;.
	*
	* @param parentActivityId the parent activity ID
	* @return the matching activity depends ons
	*/
	public java.util.List<ActivityDependsOn> findByParentActivityId(
		long parentActivityId);

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
	public java.util.List<ActivityDependsOn> findByParentActivityId(
		long parentActivityId, int start, int end);

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
	public java.util.List<ActivityDependsOn> findByParentActivityId(
		long parentActivityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator);

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
	public java.util.List<ActivityDependsOn> findByParentActivityId(
		long parentActivityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first activity depends on in the ordered set where parentActivityId = &#63;.
	*
	* @param parentActivityId the parent activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity depends on
	* @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	*/
	public ActivityDependsOn findByParentActivityId_First(
		long parentActivityId,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException;

	/**
	* Returns the first activity depends on in the ordered set where parentActivityId = &#63;.
	*
	* @param parentActivityId the parent activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	*/
	public ActivityDependsOn fetchByParentActivityId_First(
		long parentActivityId,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator);

	/**
	* Returns the last activity depends on in the ordered set where parentActivityId = &#63;.
	*
	* @param parentActivityId the parent activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity depends on
	* @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	*/
	public ActivityDependsOn findByParentActivityId_Last(
		long parentActivityId,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException;

	/**
	* Returns the last activity depends on in the ordered set where parentActivityId = &#63;.
	*
	* @param parentActivityId the parent activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	*/
	public ActivityDependsOn fetchByParentActivityId_Last(
		long parentActivityId,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator);

	/**
	* Returns the activity depends ons before and after the current activity depends on in the ordered set where parentActivityId = &#63;.
	*
	* @param activityDependsOnId the primary key of the current activity depends on
	* @param parentActivityId the parent activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next activity depends on
	* @throws NoSuchActivityDependsOnException if a activity depends on with the primary key could not be found
	*/
	public ActivityDependsOn[] findByParentActivityId_PrevAndNext(
		long activityDependsOnId, long parentActivityId,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException;

	/**
	* Removes all the activity depends ons where parentActivityId = &#63; from the database.
	*
	* @param parentActivityId the parent activity ID
	*/
	public void removeByParentActivityId(long parentActivityId);

	/**
	* Returns the number of activity depends ons where parentActivityId = &#63;.
	*
	* @param parentActivityId the parent activity ID
	* @return the number of matching activity depends ons
	*/
	public int countByParentActivityId(long parentActivityId);

	/**
	* Caches the activity depends on in the entity cache if it is enabled.
	*
	* @param activityDependsOn the activity depends on
	*/
	public void cacheResult(ActivityDependsOn activityDependsOn);

	/**
	* Caches the activity depends ons in the entity cache if it is enabled.
	*
	* @param activityDependsOns the activity depends ons
	*/
	public void cacheResult(
		java.util.List<ActivityDependsOn> activityDependsOns);

	/**
	* Creates a new activity depends on with the primary key. Does not add the activity depends on to the database.
	*
	* @param activityDependsOnId the primary key for the new activity depends on
	* @return the new activity depends on
	*/
	public ActivityDependsOn create(long activityDependsOnId);

	/**
	* Removes the activity depends on with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activityDependsOnId the primary key of the activity depends on
	* @return the activity depends on that was removed
	* @throws NoSuchActivityDependsOnException if a activity depends on with the primary key could not be found
	*/
	public ActivityDependsOn remove(long activityDependsOnId)
		throws NoSuchActivityDependsOnException;

	public ActivityDependsOn updateImpl(ActivityDependsOn activityDependsOn);

	/**
	* Returns the activity depends on with the primary key or throws a {@link NoSuchActivityDependsOnException} if it could not be found.
	*
	* @param activityDependsOnId the primary key of the activity depends on
	* @return the activity depends on
	* @throws NoSuchActivityDependsOnException if a activity depends on with the primary key could not be found
	*/
	public ActivityDependsOn findByPrimaryKey(long activityDependsOnId)
		throws NoSuchActivityDependsOnException;

	/**
	* Returns the activity depends on with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param activityDependsOnId the primary key of the activity depends on
	* @return the activity depends on, or <code>null</code> if a activity depends on with the primary key could not be found
	*/
	public ActivityDependsOn fetchByPrimaryKey(long activityDependsOnId);

	@Override
	public java.util.Map<java.io.Serializable, ActivityDependsOn> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the activity depends ons.
	*
	* @return the activity depends ons
	*/
	public java.util.List<ActivityDependsOn> findAll();

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
	public java.util.List<ActivityDependsOn> findAll(int start, int end);

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
	public java.util.List<ActivityDependsOn> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator);

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
	public java.util.List<ActivityDependsOn> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ActivityDependsOn> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the activity depends ons from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of activity depends ons.
	*
	* @return the number of activity depends ons
	*/
	public int countAll();
}
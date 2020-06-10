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

import cat.diba.materialesportiu.model.LoanActivity;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the loan activity service. This utility wraps {@link cat.diba.materialesportiu.service.persistence.impl.LoanActivityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoanActivityPersistence
 * @see cat.diba.materialesportiu.service.persistence.impl.LoanActivityPersistenceImpl
 * @generated
 */
@ProviderType
public class LoanActivityUtil {
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
	public static void clearCache(LoanActivity loanActivity) {
		getPersistence().clearCache(loanActivity);
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
	public static List<LoanActivity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LoanActivity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LoanActivity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LoanActivity> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LoanActivity update(LoanActivity loanActivity) {
		return getPersistence().update(loanActivity);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LoanActivity update(LoanActivity loanActivity,
		ServiceContext serviceContext) {
		return getPersistence().update(loanActivity, serviceContext);
	}

	/**
	* Returns all the loan activities where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching loan activities
	*/
	public static List<LoanActivity> findByCompanyGroup(long companyId,
		long groupId) {
		return getPersistence().findByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the loan activities where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of loan activities
	* @param end the upper bound of the range of loan activities (not inclusive)
	* @return the range of matching loan activities
	*/
	public static List<LoanActivity> findByCompanyGroup(long companyId,
		long groupId, int start, int end) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the loan activities where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of loan activities
	* @param end the upper bound of the range of loan activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loan activities
	*/
	public static List<LoanActivity> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<LoanActivity> orderByComparator) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the loan activities where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of loan activities
	* @param end the upper bound of the range of loan activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching loan activities
	*/
	public static List<LoanActivity> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<LoanActivity> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first loan activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan activity
	* @throws NoSuchLoanActivityException if a matching loan activity could not be found
	*/
	public static LoanActivity findByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator<LoanActivity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanActivityException {
		return getPersistence()
				   .findByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first loan activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan activity, or <code>null</code> if a matching loan activity could not be found
	*/
	public static LoanActivity fetchByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator<LoanActivity> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last loan activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan activity
	* @throws NoSuchLoanActivityException if a matching loan activity could not be found
	*/
	public static LoanActivity findByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator<LoanActivity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanActivityException {
		return getPersistence()
				   .findByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last loan activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan activity, or <code>null</code> if a matching loan activity could not be found
	*/
	public static LoanActivity fetchByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator<LoanActivity> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the loan activities before and after the current loan activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param loanActivityId the primary key of the current loan activity
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan activity
	* @throws NoSuchLoanActivityException if a loan activity with the primary key could not be found
	*/
	public static LoanActivity[] findByCompanyGroup_PrevAndNext(
		long loanActivityId, long companyId, long groupId,
		OrderByComparator<LoanActivity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanActivityException {
		return getPersistence()
				   .findByCompanyGroup_PrevAndNext(loanActivityId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the loan activities where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public static void removeByCompanyGroup(long companyId, long groupId) {
		getPersistence().removeByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns the number of loan activities where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching loan activities
	*/
	public static int countByCompanyGroup(long companyId, long groupId) {
		return getPersistence().countByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns all the loan activities where loanId = &#63;.
	*
	* @param loanId the loan ID
	* @return the matching loan activities
	*/
	public static List<LoanActivity> findByLoanId(long loanId) {
		return getPersistence().findByLoanId(loanId);
	}

	/**
	* Returns a range of all the loan activities where loanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param loanId the loan ID
	* @param start the lower bound of the range of loan activities
	* @param end the upper bound of the range of loan activities (not inclusive)
	* @return the range of matching loan activities
	*/
	public static List<LoanActivity> findByLoanId(long loanId, int start,
		int end) {
		return getPersistence().findByLoanId(loanId, start, end);
	}

	/**
	* Returns an ordered range of all the loan activities where loanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param loanId the loan ID
	* @param start the lower bound of the range of loan activities
	* @param end the upper bound of the range of loan activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loan activities
	*/
	public static List<LoanActivity> findByLoanId(long loanId, int start,
		int end, OrderByComparator<LoanActivity> orderByComparator) {
		return getPersistence()
				   .findByLoanId(loanId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the loan activities where loanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param loanId the loan ID
	* @param start the lower bound of the range of loan activities
	* @param end the upper bound of the range of loan activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching loan activities
	*/
	public static List<LoanActivity> findByLoanId(long loanId, int start,
		int end, OrderByComparator<LoanActivity> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByLoanId(loanId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first loan activity in the ordered set where loanId = &#63;.
	*
	* @param loanId the loan ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan activity
	* @throws NoSuchLoanActivityException if a matching loan activity could not be found
	*/
	public static LoanActivity findByLoanId_First(long loanId,
		OrderByComparator<LoanActivity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanActivityException {
		return getPersistence().findByLoanId_First(loanId, orderByComparator);
	}

	/**
	* Returns the first loan activity in the ordered set where loanId = &#63;.
	*
	* @param loanId the loan ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan activity, or <code>null</code> if a matching loan activity could not be found
	*/
	public static LoanActivity fetchByLoanId_First(long loanId,
		OrderByComparator<LoanActivity> orderByComparator) {
		return getPersistence().fetchByLoanId_First(loanId, orderByComparator);
	}

	/**
	* Returns the last loan activity in the ordered set where loanId = &#63;.
	*
	* @param loanId the loan ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan activity
	* @throws NoSuchLoanActivityException if a matching loan activity could not be found
	*/
	public static LoanActivity findByLoanId_Last(long loanId,
		OrderByComparator<LoanActivity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanActivityException {
		return getPersistence().findByLoanId_Last(loanId, orderByComparator);
	}

	/**
	* Returns the last loan activity in the ordered set where loanId = &#63;.
	*
	* @param loanId the loan ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan activity, or <code>null</code> if a matching loan activity could not be found
	*/
	public static LoanActivity fetchByLoanId_Last(long loanId,
		OrderByComparator<LoanActivity> orderByComparator) {
		return getPersistence().fetchByLoanId_Last(loanId, orderByComparator);
	}

	/**
	* Returns the loan activities before and after the current loan activity in the ordered set where loanId = &#63;.
	*
	* @param loanActivityId the primary key of the current loan activity
	* @param loanId the loan ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan activity
	* @throws NoSuchLoanActivityException if a loan activity with the primary key could not be found
	*/
	public static LoanActivity[] findByLoanId_PrevAndNext(long loanActivityId,
		long loanId, OrderByComparator<LoanActivity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanActivityException {
		return getPersistence()
				   .findByLoanId_PrevAndNext(loanActivityId, loanId,
			orderByComparator);
	}

	/**
	* Removes all the loan activities where loanId = &#63; from the database.
	*
	* @param loanId the loan ID
	*/
	public static void removeByLoanId(long loanId) {
		getPersistence().removeByLoanId(loanId);
	}

	/**
	* Returns the number of loan activities where loanId = &#63;.
	*
	* @param loanId the loan ID
	* @return the number of matching loan activities
	*/
	public static int countByLoanId(long loanId) {
		return getPersistence().countByLoanId(loanId);
	}

	/**
	* Returns all the loan activities where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the matching loan activities
	*/
	public static List<LoanActivity> findByActivityId(long activityId) {
		return getPersistence().findByActivityId(activityId);
	}

	/**
	* Returns a range of all the loan activities where activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activityId the activity ID
	* @param start the lower bound of the range of loan activities
	* @param end the upper bound of the range of loan activities (not inclusive)
	* @return the range of matching loan activities
	*/
	public static List<LoanActivity> findByActivityId(long activityId,
		int start, int end) {
		return getPersistence().findByActivityId(activityId, start, end);
	}

	/**
	* Returns an ordered range of all the loan activities where activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activityId the activity ID
	* @param start the lower bound of the range of loan activities
	* @param end the upper bound of the range of loan activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loan activities
	*/
	public static List<LoanActivity> findByActivityId(long activityId,
		int start, int end, OrderByComparator<LoanActivity> orderByComparator) {
		return getPersistence()
				   .findByActivityId(activityId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the loan activities where activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activityId the activity ID
	* @param start the lower bound of the range of loan activities
	* @param end the upper bound of the range of loan activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching loan activities
	*/
	public static List<LoanActivity> findByActivityId(long activityId,
		int start, int end, OrderByComparator<LoanActivity> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByActivityId(activityId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first loan activity in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan activity
	* @throws NoSuchLoanActivityException if a matching loan activity could not be found
	*/
	public static LoanActivity findByActivityId_First(long activityId,
		OrderByComparator<LoanActivity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanActivityException {
		return getPersistence()
				   .findByActivityId_First(activityId, orderByComparator);
	}

	/**
	* Returns the first loan activity in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan activity, or <code>null</code> if a matching loan activity could not be found
	*/
	public static LoanActivity fetchByActivityId_First(long activityId,
		OrderByComparator<LoanActivity> orderByComparator) {
		return getPersistence()
				   .fetchByActivityId_First(activityId, orderByComparator);
	}

	/**
	* Returns the last loan activity in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan activity
	* @throws NoSuchLoanActivityException if a matching loan activity could not be found
	*/
	public static LoanActivity findByActivityId_Last(long activityId,
		OrderByComparator<LoanActivity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanActivityException {
		return getPersistence()
				   .findByActivityId_Last(activityId, orderByComparator);
	}

	/**
	* Returns the last loan activity in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan activity, or <code>null</code> if a matching loan activity could not be found
	*/
	public static LoanActivity fetchByActivityId_Last(long activityId,
		OrderByComparator<LoanActivity> orderByComparator) {
		return getPersistence()
				   .fetchByActivityId_Last(activityId, orderByComparator);
	}

	/**
	* Returns the loan activities before and after the current loan activity in the ordered set where activityId = &#63;.
	*
	* @param loanActivityId the primary key of the current loan activity
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan activity
	* @throws NoSuchLoanActivityException if a loan activity with the primary key could not be found
	*/
	public static LoanActivity[] findByActivityId_PrevAndNext(
		long loanActivityId, long activityId,
		OrderByComparator<LoanActivity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanActivityException {
		return getPersistence()
				   .findByActivityId_PrevAndNext(loanActivityId, activityId,
			orderByComparator);
	}

	/**
	* Removes all the loan activities where activityId = &#63; from the database.
	*
	* @param activityId the activity ID
	*/
	public static void removeByActivityId(long activityId) {
		getPersistence().removeByActivityId(activityId);
	}

	/**
	* Returns the number of loan activities where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the number of matching loan activities
	*/
	public static int countByActivityId(long activityId) {
		return getPersistence().countByActivityId(activityId);
	}

	/**
	* Returns the loan activity where loanId = &#63; and activityId = &#63; or throws a {@link NoSuchLoanActivityException} if it could not be found.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @return the matching loan activity
	* @throws NoSuchLoanActivityException if a matching loan activity could not be found
	*/
	public static LoanActivity findByLoanIdActivityId(long loanId,
		long activityId)
		throws cat.diba.materialesportiu.exception.NoSuchLoanActivityException {
		return getPersistence().findByLoanIdActivityId(loanId, activityId);
	}

	/**
	* Returns the loan activity where loanId = &#63; and activityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @return the matching loan activity, or <code>null</code> if a matching loan activity could not be found
	*/
	public static LoanActivity fetchByLoanIdActivityId(long loanId,
		long activityId) {
		return getPersistence().fetchByLoanIdActivityId(loanId, activityId);
	}

	/**
	* Returns the loan activity where loanId = &#63; and activityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching loan activity, or <code>null</code> if a matching loan activity could not be found
	*/
	public static LoanActivity fetchByLoanIdActivityId(long loanId,
		long activityId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByLoanIdActivityId(loanId, activityId,
			retrieveFromCache);
	}

	/**
	* Removes the loan activity where loanId = &#63; and activityId = &#63; from the database.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @return the loan activity that was removed
	*/
	public static LoanActivity removeByLoanIdActivityId(long loanId,
		long activityId)
		throws cat.diba.materialesportiu.exception.NoSuchLoanActivityException {
		return getPersistence().removeByLoanIdActivityId(loanId, activityId);
	}

	/**
	* Returns the number of loan activities where loanId = &#63; and activityId = &#63;.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @return the number of matching loan activities
	*/
	public static int countByLoanIdActivityId(long loanId, long activityId) {
		return getPersistence().countByLoanIdActivityId(loanId, activityId);
	}

	/**
	* Caches the loan activity in the entity cache if it is enabled.
	*
	* @param loanActivity the loan activity
	*/
	public static void cacheResult(LoanActivity loanActivity) {
		getPersistence().cacheResult(loanActivity);
	}

	/**
	* Caches the loan activities in the entity cache if it is enabled.
	*
	* @param loanActivities the loan activities
	*/
	public static void cacheResult(List<LoanActivity> loanActivities) {
		getPersistence().cacheResult(loanActivities);
	}

	/**
	* Creates a new loan activity with the primary key. Does not add the loan activity to the database.
	*
	* @param loanActivityId the primary key for the new loan activity
	* @return the new loan activity
	*/
	public static LoanActivity create(long loanActivityId) {
		return getPersistence().create(loanActivityId);
	}

	/**
	* Removes the loan activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loanActivityId the primary key of the loan activity
	* @return the loan activity that was removed
	* @throws NoSuchLoanActivityException if a loan activity with the primary key could not be found
	*/
	public static LoanActivity remove(long loanActivityId)
		throws cat.diba.materialesportiu.exception.NoSuchLoanActivityException {
		return getPersistence().remove(loanActivityId);
	}

	public static LoanActivity updateImpl(LoanActivity loanActivity) {
		return getPersistence().updateImpl(loanActivity);
	}

	/**
	* Returns the loan activity with the primary key or throws a {@link NoSuchLoanActivityException} if it could not be found.
	*
	* @param loanActivityId the primary key of the loan activity
	* @return the loan activity
	* @throws NoSuchLoanActivityException if a loan activity with the primary key could not be found
	*/
	public static LoanActivity findByPrimaryKey(long loanActivityId)
		throws cat.diba.materialesportiu.exception.NoSuchLoanActivityException {
		return getPersistence().findByPrimaryKey(loanActivityId);
	}

	/**
	* Returns the loan activity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param loanActivityId the primary key of the loan activity
	* @return the loan activity, or <code>null</code> if a loan activity with the primary key could not be found
	*/
	public static LoanActivity fetchByPrimaryKey(long loanActivityId) {
		return getPersistence().fetchByPrimaryKey(loanActivityId);
	}

	public static java.util.Map<java.io.Serializable, LoanActivity> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the loan activities.
	*
	* @return the loan activities
	*/
	public static List<LoanActivity> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the loan activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loan activities
	* @param end the upper bound of the range of loan activities (not inclusive)
	* @return the range of loan activities
	*/
	public static List<LoanActivity> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the loan activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loan activities
	* @param end the upper bound of the range of loan activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of loan activities
	*/
	public static List<LoanActivity> findAll(int start, int end,
		OrderByComparator<LoanActivity> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the loan activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loan activities
	* @param end the upper bound of the range of loan activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of loan activities
	*/
	public static List<LoanActivity> findAll(int start, int end,
		OrderByComparator<LoanActivity> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the loan activities from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of loan activities.
	*
	* @return the number of loan activities
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LoanActivityPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LoanActivityPersistence, LoanActivityPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LoanActivityPersistence.class);

		ServiceTracker<LoanActivityPersistence, LoanActivityPersistence> serviceTracker =
			new ServiceTracker<LoanActivityPersistence, LoanActivityPersistence>(bundle.getBundleContext(),
				LoanActivityPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
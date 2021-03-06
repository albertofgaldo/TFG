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

import cat.diba.materialesportiu.exception.NoSuchLoanActivityException;
import cat.diba.materialesportiu.model.LoanActivity;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the loan activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see cat.diba.materialesportiu.service.persistence.impl.LoanActivityPersistenceImpl
 * @see LoanActivityUtil
 * @generated
 */
@ProviderType
public interface LoanActivityPersistence extends BasePersistence<LoanActivity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LoanActivityUtil} to access the loan activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the loan activities where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching loan activities
	*/
	public java.util.List<LoanActivity> findByCompanyGroup(long companyId,
		long groupId);

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
	public java.util.List<LoanActivity> findByCompanyGroup(long companyId,
		long groupId, int start, int end);

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
	public java.util.List<LoanActivity> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator);

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
	public java.util.List<LoanActivity> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first loan activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan activity
	* @throws NoSuchLoanActivityException if a matching loan activity could not be found
	*/
	public LoanActivity findByCompanyGroup_First(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException;

	/**
	* Returns the first loan activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan activity, or <code>null</code> if a matching loan activity could not be found
	*/
	public LoanActivity fetchByCompanyGroup_First(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator);

	/**
	* Returns the last loan activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan activity
	* @throws NoSuchLoanActivityException if a matching loan activity could not be found
	*/
	public LoanActivity findByCompanyGroup_Last(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException;

	/**
	* Returns the last loan activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan activity, or <code>null</code> if a matching loan activity could not be found
	*/
	public LoanActivity fetchByCompanyGroup_Last(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator);

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
	public LoanActivity[] findByCompanyGroup_PrevAndNext(long loanActivityId,
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException;

	/**
	* Removes all the loan activities where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public void removeByCompanyGroup(long companyId, long groupId);

	/**
	* Returns the number of loan activities where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching loan activities
	*/
	public int countByCompanyGroup(long companyId, long groupId);

	/**
	* Returns all the loan activities where loanId = &#63;.
	*
	* @param loanId the loan ID
	* @return the matching loan activities
	*/
	public java.util.List<LoanActivity> findByLoanId(long loanId);

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
	public java.util.List<LoanActivity> findByLoanId(long loanId, int start,
		int end);

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
	public java.util.List<LoanActivity> findByLoanId(long loanId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator);

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
	public java.util.List<LoanActivity> findByLoanId(long loanId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first loan activity in the ordered set where loanId = &#63;.
	*
	* @param loanId the loan ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan activity
	* @throws NoSuchLoanActivityException if a matching loan activity could not be found
	*/
	public LoanActivity findByLoanId_First(long loanId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException;

	/**
	* Returns the first loan activity in the ordered set where loanId = &#63;.
	*
	* @param loanId the loan ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan activity, or <code>null</code> if a matching loan activity could not be found
	*/
	public LoanActivity fetchByLoanId_First(long loanId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator);

	/**
	* Returns the last loan activity in the ordered set where loanId = &#63;.
	*
	* @param loanId the loan ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan activity
	* @throws NoSuchLoanActivityException if a matching loan activity could not be found
	*/
	public LoanActivity findByLoanId_Last(long loanId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException;

	/**
	* Returns the last loan activity in the ordered set where loanId = &#63;.
	*
	* @param loanId the loan ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan activity, or <code>null</code> if a matching loan activity could not be found
	*/
	public LoanActivity fetchByLoanId_Last(long loanId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator);

	/**
	* Returns the loan activities before and after the current loan activity in the ordered set where loanId = &#63;.
	*
	* @param loanActivityId the primary key of the current loan activity
	* @param loanId the loan ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan activity
	* @throws NoSuchLoanActivityException if a loan activity with the primary key could not be found
	*/
	public LoanActivity[] findByLoanId_PrevAndNext(long loanActivityId,
		long loanId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException;

	/**
	* Removes all the loan activities where loanId = &#63; from the database.
	*
	* @param loanId the loan ID
	*/
	public void removeByLoanId(long loanId);

	/**
	* Returns the number of loan activities where loanId = &#63;.
	*
	* @param loanId the loan ID
	* @return the number of matching loan activities
	*/
	public int countByLoanId(long loanId);

	/**
	* Returns all the loan activities where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the matching loan activities
	*/
	public java.util.List<LoanActivity> findByActivityId(long activityId);

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
	public java.util.List<LoanActivity> findByActivityId(long activityId,
		int start, int end);

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
	public java.util.List<LoanActivity> findByActivityId(long activityId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator);

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
	public java.util.List<LoanActivity> findByActivityId(long activityId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first loan activity in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan activity
	* @throws NoSuchLoanActivityException if a matching loan activity could not be found
	*/
	public LoanActivity findByActivityId_First(long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException;

	/**
	* Returns the first loan activity in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan activity, or <code>null</code> if a matching loan activity could not be found
	*/
	public LoanActivity fetchByActivityId_First(long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator);

	/**
	* Returns the last loan activity in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan activity
	* @throws NoSuchLoanActivityException if a matching loan activity could not be found
	*/
	public LoanActivity findByActivityId_Last(long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException;

	/**
	* Returns the last loan activity in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan activity, or <code>null</code> if a matching loan activity could not be found
	*/
	public LoanActivity fetchByActivityId_Last(long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator);

	/**
	* Returns the loan activities before and after the current loan activity in the ordered set where activityId = &#63;.
	*
	* @param loanActivityId the primary key of the current loan activity
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan activity
	* @throws NoSuchLoanActivityException if a loan activity with the primary key could not be found
	*/
	public LoanActivity[] findByActivityId_PrevAndNext(long loanActivityId,
		long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException;

	/**
	* Removes all the loan activities where activityId = &#63; from the database.
	*
	* @param activityId the activity ID
	*/
	public void removeByActivityId(long activityId);

	/**
	* Returns the number of loan activities where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the number of matching loan activities
	*/
	public int countByActivityId(long activityId);

	/**
	* Returns the loan activity where loanId = &#63; and activityId = &#63; or throws a {@link NoSuchLoanActivityException} if it could not be found.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @return the matching loan activity
	* @throws NoSuchLoanActivityException if a matching loan activity could not be found
	*/
	public LoanActivity findByLoanIdActivityId(long loanId, long activityId)
		throws NoSuchLoanActivityException;

	/**
	* Returns the loan activity where loanId = &#63; and activityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @return the matching loan activity, or <code>null</code> if a matching loan activity could not be found
	*/
	public LoanActivity fetchByLoanIdActivityId(long loanId, long activityId);

	/**
	* Returns the loan activity where loanId = &#63; and activityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching loan activity, or <code>null</code> if a matching loan activity could not be found
	*/
	public LoanActivity fetchByLoanIdActivityId(long loanId, long activityId,
		boolean retrieveFromCache);

	/**
	* Removes the loan activity where loanId = &#63; and activityId = &#63; from the database.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @return the loan activity that was removed
	*/
	public LoanActivity removeByLoanIdActivityId(long loanId, long activityId)
		throws NoSuchLoanActivityException;

	/**
	* Returns the number of loan activities where loanId = &#63; and activityId = &#63;.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @return the number of matching loan activities
	*/
	public int countByLoanIdActivityId(long loanId, long activityId);

	/**
	* Caches the loan activity in the entity cache if it is enabled.
	*
	* @param loanActivity the loan activity
	*/
	public void cacheResult(LoanActivity loanActivity);

	/**
	* Caches the loan activities in the entity cache if it is enabled.
	*
	* @param loanActivities the loan activities
	*/
	public void cacheResult(java.util.List<LoanActivity> loanActivities);

	/**
	* Creates a new loan activity with the primary key. Does not add the loan activity to the database.
	*
	* @param loanActivityId the primary key for the new loan activity
	* @return the new loan activity
	*/
	public LoanActivity create(long loanActivityId);

	/**
	* Removes the loan activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loanActivityId the primary key of the loan activity
	* @return the loan activity that was removed
	* @throws NoSuchLoanActivityException if a loan activity with the primary key could not be found
	*/
	public LoanActivity remove(long loanActivityId)
		throws NoSuchLoanActivityException;

	public LoanActivity updateImpl(LoanActivity loanActivity);

	/**
	* Returns the loan activity with the primary key or throws a {@link NoSuchLoanActivityException} if it could not be found.
	*
	* @param loanActivityId the primary key of the loan activity
	* @return the loan activity
	* @throws NoSuchLoanActivityException if a loan activity with the primary key could not be found
	*/
	public LoanActivity findByPrimaryKey(long loanActivityId)
		throws NoSuchLoanActivityException;

	/**
	* Returns the loan activity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param loanActivityId the primary key of the loan activity
	* @return the loan activity, or <code>null</code> if a loan activity with the primary key could not be found
	*/
	public LoanActivity fetchByPrimaryKey(long loanActivityId);

	@Override
	public java.util.Map<java.io.Serializable, LoanActivity> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the loan activities.
	*
	* @return the loan activities
	*/
	public java.util.List<LoanActivity> findAll();

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
	public java.util.List<LoanActivity> findAll(int start, int end);

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
	public java.util.List<LoanActivity> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator);

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
	public java.util.List<LoanActivity> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoanActivity> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the loan activities from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of loan activities.
	*
	* @return the number of loan activities
	*/
	public int countAll();
}
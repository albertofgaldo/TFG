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

import cat.diba.materialesportiu.model.Loan;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the loan service. This utility wraps {@link cat.diba.materialesportiu.service.persistence.impl.LoanPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoanPersistence
 * @see cat.diba.materialesportiu.service.persistence.impl.LoanPersistenceImpl
 * @generated
 */
@ProviderType
public class LoanUtil {
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
	public static void clearCache(Loan loan) {
		getPersistence().clearCache(loan);
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
	public static List<Loan> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Loan> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Loan> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Loan> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Loan update(Loan loan) {
		return getPersistence().update(loan);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Loan update(Loan loan, ServiceContext serviceContext) {
		return getPersistence().update(loan, serviceContext);
	}

	/**
	* Returns all the loans where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching loans
	*/
	public static List<Loan> findByCompanyGroup(long companyId, long groupId) {
		return getPersistence().findByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the loans where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @return the range of matching loans
	*/
	public static List<Loan> findByCompanyGroup(long companyId, long groupId,
		int start, int end) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the loans where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loans
	*/
	public static List<Loan> findByCompanyGroup(long companyId, long groupId,
		int start, int end, OrderByComparator<Loan> orderByComparator) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the loans where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching loans
	*/
	public static List<Loan> findByCompanyGroup(long companyId, long groupId,
		int start, int end, OrderByComparator<Loan> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first loan in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws NoSuchLoanException if a matching loan could not be found
	*/
	public static Loan findByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator<Loan> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanException {
		return getPersistence()
				   .findByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first loan in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	*/
	public static Loan fetchByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator<Loan> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last loan in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws NoSuchLoanException if a matching loan could not be found
	*/
	public static Loan findByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator<Loan> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanException {
		return getPersistence()
				   .findByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last loan in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	*/
	public static Loan fetchByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator<Loan> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the loans before and after the current loan in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param loanId the primary key of the current loan
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan
	* @throws NoSuchLoanException if a loan with the primary key could not be found
	*/
	public static Loan[] findByCompanyGroup_PrevAndNext(long loanId,
		long companyId, long groupId, OrderByComparator<Loan> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanException {
		return getPersistence()
				   .findByCompanyGroup_PrevAndNext(loanId, companyId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the loans where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public static void removeByCompanyGroup(long companyId, long groupId) {
		getPersistence().removeByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns the number of loans where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching loans
	*/
	public static int countByCompanyGroup(long companyId, long groupId) {
		return getPersistence().countByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns all the loans where status = &#63; and pickupDate &lt; &#63;.
	*
	* @param status the status
	* @param pickupDate the pickup date
	* @return the matching loans
	*/
	public static List<Loan> findByStatusPastPickupDate(String status,
		Date pickupDate) {
		return getPersistence().findByStatusPastPickupDate(status, pickupDate);
	}

	/**
	* Returns a range of all the loans where status = &#63; and pickupDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param pickupDate the pickup date
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @return the range of matching loans
	*/
	public static List<Loan> findByStatusPastPickupDate(String status,
		Date pickupDate, int start, int end) {
		return getPersistence()
				   .findByStatusPastPickupDate(status, pickupDate, start, end);
	}

	/**
	* Returns an ordered range of all the loans where status = &#63; and pickupDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param pickupDate the pickup date
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loans
	*/
	public static List<Loan> findByStatusPastPickupDate(String status,
		Date pickupDate, int start, int end,
		OrderByComparator<Loan> orderByComparator) {
		return getPersistence()
				   .findByStatusPastPickupDate(status, pickupDate, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the loans where status = &#63; and pickupDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param pickupDate the pickup date
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching loans
	*/
	public static List<Loan> findByStatusPastPickupDate(String status,
		Date pickupDate, int start, int end,
		OrderByComparator<Loan> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByStatusPastPickupDate(status, pickupDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first loan in the ordered set where status = &#63; and pickupDate &lt; &#63;.
	*
	* @param status the status
	* @param pickupDate the pickup date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws NoSuchLoanException if a matching loan could not be found
	*/
	public static Loan findByStatusPastPickupDate_First(String status,
		Date pickupDate, OrderByComparator<Loan> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanException {
		return getPersistence()
				   .findByStatusPastPickupDate_First(status, pickupDate,
			orderByComparator);
	}

	/**
	* Returns the first loan in the ordered set where status = &#63; and pickupDate &lt; &#63;.
	*
	* @param status the status
	* @param pickupDate the pickup date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	*/
	public static Loan fetchByStatusPastPickupDate_First(String status,
		Date pickupDate, OrderByComparator<Loan> orderByComparator) {
		return getPersistence()
				   .fetchByStatusPastPickupDate_First(status, pickupDate,
			orderByComparator);
	}

	/**
	* Returns the last loan in the ordered set where status = &#63; and pickupDate &lt; &#63;.
	*
	* @param status the status
	* @param pickupDate the pickup date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws NoSuchLoanException if a matching loan could not be found
	*/
	public static Loan findByStatusPastPickupDate_Last(String status,
		Date pickupDate, OrderByComparator<Loan> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanException {
		return getPersistence()
				   .findByStatusPastPickupDate_Last(status, pickupDate,
			orderByComparator);
	}

	/**
	* Returns the last loan in the ordered set where status = &#63; and pickupDate &lt; &#63;.
	*
	* @param status the status
	* @param pickupDate the pickup date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	*/
	public static Loan fetchByStatusPastPickupDate_Last(String status,
		Date pickupDate, OrderByComparator<Loan> orderByComparator) {
		return getPersistence()
				   .fetchByStatusPastPickupDate_Last(status, pickupDate,
			orderByComparator);
	}

	/**
	* Returns the loans before and after the current loan in the ordered set where status = &#63; and pickupDate &lt; &#63;.
	*
	* @param loanId the primary key of the current loan
	* @param status the status
	* @param pickupDate the pickup date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan
	* @throws NoSuchLoanException if a loan with the primary key could not be found
	*/
	public static Loan[] findByStatusPastPickupDate_PrevAndNext(long loanId,
		String status, Date pickupDate,
		OrderByComparator<Loan> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanException {
		return getPersistence()
				   .findByStatusPastPickupDate_PrevAndNext(loanId, status,
			pickupDate, orderByComparator);
	}

	/**
	* Removes all the loans where status = &#63; and pickupDate &lt; &#63; from the database.
	*
	* @param status the status
	* @param pickupDate the pickup date
	*/
	public static void removeByStatusPastPickupDate(String status,
		Date pickupDate) {
		getPersistence().removeByStatusPastPickupDate(status, pickupDate);
	}

	/**
	* Returns the number of loans where status = &#63; and pickupDate &lt; &#63;.
	*
	* @param status the status
	* @param pickupDate the pickup date
	* @return the number of matching loans
	*/
	public static int countByStatusPastPickupDate(String status, Date pickupDate) {
		return getPersistence().countByStatusPastPickupDate(status, pickupDate);
	}

	/**
	* Returns all the loans where status = &#63; and returnDate &lt; &#63;.
	*
	* @param status the status
	* @param returnDate the return date
	* @return the matching loans
	*/
	public static List<Loan> findByStatusPastReturnDate(String status,
		Date returnDate) {
		return getPersistence().findByStatusPastReturnDate(status, returnDate);
	}

	/**
	* Returns a range of all the loans where status = &#63; and returnDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param returnDate the return date
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @return the range of matching loans
	*/
	public static List<Loan> findByStatusPastReturnDate(String status,
		Date returnDate, int start, int end) {
		return getPersistence()
				   .findByStatusPastReturnDate(status, returnDate, start, end);
	}

	/**
	* Returns an ordered range of all the loans where status = &#63; and returnDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param returnDate the return date
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loans
	*/
	public static List<Loan> findByStatusPastReturnDate(String status,
		Date returnDate, int start, int end,
		OrderByComparator<Loan> orderByComparator) {
		return getPersistence()
				   .findByStatusPastReturnDate(status, returnDate, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the loans where status = &#63; and returnDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param returnDate the return date
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching loans
	*/
	public static List<Loan> findByStatusPastReturnDate(String status,
		Date returnDate, int start, int end,
		OrderByComparator<Loan> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByStatusPastReturnDate(status, returnDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first loan in the ordered set where status = &#63; and returnDate &lt; &#63;.
	*
	* @param status the status
	* @param returnDate the return date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws NoSuchLoanException if a matching loan could not be found
	*/
	public static Loan findByStatusPastReturnDate_First(String status,
		Date returnDate, OrderByComparator<Loan> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanException {
		return getPersistence()
				   .findByStatusPastReturnDate_First(status, returnDate,
			orderByComparator);
	}

	/**
	* Returns the first loan in the ordered set where status = &#63; and returnDate &lt; &#63;.
	*
	* @param status the status
	* @param returnDate the return date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	*/
	public static Loan fetchByStatusPastReturnDate_First(String status,
		Date returnDate, OrderByComparator<Loan> orderByComparator) {
		return getPersistence()
				   .fetchByStatusPastReturnDate_First(status, returnDate,
			orderByComparator);
	}

	/**
	* Returns the last loan in the ordered set where status = &#63; and returnDate &lt; &#63;.
	*
	* @param status the status
	* @param returnDate the return date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws NoSuchLoanException if a matching loan could not be found
	*/
	public static Loan findByStatusPastReturnDate_Last(String status,
		Date returnDate, OrderByComparator<Loan> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanException {
		return getPersistence()
				   .findByStatusPastReturnDate_Last(status, returnDate,
			orderByComparator);
	}

	/**
	* Returns the last loan in the ordered set where status = &#63; and returnDate &lt; &#63;.
	*
	* @param status the status
	* @param returnDate the return date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	*/
	public static Loan fetchByStatusPastReturnDate_Last(String status,
		Date returnDate, OrderByComparator<Loan> orderByComparator) {
		return getPersistence()
				   .fetchByStatusPastReturnDate_Last(status, returnDate,
			orderByComparator);
	}

	/**
	* Returns the loans before and after the current loan in the ordered set where status = &#63; and returnDate &lt; &#63;.
	*
	* @param loanId the primary key of the current loan
	* @param status the status
	* @param returnDate the return date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan
	* @throws NoSuchLoanException if a loan with the primary key could not be found
	*/
	public static Loan[] findByStatusPastReturnDate_PrevAndNext(long loanId,
		String status, Date returnDate,
		OrderByComparator<Loan> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanException {
		return getPersistence()
				   .findByStatusPastReturnDate_PrevAndNext(loanId, status,
			returnDate, orderByComparator);
	}

	/**
	* Removes all the loans where status = &#63; and returnDate &lt; &#63; from the database.
	*
	* @param status the status
	* @param returnDate the return date
	*/
	public static void removeByStatusPastReturnDate(String status,
		Date returnDate) {
		getPersistence().removeByStatusPastReturnDate(status, returnDate);
	}

	/**
	* Returns the number of loans where status = &#63; and returnDate &lt; &#63;.
	*
	* @param status the status
	* @param returnDate the return date
	* @return the number of matching loans
	*/
	public static int countByStatusPastReturnDate(String status, Date returnDate) {
		return getPersistence().countByStatusPastReturnDate(status, returnDate);
	}

	/**
	* Returns all the loans where status = &#63;.
	*
	* @param status the status
	* @return the matching loans
	*/
	public static List<Loan> findByStatus(String status) {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the loans where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @return the range of matching loans
	*/
	public static List<Loan> findByStatus(String status, int start, int end) {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the loans where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loans
	*/
	public static List<Loan> findByStatus(String status, int start, int end,
		OrderByComparator<Loan> orderByComparator) {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the loans where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching loans
	*/
	public static List<Loan> findByStatus(String status, int start, int end,
		OrderByComparator<Loan> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first loan in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws NoSuchLoanException if a matching loan could not be found
	*/
	public static Loan findByStatus_First(String status,
		OrderByComparator<Loan> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first loan in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	*/
	public static Loan fetchByStatus_First(String status,
		OrderByComparator<Loan> orderByComparator) {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last loan in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws NoSuchLoanException if a matching loan could not be found
	*/
	public static Loan findByStatus_Last(String status,
		OrderByComparator<Loan> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last loan in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	*/
	public static Loan fetchByStatus_Last(String status,
		OrderByComparator<Loan> orderByComparator) {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the loans before and after the current loan in the ordered set where status = &#63;.
	*
	* @param loanId the primary key of the current loan
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan
	* @throws NoSuchLoanException if a loan with the primary key could not be found
	*/
	public static Loan[] findByStatus_PrevAndNext(long loanId, String status,
		OrderByComparator<Loan> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLoanException {
		return getPersistence()
				   .findByStatus_PrevAndNext(loanId, status, orderByComparator);
	}

	/**
	* Removes all the loans where status = &#63; from the database.
	*
	* @param status the status
	*/
	public static void removeByStatus(String status) {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of loans where status = &#63;.
	*
	* @param status the status
	* @return the number of matching loans
	*/
	public static int countByStatus(String status) {
		return getPersistence().countByStatus(status);
	}

	/**
	* Caches the loan in the entity cache if it is enabled.
	*
	* @param loan the loan
	*/
	public static void cacheResult(Loan loan) {
		getPersistence().cacheResult(loan);
	}

	/**
	* Caches the loans in the entity cache if it is enabled.
	*
	* @param loans the loans
	*/
	public static void cacheResult(List<Loan> loans) {
		getPersistence().cacheResult(loans);
	}

	/**
	* Creates a new loan with the primary key. Does not add the loan to the database.
	*
	* @param loanId the primary key for the new loan
	* @return the new loan
	*/
	public static Loan create(long loanId) {
		return getPersistence().create(loanId);
	}

	/**
	* Removes the loan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loanId the primary key of the loan
	* @return the loan that was removed
	* @throws NoSuchLoanException if a loan with the primary key could not be found
	*/
	public static Loan remove(long loanId)
		throws cat.diba.materialesportiu.exception.NoSuchLoanException {
		return getPersistence().remove(loanId);
	}

	public static Loan updateImpl(Loan loan) {
		return getPersistence().updateImpl(loan);
	}

	/**
	* Returns the loan with the primary key or throws a {@link NoSuchLoanException} if it could not be found.
	*
	* @param loanId the primary key of the loan
	* @return the loan
	* @throws NoSuchLoanException if a loan with the primary key could not be found
	*/
	public static Loan findByPrimaryKey(long loanId)
		throws cat.diba.materialesportiu.exception.NoSuchLoanException {
		return getPersistence().findByPrimaryKey(loanId);
	}

	/**
	* Returns the loan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param loanId the primary key of the loan
	* @return the loan, or <code>null</code> if a loan with the primary key could not be found
	*/
	public static Loan fetchByPrimaryKey(long loanId) {
		return getPersistence().fetchByPrimaryKey(loanId);
	}

	public static java.util.Map<java.io.Serializable, Loan> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the loans.
	*
	* @return the loans
	*/
	public static List<Loan> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the loans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @return the range of loans
	*/
	public static List<Loan> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the loans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of loans
	*/
	public static List<Loan> findAll(int start, int end,
		OrderByComparator<Loan> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the loans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of loans
	*/
	public static List<Loan> findAll(int start, int end,
		OrderByComparator<Loan> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the loans from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of loans.
	*
	* @return the number of loans
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LoanPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LoanPersistence, LoanPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LoanPersistence.class);

		ServiceTracker<LoanPersistence, LoanPersistence> serviceTracker = new ServiceTracker<LoanPersistence, LoanPersistence>(bundle.getBundleContext(),
				LoanPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
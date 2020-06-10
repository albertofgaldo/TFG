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

import cat.diba.materialesportiu.exception.NoSuchLoanException;
import cat.diba.materialesportiu.model.Loan;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the loan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see cat.diba.materialesportiu.service.persistence.impl.LoanPersistenceImpl
 * @see LoanUtil
 * @generated
 */
@ProviderType
public interface LoanPersistence extends BasePersistence<Loan> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LoanUtil} to access the loan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the loans where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching loans
	*/
	public java.util.List<Loan> findByCompanyGroup(long companyId, long groupId);

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
	public java.util.List<Loan> findByCompanyGroup(long companyId,
		long groupId, int start, int end);

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
	public java.util.List<Loan> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator);

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
	public java.util.List<Loan> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first loan in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws NoSuchLoanException if a matching loan could not be found
	*/
	public Loan findByCompanyGroup_First(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator)
		throws NoSuchLoanException;

	/**
	* Returns the first loan in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	*/
	public Loan fetchByCompanyGroup_First(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator);

	/**
	* Returns the last loan in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws NoSuchLoanException if a matching loan could not be found
	*/
	public Loan findByCompanyGroup_Last(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator)
		throws NoSuchLoanException;

	/**
	* Returns the last loan in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	*/
	public Loan fetchByCompanyGroup_Last(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator);

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
	public Loan[] findByCompanyGroup_PrevAndNext(long loanId, long companyId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator)
		throws NoSuchLoanException;

	/**
	* Removes all the loans where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public void removeByCompanyGroup(long companyId, long groupId);

	/**
	* Returns the number of loans where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching loans
	*/
	public int countByCompanyGroup(long companyId, long groupId);

	/**
	* Returns all the loans where status = &#63; and pickupDate &lt; &#63;.
	*
	* @param status the status
	* @param pickupDate the pickup date
	* @return the matching loans
	*/
	public java.util.List<Loan> findByStatusPastPickupDate(String status,
		Date pickupDate);

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
	public java.util.List<Loan> findByStatusPastPickupDate(String status,
		Date pickupDate, int start, int end);

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
	public java.util.List<Loan> findByStatusPastPickupDate(String status,
		Date pickupDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator);

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
	public java.util.List<Loan> findByStatusPastPickupDate(String status,
		Date pickupDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first loan in the ordered set where status = &#63; and pickupDate &lt; &#63;.
	*
	* @param status the status
	* @param pickupDate the pickup date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws NoSuchLoanException if a matching loan could not be found
	*/
	public Loan findByStatusPastPickupDate_First(String status,
		Date pickupDate,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator)
		throws NoSuchLoanException;

	/**
	* Returns the first loan in the ordered set where status = &#63; and pickupDate &lt; &#63;.
	*
	* @param status the status
	* @param pickupDate the pickup date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	*/
	public Loan fetchByStatusPastPickupDate_First(String status,
		Date pickupDate,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator);

	/**
	* Returns the last loan in the ordered set where status = &#63; and pickupDate &lt; &#63;.
	*
	* @param status the status
	* @param pickupDate the pickup date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws NoSuchLoanException if a matching loan could not be found
	*/
	public Loan findByStatusPastPickupDate_Last(String status, Date pickupDate,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator)
		throws NoSuchLoanException;

	/**
	* Returns the last loan in the ordered set where status = &#63; and pickupDate &lt; &#63;.
	*
	* @param status the status
	* @param pickupDate the pickup date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	*/
	public Loan fetchByStatusPastPickupDate_Last(String status,
		Date pickupDate,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator);

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
	public Loan[] findByStatusPastPickupDate_PrevAndNext(long loanId,
		String status, Date pickupDate,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator)
		throws NoSuchLoanException;

	/**
	* Removes all the loans where status = &#63; and pickupDate &lt; &#63; from the database.
	*
	* @param status the status
	* @param pickupDate the pickup date
	*/
	public void removeByStatusPastPickupDate(String status, Date pickupDate);

	/**
	* Returns the number of loans where status = &#63; and pickupDate &lt; &#63;.
	*
	* @param status the status
	* @param pickupDate the pickup date
	* @return the number of matching loans
	*/
	public int countByStatusPastPickupDate(String status, Date pickupDate);

	/**
	* Returns all the loans where status = &#63; and returnDate &lt; &#63;.
	*
	* @param status the status
	* @param returnDate the return date
	* @return the matching loans
	*/
	public java.util.List<Loan> findByStatusPastReturnDate(String status,
		Date returnDate);

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
	public java.util.List<Loan> findByStatusPastReturnDate(String status,
		Date returnDate, int start, int end);

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
	public java.util.List<Loan> findByStatusPastReturnDate(String status,
		Date returnDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator);

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
	public java.util.List<Loan> findByStatusPastReturnDate(String status,
		Date returnDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first loan in the ordered set where status = &#63; and returnDate &lt; &#63;.
	*
	* @param status the status
	* @param returnDate the return date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws NoSuchLoanException if a matching loan could not be found
	*/
	public Loan findByStatusPastReturnDate_First(String status,
		Date returnDate,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator)
		throws NoSuchLoanException;

	/**
	* Returns the first loan in the ordered set where status = &#63; and returnDate &lt; &#63;.
	*
	* @param status the status
	* @param returnDate the return date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	*/
	public Loan fetchByStatusPastReturnDate_First(String status,
		Date returnDate,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator);

	/**
	* Returns the last loan in the ordered set where status = &#63; and returnDate &lt; &#63;.
	*
	* @param status the status
	* @param returnDate the return date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws NoSuchLoanException if a matching loan could not be found
	*/
	public Loan findByStatusPastReturnDate_Last(String status, Date returnDate,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator)
		throws NoSuchLoanException;

	/**
	* Returns the last loan in the ordered set where status = &#63; and returnDate &lt; &#63;.
	*
	* @param status the status
	* @param returnDate the return date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	*/
	public Loan fetchByStatusPastReturnDate_Last(String status,
		Date returnDate,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator);

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
	public Loan[] findByStatusPastReturnDate_PrevAndNext(long loanId,
		String status, Date returnDate,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator)
		throws NoSuchLoanException;

	/**
	* Removes all the loans where status = &#63; and returnDate &lt; &#63; from the database.
	*
	* @param status the status
	* @param returnDate the return date
	*/
	public void removeByStatusPastReturnDate(String status, Date returnDate);

	/**
	* Returns the number of loans where status = &#63; and returnDate &lt; &#63;.
	*
	* @param status the status
	* @param returnDate the return date
	* @return the number of matching loans
	*/
	public int countByStatusPastReturnDate(String status, Date returnDate);

	/**
	* Returns all the loans where status = &#63;.
	*
	* @param status the status
	* @return the matching loans
	*/
	public java.util.List<Loan> findByStatus(String status);

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
	public java.util.List<Loan> findByStatus(String status, int start, int end);

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
	public java.util.List<Loan> findByStatus(String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator);

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
	public java.util.List<Loan> findByStatus(String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first loan in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws NoSuchLoanException if a matching loan could not be found
	*/
	public Loan findByStatus_First(String status,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator)
		throws NoSuchLoanException;

	/**
	* Returns the first loan in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	*/
	public Loan fetchByStatus_First(String status,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator);

	/**
	* Returns the last loan in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws NoSuchLoanException if a matching loan could not be found
	*/
	public Loan findByStatus_Last(String status,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator)
		throws NoSuchLoanException;

	/**
	* Returns the last loan in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	*/
	public Loan fetchByStatus_Last(String status,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator);

	/**
	* Returns the loans before and after the current loan in the ordered set where status = &#63;.
	*
	* @param loanId the primary key of the current loan
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan
	* @throws NoSuchLoanException if a loan with the primary key could not be found
	*/
	public Loan[] findByStatus_PrevAndNext(long loanId, String status,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator)
		throws NoSuchLoanException;

	/**
	* Removes all the loans where status = &#63; from the database.
	*
	* @param status the status
	*/
	public void removeByStatus(String status);

	/**
	* Returns the number of loans where status = &#63;.
	*
	* @param status the status
	* @return the number of matching loans
	*/
	public int countByStatus(String status);

	/**
	* Caches the loan in the entity cache if it is enabled.
	*
	* @param loan the loan
	*/
	public void cacheResult(Loan loan);

	/**
	* Caches the loans in the entity cache if it is enabled.
	*
	* @param loans the loans
	*/
	public void cacheResult(java.util.List<Loan> loans);

	/**
	* Creates a new loan with the primary key. Does not add the loan to the database.
	*
	* @param loanId the primary key for the new loan
	* @return the new loan
	*/
	public Loan create(long loanId);

	/**
	* Removes the loan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loanId the primary key of the loan
	* @return the loan that was removed
	* @throws NoSuchLoanException if a loan with the primary key could not be found
	*/
	public Loan remove(long loanId) throws NoSuchLoanException;

	public Loan updateImpl(Loan loan);

	/**
	* Returns the loan with the primary key or throws a {@link NoSuchLoanException} if it could not be found.
	*
	* @param loanId the primary key of the loan
	* @return the loan
	* @throws NoSuchLoanException if a loan with the primary key could not be found
	*/
	public Loan findByPrimaryKey(long loanId) throws NoSuchLoanException;

	/**
	* Returns the loan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param loanId the primary key of the loan
	* @return the loan, or <code>null</code> if a loan with the primary key could not be found
	*/
	public Loan fetchByPrimaryKey(long loanId);

	@Override
	public java.util.Map<java.io.Serializable, Loan> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the loans.
	*
	* @return the loans
	*/
	public java.util.List<Loan> findAll();

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
	public java.util.List<Loan> findAll(int start, int end);

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
	public java.util.List<Loan> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator);

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
	public java.util.List<Loan> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loan> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the loans from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of loans.
	*
	* @return the number of loans
	*/
	public int countAll();
}
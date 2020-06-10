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

import cat.diba.materialesportiu.exception.NoSuchMaintenanceException;
import cat.diba.materialesportiu.model.Maintenance;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the maintenance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see cat.diba.materialesportiu.service.persistence.impl.MaintenancePersistenceImpl
 * @see MaintenanceUtil
 * @generated
 */
@ProviderType
public interface MaintenancePersistence extends BasePersistence<Maintenance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MaintenanceUtil} to access the maintenance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the maintenances where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the matching maintenances
	*/
	public java.util.List<Maintenance> findByActivityId(long activityId);

	/**
	* Returns a range of all the maintenances where activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activityId the activity ID
	* @param start the lower bound of the range of maintenances
	* @param end the upper bound of the range of maintenances (not inclusive)
	* @return the range of matching maintenances
	*/
	public java.util.List<Maintenance> findByActivityId(long activityId,
		int start, int end);

	/**
	* Returns an ordered range of all the maintenances where activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activityId the activity ID
	* @param start the lower bound of the range of maintenances
	* @param end the upper bound of the range of maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching maintenances
	*/
	public java.util.List<Maintenance> findByActivityId(long activityId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator);

	/**
	* Returns an ordered range of all the maintenances where activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activityId the activity ID
	* @param start the lower bound of the range of maintenances
	* @param end the upper bound of the range of maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching maintenances
	*/
	public java.util.List<Maintenance> findByActivityId(long activityId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first maintenance in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching maintenance
	* @throws NoSuchMaintenanceException if a matching maintenance could not be found
	*/
	public Maintenance findByActivityId_First(long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException;

	/**
	* Returns the first maintenance in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public Maintenance fetchByActivityId_First(long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator);

	/**
	* Returns the last maintenance in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching maintenance
	* @throws NoSuchMaintenanceException if a matching maintenance could not be found
	*/
	public Maintenance findByActivityId_Last(long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException;

	/**
	* Returns the last maintenance in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public Maintenance fetchByActivityId_Last(long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator);

	/**
	* Returns the maintenances before and after the current maintenance in the ordered set where activityId = &#63;.
	*
	* @param maintenanceId the primary key of the current maintenance
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next maintenance
	* @throws NoSuchMaintenanceException if a maintenance with the primary key could not be found
	*/
	public Maintenance[] findByActivityId_PrevAndNext(long maintenanceId,
		long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException;

	/**
	* Removes all the maintenances where activityId = &#63; from the database.
	*
	* @param activityId the activity ID
	*/
	public void removeByActivityId(long activityId);

	/**
	* Returns the number of maintenances where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the number of matching maintenances
	*/
	public int countByActivityId(long activityId);

	/**
	* Returns the maintenance where activityId = &#63; and label = &#63; or throws a {@link NoSuchMaintenanceException} if it could not be found.
	*
	* @param activityId the activity ID
	* @param label the label
	* @return the matching maintenance
	* @throws NoSuchMaintenanceException if a matching maintenance could not be found
	*/
	public Maintenance findByActivityId_Label(long activityId, String label)
		throws NoSuchMaintenanceException;

	/**
	* Returns the maintenance where activityId = &#63; and label = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param activityId the activity ID
	* @param label the label
	* @return the matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public Maintenance fetchByActivityId_Label(long activityId, String label);

	/**
	* Returns the maintenance where activityId = &#63; and label = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param activityId the activity ID
	* @param label the label
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public Maintenance fetchByActivityId_Label(long activityId, String label,
		boolean retrieveFromCache);

	/**
	* Removes the maintenance where activityId = &#63; and label = &#63; from the database.
	*
	* @param activityId the activity ID
	* @param label the label
	* @return the maintenance that was removed
	*/
	public Maintenance removeByActivityId_Label(long activityId, String label)
		throws NoSuchMaintenanceException;

	/**
	* Returns the number of maintenances where activityId = &#63; and label = &#63;.
	*
	* @param activityId the activity ID
	* @param label the label
	* @return the number of matching maintenances
	*/
	public int countByActivityId_Label(long activityId, String label);

	/**
	* Returns all the maintenances where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching maintenances
	*/
	public java.util.List<Maintenance> findByCompanyGroup(long companyId,
		long groupId);

	/**
	* Returns a range of all the maintenances where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of maintenances
	* @param end the upper bound of the range of maintenances (not inclusive)
	* @return the range of matching maintenances
	*/
	public java.util.List<Maintenance> findByCompanyGroup(long companyId,
		long groupId, int start, int end);

	/**
	* Returns an ordered range of all the maintenances where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of maintenances
	* @param end the upper bound of the range of maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching maintenances
	*/
	public java.util.List<Maintenance> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator);

	/**
	* Returns an ordered range of all the maintenances where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of maintenances
	* @param end the upper bound of the range of maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching maintenances
	*/
	public java.util.List<Maintenance> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first maintenance in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching maintenance
	* @throws NoSuchMaintenanceException if a matching maintenance could not be found
	*/
	public Maintenance findByCompanyGroup_First(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException;

	/**
	* Returns the first maintenance in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public Maintenance fetchByCompanyGroup_First(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator);

	/**
	* Returns the last maintenance in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching maintenance
	* @throws NoSuchMaintenanceException if a matching maintenance could not be found
	*/
	public Maintenance findByCompanyGroup_Last(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException;

	/**
	* Returns the last maintenance in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public Maintenance fetchByCompanyGroup_Last(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator);

	/**
	* Returns the maintenances before and after the current maintenance in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param maintenanceId the primary key of the current maintenance
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next maintenance
	* @throws NoSuchMaintenanceException if a maintenance with the primary key could not be found
	*/
	public Maintenance[] findByCompanyGroup_PrevAndNext(long maintenanceId,
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException;

	/**
	* Removes all the maintenances where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public void removeByCompanyGroup(long companyId, long groupId);

	/**
	* Returns the number of maintenances where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching maintenances
	*/
	public int countByCompanyGroup(long companyId, long groupId);

	/**
	* Returns all the maintenances where loanId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param isDone the is done
	* @return the matching maintenances
	*/
	public java.util.List<Maintenance> findByLoanIdIsDone(long loanId,
		Boolean isDone);

	/**
	* Returns a range of all the maintenances where loanId = &#63; and isDone = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param loanId the loan ID
	* @param isDone the is done
	* @param start the lower bound of the range of maintenances
	* @param end the upper bound of the range of maintenances (not inclusive)
	* @return the range of matching maintenances
	*/
	public java.util.List<Maintenance> findByLoanIdIsDone(long loanId,
		Boolean isDone, int start, int end);

	/**
	* Returns an ordered range of all the maintenances where loanId = &#63; and isDone = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param loanId the loan ID
	* @param isDone the is done
	* @param start the lower bound of the range of maintenances
	* @param end the upper bound of the range of maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching maintenances
	*/
	public java.util.List<Maintenance> findByLoanIdIsDone(long loanId,
		Boolean isDone, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator);

	/**
	* Returns an ordered range of all the maintenances where loanId = &#63; and isDone = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param loanId the loan ID
	* @param isDone the is done
	* @param start the lower bound of the range of maintenances
	* @param end the upper bound of the range of maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching maintenances
	*/
	public java.util.List<Maintenance> findByLoanIdIsDone(long loanId,
		Boolean isDone, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first maintenance in the ordered set where loanId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param isDone the is done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching maintenance
	* @throws NoSuchMaintenanceException if a matching maintenance could not be found
	*/
	public Maintenance findByLoanIdIsDone_First(long loanId, Boolean isDone,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException;

	/**
	* Returns the first maintenance in the ordered set where loanId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param isDone the is done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public Maintenance fetchByLoanIdIsDone_First(long loanId, Boolean isDone,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator);

	/**
	* Returns the last maintenance in the ordered set where loanId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param isDone the is done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching maintenance
	* @throws NoSuchMaintenanceException if a matching maintenance could not be found
	*/
	public Maintenance findByLoanIdIsDone_Last(long loanId, Boolean isDone,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException;

	/**
	* Returns the last maintenance in the ordered set where loanId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param isDone the is done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public Maintenance fetchByLoanIdIsDone_Last(long loanId, Boolean isDone,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator);

	/**
	* Returns the maintenances before and after the current maintenance in the ordered set where loanId = &#63; and isDone = &#63;.
	*
	* @param maintenanceId the primary key of the current maintenance
	* @param loanId the loan ID
	* @param isDone the is done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next maintenance
	* @throws NoSuchMaintenanceException if a maintenance with the primary key could not be found
	*/
	public Maintenance[] findByLoanIdIsDone_PrevAndNext(long maintenanceId,
		long loanId, Boolean isDone,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException;

	/**
	* Removes all the maintenances where loanId = &#63; and isDone = &#63; from the database.
	*
	* @param loanId the loan ID
	* @param isDone the is done
	*/
	public void removeByLoanIdIsDone(long loanId, Boolean isDone);

	/**
	* Returns the number of maintenances where loanId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param isDone the is done
	* @return the number of matching maintenances
	*/
	public int countByLoanIdIsDone(long loanId, Boolean isDone);

	/**
	* Returns all the maintenances where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param isDone the is done
	* @return the matching maintenances
	*/
	public java.util.List<Maintenance> findByLoanIdActivityIdIsDone(
		long loanId, long activityId, Boolean isDone);

	/**
	* Returns a range of all the maintenances where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param isDone the is done
	* @param start the lower bound of the range of maintenances
	* @param end the upper bound of the range of maintenances (not inclusive)
	* @return the range of matching maintenances
	*/
	public java.util.List<Maintenance> findByLoanIdActivityIdIsDone(
		long loanId, long activityId, Boolean isDone, int start, int end);

	/**
	* Returns an ordered range of all the maintenances where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param isDone the is done
	* @param start the lower bound of the range of maintenances
	* @param end the upper bound of the range of maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching maintenances
	*/
	public java.util.List<Maintenance> findByLoanIdActivityIdIsDone(
		long loanId, long activityId, Boolean isDone, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator);

	/**
	* Returns an ordered range of all the maintenances where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param isDone the is done
	* @param start the lower bound of the range of maintenances
	* @param end the upper bound of the range of maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching maintenances
	*/
	public java.util.List<Maintenance> findByLoanIdActivityIdIsDone(
		long loanId, long activityId, Boolean isDone, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first maintenance in the ordered set where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param isDone the is done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching maintenance
	* @throws NoSuchMaintenanceException if a matching maintenance could not be found
	*/
	public Maintenance findByLoanIdActivityIdIsDone_First(long loanId,
		long activityId, Boolean isDone,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException;

	/**
	* Returns the first maintenance in the ordered set where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param isDone the is done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public Maintenance fetchByLoanIdActivityIdIsDone_First(long loanId,
		long activityId, Boolean isDone,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator);

	/**
	* Returns the last maintenance in the ordered set where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param isDone the is done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching maintenance
	* @throws NoSuchMaintenanceException if a matching maintenance could not be found
	*/
	public Maintenance findByLoanIdActivityIdIsDone_Last(long loanId,
		long activityId, Boolean isDone,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException;

	/**
	* Returns the last maintenance in the ordered set where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param isDone the is done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public Maintenance fetchByLoanIdActivityIdIsDone_Last(long loanId,
		long activityId, Boolean isDone,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator);

	/**
	* Returns the maintenances before and after the current maintenance in the ordered set where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	*
	* @param maintenanceId the primary key of the current maintenance
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param isDone the is done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next maintenance
	* @throws NoSuchMaintenanceException if a maintenance with the primary key could not be found
	*/
	public Maintenance[] findByLoanIdActivityIdIsDone_PrevAndNext(
		long maintenanceId, long loanId, long activityId, Boolean isDone,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException;

	/**
	* Removes all the maintenances where loanId = &#63; and activityId = &#63; and isDone = &#63; from the database.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param isDone the is done
	*/
	public void removeByLoanIdActivityIdIsDone(long loanId, long activityId,
		Boolean isDone);

	/**
	* Returns the number of maintenances where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param isDone the is done
	* @return the number of matching maintenances
	*/
	public int countByLoanIdActivityIdIsDone(long loanId, long activityId,
		Boolean isDone);

	/**
	* Caches the maintenance in the entity cache if it is enabled.
	*
	* @param maintenance the maintenance
	*/
	public void cacheResult(Maintenance maintenance);

	/**
	* Caches the maintenances in the entity cache if it is enabled.
	*
	* @param maintenances the maintenances
	*/
	public void cacheResult(java.util.List<Maintenance> maintenances);

	/**
	* Creates a new maintenance with the primary key. Does not add the maintenance to the database.
	*
	* @param maintenanceId the primary key for the new maintenance
	* @return the new maintenance
	*/
	public Maintenance create(long maintenanceId);

	/**
	* Removes the maintenance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param maintenanceId the primary key of the maintenance
	* @return the maintenance that was removed
	* @throws NoSuchMaintenanceException if a maintenance with the primary key could not be found
	*/
	public Maintenance remove(long maintenanceId)
		throws NoSuchMaintenanceException;

	public Maintenance updateImpl(Maintenance maintenance);

	/**
	* Returns the maintenance with the primary key or throws a {@link NoSuchMaintenanceException} if it could not be found.
	*
	* @param maintenanceId the primary key of the maintenance
	* @return the maintenance
	* @throws NoSuchMaintenanceException if a maintenance with the primary key could not be found
	*/
	public Maintenance findByPrimaryKey(long maintenanceId)
		throws NoSuchMaintenanceException;

	/**
	* Returns the maintenance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param maintenanceId the primary key of the maintenance
	* @return the maintenance, or <code>null</code> if a maintenance with the primary key could not be found
	*/
	public Maintenance fetchByPrimaryKey(long maintenanceId);

	@Override
	public java.util.Map<java.io.Serializable, Maintenance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the maintenances.
	*
	* @return the maintenances
	*/
	public java.util.List<Maintenance> findAll();

	/**
	* Returns a range of all the maintenances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of maintenances
	* @param end the upper bound of the range of maintenances (not inclusive)
	* @return the range of maintenances
	*/
	public java.util.List<Maintenance> findAll(int start, int end);

	/**
	* Returns an ordered range of all the maintenances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of maintenances
	* @param end the upper bound of the range of maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of maintenances
	*/
	public java.util.List<Maintenance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator);

	/**
	* Returns an ordered range of all the maintenances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of maintenances
	* @param end the upper bound of the range of maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of maintenances
	*/
	public java.util.List<Maintenance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Maintenance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the maintenances from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of maintenances.
	*
	* @return the number of maintenances
	*/
	public int countAll();
}
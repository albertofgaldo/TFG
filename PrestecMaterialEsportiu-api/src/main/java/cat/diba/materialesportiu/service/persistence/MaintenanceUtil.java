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

import cat.diba.materialesportiu.model.Maintenance;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the maintenance service. This utility wraps {@link cat.diba.materialesportiu.service.persistence.impl.MaintenancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MaintenancePersistence
 * @see cat.diba.materialesportiu.service.persistence.impl.MaintenancePersistenceImpl
 * @generated
 */
@ProviderType
public class MaintenanceUtil {
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
	public static void clearCache(Maintenance maintenance) {
		getPersistence().clearCache(maintenance);
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
	public static List<Maintenance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Maintenance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Maintenance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Maintenance> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Maintenance update(Maintenance maintenance) {
		return getPersistence().update(maintenance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Maintenance update(Maintenance maintenance,
		ServiceContext serviceContext) {
		return getPersistence().update(maintenance, serviceContext);
	}

	/**
	* Returns all the maintenances where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the matching maintenances
	*/
	public static List<Maintenance> findByActivityId(long activityId) {
		return getPersistence().findByActivityId(activityId);
	}

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
	public static List<Maintenance> findByActivityId(long activityId,
		int start, int end) {
		return getPersistence().findByActivityId(activityId, start, end);
	}

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
	public static List<Maintenance> findByActivityId(long activityId,
		int start, int end, OrderByComparator<Maintenance> orderByComparator) {
		return getPersistence()
				   .findByActivityId(activityId, start, end, orderByComparator);
	}

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
	public static List<Maintenance> findByActivityId(long activityId,
		int start, int end, OrderByComparator<Maintenance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByActivityId(activityId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first maintenance in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching maintenance
	* @throws NoSuchMaintenanceException if a matching maintenance could not be found
	*/
	public static Maintenance findByActivityId_First(long activityId,
		OrderByComparator<Maintenance> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return getPersistence()
				   .findByActivityId_First(activityId, orderByComparator);
	}

	/**
	* Returns the first maintenance in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public static Maintenance fetchByActivityId_First(long activityId,
		OrderByComparator<Maintenance> orderByComparator) {
		return getPersistence()
				   .fetchByActivityId_First(activityId, orderByComparator);
	}

	/**
	* Returns the last maintenance in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching maintenance
	* @throws NoSuchMaintenanceException if a matching maintenance could not be found
	*/
	public static Maintenance findByActivityId_Last(long activityId,
		OrderByComparator<Maintenance> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return getPersistence()
				   .findByActivityId_Last(activityId, orderByComparator);
	}

	/**
	* Returns the last maintenance in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public static Maintenance fetchByActivityId_Last(long activityId,
		OrderByComparator<Maintenance> orderByComparator) {
		return getPersistence()
				   .fetchByActivityId_Last(activityId, orderByComparator);
	}

	/**
	* Returns the maintenances before and after the current maintenance in the ordered set where activityId = &#63;.
	*
	* @param maintenanceId the primary key of the current maintenance
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next maintenance
	* @throws NoSuchMaintenanceException if a maintenance with the primary key could not be found
	*/
	public static Maintenance[] findByActivityId_PrevAndNext(
		long maintenanceId, long activityId,
		OrderByComparator<Maintenance> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return getPersistence()
				   .findByActivityId_PrevAndNext(maintenanceId, activityId,
			orderByComparator);
	}

	/**
	* Removes all the maintenances where activityId = &#63; from the database.
	*
	* @param activityId the activity ID
	*/
	public static void removeByActivityId(long activityId) {
		getPersistence().removeByActivityId(activityId);
	}

	/**
	* Returns the number of maintenances where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the number of matching maintenances
	*/
	public static int countByActivityId(long activityId) {
		return getPersistence().countByActivityId(activityId);
	}

	/**
	* Returns the maintenance where activityId = &#63; and label = &#63; or throws a {@link NoSuchMaintenanceException} if it could not be found.
	*
	* @param activityId the activity ID
	* @param label the label
	* @return the matching maintenance
	* @throws NoSuchMaintenanceException if a matching maintenance could not be found
	*/
	public static Maintenance findByActivityId_Label(long activityId,
		String label)
		throws cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return getPersistence().findByActivityId_Label(activityId, label);
	}

	/**
	* Returns the maintenance where activityId = &#63; and label = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param activityId the activity ID
	* @param label the label
	* @return the matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public static Maintenance fetchByActivityId_Label(long activityId,
		String label) {
		return getPersistence().fetchByActivityId_Label(activityId, label);
	}

	/**
	* Returns the maintenance where activityId = &#63; and label = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param activityId the activity ID
	* @param label the label
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public static Maintenance fetchByActivityId_Label(long activityId,
		String label, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByActivityId_Label(activityId, label, retrieveFromCache);
	}

	/**
	* Removes the maintenance where activityId = &#63; and label = &#63; from the database.
	*
	* @param activityId the activity ID
	* @param label the label
	* @return the maintenance that was removed
	*/
	public static Maintenance removeByActivityId_Label(long activityId,
		String label)
		throws cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return getPersistence().removeByActivityId_Label(activityId, label);
	}

	/**
	* Returns the number of maintenances where activityId = &#63; and label = &#63;.
	*
	* @param activityId the activity ID
	* @param label the label
	* @return the number of matching maintenances
	*/
	public static int countByActivityId_Label(long activityId, String label) {
		return getPersistence().countByActivityId_Label(activityId, label);
	}

	/**
	* Returns all the maintenances where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching maintenances
	*/
	public static List<Maintenance> findByCompanyGroup(long companyId,
		long groupId) {
		return getPersistence().findByCompanyGroup(companyId, groupId);
	}

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
	public static List<Maintenance> findByCompanyGroup(long companyId,
		long groupId, int start, int end) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end);
	}

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
	public static List<Maintenance> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<Maintenance> orderByComparator) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator);
	}

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
	public static List<Maintenance> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<Maintenance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first maintenance in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching maintenance
	* @throws NoSuchMaintenanceException if a matching maintenance could not be found
	*/
	public static Maintenance findByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator<Maintenance> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return getPersistence()
				   .findByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first maintenance in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public static Maintenance fetchByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator<Maintenance> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last maintenance in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching maintenance
	* @throws NoSuchMaintenanceException if a matching maintenance could not be found
	*/
	public static Maintenance findByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator<Maintenance> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return getPersistence()
				   .findByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last maintenance in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public static Maintenance fetchByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator<Maintenance> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

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
	public static Maintenance[] findByCompanyGroup_PrevAndNext(
		long maintenanceId, long companyId, long groupId,
		OrderByComparator<Maintenance> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return getPersistence()
				   .findByCompanyGroup_PrevAndNext(maintenanceId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the maintenances where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public static void removeByCompanyGroup(long companyId, long groupId) {
		getPersistence().removeByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns the number of maintenances where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching maintenances
	*/
	public static int countByCompanyGroup(long companyId, long groupId) {
		return getPersistence().countByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns all the maintenances where loanId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param isDone the is done
	* @return the matching maintenances
	*/
	public static List<Maintenance> findByLoanIdIsDone(long loanId,
		Boolean isDone) {
		return getPersistence().findByLoanIdIsDone(loanId, isDone);
	}

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
	public static List<Maintenance> findByLoanIdIsDone(long loanId,
		Boolean isDone, int start, int end) {
		return getPersistence().findByLoanIdIsDone(loanId, isDone, start, end);
	}

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
	public static List<Maintenance> findByLoanIdIsDone(long loanId,
		Boolean isDone, int start, int end,
		OrderByComparator<Maintenance> orderByComparator) {
		return getPersistence()
				   .findByLoanIdIsDone(loanId, isDone, start, end,
			orderByComparator);
	}

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
	public static List<Maintenance> findByLoanIdIsDone(long loanId,
		Boolean isDone, int start, int end,
		OrderByComparator<Maintenance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByLoanIdIsDone(loanId, isDone, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first maintenance in the ordered set where loanId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param isDone the is done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching maintenance
	* @throws NoSuchMaintenanceException if a matching maintenance could not be found
	*/
	public static Maintenance findByLoanIdIsDone_First(long loanId,
		Boolean isDone, OrderByComparator<Maintenance> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return getPersistence()
				   .findByLoanIdIsDone_First(loanId, isDone, orderByComparator);
	}

	/**
	* Returns the first maintenance in the ordered set where loanId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param isDone the is done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public static Maintenance fetchByLoanIdIsDone_First(long loanId,
		Boolean isDone, OrderByComparator<Maintenance> orderByComparator) {
		return getPersistence()
				   .fetchByLoanIdIsDone_First(loanId, isDone, orderByComparator);
	}

	/**
	* Returns the last maintenance in the ordered set where loanId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param isDone the is done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching maintenance
	* @throws NoSuchMaintenanceException if a matching maintenance could not be found
	*/
	public static Maintenance findByLoanIdIsDone_Last(long loanId,
		Boolean isDone, OrderByComparator<Maintenance> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return getPersistence()
				   .findByLoanIdIsDone_Last(loanId, isDone, orderByComparator);
	}

	/**
	* Returns the last maintenance in the ordered set where loanId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param isDone the is done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public static Maintenance fetchByLoanIdIsDone_Last(long loanId,
		Boolean isDone, OrderByComparator<Maintenance> orderByComparator) {
		return getPersistence()
				   .fetchByLoanIdIsDone_Last(loanId, isDone, orderByComparator);
	}

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
	public static Maintenance[] findByLoanIdIsDone_PrevAndNext(
		long maintenanceId, long loanId, Boolean isDone,
		OrderByComparator<Maintenance> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return getPersistence()
				   .findByLoanIdIsDone_PrevAndNext(maintenanceId, loanId,
			isDone, orderByComparator);
	}

	/**
	* Removes all the maintenances where loanId = &#63; and isDone = &#63; from the database.
	*
	* @param loanId the loan ID
	* @param isDone the is done
	*/
	public static void removeByLoanIdIsDone(long loanId, Boolean isDone) {
		getPersistence().removeByLoanIdIsDone(loanId, isDone);
	}

	/**
	* Returns the number of maintenances where loanId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param isDone the is done
	* @return the number of matching maintenances
	*/
	public static int countByLoanIdIsDone(long loanId, Boolean isDone) {
		return getPersistence().countByLoanIdIsDone(loanId, isDone);
	}

	/**
	* Returns all the maintenances where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param isDone the is done
	* @return the matching maintenances
	*/
	public static List<Maintenance> findByLoanIdActivityIdIsDone(long loanId,
		long activityId, Boolean isDone) {
		return getPersistence()
				   .findByLoanIdActivityIdIsDone(loanId, activityId, isDone);
	}

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
	public static List<Maintenance> findByLoanIdActivityIdIsDone(long loanId,
		long activityId, Boolean isDone, int start, int end) {
		return getPersistence()
				   .findByLoanIdActivityIdIsDone(loanId, activityId, isDone,
			start, end);
	}

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
	public static List<Maintenance> findByLoanIdActivityIdIsDone(long loanId,
		long activityId, Boolean isDone, int start, int end,
		OrderByComparator<Maintenance> orderByComparator) {
		return getPersistence()
				   .findByLoanIdActivityIdIsDone(loanId, activityId, isDone,
			start, end, orderByComparator);
	}

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
	public static List<Maintenance> findByLoanIdActivityIdIsDone(long loanId,
		long activityId, Boolean isDone, int start, int end,
		OrderByComparator<Maintenance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByLoanIdActivityIdIsDone(loanId, activityId, isDone,
			start, end, orderByComparator, retrieveFromCache);
	}

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
	public static Maintenance findByLoanIdActivityIdIsDone_First(long loanId,
		long activityId, Boolean isDone,
		OrderByComparator<Maintenance> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return getPersistence()
				   .findByLoanIdActivityIdIsDone_First(loanId, activityId,
			isDone, orderByComparator);
	}

	/**
	* Returns the first maintenance in the ordered set where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param isDone the is done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public static Maintenance fetchByLoanIdActivityIdIsDone_First(long loanId,
		long activityId, Boolean isDone,
		OrderByComparator<Maintenance> orderByComparator) {
		return getPersistence()
				   .fetchByLoanIdActivityIdIsDone_First(loanId, activityId,
			isDone, orderByComparator);
	}

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
	public static Maintenance findByLoanIdActivityIdIsDone_Last(long loanId,
		long activityId, Boolean isDone,
		OrderByComparator<Maintenance> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return getPersistence()
				   .findByLoanIdActivityIdIsDone_Last(loanId, activityId,
			isDone, orderByComparator);
	}

	/**
	* Returns the last maintenance in the ordered set where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param isDone the is done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching maintenance, or <code>null</code> if a matching maintenance could not be found
	*/
	public static Maintenance fetchByLoanIdActivityIdIsDone_Last(long loanId,
		long activityId, Boolean isDone,
		OrderByComparator<Maintenance> orderByComparator) {
		return getPersistence()
				   .fetchByLoanIdActivityIdIsDone_Last(loanId, activityId,
			isDone, orderByComparator);
	}

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
	public static Maintenance[] findByLoanIdActivityIdIsDone_PrevAndNext(
		long maintenanceId, long loanId, long activityId, Boolean isDone,
		OrderByComparator<Maintenance> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return getPersistence()
				   .findByLoanIdActivityIdIsDone_PrevAndNext(maintenanceId,
			loanId, activityId, isDone, orderByComparator);
	}

	/**
	* Removes all the maintenances where loanId = &#63; and activityId = &#63; and isDone = &#63; from the database.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param isDone the is done
	*/
	public static void removeByLoanIdActivityIdIsDone(long loanId,
		long activityId, Boolean isDone) {
		getPersistence()
			.removeByLoanIdActivityIdIsDone(loanId, activityId, isDone);
	}

	/**
	* Returns the number of maintenances where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	*
	* @param loanId the loan ID
	* @param activityId the activity ID
	* @param isDone the is done
	* @return the number of matching maintenances
	*/
	public static int countByLoanIdActivityIdIsDone(long loanId,
		long activityId, Boolean isDone) {
		return getPersistence()
				   .countByLoanIdActivityIdIsDone(loanId, activityId, isDone);
	}

	/**
	* Caches the maintenance in the entity cache if it is enabled.
	*
	* @param maintenance the maintenance
	*/
	public static void cacheResult(Maintenance maintenance) {
		getPersistence().cacheResult(maintenance);
	}

	/**
	* Caches the maintenances in the entity cache if it is enabled.
	*
	* @param maintenances the maintenances
	*/
	public static void cacheResult(List<Maintenance> maintenances) {
		getPersistence().cacheResult(maintenances);
	}

	/**
	* Creates a new maintenance with the primary key. Does not add the maintenance to the database.
	*
	* @param maintenanceId the primary key for the new maintenance
	* @return the new maintenance
	*/
	public static Maintenance create(long maintenanceId) {
		return getPersistence().create(maintenanceId);
	}

	/**
	* Removes the maintenance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param maintenanceId the primary key of the maintenance
	* @return the maintenance that was removed
	* @throws NoSuchMaintenanceException if a maintenance with the primary key could not be found
	*/
	public static Maintenance remove(long maintenanceId)
		throws cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return getPersistence().remove(maintenanceId);
	}

	public static Maintenance updateImpl(Maintenance maintenance) {
		return getPersistence().updateImpl(maintenance);
	}

	/**
	* Returns the maintenance with the primary key or throws a {@link NoSuchMaintenanceException} if it could not be found.
	*
	* @param maintenanceId the primary key of the maintenance
	* @return the maintenance
	* @throws NoSuchMaintenanceException if a maintenance with the primary key could not be found
	*/
	public static Maintenance findByPrimaryKey(long maintenanceId)
		throws cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return getPersistence().findByPrimaryKey(maintenanceId);
	}

	/**
	* Returns the maintenance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param maintenanceId the primary key of the maintenance
	* @return the maintenance, or <code>null</code> if a maintenance with the primary key could not be found
	*/
	public static Maintenance fetchByPrimaryKey(long maintenanceId) {
		return getPersistence().fetchByPrimaryKey(maintenanceId);
	}

	public static java.util.Map<java.io.Serializable, Maintenance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the maintenances.
	*
	* @return the maintenances
	*/
	public static List<Maintenance> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Maintenance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Maintenance> findAll(int start, int end,
		OrderByComparator<Maintenance> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Maintenance> findAll(int start, int end,
		OrderByComparator<Maintenance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the maintenances from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of maintenances.
	*
	* @return the number of maintenances
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MaintenancePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MaintenancePersistence, MaintenancePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MaintenancePersistence.class);

		ServiceTracker<MaintenancePersistence, MaintenancePersistence> serviceTracker =
			new ServiceTracker<MaintenancePersistence, MaintenancePersistence>(bundle.getBundleContext(),
				MaintenancePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
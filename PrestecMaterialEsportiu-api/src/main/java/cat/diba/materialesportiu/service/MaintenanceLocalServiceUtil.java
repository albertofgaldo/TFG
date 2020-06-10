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

package cat.diba.materialesportiu.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Maintenance. This utility wraps
 * {@link cat.diba.materialesportiu.service.impl.MaintenanceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MaintenanceLocalService
 * @see cat.diba.materialesportiu.service.base.MaintenanceLocalServiceBaseImpl
 * @see cat.diba.materialesportiu.service.impl.MaintenanceLocalServiceImpl
 * @generated
 */
@ProviderType
public class MaintenanceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link cat.diba.materialesportiu.service.impl.MaintenanceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the maintenance to the database. Also notifies the appropriate model listeners.
	*
	* @param maintenance the maintenance
	* @return the maintenance that was added
	* @throws SystemException
	*/
	public static cat.diba.materialesportiu.model.Maintenance addMaintenance(
		cat.diba.materialesportiu.model.Maintenance maintenance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMaintenance(maintenance);
	}

	/**
	* Creates a new maintenance with the primary key. Does not add the maintenance to the database.
	*
	* @param maintenanceId the primary key for the new maintenance
	* @return the new maintenance
	*/
	public static cat.diba.materialesportiu.model.Maintenance createMaintenance(
		long maintenanceId) {
		return getService().createMaintenance(maintenanceId);
	}

	/**
	* Deletes the maintenance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param maintenanceId the primary key of the maintenance
	* @return the maintenance that was removed
	* @throws PortalException if a maintenance with the primary key could not be found
	*/
	public static cat.diba.materialesportiu.model.Maintenance deleteMaintenance(
		long maintenanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteMaintenance(maintenanceId);
	}

	/**
	* Deletes the maintenance from the database. Also notifies the appropriate model listeners.
	*
	* @param maintenance the maintenance
	* @return the maintenance that was removed
	*/
	public static cat.diba.materialesportiu.model.Maintenance deleteMaintenance(
		cat.diba.materialesportiu.model.Maintenance maintenance) {
		return getService().deleteMaintenance(maintenance);
	}

	public static void deleteMaintenanceByLoanId(long loanId)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().deleteMaintenanceByLoanId(loanId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static cat.diba.materialesportiu.model.Maintenance fetchMaintenance(
		long maintenanceId) {
		return getService().fetchMaintenance(maintenanceId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static int getCountByActivityId(long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountByActivityId(activityId);
	}

	public static int getCountByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountByCompanyGroup(companyId, groupId);
	}

	public static int getCountByLoanIdActivityIdIsDone(long loanId,
		long activityId, boolean isDone) {
		return getService()
				   .getCountByLoanIdActivityIdIsDone(loanId, activityId, isDone);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the maintenance with the primary key.
	*
	* @param maintenanceId the primary key of the maintenance
	* @return the maintenance
	* @throws PortalException if a maintenance with the primary key could not be found
	*/
	public static cat.diba.materialesportiu.model.Maintenance getMaintenance(
		long maintenanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getMaintenance(maintenanceId);
	}

	public static java.util.List<cat.diba.materialesportiu.model.Maintenance> getMaintenanceByActivityId(
		long activityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMaintenanceByActivityId(activityId, start, end);
	}

	public static cat.diba.materialesportiu.model.Maintenance getMaintenanceByActivityIdAndLabel(
		long activityId, String label)
		throws com.liferay.portal.kernel.exception.SystemException,
			cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return getService().getMaintenanceByActivityIdAndLabel(activityId, label);
	}

	public static java.util.List<cat.diba.materialesportiu.model.Maintenance> getMaintenanceByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<cat.diba.materialesportiu.model.Maintenance> obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getMaintenanceByCompanyGroup(companyId, groupId, start,
			end, obc);
	}

	public static java.util.List<cat.diba.materialesportiu.model.Maintenance> getMaintenanceByLoanIdIsDone(
		long loanId, boolean isDone) {
		return getService().getMaintenanceByLoanIdIsDone(loanId, isDone);
	}

	/**
	* Returns a range of all the maintenances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of maintenances
	* @param end the upper bound of the range of maintenances (not inclusive)
	* @return the range of maintenances
	*/
	public static java.util.List<cat.diba.materialesportiu.model.Maintenance> getMaintenances(
		int start, int end) {
		return getService().getMaintenances(start, end);
	}

	/**
	* Returns the number of maintenances.
	*
	* @return the number of maintenances
	*/
	public static int getMaintenancesCount() {
		return getService().getMaintenancesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the maintenance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param maintenance the maintenance
	* @return the maintenance that was updated
	* @throws SystemException
	*/
	public static cat.diba.materialesportiu.model.Maintenance updateMaintenance(
		cat.diba.materialesportiu.model.Maintenance maintenance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMaintenance(maintenance);
	}

	public static MaintenanceLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MaintenanceLocalService, MaintenanceLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MaintenanceLocalService.class);

		ServiceTracker<MaintenanceLocalService, MaintenanceLocalService> serviceTracker =
			new ServiceTracker<MaintenanceLocalService, MaintenanceLocalService>(bundle.getBundleContext(),
				MaintenanceLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
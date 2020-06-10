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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MaintenanceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MaintenanceLocalService
 * @generated
 */
@ProviderType
public class MaintenanceLocalServiceWrapper implements MaintenanceLocalService,
	ServiceWrapper<MaintenanceLocalService> {
	public MaintenanceLocalServiceWrapper(
		MaintenanceLocalService maintenanceLocalService) {
		_maintenanceLocalService = maintenanceLocalService;
	}

	/**
	* Adds the maintenance to the database. Also notifies the appropriate model listeners.
	*
	* @param maintenance the maintenance
	* @return the maintenance that was added
	* @throws SystemException
	*/
	@Override
	public cat.diba.materialesportiu.model.Maintenance addMaintenance(
		cat.diba.materialesportiu.model.Maintenance maintenance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _maintenanceLocalService.addMaintenance(maintenance);
	}

	/**
	* Creates a new maintenance with the primary key. Does not add the maintenance to the database.
	*
	* @param maintenanceId the primary key for the new maintenance
	* @return the new maintenance
	*/
	@Override
	public cat.diba.materialesportiu.model.Maintenance createMaintenance(
		long maintenanceId) {
		return _maintenanceLocalService.createMaintenance(maintenanceId);
	}

	/**
	* Deletes the maintenance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param maintenanceId the primary key of the maintenance
	* @return the maintenance that was removed
	* @throws PortalException if a maintenance with the primary key could not be found
	*/
	@Override
	public cat.diba.materialesportiu.model.Maintenance deleteMaintenance(
		long maintenanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _maintenanceLocalService.deleteMaintenance(maintenanceId);
	}

	/**
	* Deletes the maintenance from the database. Also notifies the appropriate model listeners.
	*
	* @param maintenance the maintenance
	* @return the maintenance that was removed
	*/
	@Override
	public cat.diba.materialesportiu.model.Maintenance deleteMaintenance(
		cat.diba.materialesportiu.model.Maintenance maintenance) {
		return _maintenanceLocalService.deleteMaintenance(maintenance);
	}

	@Override
	public void deleteMaintenanceByLoanId(long loanId)
		throws com.liferay.portal.kernel.exception.PortalException {
		_maintenanceLocalService.deleteMaintenanceByLoanId(loanId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _maintenanceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _maintenanceLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _maintenanceLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _maintenanceLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _maintenanceLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _maintenanceLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _maintenanceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public cat.diba.materialesportiu.model.Maintenance fetchMaintenance(
		long maintenanceId) {
		return _maintenanceLocalService.fetchMaintenance(maintenanceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _maintenanceLocalService.getActionableDynamicQuery();
	}

	@Override
	public int getCountByActivityId(long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _maintenanceLocalService.getCountByActivityId(activityId);
	}

	@Override
	public int getCountByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _maintenanceLocalService.getCountByCompanyGroup(companyId,
			groupId);
	}

	@Override
	public int getCountByLoanIdActivityIdIsDone(long loanId, long activityId,
		boolean isDone) {
		return _maintenanceLocalService.getCountByLoanIdActivityIdIsDone(loanId,
			activityId, isDone);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _maintenanceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the maintenance with the primary key.
	*
	* @param maintenanceId the primary key of the maintenance
	* @return the maintenance
	* @throws PortalException if a maintenance with the primary key could not be found
	*/
	@Override
	public cat.diba.materialesportiu.model.Maintenance getMaintenance(
		long maintenanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _maintenanceLocalService.getMaintenance(maintenanceId);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.Maintenance> getMaintenanceByActivityId(
		long activityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _maintenanceLocalService.getMaintenanceByActivityId(activityId,
			start, end);
	}

	@Override
	public cat.diba.materialesportiu.model.Maintenance getMaintenanceByActivityIdAndLabel(
		long activityId, String label)
		throws com.liferay.portal.kernel.exception.SystemException,
			cat.diba.materialesportiu.exception.NoSuchMaintenanceException {
		return _maintenanceLocalService.getMaintenanceByActivityIdAndLabel(activityId,
			label);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.Maintenance> getMaintenanceByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<cat.diba.materialesportiu.model.Maintenance> obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _maintenanceLocalService.getMaintenanceByCompanyGroup(companyId,
			groupId, start, end, obc);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.Maintenance> getMaintenanceByLoanIdIsDone(
		long loanId, boolean isDone) {
		return _maintenanceLocalService.getMaintenanceByLoanIdIsDone(loanId,
			isDone);
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
	@Override
	public java.util.List<cat.diba.materialesportiu.model.Maintenance> getMaintenances(
		int start, int end) {
		return _maintenanceLocalService.getMaintenances(start, end);
	}

	/**
	* Returns the number of maintenances.
	*
	* @return the number of maintenances
	*/
	@Override
	public int getMaintenancesCount() {
		return _maintenanceLocalService.getMaintenancesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _maintenanceLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _maintenanceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the maintenance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param maintenance the maintenance
	* @return the maintenance that was updated
	* @throws SystemException
	*/
	@Override
	public cat.diba.materialesportiu.model.Maintenance updateMaintenance(
		cat.diba.materialesportiu.model.Maintenance maintenance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _maintenanceLocalService.updateMaintenance(maintenance);
	}

	@Override
	public MaintenanceLocalService getWrappedService() {
		return _maintenanceLocalService;
	}

	@Override
	public void setWrappedService(
		MaintenanceLocalService maintenanceLocalService) {
		_maintenanceLocalService = maintenanceLocalService;
	}

	private MaintenanceLocalService _maintenanceLocalService;
}
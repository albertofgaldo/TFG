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
 * Provides a wrapper for {@link LoanActivityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LoanActivityLocalService
 * @generated
 */
@ProviderType
public class LoanActivityLocalServiceWrapper implements LoanActivityLocalService,
	ServiceWrapper<LoanActivityLocalService> {
	public LoanActivityLocalServiceWrapper(
		LoanActivityLocalService loanActivityLocalService) {
		_loanActivityLocalService = loanActivityLocalService;
	}

	/**
	* Adds the loan activity to the database. Also notifies the appropriate model listeners.
	*
	* @param loanActivity the loan activity
	* @return the loan activity that was added
	* @throws SystemException
	*/
	@Override
	public cat.diba.materialesportiu.model.LoanActivity addLoanActivity(
		cat.diba.materialesportiu.model.LoanActivity loanActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loanActivityLocalService.addLoanActivity(loanActivity);
	}

	/**
	* Creates a new loan activity with the primary key. Does not add the loan activity to the database.
	*
	* @param loanActivityId the primary key for the new loan activity
	* @return the new loan activity
	*/
	@Override
	public cat.diba.materialesportiu.model.LoanActivity createLoanActivity(
		long loanActivityId) {
		return _loanActivityLocalService.createLoanActivity(loanActivityId);
	}

	/**
	* Deletes the loan activity from the database. Also notifies the appropriate model listeners.
	*
	* @param loanActivity the loan activity
	* @return the loan activity that was removed
	*/
	@Override
	public cat.diba.materialesportiu.model.LoanActivity deleteLoanActivity(
		cat.diba.materialesportiu.model.LoanActivity loanActivity) {
		return _loanActivityLocalService.deleteLoanActivity(loanActivity);
	}

	/**
	* Deletes the loan activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loanActivityId the primary key of the loan activity
	* @return the loan activity that was removed
	* @throws PortalException if a loan activity with the primary key could not be found
	*/
	@Override
	public cat.diba.materialesportiu.model.LoanActivity deleteLoanActivity(
		long loanActivityId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _loanActivityLocalService.deleteLoanActivity(loanActivityId);
	}

	@Override
	public void deleteLoanActivityByActivityId(long activityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		_loanActivityLocalService.deleteLoanActivityByActivityId(activityId);
	}

	@Override
	public void deleteLoanActivityByLoanlId(long loanId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		_loanActivityLocalService.deleteLoanActivityByLoanlId(loanId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _loanActivityLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _loanActivityLocalService.dynamicQuery();
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
		return _loanActivityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _loanActivityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _loanActivityLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _loanActivityLocalService.dynamicQueryCount(dynamicQuery);
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
		return _loanActivityLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public cat.diba.materialesportiu.model.LoanActivity fetchLoanActivity(
		long loanActivityId) {
		return _loanActivityLocalService.fetchLoanActivity(loanActivityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _loanActivityLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.LoanActivity> getActivityByLoanId(
		Long loanId) throws com.liferay.portal.kernel.exception.SystemException {
		return _loanActivityLocalService.getActivityByLoanId(loanId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _loanActivityLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns a range of all the loan activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loan activities
	* @param end the upper bound of the range of loan activities (not inclusive)
	* @return the range of loan activities
	*/
	@Override
	public java.util.List<cat.diba.materialesportiu.model.LoanActivity> getLoanActivities(
		int start, int end) {
		return _loanActivityLocalService.getLoanActivities(start, end);
	}

	/**
	* Returns the number of loan activities.
	*
	* @return the number of loan activities
	*/
	@Override
	public int getLoanActivitiesCount() {
		return _loanActivityLocalService.getLoanActivitiesCount();
	}

	/**
	* Returns the loan activity with the primary key.
	*
	* @param loanActivityId the primary key of the loan activity
	* @return the loan activity
	* @throws PortalException if a loan activity with the primary key could not be found
	*/
	@Override
	public cat.diba.materialesportiu.model.LoanActivity getLoanActivity(
		long loanActivityId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _loanActivityLocalService.getLoanActivity(loanActivityId);
	}

	@Override
	public cat.diba.materialesportiu.model.LoanActivity getLoanActivityByLoanIdActivityId(
		Long loanId, Long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loanActivityLocalService.getLoanActivityByLoanIdActivityId(loanId,
			activityId);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.LoanActivity> getLoanByActivityId(
		Long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loanActivityLocalService.getLoanByActivityId(activityId);
	}

	@Override
	public cat.diba.materialesportiu.model.Material getMaterialByActivityId(
		long activityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		return _loanActivityLocalService.getMaterialByActivityId(activityId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _loanActivityLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _loanActivityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the loan activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param loanActivity the loan activity
	* @return the loan activity that was updated
	* @throws SystemException
	*/
	@Override
	public cat.diba.materialesportiu.model.LoanActivity updateLoanActivity(
		cat.diba.materialesportiu.model.LoanActivity loanActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loanActivityLocalService.updateLoanActivity(loanActivity);
	}

	@Override
	public LoanActivityLocalService getWrappedService() {
		return _loanActivityLocalService;
	}

	@Override
	public void setWrappedService(
		LoanActivityLocalService loanActivityLocalService) {
		_loanActivityLocalService = loanActivityLocalService;
	}

	private LoanActivityLocalService _loanActivityLocalService;
}
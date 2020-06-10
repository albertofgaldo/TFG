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
 * Provides a wrapper for {@link LoanLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LoanLocalService
 * @generated
 */
@ProviderType
public class LoanLocalServiceWrapper implements LoanLocalService,
	ServiceWrapper<LoanLocalService> {
	public LoanLocalServiceWrapper(LoanLocalService loanLocalService) {
		_loanLocalService = loanLocalService;
	}

	/**
	* Adds the loan to the database. Also notifies the appropriate model listeners.
	*
	* @param loan the loan
	* @return the loan that was added
	* @throws SystemException
	*/
	@Override
	public cat.diba.materialesportiu.model.Loan addLoan(
		cat.diba.materialesportiu.model.Loan loan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.addLoan(loan);
	}

	@Override
	public void checkExpiredLoans() {
		_loanLocalService.checkExpiredLoans();
	}

	/**
	* Creates a new loan with the primary key. Does not add the loan to the database.
	*
	* @param loanId the primary key for the new loan
	* @return the new loan
	*/
	@Override
	public cat.diba.materialesportiu.model.Loan createLoan(long loanId) {
		return _loanLocalService.createLoan(loanId);
	}

	/**
	* Deletes the loan from the database. Also notifies the appropriate model listeners.
	*
	* @param loan the loan
	* @return the loan that was removed
	*/
	@Override
	public cat.diba.materialesportiu.model.Loan deleteLoan(
		cat.diba.materialesportiu.model.Loan loan) {
		return _loanLocalService.deleteLoan(loan);
	}

	/**
	* Deletes the loan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loanId the primary key of the loan
	* @return the loan that was removed
	* @throws PortalException if a loan with the primary key could not be found
	*/
	@Override
	public cat.diba.materialesportiu.model.Loan deleteLoan(long loanId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _loanLocalService.deleteLoan(loanId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _loanLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _loanLocalService.dynamicQuery();
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
		return _loanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _loanLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _loanLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _loanLocalService.dynamicQueryCount(dynamicQuery);
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
		return _loanLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public cat.diba.materialesportiu.model.Loan fetchLoan(long loanId) {
		return _loanLocalService.fetchLoan(loanId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _loanLocalService.getActionableDynamicQuery();
	}

	@Override
	public int getCountByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.getCountByCompanyGroup(companyId, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _loanLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the loan with the primary key.
	*
	* @param loanId the primary key of the loan
	* @return the loan
	* @throws PortalException if a loan with the primary key could not be found
	*/
	@Override
	public cat.diba.materialesportiu.model.Loan getLoan(long loanId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _loanLocalService.getLoan(loanId);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.Loan> getLoanByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.getLoanByCompanyGroup(companyId, groupId);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.Loan> getLoanByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<cat.diba.materialesportiu.model.Loan> obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.getLoanByCompanyGroup(companyId, groupId,
			start, end, obc);
	}

	@Override
	public cat.diba.materialesportiu.model.Loan getLoanId(long loanId) {
		return _loanLocalService.getLoanId(loanId);
	}

	/**
	* Returns a range of all the loans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @return the range of loans
	*/
	@Override
	public java.util.List<cat.diba.materialesportiu.model.Loan> getLoans(
		int start, int end) {
		return _loanLocalService.getLoans(start, end);
	}

	/**
	* Returns the number of loans.
	*
	* @return the number of loans
	*/
	@Override
	public int getLoansCount() {
		return _loanLocalService.getLoansCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _loanLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _loanLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int getStockAvailableBetweenDates(long activityId,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _loanLocalService.getStockAvailableBetweenDates(activityId,
			startDate, endDate);
	}

	/**
	* Updates the loan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param loan the loan
	* @return the loan that was updated
	* @throws SystemException
	*/
	@Override
	public cat.diba.materialesportiu.model.Loan updateLoan(
		cat.diba.materialesportiu.model.Loan loan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.updateLoan(loan);
	}

	@Override
	public void updateStatusBorrowedToMaintenance(java.util.Calendar today)
		throws com.liferay.portal.kernel.exception.PortalException {
		_loanLocalService.updateStatusBorrowedToMaintenance(today);
	}

	@Override
	public void updateStatusConfirmedToBorrowed(java.util.Date today)
		throws com.liferay.portal.kernel.exception.PortalException {
		_loanLocalService.updateStatusConfirmedToBorrowed(today);
	}

	@Override
	public void updateStatusMaintenanceIsDone(
		cat.diba.materialesportiu.model.Loan loan, java.util.Date today)
		throws com.liferay.portal.kernel.exception.PortalException {
		_loanLocalService.updateStatusMaintenanceIsDone(loan, today);
	}

	@Override
	public void updateStatusMaintenanceToReturned(java.util.Date today)
		throws com.liferay.portal.kernel.exception.PortalException {
		_loanLocalService.updateStatusMaintenanceToReturned(today);
	}

	@Override
	public LoanLocalService getWrappedService() {
		return _loanLocalService;
	}

	@Override
	public void setWrappedService(LoanLocalService loanLocalService) {
		_loanLocalService = loanLocalService;
	}

	private LoanLocalService _loanLocalService;
}
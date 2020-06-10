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
 * Provides the local service utility for Loan. This utility wraps
 * {@link cat.diba.materialesportiu.service.impl.LoanLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LoanLocalService
 * @see cat.diba.materialesportiu.service.base.LoanLocalServiceBaseImpl
 * @see cat.diba.materialesportiu.service.impl.LoanLocalServiceImpl
 * @generated
 */
@ProviderType
public class LoanLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link cat.diba.materialesportiu.service.impl.LoanLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the loan to the database. Also notifies the appropriate model listeners.
	*
	* @param loan the loan
	* @return the loan that was added
	* @throws SystemException
	*/
	public static cat.diba.materialesportiu.model.Loan addLoan(
		cat.diba.materialesportiu.model.Loan loan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLoan(loan);
	}

	public static void checkExpiredLoans() {
		getService().checkExpiredLoans();
	}

	/**
	* Creates a new loan with the primary key. Does not add the loan to the database.
	*
	* @param loanId the primary key for the new loan
	* @return the new loan
	*/
	public static cat.diba.materialesportiu.model.Loan createLoan(long loanId) {
		return getService().createLoan(loanId);
	}

	/**
	* Deletes the loan from the database. Also notifies the appropriate model listeners.
	*
	* @param loan the loan
	* @return the loan that was removed
	*/
	public static cat.diba.materialesportiu.model.Loan deleteLoan(
		cat.diba.materialesportiu.model.Loan loan) {
		return getService().deleteLoan(loan);
	}

	/**
	* Deletes the loan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loanId the primary key of the loan
	* @return the loan that was removed
	* @throws PortalException if a loan with the primary key could not be found
	*/
	public static cat.diba.materialesportiu.model.Loan deleteLoan(long loanId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLoan(loanId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static cat.diba.materialesportiu.model.Loan fetchLoan(long loanId) {
		return getService().fetchLoan(loanId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static int getCountByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountByCompanyGroup(companyId, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the loan with the primary key.
	*
	* @param loanId the primary key of the loan
	* @return the loan
	* @throws PortalException if a loan with the primary key could not be found
	*/
	public static cat.diba.materialesportiu.model.Loan getLoan(long loanId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLoan(loanId);
	}

	public static java.util.List<cat.diba.materialesportiu.model.Loan> getLoanByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLoanByCompanyGroup(companyId, groupId);
	}

	public static java.util.List<cat.diba.materialesportiu.model.Loan> getLoanByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<cat.diba.materialesportiu.model.Loan> obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLoanByCompanyGroup(companyId, groupId, start, end, obc);
	}

	public static cat.diba.materialesportiu.model.Loan getLoanId(long loanId) {
		return getService().getLoanId(loanId);
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
	public static java.util.List<cat.diba.materialesportiu.model.Loan> getLoans(
		int start, int end) {
		return getService().getLoans(start, end);
	}

	/**
	* Returns the number of loans.
	*
	* @return the number of loans
	*/
	public static int getLoansCount() {
		return getService().getLoansCount();
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

	public static int getStockAvailableBetweenDates(long activityId,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getStockAvailableBetweenDates(activityId, startDate, endDate);
	}

	/**
	* Updates the loan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param loan the loan
	* @return the loan that was updated
	* @throws SystemException
	*/
	public static cat.diba.materialesportiu.model.Loan updateLoan(
		cat.diba.materialesportiu.model.Loan loan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLoan(loan);
	}

	public static void updateStatusBorrowedToMaintenance(
		java.util.Calendar today)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().updateStatusBorrowedToMaintenance(today);
	}

	public static void updateStatusConfirmedToBorrowed(java.util.Date today)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().updateStatusConfirmedToBorrowed(today);
	}

	public static void updateStatusMaintenanceIsDone(
		cat.diba.materialesportiu.model.Loan loan, java.util.Date today)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().updateStatusMaintenanceIsDone(loan, today);
	}

	public static void updateStatusMaintenanceToReturned(java.util.Date today)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().updateStatusMaintenanceToReturned(today);
	}

	public static LoanLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LoanLocalService, LoanLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LoanLocalService.class);

		ServiceTracker<LoanLocalService, LoanLocalService> serviceTracker = new ServiceTracker<LoanLocalService, LoanLocalService>(bundle.getBundleContext(),
				LoanLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
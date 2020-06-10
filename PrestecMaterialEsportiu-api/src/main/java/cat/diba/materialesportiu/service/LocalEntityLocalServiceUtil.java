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
 * Provides the local service utility for LocalEntity. This utility wraps
 * {@link cat.diba.materialesportiu.service.impl.LocalEntityLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LocalEntityLocalService
 * @see cat.diba.materialesportiu.service.base.LocalEntityLocalServiceBaseImpl
 * @see cat.diba.materialesportiu.service.impl.LocalEntityLocalServiceImpl
 * @generated
 */
@ProviderType
public class LocalEntityLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link cat.diba.materialesportiu.service.impl.LocalEntityLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the local entity to the database. Also notifies the appropriate model listeners.
	*
	* @param localEntity the local entity
	* @return the local entity that was added
	* @throws SystemException
	*/
	public static cat.diba.materialesportiu.model.LocalEntity addLocalEntity(
		cat.diba.materialesportiu.model.LocalEntity localEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLocalEntity(localEntity);
	}

	public static boolean checkCif(String cif) {
		return getService().checkCif(cif);
	}

	/**
	* Creates a new local entity with the primary key. Does not add the local entity to the database.
	*
	* @param localEntityId the primary key for the new local entity
	* @return the new local entity
	*/
	public static cat.diba.materialesportiu.model.LocalEntity createLocalEntity(
		long localEntityId) {
		return getService().createLocalEntity(localEntityId);
	}

	/**
	* Deletes the local entity from the database. Also notifies the appropriate model listeners.
	*
	* @param localEntity the local entity
	* @return the local entity that was removed
	*/
	public static cat.diba.materialesportiu.model.LocalEntity deleteLocalEntity(
		cat.diba.materialesportiu.model.LocalEntity localEntity) {
		return getService().deleteLocalEntity(localEntity);
	}

	/**
	* Deletes the local entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param localEntityId the primary key of the local entity
	* @return the local entity that was removed
	* @throws PortalException if a local entity with the primary key could not be found
	*/
	public static cat.diba.materialesportiu.model.LocalEntity deleteLocalEntity(
		long localEntityId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLocalEntity(localEntityId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static cat.diba.materialesportiu.model.LocalEntity fetchLocalEntity(
		long localEntityId) {
		return getService().fetchLocalEntity(localEntityId);
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
	* Returns a range of all the local entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local entities
	* @param end the upper bound of the range of local entities (not inclusive)
	* @return the range of local entities
	*/
	public static java.util.List<cat.diba.materialesportiu.model.LocalEntity> getLocalEntities(
		int start, int end) {
		return getService().getLocalEntities(start, end);
	}

	/**
	* Returns the number of local entities.
	*
	* @return the number of local entities
	*/
	public static int getLocalEntitiesCount() {
		return getService().getLocalEntitiesCount();
	}

	/**
	* Returns the local entity with the primary key.
	*
	* @param localEntityId the primary key of the local entity
	* @return the local entity
	* @throws PortalException if a local entity with the primary key could not be found
	*/
	public static cat.diba.materialesportiu.model.LocalEntity getLocalEntity(
		long localEntityId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLocalEntity(localEntityId);
	}

	public static cat.diba.materialesportiu.model.LocalEntity getLocalEntityByCif(
		String cif)
		throws cat.diba.materialesportiu.exception.NoSuchLocalEntityException {
		return getService().getLocalEntityByCif(cif);
	}

	public static java.util.List<cat.diba.materialesportiu.model.LocalEntity> getLocalEntityByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocalEntityByCompanyGroup(companyId, groupId);
	}

	public static java.util.List<cat.diba.materialesportiu.model.LocalEntity> getLocalEntityByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<cat.diba.materialesportiu.model.LocalEntity> obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLocalEntityByCompanyGroup(companyId, groupId, start,
			end, obc);
	}

	public static java.util.List<cat.diba.materialesportiu.model.LocalEntity> getLocalEntityByName(
		String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocalEntityByName(name, start, end);
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
	* Updates the local entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param localEntity the local entity
	* @return the local entity that was updated
	*/
	public static cat.diba.materialesportiu.model.LocalEntity updateLocalEntity(
		cat.diba.materialesportiu.model.LocalEntity localEntity) {
		return getService().updateLocalEntity(localEntity);
	}

	public static LocalEntityLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LocalEntityLocalService, LocalEntityLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LocalEntityLocalService.class);

		ServiceTracker<LocalEntityLocalService, LocalEntityLocalService> serviceTracker =
			new ServiceTracker<LocalEntityLocalService, LocalEntityLocalService>(bundle.getBundleContext(),
				LocalEntityLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
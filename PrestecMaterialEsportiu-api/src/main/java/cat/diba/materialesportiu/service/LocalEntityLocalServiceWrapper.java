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
 * Provides a wrapper for {@link LocalEntityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LocalEntityLocalService
 * @generated
 */
@ProviderType
public class LocalEntityLocalServiceWrapper implements LocalEntityLocalService,
	ServiceWrapper<LocalEntityLocalService> {
	public LocalEntityLocalServiceWrapper(
		LocalEntityLocalService localEntityLocalService) {
		_localEntityLocalService = localEntityLocalService;
	}

	/**
	* Adds the local entity to the database. Also notifies the appropriate model listeners.
	*
	* @param localEntity the local entity
	* @return the local entity that was added
	* @throws SystemException
	*/
	@Override
	public cat.diba.materialesportiu.model.LocalEntity addLocalEntity(
		cat.diba.materialesportiu.model.LocalEntity localEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _localEntityLocalService.addLocalEntity(localEntity);
	}

	@Override
	public boolean checkCif(String cif) {
		return _localEntityLocalService.checkCif(cif);
	}

	/**
	* Creates a new local entity with the primary key. Does not add the local entity to the database.
	*
	* @param localEntityId the primary key for the new local entity
	* @return the new local entity
	*/
	@Override
	public cat.diba.materialesportiu.model.LocalEntity createLocalEntity(
		long localEntityId) {
		return _localEntityLocalService.createLocalEntity(localEntityId);
	}

	/**
	* Deletes the local entity from the database. Also notifies the appropriate model listeners.
	*
	* @param localEntity the local entity
	* @return the local entity that was removed
	*/
	@Override
	public cat.diba.materialesportiu.model.LocalEntity deleteLocalEntity(
		cat.diba.materialesportiu.model.LocalEntity localEntity) {
		return _localEntityLocalService.deleteLocalEntity(localEntity);
	}

	/**
	* Deletes the local entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param localEntityId the primary key of the local entity
	* @return the local entity that was removed
	* @throws PortalException if a local entity with the primary key could not be found
	*/
	@Override
	public cat.diba.materialesportiu.model.LocalEntity deleteLocalEntity(
		long localEntityId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _localEntityLocalService.deleteLocalEntity(localEntityId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _localEntityLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _localEntityLocalService.dynamicQuery();
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
		return _localEntityLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _localEntityLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _localEntityLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _localEntityLocalService.dynamicQueryCount(dynamicQuery);
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
		return _localEntityLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public cat.diba.materialesportiu.model.LocalEntity fetchLocalEntity(
		long localEntityId) {
		return _localEntityLocalService.fetchLocalEntity(localEntityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _localEntityLocalService.getActionableDynamicQuery();
	}

	@Override
	public int getCountByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _localEntityLocalService.getCountByCompanyGroup(companyId,
			groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _localEntityLocalService.getIndexableActionableDynamicQuery();
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
	@Override
	public java.util.List<cat.diba.materialesportiu.model.LocalEntity> getLocalEntities(
		int start, int end) {
		return _localEntityLocalService.getLocalEntities(start, end);
	}

	/**
	* Returns the number of local entities.
	*
	* @return the number of local entities
	*/
	@Override
	public int getLocalEntitiesCount() {
		return _localEntityLocalService.getLocalEntitiesCount();
	}

	/**
	* Returns the local entity with the primary key.
	*
	* @param localEntityId the primary key of the local entity
	* @return the local entity
	* @throws PortalException if a local entity with the primary key could not be found
	*/
	@Override
	public cat.diba.materialesportiu.model.LocalEntity getLocalEntity(
		long localEntityId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _localEntityLocalService.getLocalEntity(localEntityId);
	}

	@Override
	public cat.diba.materialesportiu.model.LocalEntity getLocalEntityByCif(
		String cif)
		throws cat.diba.materialesportiu.exception.NoSuchLocalEntityException {
		return _localEntityLocalService.getLocalEntityByCif(cif);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.LocalEntity> getLocalEntityByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _localEntityLocalService.getLocalEntityByCompanyGroup(companyId,
			groupId);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.LocalEntity> getLocalEntityByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<cat.diba.materialesportiu.model.LocalEntity> obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _localEntityLocalService.getLocalEntityByCompanyGroup(companyId,
			groupId, start, end, obc);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.LocalEntity> getLocalEntityByName(
		String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _localEntityLocalService.getLocalEntityByName(name, start, end);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _localEntityLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _localEntityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the local entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param localEntity the local entity
	* @return the local entity that was updated
	*/
	@Override
	public cat.diba.materialesportiu.model.LocalEntity updateLocalEntity(
		cat.diba.materialesportiu.model.LocalEntity localEntity) {
		return _localEntityLocalService.updateLocalEntity(localEntity);
	}

	@Override
	public LocalEntityLocalService getWrappedService() {
		return _localEntityLocalService;
	}

	@Override
	public void setWrappedService(
		LocalEntityLocalService localEntityLocalService) {
		_localEntityLocalService = localEntityLocalService;
	}

	private LocalEntityLocalService _localEntityLocalService;
}
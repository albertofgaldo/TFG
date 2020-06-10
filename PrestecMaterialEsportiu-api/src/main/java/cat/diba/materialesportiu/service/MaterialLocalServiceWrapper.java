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
 * Provides a wrapper for {@link MaterialLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MaterialLocalService
 * @generated
 */
@ProviderType
public class MaterialLocalServiceWrapper implements MaterialLocalService,
	ServiceWrapper<MaterialLocalService> {
	public MaterialLocalServiceWrapper(
		MaterialLocalService materialLocalService) {
		_materialLocalService = materialLocalService;
	}

	/**
	* Adds the material to the database. Also notifies the appropriate model listeners.
	*
	* @param material the material
	* @return the material that was added
	* @throws SystemException
	*/
	@Override
	public cat.diba.materialesportiu.model.Material addMaterial(
		cat.diba.materialesportiu.model.Material material)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materialLocalService.addMaterial(material);
	}

	/**
	* Creates a new material with the primary key. Does not add the material to the database.
	*
	* @param materialId the primary key for the new material
	* @return the new material
	*/
	@Override
	public cat.diba.materialesportiu.model.Material createMaterial(
		long materialId) {
		return _materialLocalService.createMaterial(materialId);
	}

	/**
	* Deletes the material with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param materialId the primary key of the material
	* @return the material that was removed
	* @throws PortalException if a material with the primary key could not be found
	*/
	@Override
	public cat.diba.materialesportiu.model.Material deleteMaterial(
		long materialId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _materialLocalService.deleteMaterial(materialId);
	}

	/**
	* Deletes the material from the database. Also notifies the appropriate model listeners.
	*
	* @param material the material
	* @return the material that was removed
	*/
	@Override
	public cat.diba.materialesportiu.model.Material deleteMaterial(
		cat.diba.materialesportiu.model.Material material) {
		return _materialLocalService.deleteMaterial(material);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _materialLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _materialLocalService.dynamicQuery();
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
		return _materialLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.MaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _materialLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.MaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _materialLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _materialLocalService.dynamicQueryCount(dynamicQuery);
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
		return _materialLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public cat.diba.materialesportiu.model.Material fetchMaterial(
		long materialId) {
		return _materialLocalService.fetchMaterial(materialId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _materialLocalService.getActionableDynamicQuery();
	}

	@Override
	public int getCountByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materialLocalService.getCountByCompanyGroup(companyId, groupId);
	}

	@Override
	public int getCountByCompanyGroupByActivityId(long companyId, long groupId,
		long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materialLocalService.getCountByCompanyGroupByActivityId(companyId,
			groupId, activityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _materialLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the material with the primary key.
	*
	* @param materialId the primary key of the material
	* @return the material
	* @throws PortalException if a material with the primary key could not be found
	*/
	@Override
	public cat.diba.materialesportiu.model.Material getMaterial(long materialId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _materialLocalService.getMaterial(materialId);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.Material> getMaterialbyActivityId(
		long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materialLocalService.getMaterialbyActivityId(activityId);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.Material> getMaterialByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materialLocalService.getMaterialByCompanyGroup(companyId,
			groupId);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.Material> getMaterialByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<cat.diba.materialesportiu.model.Material> obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materialLocalService.getMaterialByCompanyGroup(companyId,
			groupId, start, end, obc);
	}

	@Override
	public java.util.List<cat.diba.materialesportiu.model.Material> getMaterialByCompanyGroupActivityId(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<cat.diba.materialesportiu.model.Material> obc,
		long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materialLocalService.getMaterialByCompanyGroupActivityId(companyId,
			groupId, start, end, obc, activityId);
	}

	@Override
	public cat.diba.materialesportiu.model.Material getMaterialById(
		long materialId)
		throws com.liferay.portal.kernel.exception.SystemException,
			cat.diba.materialesportiu.exception.NoSuchMaterialException {
		return _materialLocalService.getMaterialById(materialId);
	}

	/**
	* Returns a range of all the materials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cat.diba.materialesportiu.model.impl.MaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of materials
	* @param end the upper bound of the range of materials (not inclusive)
	* @return the range of materials
	*/
	@Override
	public java.util.List<cat.diba.materialesportiu.model.Material> getMaterials(
		int start, int end) {
		return _materialLocalService.getMaterials(start, end);
	}

	/**
	* Returns the number of materials.
	*
	* @return the number of materials
	*/
	@Override
	public int getMaterialsCount() {
		return _materialLocalService.getMaterialsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _materialLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _materialLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the material in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param material the material
	* @return the material that was updated
	* @throws SystemException
	*/
	@Override
	public cat.diba.materialesportiu.model.Material updateMaterial(
		cat.diba.materialesportiu.model.Material material)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materialLocalService.updateMaterial(material);
	}

	@Override
	public MaterialLocalService getWrappedService() {
		return _materialLocalService;
	}

	@Override
	public void setWrappedService(MaterialLocalService materialLocalService) {
		_materialLocalService = materialLocalService;
	}

	private MaterialLocalService _materialLocalService;
}
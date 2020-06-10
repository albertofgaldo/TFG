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

import cat.diba.materialesportiu.model.Material;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the material service. This utility wraps {@link cat.diba.materialesportiu.service.persistence.impl.MaterialPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MaterialPersistence
 * @see cat.diba.materialesportiu.service.persistence.impl.MaterialPersistenceImpl
 * @generated
 */
@ProviderType
public class MaterialUtil {
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
	public static void clearCache(Material material) {
		getPersistence().clearCache(material);
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
	public static List<Material> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Material> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Material> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Material> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Material update(Material material) {
		return getPersistence().update(material);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Material update(Material material,
		ServiceContext serviceContext) {
		return getPersistence().update(material, serviceContext);
	}

	/**
	* Returns the material where materialId = &#63; or throws a {@link NoSuchMaterialException} if it could not be found.
	*
	* @param materialId the material ID
	* @return the matching material
	* @throws NoSuchMaterialException if a matching material could not be found
	*/
	public static Material findByMaterialId(long materialId)
		throws cat.diba.materialesportiu.exception.NoSuchMaterialException {
		return getPersistence().findByMaterialId(materialId);
	}

	/**
	* Returns the material where materialId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param materialId the material ID
	* @return the matching material, or <code>null</code> if a matching material could not be found
	*/
	public static Material fetchByMaterialId(long materialId) {
		return getPersistence().fetchByMaterialId(materialId);
	}

	/**
	* Returns the material where materialId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param materialId the material ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching material, or <code>null</code> if a matching material could not be found
	*/
	public static Material fetchByMaterialId(long materialId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByMaterialId(materialId, retrieveFromCache);
	}

	/**
	* Removes the material where materialId = &#63; from the database.
	*
	* @param materialId the material ID
	* @return the material that was removed
	*/
	public static Material removeByMaterialId(long materialId)
		throws cat.diba.materialesportiu.exception.NoSuchMaterialException {
		return getPersistence().removeByMaterialId(materialId);
	}

	/**
	* Returns the number of materials where materialId = &#63;.
	*
	* @param materialId the material ID
	* @return the number of matching materials
	*/
	public static int countByMaterialId(long materialId) {
		return getPersistence().countByMaterialId(materialId);
	}

	/**
	* Returns all the materials where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the matching materials
	*/
	public static List<Material> findByActivityId(long activityId) {
		return getPersistence().findByActivityId(activityId);
	}

	/**
	* Returns a range of all the materials where activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activityId the activity ID
	* @param start the lower bound of the range of materials
	* @param end the upper bound of the range of materials (not inclusive)
	* @return the range of matching materials
	*/
	public static List<Material> findByActivityId(long activityId, int start,
		int end) {
		return getPersistence().findByActivityId(activityId, start, end);
	}

	/**
	* Returns an ordered range of all the materials where activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activityId the activity ID
	* @param start the lower bound of the range of materials
	* @param end the upper bound of the range of materials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching materials
	*/
	public static List<Material> findByActivityId(long activityId, int start,
		int end, OrderByComparator<Material> orderByComparator) {
		return getPersistence()
				   .findByActivityId(activityId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the materials where activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activityId the activity ID
	* @param start the lower bound of the range of materials
	* @param end the upper bound of the range of materials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching materials
	*/
	public static List<Material> findByActivityId(long activityId, int start,
		int end, OrderByComparator<Material> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByActivityId(activityId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first material in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching material
	* @throws NoSuchMaterialException if a matching material could not be found
	*/
	public static Material findByActivityId_First(long activityId,
		OrderByComparator<Material> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaterialException {
		return getPersistence()
				   .findByActivityId_First(activityId, orderByComparator);
	}

	/**
	* Returns the first material in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching material, or <code>null</code> if a matching material could not be found
	*/
	public static Material fetchByActivityId_First(long activityId,
		OrderByComparator<Material> orderByComparator) {
		return getPersistence()
				   .fetchByActivityId_First(activityId, orderByComparator);
	}

	/**
	* Returns the last material in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching material
	* @throws NoSuchMaterialException if a matching material could not be found
	*/
	public static Material findByActivityId_Last(long activityId,
		OrderByComparator<Material> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaterialException {
		return getPersistence()
				   .findByActivityId_Last(activityId, orderByComparator);
	}

	/**
	* Returns the last material in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching material, or <code>null</code> if a matching material could not be found
	*/
	public static Material fetchByActivityId_Last(long activityId,
		OrderByComparator<Material> orderByComparator) {
		return getPersistence()
				   .fetchByActivityId_Last(activityId, orderByComparator);
	}

	/**
	* Returns the materials before and after the current material in the ordered set where activityId = &#63;.
	*
	* @param materialId the primary key of the current material
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next material
	* @throws NoSuchMaterialException if a material with the primary key could not be found
	*/
	public static Material[] findByActivityId_PrevAndNext(long materialId,
		long activityId, OrderByComparator<Material> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaterialException {
		return getPersistence()
				   .findByActivityId_PrevAndNext(materialId, activityId,
			orderByComparator);
	}

	/**
	* Removes all the materials where activityId = &#63; from the database.
	*
	* @param activityId the activity ID
	*/
	public static void removeByActivityId(long activityId) {
		getPersistence().removeByActivityId(activityId);
	}

	/**
	* Returns the number of materials where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the number of matching materials
	*/
	public static int countByActivityId(long activityId) {
		return getPersistence().countByActivityId(activityId);
	}

	/**
	* Returns all the materials where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching materials
	*/
	public static List<Material> findByCompanyGroup(long companyId, long groupId) {
		return getPersistence().findByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the materials where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of materials
	* @param end the upper bound of the range of materials (not inclusive)
	* @return the range of matching materials
	*/
	public static List<Material> findByCompanyGroup(long companyId,
		long groupId, int start, int end) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the materials where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of materials
	* @param end the upper bound of the range of materials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching materials
	*/
	public static List<Material> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<Material> orderByComparator) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the materials where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of materials
	* @param end the upper bound of the range of materials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching materials
	*/
	public static List<Material> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<Material> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first material in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching material
	* @throws NoSuchMaterialException if a matching material could not be found
	*/
	public static Material findByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator<Material> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaterialException {
		return getPersistence()
				   .findByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first material in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching material, or <code>null</code> if a matching material could not be found
	*/
	public static Material fetchByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator<Material> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last material in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching material
	* @throws NoSuchMaterialException if a matching material could not be found
	*/
	public static Material findByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator<Material> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaterialException {
		return getPersistence()
				   .findByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last material in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching material, or <code>null</code> if a matching material could not be found
	*/
	public static Material fetchByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator<Material> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the materials before and after the current material in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param materialId the primary key of the current material
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next material
	* @throws NoSuchMaterialException if a material with the primary key could not be found
	*/
	public static Material[] findByCompanyGroup_PrevAndNext(long materialId,
		long companyId, long groupId,
		OrderByComparator<Material> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaterialException {
		return getPersistence()
				   .findByCompanyGroup_PrevAndNext(materialId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the materials where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public static void removeByCompanyGroup(long companyId, long groupId) {
		getPersistence().removeByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns the number of materials where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching materials
	*/
	public static int countByCompanyGroup(long companyId, long groupId) {
		return getPersistence().countByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns all the materials where companyId = &#63; and groupId = &#63; and activityId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param activityId the activity ID
	* @return the matching materials
	*/
	public static List<Material> findByCompanyGroupActivityId(long companyId,
		long groupId, long activityId) {
		return getPersistence()
				   .findByCompanyGroupActivityId(companyId, groupId, activityId);
	}

	/**
	* Returns a range of all the materials where companyId = &#63; and groupId = &#63; and activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param activityId the activity ID
	* @param start the lower bound of the range of materials
	* @param end the upper bound of the range of materials (not inclusive)
	* @return the range of matching materials
	*/
	public static List<Material> findByCompanyGroupActivityId(long companyId,
		long groupId, long activityId, int start, int end) {
		return getPersistence()
				   .findByCompanyGroupActivityId(companyId, groupId,
			activityId, start, end);
	}

	/**
	* Returns an ordered range of all the materials where companyId = &#63; and groupId = &#63; and activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param activityId the activity ID
	* @param start the lower bound of the range of materials
	* @param end the upper bound of the range of materials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching materials
	*/
	public static List<Material> findByCompanyGroupActivityId(long companyId,
		long groupId, long activityId, int start, int end,
		OrderByComparator<Material> orderByComparator) {
		return getPersistence()
				   .findByCompanyGroupActivityId(companyId, groupId,
			activityId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the materials where companyId = &#63; and groupId = &#63; and activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param activityId the activity ID
	* @param start the lower bound of the range of materials
	* @param end the upper bound of the range of materials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching materials
	*/
	public static List<Material> findByCompanyGroupActivityId(long companyId,
		long groupId, long activityId, int start, int end,
		OrderByComparator<Material> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyGroupActivityId(companyId, groupId,
			activityId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first material in the ordered set where companyId = &#63; and groupId = &#63; and activityId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching material
	* @throws NoSuchMaterialException if a matching material could not be found
	*/
	public static Material findByCompanyGroupActivityId_First(long companyId,
		long groupId, long activityId,
		OrderByComparator<Material> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaterialException {
		return getPersistence()
				   .findByCompanyGroupActivityId_First(companyId, groupId,
			activityId, orderByComparator);
	}

	/**
	* Returns the first material in the ordered set where companyId = &#63; and groupId = &#63; and activityId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching material, or <code>null</code> if a matching material could not be found
	*/
	public static Material fetchByCompanyGroupActivityId_First(long companyId,
		long groupId, long activityId,
		OrderByComparator<Material> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyGroupActivityId_First(companyId, groupId,
			activityId, orderByComparator);
	}

	/**
	* Returns the last material in the ordered set where companyId = &#63; and groupId = &#63; and activityId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching material
	* @throws NoSuchMaterialException if a matching material could not be found
	*/
	public static Material findByCompanyGroupActivityId_Last(long companyId,
		long groupId, long activityId,
		OrderByComparator<Material> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaterialException {
		return getPersistence()
				   .findByCompanyGroupActivityId_Last(companyId, groupId,
			activityId, orderByComparator);
	}

	/**
	* Returns the last material in the ordered set where companyId = &#63; and groupId = &#63; and activityId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching material, or <code>null</code> if a matching material could not be found
	*/
	public static Material fetchByCompanyGroupActivityId_Last(long companyId,
		long groupId, long activityId,
		OrderByComparator<Material> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyGroupActivityId_Last(companyId, groupId,
			activityId, orderByComparator);
	}

	/**
	* Returns the materials before and after the current material in the ordered set where companyId = &#63; and groupId = &#63; and activityId = &#63;.
	*
	* @param materialId the primary key of the current material
	* @param companyId the company ID
	* @param groupId the group ID
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next material
	* @throws NoSuchMaterialException if a material with the primary key could not be found
	*/
	public static Material[] findByCompanyGroupActivityId_PrevAndNext(
		long materialId, long companyId, long groupId, long activityId,
		OrderByComparator<Material> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchMaterialException {
		return getPersistence()
				   .findByCompanyGroupActivityId_PrevAndNext(materialId,
			companyId, groupId, activityId, orderByComparator);
	}

	/**
	* Removes all the materials where companyId = &#63; and groupId = &#63; and activityId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param activityId the activity ID
	*/
	public static void removeByCompanyGroupActivityId(long companyId,
		long groupId, long activityId) {
		getPersistence()
			.removeByCompanyGroupActivityId(companyId, groupId, activityId);
	}

	/**
	* Returns the number of materials where companyId = &#63; and groupId = &#63; and activityId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param activityId the activity ID
	* @return the number of matching materials
	*/
	public static int countByCompanyGroupActivityId(long companyId,
		long groupId, long activityId) {
		return getPersistence()
				   .countByCompanyGroupActivityId(companyId, groupId, activityId);
	}

	/**
	* Caches the material in the entity cache if it is enabled.
	*
	* @param material the material
	*/
	public static void cacheResult(Material material) {
		getPersistence().cacheResult(material);
	}

	/**
	* Caches the materials in the entity cache if it is enabled.
	*
	* @param materials the materials
	*/
	public static void cacheResult(List<Material> materials) {
		getPersistence().cacheResult(materials);
	}

	/**
	* Creates a new material with the primary key. Does not add the material to the database.
	*
	* @param materialId the primary key for the new material
	* @return the new material
	*/
	public static Material create(long materialId) {
		return getPersistence().create(materialId);
	}

	/**
	* Removes the material with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param materialId the primary key of the material
	* @return the material that was removed
	* @throws NoSuchMaterialException if a material with the primary key could not be found
	*/
	public static Material remove(long materialId)
		throws cat.diba.materialesportiu.exception.NoSuchMaterialException {
		return getPersistence().remove(materialId);
	}

	public static Material updateImpl(Material material) {
		return getPersistence().updateImpl(material);
	}

	/**
	* Returns the material with the primary key or throws a {@link NoSuchMaterialException} if it could not be found.
	*
	* @param materialId the primary key of the material
	* @return the material
	* @throws NoSuchMaterialException if a material with the primary key could not be found
	*/
	public static Material findByPrimaryKey(long materialId)
		throws cat.diba.materialesportiu.exception.NoSuchMaterialException {
		return getPersistence().findByPrimaryKey(materialId);
	}

	/**
	* Returns the material with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param materialId the primary key of the material
	* @return the material, or <code>null</code> if a material with the primary key could not be found
	*/
	public static Material fetchByPrimaryKey(long materialId) {
		return getPersistence().fetchByPrimaryKey(materialId);
	}

	public static java.util.Map<java.io.Serializable, Material> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the materials.
	*
	* @return the materials
	*/
	public static List<Material> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the materials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of materials
	* @param end the upper bound of the range of materials (not inclusive)
	* @return the range of materials
	*/
	public static List<Material> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the materials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of materials
	* @param end the upper bound of the range of materials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of materials
	*/
	public static List<Material> findAll(int start, int end,
		OrderByComparator<Material> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the materials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of materials
	* @param end the upper bound of the range of materials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of materials
	*/
	public static List<Material> findAll(int start, int end,
		OrderByComparator<Material> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the materials from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of materials.
	*
	* @return the number of materials
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MaterialPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MaterialPersistence, MaterialPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MaterialPersistence.class);

		ServiceTracker<MaterialPersistence, MaterialPersistence> serviceTracker = new ServiceTracker<MaterialPersistence, MaterialPersistence>(bundle.getBundleContext(),
				MaterialPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
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

import cat.diba.materialesportiu.exception.NoSuchMaterialException;
import cat.diba.materialesportiu.model.Material;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the material service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see cat.diba.materialesportiu.service.persistence.impl.MaterialPersistenceImpl
 * @see MaterialUtil
 * @generated
 */
@ProviderType
public interface MaterialPersistence extends BasePersistence<Material> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MaterialUtil} to access the material persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the material where materialId = &#63; or throws a {@link NoSuchMaterialException} if it could not be found.
	*
	* @param materialId the material ID
	* @return the matching material
	* @throws NoSuchMaterialException if a matching material could not be found
	*/
	public Material findByMaterialId(long materialId)
		throws NoSuchMaterialException;

	/**
	* Returns the material where materialId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param materialId the material ID
	* @return the matching material, or <code>null</code> if a matching material could not be found
	*/
	public Material fetchByMaterialId(long materialId);

	/**
	* Returns the material where materialId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param materialId the material ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching material, or <code>null</code> if a matching material could not be found
	*/
	public Material fetchByMaterialId(long materialId, boolean retrieveFromCache);

	/**
	* Removes the material where materialId = &#63; from the database.
	*
	* @param materialId the material ID
	* @return the material that was removed
	*/
	public Material removeByMaterialId(long materialId)
		throws NoSuchMaterialException;

	/**
	* Returns the number of materials where materialId = &#63;.
	*
	* @param materialId the material ID
	* @return the number of matching materials
	*/
	public int countByMaterialId(long materialId);

	/**
	* Returns all the materials where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the matching materials
	*/
	public java.util.List<Material> findByActivityId(long activityId);

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
	public java.util.List<Material> findByActivityId(long activityId,
		int start, int end);

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
	public java.util.List<Material> findByActivityId(long activityId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator);

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
	public java.util.List<Material> findByActivityId(long activityId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first material in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching material
	* @throws NoSuchMaterialException if a matching material could not be found
	*/
	public Material findByActivityId_First(long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator)
		throws NoSuchMaterialException;

	/**
	* Returns the first material in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching material, or <code>null</code> if a matching material could not be found
	*/
	public Material fetchByActivityId_First(long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator);

	/**
	* Returns the last material in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching material
	* @throws NoSuchMaterialException if a matching material could not be found
	*/
	public Material findByActivityId_Last(long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator)
		throws NoSuchMaterialException;

	/**
	* Returns the last material in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching material, or <code>null</code> if a matching material could not be found
	*/
	public Material fetchByActivityId_Last(long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator);

	/**
	* Returns the materials before and after the current material in the ordered set where activityId = &#63;.
	*
	* @param materialId the primary key of the current material
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next material
	* @throws NoSuchMaterialException if a material with the primary key could not be found
	*/
	public Material[] findByActivityId_PrevAndNext(long materialId,
		long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator)
		throws NoSuchMaterialException;

	/**
	* Removes all the materials where activityId = &#63; from the database.
	*
	* @param activityId the activity ID
	*/
	public void removeByActivityId(long activityId);

	/**
	* Returns the number of materials where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the number of matching materials
	*/
	public int countByActivityId(long activityId);

	/**
	* Returns all the materials where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching materials
	*/
	public java.util.List<Material> findByCompanyGroup(long companyId,
		long groupId);

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
	public java.util.List<Material> findByCompanyGroup(long companyId,
		long groupId, int start, int end);

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
	public java.util.List<Material> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator);

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
	public java.util.List<Material> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first material in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching material
	* @throws NoSuchMaterialException if a matching material could not be found
	*/
	public Material findByCompanyGroup_First(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator)
		throws NoSuchMaterialException;

	/**
	* Returns the first material in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching material, or <code>null</code> if a matching material could not be found
	*/
	public Material fetchByCompanyGroup_First(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator);

	/**
	* Returns the last material in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching material
	* @throws NoSuchMaterialException if a matching material could not be found
	*/
	public Material findByCompanyGroup_Last(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator)
		throws NoSuchMaterialException;

	/**
	* Returns the last material in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching material, or <code>null</code> if a matching material could not be found
	*/
	public Material fetchByCompanyGroup_Last(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator);

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
	public Material[] findByCompanyGroup_PrevAndNext(long materialId,
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator)
		throws NoSuchMaterialException;

	/**
	* Removes all the materials where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public void removeByCompanyGroup(long companyId, long groupId);

	/**
	* Returns the number of materials where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching materials
	*/
	public int countByCompanyGroup(long companyId, long groupId);

	/**
	* Returns all the materials where companyId = &#63; and groupId = &#63; and activityId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param activityId the activity ID
	* @return the matching materials
	*/
	public java.util.List<Material> findByCompanyGroupActivityId(
		long companyId, long groupId, long activityId);

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
	public java.util.List<Material> findByCompanyGroupActivityId(
		long companyId, long groupId, long activityId, int start, int end);

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
	public java.util.List<Material> findByCompanyGroupActivityId(
		long companyId, long groupId, long activityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator);

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
	public java.util.List<Material> findByCompanyGroupActivityId(
		long companyId, long groupId, long activityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator,
		boolean retrieveFromCache);

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
	public Material findByCompanyGroupActivityId_First(long companyId,
		long groupId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator)
		throws NoSuchMaterialException;

	/**
	* Returns the first material in the ordered set where companyId = &#63; and groupId = &#63; and activityId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching material, or <code>null</code> if a matching material could not be found
	*/
	public Material fetchByCompanyGroupActivityId_First(long companyId,
		long groupId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator);

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
	public Material findByCompanyGroupActivityId_Last(long companyId,
		long groupId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator)
		throws NoSuchMaterialException;

	/**
	* Returns the last material in the ordered set where companyId = &#63; and groupId = &#63; and activityId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching material, or <code>null</code> if a matching material could not be found
	*/
	public Material fetchByCompanyGroupActivityId_Last(long companyId,
		long groupId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator);

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
	public Material[] findByCompanyGroupActivityId_PrevAndNext(
		long materialId, long companyId, long groupId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator)
		throws NoSuchMaterialException;

	/**
	* Removes all the materials where companyId = &#63; and groupId = &#63; and activityId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param activityId the activity ID
	*/
	public void removeByCompanyGroupActivityId(long companyId, long groupId,
		long activityId);

	/**
	* Returns the number of materials where companyId = &#63; and groupId = &#63; and activityId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param activityId the activity ID
	* @return the number of matching materials
	*/
	public int countByCompanyGroupActivityId(long companyId, long groupId,
		long activityId);

	/**
	* Caches the material in the entity cache if it is enabled.
	*
	* @param material the material
	*/
	public void cacheResult(Material material);

	/**
	* Caches the materials in the entity cache if it is enabled.
	*
	* @param materials the materials
	*/
	public void cacheResult(java.util.List<Material> materials);

	/**
	* Creates a new material with the primary key. Does not add the material to the database.
	*
	* @param materialId the primary key for the new material
	* @return the new material
	*/
	public Material create(long materialId);

	/**
	* Removes the material with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param materialId the primary key of the material
	* @return the material that was removed
	* @throws NoSuchMaterialException if a material with the primary key could not be found
	*/
	public Material remove(long materialId) throws NoSuchMaterialException;

	public Material updateImpl(Material material);

	/**
	* Returns the material with the primary key or throws a {@link NoSuchMaterialException} if it could not be found.
	*
	* @param materialId the primary key of the material
	* @return the material
	* @throws NoSuchMaterialException if a material with the primary key could not be found
	*/
	public Material findByPrimaryKey(long materialId)
		throws NoSuchMaterialException;

	/**
	* Returns the material with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param materialId the primary key of the material
	* @return the material, or <code>null</code> if a material with the primary key could not be found
	*/
	public Material fetchByPrimaryKey(long materialId);

	@Override
	public java.util.Map<java.io.Serializable, Material> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the materials.
	*
	* @return the materials
	*/
	public java.util.List<Material> findAll();

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
	public java.util.List<Material> findAll(int start, int end);

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
	public java.util.List<Material> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator);

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
	public java.util.List<Material> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Material> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the materials from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of materials.
	*
	* @return the number of materials
	*/
	public int countAll();
}
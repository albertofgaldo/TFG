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

import cat.diba.materialesportiu.model.LocalEntity;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the local entity service. This utility wraps {@link cat.diba.materialesportiu.service.persistence.impl.LocalEntityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalEntityPersistence
 * @see cat.diba.materialesportiu.service.persistence.impl.LocalEntityPersistenceImpl
 * @generated
 */
@ProviderType
public class LocalEntityUtil {
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
	public static void clearCache(LocalEntity localEntity) {
		getPersistence().clearCache(localEntity);
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
	public static List<LocalEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LocalEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LocalEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LocalEntity> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LocalEntity update(LocalEntity localEntity) {
		return getPersistence().update(localEntity);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LocalEntity update(LocalEntity localEntity,
		ServiceContext serviceContext) {
		return getPersistence().update(localEntity, serviceContext);
	}

	/**
	* Returns all the local entities where name = &#63;.
	*
	* @param name the name
	* @return the matching local entities
	*/
	public static List<LocalEntity> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	* Returns a range of all the local entities where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of local entities
	* @param end the upper bound of the range of local entities (not inclusive)
	* @return the range of matching local entities
	*/
	public static List<LocalEntity> findByName(String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

	/**
	* Returns an ordered range of all the local entities where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of local entities
	* @param end the upper bound of the range of local entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching local entities
	*/
	public static List<LocalEntity> findByName(String name, int start, int end,
		OrderByComparator<LocalEntity> orderByComparator) {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the local entities where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of local entities
	* @param end the upper bound of the range of local entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching local entities
	*/
	public static List<LocalEntity> findByName(String name, int start, int end,
		OrderByComparator<LocalEntity> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByName(name, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first local entity in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local entity
	* @throws NoSuchLocalEntityException if a matching local entity could not be found
	*/
	public static LocalEntity findByName_First(String name,
		OrderByComparator<LocalEntity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLocalEntityException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	* Returns the first local entity in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local entity, or <code>null</code> if a matching local entity could not be found
	*/
	public static LocalEntity fetchByName_First(String name,
		OrderByComparator<LocalEntity> orderByComparator) {
		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	* Returns the last local entity in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local entity
	* @throws NoSuchLocalEntityException if a matching local entity could not be found
	*/
	public static LocalEntity findByName_Last(String name,
		OrderByComparator<LocalEntity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLocalEntityException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	* Returns the last local entity in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local entity, or <code>null</code> if a matching local entity could not be found
	*/
	public static LocalEntity fetchByName_Last(String name,
		OrderByComparator<LocalEntity> orderByComparator) {
		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	* Returns the local entities before and after the current local entity in the ordered set where name = &#63;.
	*
	* @param localEntityId the primary key of the current local entity
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next local entity
	* @throws NoSuchLocalEntityException if a local entity with the primary key could not be found
	*/
	public static LocalEntity[] findByName_PrevAndNext(long localEntityId,
		String name, OrderByComparator<LocalEntity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLocalEntityException {
		return getPersistence()
				   .findByName_PrevAndNext(localEntityId, name,
			orderByComparator);
	}

	/**
	* Removes all the local entities where name = &#63; from the database.
	*
	* @param name the name
	*/
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	* Returns the number of local entities where name = &#63;.
	*
	* @param name the name
	* @return the number of matching local entities
	*/
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	* Returns all the local entities where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching local entities
	*/
	public static List<LocalEntity> findByCompanyGroup(long companyId,
		long groupId) {
		return getPersistence().findByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the local entities where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of local entities
	* @param end the upper bound of the range of local entities (not inclusive)
	* @return the range of matching local entities
	*/
	public static List<LocalEntity> findByCompanyGroup(long companyId,
		long groupId, int start, int end) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the local entities where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of local entities
	* @param end the upper bound of the range of local entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching local entities
	*/
	public static List<LocalEntity> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<LocalEntity> orderByComparator) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the local entities where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of local entities
	* @param end the upper bound of the range of local entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching local entities
	*/
	public static List<LocalEntity> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<LocalEntity> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first local entity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local entity
	* @throws NoSuchLocalEntityException if a matching local entity could not be found
	*/
	public static LocalEntity findByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator<LocalEntity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLocalEntityException {
		return getPersistence()
				   .findByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first local entity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local entity, or <code>null</code> if a matching local entity could not be found
	*/
	public static LocalEntity fetchByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator<LocalEntity> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last local entity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local entity
	* @throws NoSuchLocalEntityException if a matching local entity could not be found
	*/
	public static LocalEntity findByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator<LocalEntity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLocalEntityException {
		return getPersistence()
				   .findByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last local entity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local entity, or <code>null</code> if a matching local entity could not be found
	*/
	public static LocalEntity fetchByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator<LocalEntity> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the local entities before and after the current local entity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param localEntityId the primary key of the current local entity
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next local entity
	* @throws NoSuchLocalEntityException if a local entity with the primary key could not be found
	*/
	public static LocalEntity[] findByCompanyGroup_PrevAndNext(
		long localEntityId, long companyId, long groupId,
		OrderByComparator<LocalEntity> orderByComparator)
		throws cat.diba.materialesportiu.exception.NoSuchLocalEntityException {
		return getPersistence()
				   .findByCompanyGroup_PrevAndNext(localEntityId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the local entities where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public static void removeByCompanyGroup(long companyId, long groupId) {
		getPersistence().removeByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns the number of local entities where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching local entities
	*/
	public static int countByCompanyGroup(long companyId, long groupId) {
		return getPersistence().countByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns the local entity where cif = &#63; or throws a {@link NoSuchLocalEntityException} if it could not be found.
	*
	* @param cif the cif
	* @return the matching local entity
	* @throws NoSuchLocalEntityException if a matching local entity could not be found
	*/
	public static LocalEntity findByCif(String cif)
		throws cat.diba.materialesportiu.exception.NoSuchLocalEntityException {
		return getPersistence().findByCif(cif);
	}

	/**
	* Returns the local entity where cif = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cif the cif
	* @return the matching local entity, or <code>null</code> if a matching local entity could not be found
	*/
	public static LocalEntity fetchByCif(String cif) {
		return getPersistence().fetchByCif(cif);
	}

	/**
	* Returns the local entity where cif = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cif the cif
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching local entity, or <code>null</code> if a matching local entity could not be found
	*/
	public static LocalEntity fetchByCif(String cif, boolean retrieveFromCache) {
		return getPersistence().fetchByCif(cif, retrieveFromCache);
	}

	/**
	* Removes the local entity where cif = &#63; from the database.
	*
	* @param cif the cif
	* @return the local entity that was removed
	*/
	public static LocalEntity removeByCif(String cif)
		throws cat.diba.materialesportiu.exception.NoSuchLocalEntityException {
		return getPersistence().removeByCif(cif);
	}

	/**
	* Returns the number of local entities where cif = &#63;.
	*
	* @param cif the cif
	* @return the number of matching local entities
	*/
	public static int countByCif(String cif) {
		return getPersistence().countByCif(cif);
	}

	/**
	* Caches the local entity in the entity cache if it is enabled.
	*
	* @param localEntity the local entity
	*/
	public static void cacheResult(LocalEntity localEntity) {
		getPersistence().cacheResult(localEntity);
	}

	/**
	* Caches the local entities in the entity cache if it is enabled.
	*
	* @param localEntities the local entities
	*/
	public static void cacheResult(List<LocalEntity> localEntities) {
		getPersistence().cacheResult(localEntities);
	}

	/**
	* Creates a new local entity with the primary key. Does not add the local entity to the database.
	*
	* @param localEntityId the primary key for the new local entity
	* @return the new local entity
	*/
	public static LocalEntity create(long localEntityId) {
		return getPersistence().create(localEntityId);
	}

	/**
	* Removes the local entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param localEntityId the primary key of the local entity
	* @return the local entity that was removed
	* @throws NoSuchLocalEntityException if a local entity with the primary key could not be found
	*/
	public static LocalEntity remove(long localEntityId)
		throws cat.diba.materialesportiu.exception.NoSuchLocalEntityException {
		return getPersistence().remove(localEntityId);
	}

	public static LocalEntity updateImpl(LocalEntity localEntity) {
		return getPersistence().updateImpl(localEntity);
	}

	/**
	* Returns the local entity with the primary key or throws a {@link NoSuchLocalEntityException} if it could not be found.
	*
	* @param localEntityId the primary key of the local entity
	* @return the local entity
	* @throws NoSuchLocalEntityException if a local entity with the primary key could not be found
	*/
	public static LocalEntity findByPrimaryKey(long localEntityId)
		throws cat.diba.materialesportiu.exception.NoSuchLocalEntityException {
		return getPersistence().findByPrimaryKey(localEntityId);
	}

	/**
	* Returns the local entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param localEntityId the primary key of the local entity
	* @return the local entity, or <code>null</code> if a local entity with the primary key could not be found
	*/
	public static LocalEntity fetchByPrimaryKey(long localEntityId) {
		return getPersistence().fetchByPrimaryKey(localEntityId);
	}

	public static java.util.Map<java.io.Serializable, LocalEntity> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the local entities.
	*
	* @return the local entities
	*/
	public static List<LocalEntity> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the local entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local entities
	* @param end the upper bound of the range of local entities (not inclusive)
	* @return the range of local entities
	*/
	public static List<LocalEntity> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the local entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local entities
	* @param end the upper bound of the range of local entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of local entities
	*/
	public static List<LocalEntity> findAll(int start, int end,
		OrderByComparator<LocalEntity> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the local entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local entities
	* @param end the upper bound of the range of local entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of local entities
	*/
	public static List<LocalEntity> findAll(int start, int end,
		OrderByComparator<LocalEntity> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the local entities from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of local entities.
	*
	* @return the number of local entities
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LocalEntityPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LocalEntityPersistence, LocalEntityPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LocalEntityPersistence.class);

		ServiceTracker<LocalEntityPersistence, LocalEntityPersistence> serviceTracker =
			new ServiceTracker<LocalEntityPersistence, LocalEntityPersistence>(bundle.getBundleContext(),
				LocalEntityPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
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

import cat.diba.materialesportiu.exception.NoSuchLocalEntityException;
import cat.diba.materialesportiu.model.LocalEntity;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the local entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see cat.diba.materialesportiu.service.persistence.impl.LocalEntityPersistenceImpl
 * @see LocalEntityUtil
 * @generated
 */
@ProviderType
public interface LocalEntityPersistence extends BasePersistence<LocalEntity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LocalEntityUtil} to access the local entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the local entities where name = &#63;.
	*
	* @param name the name
	* @return the matching local entities
	*/
	public java.util.List<LocalEntity> findByName(String name);

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
	public java.util.List<LocalEntity> findByName(String name, int start,
		int end);

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
	public java.util.List<LocalEntity> findByName(String name, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalEntity> orderByComparator);

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
	public java.util.List<LocalEntity> findByName(String name, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalEntity> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first local entity in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local entity
	* @throws NoSuchLocalEntityException if a matching local entity could not be found
	*/
	public LocalEntity findByName_First(String name,
		com.liferay.portal.kernel.util.OrderByComparator<LocalEntity> orderByComparator)
		throws NoSuchLocalEntityException;

	/**
	* Returns the first local entity in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local entity, or <code>null</code> if a matching local entity could not be found
	*/
	public LocalEntity fetchByName_First(String name,
		com.liferay.portal.kernel.util.OrderByComparator<LocalEntity> orderByComparator);

	/**
	* Returns the last local entity in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local entity
	* @throws NoSuchLocalEntityException if a matching local entity could not be found
	*/
	public LocalEntity findByName_Last(String name,
		com.liferay.portal.kernel.util.OrderByComparator<LocalEntity> orderByComparator)
		throws NoSuchLocalEntityException;

	/**
	* Returns the last local entity in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local entity, or <code>null</code> if a matching local entity could not be found
	*/
	public LocalEntity fetchByName_Last(String name,
		com.liferay.portal.kernel.util.OrderByComparator<LocalEntity> orderByComparator);

	/**
	* Returns the local entities before and after the current local entity in the ordered set where name = &#63;.
	*
	* @param localEntityId the primary key of the current local entity
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next local entity
	* @throws NoSuchLocalEntityException if a local entity with the primary key could not be found
	*/
	public LocalEntity[] findByName_PrevAndNext(long localEntityId,
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<LocalEntity> orderByComparator)
		throws NoSuchLocalEntityException;

	/**
	* Removes all the local entities where name = &#63; from the database.
	*
	* @param name the name
	*/
	public void removeByName(String name);

	/**
	* Returns the number of local entities where name = &#63;.
	*
	* @param name the name
	* @return the number of matching local entities
	*/
	public int countByName(String name);

	/**
	* Returns all the local entities where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching local entities
	*/
	public java.util.List<LocalEntity> findByCompanyGroup(long companyId,
		long groupId);

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
	public java.util.List<LocalEntity> findByCompanyGroup(long companyId,
		long groupId, int start, int end);

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
	public java.util.List<LocalEntity> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalEntity> orderByComparator);

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
	public java.util.List<LocalEntity> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalEntity> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first local entity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local entity
	* @throws NoSuchLocalEntityException if a matching local entity could not be found
	*/
	public LocalEntity findByCompanyGroup_First(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LocalEntity> orderByComparator)
		throws NoSuchLocalEntityException;

	/**
	* Returns the first local entity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local entity, or <code>null</code> if a matching local entity could not be found
	*/
	public LocalEntity fetchByCompanyGroup_First(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LocalEntity> orderByComparator);

	/**
	* Returns the last local entity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local entity
	* @throws NoSuchLocalEntityException if a matching local entity could not be found
	*/
	public LocalEntity findByCompanyGroup_Last(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LocalEntity> orderByComparator)
		throws NoSuchLocalEntityException;

	/**
	* Returns the last local entity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local entity, or <code>null</code> if a matching local entity could not be found
	*/
	public LocalEntity fetchByCompanyGroup_Last(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LocalEntity> orderByComparator);

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
	public LocalEntity[] findByCompanyGroup_PrevAndNext(long localEntityId,
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LocalEntity> orderByComparator)
		throws NoSuchLocalEntityException;

	/**
	* Removes all the local entities where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public void removeByCompanyGroup(long companyId, long groupId);

	/**
	* Returns the number of local entities where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching local entities
	*/
	public int countByCompanyGroup(long companyId, long groupId);

	/**
	* Returns the local entity where cif = &#63; or throws a {@link NoSuchLocalEntityException} if it could not be found.
	*
	* @param cif the cif
	* @return the matching local entity
	* @throws NoSuchLocalEntityException if a matching local entity could not be found
	*/
	public LocalEntity findByCif(String cif) throws NoSuchLocalEntityException;

	/**
	* Returns the local entity where cif = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cif the cif
	* @return the matching local entity, or <code>null</code> if a matching local entity could not be found
	*/
	public LocalEntity fetchByCif(String cif);

	/**
	* Returns the local entity where cif = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cif the cif
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching local entity, or <code>null</code> if a matching local entity could not be found
	*/
	public LocalEntity fetchByCif(String cif, boolean retrieveFromCache);

	/**
	* Removes the local entity where cif = &#63; from the database.
	*
	* @param cif the cif
	* @return the local entity that was removed
	*/
	public LocalEntity removeByCif(String cif)
		throws NoSuchLocalEntityException;

	/**
	* Returns the number of local entities where cif = &#63;.
	*
	* @param cif the cif
	* @return the number of matching local entities
	*/
	public int countByCif(String cif);

	/**
	* Caches the local entity in the entity cache if it is enabled.
	*
	* @param localEntity the local entity
	*/
	public void cacheResult(LocalEntity localEntity);

	/**
	* Caches the local entities in the entity cache if it is enabled.
	*
	* @param localEntities the local entities
	*/
	public void cacheResult(java.util.List<LocalEntity> localEntities);

	/**
	* Creates a new local entity with the primary key. Does not add the local entity to the database.
	*
	* @param localEntityId the primary key for the new local entity
	* @return the new local entity
	*/
	public LocalEntity create(long localEntityId);

	/**
	* Removes the local entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param localEntityId the primary key of the local entity
	* @return the local entity that was removed
	* @throws NoSuchLocalEntityException if a local entity with the primary key could not be found
	*/
	public LocalEntity remove(long localEntityId)
		throws NoSuchLocalEntityException;

	public LocalEntity updateImpl(LocalEntity localEntity);

	/**
	* Returns the local entity with the primary key or throws a {@link NoSuchLocalEntityException} if it could not be found.
	*
	* @param localEntityId the primary key of the local entity
	* @return the local entity
	* @throws NoSuchLocalEntityException if a local entity with the primary key could not be found
	*/
	public LocalEntity findByPrimaryKey(long localEntityId)
		throws NoSuchLocalEntityException;

	/**
	* Returns the local entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param localEntityId the primary key of the local entity
	* @return the local entity, or <code>null</code> if a local entity with the primary key could not be found
	*/
	public LocalEntity fetchByPrimaryKey(long localEntityId);

	@Override
	public java.util.Map<java.io.Serializable, LocalEntity> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the local entities.
	*
	* @return the local entities
	*/
	public java.util.List<LocalEntity> findAll();

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
	public java.util.List<LocalEntity> findAll(int start, int end);

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
	public java.util.List<LocalEntity> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalEntity> orderByComparator);

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
	public java.util.List<LocalEntity> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalEntity> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the local entities from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of local entities.
	*
	* @return the number of local entities
	*/
	public int countAll();
}
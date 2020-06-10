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

package cat.diba.materialesportiu.service.impl;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import cat.diba.materialesportiu.exception.NoSuchMaterialException;
import cat.diba.materialesportiu.model.Material;
import cat.diba.materialesportiu.service.base.MaterialLocalServiceBaseImpl;

/**
 * The implementation of the material local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cat.diba.materialesportiu.service.MaterialLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MaterialLocalServiceBaseImpl
 * @see cat.diba.materialesportiu.service.MaterialLocalServiceUtil
 */
public class MaterialLocalServiceImpl extends MaterialLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link cat.diba.materialesportiu.service.MaterialLocalServiceUtil} to access the material local service.
	 */
	public Material addMaterial(Material material)throws SystemException {
		CounterLocalService counterLocalService = getCounterLocalService();
		material.setMaterialId(counterLocalService.increment());
		return super.addMaterial(material);
	}
	
	public Material getMaterialById(long materialId)throws SystemException, NoSuchMaterialException{
		return getMaterialPersistence().findByMaterialId(materialId);
	}
	
	public Material updateMaterial(Material material)throws SystemException{
		return super.updateMaterial(material);
	}
	
	public List<Material> getMaterialByCompanyGroup(long companyId, long groupId, int start, int end, OrderByComparator<Material> obc) throws SystemException{
		return getMaterialPersistence().findByCompanyGroup(companyId, groupId, start, end, obc);
	}
	
	public List<Material> getMaterialByCompanyGroupActivityId(long companyId, long groupId, int start, int end, OrderByComparator<Material> obc, long activityId) throws SystemException{
		return getMaterialPersistence().findByCompanyGroupActivityId(companyId, groupId, activityId, start, end, obc);
	}
	
	public int getCountByCompanyGroup(long companyId, long groupId)throws SystemException{
		return getMaterialPersistence().countByCompanyGroup(companyId, groupId);
	}
	
	public int getCountByCompanyGroupByActivityId(long companyId, long groupId, long activityId)throws SystemException{
		return getMaterialPersistence().countByCompanyGroupActivityId(companyId, groupId, activityId);
	}

	public List<Material> getMaterialByCompanyGroup(long companyId, long groupId) throws SystemException{
		return getMaterialPersistence().findByCompanyGroup(companyId, groupId);
	}
	
	public List<Material> getMaterialbyActivityId(long activityId) throws SystemException{
		return getMaterialPersistence().findByActivityId(activityId);
	}
	
}
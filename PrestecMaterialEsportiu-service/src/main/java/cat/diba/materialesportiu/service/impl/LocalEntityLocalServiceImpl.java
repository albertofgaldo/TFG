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

import cat.diba.materialesportiu.exception.NoSuchLocalEntityException;
import cat.diba.materialesportiu.model.LocalEntity;
import cat.diba.materialesportiu.service.base.LocalEntityLocalServiceBaseImpl;

/**
 * The implementation of the local entity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cat.diba.materialesportiu.service.LocalEntityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalEntityLocalServiceBaseImpl
 * @see cat.diba.materialesportiu.service.LocalEntityLocalServiceUtil
 */
public class LocalEntityLocalServiceImpl extends LocalEntityLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link cat.diba.materialesportiu.service.LocalEntityLocalServiceUtil} to access the local entity local service.
	 */
	public LocalEntity addLocalEntity(LocalEntity localEntity)throws SystemException{
		CounterLocalService counterLocalService = getCounterLocalService();
		localEntity.setLocalEntityId(counterLocalService.increment());
		return super.addLocalEntity(localEntity);		
	}
	
	public List<LocalEntity> getLocalEntityByName(String name, int start, int end)throws SystemException{
		return getLocalEntityPersistence().findByName(name, start, end);
	}
	
	public List<LocalEntity> getLocalEntityByCompanyGroup(long companyId, long groupId, int start, int end, OrderByComparator<LocalEntity> obc) throws SystemException{
		return getLocalEntityPersistence().findByCompanyGroup(companyId, groupId, start, end, obc);
	}
	
	public List<LocalEntity> getLocalEntityByCompanyGroup(long companyId, long groupId) throws SystemException{
		return getLocalEntityPersistence().findByCompanyGroup(companyId, groupId);
	}
	
	public int getCountByCompanyGroup(long companyId, long groupId)throws SystemException{
		return getLocalEntityPersistence().countByCompanyGroup(companyId, groupId);
	}

	public boolean checkCif(String cif) {
		boolean exist=false;
		try {
			if(getLocalEntityPersistence().findByCif(cif) != null) {
				exist= true;
			}
		} catch (NoSuchLocalEntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			exist=false;
		}
		return exist;
	}
	public LocalEntity getLocalEntityByCif(String cif) throws NoSuchLocalEntityException {
		return getLocalEntityPersistence().findByCif(cif);
	}
}
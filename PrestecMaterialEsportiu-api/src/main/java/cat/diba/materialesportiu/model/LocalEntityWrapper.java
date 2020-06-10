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

package cat.diba.materialesportiu.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link LocalEntity}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalEntity
 * @generated
 */
@ProviderType
public class LocalEntityWrapper implements LocalEntity,
	ModelWrapper<LocalEntity> {
	public LocalEntityWrapper(LocalEntity localEntity) {
		_localEntity = localEntity;
	}

	@Override
	public Class<?> getModelClass() {
		return LocalEntity.class;
	}

	@Override
	public String getModelClassName() {
		return LocalEntity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("localEntityId", getLocalEntityId());
		attributes.put("cif", getCif());
		attributes.put("name", getName());
		attributes.put("telephone", getTelephone());
		attributes.put("email", getEmail());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long localEntityId = (Long)attributes.get("localEntityId");

		if (localEntityId != null) {
			setLocalEntityId(localEntityId);
		}

		String cif = (String)attributes.get("cif");

		if (cif != null) {
			setCif(cif);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String telephone = (String)attributes.get("telephone");

		if (telephone != null) {
			setTelephone(telephone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Object clone() {
		return new LocalEntityWrapper((LocalEntity)_localEntity.clone());
	}

	@Override
	public int compareTo(LocalEntity localEntity) {
		return _localEntity.compareTo(localEntity);
	}

	/**
	* Returns the cif of this local entity.
	*
	* @return the cif of this local entity
	*/
	@Override
	public String getCif() {
		return _localEntity.getCif();
	}

	/**
	* Returns the company ID of this local entity.
	*
	* @return the company ID of this local entity
	*/
	@Override
	public long getCompanyId() {
		return _localEntity.getCompanyId();
	}

	/**
	* Returns the create date of this local entity.
	*
	* @return the create date of this local entity
	*/
	@Override
	public Date getCreateDate() {
		return _localEntity.getCreateDate();
	}

	/**
	* Returns the email of this local entity.
	*
	* @return the email of this local entity
	*/
	@Override
	public String getEmail() {
		return _localEntity.getEmail();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _localEntity.getExpandoBridge();
	}

	/**
	* Returns the group ID of this local entity.
	*
	* @return the group ID of this local entity
	*/
	@Override
	public long getGroupId() {
		return _localEntity.getGroupId();
	}

	/**
	* Returns the local entity ID of this local entity.
	*
	* @return the local entity ID of this local entity
	*/
	@Override
	public long getLocalEntityId() {
		return _localEntity.getLocalEntityId();
	}

	/**
	* Returns the modified date of this local entity.
	*
	* @return the modified date of this local entity
	*/
	@Override
	public Date getModifiedDate() {
		return _localEntity.getModifiedDate();
	}

	/**
	* Returns the name of this local entity.
	*
	* @return the name of this local entity
	*/
	@Override
	public String getName() {
		return _localEntity.getName();
	}

	/**
	* Returns the primary key of this local entity.
	*
	* @return the primary key of this local entity
	*/
	@Override
	public long getPrimaryKey() {
		return _localEntity.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _localEntity.getPrimaryKeyObj();
	}

	/**
	* Returns the telephone of this local entity.
	*
	* @return the telephone of this local entity
	*/
	@Override
	public String getTelephone() {
		return _localEntity.getTelephone();
	}

	/**
	* Returns the user ID of this local entity.
	*
	* @return the user ID of this local entity
	*/
	@Override
	public long getUserId() {
		return _localEntity.getUserId();
	}

	/**
	* Returns the user name of this local entity.
	*
	* @return the user name of this local entity
	*/
	@Override
	public String getUserName() {
		return _localEntity.getUserName();
	}

	/**
	* Returns the user uuid of this local entity.
	*
	* @return the user uuid of this local entity
	*/
	@Override
	public String getUserUuid() {
		return _localEntity.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _localEntity.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _localEntity.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _localEntity.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _localEntity.isNew();
	}

	@Override
	public void persist() {
		_localEntity.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_localEntity.setCachedModel(cachedModel);
	}

	/**
	* Sets the cif of this local entity.
	*
	* @param cif the cif of this local entity
	*/
	@Override
	public void setCif(String cif) {
		_localEntity.setCif(cif);
	}

	/**
	* Sets the company ID of this local entity.
	*
	* @param companyId the company ID of this local entity
	*/
	@Override
	public void setCompanyId(long companyId) {
		_localEntity.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this local entity.
	*
	* @param createDate the create date of this local entity
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_localEntity.setCreateDate(createDate);
	}

	/**
	* Sets the email of this local entity.
	*
	* @param email the email of this local entity
	*/
	@Override
	public void setEmail(String email) {
		_localEntity.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_localEntity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_localEntity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_localEntity.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this local entity.
	*
	* @param groupId the group ID of this local entity
	*/
	@Override
	public void setGroupId(long groupId) {
		_localEntity.setGroupId(groupId);
	}

	/**
	* Sets the local entity ID of this local entity.
	*
	* @param localEntityId the local entity ID of this local entity
	*/
	@Override
	public void setLocalEntityId(long localEntityId) {
		_localEntity.setLocalEntityId(localEntityId);
	}

	/**
	* Sets the modified date of this local entity.
	*
	* @param modifiedDate the modified date of this local entity
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_localEntity.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this local entity.
	*
	* @param name the name of this local entity
	*/
	@Override
	public void setName(String name) {
		_localEntity.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_localEntity.setNew(n);
	}

	/**
	* Sets the primary key of this local entity.
	*
	* @param primaryKey the primary key of this local entity
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_localEntity.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_localEntity.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the telephone of this local entity.
	*
	* @param telephone the telephone of this local entity
	*/
	@Override
	public void setTelephone(String telephone) {
		_localEntity.setTelephone(telephone);
	}

	/**
	* Sets the user ID of this local entity.
	*
	* @param userId the user ID of this local entity
	*/
	@Override
	public void setUserId(long userId) {
		_localEntity.setUserId(userId);
	}

	/**
	* Sets the user name of this local entity.
	*
	* @param userName the user name of this local entity
	*/
	@Override
	public void setUserName(String userName) {
		_localEntity.setUserName(userName);
	}

	/**
	* Sets the user uuid of this local entity.
	*
	* @param userUuid the user uuid of this local entity
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_localEntity.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LocalEntity> toCacheModel() {
		return _localEntity.toCacheModel();
	}

	@Override
	public LocalEntity toEscapedModel() {
		return new LocalEntityWrapper(_localEntity.toEscapedModel());
	}

	@Override
	public String toString() {
		return _localEntity.toString();
	}

	@Override
	public LocalEntity toUnescapedModel() {
		return new LocalEntityWrapper(_localEntity.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _localEntity.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LocalEntityWrapper)) {
			return false;
		}

		LocalEntityWrapper localEntityWrapper = (LocalEntityWrapper)obj;

		if (Objects.equals(_localEntity, localEntityWrapper._localEntity)) {
			return true;
		}

		return false;
	}

	@Override
	public LocalEntity getWrappedModel() {
		return _localEntity;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _localEntity.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _localEntity.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_localEntity.resetOriginalValues();
	}

	private final LocalEntity _localEntity;
}
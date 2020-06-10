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
 * This class is a wrapper for {@link ActivityDependsOn}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityDependsOn
 * @generated
 */
@ProviderType
public class ActivityDependsOnWrapper implements ActivityDependsOn,
	ModelWrapper<ActivityDependsOn> {
	public ActivityDependsOnWrapper(ActivityDependsOn activityDependsOn) {
		_activityDependsOn = activityDependsOn;
	}

	@Override
	public Class<?> getModelClass() {
		return ActivityDependsOn.class;
	}

	@Override
	public String getModelClassName() {
		return ActivityDependsOn.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("activityDependsOnId", getActivityDependsOnId());
		attributes.put("activityId", getActivityId());
		attributes.put("parentActivityId", getParentActivityId());
		attributes.put("quantity", getQuantity());
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
		Long activityDependsOnId = (Long)attributes.get("activityDependsOnId");

		if (activityDependsOnId != null) {
			setActivityDependsOnId(activityDependsOnId);
		}

		Long activityId = (Long)attributes.get("activityId");

		if (activityId != null) {
			setActivityId(activityId);
		}

		Long parentActivityId = (Long)attributes.get("parentActivityId");

		if (parentActivityId != null) {
			setParentActivityId(parentActivityId);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
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
		return new ActivityDependsOnWrapper((ActivityDependsOn)_activityDependsOn.clone());
	}

	@Override
	public int compareTo(ActivityDependsOn activityDependsOn) {
		return _activityDependsOn.compareTo(activityDependsOn);
	}

	/**
	* Returns the activity depends on ID of this activity depends on.
	*
	* @return the activity depends on ID of this activity depends on
	*/
	@Override
	public long getActivityDependsOnId() {
		return _activityDependsOn.getActivityDependsOnId();
	}

	/**
	* Returns the activity ID of this activity depends on.
	*
	* @return the activity ID of this activity depends on
	*/
	@Override
	public long getActivityId() {
		return _activityDependsOn.getActivityId();
	}

	/**
	* Returns the company ID of this activity depends on.
	*
	* @return the company ID of this activity depends on
	*/
	@Override
	public long getCompanyId() {
		return _activityDependsOn.getCompanyId();
	}

	/**
	* Returns the create date of this activity depends on.
	*
	* @return the create date of this activity depends on
	*/
	@Override
	public Date getCreateDate() {
		return _activityDependsOn.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _activityDependsOn.getExpandoBridge();
	}

	/**
	* Returns the group ID of this activity depends on.
	*
	* @return the group ID of this activity depends on
	*/
	@Override
	public long getGroupId() {
		return _activityDependsOn.getGroupId();
	}

	/**
	* Returns the modified date of this activity depends on.
	*
	* @return the modified date of this activity depends on
	*/
	@Override
	public Date getModifiedDate() {
		return _activityDependsOn.getModifiedDate();
	}

	/**
	* Returns the parent activity ID of this activity depends on.
	*
	* @return the parent activity ID of this activity depends on
	*/
	@Override
	public long getParentActivityId() {
		return _activityDependsOn.getParentActivityId();
	}

	/**
	* Returns the primary key of this activity depends on.
	*
	* @return the primary key of this activity depends on
	*/
	@Override
	public long getPrimaryKey() {
		return _activityDependsOn.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _activityDependsOn.getPrimaryKeyObj();
	}

	/**
	* Returns the quantity of this activity depends on.
	*
	* @return the quantity of this activity depends on
	*/
	@Override
	public int getQuantity() {
		return _activityDependsOn.getQuantity();
	}

	/**
	* Returns the user ID of this activity depends on.
	*
	* @return the user ID of this activity depends on
	*/
	@Override
	public long getUserId() {
		return _activityDependsOn.getUserId();
	}

	/**
	* Returns the user name of this activity depends on.
	*
	* @return the user name of this activity depends on
	*/
	@Override
	public String getUserName() {
		return _activityDependsOn.getUserName();
	}

	/**
	* Returns the user uuid of this activity depends on.
	*
	* @return the user uuid of this activity depends on
	*/
	@Override
	public String getUserUuid() {
		return _activityDependsOn.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _activityDependsOn.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _activityDependsOn.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _activityDependsOn.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _activityDependsOn.isNew();
	}

	@Override
	public void persist() {
		_activityDependsOn.persist();
	}

	/**
	* Sets the activity depends on ID of this activity depends on.
	*
	* @param activityDependsOnId the activity depends on ID of this activity depends on
	*/
	@Override
	public void setActivityDependsOnId(long activityDependsOnId) {
		_activityDependsOn.setActivityDependsOnId(activityDependsOnId);
	}

	/**
	* Sets the activity ID of this activity depends on.
	*
	* @param activityId the activity ID of this activity depends on
	*/
	@Override
	public void setActivityId(long activityId) {
		_activityDependsOn.setActivityId(activityId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_activityDependsOn.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this activity depends on.
	*
	* @param companyId the company ID of this activity depends on
	*/
	@Override
	public void setCompanyId(long companyId) {
		_activityDependsOn.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this activity depends on.
	*
	* @param createDate the create date of this activity depends on
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_activityDependsOn.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_activityDependsOn.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_activityDependsOn.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_activityDependsOn.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this activity depends on.
	*
	* @param groupId the group ID of this activity depends on
	*/
	@Override
	public void setGroupId(long groupId) {
		_activityDependsOn.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this activity depends on.
	*
	* @param modifiedDate the modified date of this activity depends on
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_activityDependsOn.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_activityDependsOn.setNew(n);
	}

	/**
	* Sets the parent activity ID of this activity depends on.
	*
	* @param parentActivityId the parent activity ID of this activity depends on
	*/
	@Override
	public void setParentActivityId(long parentActivityId) {
		_activityDependsOn.setParentActivityId(parentActivityId);
	}

	/**
	* Sets the primary key of this activity depends on.
	*
	* @param primaryKey the primary key of this activity depends on
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_activityDependsOn.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_activityDependsOn.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the quantity of this activity depends on.
	*
	* @param quantity the quantity of this activity depends on
	*/
	@Override
	public void setQuantity(int quantity) {
		_activityDependsOn.setQuantity(quantity);
	}

	/**
	* Sets the user ID of this activity depends on.
	*
	* @param userId the user ID of this activity depends on
	*/
	@Override
	public void setUserId(long userId) {
		_activityDependsOn.setUserId(userId);
	}

	/**
	* Sets the user name of this activity depends on.
	*
	* @param userName the user name of this activity depends on
	*/
	@Override
	public void setUserName(String userName) {
		_activityDependsOn.setUserName(userName);
	}

	/**
	* Sets the user uuid of this activity depends on.
	*
	* @param userUuid the user uuid of this activity depends on
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_activityDependsOn.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ActivityDependsOn> toCacheModel() {
		return _activityDependsOn.toCacheModel();
	}

	@Override
	public ActivityDependsOn toEscapedModel() {
		return new ActivityDependsOnWrapper(_activityDependsOn.toEscapedModel());
	}

	@Override
	public String toString() {
		return _activityDependsOn.toString();
	}

	@Override
	public ActivityDependsOn toUnescapedModel() {
		return new ActivityDependsOnWrapper(_activityDependsOn.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _activityDependsOn.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ActivityDependsOnWrapper)) {
			return false;
		}

		ActivityDependsOnWrapper activityDependsOnWrapper = (ActivityDependsOnWrapper)obj;

		if (Objects.equals(_activityDependsOn,
					activityDependsOnWrapper._activityDependsOn)) {
			return true;
		}

		return false;
	}

	@Override
	public ActivityDependsOn getWrappedModel() {
		return _activityDependsOn;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _activityDependsOn.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _activityDependsOn.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_activityDependsOn.resetOriginalValues();
	}

	private final ActivityDependsOn _activityDependsOn;
}
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
 * This class is a wrapper for {@link Maintenance}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Maintenance
 * @generated
 */
@ProviderType
public class MaintenanceWrapper implements Maintenance,
	ModelWrapper<Maintenance> {
	public MaintenanceWrapper(Maintenance maintenance) {
		_maintenance = maintenance;
	}

	@Override
	public Class<?> getModelClass() {
		return Maintenance.class;
	}

	@Override
	public String getModelClassName() {
		return Maintenance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("maintenanceId", getMaintenanceId());
		attributes.put("activityId", getActivityId());
		attributes.put("label", getLabel());
		attributes.put("description", getDescription());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("isDone", getIsDone());
		attributes.put("loanId", getLoanId());
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
		Long maintenanceId = (Long)attributes.get("maintenanceId");

		if (maintenanceId != null) {
			setMaintenanceId(maintenanceId);
		}

		Long activityId = (Long)attributes.get("activityId");

		if (activityId != null) {
			setActivityId(activityId);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Boolean isDone = (Boolean)attributes.get("isDone");

		if (isDone != null) {
			setIsDone(isDone);
		}

		Long loanId = (Long)attributes.get("loanId");

		if (loanId != null) {
			setLoanId(loanId);
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
		return new MaintenanceWrapper((Maintenance)_maintenance.clone());
	}

	@Override
	public int compareTo(Maintenance maintenance) {
		return _maintenance.compareTo(maintenance);
	}

	/**
	* Returns the activity ID of this maintenance.
	*
	* @return the activity ID of this maintenance
	*/
	@Override
	public long getActivityId() {
		return _maintenance.getActivityId();
	}

	/**
	* Returns the company ID of this maintenance.
	*
	* @return the company ID of this maintenance
	*/
	@Override
	public long getCompanyId() {
		return _maintenance.getCompanyId();
	}

	/**
	* Returns the create date of this maintenance.
	*
	* @return the create date of this maintenance
	*/
	@Override
	public Date getCreateDate() {
		return _maintenance.getCreateDate();
	}

	/**
	* Returns the description of this maintenance.
	*
	* @return the description of this maintenance
	*/
	@Override
	public String getDescription() {
		return _maintenance.getDescription();
	}

	/**
	* Returns the end date of this maintenance.
	*
	* @return the end date of this maintenance
	*/
	@Override
	public Date getEndDate() {
		return _maintenance.getEndDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _maintenance.getExpandoBridge();
	}

	/**
	* Returns the group ID of this maintenance.
	*
	* @return the group ID of this maintenance
	*/
	@Override
	public long getGroupId() {
		return _maintenance.getGroupId();
	}

	/**
	* Returns the is done of this maintenance.
	*
	* @return the is done of this maintenance
	*/
	@Override
	public Boolean getIsDone() {
		return _maintenance.getIsDone();
	}

	/**
	* Returns the label of this maintenance.
	*
	* @return the label of this maintenance
	*/
	@Override
	public String getLabel() {
		return _maintenance.getLabel();
	}

	/**
	* Returns the loan ID of this maintenance.
	*
	* @return the loan ID of this maintenance
	*/
	@Override
	public long getLoanId() {
		return _maintenance.getLoanId();
	}

	/**
	* Returns the maintenance ID of this maintenance.
	*
	* @return the maintenance ID of this maintenance
	*/
	@Override
	public long getMaintenanceId() {
		return _maintenance.getMaintenanceId();
	}

	/**
	* Returns the modified date of this maintenance.
	*
	* @return the modified date of this maintenance
	*/
	@Override
	public Date getModifiedDate() {
		return _maintenance.getModifiedDate();
	}

	/**
	* Returns the primary key of this maintenance.
	*
	* @return the primary key of this maintenance
	*/
	@Override
	public long getPrimaryKey() {
		return _maintenance.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _maintenance.getPrimaryKeyObj();
	}

	/**
	* Returns the start date of this maintenance.
	*
	* @return the start date of this maintenance
	*/
	@Override
	public Date getStartDate() {
		return _maintenance.getStartDate();
	}

	/**
	* Returns the user ID of this maintenance.
	*
	* @return the user ID of this maintenance
	*/
	@Override
	public long getUserId() {
		return _maintenance.getUserId();
	}

	/**
	* Returns the user name of this maintenance.
	*
	* @return the user name of this maintenance
	*/
	@Override
	public String getUserName() {
		return _maintenance.getUserName();
	}

	/**
	* Returns the user uuid of this maintenance.
	*
	* @return the user uuid of this maintenance
	*/
	@Override
	public String getUserUuid() {
		return _maintenance.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _maintenance.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _maintenance.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _maintenance.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _maintenance.isNew();
	}

	@Override
	public void persist() {
		_maintenance.persist();
	}

	/**
	* Sets the activity ID of this maintenance.
	*
	* @param activityId the activity ID of this maintenance
	*/
	@Override
	public void setActivityId(long activityId) {
		_maintenance.setActivityId(activityId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_maintenance.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this maintenance.
	*
	* @param companyId the company ID of this maintenance
	*/
	@Override
	public void setCompanyId(long companyId) {
		_maintenance.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this maintenance.
	*
	* @param createDate the create date of this maintenance
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_maintenance.setCreateDate(createDate);
	}

	/**
	* Sets the description of this maintenance.
	*
	* @param description the description of this maintenance
	*/
	@Override
	public void setDescription(String description) {
		_maintenance.setDescription(description);
	}

	/**
	* Sets the end date of this maintenance.
	*
	* @param endDate the end date of this maintenance
	*/
	@Override
	public void setEndDate(Date endDate) {
		_maintenance.setEndDate(endDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_maintenance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_maintenance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_maintenance.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this maintenance.
	*
	* @param groupId the group ID of this maintenance
	*/
	@Override
	public void setGroupId(long groupId) {
		_maintenance.setGroupId(groupId);
	}

	/**
	* Sets the is done of this maintenance.
	*
	* @param isDone the is done of this maintenance
	*/
	@Override
	public void setIsDone(Boolean isDone) {
		_maintenance.setIsDone(isDone);
	}

	/**
	* Sets the label of this maintenance.
	*
	* @param label the label of this maintenance
	*/
	@Override
	public void setLabel(String label) {
		_maintenance.setLabel(label);
	}

	/**
	* Sets the loan ID of this maintenance.
	*
	* @param loanId the loan ID of this maintenance
	*/
	@Override
	public void setLoanId(long loanId) {
		_maintenance.setLoanId(loanId);
	}

	/**
	* Sets the maintenance ID of this maintenance.
	*
	* @param maintenanceId the maintenance ID of this maintenance
	*/
	@Override
	public void setMaintenanceId(long maintenanceId) {
		_maintenance.setMaintenanceId(maintenanceId);
	}

	/**
	* Sets the modified date of this maintenance.
	*
	* @param modifiedDate the modified date of this maintenance
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_maintenance.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_maintenance.setNew(n);
	}

	/**
	* Sets the primary key of this maintenance.
	*
	* @param primaryKey the primary key of this maintenance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_maintenance.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_maintenance.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the start date of this maintenance.
	*
	* @param startDate the start date of this maintenance
	*/
	@Override
	public void setStartDate(Date startDate) {
		_maintenance.setStartDate(startDate);
	}

	/**
	* Sets the user ID of this maintenance.
	*
	* @param userId the user ID of this maintenance
	*/
	@Override
	public void setUserId(long userId) {
		_maintenance.setUserId(userId);
	}

	/**
	* Sets the user name of this maintenance.
	*
	* @param userName the user name of this maintenance
	*/
	@Override
	public void setUserName(String userName) {
		_maintenance.setUserName(userName);
	}

	/**
	* Sets the user uuid of this maintenance.
	*
	* @param userUuid the user uuid of this maintenance
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_maintenance.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Maintenance> toCacheModel() {
		return _maintenance.toCacheModel();
	}

	@Override
	public Maintenance toEscapedModel() {
		return new MaintenanceWrapper(_maintenance.toEscapedModel());
	}

	@Override
	public String toString() {
		return _maintenance.toString();
	}

	@Override
	public Maintenance toUnescapedModel() {
		return new MaintenanceWrapper(_maintenance.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _maintenance.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MaintenanceWrapper)) {
			return false;
		}

		MaintenanceWrapper maintenanceWrapper = (MaintenanceWrapper)obj;

		if (Objects.equals(_maintenance, maintenanceWrapper._maintenance)) {
			return true;
		}

		return false;
	}

	@Override
	public Maintenance getWrappedModel() {
		return _maintenance;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _maintenance.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _maintenance.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_maintenance.resetOriginalValues();
	}

	private final Maintenance _maintenance;
}
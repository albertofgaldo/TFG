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
 * This class is a wrapper for {@link LoanActivity}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoanActivity
 * @generated
 */
@ProviderType
public class LoanActivityWrapper implements LoanActivity,
	ModelWrapper<LoanActivity> {
	public LoanActivityWrapper(LoanActivity loanActivity) {
		_loanActivity = loanActivity;
	}

	@Override
	public Class<?> getModelClass() {
		return LoanActivity.class;
	}

	@Override
	public String getModelClassName() {
		return LoanActivity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("loanActivityId", getLoanActivityId());
		attributes.put("loanId", getLoanId());
		attributes.put("activityId", getActivityId());
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
		Long loanActivityId = (Long)attributes.get("loanActivityId");

		if (loanActivityId != null) {
			setLoanActivityId(loanActivityId);
		}

		Long loanId = (Long)attributes.get("loanId");

		if (loanId != null) {
			setLoanId(loanId);
		}

		Long activityId = (Long)attributes.get("activityId");

		if (activityId != null) {
			setActivityId(activityId);
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
		return new LoanActivityWrapper((LoanActivity)_loanActivity.clone());
	}

	@Override
	public int compareTo(LoanActivity loanActivity) {
		return _loanActivity.compareTo(loanActivity);
	}

	/**
	* Returns the activity ID of this loan activity.
	*
	* @return the activity ID of this loan activity
	*/
	@Override
	public long getActivityId() {
		return _loanActivity.getActivityId();
	}

	/**
	* Returns the company ID of this loan activity.
	*
	* @return the company ID of this loan activity
	*/
	@Override
	public long getCompanyId() {
		return _loanActivity.getCompanyId();
	}

	/**
	* Returns the create date of this loan activity.
	*
	* @return the create date of this loan activity
	*/
	@Override
	public Date getCreateDate() {
		return _loanActivity.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _loanActivity.getExpandoBridge();
	}

	/**
	* Returns the group ID of this loan activity.
	*
	* @return the group ID of this loan activity
	*/
	@Override
	public long getGroupId() {
		return _loanActivity.getGroupId();
	}

	/**
	* Returns the loan activity ID of this loan activity.
	*
	* @return the loan activity ID of this loan activity
	*/
	@Override
	public long getLoanActivityId() {
		return _loanActivity.getLoanActivityId();
	}

	/**
	* Returns the loan ID of this loan activity.
	*
	* @return the loan ID of this loan activity
	*/
	@Override
	public long getLoanId() {
		return _loanActivity.getLoanId();
	}

	/**
	* Returns the modified date of this loan activity.
	*
	* @return the modified date of this loan activity
	*/
	@Override
	public Date getModifiedDate() {
		return _loanActivity.getModifiedDate();
	}

	/**
	* Returns the primary key of this loan activity.
	*
	* @return the primary key of this loan activity
	*/
	@Override
	public long getPrimaryKey() {
		return _loanActivity.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _loanActivity.getPrimaryKeyObj();
	}

	/**
	* Returns the quantity of this loan activity.
	*
	* @return the quantity of this loan activity
	*/
	@Override
	public int getQuantity() {
		return _loanActivity.getQuantity();
	}

	/**
	* Returns the user ID of this loan activity.
	*
	* @return the user ID of this loan activity
	*/
	@Override
	public long getUserId() {
		return _loanActivity.getUserId();
	}

	/**
	* Returns the user name of this loan activity.
	*
	* @return the user name of this loan activity
	*/
	@Override
	public String getUserName() {
		return _loanActivity.getUserName();
	}

	/**
	* Returns the user uuid of this loan activity.
	*
	* @return the user uuid of this loan activity
	*/
	@Override
	public String getUserUuid() {
		return _loanActivity.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _loanActivity.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _loanActivity.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _loanActivity.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _loanActivity.isNew();
	}

	@Override
	public void persist() {
		_loanActivity.persist();
	}

	/**
	* Sets the activity ID of this loan activity.
	*
	* @param activityId the activity ID of this loan activity
	*/
	@Override
	public void setActivityId(long activityId) {
		_loanActivity.setActivityId(activityId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_loanActivity.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this loan activity.
	*
	* @param companyId the company ID of this loan activity
	*/
	@Override
	public void setCompanyId(long companyId) {
		_loanActivity.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this loan activity.
	*
	* @param createDate the create date of this loan activity
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_loanActivity.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_loanActivity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_loanActivity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_loanActivity.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this loan activity.
	*
	* @param groupId the group ID of this loan activity
	*/
	@Override
	public void setGroupId(long groupId) {
		_loanActivity.setGroupId(groupId);
	}

	/**
	* Sets the loan activity ID of this loan activity.
	*
	* @param loanActivityId the loan activity ID of this loan activity
	*/
	@Override
	public void setLoanActivityId(long loanActivityId) {
		_loanActivity.setLoanActivityId(loanActivityId);
	}

	/**
	* Sets the loan ID of this loan activity.
	*
	* @param loanId the loan ID of this loan activity
	*/
	@Override
	public void setLoanId(long loanId) {
		_loanActivity.setLoanId(loanId);
	}

	/**
	* Sets the modified date of this loan activity.
	*
	* @param modifiedDate the modified date of this loan activity
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_loanActivity.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_loanActivity.setNew(n);
	}

	/**
	* Sets the primary key of this loan activity.
	*
	* @param primaryKey the primary key of this loan activity
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_loanActivity.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_loanActivity.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the quantity of this loan activity.
	*
	* @param quantity the quantity of this loan activity
	*/
	@Override
	public void setQuantity(int quantity) {
		_loanActivity.setQuantity(quantity);
	}

	/**
	* Sets the user ID of this loan activity.
	*
	* @param userId the user ID of this loan activity
	*/
	@Override
	public void setUserId(long userId) {
		_loanActivity.setUserId(userId);
	}

	/**
	* Sets the user name of this loan activity.
	*
	* @param userName the user name of this loan activity
	*/
	@Override
	public void setUserName(String userName) {
		_loanActivity.setUserName(userName);
	}

	/**
	* Sets the user uuid of this loan activity.
	*
	* @param userUuid the user uuid of this loan activity
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_loanActivity.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LoanActivity> toCacheModel() {
		return _loanActivity.toCacheModel();
	}

	@Override
	public LoanActivity toEscapedModel() {
		return new LoanActivityWrapper(_loanActivity.toEscapedModel());
	}

	@Override
	public String toString() {
		return _loanActivity.toString();
	}

	@Override
	public LoanActivity toUnescapedModel() {
		return new LoanActivityWrapper(_loanActivity.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _loanActivity.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LoanActivityWrapper)) {
			return false;
		}

		LoanActivityWrapper loanActivityWrapper = (LoanActivityWrapper)obj;

		if (Objects.equals(_loanActivity, loanActivityWrapper._loanActivity)) {
			return true;
		}

		return false;
	}

	@Override
	public LoanActivity getWrappedModel() {
		return _loanActivity;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _loanActivity.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _loanActivity.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_loanActivity.resetOriginalValues();
	}

	private final LoanActivity _loanActivity;
}
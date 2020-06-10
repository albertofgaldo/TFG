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
 * This class is a wrapper for {@link Loan}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Loan
 * @generated
 */
@ProviderType
public class LoanWrapper implements Loan, ModelWrapper<Loan> {
	public LoanWrapper(Loan loan) {
		_loan = loan;
	}

	@Override
	public Class<?> getModelClass() {
		return Loan.class;
	}

	@Override
	public String getModelClassName() {
		return Loan.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("loanId", getLoanId());
		attributes.put("localEntityId", getLocalEntityId());
		attributes.put("pickupDate", getPickupDate());
		attributes.put("returnDate", getReturnDate());
		attributes.put("activityDate", getActivityDate());
		attributes.put("activityName", getActivityName());
		attributes.put("participantsNum", getParticipantsNum());
		attributes.put("participantsKidsNum", getParticipantsKidsNum());
		attributes.put("description", getDescription());
		attributes.put("contactPerson", getContactPerson());
		attributes.put("positionPerson", getPositionPerson());
		attributes.put("telephone", getTelephone());
		attributes.put("email", getEmail());
		attributes.put("pmt", getPmt());
		attributes.put("status", getStatus());
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
		Long loanId = (Long)attributes.get("loanId");

		if (loanId != null) {
			setLoanId(loanId);
		}

		Long localEntityId = (Long)attributes.get("localEntityId");

		if (localEntityId != null) {
			setLocalEntityId(localEntityId);
		}

		Date pickupDate = (Date)attributes.get("pickupDate");

		if (pickupDate != null) {
			setPickupDate(pickupDate);
		}

		Date returnDate = (Date)attributes.get("returnDate");

		if (returnDate != null) {
			setReturnDate(returnDate);
		}

		Date activityDate = (Date)attributes.get("activityDate");

		if (activityDate != null) {
			setActivityDate(activityDate);
		}

		String activityName = (String)attributes.get("activityName");

		if (activityName != null) {
			setActivityName(activityName);
		}

		Integer participantsNum = (Integer)attributes.get("participantsNum");

		if (participantsNum != null) {
			setParticipantsNum(participantsNum);
		}

		Integer participantsKidsNum = (Integer)attributes.get(
				"participantsKidsNum");

		if (participantsKidsNum != null) {
			setParticipantsKidsNum(participantsKidsNum);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String contactPerson = (String)attributes.get("contactPerson");

		if (contactPerson != null) {
			setContactPerson(contactPerson);
		}

		String positionPerson = (String)attributes.get("positionPerson");

		if (positionPerson != null) {
			setPositionPerson(positionPerson);
		}

		String telephone = (String)attributes.get("telephone");

		if (telephone != null) {
			setTelephone(telephone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String pmt = (String)attributes.get("pmt");

		if (pmt != null) {
			setPmt(pmt);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
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
		return new LoanWrapper((Loan)_loan.clone());
	}

	@Override
	public int compareTo(Loan loan) {
		return _loan.compareTo(loan);
	}

	/**
	* Returns the activity date of this loan.
	*
	* @return the activity date of this loan
	*/
	@Override
	public Date getActivityDate() {
		return _loan.getActivityDate();
	}

	/**
	* Returns the activity name of this loan.
	*
	* @return the activity name of this loan
	*/
	@Override
	public String getActivityName() {
		return _loan.getActivityName();
	}

	/**
	* Returns the company ID of this loan.
	*
	* @return the company ID of this loan
	*/
	@Override
	public long getCompanyId() {
		return _loan.getCompanyId();
	}

	/**
	* Returns the contact person of this loan.
	*
	* @return the contact person of this loan
	*/
	@Override
	public String getContactPerson() {
		return _loan.getContactPerson();
	}

	/**
	* Returns the create date of this loan.
	*
	* @return the create date of this loan
	*/
	@Override
	public Date getCreateDate() {
		return _loan.getCreateDate();
	}

	/**
	* Returns the description of this loan.
	*
	* @return the description of this loan
	*/
	@Override
	public String getDescription() {
		return _loan.getDescription();
	}

	/**
	* Returns the email of this loan.
	*
	* @return the email of this loan
	*/
	@Override
	public String getEmail() {
		return _loan.getEmail();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _loan.getExpandoBridge();
	}

	/**
	* Returns the group ID of this loan.
	*
	* @return the group ID of this loan
	*/
	@Override
	public long getGroupId() {
		return _loan.getGroupId();
	}

	/**
	* Returns the loan ID of this loan.
	*
	* @return the loan ID of this loan
	*/
	@Override
	public long getLoanId() {
		return _loan.getLoanId();
	}

	/**
	* Returns the local entity ID of this loan.
	*
	* @return the local entity ID of this loan
	*/
	@Override
	public long getLocalEntityId() {
		return _loan.getLocalEntityId();
	}

	/**
	* Returns the modified date of this loan.
	*
	* @return the modified date of this loan
	*/
	@Override
	public Date getModifiedDate() {
		return _loan.getModifiedDate();
	}

	/**
	* Returns the participants kids num of this loan.
	*
	* @return the participants kids num of this loan
	*/
	@Override
	public int getParticipantsKidsNum() {
		return _loan.getParticipantsKidsNum();
	}

	/**
	* Returns the participants num of this loan.
	*
	* @return the participants num of this loan
	*/
	@Override
	public int getParticipantsNum() {
		return _loan.getParticipantsNum();
	}

	/**
	* Returns the pickup date of this loan.
	*
	* @return the pickup date of this loan
	*/
	@Override
	public Date getPickupDate() {
		return _loan.getPickupDate();
	}

	/**
	* Returns the pmt of this loan.
	*
	* @return the pmt of this loan
	*/
	@Override
	public String getPmt() {
		return _loan.getPmt();
	}

	/**
	* Returns the position person of this loan.
	*
	* @return the position person of this loan
	*/
	@Override
	public String getPositionPerson() {
		return _loan.getPositionPerson();
	}

	/**
	* Returns the primary key of this loan.
	*
	* @return the primary key of this loan
	*/
	@Override
	public long getPrimaryKey() {
		return _loan.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _loan.getPrimaryKeyObj();
	}

	/**
	* Returns the return date of this loan.
	*
	* @return the return date of this loan
	*/
	@Override
	public Date getReturnDate() {
		return _loan.getReturnDate();
	}

	/**
	* Returns the status of this loan.
	*
	* @return the status of this loan
	*/
	@Override
	public String getStatus() {
		return _loan.getStatus();
	}

	/**
	* Returns the telephone of this loan.
	*
	* @return the telephone of this loan
	*/
	@Override
	public String getTelephone() {
		return _loan.getTelephone();
	}

	/**
	* Returns the user ID of this loan.
	*
	* @return the user ID of this loan
	*/
	@Override
	public long getUserId() {
		return _loan.getUserId();
	}

	/**
	* Returns the user name of this loan.
	*
	* @return the user name of this loan
	*/
	@Override
	public String getUserName() {
		return _loan.getUserName();
	}

	/**
	* Returns the user uuid of this loan.
	*
	* @return the user uuid of this loan
	*/
	@Override
	public String getUserUuid() {
		return _loan.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _loan.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _loan.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _loan.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _loan.isNew();
	}

	@Override
	public void persist() {
		_loan.persist();
	}

	/**
	* Sets the activity date of this loan.
	*
	* @param activityDate the activity date of this loan
	*/
	@Override
	public void setActivityDate(Date activityDate) {
		_loan.setActivityDate(activityDate);
	}

	/**
	* Sets the activity name of this loan.
	*
	* @param activityName the activity name of this loan
	*/
	@Override
	public void setActivityName(String activityName) {
		_loan.setActivityName(activityName);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_loan.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this loan.
	*
	* @param companyId the company ID of this loan
	*/
	@Override
	public void setCompanyId(long companyId) {
		_loan.setCompanyId(companyId);
	}

	/**
	* Sets the contact person of this loan.
	*
	* @param contactPerson the contact person of this loan
	*/
	@Override
	public void setContactPerson(String contactPerson) {
		_loan.setContactPerson(contactPerson);
	}

	/**
	* Sets the create date of this loan.
	*
	* @param createDate the create date of this loan
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_loan.setCreateDate(createDate);
	}

	/**
	* Sets the description of this loan.
	*
	* @param description the description of this loan
	*/
	@Override
	public void setDescription(String description) {
		_loan.setDescription(description);
	}

	/**
	* Sets the email of this loan.
	*
	* @param email the email of this loan
	*/
	@Override
	public void setEmail(String email) {
		_loan.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_loan.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_loan.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_loan.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this loan.
	*
	* @param groupId the group ID of this loan
	*/
	@Override
	public void setGroupId(long groupId) {
		_loan.setGroupId(groupId);
	}

	/**
	* Sets the loan ID of this loan.
	*
	* @param loanId the loan ID of this loan
	*/
	@Override
	public void setLoanId(long loanId) {
		_loan.setLoanId(loanId);
	}

	/**
	* Sets the local entity ID of this loan.
	*
	* @param localEntityId the local entity ID of this loan
	*/
	@Override
	public void setLocalEntityId(long localEntityId) {
		_loan.setLocalEntityId(localEntityId);
	}

	/**
	* Sets the modified date of this loan.
	*
	* @param modifiedDate the modified date of this loan
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_loan.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_loan.setNew(n);
	}

	/**
	* Sets the participants kids num of this loan.
	*
	* @param participantsKidsNum the participants kids num of this loan
	*/
	@Override
	public void setParticipantsKidsNum(int participantsKidsNum) {
		_loan.setParticipantsKidsNum(participantsKidsNum);
	}

	/**
	* Sets the participants num of this loan.
	*
	* @param participantsNum the participants num of this loan
	*/
	@Override
	public void setParticipantsNum(int participantsNum) {
		_loan.setParticipantsNum(participantsNum);
	}

	/**
	* Sets the pickup date of this loan.
	*
	* @param pickupDate the pickup date of this loan
	*/
	@Override
	public void setPickupDate(Date pickupDate) {
		_loan.setPickupDate(pickupDate);
	}

	/**
	* Sets the pmt of this loan.
	*
	* @param pmt the pmt of this loan
	*/
	@Override
	public void setPmt(String pmt) {
		_loan.setPmt(pmt);
	}

	/**
	* Sets the position person of this loan.
	*
	* @param positionPerson the position person of this loan
	*/
	@Override
	public void setPositionPerson(String positionPerson) {
		_loan.setPositionPerson(positionPerson);
	}

	/**
	* Sets the primary key of this loan.
	*
	* @param primaryKey the primary key of this loan
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_loan.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_loan.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the return date of this loan.
	*
	* @param returnDate the return date of this loan
	*/
	@Override
	public void setReturnDate(Date returnDate) {
		_loan.setReturnDate(returnDate);
	}

	/**
	* Sets the status of this loan.
	*
	* @param status the status of this loan
	*/
	@Override
	public void setStatus(String status) {
		_loan.setStatus(status);
	}

	/**
	* Sets the telephone of this loan.
	*
	* @param telephone the telephone of this loan
	*/
	@Override
	public void setTelephone(String telephone) {
		_loan.setTelephone(telephone);
	}

	/**
	* Sets the user ID of this loan.
	*
	* @param userId the user ID of this loan
	*/
	@Override
	public void setUserId(long userId) {
		_loan.setUserId(userId);
	}

	/**
	* Sets the user name of this loan.
	*
	* @param userName the user name of this loan
	*/
	@Override
	public void setUserName(String userName) {
		_loan.setUserName(userName);
	}

	/**
	* Sets the user uuid of this loan.
	*
	* @param userUuid the user uuid of this loan
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_loan.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Loan> toCacheModel() {
		return _loan.toCacheModel();
	}

	@Override
	public Loan toEscapedModel() {
		return new LoanWrapper(_loan.toEscapedModel());
	}

	@Override
	public String toString() {
		return _loan.toString();
	}

	@Override
	public Loan toUnescapedModel() {
		return new LoanWrapper(_loan.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _loan.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LoanWrapper)) {
			return false;
		}

		LoanWrapper loanWrapper = (LoanWrapper)obj;

		if (Objects.equals(_loan, loanWrapper._loan)) {
			return true;
		}

		return false;
	}

	@Override
	public Loan getWrappedModel() {
		return _loan;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _loan.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _loan.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_loan.resetOriginalValues();
	}

	private final Loan _loan;
}
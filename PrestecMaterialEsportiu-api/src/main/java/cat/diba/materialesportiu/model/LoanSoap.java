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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class LoanSoap implements Serializable {
	public static LoanSoap toSoapModel(Loan model) {
		LoanSoap soapModel = new LoanSoap();

		soapModel.setLoanId(model.getLoanId());
		soapModel.setLocalEntityId(model.getLocalEntityId());
		soapModel.setPickupDate(model.getPickupDate());
		soapModel.setReturnDate(model.getReturnDate());
		soapModel.setActivityDate(model.getActivityDate());
		soapModel.setActivityName(model.getActivityName());
		soapModel.setParticipantsNum(model.getParticipantsNum());
		soapModel.setParticipantsKidsNum(model.getParticipantsKidsNum());
		soapModel.setDescription(model.getDescription());
		soapModel.setContactPerson(model.getContactPerson());
		soapModel.setPositionPerson(model.getPositionPerson());
		soapModel.setTelephone(model.getTelephone());
		soapModel.setEmail(model.getEmail());
		soapModel.setPmt(model.getPmt());
		soapModel.setStatus(model.getStatus());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static LoanSoap[] toSoapModels(Loan[] models) {
		LoanSoap[] soapModels = new LoanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LoanSoap[][] toSoapModels(Loan[][] models) {
		LoanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LoanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LoanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LoanSoap[] toSoapModels(List<Loan> models) {
		List<LoanSoap> soapModels = new ArrayList<LoanSoap>(models.size());

		for (Loan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LoanSoap[soapModels.size()]);
	}

	public LoanSoap() {
	}

	public long getPrimaryKey() {
		return _loanId;
	}

	public void setPrimaryKey(long pk) {
		setLoanId(pk);
	}

	public long getLoanId() {
		return _loanId;
	}

	public void setLoanId(long loanId) {
		_loanId = loanId;
	}

	public long getLocalEntityId() {
		return _localEntityId;
	}

	public void setLocalEntityId(long localEntityId) {
		_localEntityId = localEntityId;
	}

	public Date getPickupDate() {
		return _pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		_pickupDate = pickupDate;
	}

	public Date getReturnDate() {
		return _returnDate;
	}

	public void setReturnDate(Date returnDate) {
		_returnDate = returnDate;
	}

	public Date getActivityDate() {
		return _activityDate;
	}

	public void setActivityDate(Date activityDate) {
		_activityDate = activityDate;
	}

	public String getActivityName() {
		return _activityName;
	}

	public void setActivityName(String activityName) {
		_activityName = activityName;
	}

	public int getParticipantsNum() {
		return _participantsNum;
	}

	public void setParticipantsNum(int participantsNum) {
		_participantsNum = participantsNum;
	}

	public int getParticipantsKidsNum() {
		return _participantsKidsNum;
	}

	public void setParticipantsKidsNum(int participantsKidsNum) {
		_participantsKidsNum = participantsKidsNum;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getContactPerson() {
		return _contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		_contactPerson = contactPerson;
	}

	public String getPositionPerson() {
		return _positionPerson;
	}

	public void setPositionPerson(String positionPerson) {
		_positionPerson = positionPerson;
	}

	public String getTelephone() {
		return _telephone;
	}

	public void setTelephone(String telephone) {
		_telephone = telephone;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getPmt() {
		return _pmt;
	}

	public void setPmt(String pmt) {
		_pmt = pmt;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _loanId;
	private long _localEntityId;
	private Date _pickupDate;
	private Date _returnDate;
	private Date _activityDate;
	private String _activityName;
	private int _participantsNum;
	private int _participantsKidsNum;
	private String _description;
	private String _contactPerson;
	private String _positionPerson;
	private String _telephone;
	private String _email;
	private String _pmt;
	private String _status;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}
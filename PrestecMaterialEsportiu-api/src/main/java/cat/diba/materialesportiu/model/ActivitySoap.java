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
public class ActivitySoap implements Serializable {
	public static ActivitySoap toSoapModel(Activity model) {
		ActivitySoap soapModel = new ActivitySoap();

		soapModel.setActivityId(model.getActivityId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setAge(model.getAge());
		soapModel.setMinParticipants(model.getMinParticipants());
		soapModel.setMaxParticipants(model.getMaxParticipants());
		soapModel.setUsageRules(model.getUsageRules());
		soapModel.setLoanConditions(model.getLoanConditions());
		soapModel.setTitulationIsRequired(model.isTitulationIsRequired());
		soapModel.setTotalStock(model.getTotalStock());
		soapModel.setAvailableStock(model.getAvailableStock());
		soapModel.setDaysBeforeLoan(model.getDaysBeforeLoan());
		soapModel.setDaysBooking(model.getDaysBooking());
		soapModel.setDaysAfterLoan(model.getDaysAfterLoan());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ActivitySoap[] toSoapModels(Activity[] models) {
		ActivitySoap[] soapModels = new ActivitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ActivitySoap[][] toSoapModels(Activity[][] models) {
		ActivitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ActivitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ActivitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ActivitySoap[] toSoapModels(List<Activity> models) {
		List<ActivitySoap> soapModels = new ArrayList<ActivitySoap>(models.size());

		for (Activity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ActivitySoap[soapModels.size()]);
	}

	public ActivitySoap() {
	}

	public long getPrimaryKey() {
		return _activityId;
	}

	public void setPrimaryKey(long pk) {
		setActivityId(pk);
	}

	public long getActivityId() {
		return _activityId;
	}

	public void setActivityId(long activityId) {
		_activityId = activityId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getAge() {
		return _age;
	}

	public void setAge(int age) {
		_age = age;
	}

	public int getMinParticipants() {
		return _minParticipants;
	}

	public void setMinParticipants(int minParticipants) {
		_minParticipants = minParticipants;
	}

	public int getMaxParticipants() {
		return _maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		_maxParticipants = maxParticipants;
	}

	public String getUsageRules() {
		return _usageRules;
	}

	public void setUsageRules(String usageRules) {
		_usageRules = usageRules;
	}

	public String getLoanConditions() {
		return _loanConditions;
	}

	public void setLoanConditions(String loanConditions) {
		_loanConditions = loanConditions;
	}

	public boolean getTitulationIsRequired() {
		return _titulationIsRequired;
	}

	public boolean isTitulationIsRequired() {
		return _titulationIsRequired;
	}

	public void setTitulationIsRequired(boolean titulationIsRequired) {
		_titulationIsRequired = titulationIsRequired;
	}

	public int getTotalStock() {
		return _totalStock;
	}

	public void setTotalStock(int totalStock) {
		_totalStock = totalStock;
	}

	public int getAvailableStock() {
		return _availableStock;
	}

	public void setAvailableStock(int availableStock) {
		_availableStock = availableStock;
	}

	public int getDaysBeforeLoan() {
		return _daysBeforeLoan;
	}

	public void setDaysBeforeLoan(int daysBeforeLoan) {
		_daysBeforeLoan = daysBeforeLoan;
	}

	public int getDaysBooking() {
		return _daysBooking;
	}

	public void setDaysBooking(int daysBooking) {
		_daysBooking = daysBooking;
	}

	public int getDaysAfterLoan() {
		return _daysAfterLoan;
	}

	public void setDaysAfterLoan(int daysAfterLoan) {
		_daysAfterLoan = daysAfterLoan;
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

	private long _activityId;
	private String _name;
	private String _description;
	private int _age;
	private int _minParticipants;
	private int _maxParticipants;
	private String _usageRules;
	private String _loanConditions;
	private boolean _titulationIsRequired;
	private int _totalStock;
	private int _availableStock;
	private int _daysBeforeLoan;
	private int _daysBooking;
	private int _daysAfterLoan;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}
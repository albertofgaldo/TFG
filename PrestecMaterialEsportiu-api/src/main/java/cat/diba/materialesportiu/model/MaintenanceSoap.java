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
public class MaintenanceSoap implements Serializable {
	public static MaintenanceSoap toSoapModel(Maintenance model) {
		MaintenanceSoap soapModel = new MaintenanceSoap();

		soapModel.setMaintenanceId(model.getMaintenanceId());
		soapModel.setActivityId(model.getActivityId());
		soapModel.setLabel(model.getLabel());
		soapModel.setDescription(model.getDescription());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setIsDone(model.getIsDone());
		soapModel.setLoanId(model.getLoanId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static MaintenanceSoap[] toSoapModels(Maintenance[] models) {
		MaintenanceSoap[] soapModels = new MaintenanceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MaintenanceSoap[][] toSoapModels(Maintenance[][] models) {
		MaintenanceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MaintenanceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MaintenanceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MaintenanceSoap[] toSoapModels(List<Maintenance> models) {
		List<MaintenanceSoap> soapModels = new ArrayList<MaintenanceSoap>(models.size());

		for (Maintenance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MaintenanceSoap[soapModels.size()]);
	}

	public MaintenanceSoap() {
	}

	public long getPrimaryKey() {
		return _maintenanceId;
	}

	public void setPrimaryKey(long pk) {
		setMaintenanceId(pk);
	}

	public long getMaintenanceId() {
		return _maintenanceId;
	}

	public void setMaintenanceId(long maintenanceId) {
		_maintenanceId = maintenanceId;
	}

	public long getActivityId() {
		return _activityId;
	}

	public void setActivityId(long activityId) {
		_activityId = activityId;
	}

	public String getLabel() {
		return _label;
	}

	public void setLabel(String label) {
		_label = label;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public Boolean getIsDone() {
		return _isDone;
	}

	public void setIsDone(Boolean isDone) {
		_isDone = isDone;
	}

	public long getLoanId() {
		return _loanId;
	}

	public void setLoanId(long loanId) {
		_loanId = loanId;
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

	private long _maintenanceId;
	private long _activityId;
	private String _label;
	private String _description;
	private Date _startDate;
	private Date _endDate;
	private Boolean _isDone;
	private long _loanId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}
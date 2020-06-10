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
public class ActivityDependsOnSoap implements Serializable {
	public static ActivityDependsOnSoap toSoapModel(ActivityDependsOn model) {
		ActivityDependsOnSoap soapModel = new ActivityDependsOnSoap();

		soapModel.setActivityDependsOnId(model.getActivityDependsOnId());
		soapModel.setActivityId(model.getActivityId());
		soapModel.setParentActivityId(model.getParentActivityId());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ActivityDependsOnSoap[] toSoapModels(
		ActivityDependsOn[] models) {
		ActivityDependsOnSoap[] soapModels = new ActivityDependsOnSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ActivityDependsOnSoap[][] toSoapModels(
		ActivityDependsOn[][] models) {
		ActivityDependsOnSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ActivityDependsOnSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ActivityDependsOnSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ActivityDependsOnSoap[] toSoapModels(
		List<ActivityDependsOn> models) {
		List<ActivityDependsOnSoap> soapModels = new ArrayList<ActivityDependsOnSoap>(models.size());

		for (ActivityDependsOn model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ActivityDependsOnSoap[soapModels.size()]);
	}

	public ActivityDependsOnSoap() {
	}

	public long getPrimaryKey() {
		return _activityDependsOnId;
	}

	public void setPrimaryKey(long pk) {
		setActivityDependsOnId(pk);
	}

	public long getActivityDependsOnId() {
		return _activityDependsOnId;
	}

	public void setActivityDependsOnId(long activityDependsOnId) {
		_activityDependsOnId = activityDependsOnId;
	}

	public long getActivityId() {
		return _activityId;
	}

	public void setActivityId(long activityId) {
		_activityId = activityId;
	}

	public long getParentActivityId() {
		return _parentActivityId;
	}

	public void setParentActivityId(long parentActivityId) {
		_parentActivityId = parentActivityId;
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
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

	private long _activityDependsOnId;
	private long _activityId;
	private long _parentActivityId;
	private int _quantity;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}
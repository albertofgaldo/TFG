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
public class LocalEntitySoap implements Serializable {
	public static LocalEntitySoap toSoapModel(LocalEntity model) {
		LocalEntitySoap soapModel = new LocalEntitySoap();

		soapModel.setLocalEntityId(model.getLocalEntityId());
		soapModel.setCif(model.getCif());
		soapModel.setName(model.getName());
		soapModel.setTelephone(model.getTelephone());
		soapModel.setEmail(model.getEmail());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static LocalEntitySoap[] toSoapModels(LocalEntity[] models) {
		LocalEntitySoap[] soapModels = new LocalEntitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LocalEntitySoap[][] toSoapModels(LocalEntity[][] models) {
		LocalEntitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LocalEntitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LocalEntitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LocalEntitySoap[] toSoapModels(List<LocalEntity> models) {
		List<LocalEntitySoap> soapModels = new ArrayList<LocalEntitySoap>(models.size());

		for (LocalEntity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LocalEntitySoap[soapModels.size()]);
	}

	public LocalEntitySoap() {
	}

	public long getPrimaryKey() {
		return _localEntityId;
	}

	public void setPrimaryKey(long pk) {
		setLocalEntityId(pk);
	}

	public long getLocalEntityId() {
		return _localEntityId;
	}

	public void setLocalEntityId(long localEntityId) {
		_localEntityId = localEntityId;
	}

	public String getCif() {
		return _cif;
	}

	public void setCif(String cif) {
		_cif = cif;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
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

	private long _localEntityId;
	private String _cif;
	private String _name;
	private String _telephone;
	private String _email;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}
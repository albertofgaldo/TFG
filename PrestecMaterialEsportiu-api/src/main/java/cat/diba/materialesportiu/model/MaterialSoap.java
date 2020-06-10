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
public class MaterialSoap implements Serializable {
	public static MaterialSoap toSoapModel(Material model) {
		MaterialSoap soapModel = new MaterialSoap();

		soapModel.setMaterialId(model.getMaterialId());
		soapModel.setName(model.getName());
		soapModel.setHeigh(model.getHeigh());
		soapModel.setWidth(model.getWidth());
		soapModel.setLongitude(model.getLongitude());
		soapModel.setWeight(model.getWeight());
		soapModel.setActivityId(model.getActivityId());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static MaterialSoap[] toSoapModels(Material[] models) {
		MaterialSoap[] soapModels = new MaterialSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MaterialSoap[][] toSoapModels(Material[][] models) {
		MaterialSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MaterialSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MaterialSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MaterialSoap[] toSoapModels(List<Material> models) {
		List<MaterialSoap> soapModels = new ArrayList<MaterialSoap>(models.size());

		for (Material model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MaterialSoap[soapModels.size()]);
	}

	public MaterialSoap() {
	}

	public long getPrimaryKey() {
		return _materialId;
	}

	public void setPrimaryKey(long pk) {
		setMaterialId(pk);
	}

	public long getMaterialId() {
		return _materialId;
	}

	public void setMaterialId(long materialId) {
		_materialId = materialId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public float getHeigh() {
		return _heigh;
	}

	public void setHeigh(float heigh) {
		_heigh = heigh;
	}

	public float getWidth() {
		return _width;
	}

	public void setWidth(float width) {
		_width = width;
	}

	public float getLongitude() {
		return _longitude;
	}

	public void setLongitude(float longitude) {
		_longitude = longitude;
	}

	public float getWeight() {
		return _weight;
	}

	public void setWeight(float weight) {
		_weight = weight;
	}

	public long getActivityId() {
		return _activityId;
	}

	public void setActivityId(long activityId) {
		_activityId = activityId;
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

	private long _materialId;
	private String _name;
	private float _heigh;
	private float _width;
	private float _longitude;
	private float _weight;
	private long _activityId;
	private int _quantity;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}
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

package cat.diba.materialesportiu.model.impl;

import aQute.bnd.annotation.ProviderType;

import cat.diba.materialesportiu.model.Material;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Material in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Material
 * @generated
 */
@ProviderType
public class MaterialCacheModel implements CacheModel<Material>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MaterialCacheModel)) {
			return false;
		}

		MaterialCacheModel materialCacheModel = (MaterialCacheModel)obj;

		if (materialId == materialCacheModel.materialId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, materialId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{materialId=");
		sb.append(materialId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", heigh=");
		sb.append(heigh);
		sb.append(", width=");
		sb.append(width);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", activityId=");
		sb.append(activityId);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Material toEntityModel() {
		MaterialImpl materialImpl = new MaterialImpl();

		materialImpl.setMaterialId(materialId);

		if (name == null) {
			materialImpl.setName("");
		}
		else {
			materialImpl.setName(name);
		}

		materialImpl.setHeigh(heigh);
		materialImpl.setWidth(width);
		materialImpl.setLongitude(longitude);
		materialImpl.setWeight(weight);
		materialImpl.setActivityId(activityId);
		materialImpl.setQuantity(quantity);
		materialImpl.setGroupId(groupId);
		materialImpl.setCompanyId(companyId);
		materialImpl.setUserId(userId);

		if (userName == null) {
			materialImpl.setUserName("");
		}
		else {
			materialImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			materialImpl.setCreateDate(null);
		}
		else {
			materialImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			materialImpl.setModifiedDate(null);
		}
		else {
			materialImpl.setModifiedDate(new Date(modifiedDate));
		}

		materialImpl.resetOriginalValues();

		return materialImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		materialId = objectInput.readLong();
		name = objectInput.readUTF();

		heigh = objectInput.readFloat();

		width = objectInput.readFloat();

		longitude = objectInput.readFloat();

		weight = objectInput.readFloat();

		activityId = objectInput.readLong();

		quantity = objectInput.readInt();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(materialId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeFloat(heigh);

		objectOutput.writeFloat(width);

		objectOutput.writeFloat(longitude);

		objectOutput.writeFloat(weight);

		objectOutput.writeLong(activityId);

		objectOutput.writeInt(quantity);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long materialId;
	public String name;
	public float heigh;
	public float width;
	public float longitude;
	public float weight;
	public long activityId;
	public int quantity;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
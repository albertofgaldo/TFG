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

import cat.diba.materialesportiu.model.LocalEntity;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LocalEntity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LocalEntity
 * @generated
 */
@ProviderType
public class LocalEntityCacheModel implements CacheModel<LocalEntity>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LocalEntityCacheModel)) {
			return false;
		}

		LocalEntityCacheModel localEntityCacheModel = (LocalEntityCacheModel)obj;

		if (localEntityId == localEntityCacheModel.localEntityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, localEntityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{localEntityId=");
		sb.append(localEntityId);
		sb.append(", cif=");
		sb.append(cif);
		sb.append(", name=");
		sb.append(name);
		sb.append(", telephone=");
		sb.append(telephone);
		sb.append(", email=");
		sb.append(email);
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
	public LocalEntity toEntityModel() {
		LocalEntityImpl localEntityImpl = new LocalEntityImpl();

		localEntityImpl.setLocalEntityId(localEntityId);

		if (cif == null) {
			localEntityImpl.setCif("");
		}
		else {
			localEntityImpl.setCif(cif);
		}

		if (name == null) {
			localEntityImpl.setName("");
		}
		else {
			localEntityImpl.setName(name);
		}

		if (telephone == null) {
			localEntityImpl.setTelephone("");
		}
		else {
			localEntityImpl.setTelephone(telephone);
		}

		if (email == null) {
			localEntityImpl.setEmail("");
		}
		else {
			localEntityImpl.setEmail(email);
		}

		localEntityImpl.setGroupId(groupId);
		localEntityImpl.setCompanyId(companyId);
		localEntityImpl.setUserId(userId);

		if (userName == null) {
			localEntityImpl.setUserName("");
		}
		else {
			localEntityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			localEntityImpl.setCreateDate(null);
		}
		else {
			localEntityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			localEntityImpl.setModifiedDate(null);
		}
		else {
			localEntityImpl.setModifiedDate(new Date(modifiedDate));
		}

		localEntityImpl.resetOriginalValues();

		return localEntityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		localEntityId = objectInput.readLong();
		cif = objectInput.readUTF();
		name = objectInput.readUTF();
		telephone = objectInput.readUTF();
		email = objectInput.readUTF();

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
		objectOutput.writeLong(localEntityId);

		if (cif == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cif);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (telephone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(telephone);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

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

	public long localEntityId;
	public String cif;
	public String name;
	public String telephone;
	public String email;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
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

import cat.diba.materialesportiu.model.ActivityDependsOn;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ActivityDependsOn in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityDependsOn
 * @generated
 */
@ProviderType
public class ActivityDependsOnCacheModel implements CacheModel<ActivityDependsOn>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ActivityDependsOnCacheModel)) {
			return false;
		}

		ActivityDependsOnCacheModel activityDependsOnCacheModel = (ActivityDependsOnCacheModel)obj;

		if (activityDependsOnId == activityDependsOnCacheModel.activityDependsOnId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, activityDependsOnId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{activityDependsOnId=");
		sb.append(activityDependsOnId);
		sb.append(", activityId=");
		sb.append(activityId);
		sb.append(", parentActivityId=");
		sb.append(parentActivityId);
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
	public ActivityDependsOn toEntityModel() {
		ActivityDependsOnImpl activityDependsOnImpl = new ActivityDependsOnImpl();

		activityDependsOnImpl.setActivityDependsOnId(activityDependsOnId);
		activityDependsOnImpl.setActivityId(activityId);
		activityDependsOnImpl.setParentActivityId(parentActivityId);
		activityDependsOnImpl.setQuantity(quantity);
		activityDependsOnImpl.setGroupId(groupId);
		activityDependsOnImpl.setCompanyId(companyId);
		activityDependsOnImpl.setUserId(userId);

		if (userName == null) {
			activityDependsOnImpl.setUserName("");
		}
		else {
			activityDependsOnImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			activityDependsOnImpl.setCreateDate(null);
		}
		else {
			activityDependsOnImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			activityDependsOnImpl.setModifiedDate(null);
		}
		else {
			activityDependsOnImpl.setModifiedDate(new Date(modifiedDate));
		}

		activityDependsOnImpl.resetOriginalValues();

		return activityDependsOnImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		activityDependsOnId = objectInput.readLong();

		activityId = objectInput.readLong();

		parentActivityId = objectInput.readLong();

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
		objectOutput.writeLong(activityDependsOnId);

		objectOutput.writeLong(activityId);

		objectOutput.writeLong(parentActivityId);

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

	public long activityDependsOnId;
	public long activityId;
	public long parentActivityId;
	public int quantity;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
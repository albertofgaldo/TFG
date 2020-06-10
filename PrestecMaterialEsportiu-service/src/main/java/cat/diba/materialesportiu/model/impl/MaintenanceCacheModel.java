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

import cat.diba.materialesportiu.model.Maintenance;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Maintenance in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Maintenance
 * @generated
 */
@ProviderType
public class MaintenanceCacheModel implements CacheModel<Maintenance>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MaintenanceCacheModel)) {
			return false;
		}

		MaintenanceCacheModel maintenanceCacheModel = (MaintenanceCacheModel)obj;

		if (maintenanceId == maintenanceCacheModel.maintenanceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, maintenanceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{maintenanceId=");
		sb.append(maintenanceId);
		sb.append(", activityId=");
		sb.append(activityId);
		sb.append(", label=");
		sb.append(label);
		sb.append(", description=");
		sb.append(description);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", isDone=");
		sb.append(isDone);
		sb.append(", loanId=");
		sb.append(loanId);
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
	public Maintenance toEntityModel() {
		MaintenanceImpl maintenanceImpl = new MaintenanceImpl();

		maintenanceImpl.setMaintenanceId(maintenanceId);
		maintenanceImpl.setActivityId(activityId);

		if (label == null) {
			maintenanceImpl.setLabel("");
		}
		else {
			maintenanceImpl.setLabel(label);
		}

		if (description == null) {
			maintenanceImpl.setDescription("");
		}
		else {
			maintenanceImpl.setDescription(description);
		}

		if (startDate == Long.MIN_VALUE) {
			maintenanceImpl.setStartDate(null);
		}
		else {
			maintenanceImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			maintenanceImpl.setEndDate(null);
		}
		else {
			maintenanceImpl.setEndDate(new Date(endDate));
		}

		maintenanceImpl.setIsDone(isDone);
		maintenanceImpl.setLoanId(loanId);
		maintenanceImpl.setGroupId(groupId);
		maintenanceImpl.setCompanyId(companyId);
		maintenanceImpl.setUserId(userId);

		if (userName == null) {
			maintenanceImpl.setUserName("");
		}
		else {
			maintenanceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			maintenanceImpl.setCreateDate(null);
		}
		else {
			maintenanceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			maintenanceImpl.setModifiedDate(null);
		}
		else {
			maintenanceImpl.setModifiedDate(new Date(modifiedDate));
		}

		maintenanceImpl.resetOriginalValues();

		return maintenanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		maintenanceId = objectInput.readLong();

		activityId = objectInput.readLong();
		label = objectInput.readUTF();
		description = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();

		isDone = objectInput.readBoolean();

		loanId = objectInput.readLong();

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
		objectOutput.writeLong(maintenanceId);

		objectOutput.writeLong(activityId);

		if (label == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(label);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		objectOutput.writeBoolean(isDone);

		objectOutput.writeLong(loanId);

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

	public long maintenanceId;
	public long activityId;
	public String label;
	public String description;
	public long startDate;
	public long endDate;
	public boolean isDone;
	public long loanId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
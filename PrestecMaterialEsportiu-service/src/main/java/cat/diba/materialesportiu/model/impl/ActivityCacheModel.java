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

import cat.diba.materialesportiu.model.Activity;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Activity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Activity
 * @generated
 */
@ProviderType
public class ActivityCacheModel implements CacheModel<Activity>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ActivityCacheModel)) {
			return false;
		}

		ActivityCacheModel activityCacheModel = (ActivityCacheModel)obj;

		if (activityId == activityCacheModel.activityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, activityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{activityId=");
		sb.append(activityId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", age=");
		sb.append(age);
		sb.append(", minParticipants=");
		sb.append(minParticipants);
		sb.append(", maxParticipants=");
		sb.append(maxParticipants);
		sb.append(", usageRules=");
		sb.append(usageRules);
		sb.append(", loanConditions=");
		sb.append(loanConditions);
		sb.append(", titulationIsRequired=");
		sb.append(titulationIsRequired);
		sb.append(", totalStock=");
		sb.append(totalStock);
		sb.append(", availableStock=");
		sb.append(availableStock);
		sb.append(", daysBeforeLoan=");
		sb.append(daysBeforeLoan);
		sb.append(", daysBooking=");
		sb.append(daysBooking);
		sb.append(", daysAfterLoan=");
		sb.append(daysAfterLoan);
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
	public Activity toEntityModel() {
		ActivityImpl activityImpl = new ActivityImpl();

		activityImpl.setActivityId(activityId);

		if (name == null) {
			activityImpl.setName("");
		}
		else {
			activityImpl.setName(name);
		}

		if (description == null) {
			activityImpl.setDescription("");
		}
		else {
			activityImpl.setDescription(description);
		}

		activityImpl.setAge(age);
		activityImpl.setMinParticipants(minParticipants);
		activityImpl.setMaxParticipants(maxParticipants);

		if (usageRules == null) {
			activityImpl.setUsageRules("");
		}
		else {
			activityImpl.setUsageRules(usageRules);
		}

		if (loanConditions == null) {
			activityImpl.setLoanConditions("");
		}
		else {
			activityImpl.setLoanConditions(loanConditions);
		}

		activityImpl.setTitulationIsRequired(titulationIsRequired);
		activityImpl.setTotalStock(totalStock);
		activityImpl.setAvailableStock(availableStock);
		activityImpl.setDaysBeforeLoan(daysBeforeLoan);
		activityImpl.setDaysBooking(daysBooking);
		activityImpl.setDaysAfterLoan(daysAfterLoan);
		activityImpl.setGroupId(groupId);
		activityImpl.setCompanyId(companyId);
		activityImpl.setUserId(userId);

		if (userName == null) {
			activityImpl.setUserName("");
		}
		else {
			activityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			activityImpl.setCreateDate(null);
		}
		else {
			activityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			activityImpl.setModifiedDate(null);
		}
		else {
			activityImpl.setModifiedDate(new Date(modifiedDate));
		}

		activityImpl.resetOriginalValues();

		return activityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		activityId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

		age = objectInput.readInt();

		minParticipants = objectInput.readInt();

		maxParticipants = objectInput.readInt();
		usageRules = objectInput.readUTF();
		loanConditions = objectInput.readUTF();

		titulationIsRequired = objectInput.readBoolean();

		totalStock = objectInput.readInt();

		availableStock = objectInput.readInt();

		daysBeforeLoan = objectInput.readInt();

		daysBooking = objectInput.readInt();

		daysAfterLoan = objectInput.readInt();

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
		objectOutput.writeLong(activityId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(age);

		objectOutput.writeInt(minParticipants);

		objectOutput.writeInt(maxParticipants);

		if (usageRules == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(usageRules);
		}

		if (loanConditions == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(loanConditions);
		}

		objectOutput.writeBoolean(titulationIsRequired);

		objectOutput.writeInt(totalStock);

		objectOutput.writeInt(availableStock);

		objectOutput.writeInt(daysBeforeLoan);

		objectOutput.writeInt(daysBooking);

		objectOutput.writeInt(daysAfterLoan);

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

	public long activityId;
	public String name;
	public String description;
	public int age;
	public int minParticipants;
	public int maxParticipants;
	public String usageRules;
	public String loanConditions;
	public boolean titulationIsRequired;
	public int totalStock;
	public int availableStock;
	public int daysBeforeLoan;
	public int daysBooking;
	public int daysAfterLoan;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
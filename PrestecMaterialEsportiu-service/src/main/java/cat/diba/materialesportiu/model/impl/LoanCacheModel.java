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

import cat.diba.materialesportiu.model.Loan;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Loan in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Loan
 * @generated
 */
@ProviderType
public class LoanCacheModel implements CacheModel<Loan>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LoanCacheModel)) {
			return false;
		}

		LoanCacheModel loanCacheModel = (LoanCacheModel)obj;

		if (loanId == loanCacheModel.loanId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, loanId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{loanId=");
		sb.append(loanId);
		sb.append(", localEntityId=");
		sb.append(localEntityId);
		sb.append(", pickupDate=");
		sb.append(pickupDate);
		sb.append(", returnDate=");
		sb.append(returnDate);
		sb.append(", activityDate=");
		sb.append(activityDate);
		sb.append(", activityName=");
		sb.append(activityName);
		sb.append(", participantsNum=");
		sb.append(participantsNum);
		sb.append(", participantsKidsNum=");
		sb.append(participantsKidsNum);
		sb.append(", description=");
		sb.append(description);
		sb.append(", contactPerson=");
		sb.append(contactPerson);
		sb.append(", positionPerson=");
		sb.append(positionPerson);
		sb.append(", telephone=");
		sb.append(telephone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", pmt=");
		sb.append(pmt);
		sb.append(", status=");
		sb.append(status);
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
	public Loan toEntityModel() {
		LoanImpl loanImpl = new LoanImpl();

		loanImpl.setLoanId(loanId);
		loanImpl.setLocalEntityId(localEntityId);

		if (pickupDate == Long.MIN_VALUE) {
			loanImpl.setPickupDate(null);
		}
		else {
			loanImpl.setPickupDate(new Date(pickupDate));
		}

		if (returnDate == Long.MIN_VALUE) {
			loanImpl.setReturnDate(null);
		}
		else {
			loanImpl.setReturnDate(new Date(returnDate));
		}

		if (activityDate == Long.MIN_VALUE) {
			loanImpl.setActivityDate(null);
		}
		else {
			loanImpl.setActivityDate(new Date(activityDate));
		}

		if (activityName == null) {
			loanImpl.setActivityName("");
		}
		else {
			loanImpl.setActivityName(activityName);
		}

		loanImpl.setParticipantsNum(participantsNum);
		loanImpl.setParticipantsKidsNum(participantsKidsNum);

		if (description == null) {
			loanImpl.setDescription("");
		}
		else {
			loanImpl.setDescription(description);
		}

		if (contactPerson == null) {
			loanImpl.setContactPerson("");
		}
		else {
			loanImpl.setContactPerson(contactPerson);
		}

		if (positionPerson == null) {
			loanImpl.setPositionPerson("");
		}
		else {
			loanImpl.setPositionPerson(positionPerson);
		}

		if (telephone == null) {
			loanImpl.setTelephone("");
		}
		else {
			loanImpl.setTelephone(telephone);
		}

		if (email == null) {
			loanImpl.setEmail("");
		}
		else {
			loanImpl.setEmail(email);
		}

		if (pmt == null) {
			loanImpl.setPmt("");
		}
		else {
			loanImpl.setPmt(pmt);
		}

		if (status == null) {
			loanImpl.setStatus("");
		}
		else {
			loanImpl.setStatus(status);
		}

		loanImpl.setGroupId(groupId);
		loanImpl.setCompanyId(companyId);
		loanImpl.setUserId(userId);

		if (userName == null) {
			loanImpl.setUserName("");
		}
		else {
			loanImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			loanImpl.setCreateDate(null);
		}
		else {
			loanImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			loanImpl.setModifiedDate(null);
		}
		else {
			loanImpl.setModifiedDate(new Date(modifiedDate));
		}

		loanImpl.resetOriginalValues();

		return loanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		loanId = objectInput.readLong();

		localEntityId = objectInput.readLong();
		pickupDate = objectInput.readLong();
		returnDate = objectInput.readLong();
		activityDate = objectInput.readLong();
		activityName = objectInput.readUTF();

		participantsNum = objectInput.readInt();

		participantsKidsNum = objectInput.readInt();
		description = objectInput.readUTF();
		contactPerson = objectInput.readUTF();
		positionPerson = objectInput.readUTF();
		telephone = objectInput.readUTF();
		email = objectInput.readUTF();
		pmt = objectInput.readUTF();
		status = objectInput.readUTF();

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
		objectOutput.writeLong(loanId);

		objectOutput.writeLong(localEntityId);
		objectOutput.writeLong(pickupDate);
		objectOutput.writeLong(returnDate);
		objectOutput.writeLong(activityDate);

		if (activityName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(activityName);
		}

		objectOutput.writeInt(participantsNum);

		objectOutput.writeInt(participantsKidsNum);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (contactPerson == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactPerson);
		}

		if (positionPerson == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(positionPerson);
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

		if (pmt == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pmt);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
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

	public long loanId;
	public long localEntityId;
	public long pickupDate;
	public long returnDate;
	public long activityDate;
	public String activityName;
	public int participantsNum;
	public int participantsKidsNum;
	public String description;
	public String contactPerson;
	public String positionPerson;
	public String telephone;
	public String email;
	public String pmt;
	public String status;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
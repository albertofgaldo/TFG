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

import cat.diba.materialesportiu.model.LoanActivity;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LoanActivity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LoanActivity
 * @generated
 */
@ProviderType
public class LoanActivityCacheModel implements CacheModel<LoanActivity>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LoanActivityCacheModel)) {
			return false;
		}

		LoanActivityCacheModel loanActivityCacheModel = (LoanActivityCacheModel)obj;

		if (loanActivityId == loanActivityCacheModel.loanActivityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, loanActivityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{loanActivityId=");
		sb.append(loanActivityId);
		sb.append(", loanId=");
		sb.append(loanId);
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
	public LoanActivity toEntityModel() {
		LoanActivityImpl loanActivityImpl = new LoanActivityImpl();

		loanActivityImpl.setLoanActivityId(loanActivityId);
		loanActivityImpl.setLoanId(loanId);
		loanActivityImpl.setActivityId(activityId);
		loanActivityImpl.setQuantity(quantity);
		loanActivityImpl.setGroupId(groupId);
		loanActivityImpl.setCompanyId(companyId);
		loanActivityImpl.setUserId(userId);

		if (userName == null) {
			loanActivityImpl.setUserName("");
		}
		else {
			loanActivityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			loanActivityImpl.setCreateDate(null);
		}
		else {
			loanActivityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			loanActivityImpl.setModifiedDate(null);
		}
		else {
			loanActivityImpl.setModifiedDate(new Date(modifiedDate));
		}

		loanActivityImpl.resetOriginalValues();

		return loanActivityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		loanActivityId = objectInput.readLong();

		loanId = objectInput.readLong();

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
		objectOutput.writeLong(loanActivityId);

		objectOutput.writeLong(loanId);

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

	public long loanActivityId;
	public long loanId;
	public long activityId;
	public int quantity;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
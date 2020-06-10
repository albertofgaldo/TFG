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
import cat.diba.materialesportiu.model.LoanModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Loan service. Represents a row in the &quot;PME_Loan&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link LoanModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LoanImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoanImpl
 * @see Loan
 * @see LoanModel
 * @generated
 */
@ProviderType
public class LoanModelImpl extends BaseModelImpl<Loan> implements LoanModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a loan model instance should use the {@link Loan} interface instead.
	 */
	public static final String TABLE_NAME = "PME_Loan";
	public static final Object[][] TABLE_COLUMNS = {
			{ "loanId", Types.BIGINT },
			{ "localEntityId", Types.BIGINT },
			{ "pickupDate", Types.TIMESTAMP },
			{ "returnDate", Types.TIMESTAMP },
			{ "activityDate", Types.TIMESTAMP },
			{ "activityName", Types.VARCHAR },
			{ "participantsNum", Types.INTEGER },
			{ "participantsKidsNum", Types.INTEGER },
			{ "description", Types.VARCHAR },
			{ "contactPerson", Types.VARCHAR },
			{ "positionPerson", Types.VARCHAR },
			{ "telephone", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "pmt", Types.VARCHAR },
			{ "status", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("loanId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("localEntityId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("pickupDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("returnDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("activityDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("activityName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("participantsNum", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("participantsKidsNum", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactPerson", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("positionPerson", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("telephone", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("pmt", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table PME_Loan (loanId LONG not null primary key,localEntityId LONG,pickupDate DATE null,returnDate DATE null,activityDate DATE null,activityName VARCHAR(75) null,participantsNum INTEGER,participantsKidsNum INTEGER,description VARCHAR(75) null,contactPerson VARCHAR(75) null,positionPerson VARCHAR(75) null,telephone VARCHAR(75) null,email VARCHAR(75) null,pmt VARCHAR(75) null,status VARCHAR(75) null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table PME_Loan";
	public static final String ORDER_BY_JPQL = " ORDER BY loan.pickupDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY PME_Loan.pickupDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(cat.diba.materialesportiu.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.cat.diba.materialesportiu.model.Loan"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(cat.diba.materialesportiu.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.cat.diba.materialesportiu.model.Loan"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(cat.diba.materialesportiu.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.cat.diba.materialesportiu.model.Loan"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long PICKUPDATE_COLUMN_BITMASK = 4L;
	public static final long RETURNDATE_COLUMN_BITMASK = 8L;
	public static final long STATUS_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(cat.diba.materialesportiu.service.util.ServiceProps.get(
				"lock.expiration.time.cat.diba.materialesportiu.model.Loan"));

	public LoanModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _loanId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLoanId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _loanId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Loan.class;
	}

	@Override
	public String getModelClassName() {
		return Loan.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("loanId", getLoanId());
		attributes.put("localEntityId", getLocalEntityId());
		attributes.put("pickupDate", getPickupDate());
		attributes.put("returnDate", getReturnDate());
		attributes.put("activityDate", getActivityDate());
		attributes.put("activityName", getActivityName());
		attributes.put("participantsNum", getParticipantsNum());
		attributes.put("participantsKidsNum", getParticipantsKidsNum());
		attributes.put("description", getDescription());
		attributes.put("contactPerson", getContactPerson());
		attributes.put("positionPerson", getPositionPerson());
		attributes.put("telephone", getTelephone());
		attributes.put("email", getEmail());
		attributes.put("pmt", getPmt());
		attributes.put("status", getStatus());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long loanId = (Long)attributes.get("loanId");

		if (loanId != null) {
			setLoanId(loanId);
		}

		Long localEntityId = (Long)attributes.get("localEntityId");

		if (localEntityId != null) {
			setLocalEntityId(localEntityId);
		}

		Date pickupDate = (Date)attributes.get("pickupDate");

		if (pickupDate != null) {
			setPickupDate(pickupDate);
		}

		Date returnDate = (Date)attributes.get("returnDate");

		if (returnDate != null) {
			setReturnDate(returnDate);
		}

		Date activityDate = (Date)attributes.get("activityDate");

		if (activityDate != null) {
			setActivityDate(activityDate);
		}

		String activityName = (String)attributes.get("activityName");

		if (activityName != null) {
			setActivityName(activityName);
		}

		Integer participantsNum = (Integer)attributes.get("participantsNum");

		if (participantsNum != null) {
			setParticipantsNum(participantsNum);
		}

		Integer participantsKidsNum = (Integer)attributes.get(
				"participantsKidsNum");

		if (participantsKidsNum != null) {
			setParticipantsKidsNum(participantsKidsNum);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String contactPerson = (String)attributes.get("contactPerson");

		if (contactPerson != null) {
			setContactPerson(contactPerson);
		}

		String positionPerson = (String)attributes.get("positionPerson");

		if (positionPerson != null) {
			setPositionPerson(positionPerson);
		}

		String telephone = (String)attributes.get("telephone");

		if (telephone != null) {
			setTelephone(telephone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String pmt = (String)attributes.get("pmt");

		if (pmt != null) {
			setPmt(pmt);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public long getLoanId() {
		return _loanId;
	}

	@Override
	public void setLoanId(long loanId) {
		_loanId = loanId;
	}

	@Override
	public long getLocalEntityId() {
		return _localEntityId;
	}

	@Override
	public void setLocalEntityId(long localEntityId) {
		_localEntityId = localEntityId;
	}

	@Override
	public Date getPickupDate() {
		return _pickupDate;
	}

	@Override
	public void setPickupDate(Date pickupDate) {
		_columnBitmask = -1L;

		if (_originalPickupDate == null) {
			_originalPickupDate = _pickupDate;
		}

		_pickupDate = pickupDate;
	}

	public Date getOriginalPickupDate() {
		return _originalPickupDate;
	}

	@Override
	public Date getReturnDate() {
		return _returnDate;
	}

	@Override
	public void setReturnDate(Date returnDate) {
		_columnBitmask |= RETURNDATE_COLUMN_BITMASK;

		if (_originalReturnDate == null) {
			_originalReturnDate = _returnDate;
		}

		_returnDate = returnDate;
	}

	public Date getOriginalReturnDate() {
		return _originalReturnDate;
	}

	@Override
	public Date getActivityDate() {
		return _activityDate;
	}

	@Override
	public void setActivityDate(Date activityDate) {
		_activityDate = activityDate;
	}

	@Override
	public String getActivityName() {
		if (_activityName == null) {
			return "";
		}
		else {
			return _activityName;
		}
	}

	@Override
	public void setActivityName(String activityName) {
		_activityName = activityName;
	}

	@Override
	public int getParticipantsNum() {
		return _participantsNum;
	}

	@Override
	public void setParticipantsNum(int participantsNum) {
		_participantsNum = participantsNum;
	}

	@Override
	public int getParticipantsKidsNum() {
		return _participantsKidsNum;
	}

	@Override
	public void setParticipantsKidsNum(int participantsKidsNum) {
		_participantsKidsNum = participantsKidsNum;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public String getContactPerson() {
		if (_contactPerson == null) {
			return "";
		}
		else {
			return _contactPerson;
		}
	}

	@Override
	public void setContactPerson(String contactPerson) {
		_contactPerson = contactPerson;
	}

	@Override
	public String getPositionPerson() {
		if (_positionPerson == null) {
			return "";
		}
		else {
			return _positionPerson;
		}
	}

	@Override
	public void setPositionPerson(String positionPerson) {
		_positionPerson = positionPerson;
	}

	@Override
	public String getTelephone() {
		if (_telephone == null) {
			return "";
		}
		else {
			return _telephone;
		}
	}

	@Override
	public void setTelephone(String telephone) {
		_telephone = telephone;
	}

	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@Override
	public String getPmt() {
		if (_pmt == null) {
			return "";
		}
		else {
			return _pmt;
		}
	}

	@Override
	public void setPmt(String pmt) {
		_pmt = pmt;
	}

	@Override
	public String getStatus() {
		if (_status == null) {
			return "";
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (_originalStatus == null) {
			_originalStatus = _status;
		}

		_status = status;
	}

	public String getOriginalStatus() {
		return GetterUtil.getString(_originalStatus);
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Loan.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Loan toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Loan)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LoanImpl loanImpl = new LoanImpl();

		loanImpl.setLoanId(getLoanId());
		loanImpl.setLocalEntityId(getLocalEntityId());
		loanImpl.setPickupDate(getPickupDate());
		loanImpl.setReturnDate(getReturnDate());
		loanImpl.setActivityDate(getActivityDate());
		loanImpl.setActivityName(getActivityName());
		loanImpl.setParticipantsNum(getParticipantsNum());
		loanImpl.setParticipantsKidsNum(getParticipantsKidsNum());
		loanImpl.setDescription(getDescription());
		loanImpl.setContactPerson(getContactPerson());
		loanImpl.setPositionPerson(getPositionPerson());
		loanImpl.setTelephone(getTelephone());
		loanImpl.setEmail(getEmail());
		loanImpl.setPmt(getPmt());
		loanImpl.setStatus(getStatus());
		loanImpl.setGroupId(getGroupId());
		loanImpl.setCompanyId(getCompanyId());
		loanImpl.setUserId(getUserId());
		loanImpl.setUserName(getUserName());
		loanImpl.setCreateDate(getCreateDate());
		loanImpl.setModifiedDate(getModifiedDate());

		loanImpl.resetOriginalValues();

		return loanImpl;
	}

	@Override
	public int compareTo(Loan loan) {
		int value = 0;

		value = DateUtil.compareTo(getPickupDate(), loan.getPickupDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Loan)) {
			return false;
		}

		Loan loan = (Loan)obj;

		long primaryKey = loan.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		LoanModelImpl loanModelImpl = this;

		loanModelImpl._originalPickupDate = loanModelImpl._pickupDate;

		loanModelImpl._originalReturnDate = loanModelImpl._returnDate;

		loanModelImpl._originalStatus = loanModelImpl._status;

		loanModelImpl._originalGroupId = loanModelImpl._groupId;

		loanModelImpl._setOriginalGroupId = false;

		loanModelImpl._originalCompanyId = loanModelImpl._companyId;

		loanModelImpl._setOriginalCompanyId = false;

		loanModelImpl._setModifiedDate = false;

		loanModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Loan> toCacheModel() {
		LoanCacheModel loanCacheModel = new LoanCacheModel();

		loanCacheModel.loanId = getLoanId();

		loanCacheModel.localEntityId = getLocalEntityId();

		Date pickupDate = getPickupDate();

		if (pickupDate != null) {
			loanCacheModel.pickupDate = pickupDate.getTime();
		}
		else {
			loanCacheModel.pickupDate = Long.MIN_VALUE;
		}

		Date returnDate = getReturnDate();

		if (returnDate != null) {
			loanCacheModel.returnDate = returnDate.getTime();
		}
		else {
			loanCacheModel.returnDate = Long.MIN_VALUE;
		}

		Date activityDate = getActivityDate();

		if (activityDate != null) {
			loanCacheModel.activityDate = activityDate.getTime();
		}
		else {
			loanCacheModel.activityDate = Long.MIN_VALUE;
		}

		loanCacheModel.activityName = getActivityName();

		String activityName = loanCacheModel.activityName;

		if ((activityName != null) && (activityName.length() == 0)) {
			loanCacheModel.activityName = null;
		}

		loanCacheModel.participantsNum = getParticipantsNum();

		loanCacheModel.participantsKidsNum = getParticipantsKidsNum();

		loanCacheModel.description = getDescription();

		String description = loanCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			loanCacheModel.description = null;
		}

		loanCacheModel.contactPerson = getContactPerson();

		String contactPerson = loanCacheModel.contactPerson;

		if ((contactPerson != null) && (contactPerson.length() == 0)) {
			loanCacheModel.contactPerson = null;
		}

		loanCacheModel.positionPerson = getPositionPerson();

		String positionPerson = loanCacheModel.positionPerson;

		if ((positionPerson != null) && (positionPerson.length() == 0)) {
			loanCacheModel.positionPerson = null;
		}

		loanCacheModel.telephone = getTelephone();

		String telephone = loanCacheModel.telephone;

		if ((telephone != null) && (telephone.length() == 0)) {
			loanCacheModel.telephone = null;
		}

		loanCacheModel.email = getEmail();

		String email = loanCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			loanCacheModel.email = null;
		}

		loanCacheModel.pmt = getPmt();

		String pmt = loanCacheModel.pmt;

		if ((pmt != null) && (pmt.length() == 0)) {
			loanCacheModel.pmt = null;
		}

		loanCacheModel.status = getStatus();

		String status = loanCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			loanCacheModel.status = null;
		}

		loanCacheModel.groupId = getGroupId();

		loanCacheModel.companyId = getCompanyId();

		loanCacheModel.userId = getUserId();

		loanCacheModel.userName = getUserName();

		String userName = loanCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			loanCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			loanCacheModel.createDate = createDate.getTime();
		}
		else {
			loanCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			loanCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			loanCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return loanCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{loanId=");
		sb.append(getLoanId());
		sb.append(", localEntityId=");
		sb.append(getLocalEntityId());
		sb.append(", pickupDate=");
		sb.append(getPickupDate());
		sb.append(", returnDate=");
		sb.append(getReturnDate());
		sb.append(", activityDate=");
		sb.append(getActivityDate());
		sb.append(", activityName=");
		sb.append(getActivityName());
		sb.append(", participantsNum=");
		sb.append(getParticipantsNum());
		sb.append(", participantsKidsNum=");
		sb.append(getParticipantsKidsNum());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", contactPerson=");
		sb.append(getContactPerson());
		sb.append(", positionPerson=");
		sb.append(getPositionPerson());
		sb.append(", telephone=");
		sb.append(getTelephone());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", pmt=");
		sb.append(getPmt());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("cat.diba.materialesportiu.model.Loan");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>loanId</column-name><column-value><![CDATA[");
		sb.append(getLoanId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localEntityId</column-name><column-value><![CDATA[");
		sb.append(getLocalEntityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pickupDate</column-name><column-value><![CDATA[");
		sb.append(getPickupDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>returnDate</column-name><column-value><![CDATA[");
		sb.append(getReturnDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activityDate</column-name><column-value><![CDATA[");
		sb.append(getActivityDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activityName</column-name><column-value><![CDATA[");
		sb.append(getActivityName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>participantsNum</column-name><column-value><![CDATA[");
		sb.append(getParticipantsNum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>participantsKidsNum</column-name><column-value><![CDATA[");
		sb.append(getParticipantsKidsNum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactPerson</column-name><column-value><![CDATA[");
		sb.append(getContactPerson());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>positionPerson</column-name><column-value><![CDATA[");
		sb.append(getPositionPerson());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telephone</column-name><column-value><![CDATA[");
		sb.append(getTelephone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pmt</column-name><column-value><![CDATA[");
		sb.append(getPmt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Loan.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Loan.class, ModelWrapper.class
		};
	private long _loanId;
	private long _localEntityId;
	private Date _pickupDate;
	private Date _originalPickupDate;
	private Date _returnDate;
	private Date _originalReturnDate;
	private Date _activityDate;
	private String _activityName;
	private int _participantsNum;
	private int _participantsKidsNum;
	private String _description;
	private String _contactPerson;
	private String _positionPerson;
	private String _telephone;
	private String _email;
	private String _pmt;
	private String _status;
	private String _originalStatus;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _columnBitmask;
	private Loan _escapedModel;
}
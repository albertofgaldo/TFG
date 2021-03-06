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
import cat.diba.materialesportiu.model.LocalEntityModel;

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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the LocalEntity service. Represents a row in the &quot;PME_LocalEntity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link LocalEntityModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LocalEntityImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalEntityImpl
 * @see LocalEntity
 * @see LocalEntityModel
 * @generated
 */
@ProviderType
public class LocalEntityModelImpl extends BaseModelImpl<LocalEntity>
	implements LocalEntityModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a local entity model instance should use the {@link LocalEntity} interface instead.
	 */
	public static final String TABLE_NAME = "PME_LocalEntity";
	public static final Object[][] TABLE_COLUMNS = {
			{ "localEntityId", Types.BIGINT },
			{ "cif", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "telephone", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("localEntityId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("cif", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("telephone", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table PME_LocalEntity (localEntityId LONG not null primary key,cif VARCHAR(75) null,name VARCHAR(75) null,telephone VARCHAR(75) null,email VARCHAR(75) null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table PME_LocalEntity";
	public static final String ORDER_BY_JPQL = " ORDER BY localEntity.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY PME_LocalEntity.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(cat.diba.materialesportiu.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.cat.diba.materialesportiu.model.LocalEntity"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(cat.diba.materialesportiu.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.cat.diba.materialesportiu.model.LocalEntity"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(cat.diba.materialesportiu.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.cat.diba.materialesportiu.model.LocalEntity"),
			true);
	public static final long CIF_COLUMN_BITMASK = 1L;
	public static final long COMPANYID_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long NAME_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(cat.diba.materialesportiu.service.util.ServiceProps.get(
				"lock.expiration.time.cat.diba.materialesportiu.model.LocalEntity"));

	public LocalEntityModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _localEntityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLocalEntityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _localEntityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return LocalEntity.class;
	}

	@Override
	public String getModelClassName() {
		return LocalEntity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("localEntityId", getLocalEntityId());
		attributes.put("cif", getCif());
		attributes.put("name", getName());
		attributes.put("telephone", getTelephone());
		attributes.put("email", getEmail());
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
		Long localEntityId = (Long)attributes.get("localEntityId");

		if (localEntityId != null) {
			setLocalEntityId(localEntityId);
		}

		String cif = (String)attributes.get("cif");

		if (cif != null) {
			setCif(cif);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String telephone = (String)attributes.get("telephone");

		if (telephone != null) {
			setTelephone(telephone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
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
	public long getLocalEntityId() {
		return _localEntityId;
	}

	@Override
	public void setLocalEntityId(long localEntityId) {
		_localEntityId = localEntityId;
	}

	@Override
	public String getCif() {
		if (_cif == null) {
			return "";
		}
		else {
			return _cif;
		}
	}

	@Override
	public void setCif(String cif) {
		_columnBitmask |= CIF_COLUMN_BITMASK;

		if (_originalCif == null) {
			_originalCif = _cif;
		}

		_cif = cif;
	}

	public String getOriginalCif() {
		return GetterUtil.getString(_originalCif);
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
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
			LocalEntity.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LocalEntity toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (LocalEntity)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LocalEntityImpl localEntityImpl = new LocalEntityImpl();

		localEntityImpl.setLocalEntityId(getLocalEntityId());
		localEntityImpl.setCif(getCif());
		localEntityImpl.setName(getName());
		localEntityImpl.setTelephone(getTelephone());
		localEntityImpl.setEmail(getEmail());
		localEntityImpl.setGroupId(getGroupId());
		localEntityImpl.setCompanyId(getCompanyId());
		localEntityImpl.setUserId(getUserId());
		localEntityImpl.setUserName(getUserName());
		localEntityImpl.setCreateDate(getCreateDate());
		localEntityImpl.setModifiedDate(getModifiedDate());

		localEntityImpl.resetOriginalValues();

		return localEntityImpl;
	}

	@Override
	public int compareTo(LocalEntity localEntity) {
		int value = 0;

		value = getName().compareTo(localEntity.getName());

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

		if (!(obj instanceof LocalEntity)) {
			return false;
		}

		LocalEntity localEntity = (LocalEntity)obj;

		long primaryKey = localEntity.getPrimaryKey();

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
		LocalEntityModelImpl localEntityModelImpl = this;

		localEntityModelImpl._originalCif = localEntityModelImpl._cif;

		localEntityModelImpl._originalName = localEntityModelImpl._name;

		localEntityModelImpl._originalGroupId = localEntityModelImpl._groupId;

		localEntityModelImpl._setOriginalGroupId = false;

		localEntityModelImpl._originalCompanyId = localEntityModelImpl._companyId;

		localEntityModelImpl._setOriginalCompanyId = false;

		localEntityModelImpl._setModifiedDate = false;

		localEntityModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LocalEntity> toCacheModel() {
		LocalEntityCacheModel localEntityCacheModel = new LocalEntityCacheModel();

		localEntityCacheModel.localEntityId = getLocalEntityId();

		localEntityCacheModel.cif = getCif();

		String cif = localEntityCacheModel.cif;

		if ((cif != null) && (cif.length() == 0)) {
			localEntityCacheModel.cif = null;
		}

		localEntityCacheModel.name = getName();

		String name = localEntityCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			localEntityCacheModel.name = null;
		}

		localEntityCacheModel.telephone = getTelephone();

		String telephone = localEntityCacheModel.telephone;

		if ((telephone != null) && (telephone.length() == 0)) {
			localEntityCacheModel.telephone = null;
		}

		localEntityCacheModel.email = getEmail();

		String email = localEntityCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			localEntityCacheModel.email = null;
		}

		localEntityCacheModel.groupId = getGroupId();

		localEntityCacheModel.companyId = getCompanyId();

		localEntityCacheModel.userId = getUserId();

		localEntityCacheModel.userName = getUserName();

		String userName = localEntityCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			localEntityCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			localEntityCacheModel.createDate = createDate.getTime();
		}
		else {
			localEntityCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			localEntityCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			localEntityCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return localEntityCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{localEntityId=");
		sb.append(getLocalEntityId());
		sb.append(", cif=");
		sb.append(getCif());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", telephone=");
		sb.append(getTelephone());
		sb.append(", email=");
		sb.append(getEmail());
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
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("cat.diba.materialesportiu.model.LocalEntity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>localEntityId</column-name><column-value><![CDATA[");
		sb.append(getLocalEntityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cif</column-name><column-value><![CDATA[");
		sb.append(getCif());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
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

	private static final ClassLoader _classLoader = LocalEntity.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			LocalEntity.class, ModelWrapper.class
		};
	private long _localEntityId;
	private String _cif;
	private String _originalCif;
	private String _name;
	private String _originalName;
	private String _telephone;
	private String _email;
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
	private LocalEntity _escapedModel;
}
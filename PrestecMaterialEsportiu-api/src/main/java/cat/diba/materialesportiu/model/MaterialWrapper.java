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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Material}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Material
 * @generated
 */
@ProviderType
public class MaterialWrapper implements Material, ModelWrapper<Material> {
	public MaterialWrapper(Material material) {
		_material = material;
	}

	@Override
	public Class<?> getModelClass() {
		return Material.class;
	}

	@Override
	public String getModelClassName() {
		return Material.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("materialId", getMaterialId());
		attributes.put("name", getName());
		attributes.put("heigh", getHeigh());
		attributes.put("width", getWidth());
		attributes.put("longitude", getLongitude());
		attributes.put("weight", getWeight());
		attributes.put("activityId", getActivityId());
		attributes.put("quantity", getQuantity());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long materialId = (Long)attributes.get("materialId");

		if (materialId != null) {
			setMaterialId(materialId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Float heigh = (Float)attributes.get("heigh");

		if (heigh != null) {
			setHeigh(heigh);
		}

		Float width = (Float)attributes.get("width");

		if (width != null) {
			setWidth(width);
		}

		Float longitude = (Float)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		Float weight = (Float)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		Long activityId = (Long)attributes.get("activityId");

		if (activityId != null) {
			setActivityId(activityId);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
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
	public Object clone() {
		return new MaterialWrapper((Material)_material.clone());
	}

	@Override
	public int compareTo(Material material) {
		return _material.compareTo(material);
	}

	/**
	* Returns the activity ID of this material.
	*
	* @return the activity ID of this material
	*/
	@Override
	public long getActivityId() {
		return _material.getActivityId();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return _material.getAvailableLanguageIds();
	}

	/**
	* Returns the company ID of this material.
	*
	* @return the company ID of this material
	*/
	@Override
	public long getCompanyId() {
		return _material.getCompanyId();
	}

	/**
	* Returns the create date of this material.
	*
	* @return the create date of this material
	*/
	@Override
	public Date getCreateDate() {
		return _material.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return _material.getDefaultLanguageId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _material.getExpandoBridge();
	}

	/**
	* Returns the group ID of this material.
	*
	* @return the group ID of this material
	*/
	@Override
	public long getGroupId() {
		return _material.getGroupId();
	}

	/**
	* Returns the heigh of this material.
	*
	* @return the heigh of this material
	*/
	@Override
	public float getHeigh() {
		return _material.getHeigh();
	}

	/**
	* Returns the longitude of this material.
	*
	* @return the longitude of this material
	*/
	@Override
	public float getLongitude() {
		return _material.getLongitude();
	}

	/**
	* Returns the material ID of this material.
	*
	* @return the material ID of this material
	*/
	@Override
	public long getMaterialId() {
		return _material.getMaterialId();
	}

	/**
	* Returns the modified date of this material.
	*
	* @return the modified date of this material
	*/
	@Override
	public Date getModifiedDate() {
		return _material.getModifiedDate();
	}

	/**
	* Returns the name of this material.
	*
	* @return the name of this material
	*/
	@Override
	public String getName() {
		return _material.getName();
	}

	/**
	* Returns the localized name of this material in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this material
	*/
	@Override
	public String getName(java.util.Locale locale) {
		return _material.getName(locale);
	}

	/**
	* Returns the localized name of this material in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this material. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return _material.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this material in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this material
	*/
	@Override
	public String getName(String languageId) {
		return _material.getName(languageId);
	}

	/**
	* Returns the localized name of this material in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this material
	*/
	@Override
	public String getName(String languageId, boolean useDefault) {
		return _material.getName(languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _material.getNameCurrentLanguageId();
	}

	@Override
	public String getNameCurrentValue() {
		return _material.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this material.
	*
	* @return the locales and localized names of this material
	*/
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return _material.getNameMap();
	}

	/**
	* Returns the primary key of this material.
	*
	* @return the primary key of this material
	*/
	@Override
	public long getPrimaryKey() {
		return _material.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _material.getPrimaryKeyObj();
	}

	/**
	* Returns the quantity of this material.
	*
	* @return the quantity of this material
	*/
	@Override
	public int getQuantity() {
		return _material.getQuantity();
	}

	/**
	* Returns the user ID of this material.
	*
	* @return the user ID of this material
	*/
	@Override
	public long getUserId() {
		return _material.getUserId();
	}

	/**
	* Returns the user name of this material.
	*
	* @return the user name of this material
	*/
	@Override
	public String getUserName() {
		return _material.getUserName();
	}

	/**
	* Returns the user uuid of this material.
	*
	* @return the user uuid of this material
	*/
	@Override
	public String getUserUuid() {
		return _material.getUserUuid();
	}

	/**
	* Returns the weight of this material.
	*
	* @return the weight of this material
	*/
	@Override
	public float getWeight() {
		return _material.getWeight();
	}

	/**
	* Returns the width of this material.
	*
	* @return the width of this material
	*/
	@Override
	public float getWidth() {
		return _material.getWidth();
	}

	@Override
	public int hashCode() {
		return _material.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _material.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _material.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _material.isNew();
	}

	@Override
	public void persist() {
		_material.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_material.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_material.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	* Sets the activity ID of this material.
	*
	* @param activityId the activity ID of this material
	*/
	@Override
	public void setActivityId(long activityId) {
		_material.setActivityId(activityId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_material.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this material.
	*
	* @param companyId the company ID of this material
	*/
	@Override
	public void setCompanyId(long companyId) {
		_material.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this material.
	*
	* @param createDate the create date of this material
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_material.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_material.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_material.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_material.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this material.
	*
	* @param groupId the group ID of this material
	*/
	@Override
	public void setGroupId(long groupId) {
		_material.setGroupId(groupId);
	}

	/**
	* Sets the heigh of this material.
	*
	* @param heigh the heigh of this material
	*/
	@Override
	public void setHeigh(float heigh) {
		_material.setHeigh(heigh);
	}

	/**
	* Sets the longitude of this material.
	*
	* @param longitude the longitude of this material
	*/
	@Override
	public void setLongitude(float longitude) {
		_material.setLongitude(longitude);
	}

	/**
	* Sets the material ID of this material.
	*
	* @param materialId the material ID of this material
	*/
	@Override
	public void setMaterialId(long materialId) {
		_material.setMaterialId(materialId);
	}

	/**
	* Sets the modified date of this material.
	*
	* @param modifiedDate the modified date of this material
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_material.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this material.
	*
	* @param name the name of this material
	*/
	@Override
	public void setName(String name) {
		_material.setName(name);
	}

	/**
	* Sets the localized name of this material in the language.
	*
	* @param name the localized name of this material
	* @param locale the locale of the language
	*/
	@Override
	public void setName(String name, java.util.Locale locale) {
		_material.setName(name, locale);
	}

	/**
	* Sets the localized name of this material in the language, and sets the default locale.
	*
	* @param name the localized name of this material
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_material.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_material.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this material from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this material
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		_material.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this material from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this material
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap,
		java.util.Locale defaultLocale) {
		_material.setNameMap(nameMap, defaultLocale);
	}

	@Override
	public void setNew(boolean n) {
		_material.setNew(n);
	}

	/**
	* Sets the primary key of this material.
	*
	* @param primaryKey the primary key of this material
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_material.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_material.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the quantity of this material.
	*
	* @param quantity the quantity of this material
	*/
	@Override
	public void setQuantity(int quantity) {
		_material.setQuantity(quantity);
	}

	/**
	* Sets the user ID of this material.
	*
	* @param userId the user ID of this material
	*/
	@Override
	public void setUserId(long userId) {
		_material.setUserId(userId);
	}

	/**
	* Sets the user name of this material.
	*
	* @param userName the user name of this material
	*/
	@Override
	public void setUserName(String userName) {
		_material.setUserName(userName);
	}

	/**
	* Sets the user uuid of this material.
	*
	* @param userUuid the user uuid of this material
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_material.setUserUuid(userUuid);
	}

	/**
	* Sets the weight of this material.
	*
	* @param weight the weight of this material
	*/
	@Override
	public void setWeight(float weight) {
		_material.setWeight(weight);
	}

	/**
	* Sets the width of this material.
	*
	* @param width the width of this material
	*/
	@Override
	public void setWidth(float width) {
		_material.setWidth(width);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Material> toCacheModel() {
		return _material.toCacheModel();
	}

	@Override
	public Material toEscapedModel() {
		return new MaterialWrapper(_material.toEscapedModel());
	}

	@Override
	public String toString() {
		return _material.toString();
	}

	@Override
	public Material toUnescapedModel() {
		return new MaterialWrapper(_material.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _material.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MaterialWrapper)) {
			return false;
		}

		MaterialWrapper materialWrapper = (MaterialWrapper)obj;

		if (Objects.equals(_material, materialWrapper._material)) {
			return true;
		}

		return false;
	}

	@Override
	public Material getWrappedModel() {
		return _material;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _material.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _material.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_material.resetOriginalValues();
	}

	private final Material _material;
}
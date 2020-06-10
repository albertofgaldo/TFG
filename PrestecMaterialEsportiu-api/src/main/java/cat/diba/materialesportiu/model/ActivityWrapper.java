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
 * This class is a wrapper for {@link Activity}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Activity
 * @generated
 */
@ProviderType
public class ActivityWrapper implements Activity, ModelWrapper<Activity> {
	public ActivityWrapper(Activity activity) {
		_activity = activity;
	}

	@Override
	public Class<?> getModelClass() {
		return Activity.class;
	}

	@Override
	public String getModelClassName() {
		return Activity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("activityId", getActivityId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("age", getAge());
		attributes.put("minParticipants", getMinParticipants());
		attributes.put("maxParticipants", getMaxParticipants());
		attributes.put("usageRules", getUsageRules());
		attributes.put("loanConditions", getLoanConditions());
		attributes.put("titulationIsRequired", isTitulationIsRequired());
		attributes.put("totalStock", getTotalStock());
		attributes.put("availableStock", getAvailableStock());
		attributes.put("daysBeforeLoan", getDaysBeforeLoan());
		attributes.put("daysBooking", getDaysBooking());
		attributes.put("daysAfterLoan", getDaysAfterLoan());
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
		Long activityId = (Long)attributes.get("activityId");

		if (activityId != null) {
			setActivityId(activityId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer age = (Integer)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		Integer minParticipants = (Integer)attributes.get("minParticipants");

		if (minParticipants != null) {
			setMinParticipants(minParticipants);
		}

		Integer maxParticipants = (Integer)attributes.get("maxParticipants");

		if (maxParticipants != null) {
			setMaxParticipants(maxParticipants);
		}

		String usageRules = (String)attributes.get("usageRules");

		if (usageRules != null) {
			setUsageRules(usageRules);
		}

		String loanConditions = (String)attributes.get("loanConditions");

		if (loanConditions != null) {
			setLoanConditions(loanConditions);
		}

		Boolean titulationIsRequired = (Boolean)attributes.get(
				"titulationIsRequired");

		if (titulationIsRequired != null) {
			setTitulationIsRequired(titulationIsRequired);
		}

		Integer totalStock = (Integer)attributes.get("totalStock");

		if (totalStock != null) {
			setTotalStock(totalStock);
		}

		Integer availableStock = (Integer)attributes.get("availableStock");

		if (availableStock != null) {
			setAvailableStock(availableStock);
		}

		Integer daysBeforeLoan = (Integer)attributes.get("daysBeforeLoan");

		if (daysBeforeLoan != null) {
			setDaysBeforeLoan(daysBeforeLoan);
		}

		Integer daysBooking = (Integer)attributes.get("daysBooking");

		if (daysBooking != null) {
			setDaysBooking(daysBooking);
		}

		Integer daysAfterLoan = (Integer)attributes.get("daysAfterLoan");

		if (daysAfterLoan != null) {
			setDaysAfterLoan(daysAfterLoan);
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
		return new ActivityWrapper((Activity)_activity.clone());
	}

	@Override
	public int compareTo(Activity activity) {
		return _activity.compareTo(activity);
	}

	/**
	* Returns the activity ID of this activity.
	*
	* @return the activity ID of this activity
	*/
	@Override
	public long getActivityId() {
		return _activity.getActivityId();
	}

	/**
	* Returns the age of this activity.
	*
	* @return the age of this activity
	*/
	@Override
	public int getAge() {
		return _activity.getAge();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return _activity.getAvailableLanguageIds();
	}

	/**
	* Returns the available stock of this activity.
	*
	* @return the available stock of this activity
	*/
	@Override
	public int getAvailableStock() {
		return _activity.getAvailableStock();
	}

	/**
	* Returns the company ID of this activity.
	*
	* @return the company ID of this activity
	*/
	@Override
	public long getCompanyId() {
		return _activity.getCompanyId();
	}

	/**
	* Returns the create date of this activity.
	*
	* @return the create date of this activity
	*/
	@Override
	public Date getCreateDate() {
		return _activity.getCreateDate();
	}

	/**
	* Returns the days after loan of this activity.
	*
	* @return the days after loan of this activity
	*/
	@Override
	public int getDaysAfterLoan() {
		return _activity.getDaysAfterLoan();
	}

	/**
	* Returns the days before loan of this activity.
	*
	* @return the days before loan of this activity
	*/
	@Override
	public int getDaysBeforeLoan() {
		return _activity.getDaysBeforeLoan();
	}

	/**
	* Returns the days booking of this activity.
	*
	* @return the days booking of this activity
	*/
	@Override
	public int getDaysBooking() {
		return _activity.getDaysBooking();
	}

	@Override
	public String getDefaultLanguageId() {
		return _activity.getDefaultLanguageId();
	}

	/**
	* Returns the description of this activity.
	*
	* @return the description of this activity
	*/
	@Override
	public String getDescription() {
		return _activity.getDescription();
	}

	/**
	* Returns the localized description of this activity in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this activity
	*/
	@Override
	public String getDescription(java.util.Locale locale) {
		return _activity.getDescription(locale);
	}

	/**
	* Returns the localized description of this activity in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this activity. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return _activity.getDescription(locale, useDefault);
	}

	/**
	* Returns the localized description of this activity in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this activity
	*/
	@Override
	public String getDescription(String languageId) {
		return _activity.getDescription(languageId);
	}

	/**
	* Returns the localized description of this activity in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this activity
	*/
	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return _activity.getDescription(languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _activity.getDescriptionCurrentLanguageId();
	}

	@Override
	public String getDescriptionCurrentValue() {
		return _activity.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this activity.
	*
	* @return the locales and localized descriptions of this activity
	*/
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return _activity.getDescriptionMap();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _activity.getExpandoBridge();
	}

	/**
	* Returns the group ID of this activity.
	*
	* @return the group ID of this activity
	*/
	@Override
	public long getGroupId() {
		return _activity.getGroupId();
	}

	/**
	* Returns the loan conditions of this activity.
	*
	* @return the loan conditions of this activity
	*/
	@Override
	public String getLoanConditions() {
		return _activity.getLoanConditions();
	}

	/**
	* Returns the localized loan conditions of this activity in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized loan conditions of this activity
	*/
	@Override
	public String getLoanConditions(java.util.Locale locale) {
		return _activity.getLoanConditions(locale);
	}

	/**
	* Returns the localized loan conditions of this activity in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized loan conditions of this activity. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public String getLoanConditions(java.util.Locale locale, boolean useDefault) {
		return _activity.getLoanConditions(locale, useDefault);
	}

	/**
	* Returns the localized loan conditions of this activity in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized loan conditions of this activity
	*/
	@Override
	public String getLoanConditions(String languageId) {
		return _activity.getLoanConditions(languageId);
	}

	/**
	* Returns the localized loan conditions of this activity in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized loan conditions of this activity
	*/
	@Override
	public String getLoanConditions(String languageId, boolean useDefault) {
		return _activity.getLoanConditions(languageId, useDefault);
	}

	@Override
	public String getLoanConditionsCurrentLanguageId() {
		return _activity.getLoanConditionsCurrentLanguageId();
	}

	@Override
	public String getLoanConditionsCurrentValue() {
		return _activity.getLoanConditionsCurrentValue();
	}

	/**
	* Returns a map of the locales and localized loan conditionses of this activity.
	*
	* @return the locales and localized loan conditionses of this activity
	*/
	@Override
	public Map<java.util.Locale, String> getLoanConditionsMap() {
		return _activity.getLoanConditionsMap();
	}

	/**
	* Returns the max participants of this activity.
	*
	* @return the max participants of this activity
	*/
	@Override
	public int getMaxParticipants() {
		return _activity.getMaxParticipants();
	}

	/**
	* Returns the min participants of this activity.
	*
	* @return the min participants of this activity
	*/
	@Override
	public int getMinParticipants() {
		return _activity.getMinParticipants();
	}

	/**
	* Returns the modified date of this activity.
	*
	* @return the modified date of this activity
	*/
	@Override
	public Date getModifiedDate() {
		return _activity.getModifiedDate();
	}

	/**
	* Returns the name of this activity.
	*
	* @return the name of this activity
	*/
	@Override
	public String getName() {
		return _activity.getName();
	}

	/**
	* Returns the localized name of this activity in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this activity
	*/
	@Override
	public String getName(java.util.Locale locale) {
		return _activity.getName(locale);
	}

	/**
	* Returns the localized name of this activity in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this activity. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return _activity.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this activity in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this activity
	*/
	@Override
	public String getName(String languageId) {
		return _activity.getName(languageId);
	}

	/**
	* Returns the localized name of this activity in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this activity
	*/
	@Override
	public String getName(String languageId, boolean useDefault) {
		return _activity.getName(languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _activity.getNameCurrentLanguageId();
	}

	@Override
	public String getNameCurrentValue() {
		return _activity.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this activity.
	*
	* @return the locales and localized names of this activity
	*/
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return _activity.getNameMap();
	}

	/**
	* Returns the primary key of this activity.
	*
	* @return the primary key of this activity
	*/
	@Override
	public long getPrimaryKey() {
		return _activity.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _activity.getPrimaryKeyObj();
	}

	/**
	* Returns the titulation is required of this activity.
	*
	* @return the titulation is required of this activity
	*/
	@Override
	public boolean getTitulationIsRequired() {
		return _activity.getTitulationIsRequired();
	}

	/**
	* Returns the total stock of this activity.
	*
	* @return the total stock of this activity
	*/
	@Override
	public int getTotalStock() {
		return _activity.getTotalStock();
	}

	/**
	* Returns the usage rules of this activity.
	*
	* @return the usage rules of this activity
	*/
	@Override
	public String getUsageRules() {
		return _activity.getUsageRules();
	}

	/**
	* Returns the localized usage rules of this activity in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized usage rules of this activity
	*/
	@Override
	public String getUsageRules(java.util.Locale locale) {
		return _activity.getUsageRules(locale);
	}

	/**
	* Returns the localized usage rules of this activity in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized usage rules of this activity. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public String getUsageRules(java.util.Locale locale, boolean useDefault) {
		return _activity.getUsageRules(locale, useDefault);
	}

	/**
	* Returns the localized usage rules of this activity in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized usage rules of this activity
	*/
	@Override
	public String getUsageRules(String languageId) {
		return _activity.getUsageRules(languageId);
	}

	/**
	* Returns the localized usage rules of this activity in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized usage rules of this activity
	*/
	@Override
	public String getUsageRules(String languageId, boolean useDefault) {
		return _activity.getUsageRules(languageId, useDefault);
	}

	@Override
	public String getUsageRulesCurrentLanguageId() {
		return _activity.getUsageRulesCurrentLanguageId();
	}

	@Override
	public String getUsageRulesCurrentValue() {
		return _activity.getUsageRulesCurrentValue();
	}

	/**
	* Returns a map of the locales and localized usage ruleses of this activity.
	*
	* @return the locales and localized usage ruleses of this activity
	*/
	@Override
	public Map<java.util.Locale, String> getUsageRulesMap() {
		return _activity.getUsageRulesMap();
	}

	/**
	* Returns the user ID of this activity.
	*
	* @return the user ID of this activity
	*/
	@Override
	public long getUserId() {
		return _activity.getUserId();
	}

	/**
	* Returns the user name of this activity.
	*
	* @return the user name of this activity
	*/
	@Override
	public String getUserName() {
		return _activity.getUserName();
	}

	/**
	* Returns the user uuid of this activity.
	*
	* @return the user uuid of this activity
	*/
	@Override
	public String getUserUuid() {
		return _activity.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _activity.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _activity.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _activity.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _activity.isNew();
	}

	/**
	* Returns <code>true</code> if this activity is titulation is required.
	*
	* @return <code>true</code> if this activity is titulation is required; <code>false</code> otherwise
	*/
	@Override
	public boolean isTitulationIsRequired() {
		return _activity.isTitulationIsRequired();
	}

	@Override
	public void persist() {
		_activity.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_activity.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_activity.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	* Sets the activity ID of this activity.
	*
	* @param activityId the activity ID of this activity
	*/
	@Override
	public void setActivityId(long activityId) {
		_activity.setActivityId(activityId);
	}

	/**
	* Sets the age of this activity.
	*
	* @param age the age of this activity
	*/
	@Override
	public void setAge(int age) {
		_activity.setAge(age);
	}

	/**
	* Sets the available stock of this activity.
	*
	* @param availableStock the available stock of this activity
	*/
	@Override
	public void setAvailableStock(int availableStock) {
		_activity.setAvailableStock(availableStock);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_activity.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this activity.
	*
	* @param companyId the company ID of this activity
	*/
	@Override
	public void setCompanyId(long companyId) {
		_activity.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this activity.
	*
	* @param createDate the create date of this activity
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_activity.setCreateDate(createDate);
	}

	/**
	* Sets the days after loan of this activity.
	*
	* @param daysAfterLoan the days after loan of this activity
	*/
	@Override
	public void setDaysAfterLoan(int daysAfterLoan) {
		_activity.setDaysAfterLoan(daysAfterLoan);
	}

	/**
	* Sets the days before loan of this activity.
	*
	* @param daysBeforeLoan the days before loan of this activity
	*/
	@Override
	public void setDaysBeforeLoan(int daysBeforeLoan) {
		_activity.setDaysBeforeLoan(daysBeforeLoan);
	}

	/**
	* Sets the days booking of this activity.
	*
	* @param daysBooking the days booking of this activity
	*/
	@Override
	public void setDaysBooking(int daysBooking) {
		_activity.setDaysBooking(daysBooking);
	}

	/**
	* Sets the description of this activity.
	*
	* @param description the description of this activity
	*/
	@Override
	public void setDescription(String description) {
		_activity.setDescription(description);
	}

	/**
	* Sets the localized description of this activity in the language.
	*
	* @param description the localized description of this activity
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		_activity.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this activity in the language, and sets the default locale.
	*
	* @param description the localized description of this activity
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(String description, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_activity.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_activity.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this activity from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this activity
	*/
	@Override
	public void setDescriptionMap(Map<java.util.Locale, String> descriptionMap) {
		_activity.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this activity from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this activity
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {
		_activity.setDescriptionMap(descriptionMap, defaultLocale);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_activity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_activity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_activity.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this activity.
	*
	* @param groupId the group ID of this activity
	*/
	@Override
	public void setGroupId(long groupId) {
		_activity.setGroupId(groupId);
	}

	/**
	* Sets the loan conditions of this activity.
	*
	* @param loanConditions the loan conditions of this activity
	*/
	@Override
	public void setLoanConditions(String loanConditions) {
		_activity.setLoanConditions(loanConditions);
	}

	/**
	* Sets the localized loan conditions of this activity in the language.
	*
	* @param loanConditions the localized loan conditions of this activity
	* @param locale the locale of the language
	*/
	@Override
	public void setLoanConditions(String loanConditions, java.util.Locale locale) {
		_activity.setLoanConditions(loanConditions, locale);
	}

	/**
	* Sets the localized loan conditions of this activity in the language, and sets the default locale.
	*
	* @param loanConditions the localized loan conditions of this activity
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setLoanConditions(String loanConditions,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_activity.setLoanConditions(loanConditions, locale, defaultLocale);
	}

	@Override
	public void setLoanConditionsCurrentLanguageId(String languageId) {
		_activity.setLoanConditionsCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized loan conditionses of this activity from the map of locales and localized loan conditionses.
	*
	* @param loanConditionsMap the locales and localized loan conditionses of this activity
	*/
	@Override
	public void setLoanConditionsMap(
		Map<java.util.Locale, String> loanConditionsMap) {
		_activity.setLoanConditionsMap(loanConditionsMap);
	}

	/**
	* Sets the localized loan conditionses of this activity from the map of locales and localized loan conditionses, and sets the default locale.
	*
	* @param loanConditionsMap the locales and localized loan conditionses of this activity
	* @param defaultLocale the default locale
	*/
	@Override
	public void setLoanConditionsMap(
		Map<java.util.Locale, String> loanConditionsMap,
		java.util.Locale defaultLocale) {
		_activity.setLoanConditionsMap(loanConditionsMap, defaultLocale);
	}

	/**
	* Sets the max participants of this activity.
	*
	* @param maxParticipants the max participants of this activity
	*/
	@Override
	public void setMaxParticipants(int maxParticipants) {
		_activity.setMaxParticipants(maxParticipants);
	}

	/**
	* Sets the min participants of this activity.
	*
	* @param minParticipants the min participants of this activity
	*/
	@Override
	public void setMinParticipants(int minParticipants) {
		_activity.setMinParticipants(minParticipants);
	}

	/**
	* Sets the modified date of this activity.
	*
	* @param modifiedDate the modified date of this activity
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_activity.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this activity.
	*
	* @param name the name of this activity
	*/
	@Override
	public void setName(String name) {
		_activity.setName(name);
	}

	/**
	* Sets the localized name of this activity in the language.
	*
	* @param name the localized name of this activity
	* @param locale the locale of the language
	*/
	@Override
	public void setName(String name, java.util.Locale locale) {
		_activity.setName(name, locale);
	}

	/**
	* Sets the localized name of this activity in the language, and sets the default locale.
	*
	* @param name the localized name of this activity
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_activity.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_activity.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this activity from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this activity
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		_activity.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this activity from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this activity
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap,
		java.util.Locale defaultLocale) {
		_activity.setNameMap(nameMap, defaultLocale);
	}

	@Override
	public void setNew(boolean n) {
		_activity.setNew(n);
	}

	/**
	* Sets the primary key of this activity.
	*
	* @param primaryKey the primary key of this activity
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_activity.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_activity.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this activity is titulation is required.
	*
	* @param titulationIsRequired the titulation is required of this activity
	*/
	@Override
	public void setTitulationIsRequired(boolean titulationIsRequired) {
		_activity.setTitulationIsRequired(titulationIsRequired);
	}

	/**
	* Sets the total stock of this activity.
	*
	* @param totalStock the total stock of this activity
	*/
	@Override
	public void setTotalStock(int totalStock) {
		_activity.setTotalStock(totalStock);
	}

	/**
	* Sets the usage rules of this activity.
	*
	* @param usageRules the usage rules of this activity
	*/
	@Override
	public void setUsageRules(String usageRules) {
		_activity.setUsageRules(usageRules);
	}

	/**
	* Sets the localized usage rules of this activity in the language.
	*
	* @param usageRules the localized usage rules of this activity
	* @param locale the locale of the language
	*/
	@Override
	public void setUsageRules(String usageRules, java.util.Locale locale) {
		_activity.setUsageRules(usageRules, locale);
	}

	/**
	* Sets the localized usage rules of this activity in the language, and sets the default locale.
	*
	* @param usageRules the localized usage rules of this activity
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setUsageRules(String usageRules, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_activity.setUsageRules(usageRules, locale, defaultLocale);
	}

	@Override
	public void setUsageRulesCurrentLanguageId(String languageId) {
		_activity.setUsageRulesCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized usage ruleses of this activity from the map of locales and localized usage ruleses.
	*
	* @param usageRulesMap the locales and localized usage ruleses of this activity
	*/
	@Override
	public void setUsageRulesMap(Map<java.util.Locale, String> usageRulesMap) {
		_activity.setUsageRulesMap(usageRulesMap);
	}

	/**
	* Sets the localized usage ruleses of this activity from the map of locales and localized usage ruleses, and sets the default locale.
	*
	* @param usageRulesMap the locales and localized usage ruleses of this activity
	* @param defaultLocale the default locale
	*/
	@Override
	public void setUsageRulesMap(Map<java.util.Locale, String> usageRulesMap,
		java.util.Locale defaultLocale) {
		_activity.setUsageRulesMap(usageRulesMap, defaultLocale);
	}

	/**
	* Sets the user ID of this activity.
	*
	* @param userId the user ID of this activity
	*/
	@Override
	public void setUserId(long userId) {
		_activity.setUserId(userId);
	}

	/**
	* Sets the user name of this activity.
	*
	* @param userName the user name of this activity
	*/
	@Override
	public void setUserName(String userName) {
		_activity.setUserName(userName);
	}

	/**
	* Sets the user uuid of this activity.
	*
	* @param userUuid the user uuid of this activity
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_activity.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Activity> toCacheModel() {
		return _activity.toCacheModel();
	}

	@Override
	public Activity toEscapedModel() {
		return new ActivityWrapper(_activity.toEscapedModel());
	}

	@Override
	public String toString() {
		return _activity.toString();
	}

	@Override
	public Activity toUnescapedModel() {
		return new ActivityWrapper(_activity.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _activity.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ActivityWrapper)) {
			return false;
		}

		ActivityWrapper activityWrapper = (ActivityWrapper)obj;

		if (Objects.equals(_activity, activityWrapper._activity)) {
			return true;
		}

		return false;
	}

	@Override
	public Activity getWrappedModel() {
		return _activity;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _activity.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _activity.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_activity.resetOriginalValues();
	}

	private final Activity _activity;
}
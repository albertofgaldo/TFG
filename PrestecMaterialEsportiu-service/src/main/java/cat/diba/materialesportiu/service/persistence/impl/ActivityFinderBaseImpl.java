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

package cat.diba.materialesportiu.service.persistence.impl;

import cat.diba.materialesportiu.model.Activity;
import cat.diba.materialesportiu.service.persistence.ActivityPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ActivityFinderBaseImpl extends BasePersistenceImpl<Activity> {
	public ActivityFinderBaseImpl() {
		setModelClass(Activity.class);
	}

	/**
	 * Returns the activity persistence.
	 *
	 * @return the activity persistence
	 */
	public ActivityPersistence getActivityPersistence() {
		return activityPersistence;
	}

	/**
	 * Sets the activity persistence.
	 *
	 * @param activityPersistence the activity persistence
	 */
	public void setActivityPersistence(ActivityPersistence activityPersistence) {
		this.activityPersistence = activityPersistence;
	}

	@BeanReference(type = ActivityPersistence.class)
	protected ActivityPersistence activityPersistence;
}
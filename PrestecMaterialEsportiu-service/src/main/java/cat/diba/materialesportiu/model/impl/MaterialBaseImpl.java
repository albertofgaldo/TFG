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

import cat.diba.materialesportiu.model.Material;
import cat.diba.materialesportiu.service.MaterialLocalServiceUtil;

/**
 * The extended model base implementation for the Material service. Represents a row in the &quot;PME_Material&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MaterialImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MaterialImpl
 * @see Material
 * @generated
 */
@ProviderType
public abstract class MaterialBaseImpl extends MaterialModelImpl
	implements Material {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a material model instance should use the {@link Material} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			MaterialLocalServiceUtil.addMaterial(this);
		}
		else {
			MaterialLocalServiceUtil.updateMaterial(this);
		}
	}
}
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

import cat.diba.materialesportiu.model.Loan;
import cat.diba.materialesportiu.service.persistence.LoanPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LoanFinderBaseImpl extends BasePersistenceImpl<Loan> {
	public LoanFinderBaseImpl() {
		setModelClass(Loan.class);
	}

	/**
	 * Returns the loan persistence.
	 *
	 * @return the loan persistence
	 */
	public LoanPersistence getLoanPersistence() {
		return loanPersistence;
	}

	/**
	 * Sets the loan persistence.
	 *
	 * @param loanPersistence the loan persistence
	 */
	public void setLoanPersistence(LoanPersistence loanPersistence) {
		this.loanPersistence = loanPersistence;
	}

	@BeanReference(type = LoanPersistence.class)
	protected LoanPersistence loanPersistence;
}
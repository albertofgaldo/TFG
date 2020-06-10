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

import aQute.bnd.annotation.ProviderType;

import cat.diba.materialesportiu.exception.NoSuchLoanException;
import cat.diba.materialesportiu.model.Loan;
import cat.diba.materialesportiu.model.impl.LoanImpl;
import cat.diba.materialesportiu.model.impl.LoanModelImpl;
import cat.diba.materialesportiu.service.persistence.LoanPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the loan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoanPersistence
 * @see cat.diba.materialesportiu.service.persistence.LoanUtil
 * @generated
 */
@ProviderType
public class LoanPersistenceImpl extends BasePersistenceImpl<Loan>
	implements LoanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LoanUtil} to access the loan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LoanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			LoanModelImpl.COMPANYID_COLUMN_BITMASK |
			LoanModelImpl.GROUPID_COLUMN_BITMASK |
			LoanModelImpl.PICKUPDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the loans where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching loans
	 */
	@Override
	public List<Loan> findByCompanyGroup(long companyId, long groupId) {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loans where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @return the range of matching loans
	 */
	@Override
	public List<Loan> findByCompanyGroup(long companyId, long groupId,
		int start, int end) {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loans where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loans
	 */
	@Override
	public List<Loan> findByCompanyGroup(long companyId, long groupId,
		int start, int end, OrderByComparator<Loan> orderByComparator) {
		return findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loans where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching loans
	 */
	@Override
	public List<Loan> findByCompanyGroup(long companyId, long groupId,
		int start, int end, OrderByComparator<Loan> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Loan> list = null;

		if (retrieveFromCache) {
			list = (List<Loan>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Loan loan : list) {
					if ((companyId != loan.getCompanyId()) ||
							(groupId != loan.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LOAN_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first loan in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan
	 * @throws NoSuchLoanException if a matching loan could not be found
	 */
	@Override
	public Loan findByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator<Loan> orderByComparator) throws NoSuchLoanException {
		Loan loan = fetchByCompanyGroup_First(companyId, groupId,
				orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLoanException(msg.toString());
	}

	/**
	 * Returns the first loan in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan, or <code>null</code> if a matching loan could not be found
	 */
	@Override
	public Loan fetchByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator<Loan> orderByComparator) {
		List<Loan> list = findByCompanyGroup(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loan in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan
	 * @throws NoSuchLoanException if a matching loan could not be found
	 */
	@Override
	public Loan findByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator<Loan> orderByComparator) throws NoSuchLoanException {
		Loan loan = fetchByCompanyGroup_Last(companyId, groupId,
				orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLoanException(msg.toString());
	}

	/**
	 * Returns the last loan in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan, or <code>null</code> if a matching loan could not be found
	 */
	@Override
	public Loan fetchByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator<Loan> orderByComparator) {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Loan> list = findByCompanyGroup(companyId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loans before and after the current loan in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param loanId the primary key of the current loan
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loan
	 * @throws NoSuchLoanException if a loan with the primary key could not be found
	 */
	@Override
	public Loan[] findByCompanyGroup_PrevAndNext(long loanId, long companyId,
		long groupId, OrderByComparator<Loan> orderByComparator)
		throws NoSuchLoanException {
		Loan loan = findByPrimaryKey(loanId);

		Session session = null;

		try {
			session = openSession();

			Loan[] array = new LoanImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, loan, companyId,
					groupId, orderByComparator, true);

			array[1] = loan;

			array[2] = getByCompanyGroup_PrevAndNext(session, loan, companyId,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Loan getByCompanyGroup_PrevAndNext(Session session, Loan loan,
		long companyId, long groupId,
		OrderByComparator<Loan> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LOAN_WHERE);

		query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LoanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loans where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId) {
		for (Loan loan : findByCompanyGroup(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(loan);
		}
	}

	/**
	 * Returns the number of loans where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching loans
	 */
	@Override
	public int countByCompanyGroup(long companyId, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYGROUP;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LOAN_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "loan.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "loan.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSPASTPICKUPDATE =
		new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatusPastPickupDate",
			new String[] {
				String.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_STATUSPASTPICKUPDATE =
		new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByStatusPastPickupDate",
			new String[] { String.class.getName(), Date.class.getName() });

	/**
	 * Returns all the loans where status = &#63; and pickupDate &lt; &#63;.
	 *
	 * @param status the status
	 * @param pickupDate the pickup date
	 * @return the matching loans
	 */
	@Override
	public List<Loan> findByStatusPastPickupDate(String status, Date pickupDate) {
		return findByStatusPastPickupDate(status, pickupDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loans where status = &#63; and pickupDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param pickupDate the pickup date
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @return the range of matching loans
	 */
	@Override
	public List<Loan> findByStatusPastPickupDate(String status,
		Date pickupDate, int start, int end) {
		return findByStatusPastPickupDate(status, pickupDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loans where status = &#63; and pickupDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param pickupDate the pickup date
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loans
	 */
	@Override
	public List<Loan> findByStatusPastPickupDate(String status,
		Date pickupDate, int start, int end,
		OrderByComparator<Loan> orderByComparator) {
		return findByStatusPastPickupDate(status, pickupDate, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loans where status = &#63; and pickupDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param pickupDate the pickup date
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching loans
	 */
	@Override
	public List<Loan> findByStatusPastPickupDate(String status,
		Date pickupDate, int start, int end,
		OrderByComparator<Loan> orderByComparator, boolean retrieveFromCache) {
		status = Objects.toString(status, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSPASTPICKUPDATE;
		finderArgs = new Object[] {
				status, _getTime(pickupDate),
				
				start, end, orderByComparator
			};

		List<Loan> list = null;

		if (retrieveFromCache) {
			list = (List<Loan>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Loan loan : list) {
					if (!status.equals(loan.getStatus()) ||
							(pickupDate.getTime() <= loan.getPickupDate()
															 .getTime())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LOAN_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				query.append(_FINDER_COLUMN_STATUSPASTPICKUPDATE_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUSPASTPICKUPDATE_STATUS_2);
			}

			boolean bindPickupDate = false;

			if (pickupDate == null) {
				query.append(_FINDER_COLUMN_STATUSPASTPICKUPDATE_PICKUPDATE_1);
			}
			else {
				bindPickupDate = true;

				query.append(_FINDER_COLUMN_STATUSPASTPICKUPDATE_PICKUPDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				if (bindPickupDate) {
					qPos.add(new Timestamp(pickupDate.getTime()));
				}

				if (!pagination) {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first loan in the ordered set where status = &#63; and pickupDate &lt; &#63;.
	 *
	 * @param status the status
	 * @param pickupDate the pickup date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan
	 * @throws NoSuchLoanException if a matching loan could not be found
	 */
	@Override
	public Loan findByStatusPastPickupDate_First(String status,
		Date pickupDate, OrderByComparator<Loan> orderByComparator)
		throws NoSuchLoanException {
		Loan loan = fetchByStatusPastPickupDate_First(status, pickupDate,
				orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", pickupDate=");
		msg.append(pickupDate);

		msg.append("}");

		throw new NoSuchLoanException(msg.toString());
	}

	/**
	 * Returns the first loan in the ordered set where status = &#63; and pickupDate &lt; &#63;.
	 *
	 * @param status the status
	 * @param pickupDate the pickup date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan, or <code>null</code> if a matching loan could not be found
	 */
	@Override
	public Loan fetchByStatusPastPickupDate_First(String status,
		Date pickupDate, OrderByComparator<Loan> orderByComparator) {
		List<Loan> list = findByStatusPastPickupDate(status, pickupDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loan in the ordered set where status = &#63; and pickupDate &lt; &#63;.
	 *
	 * @param status the status
	 * @param pickupDate the pickup date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan
	 * @throws NoSuchLoanException if a matching loan could not be found
	 */
	@Override
	public Loan findByStatusPastPickupDate_Last(String status, Date pickupDate,
		OrderByComparator<Loan> orderByComparator) throws NoSuchLoanException {
		Loan loan = fetchByStatusPastPickupDate_Last(status, pickupDate,
				orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", pickupDate=");
		msg.append(pickupDate);

		msg.append("}");

		throw new NoSuchLoanException(msg.toString());
	}

	/**
	 * Returns the last loan in the ordered set where status = &#63; and pickupDate &lt; &#63;.
	 *
	 * @param status the status
	 * @param pickupDate the pickup date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan, or <code>null</code> if a matching loan could not be found
	 */
	@Override
	public Loan fetchByStatusPastPickupDate_Last(String status,
		Date pickupDate, OrderByComparator<Loan> orderByComparator) {
		int count = countByStatusPastPickupDate(status, pickupDate);

		if (count == 0) {
			return null;
		}

		List<Loan> list = findByStatusPastPickupDate(status, pickupDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loans before and after the current loan in the ordered set where status = &#63; and pickupDate &lt; &#63;.
	 *
	 * @param loanId the primary key of the current loan
	 * @param status the status
	 * @param pickupDate the pickup date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loan
	 * @throws NoSuchLoanException if a loan with the primary key could not be found
	 */
	@Override
	public Loan[] findByStatusPastPickupDate_PrevAndNext(long loanId,
		String status, Date pickupDate,
		OrderByComparator<Loan> orderByComparator) throws NoSuchLoanException {
		status = Objects.toString(status, "");

		Loan loan = findByPrimaryKey(loanId);

		Session session = null;

		try {
			session = openSession();

			Loan[] array = new LoanImpl[3];

			array[0] = getByStatusPastPickupDate_PrevAndNext(session, loan,
					status, pickupDate, orderByComparator, true);

			array[1] = loan;

			array[2] = getByStatusPastPickupDate_PrevAndNext(session, loan,
					status, pickupDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Loan getByStatusPastPickupDate_PrevAndNext(Session session,
		Loan loan, String status, Date pickupDate,
		OrderByComparator<Loan> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LOAN_WHERE);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			query.append(_FINDER_COLUMN_STATUSPASTPICKUPDATE_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_STATUSPASTPICKUPDATE_STATUS_2);
		}

		boolean bindPickupDate = false;

		if (pickupDate == null) {
			query.append(_FINDER_COLUMN_STATUSPASTPICKUPDATE_PICKUPDATE_1);
		}
		else {
			bindPickupDate = true;

			query.append(_FINDER_COLUMN_STATUSPASTPICKUPDATE_PICKUPDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LoanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatus) {
			qPos.add(status);
		}

		if (bindPickupDate) {
			qPos.add(new Timestamp(pickupDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loans where status = &#63; and pickupDate &lt; &#63; from the database.
	 *
	 * @param status the status
	 * @param pickupDate the pickup date
	 */
	@Override
	public void removeByStatusPastPickupDate(String status, Date pickupDate) {
		for (Loan loan : findByStatusPastPickupDate(status, pickupDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(loan);
		}
	}

	/**
	 * Returns the number of loans where status = &#63; and pickupDate &lt; &#63;.
	 *
	 * @param status the status
	 * @param pickupDate the pickup date
	 * @return the number of matching loans
	 */
	@Override
	public int countByStatusPastPickupDate(String status, Date pickupDate) {
		status = Objects.toString(status, "");

		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_STATUSPASTPICKUPDATE;

		Object[] finderArgs = new Object[] { status, _getTime(pickupDate) };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LOAN_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				query.append(_FINDER_COLUMN_STATUSPASTPICKUPDATE_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUSPASTPICKUPDATE_STATUS_2);
			}

			boolean bindPickupDate = false;

			if (pickupDate == null) {
				query.append(_FINDER_COLUMN_STATUSPASTPICKUPDATE_PICKUPDATE_1);
			}
			else {
				bindPickupDate = true;

				query.append(_FINDER_COLUMN_STATUSPASTPICKUPDATE_PICKUPDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				if (bindPickupDate) {
					qPos.add(new Timestamp(pickupDate.getTime()));
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUSPASTPICKUPDATE_STATUS_1 = "loan.status IS NULL AND ";
	private static final String _FINDER_COLUMN_STATUSPASTPICKUPDATE_STATUS_2 = "loan.status = ? AND ";
	private static final String _FINDER_COLUMN_STATUSPASTPICKUPDATE_STATUS_3 = "(loan.status IS NULL OR loan.status = '') AND ";
	private static final String _FINDER_COLUMN_STATUSPASTPICKUPDATE_PICKUPDATE_1 =
		"loan.pickupDate IS NULL";
	private static final String _FINDER_COLUMN_STATUSPASTPICKUPDATE_PICKUPDATE_2 =
		"loan.pickupDate < ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSPASTRETURNDATE =
		new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatusPastReturnDate",
			new String[] {
				String.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_STATUSPASTRETURNDATE =
		new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByStatusPastReturnDate",
			new String[] { String.class.getName(), Date.class.getName() });

	/**
	 * Returns all the loans where status = &#63; and returnDate &lt; &#63;.
	 *
	 * @param status the status
	 * @param returnDate the return date
	 * @return the matching loans
	 */
	@Override
	public List<Loan> findByStatusPastReturnDate(String status, Date returnDate) {
		return findByStatusPastReturnDate(status, returnDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loans where status = &#63; and returnDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param returnDate the return date
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @return the range of matching loans
	 */
	@Override
	public List<Loan> findByStatusPastReturnDate(String status,
		Date returnDate, int start, int end) {
		return findByStatusPastReturnDate(status, returnDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loans where status = &#63; and returnDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param returnDate the return date
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loans
	 */
	@Override
	public List<Loan> findByStatusPastReturnDate(String status,
		Date returnDate, int start, int end,
		OrderByComparator<Loan> orderByComparator) {
		return findByStatusPastReturnDate(status, returnDate, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loans where status = &#63; and returnDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param returnDate the return date
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching loans
	 */
	@Override
	public List<Loan> findByStatusPastReturnDate(String status,
		Date returnDate, int start, int end,
		OrderByComparator<Loan> orderByComparator, boolean retrieveFromCache) {
		status = Objects.toString(status, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSPASTRETURNDATE;
		finderArgs = new Object[] {
				status, _getTime(returnDate),
				
				start, end, orderByComparator
			};

		List<Loan> list = null;

		if (retrieveFromCache) {
			list = (List<Loan>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Loan loan : list) {
					if (!status.equals(loan.getStatus()) ||
							(returnDate.getTime() <= loan.getReturnDate()
															 .getTime())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LOAN_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				query.append(_FINDER_COLUMN_STATUSPASTRETURNDATE_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUSPASTRETURNDATE_STATUS_2);
			}

			boolean bindReturnDate = false;

			if (returnDate == null) {
				query.append(_FINDER_COLUMN_STATUSPASTRETURNDATE_RETURNDATE_1);
			}
			else {
				bindReturnDate = true;

				query.append(_FINDER_COLUMN_STATUSPASTRETURNDATE_RETURNDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				if (bindReturnDate) {
					qPos.add(new Timestamp(returnDate.getTime()));
				}

				if (!pagination) {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first loan in the ordered set where status = &#63; and returnDate &lt; &#63;.
	 *
	 * @param status the status
	 * @param returnDate the return date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan
	 * @throws NoSuchLoanException if a matching loan could not be found
	 */
	@Override
	public Loan findByStatusPastReturnDate_First(String status,
		Date returnDate, OrderByComparator<Loan> orderByComparator)
		throws NoSuchLoanException {
		Loan loan = fetchByStatusPastReturnDate_First(status, returnDate,
				orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", returnDate=");
		msg.append(returnDate);

		msg.append("}");

		throw new NoSuchLoanException(msg.toString());
	}

	/**
	 * Returns the first loan in the ordered set where status = &#63; and returnDate &lt; &#63;.
	 *
	 * @param status the status
	 * @param returnDate the return date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan, or <code>null</code> if a matching loan could not be found
	 */
	@Override
	public Loan fetchByStatusPastReturnDate_First(String status,
		Date returnDate, OrderByComparator<Loan> orderByComparator) {
		List<Loan> list = findByStatusPastReturnDate(status, returnDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loan in the ordered set where status = &#63; and returnDate &lt; &#63;.
	 *
	 * @param status the status
	 * @param returnDate the return date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan
	 * @throws NoSuchLoanException if a matching loan could not be found
	 */
	@Override
	public Loan findByStatusPastReturnDate_Last(String status, Date returnDate,
		OrderByComparator<Loan> orderByComparator) throws NoSuchLoanException {
		Loan loan = fetchByStatusPastReturnDate_Last(status, returnDate,
				orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", returnDate=");
		msg.append(returnDate);

		msg.append("}");

		throw new NoSuchLoanException(msg.toString());
	}

	/**
	 * Returns the last loan in the ordered set where status = &#63; and returnDate &lt; &#63;.
	 *
	 * @param status the status
	 * @param returnDate the return date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan, or <code>null</code> if a matching loan could not be found
	 */
	@Override
	public Loan fetchByStatusPastReturnDate_Last(String status,
		Date returnDate, OrderByComparator<Loan> orderByComparator) {
		int count = countByStatusPastReturnDate(status, returnDate);

		if (count == 0) {
			return null;
		}

		List<Loan> list = findByStatusPastReturnDate(status, returnDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loans before and after the current loan in the ordered set where status = &#63; and returnDate &lt; &#63;.
	 *
	 * @param loanId the primary key of the current loan
	 * @param status the status
	 * @param returnDate the return date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loan
	 * @throws NoSuchLoanException if a loan with the primary key could not be found
	 */
	@Override
	public Loan[] findByStatusPastReturnDate_PrevAndNext(long loanId,
		String status, Date returnDate,
		OrderByComparator<Loan> orderByComparator) throws NoSuchLoanException {
		status = Objects.toString(status, "");

		Loan loan = findByPrimaryKey(loanId);

		Session session = null;

		try {
			session = openSession();

			Loan[] array = new LoanImpl[3];

			array[0] = getByStatusPastReturnDate_PrevAndNext(session, loan,
					status, returnDate, orderByComparator, true);

			array[1] = loan;

			array[2] = getByStatusPastReturnDate_PrevAndNext(session, loan,
					status, returnDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Loan getByStatusPastReturnDate_PrevAndNext(Session session,
		Loan loan, String status, Date returnDate,
		OrderByComparator<Loan> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LOAN_WHERE);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			query.append(_FINDER_COLUMN_STATUSPASTRETURNDATE_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_STATUSPASTRETURNDATE_STATUS_2);
		}

		boolean bindReturnDate = false;

		if (returnDate == null) {
			query.append(_FINDER_COLUMN_STATUSPASTRETURNDATE_RETURNDATE_1);
		}
		else {
			bindReturnDate = true;

			query.append(_FINDER_COLUMN_STATUSPASTRETURNDATE_RETURNDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LoanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatus) {
			qPos.add(status);
		}

		if (bindReturnDate) {
			qPos.add(new Timestamp(returnDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loans where status = &#63; and returnDate &lt; &#63; from the database.
	 *
	 * @param status the status
	 * @param returnDate the return date
	 */
	@Override
	public void removeByStatusPastReturnDate(String status, Date returnDate) {
		for (Loan loan : findByStatusPastReturnDate(status, returnDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(loan);
		}
	}

	/**
	 * Returns the number of loans where status = &#63; and returnDate &lt; &#63;.
	 *
	 * @param status the status
	 * @param returnDate the return date
	 * @return the number of matching loans
	 */
	@Override
	public int countByStatusPastReturnDate(String status, Date returnDate) {
		status = Objects.toString(status, "");

		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_STATUSPASTRETURNDATE;

		Object[] finderArgs = new Object[] { status, _getTime(returnDate) };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LOAN_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				query.append(_FINDER_COLUMN_STATUSPASTRETURNDATE_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUSPASTRETURNDATE_STATUS_2);
			}

			boolean bindReturnDate = false;

			if (returnDate == null) {
				query.append(_FINDER_COLUMN_STATUSPASTRETURNDATE_RETURNDATE_1);
			}
			else {
				bindReturnDate = true;

				query.append(_FINDER_COLUMN_STATUSPASTRETURNDATE_RETURNDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				if (bindReturnDate) {
					qPos.add(new Timestamp(returnDate.getTime()));
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUSPASTRETURNDATE_STATUS_1 = "loan.status IS NULL AND ";
	private static final String _FINDER_COLUMN_STATUSPASTRETURNDATE_STATUS_2 = "loan.status = ? AND ";
	private static final String _FINDER_COLUMN_STATUSPASTRETURNDATE_STATUS_3 = "(loan.status IS NULL OR loan.status = '') AND ";
	private static final String _FINDER_COLUMN_STATUSPASTRETURNDATE_RETURNDATE_1 =
		"loan.returnDate IS NULL";
	private static final String _FINDER_COLUMN_STATUSPASTRETURNDATE_RETURNDATE_2 =
		"loan.returnDate < ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { String.class.getName() },
			LoanModelImpl.STATUS_COLUMN_BITMASK |
			LoanModelImpl.PICKUPDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { String.class.getName() });

	/**
	 * Returns all the loans where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching loans
	 */
	@Override
	public List<Loan> findByStatus(String status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loans where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @return the range of matching loans
	 */
	@Override
	public List<Loan> findByStatus(String status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loans where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loans
	 */
	@Override
	public List<Loan> findByStatus(String status, int start, int end,
		OrderByComparator<Loan> orderByComparator) {
		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loans where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching loans
	 */
	@Override
	public List<Loan> findByStatus(String status, int start, int end,
		OrderByComparator<Loan> orderByComparator, boolean retrieveFromCache) {
		status = Objects.toString(status, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<Loan> list = null;

		if (retrieveFromCache) {
			list = (List<Loan>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Loan loan : list) {
					if (!status.equals(loan.getStatus())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LOAN_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				if (!pagination) {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first loan in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan
	 * @throws NoSuchLoanException if a matching loan could not be found
	 */
	@Override
	public Loan findByStatus_First(String status,
		OrderByComparator<Loan> orderByComparator) throws NoSuchLoanException {
		Loan loan = fetchByStatus_First(status, orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchLoanException(msg.toString());
	}

	/**
	 * Returns the first loan in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan, or <code>null</code> if a matching loan could not be found
	 */
	@Override
	public Loan fetchByStatus_First(String status,
		OrderByComparator<Loan> orderByComparator) {
		List<Loan> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loan in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan
	 * @throws NoSuchLoanException if a matching loan could not be found
	 */
	@Override
	public Loan findByStatus_Last(String status,
		OrderByComparator<Loan> orderByComparator) throws NoSuchLoanException {
		Loan loan = fetchByStatus_Last(status, orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchLoanException(msg.toString());
	}

	/**
	 * Returns the last loan in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan, or <code>null</code> if a matching loan could not be found
	 */
	@Override
	public Loan fetchByStatus_Last(String status,
		OrderByComparator<Loan> orderByComparator) {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Loan> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loans before and after the current loan in the ordered set where status = &#63;.
	 *
	 * @param loanId the primary key of the current loan
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loan
	 * @throws NoSuchLoanException if a loan with the primary key could not be found
	 */
	@Override
	public Loan[] findByStatus_PrevAndNext(long loanId, String status,
		OrderByComparator<Loan> orderByComparator) throws NoSuchLoanException {
		status = Objects.toString(status, "");

		Loan loan = findByPrimaryKey(loanId);

		Session session = null;

		try {
			session = openSession();

			Loan[] array = new LoanImpl[3];

			array[0] = getByStatus_PrevAndNext(session, loan, status,
					orderByComparator, true);

			array[1] = loan;

			array[2] = getByStatus_PrevAndNext(session, loan, status,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Loan getByStatus_PrevAndNext(Session session, Loan loan,
		String status, OrderByComparator<Loan> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOAN_WHERE);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			query.append(_FINDER_COLUMN_STATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LoanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatus) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loans where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(String status) {
		for (Loan loan : findByStatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(loan);
		}
	}

	/**
	 * Returns the number of loans where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching loans
	 */
	@Override
	public int countByStatus(String status) {
		status = Objects.toString(status, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOAN_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_1 = "loan.status IS NULL";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "loan.status = ?";
	private static final String _FINDER_COLUMN_STATUS_STATUS_3 = "(loan.status IS NULL OR loan.status = '')";

	public LoanPersistenceImpl() {
		setModelClass(Loan.class);
	}

	/**
	 * Caches the loan in the entity cache if it is enabled.
	 *
	 * @param loan the loan
	 */
	@Override
	public void cacheResult(Loan loan) {
		entityCache.putResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanImpl.class, loan.getPrimaryKey(), loan);

		loan.resetOriginalValues();
	}

	/**
	 * Caches the loans in the entity cache if it is enabled.
	 *
	 * @param loans the loans
	 */
	@Override
	public void cacheResult(List<Loan> loans) {
		for (Loan loan : loans) {
			if (entityCache.getResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
						LoanImpl.class, loan.getPrimaryKey()) == null) {
				cacheResult(loan);
			}
			else {
				loan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all loans.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LoanImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the loan.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Loan loan) {
		entityCache.removeResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanImpl.class, loan.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Loan> loans) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Loan loan : loans) {
			entityCache.removeResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
				LoanImpl.class, loan.getPrimaryKey());
		}
	}

	/**
	 * Creates a new loan with the primary key. Does not add the loan to the database.
	 *
	 * @param loanId the primary key for the new loan
	 * @return the new loan
	 */
	@Override
	public Loan create(long loanId) {
		Loan loan = new LoanImpl();

		loan.setNew(true);
		loan.setPrimaryKey(loanId);

		loan.setCompanyId(companyProvider.getCompanyId());

		return loan;
	}

	/**
	 * Removes the loan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loanId the primary key of the loan
	 * @return the loan that was removed
	 * @throws NoSuchLoanException if a loan with the primary key could not be found
	 */
	@Override
	public Loan remove(long loanId) throws NoSuchLoanException {
		return remove((Serializable)loanId);
	}

	/**
	 * Removes the loan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the loan
	 * @return the loan that was removed
	 * @throws NoSuchLoanException if a loan with the primary key could not be found
	 */
	@Override
	public Loan remove(Serializable primaryKey) throws NoSuchLoanException {
		Session session = null;

		try {
			session = openSession();

			Loan loan = (Loan)session.get(LoanImpl.class, primaryKey);

			if (loan == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLoanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(loan);
		}
		catch (NoSuchLoanException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Loan removeImpl(Loan loan) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(loan)) {
				loan = (Loan)session.get(LoanImpl.class, loan.getPrimaryKeyObj());
			}

			if (loan != null) {
				session.delete(loan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (loan != null) {
			clearCache(loan);
		}

		return loan;
	}

	@Override
	public Loan updateImpl(Loan loan) {
		boolean isNew = loan.isNew();

		if (!(loan instanceof LoanModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(loan.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(loan);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in loan proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Loan implementation " +
				loan.getClass());
		}

		LoanModelImpl loanModelImpl = (LoanModelImpl)loan;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (loan.getCreateDate() == null)) {
			if (serviceContext == null) {
				loan.setCreateDate(now);
			}
			else {
				loan.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!loanModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				loan.setModifiedDate(now);
			}
			else {
				loan.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (loan.isNew()) {
				session.save(loan);

				loan.setNew(false);
			}
			else {
				loan = (Loan)session.merge(loan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LoanModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					loanModelImpl.getCompanyId(), loanModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
				args);

			args = new Object[] { loanModelImpl.getStatus() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((loanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loanModelImpl.getOriginalCompanyId(),
						loanModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						loanModelImpl.getCompanyId(), loanModelImpl.getGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}

			if ((loanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { loanModelImpl.getOriginalStatus() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { loanModelImpl.getStatus() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		entityCache.putResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanImpl.class, loan.getPrimaryKey(), loan, false);

		loan.resetOriginalValues();

		return loan;
	}

	/**
	 * Returns the loan with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the loan
	 * @return the loan
	 * @throws NoSuchLoanException if a loan with the primary key could not be found
	 */
	@Override
	public Loan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLoanException {
		Loan loan = fetchByPrimaryKey(primaryKey);

		if (loan == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLoanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return loan;
	}

	/**
	 * Returns the loan with the primary key or throws a {@link NoSuchLoanException} if it could not be found.
	 *
	 * @param loanId the primary key of the loan
	 * @return the loan
	 * @throws NoSuchLoanException if a loan with the primary key could not be found
	 */
	@Override
	public Loan findByPrimaryKey(long loanId) throws NoSuchLoanException {
		return findByPrimaryKey((Serializable)loanId);
	}

	/**
	 * Returns the loan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the loan
	 * @return the loan, or <code>null</code> if a loan with the primary key could not be found
	 */
	@Override
	public Loan fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
				LoanImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Loan loan = (Loan)serializable;

		if (loan == null) {
			Session session = null;

			try {
				session = openSession();

				loan = (Loan)session.get(LoanImpl.class, primaryKey);

				if (loan != null) {
					cacheResult(loan);
				}
				else {
					entityCache.putResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
						LoanImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
					LoanImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return loan;
	}

	/**
	 * Returns the loan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loanId the primary key of the loan
	 * @return the loan, or <code>null</code> if a loan with the primary key could not be found
	 */
	@Override
	public Loan fetchByPrimaryKey(long loanId) {
		return fetchByPrimaryKey((Serializable)loanId);
	}

	@Override
	public Map<Serializable, Loan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Loan> map = new HashMap<Serializable, Loan>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Loan loan = fetchByPrimaryKey(primaryKey);

			if (loan != null) {
				map.put(primaryKey, loan);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
					LoanImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Loan)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LOAN_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Loan loan : (List<Loan>)q.list()) {
				map.put(loan.getPrimaryKeyObj(), loan);

				cacheResult(loan);

				uncachedPrimaryKeys.remove(loan.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
					LoanImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the loans.
	 *
	 * @return the loans
	 */
	@Override
	public List<Loan> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @return the range of loans
	 */
	@Override
	public List<Loan> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the loans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of loans
	 */
	@Override
	public List<Loan> findAll(int start, int end,
		OrderByComparator<Loan> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of loans
	 */
	@Override
	public List<Loan> findAll(int start, int end,
		OrderByComparator<Loan> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Loan> list = null;

		if (retrieveFromCache) {
			list = (List<Loan>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LOAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOAN;

				if (pagination) {
					sql = sql.concat(LoanModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the loans from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Loan loan : findAll()) {
			remove(loan);
		}
	}

	/**
	 * Returns the number of loans.
	 *
	 * @return the number of loans
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOAN);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LoanModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the loan persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LoanImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_LOAN = "SELECT loan FROM Loan loan";
	private static final String _SQL_SELECT_LOAN_WHERE_PKS_IN = "SELECT loan FROM Loan loan WHERE loanId IN (";
	private static final String _SQL_SELECT_LOAN_WHERE = "SELECT loan FROM Loan loan WHERE ";
	private static final String _SQL_COUNT_LOAN = "SELECT COUNT(loan) FROM Loan loan";
	private static final String _SQL_COUNT_LOAN_WHERE = "SELECT COUNT(loan) FROM Loan loan WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "loan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Loan exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Loan exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LoanPersistenceImpl.class);
}
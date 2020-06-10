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

import cat.diba.materialesportiu.exception.NoSuchLoanActivityException;
import cat.diba.materialesportiu.model.LoanActivity;
import cat.diba.materialesportiu.model.impl.LoanActivityImpl;
import cat.diba.materialesportiu.model.impl.LoanActivityModelImpl;
import cat.diba.materialesportiu.service.persistence.LoanActivityPersistence;

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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the loan activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoanActivityPersistence
 * @see cat.diba.materialesportiu.service.persistence.LoanActivityUtil
 * @generated
 */
@ProviderType
public class LoanActivityPersistenceImpl extends BasePersistenceImpl<LoanActivity>
	implements LoanActivityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LoanActivityUtil} to access the loan activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LoanActivityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
			LoanActivityModelImpl.FINDER_CACHE_ENABLED, LoanActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
			LoanActivityModelImpl.FINDER_CACHE_ENABLED, LoanActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
			LoanActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
			LoanActivityModelImpl.FINDER_CACHE_ENABLED, LoanActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
			LoanActivityModelImpl.FINDER_CACHE_ENABLED, LoanActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			LoanActivityModelImpl.COMPANYID_COLUMN_BITMASK |
			LoanActivityModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
			LoanActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the loan activities where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching loan activities
	 */
	@Override
	public List<LoanActivity> findByCompanyGroup(long companyId, long groupId) {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loan activities where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of loan activities
	 * @param end the upper bound of the range of loan activities (not inclusive)
	 * @return the range of matching loan activities
	 */
	@Override
	public List<LoanActivity> findByCompanyGroup(long companyId, long groupId,
		int start, int end) {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loan activities where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of loan activities
	 * @param end the upper bound of the range of loan activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loan activities
	 */
	@Override
	public List<LoanActivity> findByCompanyGroup(long companyId, long groupId,
		int start, int end, OrderByComparator<LoanActivity> orderByComparator) {
		return findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loan activities where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of loan activities
	 * @param end the upper bound of the range of loan activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching loan activities
	 */
	@Override
	public List<LoanActivity> findByCompanyGroup(long companyId, long groupId,
		int start, int end, OrderByComparator<LoanActivity> orderByComparator,
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

		List<LoanActivity> list = null;

		if (retrieveFromCache) {
			list = (List<LoanActivity>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LoanActivity loanActivity : list) {
					if ((companyId != loanActivity.getCompanyId()) ||
							(groupId != loanActivity.getGroupId())) {
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

			query.append(_SQL_SELECT_LOANACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoanActivityModelImpl.ORDER_BY_JPQL);
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
					list = (List<LoanActivity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LoanActivity>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first loan activity in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan activity
	 * @throws NoSuchLoanActivityException if a matching loan activity could not be found
	 */
	@Override
	public LoanActivity findByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException {
		LoanActivity loanActivity = fetchByCompanyGroup_First(companyId,
				groupId, orderByComparator);

		if (loanActivity != null) {
			return loanActivity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLoanActivityException(msg.toString());
	}

	/**
	 * Returns the first loan activity in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan activity, or <code>null</code> if a matching loan activity could not be found
	 */
	@Override
	public LoanActivity fetchByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator<LoanActivity> orderByComparator) {
		List<LoanActivity> list = findByCompanyGroup(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loan activity in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan activity
	 * @throws NoSuchLoanActivityException if a matching loan activity could not be found
	 */
	@Override
	public LoanActivity findByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException {
		LoanActivity loanActivity = fetchByCompanyGroup_Last(companyId,
				groupId, orderByComparator);

		if (loanActivity != null) {
			return loanActivity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLoanActivityException(msg.toString());
	}

	/**
	 * Returns the last loan activity in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan activity, or <code>null</code> if a matching loan activity could not be found
	 */
	@Override
	public LoanActivity fetchByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator<LoanActivity> orderByComparator) {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<LoanActivity> list = findByCompanyGroup(companyId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loan activities before and after the current loan activity in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param loanActivityId the primary key of the current loan activity
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loan activity
	 * @throws NoSuchLoanActivityException if a loan activity with the primary key could not be found
	 */
	@Override
	public LoanActivity[] findByCompanyGroup_PrevAndNext(long loanActivityId,
		long companyId, long groupId,
		OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException {
		LoanActivity loanActivity = findByPrimaryKey(loanActivityId);

		Session session = null;

		try {
			session = openSession();

			LoanActivity[] array = new LoanActivityImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, loanActivity,
					companyId, groupId, orderByComparator, true);

			array[1] = loanActivity;

			array[2] = getByCompanyGroup_PrevAndNext(session, loanActivity,
					companyId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LoanActivity getByCompanyGroup_PrevAndNext(Session session,
		LoanActivity loanActivity, long companyId, long groupId,
		OrderByComparator<LoanActivity> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LOANACTIVITY_WHERE);

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
			query.append(LoanActivityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loanActivity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LoanActivity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loan activities where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId) {
		for (LoanActivity loanActivity : findByCompanyGroup(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(loanActivity);
		}
	}

	/**
	 * Returns the number of loan activities where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching loan activities
	 */
	@Override
	public int countByCompanyGroup(long companyId, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYGROUP;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LOANACTIVITY_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "loanActivity.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "loanActivity.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOANID = new FinderPath(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
			LoanActivityModelImpl.FINDER_CACHE_ENABLED, LoanActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLoanId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANID =
		new FinderPath(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
			LoanActivityModelImpl.FINDER_CACHE_ENABLED, LoanActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLoanId",
			new String[] { Long.class.getName() },
			LoanActivityModelImpl.LOANID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOANID = new FinderPath(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
			LoanActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLoanId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the loan activities where loanId = &#63;.
	 *
	 * @param loanId the loan ID
	 * @return the matching loan activities
	 */
	@Override
	public List<LoanActivity> findByLoanId(long loanId) {
		return findByLoanId(loanId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loan activities where loanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loanId the loan ID
	 * @param start the lower bound of the range of loan activities
	 * @param end the upper bound of the range of loan activities (not inclusive)
	 * @return the range of matching loan activities
	 */
	@Override
	public List<LoanActivity> findByLoanId(long loanId, int start, int end) {
		return findByLoanId(loanId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loan activities where loanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loanId the loan ID
	 * @param start the lower bound of the range of loan activities
	 * @param end the upper bound of the range of loan activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loan activities
	 */
	@Override
	public List<LoanActivity> findByLoanId(long loanId, int start, int end,
		OrderByComparator<LoanActivity> orderByComparator) {
		return findByLoanId(loanId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loan activities where loanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loanId the loan ID
	 * @param start the lower bound of the range of loan activities
	 * @param end the upper bound of the range of loan activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching loan activities
	 */
	@Override
	public List<LoanActivity> findByLoanId(long loanId, int start, int end,
		OrderByComparator<LoanActivity> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANID;
			finderArgs = new Object[] { loanId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOANID;
			finderArgs = new Object[] { loanId, start, end, orderByComparator };
		}

		List<LoanActivity> list = null;

		if (retrieveFromCache) {
			list = (List<LoanActivity>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LoanActivity loanActivity : list) {
					if ((loanId != loanActivity.getLoanId())) {
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

			query.append(_SQL_SELECT_LOANACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_LOANID_LOANID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoanActivityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loanId);

				if (!pagination) {
					list = (List<LoanActivity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LoanActivity>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first loan activity in the ordered set where loanId = &#63;.
	 *
	 * @param loanId the loan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan activity
	 * @throws NoSuchLoanActivityException if a matching loan activity could not be found
	 */
	@Override
	public LoanActivity findByLoanId_First(long loanId,
		OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException {
		LoanActivity loanActivity = fetchByLoanId_First(loanId,
				orderByComparator);

		if (loanActivity != null) {
			return loanActivity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("loanId=");
		msg.append(loanId);

		msg.append("}");

		throw new NoSuchLoanActivityException(msg.toString());
	}

	/**
	 * Returns the first loan activity in the ordered set where loanId = &#63;.
	 *
	 * @param loanId the loan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan activity, or <code>null</code> if a matching loan activity could not be found
	 */
	@Override
	public LoanActivity fetchByLoanId_First(long loanId,
		OrderByComparator<LoanActivity> orderByComparator) {
		List<LoanActivity> list = findByLoanId(loanId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loan activity in the ordered set where loanId = &#63;.
	 *
	 * @param loanId the loan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan activity
	 * @throws NoSuchLoanActivityException if a matching loan activity could not be found
	 */
	@Override
	public LoanActivity findByLoanId_Last(long loanId,
		OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException {
		LoanActivity loanActivity = fetchByLoanId_Last(loanId, orderByComparator);

		if (loanActivity != null) {
			return loanActivity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("loanId=");
		msg.append(loanId);

		msg.append("}");

		throw new NoSuchLoanActivityException(msg.toString());
	}

	/**
	 * Returns the last loan activity in the ordered set where loanId = &#63;.
	 *
	 * @param loanId the loan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan activity, or <code>null</code> if a matching loan activity could not be found
	 */
	@Override
	public LoanActivity fetchByLoanId_Last(long loanId,
		OrderByComparator<LoanActivity> orderByComparator) {
		int count = countByLoanId(loanId);

		if (count == 0) {
			return null;
		}

		List<LoanActivity> list = findByLoanId(loanId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loan activities before and after the current loan activity in the ordered set where loanId = &#63;.
	 *
	 * @param loanActivityId the primary key of the current loan activity
	 * @param loanId the loan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loan activity
	 * @throws NoSuchLoanActivityException if a loan activity with the primary key could not be found
	 */
	@Override
	public LoanActivity[] findByLoanId_PrevAndNext(long loanActivityId,
		long loanId, OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException {
		LoanActivity loanActivity = findByPrimaryKey(loanActivityId);

		Session session = null;

		try {
			session = openSession();

			LoanActivity[] array = new LoanActivityImpl[3];

			array[0] = getByLoanId_PrevAndNext(session, loanActivity, loanId,
					orderByComparator, true);

			array[1] = loanActivity;

			array[2] = getByLoanId_PrevAndNext(session, loanActivity, loanId,
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

	protected LoanActivity getByLoanId_PrevAndNext(Session session,
		LoanActivity loanActivity, long loanId,
		OrderByComparator<LoanActivity> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOANACTIVITY_WHERE);

		query.append(_FINDER_COLUMN_LOANID_LOANID_2);

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
			query.append(LoanActivityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(loanId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loanActivity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LoanActivity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loan activities where loanId = &#63; from the database.
	 *
	 * @param loanId the loan ID
	 */
	@Override
	public void removeByLoanId(long loanId) {
		for (LoanActivity loanActivity : findByLoanId(loanId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(loanActivity);
		}
	}

	/**
	 * Returns the number of loan activities where loanId = &#63;.
	 *
	 * @param loanId the loan ID
	 * @return the number of matching loan activities
	 */
	@Override
	public int countByLoanId(long loanId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LOANID;

		Object[] finderArgs = new Object[] { loanId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOANACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_LOANID_LOANID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loanId);

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

	private static final String _FINDER_COLUMN_LOANID_LOANID_2 = "loanActivity.loanId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYID =
		new FinderPath(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
			LoanActivityModelImpl.FINDER_CACHE_ENABLED, LoanActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActivityId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID =
		new FinderPath(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
			LoanActivityModelImpl.FINDER_CACHE_ENABLED, LoanActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActivityId",
			new String[] { Long.class.getName() },
			LoanActivityModelImpl.ACTIVITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYID = new FinderPath(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
			LoanActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActivityId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the loan activities where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @return the matching loan activities
	 */
	@Override
	public List<LoanActivity> findByActivityId(long activityId) {
		return findByActivityId(activityId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loan activities where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of loan activities
	 * @param end the upper bound of the range of loan activities (not inclusive)
	 * @return the range of matching loan activities
	 */
	@Override
	public List<LoanActivity> findByActivityId(long activityId, int start,
		int end) {
		return findByActivityId(activityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loan activities where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of loan activities
	 * @param end the upper bound of the range of loan activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loan activities
	 */
	@Override
	public List<LoanActivity> findByActivityId(long activityId, int start,
		int end, OrderByComparator<LoanActivity> orderByComparator) {
		return findByActivityId(activityId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loan activities where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of loan activities
	 * @param end the upper bound of the range of loan activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching loan activities
	 */
	@Override
	public List<LoanActivity> findByActivityId(long activityId, int start,
		int end, OrderByComparator<LoanActivity> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID;
			finderArgs = new Object[] { activityId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYID;
			finderArgs = new Object[] { activityId, start, end, orderByComparator };
		}

		List<LoanActivity> list = null;

		if (retrieveFromCache) {
			list = (List<LoanActivity>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LoanActivity loanActivity : list) {
					if ((activityId != loanActivity.getActivityId())) {
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

			query.append(_SQL_SELECT_LOANACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoanActivityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(activityId);

				if (!pagination) {
					list = (List<LoanActivity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LoanActivity>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first loan activity in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan activity
	 * @throws NoSuchLoanActivityException if a matching loan activity could not be found
	 */
	@Override
	public LoanActivity findByActivityId_First(long activityId,
		OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException {
		LoanActivity loanActivity = fetchByActivityId_First(activityId,
				orderByComparator);

		if (loanActivity != null) {
			return loanActivity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("activityId=");
		msg.append(activityId);

		msg.append("}");

		throw new NoSuchLoanActivityException(msg.toString());
	}

	/**
	 * Returns the first loan activity in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan activity, or <code>null</code> if a matching loan activity could not be found
	 */
	@Override
	public LoanActivity fetchByActivityId_First(long activityId,
		OrderByComparator<LoanActivity> orderByComparator) {
		List<LoanActivity> list = findByActivityId(activityId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loan activity in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan activity
	 * @throws NoSuchLoanActivityException if a matching loan activity could not be found
	 */
	@Override
	public LoanActivity findByActivityId_Last(long activityId,
		OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException {
		LoanActivity loanActivity = fetchByActivityId_Last(activityId,
				orderByComparator);

		if (loanActivity != null) {
			return loanActivity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("activityId=");
		msg.append(activityId);

		msg.append("}");

		throw new NoSuchLoanActivityException(msg.toString());
	}

	/**
	 * Returns the last loan activity in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan activity, or <code>null</code> if a matching loan activity could not be found
	 */
	@Override
	public LoanActivity fetchByActivityId_Last(long activityId,
		OrderByComparator<LoanActivity> orderByComparator) {
		int count = countByActivityId(activityId);

		if (count == 0) {
			return null;
		}

		List<LoanActivity> list = findByActivityId(activityId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loan activities before and after the current loan activity in the ordered set where activityId = &#63;.
	 *
	 * @param loanActivityId the primary key of the current loan activity
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loan activity
	 * @throws NoSuchLoanActivityException if a loan activity with the primary key could not be found
	 */
	@Override
	public LoanActivity[] findByActivityId_PrevAndNext(long loanActivityId,
		long activityId, OrderByComparator<LoanActivity> orderByComparator)
		throws NoSuchLoanActivityException {
		LoanActivity loanActivity = findByPrimaryKey(loanActivityId);

		Session session = null;

		try {
			session = openSession();

			LoanActivity[] array = new LoanActivityImpl[3];

			array[0] = getByActivityId_PrevAndNext(session, loanActivity,
					activityId, orderByComparator, true);

			array[1] = loanActivity;

			array[2] = getByActivityId_PrevAndNext(session, loanActivity,
					activityId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LoanActivity getByActivityId_PrevAndNext(Session session,
		LoanActivity loanActivity, long activityId,
		OrderByComparator<LoanActivity> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOANACTIVITY_WHERE);

		query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_2);

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
			query.append(LoanActivityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(activityId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loanActivity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LoanActivity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loan activities where activityId = &#63; from the database.
	 *
	 * @param activityId the activity ID
	 */
	@Override
	public void removeByActivityId(long activityId) {
		for (LoanActivity loanActivity : findByActivityId(activityId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(loanActivity);
		}
	}

	/**
	 * Returns the number of loan activities where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @return the number of matching loan activities
	 */
	@Override
	public int countByActivityId(long activityId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVITYID;

		Object[] finderArgs = new Object[] { activityId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOANACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(activityId);

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

	private static final String _FINDER_COLUMN_ACTIVITYID_ACTIVITYID_2 = "loanActivity.activityId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_LOANIDACTIVITYID = new FinderPath(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
			LoanActivityModelImpl.FINDER_CACHE_ENABLED, LoanActivityImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLoanIdActivityId",
			new String[] { Long.class.getName(), Long.class.getName() },
			LoanActivityModelImpl.LOANID_COLUMN_BITMASK |
			LoanActivityModelImpl.ACTIVITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOANIDACTIVITYID = new FinderPath(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
			LoanActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLoanIdActivityId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the loan activity where loanId = &#63; and activityId = &#63; or throws a {@link NoSuchLoanActivityException} if it could not be found.
	 *
	 * @param loanId the loan ID
	 * @param activityId the activity ID
	 * @return the matching loan activity
	 * @throws NoSuchLoanActivityException if a matching loan activity could not be found
	 */
	@Override
	public LoanActivity findByLoanIdActivityId(long loanId, long activityId)
		throws NoSuchLoanActivityException {
		LoanActivity loanActivity = fetchByLoanIdActivityId(loanId, activityId);

		if (loanActivity == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("loanId=");
			msg.append(loanId);

			msg.append(", activityId=");
			msg.append(activityId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLoanActivityException(msg.toString());
		}

		return loanActivity;
	}

	/**
	 * Returns the loan activity where loanId = &#63; and activityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param loanId the loan ID
	 * @param activityId the activity ID
	 * @return the matching loan activity, or <code>null</code> if a matching loan activity could not be found
	 */
	@Override
	public LoanActivity fetchByLoanIdActivityId(long loanId, long activityId) {
		return fetchByLoanIdActivityId(loanId, activityId, true);
	}

	/**
	 * Returns the loan activity where loanId = &#63; and activityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param loanId the loan ID
	 * @param activityId the activity ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching loan activity, or <code>null</code> if a matching loan activity could not be found
	 */
	@Override
	public LoanActivity fetchByLoanIdActivityId(long loanId, long activityId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { loanId, activityId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_LOANIDACTIVITYID,
					finderArgs, this);
		}

		if (result instanceof LoanActivity) {
			LoanActivity loanActivity = (LoanActivity)result;

			if ((loanId != loanActivity.getLoanId()) ||
					(activityId != loanActivity.getActivityId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LOANACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_LOANIDACTIVITYID_LOANID_2);

			query.append(_FINDER_COLUMN_LOANIDACTIVITYID_ACTIVITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loanId);

				qPos.add(activityId);

				List<LoanActivity> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_LOANIDACTIVITYID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"LoanActivityPersistenceImpl.fetchByLoanIdActivityId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LoanActivity loanActivity = list.get(0);

					result = loanActivity;

					cacheResult(loanActivity);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_LOANIDACTIVITYID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (LoanActivity)result;
		}
	}

	/**
	 * Removes the loan activity where loanId = &#63; and activityId = &#63; from the database.
	 *
	 * @param loanId the loan ID
	 * @param activityId the activity ID
	 * @return the loan activity that was removed
	 */
	@Override
	public LoanActivity removeByLoanIdActivityId(long loanId, long activityId)
		throws NoSuchLoanActivityException {
		LoanActivity loanActivity = findByLoanIdActivityId(loanId, activityId);

		return remove(loanActivity);
	}

	/**
	 * Returns the number of loan activities where loanId = &#63; and activityId = &#63;.
	 *
	 * @param loanId the loan ID
	 * @param activityId the activity ID
	 * @return the number of matching loan activities
	 */
	@Override
	public int countByLoanIdActivityId(long loanId, long activityId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LOANIDACTIVITYID;

		Object[] finderArgs = new Object[] { loanId, activityId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LOANACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_LOANIDACTIVITYID_LOANID_2);

			query.append(_FINDER_COLUMN_LOANIDACTIVITYID_ACTIVITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loanId);

				qPos.add(activityId);

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

	private static final String _FINDER_COLUMN_LOANIDACTIVITYID_LOANID_2 = "loanActivity.loanId = ? AND ";
	private static final String _FINDER_COLUMN_LOANIDACTIVITYID_ACTIVITYID_2 = "loanActivity.activityId = ?";

	public LoanActivityPersistenceImpl() {
		setModelClass(LoanActivity.class);
	}

	/**
	 * Caches the loan activity in the entity cache if it is enabled.
	 *
	 * @param loanActivity the loan activity
	 */
	@Override
	public void cacheResult(LoanActivity loanActivity) {
		entityCache.putResult(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
			LoanActivityImpl.class, loanActivity.getPrimaryKey(), loanActivity);

		finderCache.putResult(FINDER_PATH_FETCH_BY_LOANIDACTIVITYID,
			new Object[] { loanActivity.getLoanId(), loanActivity.getActivityId() },
			loanActivity);

		loanActivity.resetOriginalValues();
	}

	/**
	 * Caches the loan activities in the entity cache if it is enabled.
	 *
	 * @param loanActivities the loan activities
	 */
	@Override
	public void cacheResult(List<LoanActivity> loanActivities) {
		for (LoanActivity loanActivity : loanActivities) {
			if (entityCache.getResult(
						LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
						LoanActivityImpl.class, loanActivity.getPrimaryKey()) == null) {
				cacheResult(loanActivity);
			}
			else {
				loanActivity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all loan activities.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LoanActivityImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the loan activity.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LoanActivity loanActivity) {
		entityCache.removeResult(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
			LoanActivityImpl.class, loanActivity.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LoanActivityModelImpl)loanActivity, true);
	}

	@Override
	public void clearCache(List<LoanActivity> loanActivities) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LoanActivity loanActivity : loanActivities) {
			entityCache.removeResult(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
				LoanActivityImpl.class, loanActivity.getPrimaryKey());

			clearUniqueFindersCache((LoanActivityModelImpl)loanActivity, true);
		}
	}

	protected void cacheUniqueFindersCache(
		LoanActivityModelImpl loanActivityModelImpl) {
		Object[] args = new Object[] {
				loanActivityModelImpl.getLoanId(),
				loanActivityModelImpl.getActivityId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_LOANIDACTIVITYID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_LOANIDACTIVITYID, args,
			loanActivityModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LoanActivityModelImpl loanActivityModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					loanActivityModelImpl.getLoanId(),
					loanActivityModelImpl.getActivityId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LOANIDACTIVITYID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_LOANIDACTIVITYID, args);
		}

		if ((loanActivityModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LOANIDACTIVITYID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					loanActivityModelImpl.getOriginalLoanId(),
					loanActivityModelImpl.getOriginalActivityId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LOANIDACTIVITYID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_LOANIDACTIVITYID, args);
		}
	}

	/**
	 * Creates a new loan activity with the primary key. Does not add the loan activity to the database.
	 *
	 * @param loanActivityId the primary key for the new loan activity
	 * @return the new loan activity
	 */
	@Override
	public LoanActivity create(long loanActivityId) {
		LoanActivity loanActivity = new LoanActivityImpl();

		loanActivity.setNew(true);
		loanActivity.setPrimaryKey(loanActivityId);

		loanActivity.setCompanyId(companyProvider.getCompanyId());

		return loanActivity;
	}

	/**
	 * Removes the loan activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loanActivityId the primary key of the loan activity
	 * @return the loan activity that was removed
	 * @throws NoSuchLoanActivityException if a loan activity with the primary key could not be found
	 */
	@Override
	public LoanActivity remove(long loanActivityId)
		throws NoSuchLoanActivityException {
		return remove((Serializable)loanActivityId);
	}

	/**
	 * Removes the loan activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the loan activity
	 * @return the loan activity that was removed
	 * @throws NoSuchLoanActivityException if a loan activity with the primary key could not be found
	 */
	@Override
	public LoanActivity remove(Serializable primaryKey)
		throws NoSuchLoanActivityException {
		Session session = null;

		try {
			session = openSession();

			LoanActivity loanActivity = (LoanActivity)session.get(LoanActivityImpl.class,
					primaryKey);

			if (loanActivity == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLoanActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(loanActivity);
		}
		catch (NoSuchLoanActivityException nsee) {
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
	protected LoanActivity removeImpl(LoanActivity loanActivity) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(loanActivity)) {
				loanActivity = (LoanActivity)session.get(LoanActivityImpl.class,
						loanActivity.getPrimaryKeyObj());
			}

			if (loanActivity != null) {
				session.delete(loanActivity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (loanActivity != null) {
			clearCache(loanActivity);
		}

		return loanActivity;
	}

	@Override
	public LoanActivity updateImpl(LoanActivity loanActivity) {
		boolean isNew = loanActivity.isNew();

		if (!(loanActivity instanceof LoanActivityModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(loanActivity.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(loanActivity);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in loanActivity proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LoanActivity implementation " +
				loanActivity.getClass());
		}

		LoanActivityModelImpl loanActivityModelImpl = (LoanActivityModelImpl)loanActivity;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (loanActivity.getCreateDate() == null)) {
			if (serviceContext == null) {
				loanActivity.setCreateDate(now);
			}
			else {
				loanActivity.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!loanActivityModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				loanActivity.setModifiedDate(now);
			}
			else {
				loanActivity.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (loanActivity.isNew()) {
				session.save(loanActivity);

				loanActivity.setNew(false);
			}
			else {
				loanActivity = (LoanActivity)session.merge(loanActivity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LoanActivityModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					loanActivityModelImpl.getCompanyId(),
					loanActivityModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
				args);

			args = new Object[] { loanActivityModelImpl.getLoanId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LOANID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANID,
				args);

			args = new Object[] { loanActivityModelImpl.getActivityId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((loanActivityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loanActivityModelImpl.getOriginalCompanyId(),
						loanActivityModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						loanActivityModelImpl.getCompanyId(),
						loanActivityModelImpl.getGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}

			if ((loanActivityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loanActivityModelImpl.getOriginalLoanId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LOANID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANID,
					args);

				args = new Object[] { loanActivityModelImpl.getLoanId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LOANID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANID,
					args);
			}

			if ((loanActivityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loanActivityModelImpl.getOriginalActivityId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID,
					args);

				args = new Object[] { loanActivityModelImpl.getActivityId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID,
					args);
			}
		}

		entityCache.putResult(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
			LoanActivityImpl.class, loanActivity.getPrimaryKey(), loanActivity,
			false);

		clearUniqueFindersCache(loanActivityModelImpl, false);
		cacheUniqueFindersCache(loanActivityModelImpl);

		loanActivity.resetOriginalValues();

		return loanActivity;
	}

	/**
	 * Returns the loan activity with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the loan activity
	 * @return the loan activity
	 * @throws NoSuchLoanActivityException if a loan activity with the primary key could not be found
	 */
	@Override
	public LoanActivity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLoanActivityException {
		LoanActivity loanActivity = fetchByPrimaryKey(primaryKey);

		if (loanActivity == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLoanActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return loanActivity;
	}

	/**
	 * Returns the loan activity with the primary key or throws a {@link NoSuchLoanActivityException} if it could not be found.
	 *
	 * @param loanActivityId the primary key of the loan activity
	 * @return the loan activity
	 * @throws NoSuchLoanActivityException if a loan activity with the primary key could not be found
	 */
	@Override
	public LoanActivity findByPrimaryKey(long loanActivityId)
		throws NoSuchLoanActivityException {
		return findByPrimaryKey((Serializable)loanActivityId);
	}

	/**
	 * Returns the loan activity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the loan activity
	 * @return the loan activity, or <code>null</code> if a loan activity with the primary key could not be found
	 */
	@Override
	public LoanActivity fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
				LoanActivityImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LoanActivity loanActivity = (LoanActivity)serializable;

		if (loanActivity == null) {
			Session session = null;

			try {
				session = openSession();

				loanActivity = (LoanActivity)session.get(LoanActivityImpl.class,
						primaryKey);

				if (loanActivity != null) {
					cacheResult(loanActivity);
				}
				else {
					entityCache.putResult(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
						LoanActivityImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
					LoanActivityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return loanActivity;
	}

	/**
	 * Returns the loan activity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loanActivityId the primary key of the loan activity
	 * @return the loan activity, or <code>null</code> if a loan activity with the primary key could not be found
	 */
	@Override
	public LoanActivity fetchByPrimaryKey(long loanActivityId) {
		return fetchByPrimaryKey((Serializable)loanActivityId);
	}

	@Override
	public Map<Serializable, LoanActivity> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LoanActivity> map = new HashMap<Serializable, LoanActivity>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LoanActivity loanActivity = fetchByPrimaryKey(primaryKey);

			if (loanActivity != null) {
				map.put(primaryKey, loanActivity);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
					LoanActivityImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LoanActivity)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LOANACTIVITY_WHERE_PKS_IN);

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

			for (LoanActivity loanActivity : (List<LoanActivity>)q.list()) {
				map.put(loanActivity.getPrimaryKeyObj(), loanActivity);

				cacheResult(loanActivity);

				uncachedPrimaryKeys.remove(loanActivity.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LoanActivityModelImpl.ENTITY_CACHE_ENABLED,
					LoanActivityImpl.class, primaryKey, nullModel);
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
	 * Returns all the loan activities.
	 *
	 * @return the loan activities
	 */
	@Override
	public List<LoanActivity> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loan activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loan activities
	 * @param end the upper bound of the range of loan activities (not inclusive)
	 * @return the range of loan activities
	 */
	@Override
	public List<LoanActivity> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the loan activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loan activities
	 * @param end the upper bound of the range of loan activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of loan activities
	 */
	@Override
	public List<LoanActivity> findAll(int start, int end,
		OrderByComparator<LoanActivity> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loan activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loan activities
	 * @param end the upper bound of the range of loan activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of loan activities
	 */
	@Override
	public List<LoanActivity> findAll(int start, int end,
		OrderByComparator<LoanActivity> orderByComparator,
		boolean retrieveFromCache) {
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

		List<LoanActivity> list = null;

		if (retrieveFromCache) {
			list = (List<LoanActivity>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LOANACTIVITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOANACTIVITY;

				if (pagination) {
					sql = sql.concat(LoanActivityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LoanActivity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LoanActivity>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the loan activities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LoanActivity loanActivity : findAll()) {
			remove(loanActivity);
		}
	}

	/**
	 * Returns the number of loan activities.
	 *
	 * @return the number of loan activities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOANACTIVITY);

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
		return LoanActivityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the loan activity persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LoanActivityImpl.class.getName());
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
	private static final String _SQL_SELECT_LOANACTIVITY = "SELECT loanActivity FROM LoanActivity loanActivity";
	private static final String _SQL_SELECT_LOANACTIVITY_WHERE_PKS_IN = "SELECT loanActivity FROM LoanActivity loanActivity WHERE loanActivityId IN (";
	private static final String _SQL_SELECT_LOANACTIVITY_WHERE = "SELECT loanActivity FROM LoanActivity loanActivity WHERE ";
	private static final String _SQL_COUNT_LOANACTIVITY = "SELECT COUNT(loanActivity) FROM LoanActivity loanActivity";
	private static final String _SQL_COUNT_LOANACTIVITY_WHERE = "SELECT COUNT(loanActivity) FROM LoanActivity loanActivity WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "loanActivity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LoanActivity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LoanActivity exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LoanActivityPersistenceImpl.class);
}
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

import cat.diba.materialesportiu.exception.NoSuchActivityDependsOnException;
import cat.diba.materialesportiu.model.ActivityDependsOn;
import cat.diba.materialesportiu.model.impl.ActivityDependsOnImpl;
import cat.diba.materialesportiu.model.impl.ActivityDependsOnModelImpl;
import cat.diba.materialesportiu.service.persistence.ActivityDependsOnPersistence;

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
 * The persistence implementation for the activity depends on service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityDependsOnPersistence
 * @see cat.diba.materialesportiu.service.persistence.ActivityDependsOnUtil
 * @generated
 */
@ProviderType
public class ActivityDependsOnPersistenceImpl extends BasePersistenceImpl<ActivityDependsOn>
	implements ActivityDependsOnPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ActivityDependsOnUtil} to access the activity depends on persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ActivityDependsOnImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
			ActivityDependsOnModelImpl.FINDER_CACHE_ENABLED,
			ActivityDependsOnImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
			ActivityDependsOnModelImpl.FINDER_CACHE_ENABLED,
			ActivityDependsOnImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
			ActivityDependsOnModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
			ActivityDependsOnModelImpl.FINDER_CACHE_ENABLED,
			ActivityDependsOnImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
			ActivityDependsOnModelImpl.FINDER_CACHE_ENABLED,
			ActivityDependsOnImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			ActivityDependsOnModelImpl.COMPANYID_COLUMN_BITMASK |
			ActivityDependsOnModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
			ActivityDependsOnModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the activity depends ons where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching activity depends ons
	 */
	@Override
	public List<ActivityDependsOn> findByCompanyGroup(long companyId,
		long groupId) {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity depends ons where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity depends ons
	 * @param end the upper bound of the range of activity depends ons (not inclusive)
	 * @return the range of matching activity depends ons
	 */
	@Override
	public List<ActivityDependsOn> findByCompanyGroup(long companyId,
		long groupId, int start, int end) {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity depends ons where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity depends ons
	 * @param end the upper bound of the range of activity depends ons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity depends ons
	 */
	@Override
	public List<ActivityDependsOn> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<ActivityDependsOn> orderByComparator) {
		return findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity depends ons where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity depends ons
	 * @param end the upper bound of the range of activity depends ons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching activity depends ons
	 */
	@Override
	public List<ActivityDependsOn> findByCompanyGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<ActivityDependsOn> orderByComparator,
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

		List<ActivityDependsOn> list = null;

		if (retrieveFromCache) {
			list = (List<ActivityDependsOn>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ActivityDependsOn activityDependsOn : list) {
					if ((companyId != activityDependsOn.getCompanyId()) ||
							(groupId != activityDependsOn.getGroupId())) {
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

			query.append(_SQL_SELECT_ACTIVITYDEPENDSON_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ActivityDependsOnModelImpl.ORDER_BY_JPQL);
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
					list = (List<ActivityDependsOn>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ActivityDependsOn>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first activity depends on in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity depends on
	 * @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	 */
	@Override
	public ActivityDependsOn findByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException {
		ActivityDependsOn activityDependsOn = fetchByCompanyGroup_First(companyId,
				groupId, orderByComparator);

		if (activityDependsOn != null) {
			return activityDependsOn;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchActivityDependsOnException(msg.toString());
	}

	/**
	 * Returns the first activity depends on in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	 */
	@Override
	public ActivityDependsOn fetchByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator<ActivityDependsOn> orderByComparator) {
		List<ActivityDependsOn> list = findByCompanyGroup(companyId, groupId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity depends on in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity depends on
	 * @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	 */
	@Override
	public ActivityDependsOn findByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException {
		ActivityDependsOn activityDependsOn = fetchByCompanyGroup_Last(companyId,
				groupId, orderByComparator);

		if (activityDependsOn != null) {
			return activityDependsOn;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchActivityDependsOnException(msg.toString());
	}

	/**
	 * Returns the last activity depends on in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	 */
	@Override
	public ActivityDependsOn fetchByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator<ActivityDependsOn> orderByComparator) {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<ActivityDependsOn> list = findByCompanyGroup(companyId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activity depends ons before and after the current activity depends on in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param activityDependsOnId the primary key of the current activity depends on
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity depends on
	 * @throws NoSuchActivityDependsOnException if a activity depends on with the primary key could not be found
	 */
	@Override
	public ActivityDependsOn[] findByCompanyGroup_PrevAndNext(
		long activityDependsOnId, long companyId, long groupId,
		OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException {
		ActivityDependsOn activityDependsOn = findByPrimaryKey(activityDependsOnId);

		Session session = null;

		try {
			session = openSession();

			ActivityDependsOn[] array = new ActivityDependsOnImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session,
					activityDependsOn, companyId, groupId, orderByComparator,
					true);

			array[1] = activityDependsOn;

			array[2] = getByCompanyGroup_PrevAndNext(session,
					activityDependsOn, companyId, groupId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ActivityDependsOn getByCompanyGroup_PrevAndNext(Session session,
		ActivityDependsOn activityDependsOn, long companyId, long groupId,
		OrderByComparator<ActivityDependsOn> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ACTIVITYDEPENDSON_WHERE);

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
			query.append(ActivityDependsOnModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(activityDependsOn);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ActivityDependsOn> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activity depends ons where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId) {
		for (ActivityDependsOn activityDependsOn : findByCompanyGroup(
				companyId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(activityDependsOn);
		}
	}

	/**
	 * Returns the number of activity depends ons where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching activity depends ons
	 */
	@Override
	public int countByCompanyGroup(long companyId, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYGROUP;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ACTIVITYDEPENDSON_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "activityDependsOn.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "activityDependsOn.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYID =
		new FinderPath(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
			ActivityDependsOnModelImpl.FINDER_CACHE_ENABLED,
			ActivityDependsOnImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActivityId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID =
		new FinderPath(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
			ActivityDependsOnModelImpl.FINDER_CACHE_ENABLED,
			ActivityDependsOnImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActivityId",
			new String[] { Long.class.getName() },
			ActivityDependsOnModelImpl.ACTIVITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYID = new FinderPath(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
			ActivityDependsOnModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActivityId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the activity depends ons where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @return the matching activity depends ons
	 */
	@Override
	public List<ActivityDependsOn> findByActivityId(long activityId) {
		return findByActivityId(activityId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity depends ons where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of activity depends ons
	 * @param end the upper bound of the range of activity depends ons (not inclusive)
	 * @return the range of matching activity depends ons
	 */
	@Override
	public List<ActivityDependsOn> findByActivityId(long activityId, int start,
		int end) {
		return findByActivityId(activityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity depends ons where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of activity depends ons
	 * @param end the upper bound of the range of activity depends ons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity depends ons
	 */
	@Override
	public List<ActivityDependsOn> findByActivityId(long activityId, int start,
		int end, OrderByComparator<ActivityDependsOn> orderByComparator) {
		return findByActivityId(activityId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity depends ons where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of activity depends ons
	 * @param end the upper bound of the range of activity depends ons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching activity depends ons
	 */
	@Override
	public List<ActivityDependsOn> findByActivityId(long activityId, int start,
		int end, OrderByComparator<ActivityDependsOn> orderByComparator,
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

		List<ActivityDependsOn> list = null;

		if (retrieveFromCache) {
			list = (List<ActivityDependsOn>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ActivityDependsOn activityDependsOn : list) {
					if ((activityId != activityDependsOn.getActivityId())) {
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

			query.append(_SQL_SELECT_ACTIVITYDEPENDSON_WHERE);

			query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ActivityDependsOnModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(activityId);

				if (!pagination) {
					list = (List<ActivityDependsOn>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ActivityDependsOn>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first activity depends on in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity depends on
	 * @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	 */
	@Override
	public ActivityDependsOn findByActivityId_First(long activityId,
		OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException {
		ActivityDependsOn activityDependsOn = fetchByActivityId_First(activityId,
				orderByComparator);

		if (activityDependsOn != null) {
			return activityDependsOn;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("activityId=");
		msg.append(activityId);

		msg.append("}");

		throw new NoSuchActivityDependsOnException(msg.toString());
	}

	/**
	 * Returns the first activity depends on in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	 */
	@Override
	public ActivityDependsOn fetchByActivityId_First(long activityId,
		OrderByComparator<ActivityDependsOn> orderByComparator) {
		List<ActivityDependsOn> list = findByActivityId(activityId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity depends on in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity depends on
	 * @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	 */
	@Override
	public ActivityDependsOn findByActivityId_Last(long activityId,
		OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException {
		ActivityDependsOn activityDependsOn = fetchByActivityId_Last(activityId,
				orderByComparator);

		if (activityDependsOn != null) {
			return activityDependsOn;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("activityId=");
		msg.append(activityId);

		msg.append("}");

		throw new NoSuchActivityDependsOnException(msg.toString());
	}

	/**
	 * Returns the last activity depends on in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	 */
	@Override
	public ActivityDependsOn fetchByActivityId_Last(long activityId,
		OrderByComparator<ActivityDependsOn> orderByComparator) {
		int count = countByActivityId(activityId);

		if (count == 0) {
			return null;
		}

		List<ActivityDependsOn> list = findByActivityId(activityId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activity depends ons before and after the current activity depends on in the ordered set where activityId = &#63;.
	 *
	 * @param activityDependsOnId the primary key of the current activity depends on
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity depends on
	 * @throws NoSuchActivityDependsOnException if a activity depends on with the primary key could not be found
	 */
	@Override
	public ActivityDependsOn[] findByActivityId_PrevAndNext(
		long activityDependsOnId, long activityId,
		OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException {
		ActivityDependsOn activityDependsOn = findByPrimaryKey(activityDependsOnId);

		Session session = null;

		try {
			session = openSession();

			ActivityDependsOn[] array = new ActivityDependsOnImpl[3];

			array[0] = getByActivityId_PrevAndNext(session, activityDependsOn,
					activityId, orderByComparator, true);

			array[1] = activityDependsOn;

			array[2] = getByActivityId_PrevAndNext(session, activityDependsOn,
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

	protected ActivityDependsOn getByActivityId_PrevAndNext(Session session,
		ActivityDependsOn activityDependsOn, long activityId,
		OrderByComparator<ActivityDependsOn> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACTIVITYDEPENDSON_WHERE);

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
			query.append(ActivityDependsOnModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(activityId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(activityDependsOn);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ActivityDependsOn> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activity depends ons where activityId = &#63; from the database.
	 *
	 * @param activityId the activity ID
	 */
	@Override
	public void removeByActivityId(long activityId) {
		for (ActivityDependsOn activityDependsOn : findByActivityId(
				activityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(activityDependsOn);
		}
	}

	/**
	 * Returns the number of activity depends ons where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @return the number of matching activity depends ons
	 */
	@Override
	public int countByActivityId(long activityId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVITYID;

		Object[] finderArgs = new Object[] { activityId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACTIVITYDEPENDSON_WHERE);

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

	private static final String _FINDER_COLUMN_ACTIVITYID_ACTIVITYID_2 = "activityDependsOn.activityId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ACTIVITYIDPARENTACTIVITYID =
		new FinderPath(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
			ActivityDependsOnModelImpl.FINDER_CACHE_ENABLED,
			ActivityDependsOnImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByActivityIdParentActivityId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ActivityDependsOnModelImpl.ACTIVITYID_COLUMN_BITMASK |
			ActivityDependsOnModelImpl.PARENTACTIVITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYIDPARENTACTIVITYID =
		new FinderPath(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
			ActivityDependsOnModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByActivityIdParentActivityId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the activity depends on where activityId = &#63; and parentActivityId = &#63; or throws a {@link NoSuchActivityDependsOnException} if it could not be found.
	 *
	 * @param activityId the activity ID
	 * @param parentActivityId the parent activity ID
	 * @return the matching activity depends on
	 * @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	 */
	@Override
	public ActivityDependsOn findByActivityIdParentActivityId(long activityId,
		long parentActivityId) throws NoSuchActivityDependsOnException {
		ActivityDependsOn activityDependsOn = fetchByActivityIdParentActivityId(activityId,
				parentActivityId);

		if (activityDependsOn == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("activityId=");
			msg.append(activityId);

			msg.append(", parentActivityId=");
			msg.append(parentActivityId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchActivityDependsOnException(msg.toString());
		}

		return activityDependsOn;
	}

	/**
	 * Returns the activity depends on where activityId = &#63; and parentActivityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param activityId the activity ID
	 * @param parentActivityId the parent activity ID
	 * @return the matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	 */
	@Override
	public ActivityDependsOn fetchByActivityIdParentActivityId(
		long activityId, long parentActivityId) {
		return fetchByActivityIdParentActivityId(activityId, parentActivityId,
			true);
	}

	/**
	 * Returns the activity depends on where activityId = &#63; and parentActivityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param activityId the activity ID
	 * @param parentActivityId the parent activity ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	 */
	@Override
	public ActivityDependsOn fetchByActivityIdParentActivityId(
		long activityId, long parentActivityId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { activityId, parentActivityId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_ACTIVITYIDPARENTACTIVITYID,
					finderArgs, this);
		}

		if (result instanceof ActivityDependsOn) {
			ActivityDependsOn activityDependsOn = (ActivityDependsOn)result;

			if ((activityId != activityDependsOn.getActivityId()) ||
					(parentActivityId != activityDependsOn.getParentActivityId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ACTIVITYDEPENDSON_WHERE);

			query.append(_FINDER_COLUMN_ACTIVITYIDPARENTACTIVITYID_ACTIVITYID_2);

			query.append(_FINDER_COLUMN_ACTIVITYIDPARENTACTIVITYID_PARENTACTIVITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(activityId);

				qPos.add(parentActivityId);

				List<ActivityDependsOn> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDPARENTACTIVITYID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ActivityDependsOnPersistenceImpl.fetchByActivityIdParentActivityId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ActivityDependsOn activityDependsOn = list.get(0);

					result = activityDependsOn;

					cacheResult(activityDependsOn);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYIDPARENTACTIVITYID,
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
			return (ActivityDependsOn)result;
		}
	}

	/**
	 * Removes the activity depends on where activityId = &#63; and parentActivityId = &#63; from the database.
	 *
	 * @param activityId the activity ID
	 * @param parentActivityId the parent activity ID
	 * @return the activity depends on that was removed
	 */
	@Override
	public ActivityDependsOn removeByActivityIdParentActivityId(
		long activityId, long parentActivityId)
		throws NoSuchActivityDependsOnException {
		ActivityDependsOn activityDependsOn = findByActivityIdParentActivityId(activityId,
				parentActivityId);

		return remove(activityDependsOn);
	}

	/**
	 * Returns the number of activity depends ons where activityId = &#63; and parentActivityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param parentActivityId the parent activity ID
	 * @return the number of matching activity depends ons
	 */
	@Override
	public int countByActivityIdParentActivityId(long activityId,
		long parentActivityId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVITYIDPARENTACTIVITYID;

		Object[] finderArgs = new Object[] { activityId, parentActivityId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ACTIVITYDEPENDSON_WHERE);

			query.append(_FINDER_COLUMN_ACTIVITYIDPARENTACTIVITYID_ACTIVITYID_2);

			query.append(_FINDER_COLUMN_ACTIVITYIDPARENTACTIVITYID_PARENTACTIVITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(activityId);

				qPos.add(parentActivityId);

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

	private static final String _FINDER_COLUMN_ACTIVITYIDPARENTACTIVITYID_ACTIVITYID_2 =
		"activityDependsOn.activityId = ? AND ";
	private static final String _FINDER_COLUMN_ACTIVITYIDPARENTACTIVITYID_PARENTACTIVITYID_2 =
		"activityDependsOn.parentActivityId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTACTIVITYID =
		new FinderPath(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
			ActivityDependsOnModelImpl.FINDER_CACHE_ENABLED,
			ActivityDependsOnImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentActivityId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTACTIVITYID =
		new FinderPath(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
			ActivityDependsOnModelImpl.FINDER_CACHE_ENABLED,
			ActivityDependsOnImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentActivityId", new String[] { Long.class.getName() },
			ActivityDependsOnModelImpl.PARENTACTIVITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTACTIVITYID = new FinderPath(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
			ActivityDependsOnModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentActivityId", new String[] { Long.class.getName() });

	/**
	 * Returns all the activity depends ons where parentActivityId = &#63;.
	 *
	 * @param parentActivityId the parent activity ID
	 * @return the matching activity depends ons
	 */
	@Override
	public List<ActivityDependsOn> findByParentActivityId(long parentActivityId) {
		return findByParentActivityId(parentActivityId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity depends ons where parentActivityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentActivityId the parent activity ID
	 * @param start the lower bound of the range of activity depends ons
	 * @param end the upper bound of the range of activity depends ons (not inclusive)
	 * @return the range of matching activity depends ons
	 */
	@Override
	public List<ActivityDependsOn> findByParentActivityId(
		long parentActivityId, int start, int end) {
		return findByParentActivityId(parentActivityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity depends ons where parentActivityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentActivityId the parent activity ID
	 * @param start the lower bound of the range of activity depends ons
	 * @param end the upper bound of the range of activity depends ons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity depends ons
	 */
	@Override
	public List<ActivityDependsOn> findByParentActivityId(
		long parentActivityId, int start, int end,
		OrderByComparator<ActivityDependsOn> orderByComparator) {
		return findByParentActivityId(parentActivityId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity depends ons where parentActivityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentActivityId the parent activity ID
	 * @param start the lower bound of the range of activity depends ons
	 * @param end the upper bound of the range of activity depends ons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching activity depends ons
	 */
	@Override
	public List<ActivityDependsOn> findByParentActivityId(
		long parentActivityId, int start, int end,
		OrderByComparator<ActivityDependsOn> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTACTIVITYID;
			finderArgs = new Object[] { parentActivityId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTACTIVITYID;
			finderArgs = new Object[] {
					parentActivityId,
					
					start, end, orderByComparator
				};
		}

		List<ActivityDependsOn> list = null;

		if (retrieveFromCache) {
			list = (List<ActivityDependsOn>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ActivityDependsOn activityDependsOn : list) {
					if ((parentActivityId != activityDependsOn.getParentActivityId())) {
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

			query.append(_SQL_SELECT_ACTIVITYDEPENDSON_WHERE);

			query.append(_FINDER_COLUMN_PARENTACTIVITYID_PARENTACTIVITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ActivityDependsOnModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentActivityId);

				if (!pagination) {
					list = (List<ActivityDependsOn>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ActivityDependsOn>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first activity depends on in the ordered set where parentActivityId = &#63;.
	 *
	 * @param parentActivityId the parent activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity depends on
	 * @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	 */
	@Override
	public ActivityDependsOn findByParentActivityId_First(
		long parentActivityId,
		OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException {
		ActivityDependsOn activityDependsOn = fetchByParentActivityId_First(parentActivityId,
				orderByComparator);

		if (activityDependsOn != null) {
			return activityDependsOn;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentActivityId=");
		msg.append(parentActivityId);

		msg.append("}");

		throw new NoSuchActivityDependsOnException(msg.toString());
	}

	/**
	 * Returns the first activity depends on in the ordered set where parentActivityId = &#63;.
	 *
	 * @param parentActivityId the parent activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	 */
	@Override
	public ActivityDependsOn fetchByParentActivityId_First(
		long parentActivityId,
		OrderByComparator<ActivityDependsOn> orderByComparator) {
		List<ActivityDependsOn> list = findByParentActivityId(parentActivityId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity depends on in the ordered set where parentActivityId = &#63;.
	 *
	 * @param parentActivityId the parent activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity depends on
	 * @throws NoSuchActivityDependsOnException if a matching activity depends on could not be found
	 */
	@Override
	public ActivityDependsOn findByParentActivityId_Last(
		long parentActivityId,
		OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException {
		ActivityDependsOn activityDependsOn = fetchByParentActivityId_Last(parentActivityId,
				orderByComparator);

		if (activityDependsOn != null) {
			return activityDependsOn;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentActivityId=");
		msg.append(parentActivityId);

		msg.append("}");

		throw new NoSuchActivityDependsOnException(msg.toString());
	}

	/**
	 * Returns the last activity depends on in the ordered set where parentActivityId = &#63;.
	 *
	 * @param parentActivityId the parent activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity depends on, or <code>null</code> if a matching activity depends on could not be found
	 */
	@Override
	public ActivityDependsOn fetchByParentActivityId_Last(
		long parentActivityId,
		OrderByComparator<ActivityDependsOn> orderByComparator) {
		int count = countByParentActivityId(parentActivityId);

		if (count == 0) {
			return null;
		}

		List<ActivityDependsOn> list = findByParentActivityId(parentActivityId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activity depends ons before and after the current activity depends on in the ordered set where parentActivityId = &#63;.
	 *
	 * @param activityDependsOnId the primary key of the current activity depends on
	 * @param parentActivityId the parent activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity depends on
	 * @throws NoSuchActivityDependsOnException if a activity depends on with the primary key could not be found
	 */
	@Override
	public ActivityDependsOn[] findByParentActivityId_PrevAndNext(
		long activityDependsOnId, long parentActivityId,
		OrderByComparator<ActivityDependsOn> orderByComparator)
		throws NoSuchActivityDependsOnException {
		ActivityDependsOn activityDependsOn = findByPrimaryKey(activityDependsOnId);

		Session session = null;

		try {
			session = openSession();

			ActivityDependsOn[] array = new ActivityDependsOnImpl[3];

			array[0] = getByParentActivityId_PrevAndNext(session,
					activityDependsOn, parentActivityId, orderByComparator, true);

			array[1] = activityDependsOn;

			array[2] = getByParentActivityId_PrevAndNext(session,
					activityDependsOn, parentActivityId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ActivityDependsOn getByParentActivityId_PrevAndNext(
		Session session, ActivityDependsOn activityDependsOn,
		long parentActivityId,
		OrderByComparator<ActivityDependsOn> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACTIVITYDEPENDSON_WHERE);

		query.append(_FINDER_COLUMN_PARENTACTIVITYID_PARENTACTIVITYID_2);

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
			query.append(ActivityDependsOnModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentActivityId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(activityDependsOn);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ActivityDependsOn> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activity depends ons where parentActivityId = &#63; from the database.
	 *
	 * @param parentActivityId the parent activity ID
	 */
	@Override
	public void removeByParentActivityId(long parentActivityId) {
		for (ActivityDependsOn activityDependsOn : findByParentActivityId(
				parentActivityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(activityDependsOn);
		}
	}

	/**
	 * Returns the number of activity depends ons where parentActivityId = &#63;.
	 *
	 * @param parentActivityId the parent activity ID
	 * @return the number of matching activity depends ons
	 */
	@Override
	public int countByParentActivityId(long parentActivityId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTACTIVITYID;

		Object[] finderArgs = new Object[] { parentActivityId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACTIVITYDEPENDSON_WHERE);

			query.append(_FINDER_COLUMN_PARENTACTIVITYID_PARENTACTIVITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentActivityId);

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

	private static final String _FINDER_COLUMN_PARENTACTIVITYID_PARENTACTIVITYID_2 =
		"activityDependsOn.parentActivityId = ?";

	public ActivityDependsOnPersistenceImpl() {
		setModelClass(ActivityDependsOn.class);
	}

	/**
	 * Caches the activity depends on in the entity cache if it is enabled.
	 *
	 * @param activityDependsOn the activity depends on
	 */
	@Override
	public void cacheResult(ActivityDependsOn activityDependsOn) {
		entityCache.putResult(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
			ActivityDependsOnImpl.class, activityDependsOn.getPrimaryKey(),
			activityDependsOn);

		finderCache.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDPARENTACTIVITYID,
			new Object[] {
				activityDependsOn.getActivityId(),
				activityDependsOn.getParentActivityId()
			}, activityDependsOn);

		activityDependsOn.resetOriginalValues();
	}

	/**
	 * Caches the activity depends ons in the entity cache if it is enabled.
	 *
	 * @param activityDependsOns the activity depends ons
	 */
	@Override
	public void cacheResult(List<ActivityDependsOn> activityDependsOns) {
		for (ActivityDependsOn activityDependsOn : activityDependsOns) {
			if (entityCache.getResult(
						ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
						ActivityDependsOnImpl.class,
						activityDependsOn.getPrimaryKey()) == null) {
				cacheResult(activityDependsOn);
			}
			else {
				activityDependsOn.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all activity depends ons.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ActivityDependsOnImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the activity depends on.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ActivityDependsOn activityDependsOn) {
		entityCache.removeResult(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
			ActivityDependsOnImpl.class, activityDependsOn.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ActivityDependsOnModelImpl)activityDependsOn,
			true);
	}

	@Override
	public void clearCache(List<ActivityDependsOn> activityDependsOns) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ActivityDependsOn activityDependsOn : activityDependsOns) {
			entityCache.removeResult(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
				ActivityDependsOnImpl.class, activityDependsOn.getPrimaryKey());

			clearUniqueFindersCache((ActivityDependsOnModelImpl)activityDependsOn,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		ActivityDependsOnModelImpl activityDependsOnModelImpl) {
		Object[] args = new Object[] {
				activityDependsOnModelImpl.getActivityId(),
				activityDependsOnModelImpl.getParentActivityId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_ACTIVITYIDPARENTACTIVITYID,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDPARENTACTIVITYID,
			args, activityDependsOnModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ActivityDependsOnModelImpl activityDependsOnModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					activityDependsOnModelImpl.getActivityId(),
					activityDependsOnModelImpl.getParentActivityId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYIDPARENTACTIVITYID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYIDPARENTACTIVITYID,
				args);
		}

		if ((activityDependsOnModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ACTIVITYIDPARENTACTIVITYID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					activityDependsOnModelImpl.getOriginalActivityId(),
					activityDependsOnModelImpl.getOriginalParentActivityId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYIDPARENTACTIVITYID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYIDPARENTACTIVITYID,
				args);
		}
	}

	/**
	 * Creates a new activity depends on with the primary key. Does not add the activity depends on to the database.
	 *
	 * @param activityDependsOnId the primary key for the new activity depends on
	 * @return the new activity depends on
	 */
	@Override
	public ActivityDependsOn create(long activityDependsOnId) {
		ActivityDependsOn activityDependsOn = new ActivityDependsOnImpl();

		activityDependsOn.setNew(true);
		activityDependsOn.setPrimaryKey(activityDependsOnId);

		activityDependsOn.setCompanyId(companyProvider.getCompanyId());

		return activityDependsOn;
	}

	/**
	 * Removes the activity depends on with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityDependsOnId the primary key of the activity depends on
	 * @return the activity depends on that was removed
	 * @throws NoSuchActivityDependsOnException if a activity depends on with the primary key could not be found
	 */
	@Override
	public ActivityDependsOn remove(long activityDependsOnId)
		throws NoSuchActivityDependsOnException {
		return remove((Serializable)activityDependsOnId);
	}

	/**
	 * Removes the activity depends on with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the activity depends on
	 * @return the activity depends on that was removed
	 * @throws NoSuchActivityDependsOnException if a activity depends on with the primary key could not be found
	 */
	@Override
	public ActivityDependsOn remove(Serializable primaryKey)
		throws NoSuchActivityDependsOnException {
		Session session = null;

		try {
			session = openSession();

			ActivityDependsOn activityDependsOn = (ActivityDependsOn)session.get(ActivityDependsOnImpl.class,
					primaryKey);

			if (activityDependsOn == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchActivityDependsOnException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(activityDependsOn);
		}
		catch (NoSuchActivityDependsOnException nsee) {
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
	protected ActivityDependsOn removeImpl(ActivityDependsOn activityDependsOn) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(activityDependsOn)) {
				activityDependsOn = (ActivityDependsOn)session.get(ActivityDependsOnImpl.class,
						activityDependsOn.getPrimaryKeyObj());
			}

			if (activityDependsOn != null) {
				session.delete(activityDependsOn);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (activityDependsOn != null) {
			clearCache(activityDependsOn);
		}

		return activityDependsOn;
	}

	@Override
	public ActivityDependsOn updateImpl(ActivityDependsOn activityDependsOn) {
		boolean isNew = activityDependsOn.isNew();

		if (!(activityDependsOn instanceof ActivityDependsOnModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(activityDependsOn.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(activityDependsOn);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in activityDependsOn proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ActivityDependsOn implementation " +
				activityDependsOn.getClass());
		}

		ActivityDependsOnModelImpl activityDependsOnModelImpl = (ActivityDependsOnModelImpl)activityDependsOn;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (activityDependsOn.getCreateDate() == null)) {
			if (serviceContext == null) {
				activityDependsOn.setCreateDate(now);
			}
			else {
				activityDependsOn.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!activityDependsOnModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				activityDependsOn.setModifiedDate(now);
			}
			else {
				activityDependsOn.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (activityDependsOn.isNew()) {
				session.save(activityDependsOn);

				activityDependsOn.setNew(false);
			}
			else {
				activityDependsOn = (ActivityDependsOn)session.merge(activityDependsOn);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ActivityDependsOnModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					activityDependsOnModelImpl.getCompanyId(),
					activityDependsOnModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
				args);

			args = new Object[] { activityDependsOnModelImpl.getActivityId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID,
				args);

			args = new Object[] { activityDependsOnModelImpl.getParentActivityId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PARENTACTIVITYID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTACTIVITYID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((activityDependsOnModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						activityDependsOnModelImpl.getOriginalCompanyId(),
						activityDependsOnModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						activityDependsOnModelImpl.getCompanyId(),
						activityDependsOnModelImpl.getGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}

			if ((activityDependsOnModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						activityDependsOnModelImpl.getOriginalActivityId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID,
					args);

				args = new Object[] { activityDependsOnModelImpl.getActivityId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID,
					args);
			}

			if ((activityDependsOnModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTACTIVITYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						activityDependsOnModelImpl.getOriginalParentActivityId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PARENTACTIVITYID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTACTIVITYID,
					args);

				args = new Object[] {
						activityDependsOnModelImpl.getParentActivityId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PARENTACTIVITYID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTACTIVITYID,
					args);
			}
		}

		entityCache.putResult(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
			ActivityDependsOnImpl.class, activityDependsOn.getPrimaryKey(),
			activityDependsOn, false);

		clearUniqueFindersCache(activityDependsOnModelImpl, false);
		cacheUniqueFindersCache(activityDependsOnModelImpl);

		activityDependsOn.resetOriginalValues();

		return activityDependsOn;
	}

	/**
	 * Returns the activity depends on with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the activity depends on
	 * @return the activity depends on
	 * @throws NoSuchActivityDependsOnException if a activity depends on with the primary key could not be found
	 */
	@Override
	public ActivityDependsOn findByPrimaryKey(Serializable primaryKey)
		throws NoSuchActivityDependsOnException {
		ActivityDependsOn activityDependsOn = fetchByPrimaryKey(primaryKey);

		if (activityDependsOn == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchActivityDependsOnException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return activityDependsOn;
	}

	/**
	 * Returns the activity depends on with the primary key or throws a {@link NoSuchActivityDependsOnException} if it could not be found.
	 *
	 * @param activityDependsOnId the primary key of the activity depends on
	 * @return the activity depends on
	 * @throws NoSuchActivityDependsOnException if a activity depends on with the primary key could not be found
	 */
	@Override
	public ActivityDependsOn findByPrimaryKey(long activityDependsOnId)
		throws NoSuchActivityDependsOnException {
		return findByPrimaryKey((Serializable)activityDependsOnId);
	}

	/**
	 * Returns the activity depends on with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the activity depends on
	 * @return the activity depends on, or <code>null</code> if a activity depends on with the primary key could not be found
	 */
	@Override
	public ActivityDependsOn fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
				ActivityDependsOnImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ActivityDependsOn activityDependsOn = (ActivityDependsOn)serializable;

		if (activityDependsOn == null) {
			Session session = null;

			try {
				session = openSession();

				activityDependsOn = (ActivityDependsOn)session.get(ActivityDependsOnImpl.class,
						primaryKey);

				if (activityDependsOn != null) {
					cacheResult(activityDependsOn);
				}
				else {
					entityCache.putResult(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
						ActivityDependsOnImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
					ActivityDependsOnImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return activityDependsOn;
	}

	/**
	 * Returns the activity depends on with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param activityDependsOnId the primary key of the activity depends on
	 * @return the activity depends on, or <code>null</code> if a activity depends on with the primary key could not be found
	 */
	@Override
	public ActivityDependsOn fetchByPrimaryKey(long activityDependsOnId) {
		return fetchByPrimaryKey((Serializable)activityDependsOnId);
	}

	@Override
	public Map<Serializable, ActivityDependsOn> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ActivityDependsOn> map = new HashMap<Serializable, ActivityDependsOn>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ActivityDependsOn activityDependsOn = fetchByPrimaryKey(primaryKey);

			if (activityDependsOn != null) {
				map.put(primaryKey, activityDependsOn);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
					ActivityDependsOnImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ActivityDependsOn)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ACTIVITYDEPENDSON_WHERE_PKS_IN);

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

			for (ActivityDependsOn activityDependsOn : (List<ActivityDependsOn>)q.list()) {
				map.put(activityDependsOn.getPrimaryKeyObj(), activityDependsOn);

				cacheResult(activityDependsOn);

				uncachedPrimaryKeys.remove(activityDependsOn.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ActivityDependsOnModelImpl.ENTITY_CACHE_ENABLED,
					ActivityDependsOnImpl.class, primaryKey, nullModel);
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
	 * Returns all the activity depends ons.
	 *
	 * @return the activity depends ons
	 */
	@Override
	public List<ActivityDependsOn> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity depends ons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity depends ons
	 * @param end the upper bound of the range of activity depends ons (not inclusive)
	 * @return the range of activity depends ons
	 */
	@Override
	public List<ActivityDependsOn> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity depends ons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity depends ons
	 * @param end the upper bound of the range of activity depends ons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of activity depends ons
	 */
	@Override
	public List<ActivityDependsOn> findAll(int start, int end,
		OrderByComparator<ActivityDependsOn> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity depends ons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityDependsOnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity depends ons
	 * @param end the upper bound of the range of activity depends ons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of activity depends ons
	 */
	@Override
	public List<ActivityDependsOn> findAll(int start, int end,
		OrderByComparator<ActivityDependsOn> orderByComparator,
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

		List<ActivityDependsOn> list = null;

		if (retrieveFromCache) {
			list = (List<ActivityDependsOn>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ACTIVITYDEPENDSON);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ACTIVITYDEPENDSON;

				if (pagination) {
					sql = sql.concat(ActivityDependsOnModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ActivityDependsOn>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ActivityDependsOn>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the activity depends ons from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ActivityDependsOn activityDependsOn : findAll()) {
			remove(activityDependsOn);
		}
	}

	/**
	 * Returns the number of activity depends ons.
	 *
	 * @return the number of activity depends ons
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ACTIVITYDEPENDSON);

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
		return ActivityDependsOnModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the activity depends on persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ActivityDependsOnImpl.class.getName());
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
	private static final String _SQL_SELECT_ACTIVITYDEPENDSON = "SELECT activityDependsOn FROM ActivityDependsOn activityDependsOn";
	private static final String _SQL_SELECT_ACTIVITYDEPENDSON_WHERE_PKS_IN = "SELECT activityDependsOn FROM ActivityDependsOn activityDependsOn WHERE activityDependsOnId IN (";
	private static final String _SQL_SELECT_ACTIVITYDEPENDSON_WHERE = "SELECT activityDependsOn FROM ActivityDependsOn activityDependsOn WHERE ";
	private static final String _SQL_COUNT_ACTIVITYDEPENDSON = "SELECT COUNT(activityDependsOn) FROM ActivityDependsOn activityDependsOn";
	private static final String _SQL_COUNT_ACTIVITYDEPENDSON_WHERE = "SELECT COUNT(activityDependsOn) FROM ActivityDependsOn activityDependsOn WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "activityDependsOn.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ActivityDependsOn exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ActivityDependsOn exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ActivityDependsOnPersistenceImpl.class);
}
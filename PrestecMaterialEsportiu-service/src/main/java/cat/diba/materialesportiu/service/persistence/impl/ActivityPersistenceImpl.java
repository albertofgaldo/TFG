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

import cat.diba.materialesportiu.exception.NoSuchActivityException;
import cat.diba.materialesportiu.model.Activity;
import cat.diba.materialesportiu.model.impl.ActivityImpl;
import cat.diba.materialesportiu.model.impl.ActivityModelImpl;
import cat.diba.materialesportiu.service.persistence.ActivityPersistence;

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
 * The persistence implementation for the activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityPersistence
 * @see cat.diba.materialesportiu.service.persistence.ActivityUtil
 * @generated
 */
@ProviderType
public class ActivityPersistenceImpl extends BasePersistenceImpl<Activity>
	implements ActivityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ActivityUtil} to access the activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ActivityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityModelImpl.FINDER_CACHE_ENABLED, ActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityModelImpl.FINDER_CACHE_ENABLED, ActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ACTIVITYID = new FinderPath(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityModelImpl.FINDER_CACHE_ENABLED, ActivityImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByActivityId",
			new String[] { Long.class.getName() },
			ActivityModelImpl.ACTIVITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYID = new FinderPath(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActivityId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the activity where activityId = &#63; or throws a {@link NoSuchActivityException} if it could not be found.
	 *
	 * @param activityId the activity ID
	 * @return the matching activity
	 * @throws NoSuchActivityException if a matching activity could not be found
	 */
	@Override
	public Activity findByActivityId(long activityId)
		throws NoSuchActivityException {
		Activity activity = fetchByActivityId(activityId);

		if (activity == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("activityId=");
			msg.append(activityId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchActivityException(msg.toString());
		}

		return activity;
	}

	/**
	 * Returns the activity where activityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param activityId the activity ID
	 * @return the matching activity, or <code>null</code> if a matching activity could not be found
	 */
	@Override
	public Activity fetchByActivityId(long activityId) {
		return fetchByActivityId(activityId, true);
	}

	/**
	 * Returns the activity where activityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param activityId the activity ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching activity, or <code>null</code> if a matching activity could not be found
	 */
	@Override
	public Activity fetchByActivityId(long activityId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { activityId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_ACTIVITYID,
					finderArgs, this);
		}

		if (result instanceof Activity) {
			Activity activity = (Activity)result;

			if ((activityId != activity.getActivityId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(activityId);

				List<Activity> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_ACTIVITYID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ActivityPersistenceImpl.fetchByActivityId(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Activity activity = list.get(0);

					result = activity;

					cacheResult(activity);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYID,
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
			return (Activity)result;
		}
	}

	/**
	 * Removes the activity where activityId = &#63; from the database.
	 *
	 * @param activityId the activity ID
	 * @return the activity that was removed
	 */
	@Override
	public Activity removeByActivityId(long activityId)
		throws NoSuchActivityException {
		Activity activity = findByActivityId(activityId);

		return remove(activity);
	}

	/**
	 * Returns the number of activities where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @return the number of matching activities
	 */
	@Override
	public int countByActivityId(long activityId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVITYID;

		Object[] finderArgs = new Object[] { activityId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACTIVITY_WHERE);

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

	private static final String _FINDER_COLUMN_ACTIVITYID_ACTIVITYID_2 = "activity.activityId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AVAILABLESTOCK =
		new FinderPath(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityModelImpl.FINDER_CACHE_ENABLED, ActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAvailableStock",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_AVAILABLESTOCK =
		new FinderPath(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByAvailableStock",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the activities where availableStock &gt; &#63;.
	 *
	 * @param availableStock the available stock
	 * @return the matching activities
	 */
	@Override
	public List<Activity> findByAvailableStock(int availableStock) {
		return findByAvailableStock(availableStock, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activities where availableStock &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param availableStock the available stock
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @return the range of matching activities
	 */
	@Override
	public List<Activity> findByAvailableStock(int availableStock, int start,
		int end) {
		return findByAvailableStock(availableStock, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activities where availableStock &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param availableStock the available stock
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activities
	 */
	@Override
	public List<Activity> findByAvailableStock(int availableStock, int start,
		int end, OrderByComparator<Activity> orderByComparator) {
		return findByAvailableStock(availableStock, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activities where availableStock &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param availableStock the available stock
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching activities
	 */
	@Override
	public List<Activity> findByAvailableStock(int availableStock, int start,
		int end, OrderByComparator<Activity> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AVAILABLESTOCK;
		finderArgs = new Object[] { availableStock, start, end, orderByComparator };

		List<Activity> list = null;

		if (retrieveFromCache) {
			list = (List<Activity>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Activity activity : list) {
					if ((availableStock >= activity.getAvailableStock())) {
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

			query.append(_SQL_SELECT_ACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_AVAILABLESTOCK_AVAILABLESTOCK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ActivityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(availableStock);

				if (!pagination) {
					list = (List<Activity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Activity>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first activity in the ordered set where availableStock &gt; &#63;.
	 *
	 * @param availableStock the available stock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity
	 * @throws NoSuchActivityException if a matching activity could not be found
	 */
	@Override
	public Activity findByAvailableStock_First(int availableStock,
		OrderByComparator<Activity> orderByComparator)
		throws NoSuchActivityException {
		Activity activity = fetchByAvailableStock_First(availableStock,
				orderByComparator);

		if (activity != null) {
			return activity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("availableStock=");
		msg.append(availableStock);

		msg.append("}");

		throw new NoSuchActivityException(msg.toString());
	}

	/**
	 * Returns the first activity in the ordered set where availableStock &gt; &#63;.
	 *
	 * @param availableStock the available stock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity, or <code>null</code> if a matching activity could not be found
	 */
	@Override
	public Activity fetchByAvailableStock_First(int availableStock,
		OrderByComparator<Activity> orderByComparator) {
		List<Activity> list = findByAvailableStock(availableStock, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity in the ordered set where availableStock &gt; &#63;.
	 *
	 * @param availableStock the available stock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity
	 * @throws NoSuchActivityException if a matching activity could not be found
	 */
	@Override
	public Activity findByAvailableStock_Last(int availableStock,
		OrderByComparator<Activity> orderByComparator)
		throws NoSuchActivityException {
		Activity activity = fetchByAvailableStock_Last(availableStock,
				orderByComparator);

		if (activity != null) {
			return activity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("availableStock=");
		msg.append(availableStock);

		msg.append("}");

		throw new NoSuchActivityException(msg.toString());
	}

	/**
	 * Returns the last activity in the ordered set where availableStock &gt; &#63;.
	 *
	 * @param availableStock the available stock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity, or <code>null</code> if a matching activity could not be found
	 */
	@Override
	public Activity fetchByAvailableStock_Last(int availableStock,
		OrderByComparator<Activity> orderByComparator) {
		int count = countByAvailableStock(availableStock);

		if (count == 0) {
			return null;
		}

		List<Activity> list = findByAvailableStock(availableStock, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activities before and after the current activity in the ordered set where availableStock &gt; &#63;.
	 *
	 * @param activityId the primary key of the current activity
	 * @param availableStock the available stock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity
	 * @throws NoSuchActivityException if a activity with the primary key could not be found
	 */
	@Override
	public Activity[] findByAvailableStock_PrevAndNext(long activityId,
		int availableStock, OrderByComparator<Activity> orderByComparator)
		throws NoSuchActivityException {
		Activity activity = findByPrimaryKey(activityId);

		Session session = null;

		try {
			session = openSession();

			Activity[] array = new ActivityImpl[3];

			array[0] = getByAvailableStock_PrevAndNext(session, activity,
					availableStock, orderByComparator, true);

			array[1] = activity;

			array[2] = getByAvailableStock_PrevAndNext(session, activity,
					availableStock, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Activity getByAvailableStock_PrevAndNext(Session session,
		Activity activity, int availableStock,
		OrderByComparator<Activity> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACTIVITY_WHERE);

		query.append(_FINDER_COLUMN_AVAILABLESTOCK_AVAILABLESTOCK_2);

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
			query.append(ActivityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(availableStock);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(activity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Activity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activities where availableStock &gt; &#63; from the database.
	 *
	 * @param availableStock the available stock
	 */
	@Override
	public void removeByAvailableStock(int availableStock) {
		for (Activity activity : findByAvailableStock(availableStock,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(activity);
		}
	}

	/**
	 * Returns the number of activities where availableStock &gt; &#63;.
	 *
	 * @param availableStock the available stock
	 * @return the number of matching activities
	 */
	@Override
	public int countByAvailableStock(int availableStock) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_AVAILABLESTOCK;

		Object[] finderArgs = new Object[] { availableStock };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_AVAILABLESTOCK_AVAILABLESTOCK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(availableStock);

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

	private static final String _FINDER_COLUMN_AVAILABLESTOCK_AVAILABLESTOCK_2 = "activity.availableStock > ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityModelImpl.FINDER_CACHE_ENABLED, ActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityModelImpl.FINDER_CACHE_ENABLED, ActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			ActivityModelImpl.COMPANYID_COLUMN_BITMASK |
			ActivityModelImpl.GROUPID_COLUMN_BITMASK |
			ActivityModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the activities where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching activities
	 */
	@Override
	public List<Activity> findByCompanyGroup(long companyId, long groupId) {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activities where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @return the range of matching activities
	 */
	@Override
	public List<Activity> findByCompanyGroup(long companyId, long groupId,
		int start, int end) {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activities where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activities
	 */
	@Override
	public List<Activity> findByCompanyGroup(long companyId, long groupId,
		int start, int end, OrderByComparator<Activity> orderByComparator) {
		return findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activities where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching activities
	 */
	@Override
	public List<Activity> findByCompanyGroup(long companyId, long groupId,
		int start, int end, OrderByComparator<Activity> orderByComparator,
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

		List<Activity> list = null;

		if (retrieveFromCache) {
			list = (List<Activity>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Activity activity : list) {
					if ((companyId != activity.getCompanyId()) ||
							(groupId != activity.getGroupId())) {
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

			query.append(_SQL_SELECT_ACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ActivityModelImpl.ORDER_BY_JPQL);
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
					list = (List<Activity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Activity>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first activity in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity
	 * @throws NoSuchActivityException if a matching activity could not be found
	 */
	@Override
	public Activity findByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator<Activity> orderByComparator)
		throws NoSuchActivityException {
		Activity activity = fetchByCompanyGroup_First(companyId, groupId,
				orderByComparator);

		if (activity != null) {
			return activity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchActivityException(msg.toString());
	}

	/**
	 * Returns the first activity in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity, or <code>null</code> if a matching activity could not be found
	 */
	@Override
	public Activity fetchByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator<Activity> orderByComparator) {
		List<Activity> list = findByCompanyGroup(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity
	 * @throws NoSuchActivityException if a matching activity could not be found
	 */
	@Override
	public Activity findByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator<Activity> orderByComparator)
		throws NoSuchActivityException {
		Activity activity = fetchByCompanyGroup_Last(companyId, groupId,
				orderByComparator);

		if (activity != null) {
			return activity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchActivityException(msg.toString());
	}

	/**
	 * Returns the last activity in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity, or <code>null</code> if a matching activity could not be found
	 */
	@Override
	public Activity fetchByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator<Activity> orderByComparator) {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Activity> list = findByCompanyGroup(companyId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activities before and after the current activity in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param activityId the primary key of the current activity
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity
	 * @throws NoSuchActivityException if a activity with the primary key could not be found
	 */
	@Override
	public Activity[] findByCompanyGroup_PrevAndNext(long activityId,
		long companyId, long groupId,
		OrderByComparator<Activity> orderByComparator)
		throws NoSuchActivityException {
		Activity activity = findByPrimaryKey(activityId);

		Session session = null;

		try {
			session = openSession();

			Activity[] array = new ActivityImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, activity,
					companyId, groupId, orderByComparator, true);

			array[1] = activity;

			array[2] = getByCompanyGroup_PrevAndNext(session, activity,
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

	protected Activity getByCompanyGroup_PrevAndNext(Session session,
		Activity activity, long companyId, long groupId,
		OrderByComparator<Activity> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ACTIVITY_WHERE);

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
			query.append(ActivityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(activity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Activity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activities where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId) {
		for (Activity activity : findByCompanyGroup(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(activity);
		}
	}

	/**
	 * Returns the number of activities where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching activities
	 */
	@Override
	public int countByCompanyGroup(long companyId, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYGROUP;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ACTIVITY_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "activity.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "activity.groupId = ?";

	public ActivityPersistenceImpl() {
		setModelClass(Activity.class);
	}

	/**
	 * Caches the activity in the entity cache if it is enabled.
	 *
	 * @param activity the activity
	 */
	@Override
	public void cacheResult(Activity activity) {
		entityCache.putResult(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityImpl.class, activity.getPrimaryKey(), activity);

		finderCache.putResult(FINDER_PATH_FETCH_BY_ACTIVITYID,
			new Object[] { activity.getActivityId() }, activity);

		activity.resetOriginalValues();
	}

	/**
	 * Caches the activities in the entity cache if it is enabled.
	 *
	 * @param activities the activities
	 */
	@Override
	public void cacheResult(List<Activity> activities) {
		for (Activity activity : activities) {
			if (entityCache.getResult(ActivityModelImpl.ENTITY_CACHE_ENABLED,
						ActivityImpl.class, activity.getPrimaryKey()) == null) {
				cacheResult(activity);
			}
			else {
				activity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all activities.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ActivityImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the activity.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Activity activity) {
		entityCache.removeResult(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityImpl.class, activity.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ActivityModelImpl)activity, true);
	}

	@Override
	public void clearCache(List<Activity> activities) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Activity activity : activities) {
			entityCache.removeResult(ActivityModelImpl.ENTITY_CACHE_ENABLED,
				ActivityImpl.class, activity.getPrimaryKey());

			clearUniqueFindersCache((ActivityModelImpl)activity, true);
		}
	}

	protected void cacheUniqueFindersCache(ActivityModelImpl activityModelImpl) {
		Object[] args = new Object[] { activityModelImpl.getActivityId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_ACTIVITYID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_ACTIVITYID, args,
			activityModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ActivityModelImpl activityModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { activityModelImpl.getActivityId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYID, args);
		}

		if ((activityModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ACTIVITYID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					activityModelImpl.getOriginalActivityId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYID, args);
		}
	}

	/**
	 * Creates a new activity with the primary key. Does not add the activity to the database.
	 *
	 * @param activityId the primary key for the new activity
	 * @return the new activity
	 */
	@Override
	public Activity create(long activityId) {
		Activity activity = new ActivityImpl();

		activity.setNew(true);
		activity.setPrimaryKey(activityId);

		activity.setCompanyId(companyProvider.getCompanyId());

		return activity;
	}

	/**
	 * Removes the activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity that was removed
	 * @throws NoSuchActivityException if a activity with the primary key could not be found
	 */
	@Override
	public Activity remove(long activityId) throws NoSuchActivityException {
		return remove((Serializable)activityId);
	}

	/**
	 * Removes the activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the activity
	 * @return the activity that was removed
	 * @throws NoSuchActivityException if a activity with the primary key could not be found
	 */
	@Override
	public Activity remove(Serializable primaryKey)
		throws NoSuchActivityException {
		Session session = null;

		try {
			session = openSession();

			Activity activity = (Activity)session.get(ActivityImpl.class,
					primaryKey);

			if (activity == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(activity);
		}
		catch (NoSuchActivityException nsee) {
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
	protected Activity removeImpl(Activity activity) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(activity)) {
				activity = (Activity)session.get(ActivityImpl.class,
						activity.getPrimaryKeyObj());
			}

			if (activity != null) {
				session.delete(activity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (activity != null) {
			clearCache(activity);
		}

		return activity;
	}

	@Override
	public Activity updateImpl(Activity activity) {
		boolean isNew = activity.isNew();

		if (!(activity instanceof ActivityModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(activity.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(activity);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in activity proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Activity implementation " +
				activity.getClass());
		}

		ActivityModelImpl activityModelImpl = (ActivityModelImpl)activity;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (activity.getCreateDate() == null)) {
			if (serviceContext == null) {
				activity.setCreateDate(now);
			}
			else {
				activity.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!activityModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				activity.setModifiedDate(now);
			}
			else {
				activity.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (activity.isNew()) {
				session.save(activity);

				activity.setNew(false);
			}
			else {
				activity = (Activity)session.merge(activity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ActivityModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					activityModelImpl.getCompanyId(),
					activityModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((activityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						activityModelImpl.getOriginalCompanyId(),
						activityModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						activityModelImpl.getCompanyId(),
						activityModelImpl.getGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}
		}

		entityCache.putResult(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityImpl.class, activity.getPrimaryKey(), activity, false);

		clearUniqueFindersCache(activityModelImpl, false);
		cacheUniqueFindersCache(activityModelImpl);

		activity.resetOriginalValues();

		return activity;
	}

	/**
	 * Returns the activity with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the activity
	 * @return the activity
	 * @throws NoSuchActivityException if a activity with the primary key could not be found
	 */
	@Override
	public Activity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchActivityException {
		Activity activity = fetchByPrimaryKey(primaryKey);

		if (activity == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return activity;
	}

	/**
	 * Returns the activity with the primary key or throws a {@link NoSuchActivityException} if it could not be found.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity
	 * @throws NoSuchActivityException if a activity with the primary key could not be found
	 */
	@Override
	public Activity findByPrimaryKey(long activityId)
		throws NoSuchActivityException {
		return findByPrimaryKey((Serializable)activityId);
	}

	/**
	 * Returns the activity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the activity
	 * @return the activity, or <code>null</code> if a activity with the primary key could not be found
	 */
	@Override
	public Activity fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ActivityModelImpl.ENTITY_CACHE_ENABLED,
				ActivityImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Activity activity = (Activity)serializable;

		if (activity == null) {
			Session session = null;

			try {
				session = openSession();

				activity = (Activity)session.get(ActivityImpl.class, primaryKey);

				if (activity != null) {
					cacheResult(activity);
				}
				else {
					entityCache.putResult(ActivityModelImpl.ENTITY_CACHE_ENABLED,
						ActivityImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ActivityModelImpl.ENTITY_CACHE_ENABLED,
					ActivityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return activity;
	}

	/**
	 * Returns the activity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity, or <code>null</code> if a activity with the primary key could not be found
	 */
	@Override
	public Activity fetchByPrimaryKey(long activityId) {
		return fetchByPrimaryKey((Serializable)activityId);
	}

	@Override
	public Map<Serializable, Activity> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Activity> map = new HashMap<Serializable, Activity>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Activity activity = fetchByPrimaryKey(primaryKey);

			if (activity != null) {
				map.put(primaryKey, activity);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ActivityModelImpl.ENTITY_CACHE_ENABLED,
					ActivityImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Activity)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ACTIVITY_WHERE_PKS_IN);

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

			for (Activity activity : (List<Activity>)q.list()) {
				map.put(activity.getPrimaryKeyObj(), activity);

				cacheResult(activity);

				uncachedPrimaryKeys.remove(activity.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ActivityModelImpl.ENTITY_CACHE_ENABLED,
					ActivityImpl.class, primaryKey, nullModel);
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
	 * Returns all the activities.
	 *
	 * @return the activities
	 */
	@Override
	public List<Activity> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @return the range of activities
	 */
	@Override
	public List<Activity> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of activities
	 */
	@Override
	public List<Activity> findAll(int start, int end,
		OrderByComparator<Activity> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of activities
	 */
	@Override
	public List<Activity> findAll(int start, int end,
		OrderByComparator<Activity> orderByComparator, boolean retrieveFromCache) {
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

		List<Activity> list = null;

		if (retrieveFromCache) {
			list = (List<Activity>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ACTIVITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ACTIVITY;

				if (pagination) {
					sql = sql.concat(ActivityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Activity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Activity>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the activities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Activity activity : findAll()) {
			remove(activity);
		}
	}

	/**
	 * Returns the number of activities.
	 *
	 * @return the number of activities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ACTIVITY);

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
		return ActivityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the activity persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ActivityImpl.class.getName());
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
	private static final String _SQL_SELECT_ACTIVITY = "SELECT activity FROM Activity activity";
	private static final String _SQL_SELECT_ACTIVITY_WHERE_PKS_IN = "SELECT activity FROM Activity activity WHERE activityId IN (";
	private static final String _SQL_SELECT_ACTIVITY_WHERE = "SELECT activity FROM Activity activity WHERE ";
	private static final String _SQL_COUNT_ACTIVITY = "SELECT COUNT(activity) FROM Activity activity";
	private static final String _SQL_COUNT_ACTIVITY_WHERE = "SELECT COUNT(activity) FROM Activity activity WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "activity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Activity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Activity exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ActivityPersistenceImpl.class);
}
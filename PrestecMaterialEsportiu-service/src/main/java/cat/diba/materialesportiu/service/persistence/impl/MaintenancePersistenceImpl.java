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

import cat.diba.materialesportiu.exception.NoSuchMaintenanceException;
import cat.diba.materialesportiu.model.Maintenance;
import cat.diba.materialesportiu.model.impl.MaintenanceImpl;
import cat.diba.materialesportiu.model.impl.MaintenanceModelImpl;
import cat.diba.materialesportiu.service.persistence.MaintenancePersistence;

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
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the maintenance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MaintenancePersistence
 * @see cat.diba.materialesportiu.service.persistence.MaintenanceUtil
 * @generated
 */
@ProviderType
public class MaintenancePersistenceImpl extends BasePersistenceImpl<Maintenance>
	implements MaintenancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MaintenanceUtil} to access the maintenance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MaintenanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceModelImpl.FINDER_CACHE_ENABLED, MaintenanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceModelImpl.FINDER_CACHE_ENABLED, MaintenanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYID =
		new FinderPath(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceModelImpl.FINDER_CACHE_ENABLED, MaintenanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActivityId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID =
		new FinderPath(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceModelImpl.FINDER_CACHE_ENABLED, MaintenanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActivityId",
			new String[] { Long.class.getName() },
			MaintenanceModelImpl.ACTIVITYID_COLUMN_BITMASK |
			MaintenanceModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYID = new FinderPath(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActivityId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the maintenances where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @return the matching maintenances
	 */
	@Override
	public List<Maintenance> findByActivityId(long activityId) {
		return findByActivityId(activityId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the maintenances where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of maintenances
	 * @param end the upper bound of the range of maintenances (not inclusive)
	 * @return the range of matching maintenances
	 */
	@Override
	public List<Maintenance> findByActivityId(long activityId, int start,
		int end) {
		return findByActivityId(activityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the maintenances where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of maintenances
	 * @param end the upper bound of the range of maintenances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching maintenances
	 */
	@Override
	public List<Maintenance> findByActivityId(long activityId, int start,
		int end, OrderByComparator<Maintenance> orderByComparator) {
		return findByActivityId(activityId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the maintenances where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of maintenances
	 * @param end the upper bound of the range of maintenances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching maintenances
	 */
	@Override
	public List<Maintenance> findByActivityId(long activityId, int start,
		int end, OrderByComparator<Maintenance> orderByComparator,
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

		List<Maintenance> list = null;

		if (retrieveFromCache) {
			list = (List<Maintenance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Maintenance maintenance : list) {
					if ((activityId != maintenance.getActivityId())) {
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

			query.append(_SQL_SELECT_MAINTENANCE_WHERE);

			query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MaintenanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(activityId);

				if (!pagination) {
					list = (List<Maintenance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Maintenance>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first maintenance in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching maintenance
	 * @throws NoSuchMaintenanceException if a matching maintenance could not be found
	 */
	@Override
	public Maintenance findByActivityId_First(long activityId,
		OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException {
		Maintenance maintenance = fetchByActivityId_First(activityId,
				orderByComparator);

		if (maintenance != null) {
			return maintenance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("activityId=");
		msg.append(activityId);

		msg.append("}");

		throw new NoSuchMaintenanceException(msg.toString());
	}

	/**
	 * Returns the first maintenance in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching maintenance, or <code>null</code> if a matching maintenance could not be found
	 */
	@Override
	public Maintenance fetchByActivityId_First(long activityId,
		OrderByComparator<Maintenance> orderByComparator) {
		List<Maintenance> list = findByActivityId(activityId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last maintenance in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching maintenance
	 * @throws NoSuchMaintenanceException if a matching maintenance could not be found
	 */
	@Override
	public Maintenance findByActivityId_Last(long activityId,
		OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException {
		Maintenance maintenance = fetchByActivityId_Last(activityId,
				orderByComparator);

		if (maintenance != null) {
			return maintenance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("activityId=");
		msg.append(activityId);

		msg.append("}");

		throw new NoSuchMaintenanceException(msg.toString());
	}

	/**
	 * Returns the last maintenance in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching maintenance, or <code>null</code> if a matching maintenance could not be found
	 */
	@Override
	public Maintenance fetchByActivityId_Last(long activityId,
		OrderByComparator<Maintenance> orderByComparator) {
		int count = countByActivityId(activityId);

		if (count == 0) {
			return null;
		}

		List<Maintenance> list = findByActivityId(activityId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the maintenances before and after the current maintenance in the ordered set where activityId = &#63;.
	 *
	 * @param maintenanceId the primary key of the current maintenance
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next maintenance
	 * @throws NoSuchMaintenanceException if a maintenance with the primary key could not be found
	 */
	@Override
	public Maintenance[] findByActivityId_PrevAndNext(long maintenanceId,
		long activityId, OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException {
		Maintenance maintenance = findByPrimaryKey(maintenanceId);

		Session session = null;

		try {
			session = openSession();

			Maintenance[] array = new MaintenanceImpl[3];

			array[0] = getByActivityId_PrevAndNext(session, maintenance,
					activityId, orderByComparator, true);

			array[1] = maintenance;

			array[2] = getByActivityId_PrevAndNext(session, maintenance,
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

	protected Maintenance getByActivityId_PrevAndNext(Session session,
		Maintenance maintenance, long activityId,
		OrderByComparator<Maintenance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MAINTENANCE_WHERE);

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
			query.append(MaintenanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(activityId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(maintenance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Maintenance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the maintenances where activityId = &#63; from the database.
	 *
	 * @param activityId the activity ID
	 */
	@Override
	public void removeByActivityId(long activityId) {
		for (Maintenance maintenance : findByActivityId(activityId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(maintenance);
		}
	}

	/**
	 * Returns the number of maintenances where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @return the number of matching maintenances
	 */
	@Override
	public int countByActivityId(long activityId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVITYID;

		Object[] finderArgs = new Object[] { activityId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MAINTENANCE_WHERE);

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

	private static final String _FINDER_COLUMN_ACTIVITYID_ACTIVITYID_2 = "maintenance.activityId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ACTIVITYID_LABEL = new FinderPath(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceModelImpl.FINDER_CACHE_ENABLED, MaintenanceImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByActivityId_Label",
			new String[] { Long.class.getName(), String.class.getName() },
			MaintenanceModelImpl.ACTIVITYID_COLUMN_BITMASK |
			MaintenanceModelImpl.LABEL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYID_LABEL = new FinderPath(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByActivityId_Label",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the maintenance where activityId = &#63; and label = &#63; or throws a {@link NoSuchMaintenanceException} if it could not be found.
	 *
	 * @param activityId the activity ID
	 * @param label the label
	 * @return the matching maintenance
	 * @throws NoSuchMaintenanceException if a matching maintenance could not be found
	 */
	@Override
	public Maintenance findByActivityId_Label(long activityId, String label)
		throws NoSuchMaintenanceException {
		Maintenance maintenance = fetchByActivityId_Label(activityId, label);

		if (maintenance == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("activityId=");
			msg.append(activityId);

			msg.append(", label=");
			msg.append(label);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchMaintenanceException(msg.toString());
		}

		return maintenance;
	}

	/**
	 * Returns the maintenance where activityId = &#63; and label = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param activityId the activity ID
	 * @param label the label
	 * @return the matching maintenance, or <code>null</code> if a matching maintenance could not be found
	 */
	@Override
	public Maintenance fetchByActivityId_Label(long activityId, String label) {
		return fetchByActivityId_Label(activityId, label, true);
	}

	/**
	 * Returns the maintenance where activityId = &#63; and label = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param activityId the activity ID
	 * @param label the label
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching maintenance, or <code>null</code> if a matching maintenance could not be found
	 */
	@Override
	public Maintenance fetchByActivityId_Label(long activityId, String label,
		boolean retrieveFromCache) {
		label = Objects.toString(label, "");

		Object[] finderArgs = new Object[] { activityId, label };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_ACTIVITYID_LABEL,
					finderArgs, this);
		}

		if (result instanceof Maintenance) {
			Maintenance maintenance = (Maintenance)result;

			if ((activityId != maintenance.getActivityId()) ||
					!Objects.equals(label, maintenance.getLabel())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_MAINTENANCE_WHERE);

			query.append(_FINDER_COLUMN_ACTIVITYID_LABEL_ACTIVITYID_2);

			boolean bindLabel = false;

			if (label.isEmpty()) {
				query.append(_FINDER_COLUMN_ACTIVITYID_LABEL_LABEL_3);
			}
			else {
				bindLabel = true;

				query.append(_FINDER_COLUMN_ACTIVITYID_LABEL_LABEL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(activityId);

				if (bindLabel) {
					qPos.add(label);
				}

				List<Maintenance> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_ACTIVITYID_LABEL,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"MaintenancePersistenceImpl.fetchByActivityId_Label(long, String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Maintenance maintenance = list.get(0);

					result = maintenance;

					cacheResult(maintenance);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYID_LABEL,
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
			return (Maintenance)result;
		}
	}

	/**
	 * Removes the maintenance where activityId = &#63; and label = &#63; from the database.
	 *
	 * @param activityId the activity ID
	 * @param label the label
	 * @return the maintenance that was removed
	 */
	@Override
	public Maintenance removeByActivityId_Label(long activityId, String label)
		throws NoSuchMaintenanceException {
		Maintenance maintenance = findByActivityId_Label(activityId, label);

		return remove(maintenance);
	}

	/**
	 * Returns the number of maintenances where activityId = &#63; and label = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param label the label
	 * @return the number of matching maintenances
	 */
	@Override
	public int countByActivityId_Label(long activityId, String label) {
		label = Objects.toString(label, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVITYID_LABEL;

		Object[] finderArgs = new Object[] { activityId, label };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MAINTENANCE_WHERE);

			query.append(_FINDER_COLUMN_ACTIVITYID_LABEL_ACTIVITYID_2);

			boolean bindLabel = false;

			if (label.isEmpty()) {
				query.append(_FINDER_COLUMN_ACTIVITYID_LABEL_LABEL_3);
			}
			else {
				bindLabel = true;

				query.append(_FINDER_COLUMN_ACTIVITYID_LABEL_LABEL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(activityId);

				if (bindLabel) {
					qPos.add(label);
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

	private static final String _FINDER_COLUMN_ACTIVITYID_LABEL_ACTIVITYID_2 = "maintenance.activityId = ? AND ";
	private static final String _FINDER_COLUMN_ACTIVITYID_LABEL_LABEL_1 = "maintenance.label IS NULL";
	private static final String _FINDER_COLUMN_ACTIVITYID_LABEL_LABEL_2 = "maintenance.label = ?";
	private static final String _FINDER_COLUMN_ACTIVITYID_LABEL_LABEL_3 = "(maintenance.label IS NULL OR maintenance.label = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceModelImpl.FINDER_CACHE_ENABLED, MaintenanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceModelImpl.FINDER_CACHE_ENABLED, MaintenanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			MaintenanceModelImpl.COMPANYID_COLUMN_BITMASK |
			MaintenanceModelImpl.GROUPID_COLUMN_BITMASK |
			MaintenanceModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the maintenances where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching maintenances
	 */
	@Override
	public List<Maintenance> findByCompanyGroup(long companyId, long groupId) {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the maintenances where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of maintenances
	 * @param end the upper bound of the range of maintenances (not inclusive)
	 * @return the range of matching maintenances
	 */
	@Override
	public List<Maintenance> findByCompanyGroup(long companyId, long groupId,
		int start, int end) {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the maintenances where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of maintenances
	 * @param end the upper bound of the range of maintenances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching maintenances
	 */
	@Override
	public List<Maintenance> findByCompanyGroup(long companyId, long groupId,
		int start, int end, OrderByComparator<Maintenance> orderByComparator) {
		return findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the maintenances where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of maintenances
	 * @param end the upper bound of the range of maintenances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching maintenances
	 */
	@Override
	public List<Maintenance> findByCompanyGroup(long companyId, long groupId,
		int start, int end, OrderByComparator<Maintenance> orderByComparator,
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

		List<Maintenance> list = null;

		if (retrieveFromCache) {
			list = (List<Maintenance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Maintenance maintenance : list) {
					if ((companyId != maintenance.getCompanyId()) ||
							(groupId != maintenance.getGroupId())) {
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

			query.append(_SQL_SELECT_MAINTENANCE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MaintenanceModelImpl.ORDER_BY_JPQL);
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
					list = (List<Maintenance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Maintenance>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first maintenance in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching maintenance
	 * @throws NoSuchMaintenanceException if a matching maintenance could not be found
	 */
	@Override
	public Maintenance findByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException {
		Maintenance maintenance = fetchByCompanyGroup_First(companyId, groupId,
				orderByComparator);

		if (maintenance != null) {
			return maintenance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchMaintenanceException(msg.toString());
	}

	/**
	 * Returns the first maintenance in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching maintenance, or <code>null</code> if a matching maintenance could not be found
	 */
	@Override
	public Maintenance fetchByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator<Maintenance> orderByComparator) {
		List<Maintenance> list = findByCompanyGroup(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last maintenance in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching maintenance
	 * @throws NoSuchMaintenanceException if a matching maintenance could not be found
	 */
	@Override
	public Maintenance findByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException {
		Maintenance maintenance = fetchByCompanyGroup_Last(companyId, groupId,
				orderByComparator);

		if (maintenance != null) {
			return maintenance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchMaintenanceException(msg.toString());
	}

	/**
	 * Returns the last maintenance in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching maintenance, or <code>null</code> if a matching maintenance could not be found
	 */
	@Override
	public Maintenance fetchByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator<Maintenance> orderByComparator) {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Maintenance> list = findByCompanyGroup(companyId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the maintenances before and after the current maintenance in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param maintenanceId the primary key of the current maintenance
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next maintenance
	 * @throws NoSuchMaintenanceException if a maintenance with the primary key could not be found
	 */
	@Override
	public Maintenance[] findByCompanyGroup_PrevAndNext(long maintenanceId,
		long companyId, long groupId,
		OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException {
		Maintenance maintenance = findByPrimaryKey(maintenanceId);

		Session session = null;

		try {
			session = openSession();

			Maintenance[] array = new MaintenanceImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, maintenance,
					companyId, groupId, orderByComparator, true);

			array[1] = maintenance;

			array[2] = getByCompanyGroup_PrevAndNext(session, maintenance,
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

	protected Maintenance getByCompanyGroup_PrevAndNext(Session session,
		Maintenance maintenance, long companyId, long groupId,
		OrderByComparator<Maintenance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_MAINTENANCE_WHERE);

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
			query.append(MaintenanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(maintenance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Maintenance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the maintenances where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId) {
		for (Maintenance maintenance : findByCompanyGroup(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(maintenance);
		}
	}

	/**
	 * Returns the number of maintenances where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching maintenances
	 */
	@Override
	public int countByCompanyGroup(long companyId, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYGROUP;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MAINTENANCE_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "maintenance.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "maintenance.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOANIDISDONE =
		new FinderPath(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceModelImpl.FINDER_CACHE_ENABLED, MaintenanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLoanIdIsDone",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANIDISDONE =
		new FinderPath(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceModelImpl.FINDER_CACHE_ENABLED, MaintenanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLoanIdIsDone",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			MaintenanceModelImpl.LOANID_COLUMN_BITMASK |
			MaintenanceModelImpl.ISDONE_COLUMN_BITMASK |
			MaintenanceModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOANIDISDONE = new FinderPath(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLoanIdIsDone",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the maintenances where loanId = &#63; and isDone = &#63;.
	 *
	 * @param loanId the loan ID
	 * @param isDone the is done
	 * @return the matching maintenances
	 */
	@Override
	public List<Maintenance> findByLoanIdIsDone(long loanId, Boolean isDone) {
		return findByLoanIdIsDone(loanId, isDone, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the maintenances where loanId = &#63; and isDone = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loanId the loan ID
	 * @param isDone the is done
	 * @param start the lower bound of the range of maintenances
	 * @param end the upper bound of the range of maintenances (not inclusive)
	 * @return the range of matching maintenances
	 */
	@Override
	public List<Maintenance> findByLoanIdIsDone(long loanId, Boolean isDone,
		int start, int end) {
		return findByLoanIdIsDone(loanId, isDone, start, end, null);
	}

	/**
	 * Returns an ordered range of all the maintenances where loanId = &#63; and isDone = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loanId the loan ID
	 * @param isDone the is done
	 * @param start the lower bound of the range of maintenances
	 * @param end the upper bound of the range of maintenances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching maintenances
	 */
	@Override
	public List<Maintenance> findByLoanIdIsDone(long loanId, Boolean isDone,
		int start, int end, OrderByComparator<Maintenance> orderByComparator) {
		return findByLoanIdIsDone(loanId, isDone, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the maintenances where loanId = &#63; and isDone = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loanId the loan ID
	 * @param isDone the is done
	 * @param start the lower bound of the range of maintenances
	 * @param end the upper bound of the range of maintenances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching maintenances
	 */
	@Override
	public List<Maintenance> findByLoanIdIsDone(long loanId, Boolean isDone,
		int start, int end, OrderByComparator<Maintenance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANIDISDONE;
			finderArgs = new Object[] { loanId, isDone };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOANIDISDONE;
			finderArgs = new Object[] {
					loanId, isDone,
					
					start, end, orderByComparator
				};
		}

		List<Maintenance> list = null;

		if (retrieveFromCache) {
			list = (List<Maintenance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Maintenance maintenance : list) {
					if ((loanId != maintenance.getLoanId()) ||
							!Objects.equals(isDone, maintenance.getIsDone())) {
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

			query.append(_SQL_SELECT_MAINTENANCE_WHERE);

			query.append(_FINDER_COLUMN_LOANIDISDONE_LOANID_2);

			query.append(_FINDER_COLUMN_LOANIDISDONE_ISDONE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MaintenanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loanId);

				qPos.add(isDone.booleanValue());

				if (!pagination) {
					list = (List<Maintenance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Maintenance>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first maintenance in the ordered set where loanId = &#63; and isDone = &#63;.
	 *
	 * @param loanId the loan ID
	 * @param isDone the is done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching maintenance
	 * @throws NoSuchMaintenanceException if a matching maintenance could not be found
	 */
	@Override
	public Maintenance findByLoanIdIsDone_First(long loanId, Boolean isDone,
		OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException {
		Maintenance maintenance = fetchByLoanIdIsDone_First(loanId, isDone,
				orderByComparator);

		if (maintenance != null) {
			return maintenance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("loanId=");
		msg.append(loanId);

		msg.append(", isDone=");
		msg.append(isDone);

		msg.append("}");

		throw new NoSuchMaintenanceException(msg.toString());
	}

	/**
	 * Returns the first maintenance in the ordered set where loanId = &#63; and isDone = &#63;.
	 *
	 * @param loanId the loan ID
	 * @param isDone the is done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching maintenance, or <code>null</code> if a matching maintenance could not be found
	 */
	@Override
	public Maintenance fetchByLoanIdIsDone_First(long loanId, Boolean isDone,
		OrderByComparator<Maintenance> orderByComparator) {
		List<Maintenance> list = findByLoanIdIsDone(loanId, isDone, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last maintenance in the ordered set where loanId = &#63; and isDone = &#63;.
	 *
	 * @param loanId the loan ID
	 * @param isDone the is done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching maintenance
	 * @throws NoSuchMaintenanceException if a matching maintenance could not be found
	 */
	@Override
	public Maintenance findByLoanIdIsDone_Last(long loanId, Boolean isDone,
		OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException {
		Maintenance maintenance = fetchByLoanIdIsDone_Last(loanId, isDone,
				orderByComparator);

		if (maintenance != null) {
			return maintenance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("loanId=");
		msg.append(loanId);

		msg.append(", isDone=");
		msg.append(isDone);

		msg.append("}");

		throw new NoSuchMaintenanceException(msg.toString());
	}

	/**
	 * Returns the last maintenance in the ordered set where loanId = &#63; and isDone = &#63;.
	 *
	 * @param loanId the loan ID
	 * @param isDone the is done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching maintenance, or <code>null</code> if a matching maintenance could not be found
	 */
	@Override
	public Maintenance fetchByLoanIdIsDone_Last(long loanId, Boolean isDone,
		OrderByComparator<Maintenance> orderByComparator) {
		int count = countByLoanIdIsDone(loanId, isDone);

		if (count == 0) {
			return null;
		}

		List<Maintenance> list = findByLoanIdIsDone(loanId, isDone, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the maintenances before and after the current maintenance in the ordered set where loanId = &#63; and isDone = &#63;.
	 *
	 * @param maintenanceId the primary key of the current maintenance
	 * @param loanId the loan ID
	 * @param isDone the is done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next maintenance
	 * @throws NoSuchMaintenanceException if a maintenance with the primary key could not be found
	 */
	@Override
	public Maintenance[] findByLoanIdIsDone_PrevAndNext(long maintenanceId,
		long loanId, Boolean isDone,
		OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException {
		Maintenance maintenance = findByPrimaryKey(maintenanceId);

		Session session = null;

		try {
			session = openSession();

			Maintenance[] array = new MaintenanceImpl[3];

			array[0] = getByLoanIdIsDone_PrevAndNext(session, maintenance,
					loanId, isDone, orderByComparator, true);

			array[1] = maintenance;

			array[2] = getByLoanIdIsDone_PrevAndNext(session, maintenance,
					loanId, isDone, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Maintenance getByLoanIdIsDone_PrevAndNext(Session session,
		Maintenance maintenance, long loanId, Boolean isDone,
		OrderByComparator<Maintenance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_MAINTENANCE_WHERE);

		query.append(_FINDER_COLUMN_LOANIDISDONE_LOANID_2);

		query.append(_FINDER_COLUMN_LOANIDISDONE_ISDONE_2);

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
			query.append(MaintenanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(loanId);

		qPos.add(isDone.booleanValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(maintenance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Maintenance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the maintenances where loanId = &#63; and isDone = &#63; from the database.
	 *
	 * @param loanId the loan ID
	 * @param isDone the is done
	 */
	@Override
	public void removeByLoanIdIsDone(long loanId, Boolean isDone) {
		for (Maintenance maintenance : findByLoanIdIsDone(loanId, isDone,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(maintenance);
		}
	}

	/**
	 * Returns the number of maintenances where loanId = &#63; and isDone = &#63;.
	 *
	 * @param loanId the loan ID
	 * @param isDone the is done
	 * @return the number of matching maintenances
	 */
	@Override
	public int countByLoanIdIsDone(long loanId, Boolean isDone) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LOANIDISDONE;

		Object[] finderArgs = new Object[] { loanId, isDone };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MAINTENANCE_WHERE);

			query.append(_FINDER_COLUMN_LOANIDISDONE_LOANID_2);

			query.append(_FINDER_COLUMN_LOANIDISDONE_ISDONE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loanId);

				qPos.add(isDone.booleanValue());

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

	private static final String _FINDER_COLUMN_LOANIDISDONE_LOANID_2 = "maintenance.loanId = ? AND ";
	private static final String _FINDER_COLUMN_LOANIDISDONE_ISDONE_2 = "maintenance.isDone = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOANIDACTIVITYIDISDONE =
		new FinderPath(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceModelImpl.FINDER_CACHE_ENABLED, MaintenanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLoanIdActivityIdIsDone",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANIDACTIVITYIDISDONE =
		new FinderPath(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceModelImpl.FINDER_CACHE_ENABLED, MaintenanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLoanIdActivityIdIsDone",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			MaintenanceModelImpl.LOANID_COLUMN_BITMASK |
			MaintenanceModelImpl.ACTIVITYID_COLUMN_BITMASK |
			MaintenanceModelImpl.ISDONE_COLUMN_BITMASK |
			MaintenanceModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOANIDACTIVITYIDISDONE = new FinderPath(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLoanIdActivityIdIsDone",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the maintenances where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	 *
	 * @param loanId the loan ID
	 * @param activityId the activity ID
	 * @param isDone the is done
	 * @return the matching maintenances
	 */
	@Override
	public List<Maintenance> findByLoanIdActivityIdIsDone(long loanId,
		long activityId, Boolean isDone) {
		return findByLoanIdActivityIdIsDone(loanId, activityId, isDone,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the maintenances where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loanId the loan ID
	 * @param activityId the activity ID
	 * @param isDone the is done
	 * @param start the lower bound of the range of maintenances
	 * @param end the upper bound of the range of maintenances (not inclusive)
	 * @return the range of matching maintenances
	 */
	@Override
	public List<Maintenance> findByLoanIdActivityIdIsDone(long loanId,
		long activityId, Boolean isDone, int start, int end) {
		return findByLoanIdActivityIdIsDone(loanId, activityId, isDone, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the maintenances where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loanId the loan ID
	 * @param activityId the activity ID
	 * @param isDone the is done
	 * @param start the lower bound of the range of maintenances
	 * @param end the upper bound of the range of maintenances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching maintenances
	 */
	@Override
	public List<Maintenance> findByLoanIdActivityIdIsDone(long loanId,
		long activityId, Boolean isDone, int start, int end,
		OrderByComparator<Maintenance> orderByComparator) {
		return findByLoanIdActivityIdIsDone(loanId, activityId, isDone, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the maintenances where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loanId the loan ID
	 * @param activityId the activity ID
	 * @param isDone the is done
	 * @param start the lower bound of the range of maintenances
	 * @param end the upper bound of the range of maintenances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching maintenances
	 */
	@Override
	public List<Maintenance> findByLoanIdActivityIdIsDone(long loanId,
		long activityId, Boolean isDone, int start, int end,
		OrderByComparator<Maintenance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANIDACTIVITYIDISDONE;
			finderArgs = new Object[] { loanId, activityId, isDone };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOANIDACTIVITYIDISDONE;
			finderArgs = new Object[] {
					loanId, activityId, isDone,
					
					start, end, orderByComparator
				};
		}

		List<Maintenance> list = null;

		if (retrieveFromCache) {
			list = (List<Maintenance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Maintenance maintenance : list) {
					if ((loanId != maintenance.getLoanId()) ||
							(activityId != maintenance.getActivityId()) ||
							!Objects.equals(isDone, maintenance.getIsDone())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_MAINTENANCE_WHERE);

			query.append(_FINDER_COLUMN_LOANIDACTIVITYIDISDONE_LOANID_2);

			query.append(_FINDER_COLUMN_LOANIDACTIVITYIDISDONE_ACTIVITYID_2);

			query.append(_FINDER_COLUMN_LOANIDACTIVITYIDISDONE_ISDONE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MaintenanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loanId);

				qPos.add(activityId);

				qPos.add(isDone.booleanValue());

				if (!pagination) {
					list = (List<Maintenance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Maintenance>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first maintenance in the ordered set where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	 *
	 * @param loanId the loan ID
	 * @param activityId the activity ID
	 * @param isDone the is done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching maintenance
	 * @throws NoSuchMaintenanceException if a matching maintenance could not be found
	 */
	@Override
	public Maintenance findByLoanIdActivityIdIsDone_First(long loanId,
		long activityId, Boolean isDone,
		OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException {
		Maintenance maintenance = fetchByLoanIdActivityIdIsDone_First(loanId,
				activityId, isDone, orderByComparator);

		if (maintenance != null) {
			return maintenance;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("loanId=");
		msg.append(loanId);

		msg.append(", activityId=");
		msg.append(activityId);

		msg.append(", isDone=");
		msg.append(isDone);

		msg.append("}");

		throw new NoSuchMaintenanceException(msg.toString());
	}

	/**
	 * Returns the first maintenance in the ordered set where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	 *
	 * @param loanId the loan ID
	 * @param activityId the activity ID
	 * @param isDone the is done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching maintenance, or <code>null</code> if a matching maintenance could not be found
	 */
	@Override
	public Maintenance fetchByLoanIdActivityIdIsDone_First(long loanId,
		long activityId, Boolean isDone,
		OrderByComparator<Maintenance> orderByComparator) {
		List<Maintenance> list = findByLoanIdActivityIdIsDone(loanId,
				activityId, isDone, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last maintenance in the ordered set where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	 *
	 * @param loanId the loan ID
	 * @param activityId the activity ID
	 * @param isDone the is done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching maintenance
	 * @throws NoSuchMaintenanceException if a matching maintenance could not be found
	 */
	@Override
	public Maintenance findByLoanIdActivityIdIsDone_Last(long loanId,
		long activityId, Boolean isDone,
		OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException {
		Maintenance maintenance = fetchByLoanIdActivityIdIsDone_Last(loanId,
				activityId, isDone, orderByComparator);

		if (maintenance != null) {
			return maintenance;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("loanId=");
		msg.append(loanId);

		msg.append(", activityId=");
		msg.append(activityId);

		msg.append(", isDone=");
		msg.append(isDone);

		msg.append("}");

		throw new NoSuchMaintenanceException(msg.toString());
	}

	/**
	 * Returns the last maintenance in the ordered set where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	 *
	 * @param loanId the loan ID
	 * @param activityId the activity ID
	 * @param isDone the is done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching maintenance, or <code>null</code> if a matching maintenance could not be found
	 */
	@Override
	public Maintenance fetchByLoanIdActivityIdIsDone_Last(long loanId,
		long activityId, Boolean isDone,
		OrderByComparator<Maintenance> orderByComparator) {
		int count = countByLoanIdActivityIdIsDone(loanId, activityId, isDone);

		if (count == 0) {
			return null;
		}

		List<Maintenance> list = findByLoanIdActivityIdIsDone(loanId,
				activityId, isDone, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the maintenances before and after the current maintenance in the ordered set where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	 *
	 * @param maintenanceId the primary key of the current maintenance
	 * @param loanId the loan ID
	 * @param activityId the activity ID
	 * @param isDone the is done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next maintenance
	 * @throws NoSuchMaintenanceException if a maintenance with the primary key could not be found
	 */
	@Override
	public Maintenance[] findByLoanIdActivityIdIsDone_PrevAndNext(
		long maintenanceId, long loanId, long activityId, Boolean isDone,
		OrderByComparator<Maintenance> orderByComparator)
		throws NoSuchMaintenanceException {
		Maintenance maintenance = findByPrimaryKey(maintenanceId);

		Session session = null;

		try {
			session = openSession();

			Maintenance[] array = new MaintenanceImpl[3];

			array[0] = getByLoanIdActivityIdIsDone_PrevAndNext(session,
					maintenance, loanId, activityId, isDone, orderByComparator,
					true);

			array[1] = maintenance;

			array[2] = getByLoanIdActivityIdIsDone_PrevAndNext(session,
					maintenance, loanId, activityId, isDone, orderByComparator,
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

	protected Maintenance getByLoanIdActivityIdIsDone_PrevAndNext(
		Session session, Maintenance maintenance, long loanId, long activityId,
		Boolean isDone, OrderByComparator<Maintenance> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_MAINTENANCE_WHERE);

		query.append(_FINDER_COLUMN_LOANIDACTIVITYIDISDONE_LOANID_2);

		query.append(_FINDER_COLUMN_LOANIDACTIVITYIDISDONE_ACTIVITYID_2);

		query.append(_FINDER_COLUMN_LOANIDACTIVITYIDISDONE_ISDONE_2);

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
			query.append(MaintenanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(loanId);

		qPos.add(activityId);

		qPos.add(isDone.booleanValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(maintenance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Maintenance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the maintenances where loanId = &#63; and activityId = &#63; and isDone = &#63; from the database.
	 *
	 * @param loanId the loan ID
	 * @param activityId the activity ID
	 * @param isDone the is done
	 */
	@Override
	public void removeByLoanIdActivityIdIsDone(long loanId, long activityId,
		Boolean isDone) {
		for (Maintenance maintenance : findByLoanIdActivityIdIsDone(loanId,
				activityId, isDone, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(maintenance);
		}
	}

	/**
	 * Returns the number of maintenances where loanId = &#63; and activityId = &#63; and isDone = &#63;.
	 *
	 * @param loanId the loan ID
	 * @param activityId the activity ID
	 * @param isDone the is done
	 * @return the number of matching maintenances
	 */
	@Override
	public int countByLoanIdActivityIdIsDone(long loanId, long activityId,
		Boolean isDone) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LOANIDACTIVITYIDISDONE;

		Object[] finderArgs = new Object[] { loanId, activityId, isDone };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_MAINTENANCE_WHERE);

			query.append(_FINDER_COLUMN_LOANIDACTIVITYIDISDONE_LOANID_2);

			query.append(_FINDER_COLUMN_LOANIDACTIVITYIDISDONE_ACTIVITYID_2);

			query.append(_FINDER_COLUMN_LOANIDACTIVITYIDISDONE_ISDONE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loanId);

				qPos.add(activityId);

				qPos.add(isDone.booleanValue());

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

	private static final String _FINDER_COLUMN_LOANIDACTIVITYIDISDONE_LOANID_2 = "maintenance.loanId = ? AND ";
	private static final String _FINDER_COLUMN_LOANIDACTIVITYIDISDONE_ACTIVITYID_2 =
		"maintenance.activityId = ? AND ";
	private static final String _FINDER_COLUMN_LOANIDACTIVITYIDISDONE_ISDONE_2 = "maintenance.isDone = ?";

	public MaintenancePersistenceImpl() {
		setModelClass(Maintenance.class);
	}

	/**
	 * Caches the maintenance in the entity cache if it is enabled.
	 *
	 * @param maintenance the maintenance
	 */
	@Override
	public void cacheResult(Maintenance maintenance) {
		entityCache.putResult(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceImpl.class, maintenance.getPrimaryKey(), maintenance);

		finderCache.putResult(FINDER_PATH_FETCH_BY_ACTIVITYID_LABEL,
			new Object[] { maintenance.getActivityId(), maintenance.getLabel() },
			maintenance);

		maintenance.resetOriginalValues();
	}

	/**
	 * Caches the maintenances in the entity cache if it is enabled.
	 *
	 * @param maintenances the maintenances
	 */
	@Override
	public void cacheResult(List<Maintenance> maintenances) {
		for (Maintenance maintenance : maintenances) {
			if (entityCache.getResult(
						MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
						MaintenanceImpl.class, maintenance.getPrimaryKey()) == null) {
				cacheResult(maintenance);
			}
			else {
				maintenance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all maintenances.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MaintenanceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the maintenance.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Maintenance maintenance) {
		entityCache.removeResult(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceImpl.class, maintenance.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((MaintenanceModelImpl)maintenance, true);
	}

	@Override
	public void clearCache(List<Maintenance> maintenances) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Maintenance maintenance : maintenances) {
			entityCache.removeResult(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
				MaintenanceImpl.class, maintenance.getPrimaryKey());

			clearUniqueFindersCache((MaintenanceModelImpl)maintenance, true);
		}
	}

	protected void cacheUniqueFindersCache(
		MaintenanceModelImpl maintenanceModelImpl) {
		Object[] args = new Object[] {
				maintenanceModelImpl.getActivityId(),
				maintenanceModelImpl.getLabel()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_ACTIVITYID_LABEL, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_ACTIVITYID_LABEL, args,
			maintenanceModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		MaintenanceModelImpl maintenanceModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					maintenanceModelImpl.getActivityId(),
					maintenanceModelImpl.getLabel()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYID_LABEL, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYID_LABEL, args);
		}

		if ((maintenanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ACTIVITYID_LABEL.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					maintenanceModelImpl.getOriginalActivityId(),
					maintenanceModelImpl.getOriginalLabel()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYID_LABEL, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYID_LABEL, args);
		}
	}

	/**
	 * Creates a new maintenance with the primary key. Does not add the maintenance to the database.
	 *
	 * @param maintenanceId the primary key for the new maintenance
	 * @return the new maintenance
	 */
	@Override
	public Maintenance create(long maintenanceId) {
		Maintenance maintenance = new MaintenanceImpl();

		maintenance.setNew(true);
		maintenance.setPrimaryKey(maintenanceId);

		maintenance.setCompanyId(companyProvider.getCompanyId());

		return maintenance;
	}

	/**
	 * Removes the maintenance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param maintenanceId the primary key of the maintenance
	 * @return the maintenance that was removed
	 * @throws NoSuchMaintenanceException if a maintenance with the primary key could not be found
	 */
	@Override
	public Maintenance remove(long maintenanceId)
		throws NoSuchMaintenanceException {
		return remove((Serializable)maintenanceId);
	}

	/**
	 * Removes the maintenance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the maintenance
	 * @return the maintenance that was removed
	 * @throws NoSuchMaintenanceException if a maintenance with the primary key could not be found
	 */
	@Override
	public Maintenance remove(Serializable primaryKey)
		throws NoSuchMaintenanceException {
		Session session = null;

		try {
			session = openSession();

			Maintenance maintenance = (Maintenance)session.get(MaintenanceImpl.class,
					primaryKey);

			if (maintenance == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMaintenanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(maintenance);
		}
		catch (NoSuchMaintenanceException nsee) {
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
	protected Maintenance removeImpl(Maintenance maintenance) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(maintenance)) {
				maintenance = (Maintenance)session.get(MaintenanceImpl.class,
						maintenance.getPrimaryKeyObj());
			}

			if (maintenance != null) {
				session.delete(maintenance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (maintenance != null) {
			clearCache(maintenance);
		}

		return maintenance;
	}

	@Override
	public Maintenance updateImpl(Maintenance maintenance) {
		boolean isNew = maintenance.isNew();

		if (!(maintenance instanceof MaintenanceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(maintenance.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(maintenance);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in maintenance proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Maintenance implementation " +
				maintenance.getClass());
		}

		MaintenanceModelImpl maintenanceModelImpl = (MaintenanceModelImpl)maintenance;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (maintenance.getCreateDate() == null)) {
			if (serviceContext == null) {
				maintenance.setCreateDate(now);
			}
			else {
				maintenance.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!maintenanceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				maintenance.setModifiedDate(now);
			}
			else {
				maintenance.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (maintenance.isNew()) {
				session.save(maintenance);

				maintenance.setNew(false);
			}
			else {
				maintenance = (Maintenance)session.merge(maintenance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!MaintenanceModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { maintenanceModelImpl.getActivityId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID,
				args);

			args = new Object[] {
					maintenanceModelImpl.getCompanyId(),
					maintenanceModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
				args);

			args = new Object[] {
					maintenanceModelImpl.getLoanId(),
					maintenanceModelImpl.getIsDone()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LOANIDISDONE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANIDISDONE,
				args);

			args = new Object[] {
					maintenanceModelImpl.getLoanId(),
					maintenanceModelImpl.getActivityId(),
					maintenanceModelImpl.getIsDone()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LOANIDACTIVITYIDISDONE,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANIDACTIVITYIDISDONE,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((maintenanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						maintenanceModelImpl.getOriginalActivityId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID,
					args);

				args = new Object[] { maintenanceModelImpl.getActivityId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID,
					args);
			}

			if ((maintenanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						maintenanceModelImpl.getOriginalCompanyId(),
						maintenanceModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						maintenanceModelImpl.getCompanyId(),
						maintenanceModelImpl.getGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}

			if ((maintenanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANIDISDONE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						maintenanceModelImpl.getOriginalLoanId(),
						maintenanceModelImpl.getOriginalIsDone()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LOANIDISDONE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANIDISDONE,
					args);

				args = new Object[] {
						maintenanceModelImpl.getLoanId(),
						maintenanceModelImpl.getIsDone()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LOANIDISDONE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANIDISDONE,
					args);
			}

			if ((maintenanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANIDACTIVITYIDISDONE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						maintenanceModelImpl.getOriginalLoanId(),
						maintenanceModelImpl.getOriginalActivityId(),
						maintenanceModelImpl.getOriginalIsDone()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LOANIDACTIVITYIDISDONE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANIDACTIVITYIDISDONE,
					args);

				args = new Object[] {
						maintenanceModelImpl.getLoanId(),
						maintenanceModelImpl.getActivityId(),
						maintenanceModelImpl.getIsDone()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LOANIDACTIVITYIDISDONE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOANIDACTIVITYIDISDONE,
					args);
			}
		}

		entityCache.putResult(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
			MaintenanceImpl.class, maintenance.getPrimaryKey(), maintenance,
			false);

		clearUniqueFindersCache(maintenanceModelImpl, false);
		cacheUniqueFindersCache(maintenanceModelImpl);

		maintenance.resetOriginalValues();

		return maintenance;
	}

	/**
	 * Returns the maintenance with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the maintenance
	 * @return the maintenance
	 * @throws NoSuchMaintenanceException if a maintenance with the primary key could not be found
	 */
	@Override
	public Maintenance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMaintenanceException {
		Maintenance maintenance = fetchByPrimaryKey(primaryKey);

		if (maintenance == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMaintenanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return maintenance;
	}

	/**
	 * Returns the maintenance with the primary key or throws a {@link NoSuchMaintenanceException} if it could not be found.
	 *
	 * @param maintenanceId the primary key of the maintenance
	 * @return the maintenance
	 * @throws NoSuchMaintenanceException if a maintenance with the primary key could not be found
	 */
	@Override
	public Maintenance findByPrimaryKey(long maintenanceId)
		throws NoSuchMaintenanceException {
		return findByPrimaryKey((Serializable)maintenanceId);
	}

	/**
	 * Returns the maintenance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the maintenance
	 * @return the maintenance, or <code>null</code> if a maintenance with the primary key could not be found
	 */
	@Override
	public Maintenance fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
				MaintenanceImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Maintenance maintenance = (Maintenance)serializable;

		if (maintenance == null) {
			Session session = null;

			try {
				session = openSession();

				maintenance = (Maintenance)session.get(MaintenanceImpl.class,
						primaryKey);

				if (maintenance != null) {
					cacheResult(maintenance);
				}
				else {
					entityCache.putResult(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
						MaintenanceImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
					MaintenanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return maintenance;
	}

	/**
	 * Returns the maintenance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param maintenanceId the primary key of the maintenance
	 * @return the maintenance, or <code>null</code> if a maintenance with the primary key could not be found
	 */
	@Override
	public Maintenance fetchByPrimaryKey(long maintenanceId) {
		return fetchByPrimaryKey((Serializable)maintenanceId);
	}

	@Override
	public Map<Serializable, Maintenance> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Maintenance> map = new HashMap<Serializable, Maintenance>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Maintenance maintenance = fetchByPrimaryKey(primaryKey);

			if (maintenance != null) {
				map.put(primaryKey, maintenance);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
					MaintenanceImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Maintenance)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_MAINTENANCE_WHERE_PKS_IN);

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

			for (Maintenance maintenance : (List<Maintenance>)q.list()) {
				map.put(maintenance.getPrimaryKeyObj(), maintenance);

				cacheResult(maintenance);

				uncachedPrimaryKeys.remove(maintenance.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(MaintenanceModelImpl.ENTITY_CACHE_ENABLED,
					MaintenanceImpl.class, primaryKey, nullModel);
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
	 * Returns all the maintenances.
	 *
	 * @return the maintenances
	 */
	@Override
	public List<Maintenance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the maintenances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of maintenances
	 * @param end the upper bound of the range of maintenances (not inclusive)
	 * @return the range of maintenances
	 */
	@Override
	public List<Maintenance> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the maintenances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of maintenances
	 * @param end the upper bound of the range of maintenances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of maintenances
	 */
	@Override
	public List<Maintenance> findAll(int start, int end,
		OrderByComparator<Maintenance> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the maintenances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of maintenances
	 * @param end the upper bound of the range of maintenances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of maintenances
	 */
	@Override
	public List<Maintenance> findAll(int start, int end,
		OrderByComparator<Maintenance> orderByComparator,
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

		List<Maintenance> list = null;

		if (retrieveFromCache) {
			list = (List<Maintenance>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MAINTENANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MAINTENANCE;

				if (pagination) {
					sql = sql.concat(MaintenanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Maintenance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Maintenance>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the maintenances from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Maintenance maintenance : findAll()) {
			remove(maintenance);
		}
	}

	/**
	 * Returns the number of maintenances.
	 *
	 * @return the number of maintenances
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MAINTENANCE);

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
		return MaintenanceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the maintenance persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(MaintenanceImpl.class.getName());
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
	private static final String _SQL_SELECT_MAINTENANCE = "SELECT maintenance FROM Maintenance maintenance";
	private static final String _SQL_SELECT_MAINTENANCE_WHERE_PKS_IN = "SELECT maintenance FROM Maintenance maintenance WHERE maintenanceId IN (";
	private static final String _SQL_SELECT_MAINTENANCE_WHERE = "SELECT maintenance FROM Maintenance maintenance WHERE ";
	private static final String _SQL_COUNT_MAINTENANCE = "SELECT COUNT(maintenance) FROM Maintenance maintenance";
	private static final String _SQL_COUNT_MAINTENANCE_WHERE = "SELECT COUNT(maintenance) FROM Maintenance maintenance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "maintenance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Maintenance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Maintenance exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(MaintenancePersistenceImpl.class);
}
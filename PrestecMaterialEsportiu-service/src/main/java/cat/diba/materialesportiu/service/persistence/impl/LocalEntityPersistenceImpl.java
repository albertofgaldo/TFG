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

import cat.diba.materialesportiu.exception.NoSuchLocalEntityException;
import cat.diba.materialesportiu.model.LocalEntity;
import cat.diba.materialesportiu.model.impl.LocalEntityImpl;
import cat.diba.materialesportiu.model.impl.LocalEntityModelImpl;
import cat.diba.materialesportiu.service.persistence.LocalEntityPersistence;

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
 * The persistence implementation for the local entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalEntityPersistence
 * @see cat.diba.materialesportiu.service.persistence.LocalEntityUtil
 * @generated
 */
@ProviderType
public class LocalEntityPersistenceImpl extends BasePersistenceImpl<LocalEntity>
	implements LocalEntityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LocalEntityUtil} to access the local entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LocalEntityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
			LocalEntityModelImpl.FINDER_CACHE_ENABLED, LocalEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
			LocalEntityModelImpl.FINDER_CACHE_ENABLED, LocalEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
			LocalEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
			LocalEntityModelImpl.FINDER_CACHE_ENABLED, LocalEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
			LocalEntityModelImpl.FINDER_CACHE_ENABLED, LocalEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			LocalEntityModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
			LocalEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the local entities where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching local entities
	 */
	@Override
	public List<LocalEntity> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the local entities where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of local entities
	 * @param end the upper bound of the range of local entities (not inclusive)
	 * @return the range of matching local entities
	 */
	@Override
	public List<LocalEntity> findByName(String name, int start, int end) {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the local entities where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of local entities
	 * @param end the upper bound of the range of local entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching local entities
	 */
	@Override
	public List<LocalEntity> findByName(String name, int start, int end,
		OrderByComparator<LocalEntity> orderByComparator) {
		return findByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the local entities where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of local entities
	 * @param end the upper bound of the range of local entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching local entities
	 */
	@Override
	public List<LocalEntity> findByName(String name, int start, int end,
		OrderByComparator<LocalEntity> orderByComparator,
		boolean retrieveFromCache) {
		name = Objects.toString(name, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<LocalEntity> list = null;

		if (retrieveFromCache) {
			list = (List<LocalEntity>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LocalEntity localEntity : list) {
					if (!name.equals(localEntity.getName())) {
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

			query.append(_SQL_SELECT_LOCALENTITY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LocalEntityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<LocalEntity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LocalEntity>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first local entity in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching local entity
	 * @throws NoSuchLocalEntityException if a matching local entity could not be found
	 */
	@Override
	public LocalEntity findByName_First(String name,
		OrderByComparator<LocalEntity> orderByComparator)
		throws NoSuchLocalEntityException {
		LocalEntity localEntity = fetchByName_First(name, orderByComparator);

		if (localEntity != null) {
			return localEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append("}");

		throw new NoSuchLocalEntityException(msg.toString());
	}

	/**
	 * Returns the first local entity in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching local entity, or <code>null</code> if a matching local entity could not be found
	 */
	@Override
	public LocalEntity fetchByName_First(String name,
		OrderByComparator<LocalEntity> orderByComparator) {
		List<LocalEntity> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last local entity in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching local entity
	 * @throws NoSuchLocalEntityException if a matching local entity could not be found
	 */
	@Override
	public LocalEntity findByName_Last(String name,
		OrderByComparator<LocalEntity> orderByComparator)
		throws NoSuchLocalEntityException {
		LocalEntity localEntity = fetchByName_Last(name, orderByComparator);

		if (localEntity != null) {
			return localEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append("}");

		throw new NoSuchLocalEntityException(msg.toString());
	}

	/**
	 * Returns the last local entity in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching local entity, or <code>null</code> if a matching local entity could not be found
	 */
	@Override
	public LocalEntity fetchByName_Last(String name,
		OrderByComparator<LocalEntity> orderByComparator) {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<LocalEntity> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the local entities before and after the current local entity in the ordered set where name = &#63;.
	 *
	 * @param localEntityId the primary key of the current local entity
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next local entity
	 * @throws NoSuchLocalEntityException if a local entity with the primary key could not be found
	 */
	@Override
	public LocalEntity[] findByName_PrevAndNext(long localEntityId,
		String name, OrderByComparator<LocalEntity> orderByComparator)
		throws NoSuchLocalEntityException {
		name = Objects.toString(name, "");

		LocalEntity localEntity = findByPrimaryKey(localEntityId);

		Session session = null;

		try {
			session = openSession();

			LocalEntity[] array = new LocalEntityImpl[3];

			array[0] = getByName_PrevAndNext(session, localEntity, name,
					orderByComparator, true);

			array[1] = localEntity;

			array[2] = getByName_PrevAndNext(session, localEntity, name,
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

	protected LocalEntity getByName_PrevAndNext(Session session,
		LocalEntity localEntity, String name,
		OrderByComparator<LocalEntity> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOCALENTITY_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
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
			query.append(LocalEntityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(localEntity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LocalEntity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the local entities where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (LocalEntity localEntity : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(localEntity);
		}
	}

	/**
	 * Returns the number of local entities where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching local entities
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOCALENTITY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "localEntity.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "localEntity.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(localEntity.name IS NULL OR localEntity.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
			LocalEntityModelImpl.FINDER_CACHE_ENABLED, LocalEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
			LocalEntityModelImpl.FINDER_CACHE_ENABLED, LocalEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			LocalEntityModelImpl.COMPANYID_COLUMN_BITMASK |
			LocalEntityModelImpl.GROUPID_COLUMN_BITMASK |
			LocalEntityModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
			LocalEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the local entities where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching local entities
	 */
	@Override
	public List<LocalEntity> findByCompanyGroup(long companyId, long groupId) {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the local entities where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of local entities
	 * @param end the upper bound of the range of local entities (not inclusive)
	 * @return the range of matching local entities
	 */
	@Override
	public List<LocalEntity> findByCompanyGroup(long companyId, long groupId,
		int start, int end) {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the local entities where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of local entities
	 * @param end the upper bound of the range of local entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching local entities
	 */
	@Override
	public List<LocalEntity> findByCompanyGroup(long companyId, long groupId,
		int start, int end, OrderByComparator<LocalEntity> orderByComparator) {
		return findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the local entities where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of local entities
	 * @param end the upper bound of the range of local entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching local entities
	 */
	@Override
	public List<LocalEntity> findByCompanyGroup(long companyId, long groupId,
		int start, int end, OrderByComparator<LocalEntity> orderByComparator,
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

		List<LocalEntity> list = null;

		if (retrieveFromCache) {
			list = (List<LocalEntity>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LocalEntity localEntity : list) {
					if ((companyId != localEntity.getCompanyId()) ||
							(groupId != localEntity.getGroupId())) {
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

			query.append(_SQL_SELECT_LOCALENTITY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LocalEntityModelImpl.ORDER_BY_JPQL);
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
					list = (List<LocalEntity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LocalEntity>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first local entity in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching local entity
	 * @throws NoSuchLocalEntityException if a matching local entity could not be found
	 */
	@Override
	public LocalEntity findByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator<LocalEntity> orderByComparator)
		throws NoSuchLocalEntityException {
		LocalEntity localEntity = fetchByCompanyGroup_First(companyId, groupId,
				orderByComparator);

		if (localEntity != null) {
			return localEntity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLocalEntityException(msg.toString());
	}

	/**
	 * Returns the first local entity in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching local entity, or <code>null</code> if a matching local entity could not be found
	 */
	@Override
	public LocalEntity fetchByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator<LocalEntity> orderByComparator) {
		List<LocalEntity> list = findByCompanyGroup(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last local entity in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching local entity
	 * @throws NoSuchLocalEntityException if a matching local entity could not be found
	 */
	@Override
	public LocalEntity findByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator<LocalEntity> orderByComparator)
		throws NoSuchLocalEntityException {
		LocalEntity localEntity = fetchByCompanyGroup_Last(companyId, groupId,
				orderByComparator);

		if (localEntity != null) {
			return localEntity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLocalEntityException(msg.toString());
	}

	/**
	 * Returns the last local entity in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching local entity, or <code>null</code> if a matching local entity could not be found
	 */
	@Override
	public LocalEntity fetchByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator<LocalEntity> orderByComparator) {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<LocalEntity> list = findByCompanyGroup(companyId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the local entities before and after the current local entity in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param localEntityId the primary key of the current local entity
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next local entity
	 * @throws NoSuchLocalEntityException if a local entity with the primary key could not be found
	 */
	@Override
	public LocalEntity[] findByCompanyGroup_PrevAndNext(long localEntityId,
		long companyId, long groupId,
		OrderByComparator<LocalEntity> orderByComparator)
		throws NoSuchLocalEntityException {
		LocalEntity localEntity = findByPrimaryKey(localEntityId);

		Session session = null;

		try {
			session = openSession();

			LocalEntity[] array = new LocalEntityImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, localEntity,
					companyId, groupId, orderByComparator, true);

			array[1] = localEntity;

			array[2] = getByCompanyGroup_PrevAndNext(session, localEntity,
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

	protected LocalEntity getByCompanyGroup_PrevAndNext(Session session,
		LocalEntity localEntity, long companyId, long groupId,
		OrderByComparator<LocalEntity> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LOCALENTITY_WHERE);

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
			query.append(LocalEntityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(localEntity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LocalEntity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the local entities where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId) {
		for (LocalEntity localEntity : findByCompanyGroup(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(localEntity);
		}
	}

	/**
	 * Returns the number of local entities where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching local entities
	 */
	@Override
	public int countByCompanyGroup(long companyId, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYGROUP;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LOCALENTITY_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "localEntity.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "localEntity.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CIF = new FinderPath(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
			LocalEntityModelImpl.FINDER_CACHE_ENABLED, LocalEntityImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCif",
			new String[] { String.class.getName() },
			LocalEntityModelImpl.CIF_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CIF = new FinderPath(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
			LocalEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCif",
			new String[] { String.class.getName() });

	/**
	 * Returns the local entity where cif = &#63; or throws a {@link NoSuchLocalEntityException} if it could not be found.
	 *
	 * @param cif the cif
	 * @return the matching local entity
	 * @throws NoSuchLocalEntityException if a matching local entity could not be found
	 */
	@Override
	public LocalEntity findByCif(String cif) throws NoSuchLocalEntityException {
		LocalEntity localEntity = fetchByCif(cif);

		if (localEntity == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cif=");
			msg.append(cif);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLocalEntityException(msg.toString());
		}

		return localEntity;
	}

	/**
	 * Returns the local entity where cif = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cif the cif
	 * @return the matching local entity, or <code>null</code> if a matching local entity could not be found
	 */
	@Override
	public LocalEntity fetchByCif(String cif) {
		return fetchByCif(cif, true);
	}

	/**
	 * Returns the local entity where cif = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cif the cif
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching local entity, or <code>null</code> if a matching local entity could not be found
	 */
	@Override
	public LocalEntity fetchByCif(String cif, boolean retrieveFromCache) {
		cif = Objects.toString(cif, "");

		Object[] finderArgs = new Object[] { cif };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_CIF,
					finderArgs, this);
		}

		if (result instanceof LocalEntity) {
			LocalEntity localEntity = (LocalEntity)result;

			if (!Objects.equals(cif, localEntity.getCif())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LOCALENTITY_WHERE);

			boolean bindCif = false;

			if (cif.isEmpty()) {
				query.append(_FINDER_COLUMN_CIF_CIF_3);
			}
			else {
				bindCif = true;

				query.append(_FINDER_COLUMN_CIF_CIF_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCif) {
					qPos.add(cif);
				}

				List<LocalEntity> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_CIF, finderArgs,
						list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"LocalEntityPersistenceImpl.fetchByCif(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LocalEntity localEntity = list.get(0);

					result = localEntity;

					cacheResult(localEntity);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_CIF, finderArgs);

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
			return (LocalEntity)result;
		}
	}

	/**
	 * Removes the local entity where cif = &#63; from the database.
	 *
	 * @param cif the cif
	 * @return the local entity that was removed
	 */
	@Override
	public LocalEntity removeByCif(String cif)
		throws NoSuchLocalEntityException {
		LocalEntity localEntity = findByCif(cif);

		return remove(localEntity);
	}

	/**
	 * Returns the number of local entities where cif = &#63;.
	 *
	 * @param cif the cif
	 * @return the number of matching local entities
	 */
	@Override
	public int countByCif(String cif) {
		cif = Objects.toString(cif, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_CIF;

		Object[] finderArgs = new Object[] { cif };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOCALENTITY_WHERE);

			boolean bindCif = false;

			if (cif.isEmpty()) {
				query.append(_FINDER_COLUMN_CIF_CIF_3);
			}
			else {
				bindCif = true;

				query.append(_FINDER_COLUMN_CIF_CIF_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCif) {
					qPos.add(cif);
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

	private static final String _FINDER_COLUMN_CIF_CIF_1 = "localEntity.cif IS NULL";
	private static final String _FINDER_COLUMN_CIF_CIF_2 = "localEntity.cif = ?";
	private static final String _FINDER_COLUMN_CIF_CIF_3 = "(localEntity.cif IS NULL OR localEntity.cif = '')";

	public LocalEntityPersistenceImpl() {
		setModelClass(LocalEntity.class);
	}

	/**
	 * Caches the local entity in the entity cache if it is enabled.
	 *
	 * @param localEntity the local entity
	 */
	@Override
	public void cacheResult(LocalEntity localEntity) {
		entityCache.putResult(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
			LocalEntityImpl.class, localEntity.getPrimaryKey(), localEntity);

		finderCache.putResult(FINDER_PATH_FETCH_BY_CIF,
			new Object[] { localEntity.getCif() }, localEntity);

		localEntity.resetOriginalValues();
	}

	/**
	 * Caches the local entities in the entity cache if it is enabled.
	 *
	 * @param localEntities the local entities
	 */
	@Override
	public void cacheResult(List<LocalEntity> localEntities) {
		for (LocalEntity localEntity : localEntities) {
			if (entityCache.getResult(
						LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
						LocalEntityImpl.class, localEntity.getPrimaryKey()) == null) {
				cacheResult(localEntity);
			}
			else {
				localEntity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all local entities.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LocalEntityImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the local entity.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LocalEntity localEntity) {
		entityCache.removeResult(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
			LocalEntityImpl.class, localEntity.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LocalEntityModelImpl)localEntity, true);
	}

	@Override
	public void clearCache(List<LocalEntity> localEntities) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LocalEntity localEntity : localEntities) {
			entityCache.removeResult(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
				LocalEntityImpl.class, localEntity.getPrimaryKey());

			clearUniqueFindersCache((LocalEntityModelImpl)localEntity, true);
		}
	}

	protected void cacheUniqueFindersCache(
		LocalEntityModelImpl localEntityModelImpl) {
		Object[] args = new Object[] { localEntityModelImpl.getCif() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_CIF, args, Long.valueOf(1),
			false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_CIF, args,
			localEntityModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LocalEntityModelImpl localEntityModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { localEntityModelImpl.getCif() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CIF, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CIF, args);
		}

		if ((localEntityModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CIF.getColumnBitmask()) != 0) {
			Object[] args = new Object[] { localEntityModelImpl.getOriginalCif() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CIF, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CIF, args);
		}
	}

	/**
	 * Creates a new local entity with the primary key. Does not add the local entity to the database.
	 *
	 * @param localEntityId the primary key for the new local entity
	 * @return the new local entity
	 */
	@Override
	public LocalEntity create(long localEntityId) {
		LocalEntity localEntity = new LocalEntityImpl();

		localEntity.setNew(true);
		localEntity.setPrimaryKey(localEntityId);

		localEntity.setCompanyId(companyProvider.getCompanyId());

		return localEntity;
	}

	/**
	 * Removes the local entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param localEntityId the primary key of the local entity
	 * @return the local entity that was removed
	 * @throws NoSuchLocalEntityException if a local entity with the primary key could not be found
	 */
	@Override
	public LocalEntity remove(long localEntityId)
		throws NoSuchLocalEntityException {
		return remove((Serializable)localEntityId);
	}

	/**
	 * Removes the local entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the local entity
	 * @return the local entity that was removed
	 * @throws NoSuchLocalEntityException if a local entity with the primary key could not be found
	 */
	@Override
	public LocalEntity remove(Serializable primaryKey)
		throws NoSuchLocalEntityException {
		Session session = null;

		try {
			session = openSession();

			LocalEntity localEntity = (LocalEntity)session.get(LocalEntityImpl.class,
					primaryKey);

			if (localEntity == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLocalEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(localEntity);
		}
		catch (NoSuchLocalEntityException nsee) {
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
	protected LocalEntity removeImpl(LocalEntity localEntity) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(localEntity)) {
				localEntity = (LocalEntity)session.get(LocalEntityImpl.class,
						localEntity.getPrimaryKeyObj());
			}

			if (localEntity != null) {
				session.delete(localEntity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (localEntity != null) {
			clearCache(localEntity);
		}

		return localEntity;
	}

	@Override
	public LocalEntity updateImpl(LocalEntity localEntity) {
		boolean isNew = localEntity.isNew();

		if (!(localEntity instanceof LocalEntityModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(localEntity.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(localEntity);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in localEntity proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LocalEntity implementation " +
				localEntity.getClass());
		}

		LocalEntityModelImpl localEntityModelImpl = (LocalEntityModelImpl)localEntity;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (localEntity.getCreateDate() == null)) {
			if (serviceContext == null) {
				localEntity.setCreateDate(now);
			}
			else {
				localEntity.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!localEntityModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				localEntity.setModifiedDate(now);
			}
			else {
				localEntity.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (localEntity.isNew()) {
				session.save(localEntity);

				localEntity.setNew(false);
			}
			else {
				localEntity = (LocalEntity)session.merge(localEntity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LocalEntityModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { localEntityModelImpl.getName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
				args);

			args = new Object[] {
					localEntityModelImpl.getCompanyId(),
					localEntityModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((localEntityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						localEntityModelImpl.getOriginalName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { localEntityModelImpl.getName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}

			if ((localEntityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						localEntityModelImpl.getOriginalCompanyId(),
						localEntityModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						localEntityModelImpl.getCompanyId(),
						localEntityModelImpl.getGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}
		}

		entityCache.putResult(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
			LocalEntityImpl.class, localEntity.getPrimaryKey(), localEntity,
			false);

		clearUniqueFindersCache(localEntityModelImpl, false);
		cacheUniqueFindersCache(localEntityModelImpl);

		localEntity.resetOriginalValues();

		return localEntity;
	}

	/**
	 * Returns the local entity with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the local entity
	 * @return the local entity
	 * @throws NoSuchLocalEntityException if a local entity with the primary key could not be found
	 */
	@Override
	public LocalEntity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLocalEntityException {
		LocalEntity localEntity = fetchByPrimaryKey(primaryKey);

		if (localEntity == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLocalEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return localEntity;
	}

	/**
	 * Returns the local entity with the primary key or throws a {@link NoSuchLocalEntityException} if it could not be found.
	 *
	 * @param localEntityId the primary key of the local entity
	 * @return the local entity
	 * @throws NoSuchLocalEntityException if a local entity with the primary key could not be found
	 */
	@Override
	public LocalEntity findByPrimaryKey(long localEntityId)
		throws NoSuchLocalEntityException {
		return findByPrimaryKey((Serializable)localEntityId);
	}

	/**
	 * Returns the local entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the local entity
	 * @return the local entity, or <code>null</code> if a local entity with the primary key could not be found
	 */
	@Override
	public LocalEntity fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
				LocalEntityImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LocalEntity localEntity = (LocalEntity)serializable;

		if (localEntity == null) {
			Session session = null;

			try {
				session = openSession();

				localEntity = (LocalEntity)session.get(LocalEntityImpl.class,
						primaryKey);

				if (localEntity != null) {
					cacheResult(localEntity);
				}
				else {
					entityCache.putResult(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
						LocalEntityImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
					LocalEntityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return localEntity;
	}

	/**
	 * Returns the local entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param localEntityId the primary key of the local entity
	 * @return the local entity, or <code>null</code> if a local entity with the primary key could not be found
	 */
	@Override
	public LocalEntity fetchByPrimaryKey(long localEntityId) {
		return fetchByPrimaryKey((Serializable)localEntityId);
	}

	@Override
	public Map<Serializable, LocalEntity> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LocalEntity> map = new HashMap<Serializable, LocalEntity>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LocalEntity localEntity = fetchByPrimaryKey(primaryKey);

			if (localEntity != null) {
				map.put(primaryKey, localEntity);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
					LocalEntityImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LocalEntity)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LOCALENTITY_WHERE_PKS_IN);

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

			for (LocalEntity localEntity : (List<LocalEntity>)q.list()) {
				map.put(localEntity.getPrimaryKeyObj(), localEntity);

				cacheResult(localEntity);

				uncachedPrimaryKeys.remove(localEntity.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LocalEntityModelImpl.ENTITY_CACHE_ENABLED,
					LocalEntityImpl.class, primaryKey, nullModel);
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
	 * Returns all the local entities.
	 *
	 * @return the local entities
	 */
	@Override
	public List<LocalEntity> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the local entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of local entities
	 * @param end the upper bound of the range of local entities (not inclusive)
	 * @return the range of local entities
	 */
	@Override
	public List<LocalEntity> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the local entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of local entities
	 * @param end the upper bound of the range of local entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of local entities
	 */
	@Override
	public List<LocalEntity> findAll(int start, int end,
		OrderByComparator<LocalEntity> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the local entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of local entities
	 * @param end the upper bound of the range of local entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of local entities
	 */
	@Override
	public List<LocalEntity> findAll(int start, int end,
		OrderByComparator<LocalEntity> orderByComparator,
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

		List<LocalEntity> list = null;

		if (retrieveFromCache) {
			list = (List<LocalEntity>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LOCALENTITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOCALENTITY;

				if (pagination) {
					sql = sql.concat(LocalEntityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LocalEntity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LocalEntity>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the local entities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LocalEntity localEntity : findAll()) {
			remove(localEntity);
		}
	}

	/**
	 * Returns the number of local entities.
	 *
	 * @return the number of local entities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOCALENTITY);

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
		return LocalEntityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the local entity persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LocalEntityImpl.class.getName());
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
	private static final String _SQL_SELECT_LOCALENTITY = "SELECT localEntity FROM LocalEntity localEntity";
	private static final String _SQL_SELECT_LOCALENTITY_WHERE_PKS_IN = "SELECT localEntity FROM LocalEntity localEntity WHERE localEntityId IN (";
	private static final String _SQL_SELECT_LOCALENTITY_WHERE = "SELECT localEntity FROM LocalEntity localEntity WHERE ";
	private static final String _SQL_COUNT_LOCALENTITY = "SELECT COUNT(localEntity) FROM LocalEntity localEntity";
	private static final String _SQL_COUNT_LOCALENTITY_WHERE = "SELECT COUNT(localEntity) FROM LocalEntity localEntity WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "localEntity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LocalEntity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LocalEntity exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LocalEntityPersistenceImpl.class);
}
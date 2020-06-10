package cat.diba.materialesportiu.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.text.SimpleDateFormat;
import java.util.Date;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.service.persistence.LoanFinder;

public class LoanFinderImpl extends LoanFinderBaseImpl implements cat.diba.materialesportiu.service.persistence.LoanFinder{

	private static final String FIND_BY_STOCKOUT_ACTIVITYID_BETWEEN_DATES = 
			LoanFinder.class.getName() + ".findByStockOutActivityIdBetweenDates";
	
	private static final String FIND_BY_STOCKOUT_ACTIVITYDEPENDSON = 
			LoanFinder.class.getName() + ".findByStockOutActivityDependsOn";
	
	private static final String FIND_BY_COUNT_ACTIVITIES_MAINTENANCE_BETWEEN_DATES = 
			LoanFinder.class.getName() + ".findByCountActivitiesMaintenanceBetweenDates";

	private static final String FIND_BY_COUNT_ACTIVITIES_MAINTENANCE_ACTIVITYDEPENDSON = 
			LoanFinder.class.getName() + ".findByCountActivitiesMaintenanceDependsOn";		
	
	private static final String UPDATE_LOAN_STATUS_TO_EXPIRED = 
			LoanFinder.class.getName() + ".updateLoanStatusToExpired";	
	
	
	@ServiceReference(type=CustomSQL.class)
	private CustomSQL _customSQL;
	
	@Override
	public int findByStockOutActivityIdBetweenDates(long activityId, Date startDate, Date endDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String startDate1 = format.format(startDate);
		String endDate2 = format.format(endDate);
		
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), FIND_BY_STOCKOUT_ACTIVITYID_BETWEEN_DATES);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addScalar(Fields.QUANTITY, Type.INTEGER);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(Long.toString(activityId));	
			qPos.add(startDate1);
			qPos.add(endDate2);			
			
			return (Integer)q.list().get(0);
			
		}catch(Exception e) {
			return 0;
		}finally {
	        closeSession(session);
	    }		
	}
	
	@Override
	public int findByStockOutActivityDependsOn(long activityId, Date startDate, Date endDate) {		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String startDate1 = format.format(startDate);
		String endDate2 = format.format(endDate);
		
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), FIND_BY_STOCKOUT_ACTIVITYDEPENDSON);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addScalar(Fields.QUANTITY, Type.INTEGER);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(Long.toString(activityId));	
			qPos.add(Long.toString(activityId));	
			qPos.add(startDate1);
			qPos.add(endDate2);	
			
			return (Integer)q.list().get(0);
			
		}catch(Exception e) {
			return 0;
		}finally {
	        closeSession(session);
	    }		
	}
	
	@Override
	public int findByCountActivitiesMaintenanceBetweenDates(long activityId, Date startDate, Date endDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String startDate1 = format.format(startDate);
		String endDate2 = format.format(endDate);
		
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), FIND_BY_COUNT_ACTIVITIES_MAINTENANCE_BETWEEN_DATES);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addScalar(Fields.QUANTITY, Type.INTEGER);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(Long.toString(activityId));	
			qPos.add(startDate1);
			qPos.add(endDate2);			
			
			return (Integer)q.list().get(0);
			
		}catch(Exception e) {
			return 0;
		}finally {
	        closeSession(session);
	    }	
	}	
	
	@Override
	public int findByCountActivitiesMaintenanceDependsOn(long activityId, Date startDate, Date endDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String startDate1 = format.format(startDate);
		String endDate2 = format.format(endDate);
		
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), FIND_BY_COUNT_ACTIVITIES_MAINTENANCE_ACTIVITYDEPENDSON);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addScalar(Fields.QUANTITY, Type.INTEGER);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(Long.toString(activityId));
			qPos.add(Long.toString(activityId));
			qPos.add(startDate1);
			qPos.add(endDate2);			
			
			return (Integer)q.list().get(0);
			
		}catch(Exception e) {
			return 0;
		}finally {
	        closeSession(session);
	    }	
	}
	
	@Override
	public void updateLoanStatusToExpired() {		
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), UPDATE_LOAN_STATUS_TO_EXPIRED);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);				
			q.executeUpdate();
		}catch(Exception e) {
			
		}finally {
	        closeSession(session);
	    }	
	}
}

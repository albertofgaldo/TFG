package cat.diba.materialesportiu.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.spring.extender.service.ServiceReference;

public class ActivityFinderImpl extends ActivityFinderBaseImpl implements cat.diba.materialesportiu.service.persistence.ActivityFinder{
		
	@ServiceReference(type=CustomSQL.class)
	private CustomSQL _customSQL;

}

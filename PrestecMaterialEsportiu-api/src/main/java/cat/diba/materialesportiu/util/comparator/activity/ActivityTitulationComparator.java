package cat.diba.materialesportiu.util.comparator.activity;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Locale;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Activity;

public class ActivityTitulationComparator extends OrderByComparator<Activity> {
	
	public static final String ORDER_BY_ASC = Fields.TITULATIONISREQUIRED + " " + "ASC";

	public static final String ORDER_BY_DESC = Fields.TITULATIONISREQUIRED + " " + "DESC";

	public static final String[] ORDER_BY_FIELDS = {Fields.TITULATIONISREQUIRED};

	
	public ActivityTitulationComparator(boolean ascending) {
		_ascending = ascending;
	}
	@Override
	public int compare(Activity activity1, Activity activity2) {
		
		boolean b1 = activity1.isTitulationIsRequired();
		boolean b2 = activity2.isTitulationIsRequired();

		int value = Boolean.compare(b1, b2);
		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}
	
	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;	

}

package cat.diba.materialesportiu.util.comparator.activity;

import com.liferay.portal.kernel.util.OrderByComparator;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Activity;

public class ActivityAgeComparator extends OrderByComparator<Activity> {

	public static final String ORDER_BY_ASC = Fields.AGE + " " +"ASC";

	public static final String ORDER_BY_DESC = Fields.AGE + " " + "DESC";

	public static final String[] ORDER_BY_FIELDS = {Fields.AGE};
	
	public ActivityAgeComparator() {
		this(false);
	}
	
	public ActivityAgeComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	@Override
	public int compare(Activity activity1, Activity activity2) {
int value = 0;
		
		if (activity1.getAge() < activity2.getAge()) value = -1;
		else if (activity1.getAge() > activity2.getAge()) value = 1;
		
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

package cat.diba.materialesportiu.util.comparator.activity;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Activity;

public class ActivityCreateDateComparator extends OrderByComparator<Activity> {

	public static final String ORDER_BY_ASC = Fields.CREATEDATE + " " + "ASC";

	public static final String ORDER_BY_DESC = Fields.CREATEDATE + " " + "DESC";

	public static final String[] ORDER_BY_FIELDS = {Fields.CREATEDATE};
	
	public ActivityCreateDateComparator() {
		this(false);
	}
	
	public ActivityCreateDateComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	@Override
	public int compare(Activity activity1, Activity activity2) {
		int value = DateUtil.compareTo(
				activity1.getCreateDate(), activity2.getCreateDate());

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

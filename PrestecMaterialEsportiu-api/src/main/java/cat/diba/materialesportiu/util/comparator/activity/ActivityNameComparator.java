package cat.diba.materialesportiu.util.comparator.activity;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Locale;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Activity;

public class ActivityNameComparator extends OrderByComparator<Activity> {
	
	public static final String ORDER_BY_ASC = Fields.NAME + " " + "ASC";

	public static final String ORDER_BY_DESC = Fields.NAME + " " + "DESC";

	public static final String[] ORDER_BY_FIELDS = {Fields.NAME};

	public ActivityNameComparator(Locale locale) {
		this(false, locale);
	}
	
	public ActivityNameComparator(boolean ascending, Locale locale) {
		_ascending = ascending;
		_locale = locale;
	}
	@Override
	public int compare(Activity activity1, Activity activity2) {
		
		String name1 = StringUtil.toLowerCase(activity1.getName(_locale));
		String name2 = StringUtil.toLowerCase(activity2.getName(_locale));

		int value = name1.compareTo(name2);

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
	private final Locale _locale;
}

package cat.diba.materialesportiu.util.comparator.maintenance;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Locale;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Maintenance;

public class MaintenanceLabelComparator extends OrderByComparator<Maintenance> {
	
	public static final String ORDER_BY_ASC = Fields.LABEL + " " + "ASC";

	public static final String ORDER_BY_DESC = Fields.LABEL + " " + "DESC";

	public static final String[] ORDER_BY_FIELDS = {Fields.LABEL};

		
	public MaintenanceLabelComparator(boolean ascending, Locale locale) {
		_ascending = ascending;
		_locale = locale;
	}
	@Override
	public int compare(Maintenance maintenance1, Maintenance maintenance2) {
		
		String name1 = StringUtil.toLowerCase(maintenance1.getLabel());
		String name2 = StringUtil.toLowerCase(maintenance2.getLabel());

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

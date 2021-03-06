package cat.diba.materialesportiu.util.comparator.localentity;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Locale;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.LocalEntity;

public class LocalEntityNameComparator extends OrderByComparator<LocalEntity> {
	
	public static final String ORDER_BY_ASC = Fields.NAME + " " + "ASC";

	public static final String ORDER_BY_DESC = Fields.NAME + " " + "DESC";

	public static final String[] ORDER_BY_FIELDS = {Fields.NAME};

	public LocalEntityNameComparator(Locale locale) {
		this(false, locale);
	}
	
	public LocalEntityNameComparator(boolean ascending, Locale locale) {
		_ascending = ascending;
		_locale = locale;
	}
	@Override
	public int compare(LocalEntity localEntity1, LocalEntity localEntity2) {
		
		String name1 = StringUtil.toLowerCase(localEntity1.getName());
		String name2 = StringUtil.toLowerCase(localEntity2.getName());

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

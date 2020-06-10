package cat.diba.materialesportiu.util.comparator.material;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Locale;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Material;

public class MaterialNameComparator extends OrderByComparator<Material> {
	
	public static final String ORDER_BY_ASC = Fields.NAME + " " + "ASC";

	public static final String ORDER_BY_DESC = Fields.NAME + " " + "DESC";

	public static final String[] ORDER_BY_FIELDS = {Fields.NAME};

	public MaterialNameComparator(Locale locale) {
		this(false, locale);
	}
	
	public MaterialNameComparator(boolean ascending, Locale locale) {
		_ascending = ascending;
		_locale = locale;
	}
	@Override
	public int compare(Material material1, Material material2) {
		
		String name1 = StringUtil.toLowerCase(material1.getName(_locale));
		String name2 = StringUtil.toLowerCase(material2.getName(_locale));

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

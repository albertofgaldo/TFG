package cat.diba.materialesportiu.util.comparator.material;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Material;

public class MaterialModifiedDateComparator extends OrderByComparator<Material> {

	public static final String ORDER_BY_ASC = Fields.MODIFIEDDATE + " " + "ASC";

	public static final String ORDER_BY_DESC = Fields.MODIFIEDDATE + " " + "DESC";

	public static final String[] ORDER_BY_FIELDS = {Fields.MODIFIEDDATE};
	
	public MaterialModifiedDateComparator() {
		this(false);
	}
	
	public MaterialModifiedDateComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	@Override
	public int compare(Material material1, Material material2) {
		int value = DateUtil.compareTo(
				material1.getModifiedDate(), material2.getModifiedDate());

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

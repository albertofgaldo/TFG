package cat.diba.materialesportiu.util.comparator.material;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import cat.diba.materialesportiu.model.Material;

public class MaterialCreateDateComparator extends OrderByComparator<Material> {

	public static final String ORDER_BY_ASC = "Material.createDate ASC";

	public static final String ORDER_BY_DESC = "Material.createDate DESC";

	public static final String[] ORDER_BY_FIELDS = {"createDate"};
	
	public MaterialCreateDateComparator() {
		this(false);
	}
	
	public MaterialCreateDateComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	@Override
	public int compare(Material material1, Material material2) {
		int value = DateUtil.compareTo(
				material1.getCreateDate(), material2.getCreateDate());

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

package cat.diba.materialesportiu.util.comparator.material;

import com.liferay.portal.kernel.util.OrderByComparator;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Material;

public class MaterialIdComparator extends OrderByComparator<Material> {

	public static final String ORDER_BY_ASC = Fields.MATERIALID + " " + "ASC";

	public static final String ORDER_BY_DESC = Fields.MATERIALID + " " + "DESC";

	public static final String[] ORDER_BY_FIELDS = {Fields.MATERIALID};
	
	public MaterialIdComparator() {
		this(false);
	}
	
	public MaterialIdComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	@Override
	public int compare(Material material1, Material material2) {
int value = 0;
		
		if (material1.getMaterialId() < material2.getMaterialId()) value = -1;
		else if (material1.getMaterialId() > material2.getMaterialId()) value = 1;
		
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

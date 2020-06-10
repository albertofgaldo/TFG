package cat.diba.materialesportiu.util.comparator.maintenance;

import com.liferay.portal.kernel.util.OrderByComparator;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Maintenance;

public class MaintenanceActivityIdComparator extends OrderByComparator<Maintenance> {

	public static final String ORDER_BY_ASC = Fields.MATERIALID + " " + "ASC";

	public static final String ORDER_BY_DESC = Fields.MATERIALID + " " + "DESC";

	public static final String[] ORDER_BY_FIELDS = {Fields.MATERIALID};
	
	public MaintenanceActivityIdComparator() {
		this(false);
	}
	
	public MaintenanceActivityIdComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	@Override
	public int compare(Maintenance maintenance1, Maintenance maintenance2) {
int value = 0;
		
		if (maintenance1.getActivityId() < maintenance2.getActivityId()) value = -1;
		else if (maintenance1.getActivityId() > maintenance2.getActivityId()) value = 1;
		
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

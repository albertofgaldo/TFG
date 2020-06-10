package cat.diba.materialesportiu.util.comparator.maintenance;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Maintenance;

public class MaintenanceStartDateComparator extends OrderByComparator<Maintenance> {

	public static final String ORDER_BY_ASC = Fields.START_DATE + " " + "ASC";

	public static final String ORDER_BY_DESC = Fields.START_DATE + " " + "DESC";

	public static final String[] ORDER_BY_FIELDS = {Fields.START_DATE};
	
	public MaintenanceStartDateComparator() {
		this(false);
	}
	
	public MaintenanceStartDateComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	@Override
	public int compare(Maintenance maintenance1, Maintenance maintenance2) {
		int value = DateUtil.compareTo(
				maintenance1.getStartDate(), maintenance2.getStartDate());

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

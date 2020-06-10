package cat.diba.materialesportiu.util.comparator.localentity;

import com.liferay.portal.kernel.util.OrderByComparator;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.LocalEntity;

public class LocalEntityIdComparator extends OrderByComparator<LocalEntity> {

	public static final String ORDER_BY_ASC = Fields.LOCALENTITYID + " " + "ASC";

	public static final String ORDER_BY_DESC = Fields.LOCALENTITYID + " " + "DESC";

	public static final String[] ORDER_BY_FIELDS = {Fields.LOCALENTITYID};
	
	public LocalEntityIdComparator() {
		this(false);
	}
	
	public LocalEntityIdComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	@Override
	public int compare(LocalEntity localEntity1, LocalEntity localEntity2) {
int value = 0;
		
		if (localEntity1.getLocalEntityId() < localEntity2.getLocalEntityId()) value = -1;
		else if (localEntity1.getLocalEntityId() > localEntity2.getLocalEntityId()) value = 1;
		
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

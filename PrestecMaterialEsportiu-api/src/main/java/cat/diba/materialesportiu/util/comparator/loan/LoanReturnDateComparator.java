package cat.diba.materialesportiu.util.comparator.loan;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Loan;

public class LoanReturnDateComparator extends OrderByComparator<Loan> {

	public static final String ORDER_BY_ASC = Fields.END_DATE + " " + "ASC";

	public static final String ORDER_BY_DESC = Fields.END_DATE + " " + "DESC";

	public static final String[] ORDER_BY_FIELDS = {Fields.END_DATE};
	
	public LoanReturnDateComparator() {
		this(false);
	}
	
	public LoanReturnDateComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	@Override
	public int compare(Loan loan1, Loan loan2) {
		int value = DateUtil.compareTo(
				loan1.getReturnDate(), loan2.getReturnDate());

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

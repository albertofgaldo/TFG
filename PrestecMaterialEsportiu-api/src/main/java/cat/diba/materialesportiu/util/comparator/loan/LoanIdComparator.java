package cat.diba.materialesportiu.util.comparator.loan;

import com.liferay.portal.kernel.util.OrderByComparator;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Loan;

public class LoanIdComparator extends OrderByComparator<Loan> {

	public static final String ORDER_BY_ASC = Fields.LOANID + " " + "ASC";

	public static final String ORDER_BY_DESC = Fields.LOANID + " " + "DESC";

	public static final String[] ORDER_BY_FIELDS = {Fields.LOANID};
	
	public LoanIdComparator() {
		this(false);
	}
	
	public LoanIdComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	@Override
	public int compare(Loan loan1, Loan loan2) {
int value = 0;
		
		if (loan1.getLoanId() < loan2.getLoanId()) value = -1;
		else if (loan1.getLoanId() > loan2.getLoanId()) value = 1;
		
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

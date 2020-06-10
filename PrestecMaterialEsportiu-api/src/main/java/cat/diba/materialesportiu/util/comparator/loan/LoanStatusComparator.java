package cat.diba.materialesportiu.util.comparator.loan;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Locale;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Loan;

public class LoanStatusComparator extends OrderByComparator<Loan> {
	
	public static final String ORDER_BY_ASC = Fields.EMAIL + " " + "ASC";

	public static final String ORDER_BY_DESC = Fields.EMAIL + " " + "DESC";

	public static final String[] ORDER_BY_FIELDS = {Fields.EMAIL};

	public LoanStatusComparator(Locale locale) {
		this(false, locale);
	}
	
	public LoanStatusComparator(boolean ascending, Locale locale) {
		_ascending = ascending;
		_locale = locale;
	}
	@Override
	public int compare(Loan loan1, Loan loan2) {
		
		String email1 = StringUtil.toLowerCase(loan1.getStatus());
		String email2 = StringUtil.toLowerCase(loan2.getStatus());

		int value = email1.compareTo(email2);

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

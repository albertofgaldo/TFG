package cat.diba.materialesportiu.util.comparator.loan;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Locale;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Loan;

public class LoanContactComparator extends OrderByComparator<Loan> {
	
	public static final String ORDER_BY_ASC = Fields.CONTACT_PERSON + " " + "ASC";

	public static final String ORDER_BY_DESC = Fields.CONTACT_PERSON + " " + "DESC";

	public static final String[] ORDER_BY_FIELDS = {Fields.CONTACT_PERSON};

	public LoanContactComparator(Locale locale) {
		this(false, locale);
	}
	
	public LoanContactComparator(boolean ascending, Locale locale) {
		_ascending = ascending;
		_locale = locale;
	}
	@Override
	public int compare(Loan loan1, Loan loan2) {
		
		String name1 = StringUtil.toLowerCase(loan1.getContactPerson());
		String name2 = StringUtil.toLowerCase(loan2.getContactPerson());

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

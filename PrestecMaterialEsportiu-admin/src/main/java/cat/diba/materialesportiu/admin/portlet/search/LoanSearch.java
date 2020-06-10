package cat.diba.materialesportiu.admin.portlet.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Loan;

public class LoanSearch extends SearchContainer<Loan>{

	public static final String EMPTY_RESULTS_MESSAGE = "No s'han trobat préstecs";
	public static List<String> headerNames = new ArrayList<>();
	
	static {			
		headerNames.add(Fields.CREATEDATE);
		headerNames.add(Fields.MODIFIEDDATE);
		headerNames.add(Fields.PICKUP_DATE);
		headerNames.add(Fields.RETURN_DATE);
		headerNames.add(Fields.ACTIVITY_DATE);
		headerNames.add(Fields.CONTACT_PERSON);
		headerNames.add(Fields.EMAIL);
		headerNames.add(Fields.PMT);
		headerNames.add(Fields.STATUS);
	}

	public LoanSearch(PortletRequest portletRequest, PortletURL iteratorURL){
		super(portletRequest, new PrestecMaterialEsportiuDisplayTerms(portletRequest), new PrestecMaterialEsportiuDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
	}
}

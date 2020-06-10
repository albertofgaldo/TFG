package cat.diba.materialesportiu.admin.portlet.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Activity;

public class ActivitySearch extends SearchContainer<Activity>{

	public static final String EMPTY_RESULTS_MESSAGE = "No s'han trobat activitats";
	public static List<String> headerNames = new ArrayList<>();
	
	static {
		headerNames.add(Fields.ACTIVITYID);			
		headerNames.add(Fields.NAME);
		headerNames.add(Fields.AGE);
		headerNames.add(Fields.MINPARTICIPANTS);
		headerNames.add(Fields.MAXPARTICIPANTS);
		headerNames.add(Fields.TITULATIONISREQUIRED);
		headerNames.add(Fields.CREATEDATE);
		headerNames.add(Fields.MODIFIEDDATE);	
	}

	public ActivitySearch(PortletRequest portletRequest, PortletURL iteratorURL){
		super(portletRequest, new PrestecMaterialEsportiuDisplayTerms(portletRequest), new PrestecMaterialEsportiuDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
	}
}

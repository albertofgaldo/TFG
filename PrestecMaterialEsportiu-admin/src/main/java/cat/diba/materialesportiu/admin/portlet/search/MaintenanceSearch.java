package cat.diba.materialesportiu.admin.portlet.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Maintenance;

public class MaintenanceSearch extends SearchContainer<Maintenance>{

	public static final String EMPTY_RESULTS_MESSAGE = "No s'han trobat manteniments";
	public static List<String> headerNames = new ArrayList<>();
	
	static {
		headerNames.add(Fields.MAINTENANCEID);			
		headerNames.add(Fields.MATERIALID);
		headerNames.add(Fields.LABEL);
		headerNames.add(Fields.DESCRIPTION);
		headerNames.add(Fields.START_DATE);
		headerNames.add(Fields.END_DATE);
		headerNames.add(Fields.CREATEDATE);
		headerNames.add(Fields.MODIFIEDDATE);	
	}

	public MaintenanceSearch(PortletRequest portletRequest, PortletURL iteratorURL){
		super(portletRequest, new PrestecMaterialEsportiuDisplayTerms(portletRequest), new PrestecMaterialEsportiuDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
	}
}

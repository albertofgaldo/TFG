package cat.diba.materialesportiu.admin.portlet.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Material;

public class MaterialSearch extends SearchContainer<Material>{

	public static final String EMPTY_RESULTS_MESSAGE = "No s'han trobat materials";
	public static List<String> headerNames = new ArrayList<>();
	
	static {
		headerNames.add(Fields.MATERIALID);			
		headerNames.add(Fields.NAME);
		headerNames.add(Fields.TOTAL_STOCK);
		headerNames.add(Fields.DAYSBEFORELOAN);
		headerNames.add(Fields.DAYSBOOKING);
		headerNames.add(Fields.DAYSAFTERLOAN);
		headerNames.add(Fields.CREATEDATE);
		headerNames.add(Fields.MODIFIEDDATE);
	}

	public MaterialSearch(PortletRequest portletRequest, PortletURL iteratorURL){
		super(portletRequest, new PrestecMaterialEsportiuDisplayTerms(portletRequest), new PrestecMaterialEsportiuDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
	}
}

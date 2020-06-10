package cat.diba.materialesportiu.admin.portlet.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.LocalEntity;

public class LocalEntitySearch extends SearchContainer<LocalEntity> {
	
	public static final String EMPTY_RESULTS_MESSAGE = "No s'han trobat ens locals";
	public static List<String> headerNames = new ArrayList<>();
	//Duda: Campos que quiero mostrar en la lista?
	static {
		headerNames.add(Fields.LOCALENTITYID);	
		headerNames.add(Fields.CIF);
		headerNames.add(Fields.NAME);
		headerNames.add(Fields.TELEPHONE);
		headerNames.add(Fields.EMAIL);
		headerNames.add(Fields.CREATEDATE);
		headerNames.add(Fields.MODIFIEDDATE);	
	}

	public LocalEntitySearch(PortletRequest portletRequest, PortletURL iteratorURL){
		super(portletRequest, new PrestecMaterialEsportiuDisplayTerms(portletRequest), new PrestecMaterialEsportiuDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
	}

}

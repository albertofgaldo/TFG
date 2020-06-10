package cat.diba.materialesportiu.admin.portlet.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItemList;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.function.Consumer;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import cat.diba.materialesportiu.admin.portlet.display.context.util.PrestecMaterialEsportiuRequestHelper;
import cat.diba.materialesportiu.admin.portlet.search.MaterialSearch;
import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Material;
import cat.diba.materialesportiu.service.MaterialLocalServiceUtil;
import cat.diba.materialesportiu.util.comparator.material.MaterialCreateDateComparator;
import cat.diba.materialesportiu.util.comparator.material.MaterialIdComparator;
import cat.diba.materialesportiu.util.comparator.material.MaterialNameComparator;


public class MaterialDisplayContext {
	private static final String[] _DISPLAY_VIEWS = { "list" };

	private final PrestecMaterialEsportiuRequestHelper _pmeRequestHelper;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;

	public MaterialDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse) {

		_renderRequest = renderRequest;
		_renderResponse = renderResponse;
		_pmeRequestHelper = new PrestecMaterialEsportiuRequestHelper(renderRequest);
	}
	
	public CreationMenu getCreationMenu() {	
		
		return new CreationMenu() {
			{
				HttpServletRequest request = _pmeRequestHelper.getRequest();

				addPrimaryDropdownItem(
					dropdownItem -> {
						dropdownItem.setHref(
							_renderResponse.createRenderURL(), "mvcPath",
							"/material/editMaterial.jsp", "redirect",
							PortalUtil.getCurrentURL(request));
						dropdownItem.setLabel(
							LanguageUtil.get(request, "add-material"));
					});
			}
		};
	}
	
	//NavigationBar
	public List<NavigationItem> getNavigationItems(String title) {
		ThemeDisplay themeDisplay = getThemeDisplay();

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		return new NavigationItemList() {
			{
				add(
					navigationItem -> {
						navigationItem.setActive(true);
						navigationItem.setHref(StringPool.BLANK);
						navigationItem.setLabel(!title.isEmpty()? LanguageUtil.get(_pmeRequestHelper.getRequest(), title) : 
							portletDisplay.getPortletDisplayName() );
					});
			}
		};
	}
	//ManagmentBar
	protected boolean hasResults() {
		if (getTotalItems() > 0) {
			return true;
		}

		return false;
	}
	public int getTotalItems() {
		SearchContainer<?> searchContainer = getSearch();

		return searchContainer.getTotal();
	}
	protected boolean isSearch() {
		if (Validator.isNotNull(getKeywords())) {
			return true;
		}

		return false;
	}
	public boolean isDisabledManagementBar( ) {
		if (hasResults()) {
			return false;
		}

		if (isSearch()) {
			return false;
		}

		return true;
	}
	public String getClearResultsURL() throws PortletException {
		PortletURL clearResultsURL = PortletURLUtil.clone(
			getPortletURL(), _renderResponse);

		clearResultsURL.setParameter("keywords", StringPool.BLANK);

		return clearResultsURL.toString();
	}
	public String getSearchActionURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();

		portletURL.setParameter("mvcPath", "/material/viewMaterial.jsp");

		return portletURL.toString();
	}
	public String getSortingURL() throws Exception {
		PortletURL sortingURL = PortletURLUtil.clone(
			getPortletURL(), _renderResponse);

		String orderByType = ParamUtil.getString(_renderRequest, "orderByType");

		sortingURL.setParameter(
			"orderByType", orderByType.equals("asc") ? "desc" : "asc");

		return sortingURL.toString();
	}
	protected List<DropdownItem> getFilterNavigationDropdownItems() {
		return new DropdownItemList() {
			{
				add(
					dropdownItem -> {
						dropdownItem.setActive(true);

						dropdownItem.setHref(
							getPortletURL(), "navigation", "all");

						dropdownItem.setLabel(
							LanguageUtil.get(
									_pmeRequestHelper.getRequest(), "all"));
					});
			}
		};
	}
	public List<DropdownItem> getFilterItemsDropdownItems() {
		HttpServletRequest request = _pmeRequestHelper.getRequest();

		return new DropdownItemList() {
			{
				addGroup(
					dropdownGroupItem -> {
						dropdownGroupItem.setDropdownItems(
							getFilterNavigationDropdownItems());
						dropdownGroupItem.setLabel(
							LanguageUtil.get(request, "filter-by-navigation"));
					});

				addGroup(
					dropdownGroupItem -> {
						dropdownGroupItem.setDropdownItems(
							getOrderByDropdownItems());
						dropdownGroupItem.setLabel(
							LanguageUtil.get(request, "order-by"));
					});
			}
		};
	}
	protected Consumer<DropdownItem> getOrderByDropdownItem(String orderByCol) {
		return dropdownItem -> {
			dropdownItem.setActive(orderByCol.equals(getOrderByCol()));
			dropdownItem.setHref(getPortletURL(), "orderByCol", orderByCol);
			dropdownItem.setLabel(
				LanguageUtil.get(_pmeRequestHelper.getRequest(), orderByCol));
		};
	}
	public String getOrderByCol() {
		return ParamUtil.getString(_renderRequest, "orderByCol", Fields.CREATEDATE);
	}
	//managmentBar Material
	protected List<DropdownItem> getOrderByDropdownItems() {
		return new DropdownItemList() {

			{
				add(getOrderByDropdownItem(Fields.CREATEDATE));
				add(getOrderByDropdownItem(Fields.MODIFIEDDATE));
				add(getOrderByDropdownItem(Fields.MATERIALID));
				add(getOrderByDropdownItem(Fields.NAME));
				add(getOrderByDropdownItem(Fields.TOTAL_STOCK));
				add(getOrderByDropdownItem(Fields.DAYSBEFORELOAN));
				add(getOrderByDropdownItem(Fields.DAYSBOOKING));
				add(getOrderByDropdownItem(Fields.DAYSAFTERLOAN));				
			}

		};
	}	
	public String getSearchContainerId() {
		return "material";
	}
	
	//Material
	public SearchContainer<?> getSearch( ) {
		String displayStyle = getDisplayStyle();

		PortletURL portletURL = getPortletURL();

		portletURL.setParameter("displayStyle", displayStyle);

		MaterialSearch materialSearch = new MaterialSearch(
			_renderRequest, portletURL);

		String orderByCol = getOrderByCol();
		String orderByType = getOrderByType();

		OrderByComparator<Material> orderByComparator =
			getMaterialOrderByComparator(orderByCol, orderByType);

		materialSearch.setOrderByCol(orderByCol);
		materialSearch.setOrderByComparator(orderByComparator);
		materialSearch.setOrderByType(orderByType);

		if (materialSearch.isSearch()) {
			materialSearch.setEmptyResultsMessage("no-material-were-found");
		}
		else {
			materialSearch.setEmptyResultsMessage("there-are-no-material");
		}		
		setDDMMaterialSearchResults(materialSearch);
		setDDMMaterialSearchTotal(materialSearch);

		return materialSearch;
	}
	public PortletURL getPortletURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();
		
		portletURL.setParameter("mvcPath", "/material/viewMaterial.jsp");

		String delta = ParamUtil.getString(_renderRequest, "delta");

		if (Validator.isNotNull(delta)) {
			portletURL.setParameter("delta", delta);
		}

		String displayStyle = getDisplayStyle();

		if (Validator.isNotNull(displayStyle)) {
			portletURL.setParameter("displayStyle", displayStyle);
		}

		String keywords = getKeywords();

		if (Validator.isNotNull(keywords)) {
			portletURL.setParameter("keywords", keywords);
		}

		String orderByCol = getOrderByCol();

		if (Validator.isNotNull(orderByCol)) {
			portletURL.setParameter("orderByCol", orderByCol);
		}

		String orderByType = getOrderByType();

		if (Validator.isNotNull(orderByType)) {
			portletURL.setParameter("orderByType", orderByType);
		}

		return portletURL;
	}
	//util material
	public String getDisplayStyle() {
		return "list";
	}
	protected String getKeywords() {
		return ParamUtil.getString(_renderRequest, "keywords");
	}
	public String getOrderByType() {
		return ParamUtil.getString(_renderRequest, "orderByType", "desc");
	}

	private void setDDMMaterialSearchTotal(MaterialSearch materialQuestionSearch) {
		int total = MaterialLocalServiceUtil.getCountByCompanyGroup(
				_pmeRequestHelper.getCompanyId(), 
				_pmeRequestHelper.getScopeGroupId());					
		materialQuestionSearch.setTotal(total);
	}

	private void setDDMMaterialSearchResults(MaterialSearch materialSearch ) {	
		List<Material> results = MaterialLocalServiceUtil.getMaterialByCompanyGroup(
					_pmeRequestHelper.getCompanyId(),
					_pmeRequestHelper.getScopeGroupId(),
					materialSearch.getStart(),
					materialSearch.getEnd(),
					materialSearch.getOrderByComparator());				
		materialSearch.setResults(results);
	}

	private OrderByComparator<Material> getMaterialOrderByComparator(String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator<Material> orderByComparator = null;
		switch(orderByCol) {
			case Fields.CREATEDATE:
				orderByComparator = new MaterialCreateDateComparator(orderByAsc);
				break;
			case Fields.MODIFIEDDATE:
				orderByComparator = new MaterialCreateDateComparator(orderByAsc);
				break;
			case Fields.MATERIALID:
				orderByComparator = new MaterialIdComparator(orderByAsc);
				break;
			case Fields.NAME:
				orderByComparator = new MaterialNameComparator(orderByAsc, getThemeDisplay().getLocale());
				break;
		}		
		return orderByComparator;
	}

	//util
	protected ThemeDisplay getThemeDisplay() {
		ThemeDisplay themeDisplay = (ThemeDisplay)_renderRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

			return themeDisplay;
		}

}

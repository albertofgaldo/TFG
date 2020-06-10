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
import cat.diba.materialesportiu.admin.portlet.search.LocalEntitySearch;
import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.LocalEntity;
import cat.diba.materialesportiu.service.LocalEntityLocalServiceUtil;
import cat.diba.materialesportiu.util.comparator.localentity.LocalEntityCifComparator;
import cat.diba.materialesportiu.util.comparator.localentity.LocalEntityCreateDateComparator;
import cat.diba.materialesportiu.util.comparator.localentity.LocalEntityEmailComparator;
import cat.diba.materialesportiu.util.comparator.localentity.LocalEntityIdComparator;
import cat.diba.materialesportiu.util.comparator.localentity.LocalEntityModifiedDateComparator;
import cat.diba.materialesportiu.util.comparator.localentity.LocalEntityNameComparator;

public class LocalEntityDisplayContext {

	private static final String[] _DISPLAY_VIEWS = { "list" };

	private final PrestecMaterialEsportiuRequestHelper _pmeRequestHelper;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;

	public LocalEntityDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse) {

		_renderRequest = renderRequest;
		_renderResponse = renderResponse;
		_pmeRequestHelper = new PrestecMaterialEsportiuRequestHelper(renderRequest);
	}
	
	public String getClearResultsURL() throws PortletException {
		PortletURL clearResultsURL = PortletURLUtil.clone(
			getPortletURL(), _renderResponse);

		clearResultsURL.setParameter("keywords", StringPool.BLANK);

		return clearResultsURL.toString();
	}
	
	public CreationMenu getCreationMenu() {	
		
		return new CreationMenu() {
			{
				HttpServletRequest request = _pmeRequestHelper.getRequest();

				addPrimaryDropdownItem(
					dropdownItem -> {
						dropdownItem.setHref(
							_renderResponse.createRenderURL(), "mvcPath",
							"/localEntity/editLocalEntity.jsp", "redirect",
							PortalUtil.getCurrentURL(request));
						dropdownItem.setLabel(
							LanguageUtil.get(request, "add-localEntity"));
					});
			}
		};
	}
	
	public String getDisplayStyle() {
		return "list";
	}
	
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
	
	protected List<DropdownItem> getOrderByDropdownItems() {
		return new DropdownItemList() {

			{
				add(getOrderByDropdownItem(Fields.CREATEDATE));
				add(getOrderByDropdownItem(Fields.MODIFIEDDATE));
//				add(getOrderByDropdownItem(Fields.LOCALENTITYID));
				add(getOrderByDropdownItem(Fields.NAME));
				add(getOrderByDropdownItem(Fields.CIF));
				add(getOrderByDropdownItem(Fields.EMAIL));

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
	
	public String getSearchActionURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();

		portletURL.setParameter("mvcPath", "/localEntity/viewLocalEntity.jsp");

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
	
	public PortletURL getPortletURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();
		//DUDA: Puedo quitar los m�todos deprecated?
		//A qu� hace referencia este jsp?
		portletURL.setParameter("mvcPath", "/localEntity/viewLocalEntity.jsp");

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
	
	protected String getKeywords() {
		return ParamUtil.getString(_renderRequest, "keywords");
	}
	
	public String getOrderByCol() {
		return ParamUtil.getString(_renderRequest, "orderByCol", Fields.CREATEDATE);
	}

	public String getOrderByType() {
		return ParamUtil.getString(_renderRequest, "orderByType", "desc");
	}
	
	public String getSearchContainerId() {
		return "localEntity";
	}
	
	public SearchContainer<?> getSearch() {
		String displayStyle = getDisplayStyle();

		PortletURL portletURL = getPortletURL();

		portletURL.setParameter("displayStyle", displayStyle);

		LocalEntitySearch localEntitySearch = new LocalEntitySearch(
			_renderRequest, portletURL);

		String orderByCol = getOrderByCol();
		String orderByType = getOrderByType();

		OrderByComparator<LocalEntity> orderByComparator =
			getLocalEntityOrderByComparator(orderByCol, orderByType);

		localEntitySearch.setOrderByCol(orderByCol);
		localEntitySearch.setOrderByComparator(orderByComparator);
		localEntitySearch.setOrderByType(orderByType);

		if (localEntitySearch.isSearch()) {
			localEntitySearch.setEmptyResultsMessage("no-localEntity-were-found");
		}
		else {
			localEntitySearch.setEmptyResultsMessage("there-are-no-localEntity");
		}
		
		setDDMLocalEntitySearchResults(localEntitySearch);
		setDDMLocalEntitySearchTotal(localEntitySearch);

		return localEntitySearch;
	}

	private void setDDMLocalEntitySearchTotal(LocalEntitySearch localEntityQuestionSearch) {
		
		int total = LocalEntityLocalServiceUtil.getCountByCompanyGroup(
				_pmeRequestHelper.getCompanyId(), 
				_pmeRequestHelper.getScopeGroupId());
		
		localEntityQuestionSearch.setTotal(total);
	}

	private void setDDMLocalEntitySearchResults(LocalEntitySearch localEntitySearch) {

		List<LocalEntity> results = LocalEntityLocalServiceUtil.getLocalEntityByCompanyGroup(
				_pmeRequestHelper.getCompanyId(),
				_pmeRequestHelper.getScopeGroupId(),
				localEntitySearch.getStart(),
				localEntitySearch.getEnd(),
				localEntitySearch.getOrderByComparator());
		localEntitySearch.setResults(results);
	}

	private OrderByComparator<LocalEntity> getLocalEntityOrderByComparator(String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator<LocalEntity> orderByComparator = null;

		if (orderByCol.equals(Fields.CREATEDATE)) {
			orderByComparator = new LocalEntityCreateDateComparator(orderByAsc);
		}
		else if (orderByCol.equals(Fields.MODIFIEDDATE)) {
			orderByComparator = new LocalEntityModifiedDateComparator(orderByAsc);
		}
		//else if (orderByCol.equals(Fields.LOCALENTITYID)) {
		//	orderByComparator = new LocalEntityIdComparator(orderByAsc);
		//}
		else if (orderByCol.equals(Fields.NAME)) {
			orderByComparator = new LocalEntityNameComparator(orderByAsc, getThemeDisplay().getLocale());
		}
		else if (orderByCol.equals(Fields.CIF)) {
			orderByComparator = new LocalEntityCifComparator(orderByAsc, getThemeDisplay().getLocale());
		}
		else if (orderByCol.equals(Fields.EMAIL)) {
			orderByComparator = new LocalEntityEmailComparator(orderByAsc, getThemeDisplay().getLocale());
		}
		return orderByComparator;
	}

	protected ThemeDisplay getThemeDisplay() {
		ThemeDisplay themeDisplay = (ThemeDisplay)_renderRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

			return themeDisplay;
		}
	
	public boolean isDisabledManagementBar() {
		if (hasResults()) {
			return false;
		}

		if (isSearch()) {
			return false;
		}

		return true;
	}
	
	protected boolean hasResults() {
		if (getTotalItems() > 0) {
			return true;
		}

		return false;
	}

	protected boolean isSearch() {
		if (Validator.isNotNull(getKeywords())) {
			return true;
		}

		return false;
	}

	public int getTotalItems() {
		SearchContainer<?> searchContainer = getSearch();

		return searchContainer.getTotal();
	}
}

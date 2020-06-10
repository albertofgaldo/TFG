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
import cat.diba.materialesportiu.admin.portlet.search.LoanSearch;
import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Loan;
import cat.diba.materialesportiu.service.LoanLocalServiceUtil;
import cat.diba.materialesportiu.util.comparator.loan.LoanActivityDateComparator;
import cat.diba.materialesportiu.util.comparator.loan.LoanContactComparator;
import cat.diba.materialesportiu.util.comparator.loan.LoanCreateDateComparator;
import cat.diba.materialesportiu.util.comparator.loan.LoanEmailComparator;
import cat.diba.materialesportiu.util.comparator.loan.LoanIdComparator;
import cat.diba.materialesportiu.util.comparator.loan.LoanPickupDateComparator;
import cat.diba.materialesportiu.util.comparator.loan.LoanPmtComparator;
import cat.diba.materialesportiu.util.comparator.loan.LoanReturnDateComparator;
import cat.diba.materialesportiu.util.comparator.loan.LoanStatusComparator;


public class LoanDisplayContext {
	private static final String[] _DISPLAY_VIEWS = { "list" };

	private final PrestecMaterialEsportiuRequestHelper _pmeRequestHelper;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;

	public LoanDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse) {

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
							"/loan/editLoan.jsp", "redirect",
							PortalUtil.getCurrentURL(request));
						dropdownItem.setLabel(
							LanguageUtil.get(request, "add-loan"));
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
	public boolean isDisabledManagementBar() {
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

		//clearResultsURL.setParameter("keywords", StringPool.BLANK);
		clearResultsURL.setProperty("keywords", StringPool.BLANK);

		return clearResultsURL.toString();
	}
	public String getSearchActionURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();

		//portletURL.setParameter("mvcPath", "/loan/viewLoan.jsp");
		portletURL.setProperty("mvcPath", "/loan/viewLoan.jsp");

		return portletURL.toString();
	}
	public String getSortingURL() throws Exception {
		PortletURL sortingURL = PortletURLUtil.clone(
			getPortletURL(), _renderResponse);

		String orderByType = ParamUtil.getString(_renderRequest, "orderByType");

	//	sortingURL.setParameter(
	//		"orderByType", orderByType.equals("asc") ? "desc" : "asc");
		sortingURL.setProperty(
				"orderByType", orderByType.equals("asc") ? "desc" : "asc");

		return sortingURL.toString();
	}
	protected Consumer<DropdownItem> getFilterNavigationDropdownItem(String filterByState) {
		return dropdownItem -> {
			dropdownItem.setActive(filterByState.equals("all"));
			dropdownItem.setHref(getPortletURL(), "filterByState", filterByState);
			dropdownItem.setLabel(
				LanguageUtil.get(_pmeRequestHelper.getRequest(), filterByState));
		};
	}
	
	public String getFilterByState() {
		return ParamUtil.getString(_renderRequest, "filterByState", "all");
	}
	
	protected List<DropdownItem> getFilterNavigationDropdownItems() {
		return new DropdownItemList() {
			{
				add(getFilterNavigationDropdownItem("all"));
				add(getFilterNavigationDropdownItem(Fields.LoanStatus.NOTCONFIRMED.toString().toLowerCase()));
				add(getFilterNavigationDropdownItem(Fields.LoanStatus.EXPIRED.toString().toLowerCase()));
				add(getFilterNavigationDropdownItem(Fields.LoanStatus.CONFIRMED.toString().toLowerCase()));
				add(getFilterNavigationDropdownItem(Fields.LoanStatus.BORROWED.toString().toLowerCase()));
				add(getFilterNavigationDropdownItem(Fields.LoanStatus.MAINTENANCE.toString().toLowerCase()));
				add(getFilterNavigationDropdownItem(Fields.LoanStatus.RETURNED.toString().toLowerCase()));				
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
	//managmentBar Loan
	protected List<DropdownItem> getOrderByDropdownItems() {
		return new DropdownItemList() {

			{
				add(getOrderByDropdownItem(Fields.CREATEDATE));
				add(getOrderByDropdownItem(Fields.MODIFIEDDATE));
				//add(getOrderByDropdownItem(Fields.LOANID));
				add(getOrderByDropdownItem(Fields.PICKUP_DATE));
				add(getOrderByDropdownItem(Fields.RETURN_DATE));
				add(getOrderByDropdownItem(Fields.ACTIVITY_DATE));
				add(getOrderByDropdownItem(Fields.CONTACT_PERSON));
				add(getOrderByDropdownItem(Fields.EMAIL));
				add(getOrderByDropdownItem(Fields.PMT));
				add(getOrderByDropdownItem(Fields.STATUS));				
			}

		};
	}	
	public String getSearchContainerId() {
		return "loan";
	}
	
	//Loan
	public SearchContainer<?> getSearch() {
		String displayStyle = getDisplayStyle();

		PortletURL portletURL = getPortletURL();

		//portletURL.setParameter("displayStyle", displayStyle);
		portletURL.setProperty("displayStyle", displayStyle);
		

		LoanSearch loanSearch = new LoanSearch(
			_renderRequest, portletURL);

		String orderByCol = getOrderByCol();
		String orderByType = getOrderByType();

		OrderByComparator<Loan> orderByComparator =
			getLoanOrderByComparator(orderByCol, orderByType);
		
		loanSearch.setOrderByCol(orderByCol);
		loanSearch.setOrderByComparator(orderByComparator);
		loanSearch.setOrderByType(orderByType);
		

		if (loanSearch.isSearch()) {
			loanSearch.setEmptyResultsMessage("no-loan-were-found");
		}
		else {
			loanSearch.setEmptyResultsMessage("there-are-no-loan");
		}		
		setDDMLoanSearchResults(loanSearch);
		setDDMLoanSearchTotal(loanSearch);

		return loanSearch;
	}
	public PortletURL getPortletURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();
		
		//portletURL.setParameter("mvcPath", "/loan/viewLoan.jsp");
		portletURL.setProperty("mvcPath", "/loan/viewLoan.jsp");

		String delta = ParamUtil.getString(_renderRequest, "delta");

		if (Validator.isNotNull(delta)) {
			//portletURL.setParameter("delta", delta);
			portletURL.setProperty("delta", delta);
		}

		String displayStyle = getDisplayStyle();

		if (Validator.isNotNull(displayStyle)) {
			//portletURL.setParameter("displayStyle", displayStyle);
			portletURL.setProperty("displayStyle", displayStyle);
		}

		String keywords = getKeywords();

		if (Validator.isNotNull(keywords)) {
			//portletURL.setParameter("keywords", keywords);
			portletURL.setProperty("keywords", keywords);
		}
		
		String filterByState = getFilterByState();

		if (Validator.isNotNull(filterByState)) {
			//portletURL.setParameter("orderByCol", orderByCol);
			portletURL.setProperty("filterByState", filterByState);
		}

		String orderByCol = getOrderByCol();

		if (Validator.isNotNull(orderByCol)) {
			//portletURL.setParameter("orderByCol", orderByCol);
			portletURL.setProperty("orderByCol", orderByCol);
		}

		String orderByType = getOrderByType();

		if (Validator.isNotNull(orderByType)) {
			//portletURL.setParameter("orderByType", orderByType);
			portletURL.setProperty("orderByType", orderByType);
		}

		return portletURL;
	}
	//util loan
	public String getDisplayStyle() {
		return "list";
	}
	protected String getKeywords() {
		return ParamUtil.getString(_renderRequest, "keywords");
	}
	public String getOrderByType() {
		return ParamUtil.getString(_renderRequest, "orderByType", "desc");
	}

	private void setDDMLoanSearchTotal(LoanSearch loanQuestionSearch) {
		
		int total = LoanLocalServiceUtil.getCountByCompanyGroup(
				_pmeRequestHelper.getCompanyId(), 
				_pmeRequestHelper.getScopeGroupId());
		
		loanQuestionSearch.setTotal(total);
	}

	private void setDDMLoanSearchResults(LoanSearch loanSearch) {

		List<Loan> results = LoanLocalServiceUtil.getLoanByCompanyGroup(
				_pmeRequestHelper.getCompanyId(),
				_pmeRequestHelper.getScopeGroupId(),
				loanSearch.getStart(),
				loanSearch.getEnd(),
				loanSearch.getOrderByComparator());
		loanSearch.setResults(results);
	}

	private OrderByComparator<Loan> getLoanOrderByComparator(String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator<Loan> orderByComparator = null;
		switch(orderByCol) {
			case Fields.CREATEDATE:
				orderByComparator = new LoanCreateDateComparator(orderByAsc);
				break;
			case Fields.MODIFIEDDATE:
				orderByComparator = new LoanCreateDateComparator(orderByAsc);
				break;
			//case Fields.LOANID:
			//	orderByComparator = new LoanIdComparator(orderByAsc);
			//	break;
			case Fields.PICKUP_DATE:
				orderByComparator = new LoanPickupDateComparator(orderByAsc);
				break;
			case Fields.RETURN_DATE:
				orderByComparator = new LoanReturnDateComparator(orderByAsc);
				break;
			case Fields.ACTIVITY_DATE:
				orderByComparator = new LoanActivityDateComparator(orderByAsc);
				break;
			case Fields.CONTACT_PERSON:
				orderByComparator = new LoanContactComparator(orderByAsc, getThemeDisplay().getLocale());
				break;
			case Fields.EMAIL:
				orderByComparator = new LoanEmailComparator(orderByAsc, getThemeDisplay().getLocale());
				break;
			case Fields.PMT:
				orderByComparator = new LoanPmtComparator(orderByAsc, getThemeDisplay().getLocale());
				break;
			case Fields.STATUS:
				orderByComparator = new LoanStatusComparator(orderByAsc, getThemeDisplay().getLocale());
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

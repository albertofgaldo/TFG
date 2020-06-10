package cat.diba.materialesportiu.web.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import cat.diba.materialesportiu.constants.Fields;
import cat.diba.materialesportiu.model.Loan;
import cat.diba.materialesportiu.model.LoanActivity;
import cat.diba.materialesportiu.service.LoanActivityLocalServiceUtil;
import cat.diba.materialesportiu.service.LoanLocalServiceUtil;
import cat.diba.materialesportiu.service.LocalEntityLocalServiceUtil;
import cat.diba.materialesportiu.web.config.PrestecMaterialEsportiuConfiguration;
import cat.diba.materialesportiu.web.constants.PrestecMaterialEsportiuWebPortletKeys;

/**
 * @author alberto
 */
@Component(
		// configurationPid =
		// "cat.diba.portal.cercadorArticlesVocabularis.web.config.CercadorArticlesVocabularisConfiguration",
		immediate = true, property = { "com.liferay.portlet.display-category=DIBA",
				"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
				"javax.portlet.display-name=Prestec de Material Esportiu", "javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/html/view.jsp",
				"javax.portlet.name=" + PrestecMaterialEsportiuWebPortletKeys.PRESTECMATERIALESPORTIUWEB,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=administrator,power-user,user" }, service = Portlet.class)
public class PrestecMaterialEsportiuWebPortlet extends MVCPortlet {

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		// _prestecMaterialEsportiuConfiguration = ConfigurableUtil.createConfigurable(
		// PrestecMaterialEsportiuConfiguration.class, properties);
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		if (ParamUtil.getString(renderRequest, "jsp").equals("loan-date")) {
			Date activityDate = ParamUtil.getDate(renderRequest, Fields.ACTIVITY_DATE,
					new SimpleDateFormat("dd/MM/yyyy"));
			Date returnDate = ParamUtil.getDate(renderRequest, Fields.RETURN_DATE, new SimpleDateFormat("dd/MM/yyyy"));
			if (activityDate.after(returnDate)) {
				// renderRequest.setAttribute("jsp", StringPool.BLANK);
				SessionErrors.add(renderRequest, "error-loan-dates");
			}
		}
		if (ParamUtil.getString(renderRequest, "mvcPath").equals("/html/loan.jsp")) {
			String activities[] = ParamUtil.getStringValues(renderRequest, Fields.ACTIVITYID);
			List<String> activitiesList = new ArrayList(activities.length);			
			for (String a : activities) {
				if (!activitiesList.contains(a)) {
					activitiesList.add(a);
				}else {
					SessionErrors.add(renderRequest, "error-loan-activity");
					//PortalUtil.(actionRequest, actionResponse);(renderRequest, renderResponse);
					//renderResponse.addProperty("mvcPath", "/html/view.jsp");
					renderResponse.resetBuffer();
					renderResponse.setProperty("mvcPath", "/html/view.jsp");
					renderRequest.setAttribute("mvcPath", "/html/view.jsp");
				}
			}
		}

		/*
		 * if(ParamUtil.getString(renderRequest, "mvcPath").equals("/html/loan.jsp")) {
		 * String activities[] = ParamUtil.getStringValues(renderRequest,
		 * Fields.ACTIVITYID); String units [] =
		 * ParamUtil.getStringValues(renderRequest, Fields.QUANTITY); int
		 * daysBeforeLoan=0; for(String s : activities){ if(!s.isEmpty()){ try {
		 * if(ActivityLocalServiceUtil.getActivity(Long.parseLong(s)).getDaysBeforeLoan(
		 * )>daysBeforeLoan){
		 * daysBeforeLoan=ActivityLocalServiceUtil.getActivity(Long.parseLong(s)).
		 * getDaysBeforeLoan(); } } catch (NumberFormatException | PortalException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); } } } Calendar
		 * pickupDate = Calendar.getInstance();
		 * pickupDate.setTime(ParamUtil.getDate(renderRequest, Fields.ACTIVITY_DATE, new
		 * SimpleDateFormat("dd/MM/yyyy"))); pickupDate.add(Calendar.DAY_OF_MONTH,
		 * -daysBeforeLoan); renderRequest.setAttribute(Fields.PICKUP_DATE,
		 * pickupDate.getTime()); }
		 */
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		super.doView(renderRequest, renderResponse);
	}

	@ProcessAction(name = "saveLoan")
	public void saveLoan(ActionRequest arq, ActionResponse arp) throws Exception {

		String cif = ParamUtil.getString(arq, Fields.CIF, StringPool.BLANK);
		if (LocalEntityLocalServiceUtil.checkCif(cif)) {
			Loan loan = new LoanLocalServiceUtil().createLoan(0);
			long localEntity = LocalEntityLocalServiceUtil.getLocalEntityByCif(cif).getLocalEntityId();
			loan.setLocalEntityId(localEntity);
			loan.setPickupDate(new SimpleDateFormat("dd/MM/yyyy").parse(ParamUtil.get(arq, Fields.PICKUP_DATE, "")));
			loan.setReturnDate(new SimpleDateFormat("dd/MM/yyyy").parse(ParamUtil.get(arq, Fields.RETURN_DATE, "")));
			loan.setActivityDate(
					new SimpleDateFormat("dd/MM/yyyy").parse(ParamUtil.get(arq, Fields.ACTIVITY_DATE, "")));
			loan.setActivityName(ParamUtil.get(arq, Fields.ACTIVITY_NAME, StringPool.BLANK));
			loan.setParticipantsNum(ParamUtil.get(arq, Fields.PARTICIPANTS, Fields.DEFAULT_PARTICIPANTS));
			loan.setParticipantsKidsNum(ParamUtil.get(arq, Fields.PARTICIPANTS_KIDS, Fields.DEFAULT_PARTICIPANTS_KIDS));
			loan.setDescription(ParamUtil.get(arq, Fields.DESCRIPTION, StringPool.BLANK));
			loan.setContactPerson(ParamUtil.get(arq, Fields.CONTACT_PERSON, StringPool.BLANK));
			loan.setPositionPerson(ParamUtil.get(arq, Fields.POSITION_PERSON, StringPool.BLANK));
			loan.setTelephone(ParamUtil.get(arq, Fields.TELEPHONE, StringPool.BLANK));
			loan.setEmail(ParamUtil.get(arq, Fields.EMAIL, StringPool.BLANK));
			loan.setPmt(ParamUtil.get(arq, Fields.PMT, StringPool.BLANK));
			loan.setStatus(Fields.LoanStatus.NOTCONFIRMED.toString());
			loan.setCompanyId(PortalUtil.getCompanyId(arq));
			loan.setGroupId(PortalUtil.getScopeGroupId(arq));
			loan.setUserId(PortalUtil.getUserId(arq));
			loan.setUserName(PortalUtil.getUserName(PortalUtil.getUserId(arq), StringPool.BLANK));
			loan.setCreateDate(new Date());
			loan.setModifiedDate(new Date());
			LoanLocalServiceUtil.addLoan(loan);
			long[] activities = ParamUtil.getLongValues(arq, Fields.ACTIVITYID);
			int[] quantity = ParamUtil.getIntegerValues(arq, Fields.QUANTITY);
			for (int i = 0; i < activities.length; i++) {
				LoanActivity loanActivity = new LoanActivityLocalServiceUtil().createLoanActivity(0);
				loanActivity.setLoanId(loan.getLoanId());
				loanActivity.setActivityId(activities[i]);
				loanActivity.setQuantity(quantity[i]);
				loanActivity.setCompanyId(PortalUtil.getCompanyId(arq));
				loanActivity.setGroupId(PortalUtil.getScopeGroupId(arq));
				loanActivity.setUserId(PortalUtil.getUserId(arq));
				loanActivity.setUserName(PortalUtil.getUserName(PortalUtil.getUserId(arq), StringPool.BLANK));
				loanActivity.setCreateDate(new Date());
				loanActivity.setModifiedDate(new Date());
				LoanActivityLocalServiceUtil.addLoanActivity(loanActivity);
			}
			PortalUtil.copyRequestParameters(arq, arp);
			arp.getRenderParameters().setValue("loanId", Long.toString(loan.getLoanId()));
			arp.getRenderParameters().setValue("localEntityName",
					LocalEntityLocalServiceUtil.getLocalEntity(localEntity).getName());
			arp.getRenderParameters().setValue("mvcPath", "/html/resume.jsp");
		} else {
			SessionErrors.add(arq, "error-loan-cif");
			PortalUtil.copyRequestParameters(arq, arp);
			arp.getRenderParameters().setValue("mvcPath", "/html/loan.jsp");
		}
	}

	/**
	 * Log de la clase.
	 */
	private static Log LOG = LogFactoryUtil.getLog(PrestecMaterialEsportiuWebPortlet.class);

	private volatile PrestecMaterialEsportiuConfiguration _prestecMaterialEsportiuConfiguration;
}
package cat.diba.materialesportiu.admin.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import cat.diba.materialesportiu.admin.constants.PrestecMaterialEsportiuAdminPortletKeys;

/**
 * @author alberto
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=104",
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
	},
	service = PanelApp.class
)
public class PrestecMaterialEsportiuAdminPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return PrestecMaterialEsportiuAdminPortletKeys.PRESTECMATERIALESPORTIUADMIN;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + PrestecMaterialEsportiuAdminPortletKeys.PRESTECMATERIALESPORTIUADMIN + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}
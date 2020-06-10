package cat.diba.materialesportiu.admin.portlet.display.context.util;

import com.liferay.portal.kernel.display.context.util.BaseRequestHelper;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.RenderRequest;

public class PrestecMaterialEsportiuRequestHelper extends BaseRequestHelper {
	
	public PrestecMaterialEsportiuRequestHelper(RenderRequest renderRequest) {
		super(PortalUtil.getHttpServletRequest(renderRequest));
	}
}

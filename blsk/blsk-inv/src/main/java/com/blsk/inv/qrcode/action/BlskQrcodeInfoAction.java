/**
 * 
 */
package com.blsk.inv.qrcode.action;

import javax.annotation.Resource;

import com.blsk.inv.qrcode.service.BlskQrcodeInfoService;
import com.framework.util.WebAppUtil;
import com.zlxq.rbac.base.core.action.BaseAction;
import com.zlxq.rbac.base.util.QrcodeUtil;
import com.zlxq.rbac.base.util.UserUtil;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskQrcodeInfoAction extends BaseAction {

	@Resource
	private BlskQrcodeInfoService blskQrcodeInfoService;
	
	/**
	 * @TODO 打印执行码
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public String printQrcode() {
		String qrtype = this.getRequest().getParameter("qrtype");
		String path = WebAppUtil.getGetCtxPath();
		Long companyId = UserUtil.getCompanyId();
		String qrcode = this.blskQrcodeInfoService.getQrcodeByCompanyId(companyId, qrtype);
		String serverPath = "http://localhost:8080/web/statics/file/qrcode/qrcode-" +qrtype+ ".png";
		path = path + "/statics/file/qrcode/qrcode-" +qrtype+ ".png";
		QrcodeUtil.createQrcode(qrcode, path);
		setMessage(serverPath);
		System.out.println();
		return SUCCESS;
	}
}

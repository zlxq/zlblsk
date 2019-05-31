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
		String path = WebAppUtil.getGetCtxPath();
		Long companyId = UserUtil.getCompanyId();
		String qrcode = this.blskQrcodeInfoService.getQrcodeByCompanyId(companyId);
		path = "c://qrcode//qrcode.png";
		QrcodeUtil.createQrcode(qrcode, path);
		setMessage(path);
		System.out.println();
		return SUCCESS;
	}
}

/**
 * 
 */
package com.blsk.inv.invorder.action;

import javax.annotation.Resource;

import com.blsk.inv.invorder.service.BlskBillDetailService;
import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.action.BaseAction;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskBillDetailAction extends BaseAction {

	@Resource
	private BlskBillDetailService blskBillDetailService;
	
	/**
	 * @TODO 通过单据id查询明细
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2019年6月1日
	 * @version V1.0
	 */
	public String getOrderDetailPage() {
		PagingBean pb = this.getInitPagingBean();
		String orderid = this.getRequest().getParameter("orderid");
		String json = this.blskBillDetailService.getOrderDetailPage(pb, orderid);
		setJsonString(json);
		return SUCCESS;
	}
}

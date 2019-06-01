/**
 * 
 */
package com.blsk.inv.invorder.action;

import javax.annotation.Resource;

import com.blsk.inv.invorder.service.BlskBillInfoService;
import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.action.BaseAction;
import com.zlxq.rbac.base.util.DictUtil;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskBillInfoAction extends BaseAction {
	
	@Resource
	private BlskBillInfoService blskBillInfoService;
	
	/**
	 * @TODO 查询出入库单据信息
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2019年6月1日
	 * @version V1.0
	 */
	public String getRCOrderPage() {
		PagingBean pb = this.getInitPagingBean();
		String orderType = null; //不是盘点类型就是入库或出库单据
		String json = this.blskBillInfoService.getOrderPage(pb, orderType);
		setJsonString(json);
		return SUCCESS;
	}
	
	/**
	 * @TODO 查询盘点
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2019年6月1日
	 * @version V1.0
	 */
	public String getCheckOrderPage() {
		PagingBean pb = this.getInitPagingBean();
		String orderType = DictUtil.invOrder_lx.invOrder_pd;
		String json = this.blskBillInfoService.getOrderPage(pb, orderType);
		setJsonString(json);
		return SUCCESS;
	}
	
	/**
	 * @TODO 下发出入库单据
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2019年6月1日
	 * @version V1.0
	 */
	public String nextRCOrder() {
		String ids = this.getRequest().getParameter("ids");
		String msg = this.blskBillInfoService.nextRCOrder(ids);
		setMessage(msg);
		return SUCCESS;
	}

}

/**
 * 
 */
package com.blsk.inv.invorder.service;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.service.BaseService;

import pojo.BlskBillInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public interface BlskBillInfoService extends BaseService<BlskBillInfo> {

	/**
	 * @TODO 查询出入库、盘点单据信息
	 * @author zhangl
	 *
	 * @param pb
	 * @param orderType
	 * @return
	 * @createtime 2019年6月1日
	 * @version V1.0
	 */
	String getOrderPage(PagingBean pb, String orderType);

	/**
	 * @TODO 下发出入库单据
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2019年6月1日
	 * @version V1.0
	 */
	String nextRCOrder(String ids);

}

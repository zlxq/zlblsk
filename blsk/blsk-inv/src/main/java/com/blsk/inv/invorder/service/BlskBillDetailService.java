/**
 * 
 */
package com.blsk.inv.invorder.service;

import java.util.List;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.service.BaseService;

import pojo.BlskBillDetail;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public interface BlskBillDetailService extends BaseService<BlskBillDetail> {

	/**
	 * @TODO 通过单据id查询明细
	 * @author zhangl
	 *
	 * @param pb
	 * @param orderid
	 * @return
	 * @createtime 2019年6月1日
	 * @version V1.0
	 */
	String getOrderDetailPage(PagingBean pb, String orderid);

	/**
	 * @TODO 通过订单id 查询明细list对象
	 * @author zhangl
	 *
	 * @param id
	 * @return
	 * @createtime 2019年6月2日
	 * @version V1.0
	 */
	List<BlskBillDetail> getDetailByOrderid(Long id);

}

/**
 * 
 */
package com.blsk.inv.invorder.dao;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.dao.BaseDao;

import pojo.BlskBillInfo;

import pojo.BlskBillInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public interface BlskBillInfoDao extends BaseDao<BlskBillInfo> {

	/**
	 * @TODO 查询出入库、盘点单据
	 * @author zhangl
	 *
	 * @param pb
	 * @param orderType
	 * @return
	 * @createtime 2019年6月1日
	 * @version V1.0
	 */
	String getOrderPage(PagingBean pb, String orderType);

}

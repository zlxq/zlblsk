/**
 * 
 */
package com.blsk.inv.invorder.dao.impl;

import com.blsk.inv.invorder.dao.BlskBillDetailDao;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;

import pojo.BlskBillDetail;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskBillDetailDaoImpl extends BaseDaoImpl<BlskBillDetail> implements BlskBillDetailDao {

	/**
	 * @author zhangl
	 *
	 * @param persistType
	 *
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public BlskBillDetailDaoImpl() {
		super(BlskBillDetail.class);
	}

}

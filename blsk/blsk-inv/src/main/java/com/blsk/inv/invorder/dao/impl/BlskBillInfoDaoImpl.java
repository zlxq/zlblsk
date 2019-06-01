/**
 * 
 */
package com.blsk.inv.invorder.dao.impl;

import com.blsk.inv.invorder.dao.BlskBillInfoDao;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;

import pojo.BlskBillInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskBillInfoDaoImpl extends BaseDaoImpl<BlskBillInfo> implements BlskBillInfoDao {

	/**
	 * @author zhangl
	 *
	 * @param persistType
	 *
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public BlskBillInfoDaoImpl() {
		super(BlskBillInfo.class);
	}

}

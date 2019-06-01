/**
 * 
 */
package com.blsk.inv.invorder.service.impl;

import java.io.Serializable;

import com.blsk.inv.invorder.dao.BlskBillDetailDao;
import com.blsk.inv.invorder.service.BlskBillDetailService;
import com.framework.web.ssh.dao.GenericDao;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;

import pojo.BlskBillDetail;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskBillDetailServiceImpl extends BaseServiceImpl<BlskBillDetail> implements BlskBillDetailService {

	private BlskBillDetailDao blskBillDetailDao;
	
	/**
	 * @author zhangl
	 *
	 * @param dao
	 *
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public BlskBillDetailServiceImpl(BlskBillDetailDao blskBillDetailDao) {
		super(blskBillDetailDao);
		this.blskBillDetailDao = blskBillDetailDao;
	}

}

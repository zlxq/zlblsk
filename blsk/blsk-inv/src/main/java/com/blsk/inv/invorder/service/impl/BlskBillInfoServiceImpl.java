/**
 * 
 */
package com.blsk.inv.invorder.service.impl;

import java.io.Serializable;

import com.blsk.inv.invorder.dao.BlskBillInfoDao;
import com.blsk.inv.invorder.service.BlskBillInfoService;
import com.framework.web.ssh.dao.GenericDao;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;

import pojo.BlskBillInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskBillInfoServiceImpl extends BaseServiceImpl<BlskBillInfo> implements BlskBillInfoService {

	private BlskBillInfoDao blskBillInfoDao;
	
	/**
	 * @author zhangl
	 *
	 * @param dao
	 *
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public BlskBillInfoServiceImpl(BlskBillInfoDao blskBillInfoDao) {
		super(blskBillInfoDao);
		this.blskBillInfoDao = blskBillInfoDao;
	}

}

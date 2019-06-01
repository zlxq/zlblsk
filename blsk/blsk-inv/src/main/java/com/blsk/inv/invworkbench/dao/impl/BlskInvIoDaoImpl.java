/**
 * 
 */
package com.blsk.inv.invworkbench.dao.impl;

import com.blsk.inv.invworkbench.dao.BlskInvIoDao;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;

import pojo.BlskInvIo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskInvIoDaoImpl extends BaseDaoImpl<BlskInvIo> implements BlskInvIoDao {

	/**
	 * @author zhangl
	 *
	 * @param persistType
	 *
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public BlskInvIoDaoImpl() {
		super(BlskInvIo.class);
	}

}

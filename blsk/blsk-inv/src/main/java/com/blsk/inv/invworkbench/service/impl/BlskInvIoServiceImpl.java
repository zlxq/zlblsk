/**
 * 
 */
package com.blsk.inv.invworkbench.service.impl;

import java.io.Serializable;

import com.blsk.inv.invworkbench.dao.BlskInvIoDao;
import com.blsk.inv.invworkbench.service.BlskInvIoService;
import com.framework.web.ssh.dao.GenericDao;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;

import pojo.BlskInvIo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskInvIoServiceImpl extends BaseServiceImpl<BlskInvIo> implements BlskInvIoService {

	private BlskInvIoDao blskInvIoDao;
	
	/**
	 * @author zhangl
	 *
	 * @param dao
	 *
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public BlskInvIoServiceImpl(BlskInvIoDao blskInvIoDao) {
		super(blskInvIoDao);
		this.blskInvIoDao = blskInvIoDao;
	}

}

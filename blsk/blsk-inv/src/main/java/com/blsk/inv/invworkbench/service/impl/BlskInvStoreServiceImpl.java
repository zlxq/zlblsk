/**
 * 
 */
package com.blsk.inv.invworkbench.service.impl;

import java.io.Serializable;

import com.blsk.inv.invworkbench.dao.BlskInvStoreDao;
import com.blsk.inv.invworkbench.service.BlskInvStoreService;
import com.framework.web.ssh.dao.GenericDao;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;

import pojo.BlskInvStore;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskInvStoreServiceImpl extends BaseServiceImpl<BlskInvStore> implements BlskInvStoreService {

	private BlskInvStoreDao blskInvStoreDao;
	
	/**
	 * @author zhangl
	 *
	 * @param dao
	 *
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public BlskInvStoreServiceImpl(BlskInvStoreDao blskInvStoreDao) {
		super(blskInvStoreDao);
		this.blskInvStoreDao = blskInvStoreDao;
	}

}

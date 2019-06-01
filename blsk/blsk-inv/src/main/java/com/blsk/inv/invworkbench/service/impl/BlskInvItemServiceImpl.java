/**
 * 
 */
package com.blsk.inv.invworkbench.service.impl;

import java.io.Serializable;

import com.blsk.inv.invworkbench.dao.BlskInvItemDao;
import com.blsk.inv.invworkbench.service.BlskInvItemService;
import com.framework.web.ssh.dao.GenericDao;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;

import pojo.BlskInvItem;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskInvItemServiceImpl extends BaseServiceImpl<BlskInvItem> implements BlskInvItemService {

	private BlskInvItemDao blskInvItemDao;
	
	/**
	 * @author zhangl
	 *
	 * @param dao
	 *
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public BlskInvItemServiceImpl(BlskInvItemDao blskInvItemDao) {
		super(blskInvItemDao);
		this.blskInvItemDao = blskInvItemDao;
	}

}

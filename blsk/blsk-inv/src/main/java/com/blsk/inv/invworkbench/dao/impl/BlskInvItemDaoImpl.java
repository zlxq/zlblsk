/**
 * 
 */
package com.blsk.inv.invworkbench.dao.impl;

import com.blsk.inv.invworkbench.dao.BlskInvItemDao;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;

import pojo.BlskInvItem;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskInvItemDaoImpl extends BaseDaoImpl<BlskInvItem> implements BlskInvItemDao {

	/**
	 * @author zhangl
	 *
	 * @param persistType
	 *
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public BlskInvItemDaoImpl() {
		super(BlskInvItem.class);
	}

}

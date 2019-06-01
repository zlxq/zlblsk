/**
 * 
 */
package com.blsk.inv.invworkbench.dao.impl;

import com.blsk.inv.invworkbench.dao.BlskInvStoreDao;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;

import pojo.BlskInvStore;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskInvStoreDaoImpl extends BaseDaoImpl<BlskInvStore> implements BlskInvStoreDao {

	/**
	 * @author zhangl
	 *
	 * @param persistType
	 *
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public BlskInvStoreDaoImpl() {
		super(BlskInvStore.class);
	}

}

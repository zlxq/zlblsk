package com.blsk.inv.space.dao.impl;

import com.blsk.inv.space.dao.BlskInvItemDao;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;

import pojo.BlskInvItem;

public class BlskInvItemDaoImpl extends BaseDaoImpl<BlskInvItem> implements BlskInvItemDao {

	public BlskInvItemDaoImpl() {
		super(BlskInvItem.class);
	}
}

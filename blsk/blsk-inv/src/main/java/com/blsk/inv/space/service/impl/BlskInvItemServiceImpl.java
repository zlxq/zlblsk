package com.blsk.inv.space.service.impl;

import com.blsk.inv.space.dao.BlskInvItemDao;
import com.blsk.inv.space.service.BlskInvItemService;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;

import pojo.BlskInvItem;

public class BlskInvItemServiceImpl extends BaseServiceImpl<BlskInvItem> implements BlskInvItemService {

	private BlskInvItemDao blskInvItemDao;
	public BlskInvItemServiceImpl(BlskInvItemDao blskInvItemDao) {
		super(blskInvItemDao);
		this.blskInvItemDao = blskInvItemDao;
	}

}

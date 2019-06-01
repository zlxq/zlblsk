package com.blsk.inv.space.service.impl;

import com.blsk.inv.space.dao.BlskSpacePropertyDao;
import com.blsk.inv.space.service.BlskSpacePropertyService;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;

import pojo.BlskSpaceProperty;

public class BlskSpacePropertyServiceImpl extends BaseServiceImpl<BlskSpaceProperty> implements BlskSpacePropertyService {

	private BlskSpacePropertyDao blskSpacePropertyeDao;
	public BlskSpacePropertyServiceImpl(BlskSpacePropertyDao blskSpacePropertyeDao) {
		super(blskSpacePropertyeDao);
		this.blskSpacePropertyeDao = blskSpacePropertyeDao;
	}

}

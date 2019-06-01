package com.blsk.inv.space.service.impl;

import com.blsk.inv.space.dao.BlskSpaceAddressDao;
import com.blsk.inv.space.service.BlskSpaceAddressService;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;

import pojo.BlskSpaceAddress;

public class BlskSpaceAddressServiceImpl extends BaseServiceImpl<BlskSpaceAddress> implements BlskSpaceAddressService {

	private BlskSpaceAddressDao blskSpaceAddressDao;
	public BlskSpaceAddressServiceImpl(BlskSpaceAddressDao blskSpaceAddressDao) {
		super(blskSpaceAddressDao);
		this.blskSpaceAddressDao = blskSpaceAddressDao;
	}

}

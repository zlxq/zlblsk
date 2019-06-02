package com.blsk.inv.space.service.impl;

import com.blsk.inv.space.dao.BlskSpaceEquipDao;
import com.blsk.inv.space.service.BlskSpaceEquipService;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;

import pojo.BlskSpaceEquip;

public class BlskSpaceEquipServiceImpl extends BaseServiceImpl<BlskSpaceEquip> implements BlskSpaceEquipService {

	private BlskSpaceEquipDao blskSpaceEquipDao;
	public BlskSpaceEquipServiceImpl(BlskSpaceEquipDao blskSpaceEquipDao) {
		super(blskSpaceEquipDao);
		this.blskSpaceEquipDao = blskSpaceEquipDao;
	}

}

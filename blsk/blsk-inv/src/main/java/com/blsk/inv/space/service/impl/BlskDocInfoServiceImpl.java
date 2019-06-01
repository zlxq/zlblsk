package com.blsk.inv.space.service.impl;

import com.blsk.inv.space.dao.BlskDocInfoDao;
import com.blsk.inv.space.service.BlskDocInfoService;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;

import pojo.BlskDocInfo;

public class BlskDocInfoServiceImpl extends BaseServiceImpl<BlskDocInfo> implements BlskDocInfoService {

	private BlskDocInfoDao blskDocInfoDao;
	public BlskDocInfoServiceImpl(BlskDocInfoDao blskDocInfoDao) {
		super(blskDocInfoDao);
		this.blskDocInfoDao = blskDocInfoDao;
	}

}

package com.blsk.inv.space.service.impl;

import com.blsk.inv.space.dao.BlskSpaceFileDao;
import com.blsk.inv.space.service.BlskSpaceFileService;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;

import pojo.BlskSpaceFile;

public class BlskSpaceFileServiceImpl extends BaseServiceImpl<BlskSpaceFile> implements BlskSpaceFileService {

	private BlskSpaceFileDao blskSpaceFileDao;
	public BlskSpaceFileServiceImpl(BlskSpaceFileDao blskSpaceFileDao) {
		super(blskSpaceFileDao);
		this.blskSpaceFileDao = blskSpaceFileDao;
	}

}

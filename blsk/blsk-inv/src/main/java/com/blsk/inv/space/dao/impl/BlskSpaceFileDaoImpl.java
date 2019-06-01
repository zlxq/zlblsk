package com.blsk.inv.space.dao.impl;

import com.blsk.inv.space.dao.BlskSpaceFileDao;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;

import pojo.BlskSpaceFile;

public class BlskSpaceFileDaoImpl extends BaseDaoImpl<BlskSpaceFile> implements BlskSpaceFileDao {

	public BlskSpaceFileDaoImpl() {
		super(BlskSpaceFile.class);
	}
}

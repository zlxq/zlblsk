package com.blsk.inv.space.dao.impl;

import com.blsk.inv.space.dao.BlskSpacePropertyDao;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;

import pojo.BlskSpaceProperty;

public class BlskSpacePropertyDaoImpl extends BaseDaoImpl<BlskSpaceProperty> implements BlskSpacePropertyDao {

	public BlskSpacePropertyDaoImpl() {
		super(BlskSpaceProperty.class);
	}
}

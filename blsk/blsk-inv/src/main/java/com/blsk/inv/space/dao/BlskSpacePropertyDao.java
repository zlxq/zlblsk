package com.blsk.inv.space.dao;

import com.zlxq.rbac.base.core.dao.BaseDao;

import pojo.BlskSpaceProperty;

public abstract interface BlskSpacePropertyDao extends BaseDao<BlskSpaceProperty> {

	BlskSpaceProperty getProperty(Long id, String materialId, String runCode, String inStoreRule);
}

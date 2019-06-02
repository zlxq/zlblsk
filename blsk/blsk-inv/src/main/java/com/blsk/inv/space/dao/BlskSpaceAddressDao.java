package com.blsk.inv.space.dao;

import com.zlxq.rbac.base.core.dao.BaseDao;

import pojo.BlskSpaceAddress;

public abstract interface BlskSpaceAddressDao extends BaseDao<BlskSpaceAddress> {

	String getSpaceAddress();
}

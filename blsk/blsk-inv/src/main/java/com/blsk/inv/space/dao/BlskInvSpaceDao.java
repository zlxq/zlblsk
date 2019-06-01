package com.blsk.inv.space.dao;

import java.util.List;

import com.zlxq.rbac.base.core.dao.BaseDao;

import pojo.BlskInvSpace;

public abstract interface BlskInvSpaceDao extends BaseDao<BlskInvSpace> {

	BlskInvSpace getSpaceUnit(Long pid, String storeRoom, String storeRoom_unit);

	BlskInvSpace getSpace(String storeRoom);

	BlskInvSpace getInvColumn(String rect, Long unitid, String type);

}

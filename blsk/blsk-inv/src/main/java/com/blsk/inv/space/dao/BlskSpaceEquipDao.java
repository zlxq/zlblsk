package com.blsk.inv.space.dao;

import com.zlxq.rbac.base.core.dao.BaseDao;

import pojo.BlskInvSpace;
import pojo.BlskSpaceEquip;

public abstract interface BlskSpaceEquipDao extends BaseDao<BlskSpaceEquip> {

	BlskSpaceEquip getSpaceEquip(BlskInvSpace spaceEntry, BlskInvSpace unitEntry, String equipId, String lor);
}

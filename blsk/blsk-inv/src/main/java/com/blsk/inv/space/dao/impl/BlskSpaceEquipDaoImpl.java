package com.blsk.inv.space.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.blsk.inv.space.dao.BlskSpaceEquipDao;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;

import pojo.BlskInvSpace;
import pojo.BlskSpaceEquip;

public class BlskSpaceEquipDaoImpl extends BaseDaoImpl<BlskSpaceEquip> implements BlskSpaceEquipDao {

	public BlskSpaceEquipDaoImpl() {
		super(BlskSpaceEquip.class);
	}

	@Override
	public BlskSpaceEquip getSpaceEquip(BlskInvSpace spaceEntry, BlskInvSpace unitEntry, String equipId, String lor) {
		String hql = "select t from BlskSpaceEquip t where t.isvalidate = '1'";
		
		if (spaceEntry != null) {
			hql += " and t.blskInvSpace.id = " + spaceEntry.getId() + "";
		}
		if (unitEntry != null) {
			hql += " and t.unitid = " + unitEntry.getId() + "";
		}
		if (StringUtils.isNotEmpty(equipId)) {
			hql += " and t.blskEquipInfo.id = '" + equipId + "'";
		}
		if (StringUtils.isNotEmpty(lor)) {
			hql += " and t.lor = '" + lor + "'";
		}
		@SuppressWarnings("unchecked")
		List<BlskSpaceEquip> list = (List<BlskSpaceEquip>) findByHQL(hql);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}

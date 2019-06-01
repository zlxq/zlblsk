package com.blsk.inv.space.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.blsk.inv.space.dao.BlskInvSpaceDao;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;

import pojo.BlskInvSpace;

public class BlskInvSpaceDaoImpl extends BaseDaoImpl<BlskInvSpace> implements BlskInvSpaceDao {

	public BlskInvSpaceDaoImpl() {
		super(BlskInvSpace.class);
	}

	@Override
	public BlskInvSpace getSpaceUnit(Long pid, String storeRoom, String storeRoom_unit) {
		String hql = "select t from BlskInvSpace t where t.isvalidate = '1' and t.type = '单元'";
		
		if (pid != 0) {
			hql += " and t.blskInvSpace.id = " + pid + "";
		}
		if (StringUtils.isNotEmpty(storeRoom)) {
			hql += " and t.sapceName = '" + storeRoom + "'";
		}
		if (StringUtils.isNotEmpty(storeRoom_unit)) {
			hql += " and t.name = '" + storeRoom_unit + "'";
		}
		@SuppressWarnings("unchecked")
		List<BlskInvSpace> list = (List<BlskInvSpace>) findByHQL(hql);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public BlskInvSpace getSpace(String storeRoom) {
		String hql = "select t from BlskInvSpace t where t.isvalidate = '1' and t.type = '库房'";
		
		if (StringUtils.isNotEmpty(storeRoom)) {
			hql += " and t.name = '" + storeRoom + "'";
		}
		@SuppressWarnings("unchecked")
		List<BlskInvSpace> list = (List<BlskInvSpace>) findByHQL(hql);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public BlskInvSpace getInvColumn(String rect, Long unitid, String type) {
		String hql = "select t from BlskInvSpace t where t.isvalidate = '1'";
		
		if (StringUtils.isNotEmpty(rect)) {
			hql += " and t.svgid = '" + rect + "'";
		}
		if (unitid != 0) {
			hql += " and t.blskInvSpace.id = " + unitid + "";
		}
		if (StringUtils.isNotEmpty(type)) {
			hql += " and t.type = '" + type + "'";
		}
		@SuppressWarnings("unchecked")
		List<BlskInvSpace> list = (List<BlskInvSpace>) findByHQL(hql);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}


}

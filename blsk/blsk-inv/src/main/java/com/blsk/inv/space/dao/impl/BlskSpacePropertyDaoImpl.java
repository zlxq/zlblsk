package com.blsk.inv.space.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.blsk.inv.space.dao.BlskSpacePropertyDao;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;

import pojo.BlskInvSpace;
import pojo.BlskSpaceProperty;

public class BlskSpacePropertyDaoImpl extends BaseDaoImpl<BlskSpaceProperty> implements BlskSpacePropertyDao {

	public BlskSpacePropertyDaoImpl() {
		super(BlskSpaceProperty.class);
	}

	@Override
	public BlskSpaceProperty getProperty(Long id, String materialId, String runCode, String inStoreRule) {
		String hql = "select t from BlskSpaceProperty t where t.isvalidate = '"+ ConstantRBAC.Y_ISVALIDATE +"'";
		
		if (id != 0) {
			hql += " and t.blskInvSpace.id = " + id + "";
		}
		if (StringUtils.isNotEmpty(materialId)) {
			hql += " and t.materialid = '" + materialId + "'";
		}
		if (StringUtils.isNotEmpty(runCode)) {
			hql += " and t.runcode = '" + runCode + "'";
		}
		if (StringUtils.isNotEmpty(inStoreRule)) {
			hql += " and t.storerule = '" + inStoreRule + "'";
		}
		@SuppressWarnings("unchecked")
		List<BlskSpaceProperty> list = (List<BlskSpaceProperty>) findByHQL(hql);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}

package com.zlxq.rbac.role.service.impl;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.role.dao.ZlxqRoleDao;
import com.zlxq.rbac.role.service.ZlxqRoleService;

import pojo.ZlxqRole;

public class ZlxqRoleServiceImpl extends BaseServiceImpl<ZlxqRole> implements ZlxqRoleService {

	private ZlxqRoleDao zlxqRoleDao;

	public ZlxqRoleServiceImpl(ZlxqRoleDao zlxqRoleDao) {
		super(zlxqRoleDao);
		this.zlxqRoleDao = zlxqRoleDao;
		// TODO Auto-generated constructor stub
	}

	@Override
	public ZlxqRole findByRoleType(String roletype) {
		return this.zlxqRoleDao.findByRoleType(roletype);
	}

	@Override
	public String getRoleInfo(PagingBean pb) {
		return this.zlxqRoleDao.getRoleInfo(pb);
	}

}

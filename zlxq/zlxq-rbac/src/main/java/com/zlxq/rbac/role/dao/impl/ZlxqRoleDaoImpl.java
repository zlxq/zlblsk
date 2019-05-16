package com.zlxq.rbac.role.dao.impl;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.role.dao.ZlxqRoleDao;

import pojo.ZlxqRole;

public class ZlxqRoleDaoImpl extends BaseDaoImpl<ZlxqRole> implements ZlxqRoleDao {

	public ZlxqRoleDaoImpl() {
		super(ZlxqRole.class);
	}

	@Override
	public ZlxqRole findByRoleType(String roletype) {
		String hql = "select t from ZlxqRole t where t.roletype = '"+roletype+"' and t.isvalidate = '1'";
		return (ZlxqRole) findByHQL(hql).get(0);
	}

	@Override
	public String getRoleInfo(PagingBean pb) {
		String sql = "SELECT zr.id, zr.roleno, zr.rolename, zr.roletype FROM zlxq_role zr WHERE isvalidate = '1' and roleno <> '001'";
		return findByJDBCReturnJSON(sql);
	}

}

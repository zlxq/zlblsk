package com.zlxq.rbac.rolemenu.dao.impl;

import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.rolemenu.dao.ZlxqRoleMenuDao;

import pojo.ZlxqRoleMenu;


public class ZlxqRoleMenuDaoImpl extends BaseDaoImpl<ZlxqRoleMenu> implements ZlxqRoleMenuDao {

	public ZlxqRoleMenuDaoImpl() {
		super(ZlxqRoleMenu.class);
	}

	@Override
	public void delRoleAllMenuByRoleid(long rid) {
		String sql = "DELETE FROM zlxq_role_menu WHERE role_id = "+rid+" AND isvalidate = '1'";
		this.jdbcTemplate.execute(sql);
	}

}

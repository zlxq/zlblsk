package com.zlxq.rbac.rolemenu.dao;

import com.zlxq.rbac.base.core.dao.BaseDao;

import pojo.ZlxqRoleMenu;

public interface ZlxqRoleMenuDao extends BaseDao<ZlxqRoleMenu> {

	/**
	 * 删除当前角色底下所有菜单
	 * @author zhangl
	 *
	 * @param rid
	 * @createtime 2017年7月15日
	 * @version V1.0
	 */
	void delRoleAllMenuByRoleid(long rid);

}

package com.zlxq.rbac.rolemenu.service;

import com.zlxq.rbac.base.core.service.BaseService;

import pojo.ZlxqRoleMenu;

public interface ZlxqRoleMenuService extends BaseService<ZlxqRoleMenu> {

	/**
	 * 保存角色菜单权限
	 * @author zhangl
	 *
	 * @param roleid
	 * @param selFuns
	 * @return
	 * @createtime 2017年7月15日
	 * @version V1.0
	 */
	String saveRoleMenu(String roleid, String selFuns);

}

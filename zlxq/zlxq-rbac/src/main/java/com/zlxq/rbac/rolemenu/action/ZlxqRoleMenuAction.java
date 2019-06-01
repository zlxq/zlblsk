package com.zlxq.rbac.rolemenu.action;

import javax.annotation.Resource;

import com.zlxq.rbac.base.core.action.BaseAction;
import com.zlxq.rbac.rolemenu.service.ZlxqRoleMenuService;

import pojo.ZlxqMenu;
import pojo.ZlxqRole;

public class ZlxqRoleMenuAction extends BaseAction {
	private ZlxqRole zlxqRole;
	private ZlxqMenu zlxqMenu;
	@Resource
	private ZlxqRoleMenuService roleMenuService;

	public String saveRoleMenu() {
		return SUCCESS;
	}

	public ZlxqRole getZlxqRole() {
		return zlxqRole;
	}

	public void setZlxqRole(ZlxqRole zlxqRole) {
		this.zlxqRole = zlxqRole;
	}

	public ZlxqMenu getZlxqMenu() {
		return zlxqMenu;
	}

	public void setZlxqMenu(ZlxqMenu zlxqMenu) {
		this.zlxqMenu = zlxqMenu;
	}
}

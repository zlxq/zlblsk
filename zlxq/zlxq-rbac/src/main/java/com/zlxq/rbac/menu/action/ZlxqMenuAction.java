package com.zlxq.rbac.menu.action;

import javax.annotation.Resource;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.action.BaseAction;
import com.zlxq.rbac.menu.service.ZlxqMenuService;

import pojo.ZlxqMenu;

public class ZlxqMenuAction extends BaseAction {
	
	@Resource
	private ZlxqMenuService zlxqMenuService;
	
	public ZlxqMenu zlxqMenu;

	public String getMenuPage() {
		PagingBean pb = this.getInitPagingBean();
		String json = this.zlxqMenuService.getMenuPage(pb);
		setJsonString(json);
		return SUCCESS;
	}
	
	public String getMenuTree() {
		String id = this.getRequest().getParameter("id");
		String json = this.zlxqMenuService.getMenuTree(id);
		setJsonString(json);
		return SUCCESS;
	}
	
	public String saveMenuInfo() {
		String pid = this.getRequest().getParameter("pid");
		String menuid = this.getRequest().getParameter("menuid");
		String msg = this.zlxqMenuService.saveMenuInfo(this.zlxqMenu, menuid, pid);
		setMessage(msg);
		return SUCCESS;
	}
	
	public String delMenu() {
		String id = this.getRequest().getParameter("id");
		String msg = this.zlxqMenuService.delMenu(id);
		setMessage(msg);
		return SUCCESS;
	}
	
	public String getRoleMenu() {
		String id = this.getRequest().getParameter("id");
		String json = this.zlxqMenuService.getRoleMenu(id);
		setJsonString(json);
		return SUCCESS;
	}
	
	public String getNoRoleMenu() {
		String id = this.getRequest().getParameter("id");
		String json = this.zlxqMenuService.getNoRoleMenu(id);
		setJsonString(json);
		return SUCCESS;
	}
	
	public String saveRoleMenu() {
		String roleid = this.getRequest().getParameter("roleid");
		String selFuns = this.getRequest().getParameter("selFuns");
		String msg = this.zlxqMenuService.saveRoleMenu(roleid, selFuns);
		setMessage(msg);
		return SUCCESS;
	}
	
	public ZlxqMenu getZlxqMenu() {
		return zlxqMenu;
	}

	public void setZlxqMenu(ZlxqMenu zlxqMenu) {
		this.zlxqMenu = zlxqMenu;
	}
}

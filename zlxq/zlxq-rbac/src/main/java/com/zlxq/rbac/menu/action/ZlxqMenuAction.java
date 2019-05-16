/**
 * @Title: ZlxqMenuAction.java
 * @Package: com.rbac.menu.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: PUB
 * @date: 2019年5月2日 下午12:39:35
 * @version V1.0
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 */
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

	/**
	 * @MethodName: getMenuPage
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月6日 上午2:43:45
	 * @return
	 * @return: String
	 * @throws
	 */
	public String getMenuPage() {
		PagingBean pb = this.getInitPagingBean();
		String json = this.zlxqMenuService.getMenuPage(pb);
		setJsonString(json);
		return SUCCESS;
	}
	
	/**
	 * @MethodName: getMenuTree
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月6日 上午2:48:26
	 * @return
	 * @return: String
	 * @throws
	 */
	public String getMenuTree() {
		String id = this.getRequest().getParameter("id");
		String json = this.zlxqMenuService.getMenuTree(id);
		setJsonString(json);
		return SUCCESS;
	}
	
	/**
	 * @MethodName: saveMenuInfo
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月6日 上午2:50:38
	 * @return
	 * @return: String
	 * @throws
	 */
	public String saveMenuInfo() {
		String pid = this.getRequest().getParameter("pid");
		String menuid = this.getRequest().getParameter("menuid");
		String msg = this.zlxqMenuService.saveMenuInfo(this.zlxqMenu, menuid, pid);
		setMessage(msg);
		return SUCCESS;
	}
	
	/**
	 * @MethodName: delMenu
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月6日 上午2:54:07
	 * @return
	 * @return: String
	 * @throws
	 */
	public String delMenu() {
		String id = this.getRequest().getParameter("id");
		String msg = this.zlxqMenuService.delMenu(id);
		setMessage(msg);
		return SUCCESS;
	}
	
	/**
	 * 查询角色菜单
	 * 
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2017年7月12日
	 * @version V1.0
	 */
	public String getRoleMenu() {
		String id = this.getRequest().getParameter("id");
		String json = this.zlxqMenuService.getRoleMenu(id);
		setJsonString(json);
		return SUCCESS;
	}
	
	/**
	 * 查询未被授权的角色菜单
	 * 
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2017年7月12日
	 * @version V1.0
	 */
	public String getNoRoleMenu() {
		String id = this.getRequest().getParameter("id");
		String json = this.zlxqMenuService.getNoRoleMenu(id);
		setJsonString(json);
		return SUCCESS;
	}
	
	public ZlxqMenu getZlxqMenu() {
		return zlxqMenu;
	}

	public void setZlxqMenu(ZlxqMenu zlxqMenu) {
		this.zlxqMenu = zlxqMenu;
	}
}

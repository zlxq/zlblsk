package com.zlxq.rbac.role.action;

import javax.annotation.Resource;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.action.BaseAction;
import com.zlxq.rbac.role.service.ZlxqRoleService;

import pojo.ZlxqRole;

public class ZlxqRoleAction extends BaseAction {

	@Resource
	private ZlxqRoleService zlxqRoleService;
	
	private ZlxqRole zlxqRole;
	
	/**
	 * @TODO 查询角色信息
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2017年7月11日
	 * @version V1.0
	 */
	public String getRoleInfo() {
		PagingBean pb = this.getInitPagingBean();
		String json = this.zlxqRoleService.getRoleInfo(pb);
		setJsonString(json);
		return SUCCESS;
	}
	
	/**
	 * @TODO 保存角色
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2019年5月21日
	 * @version V1.0
	 */
	public String saveRole() {
		String msg = this.zlxqRoleService.saveRole(this.zlxqRole);
		setMessage(msg);
		return SUCCESS;
	}

	/**
	 * @return the zlxqRole
	 */
	public ZlxqRole getZlxqRole() {
		return zlxqRole;
	}

	/**
	 * @param zlxqRole the zlxqRole to set
	 */
	public void setZlxqRole(ZlxqRole zlxqRole) {
		this.zlxqRole = zlxqRole;
	}
}

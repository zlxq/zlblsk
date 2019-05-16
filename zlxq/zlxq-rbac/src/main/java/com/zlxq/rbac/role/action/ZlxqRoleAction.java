package com.zlxq.rbac.role.action;

import javax.annotation.Resource;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.action.BaseAction;
import com.zlxq.rbac.role.service.ZlxqRoleService;

public class ZlxqRoleAction extends BaseAction {

	@Resource
	private ZlxqRoleService zlxqRoleService;
	
	/**
	 * 查询角色信息
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
}

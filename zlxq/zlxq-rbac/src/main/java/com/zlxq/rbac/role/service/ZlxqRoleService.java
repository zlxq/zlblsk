package com.zlxq.rbac.role.service;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.service.BaseService;

import pojo.ZlxqRole;

public abstract interface ZlxqRoleService extends BaseService<ZlxqRole> {

	/**
	 * 通过角色类型查询角色对象
	 * @author zhangl
	 *
	 * @param roletype
	 * @return
	 * @createtime 2017年7月10日
	 * @version V1.0
	 */
	ZlxqRole findByRoleType(String roletype);

	/**
	 * @TODO查询角色信息
	 * @author zhangl
	 *
	 * @param pb
	 * @return
	 * @createtime 2017年7月11日
	 * @version V1.0
	 */
	String getRoleInfo(PagingBean pb);

	/**
	 * @TODO 保存角色
	 * @author zhangl
	 *
	 * @param zlxqRole
	 * @return
	 * @createtime 2019年5月21日
	 * @version V1.0
	 */
	String saveRole(ZlxqRole zlxqRole);

}

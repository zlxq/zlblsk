package com.zlxq.rbac.role.dao;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.dao.BaseDao;

import pojo.ZlxqRole;

public abstract interface ZlxqRoleDao extends  BaseDao<ZlxqRole> {

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
	 * 查询角色信息
	 * @author zhangl
	 *
	 * @param pb
	 * @return
	 * @createtime 2017年7月11日
	 * @version V1.0
	 */
	String getRoleInfo(PagingBean pb);

}

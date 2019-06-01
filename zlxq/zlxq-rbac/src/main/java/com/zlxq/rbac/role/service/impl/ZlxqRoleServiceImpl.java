package com.zlxq.rbac.role.service.impl;

import java.util.Date;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;
import com.zlxq.rbac.base.util.UserUtil;
import com.zlxq.rbac.role.dao.ZlxqRoleDao;
import com.zlxq.rbac.role.service.ZlxqRoleService;

import pojo.ZlxqRole;

public class ZlxqRoleServiceImpl extends BaseServiceImpl<ZlxqRole> implements ZlxqRoleService {

	private ZlxqRoleDao zlxqRoleDao;

	public ZlxqRoleServiceImpl(ZlxqRoleDao zlxqRoleDao) {
		super(zlxqRoleDao);
		this.zlxqRoleDao = zlxqRoleDao;
		// TODO Auto-generated constructor stub
	}

	@Override
	public ZlxqRole findByRoleType(String roletype) {
		return this.zlxqRoleDao.findByRoleType(roletype);
	}

	@Override
	public String getRoleInfo(PagingBean pb) {
		return this.zlxqRoleDao.getRoleInfo(pb);
	}

	/* (non-Javadoc)
	 * @see com.zlxq.rbac.role.service.ZlxqRoleService#saveRole(pojo.ZlxqRole)
	 */
	@Override
	public String saveRole(ZlxqRole zlxqRole) {
		zlxqRole.setDeptid(UserUtil.getCompanyId());
		zlxqRole.setCreator(UserUtil.getUserId());
		zlxqRole.setCreatetime(new Date());
		zlxqRole.setIsvalidate(ConstantRBAC.Y_ISVALIDATE);
		try {
			this.zlxqRoleDao.save(zlxqRole);
			return "保存成功";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "保存失败";
	}

}

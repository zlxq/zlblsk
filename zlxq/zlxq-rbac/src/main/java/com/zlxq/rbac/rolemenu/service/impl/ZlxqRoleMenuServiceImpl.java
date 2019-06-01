package com.zlxq.rbac.rolemenu.service.impl;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;

import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.rolemenu.dao.ZlxqRoleMenuDao;
import com.zlxq.rbac.rolemenu.service.ZlxqRoleMenuService;

import pojo.ZlxqMenu;
import pojo.ZlxqRole;
import pojo.ZlxqRoleMenu;

public class ZlxqRoleMenuServiceImpl extends BaseServiceImpl<ZlxqRoleMenu> implements ZlxqRoleMenuService {

	private ZlxqRoleMenuDao zlxqRoleMenuDao;

	public ZlxqRoleMenuServiceImpl(ZlxqRoleMenuDao zlxqRoleMenuDao) {
		super(zlxqRoleMenuDao);
		this.zlxqRoleMenuDao = zlxqRoleMenuDao;
	}

	@Override
	public String saveRoleMenu(String roleid, String selFuns) {
		long rid = Long.parseLong(roleid);
		
		this.zlxqRoleMenuDao.delRoleAllMenuByRoleid(rid);
		
		ZlxqRole zlxqRole = new ZlxqRole();
		zlxqRole.setId(rid);
		
		try {
			ZlxqRoleMenu zlxqRolemenu = null;
			ZlxqMenu zlxqMenu = null;
			JSONArray ja = new JSONArray(selFuns);
			for (int i = 0; i < ja.length(); i++) {
				
				zlxqRolemenu = new ZlxqRoleMenu();
				zlxqMenu = new ZlxqMenu();
				
				long menuid = ja.getLong(i);
				
				zlxqMenu.setId(menuid);
				
				zlxqRolemenu.setZlxqRole(zlxqRole);
				zlxqRolemenu.setZlxqMenu(zlxqMenu);
				zlxqRolemenu.setCreatetime(new Date());
				zlxqRolemenu.setIsvalidate("1");
				this.zlxqRoleMenuDao.save(zlxqRolemenu);
			}
			return "保存成功";
		} catch (JSONException e) {
			e.printStackTrace();
			return "保存失败";
		}
		
	}

}

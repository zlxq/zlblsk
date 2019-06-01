package com.zlxq.rbac.menu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.base.util.DictUtil;
import com.zlxq.rbac.menu.dao.ZlxqMenuDao;
import com.zlxq.rbac.menu.service.ZlxqMenuService;
import com.zlxq.rbac.rolemenu.service.ZlxqRoleMenuService;

import pojo.ZlxqMenu;
public class ZlxqMenuServiceImpl extends BaseServiceImpl<ZlxqMenu> implements ZlxqMenuService {

	private ZlxqMenuDao zlxqMenuDao;
	
	@Resource
	private ZlxqRoleMenuService zlxqRoleMenuService;
	
	public ZlxqMenuServiceImpl(ZlxqMenuDao zlxqMenuDao) {
		super(zlxqMenuDao);
		this.zlxqMenuDao = zlxqMenuDao;
	}

	@Override
	public List<ZlxqMenu> getAllMenu(String userNo, String userType) {
		List<ZlxqMenu> menuList = null;
		if (DictUtil.role_lx.role_super.equals(userType)) {
			menuList = this.zlxqMenuDao.getAllMenu();
		} else {
			menuList =  this.zlxqMenuDao.getMenuByUserNo(userNo);
		}
		
		for (int i = 0; i < menuList.size(); i++) {
			this.getCMenus(menuList.get(i), userNo);
		}
		
		return menuList;
	}

	private void getCMenus(ZlxqMenu zlxqMenu, String userNo) {
		List<ZlxqMenu> menuList = this.zlxqMenuDao.getCMenuByMenuid(zlxqMenu.getId(), userNo);
		
		for (int i = 0; i < menuList.size(); i++) {
			zlxqMenu.setCzlxqMenu(menuList);
			this.getCMenus(menuList.get(i), userNo);
		}
		
		zlxqMenu.setCzlxqMenu(menuList);
	}

	@Override
	public String getMenuPage(PagingBean pb) {
		return this.zlxqMenuDao.getMenuPage(pb);
	}

	@Override
	public String getMenuTree(String id) {
		return this.zlxqMenuDao.getMenuTree(id);
	}

	@Override
	public String saveMenuInfo(ZlxqMenu zlxqMenu, String menuid, String pid) {
		if (!"null".equals(menuid) && StringUtils.isNotEmpty(menuid)) {
			long m = Long.parseLong(menuid);
			ZlxqMenu zm = this.zlxqMenuDao.findByPk(m);
			zm.setMenucode(zlxqMenu.getMenucode());
			zm.setMenuname(zlxqMenu.getMenuname());
			zm.setMenutype(zlxqMenu.getMenutype());
			zm.setMenuurl(zlxqMenu.getMenuurl());
			zm.setMenusort(zlxqMenu.getMenusort());
			zm.setUpdatetime(new Date());
			try {
				this.zlxqMenuDao.save(zm);
				return "保存成功";
			} catch (Exception e) {
				e.printStackTrace();
				return "保存失败";
			}
		}
		if (!"null".equals(pid) && StringUtils.isNotEmpty(pid)) {
			long m = Long.parseLong(pid);
			ZlxqMenu zm = this.zlxqMenuDao.findByPk(m);
			zlxqMenu.setZlxqMenu(zm);
		}
		
		zlxqMenu.setIsleaf("open");
		zlxqMenu.setIconcls("icon-city");
		zlxqMenu.setCreatetime(new Date());
		zlxqMenu.setIsvalidate("1");
		try {
			this.zlxqMenuDao.save(zlxqMenu);
			return "保存成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "保存失败";
		}
	}

	@Override
	public String delMenu(String id) {
		ZlxqMenu zlxqMenu = this.zlxqMenuDao.findByPk(Long.parseLong(id));
		zlxqMenu.setUpdatetime(new Date());
		zlxqMenu.setIsvalidate("0");
		
		try {
			this.zlxqMenuDao.save(zlxqMenu);
			
			return "删除成功";
		} catch (Exception e) {
			// TODO: handle exception
			return "删除失败";
		}
	}

	@Override
	public String getRoleMenu(String id) {
		return this.zlxqMenuDao.getRoleMenu(id);
	}

	@Override
	public String getNoRoleMenu(String id) {
		return this.zlxqMenuDao.getNoRoleMenu(id);
	}

	/* (non-Javadoc)
	 * @see com.zlxq.rbac.menu.service.ZlxqMenuService#saveRoleMenu(java.lang.String, java.lang.String)
	 */
	@Override
	public String saveRoleMenu(String roleid, String selFuns) {
		return this.zlxqRoleMenuService.saveRoleMenu(roleid, selFuns);
	}

}

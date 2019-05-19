/**
 * @Title: ZlxqMenuServiceImpl.java
 * @Package: com.rbac.menu.service.impl
 * @Description: 系统菜单业务层接口实现
 * @author: PUB
 * @date: 2019年5月2日 下午12:43:41
 * @version V1.0
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 */
package com.zlxq.rbac.menu.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.base.util.DictUtil;
import com.zlxq.rbac.menu.dao.ZlxqMenuDao;
import com.zlxq.rbac.menu.service.ZlxqMenuService;

import pojo.ZlxqMenu;
public class ZlxqMenuServiceImpl extends BaseServiceImpl<ZlxqMenu> implements ZlxqMenuService {

	private ZlxqMenuDao zlxqMenuDao;
	
	/**
	 * @Title: ZlxqMenuServiceImpl
	 * @Description: 构造方法注入系统菜单dao层
	 * @param dao
	 * @throws
	 */
	public ZlxqMenuServiceImpl(ZlxqMenuDao zlxqMenuDao) {
		super(zlxqMenuDao);
		this.zlxqMenuDao = zlxqMenuDao;
	}

	/**
	 * @MethodName: getAllMenu
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: PUB
	 * @date: 2019年5月5日 下午3:20:48
	 * @param userno
	 * @param object
	 * @return
	 * @throws
	 */
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


	/**
	 * @MethodName: getMenuPage
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: PUB
	 * @date: 2019年5月6日 上午2:44:31
	 * @param pb
	 * @return
	 * @throws
	 */
	@Override
	public String getMenuPage(PagingBean pb) {
		return this.zlxqMenuDao.getMenuPage(pb);
	}

	/**
	 * @MethodName: getMenuTree
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: PUB
	 * @date: 2019年5月6日 上午2:48:39
	 * @param id
	 * @return
	 * @throws
	 */
	@Override
	public String getMenuTree(String id) {
		return this.zlxqMenuDao.getMenuTree(id);
	}

	/**
	 * @MethodName: saveMenuInfo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: PUB
	 * @date: 2019年5月6日 上午2:52:49
	 * @param zlxqMenu
	 * @param menuid
	 * @param pid
	 * @return
	 * @throws
	 */
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

	/**
	 * @MethodName: delMenu
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: PUB
	 * @date: 2019年5月6日 上午2:54:17
	 * @param id
	 * @return
	 * @throws
	 */
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

	/**
	 * @MethodName: getRoleMenu
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: PUB
	 * @date: 2019年5月17日 上午12:07:03
	 * @param id
	 * @return
	 * @throws
	 */
	@Override
	public String getRoleMenu(String id) {
		return this.zlxqMenuDao.getRoleMenu(id);
	}

	/**
	 * @MethodName: getNoRoleMenu
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: PUB
	 * @date: 2019年5月17日 上午12:10:38
	 * @param id
	 * @return
	 * @throws
	 */
	@Override
	public String getNoRoleMenu(String id) {
		return this.zlxqMenuDao.getNoRoleMenu(id);
	}

}

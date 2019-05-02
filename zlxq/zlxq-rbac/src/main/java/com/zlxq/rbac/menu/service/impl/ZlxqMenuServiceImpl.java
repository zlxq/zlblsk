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

import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.menu.dao.ZlxqMenuDao;
import com.zlxq.rbac.menu.service.ZlxqMenuService;
import com.zlxq.rbac.pojo.ZlxqMenu;
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
	 * <p>Title: getMenuPage</p>
	 * <p>Description: </p>
	 * @see com.zlxq.rbac.menu.service.ZlxqMenuService#getMenuPage()
	 */
	@Override
	public void getMenuPage() {
		
		this.zlxqMenuDao.getMenuPage();
		System.out.println("进入serviceImpl层");
		
	}

}

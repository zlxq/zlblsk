/**
 * @Title: ZlxqMenuDaoImpl.java
 * @Package: com.rbac.menu.dao.impl
 * @Description: 系统菜单持久层接口实现
 * @author: PUB
 * @date: 2019年5月2日 下午12:41:05
 * @version V1.0
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 */
package com.zlxq.rbac.menu.dao.impl;

import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.menu.dao.ZlxqMenuDao;
import com.zlxq.rbac.pojo.ZlxqMenu;

public class ZlxqMenuDaoImpl extends BaseDaoImpl<ZlxqMenu> implements ZlxqMenuDao {

	/**
	 * @Title: ZlxqMenuDaoImpl
	 * @Description: 无参构造方法
	 * @param persistType
	 * @throws
	 */
	public ZlxqMenuDaoImpl() {
		super(ZlxqMenu.class);
	}

	/**
	 * <p>Title: getMenuPage</p>
	 * <p>Description: </p>
	 * @see com.zlxq.rbac.menu.dao.ZlxqMenuDao#getMenuPage()
	 */
	@Override
	public void getMenuPage() {
		System.out.println("进入daoImpl层");
	}

}

/**
 * @Title: ZlxqMenuDao.java
 * @Package: com.rbac.menu.dao
 * @Description: 系统菜单持久层接口
 * @author: PUB
 * @date: 2019年5月2日 下午12:40:41
 * @version V1.0
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 */
package com.zlxq.rbac.menu.dao;

import com.zlxq.rbac.base.core.dao.BaseDao;
import com.zlxq.rbac.pojo.ZlxqMenu;

public interface ZlxqMenuDao extends BaseDao<ZlxqMenu> {

	/**
	 * @MethodName: getMenuPage
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月3日 上午5:43:46
	 * @return: void
	 * @throws
	 */
	void getMenuPage();

}

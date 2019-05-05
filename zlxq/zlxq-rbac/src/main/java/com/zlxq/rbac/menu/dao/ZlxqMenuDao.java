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

import java.util.List;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.dao.BaseDao;

import pojo.ZlxqMenu;

public interface ZlxqMenuDao extends BaseDao<ZlxqMenu> {

	/**
	 * @MethodName: getAllMenu
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月5日 下午3:22:27
	 * @return
	 * @return: List<ZlxqMenu>
	 * @throws
	 */
	List<ZlxqMenu> getAllMenu();

	/**
	 * @MethodName: getCMenuByMenuid
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月5日 下午3:24:23
	 * @param id
	 * @param userNo
	 * @return
	 * @return: List<ZlxqMenu>
	 * @throws
	 */
	List<ZlxqMenu> getCMenuByMenuid(Long id, String userNo);

	/**
	 * @MethodName: getMenuPage
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月6日 上午2:44:51
	 * @param pb
	 * @return
	 * @return: String
	 * @throws
	 */
	String getMenuPage(PagingBean pb);

	/**
	 * @MethodName: getMenuByUserNo
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月6日 上午2:46:13
	 * @param userNo
	 * @return
	 * @return: List<ZlxqMenu>
	 * @throws
	 */
	List<ZlxqMenu> getMenuByUserNo(String userNo);

	/**
	 * @MethodName: getMenuTree
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月6日 上午2:49:18
	 * @param id
	 * @return
	 * @return: String
	 * @throws
	 */
	String getMenuTree(String id);

}

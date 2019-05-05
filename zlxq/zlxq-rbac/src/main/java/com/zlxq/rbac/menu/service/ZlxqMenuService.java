/**
 * @Title: ZlxqMenuService.java
 * @Package: com.rbac.menu.service
 * @Description: 系统菜单业务层接口
 * @author: PUB
 * @date: 2019年5月2日 下午12:43:13
 * @version V1.0
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 */
package com.zlxq.rbac.menu.service;

import java.util.List;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.service.BaseService;

import pojo.ZlxqMenu;

public interface ZlxqMenuService extends BaseService<ZlxqMenu> {

	/**
	 * @MethodName: getAllMenu
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月5日 下午3:20:36
	 * @param userno
	 * @param object
	 * @return
	 * @return: List<ZlxqMenu>
	 * @throws
	 */
	List<ZlxqMenu> getAllMenu(String userno, String userType);

	/**
	 * @MethodName: getMenuPage
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月6日 上午2:43:58
	 * @param pb
	 * @return
	 * @return: String
	 * @throws
	 */
	String getMenuPage(PagingBean pb);

	/**
	 * @MethodName: getMenuTree
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月6日 上午2:48:31
	 * @param id
	 * @return
	 * @return: String
	 * @throws
	 */
	String getMenuTree(String id);

	/**
	 * @MethodName: saveMenuInfo
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月6日 上午2:51:50
	 * @param zlxqMenu
	 * @param menuid
	 * @param pid
	 * @return
	 * @return: String
	 * @throws
	 */
	String saveMenuInfo(ZlxqMenu zlxqMenu, String menuid, String pid);

	/**
	 * @MethodName: delMenu
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月6日 上午2:54:09
	 * @param id
	 * @return
	 * @return: String
	 * @throws
	 */
	String delMenu(String id);

}

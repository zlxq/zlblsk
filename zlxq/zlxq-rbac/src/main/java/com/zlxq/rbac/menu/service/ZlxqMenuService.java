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

	List<ZlxqMenu> getAllMenu(String userno, String userType);

	String getMenuPage(PagingBean pb);

	String getMenuTree(String id);

	String saveMenuInfo(ZlxqMenu zlxqMenu, String menuid, String pid);

	String delMenu(String id);

	String getRoleMenu(String id);

	String getNoRoleMenu(String id);

	String saveRoleMenu(String roleid, String selFuns);

}

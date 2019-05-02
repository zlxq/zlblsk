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

import com.zlxq.rbac.base.core.service.BaseService;
import com.zlxq.rbac.pojo.ZlxqMenu;

public interface ZlxqMenuService extends BaseService<ZlxqMenu> {

	/**
	 * @MethodName: getMenuPage
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月3日 上午5:43:05
	 * @return: void
	 * @throws
	 */
	void getMenuPage();

}

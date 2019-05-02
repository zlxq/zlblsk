/**
 * @Title: ZlxqMenuAction.java
 * @Package: com.rbac.menu.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: PUB
 * @date: 2019年5月2日 下午12:39:35
 * @version V1.0
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 */
package com.zlxq.rbac.menu.action;

import java.io.IOException;

import javax.annotation.Resource;

import com.zlxq.rbac.base.core.action.BaseAction;
import com.zlxq.rbac.menu.service.ZlxqMenuService;

public class ZlxqMenuAction extends BaseAction {
	
	@Resource
	private ZlxqMenuService zlxqMenuService;

	public void getMenuPage() {
		System.out.println("进入方法");
		
		zlxqMenuService.getMenuPage();
		
		try {
			this.getResponse().getWriter().print("123");
			
			this.getResponse().getWriter().write("321231");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

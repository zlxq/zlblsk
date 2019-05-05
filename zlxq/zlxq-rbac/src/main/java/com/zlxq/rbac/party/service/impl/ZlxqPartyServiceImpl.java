package com.zlxq.rbac.party.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.framework.util.Constant;
import com.framework.util.MD5Util;
import com.framework.util.PropertiesUtil;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;
import com.zlxq.rbac.base.util.DictUtil;
import com.zlxq.rbac.menu.service.ZlxqMenuService;
import com.zlxq.rbac.party.dao.ZlxqPartyDao;
import com.zlxq.rbac.party.service.ZlxqPartyService;

import pojo.ZlxqMenu;
import pojo.ZlxqParty;

/**
 * @ClassName: ZlxqPartyServiceImpl.java
 * @Description: TODO(方法描述)
 * @author: PUB
 * @date: 2019年4月17日 下午10:30:24
 *
 * @param <T>
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 *
 */
public class ZlxqPartyServiceImpl extends BaseServiceImpl<ZlxqParty> implements ZlxqPartyService {

	private ZlxqPartyDao zlxqPartyDao;
	
	@Resource
	private ZlxqMenuService zlxqMenuService;
	
	
	/**
	 * @Title: ZlxqPartyServiceImpl
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * 
	 * @param dao
	 * @throws
	 */
	public ZlxqPartyServiceImpl(ZlxqPartyDao zlxqPartyDao) {
		super(zlxqPartyDao);
		this.zlxqPartyDao = zlxqPartyDao;
	}


	/**
	 * @MethodName: getPartyByUserNo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: PUB
	 * @date: 2019年5月5日 下午2:46:36
	 * @param userno
	 * @return
	 * @throws
	 */
	public ZlxqParty getPartyByUserNo(String userno) {
		return this.zlxqPartyDao.getPartyByUser(userno, null);
	}


	/**
	 * @MethodName: getPartyByUser
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: PUB
	 * @date: 2019年5月5日 下午3:03:51
	 * @param userno
	 * @param password
	 * @return
	 * @throws
	 */
	
	@Override
	public ZlxqParty getPartyByUser(String userno, String password) {
		password = MD5Util.getMDString(password);
		return this.zlxqPartyDao.getPartyByUser(userno, password);
	}


	/**
	 * @MethodName: login
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: PUB
	 * @date: 2019年5月5日 下午3:14:17
	 * @param userno
	 * @param password
	 * @return
	 * @throws
	 */
	
	@Override
	public String login(String userno, String password, HttpServletRequest request) {
		ZlxqParty zlxqParty = zlxqPartyDao.getPartyByUser(userno, password);
		
		if (null == zlxqParty) {
			return ConstantRBAC.FAILURE;
		}
		
		String userType = DictUtil.role_lx.role_lx_yb;
		if (Constant.IS_SUPER.equals(zlxqParty.getIssuper())) {
			userType = DictUtil.role_lx.role_lx_super;
		}
		List<ZlxqMenu> menuList = this.zlxqMenuService.getAllMenu(userno, userType);
		
		zlxqParty.setMenuList(menuList);
		
		pubSession(request, zlxqParty);
		
		return ConstantRBAC.SUCCESS;
	}


	/**
	 * @MethodName: pubSession
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月5日 下午4:11:10
	 * @param request
	 * @param zlxqParty
	 * @return: void
	 * @throws
	 */
	private void pubSession(HttpServletRequest request, ZlxqParty zlxqParty) {
		String sessionId = request.getSession().getId();
		String webAppName = PropertiesUtil.getPropertyFromConfig("WEB_APP_NAME");
		request.getSession().setAttribute("sessionId", sessionId);
		request.getSession().setAttribute("user", zlxqParty);
		request.getSession().setAttribute("rootPath", request.getContextPath());
		request.getSession().setAttribute("__ctxPath", request.getServletContext().getRealPath("/"));
		request.getSession().setAttribute("webAppName", webAppName);
	}


}

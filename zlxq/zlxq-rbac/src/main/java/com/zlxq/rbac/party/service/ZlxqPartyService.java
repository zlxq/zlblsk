package com.zlxq.rbac.party.service;

import javax.servlet.http.HttpServletRequest;

import com.zlxq.rbac.base.core.service.BaseService;

import pojo.ZlxqParty;

/**
 * @ClassName: ZlxqPartyService.java
 * @Description: TODO(方法描述)
 * @author: PUB
 * @date: 2019年4月17日 下午10:30:24
 *
 * @param <T>
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 *
 */
public interface ZlxqPartyService extends BaseService<ZlxqParty> {

	/**
	 * @MethodName: getPartyByUserNo
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月5日 下午2:39:27
	 * @param userno
	 * @return
	 * @return: ZlxqParty
	 * @throws
	 */
	ZlxqParty getPartyByUserNo(String userno);

	/**
	 * @MethodName: getPartyByUser
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月5日 下午3:03:27
	 * @param userno
	 * @param password
	 * @return
	 * @return: ZlxqParty
	 * @throws
	 */
	ZlxqParty getPartyByUser(String userno, String password);

	/**
	 * @param request 
	 * @MethodName: login
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月5日 下午3:13:52
	 * @param userno
	 * @param password
	 * @return
	 * @return: String
	 * @throws
	 */
	String login(String userno, String password, HttpServletRequest request);

}

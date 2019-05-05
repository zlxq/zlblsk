package com.zlxq.rbac.base.bean;

import java.util.HashMap;

import pojo.ZlxqParty;

/**
 * 在线用户
 * 
 * @author zhangl
 *
 * @createtime 2017年5月28日
 * @version V1.0
 */
public class OnlineUserBean {

	/**
	 * 用户session
	 */
	private static final HashMap<String, Object> USER_SESSION_MAP = new HashMap<String, Object>();

	public static void putUserBySessionId(String sessionid, Object object) {
		USER_SESSION_MAP.put(sessionid, object);
	}
	
	public static void removeUserBySessionId(String sessionid) {
		USER_SESSION_MAP.remove(sessionid);
	}
	
	public static Object getUserBySessionId(String sessionid) {
		return USER_SESSION_MAP.get(sessionid);
	}
	
	public static ZlxqParty getPartyBySessionId(String sessionid) {
		return (ZlxqParty) getUserBySessionId(sessionid);
	}
	
	public static int getUserLineCount() {
		return USER_SESSION_MAP.size();
	}
	
}

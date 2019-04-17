package com.framework.bean;

import java.util.HashMap;

/**
 * 在线用户
 * 
 * @author zhangl
 *
 * @createtime 2017年5月28日
 * @version V1.0
 */
public class OnlineUserBean {

	private static final HashMap<String, Object> userLineMap = new HashMap<String, Object>();

	private static final HashMap<String, Object> REMOVE_USER_SESSION_LIST = new HashMap<String, Object>();
	
	public static void putRemoveUser(String sessionId, Object obj) {
		REMOVE_USER_SESSION_LIST.put(sessionId, obj);
	}
	
	public static Object getRemoveUser(String sessionId) {
		return REMOVE_USER_SESSION_LIST.get(sessionId);
	}
	
	public static void removeRemoveUser(String sessionId) {
		REMOVE_USER_SESSION_LIST.remove(sessionId);
	}
	
	public static void putUserLine(String sessionId, Object object) {
		userLineMap.put(sessionId, object);
	}
	
	public static void putUserLineByUserno(String userno, Object object) {
		userLineMap.put(userno, object);
	}

	public static void removeUserLine(String sessionId) {
		userLineMap.remove(sessionId);
	}
	
	public static void removeUserLineByUserno(String userno) {
		userLineMap.remove(userno);
	}

	public static void updateUserLine(String sessionId, Object object) {
		putUserLine(sessionId, object);
	}

	public static int getUserLineCount() {
		return userLineMap.size() / 2;
	}

	public static Object getUserLine(String sessionId) {
		return userLineMap.get(sessionId);
	}
	
	public static Object getUserLineByUserNo(String userno) {
		return userLineMap.get(userno);
	}
}

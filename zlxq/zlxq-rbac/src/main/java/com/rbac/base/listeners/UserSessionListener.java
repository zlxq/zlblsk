package com.rbac.base.listeners;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.rbac.base.bean.OnlineUserBean;

public class UserSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		@SuppressWarnings("unused")
		String sessionId = session.getId();
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		String sessionId = session.getId();
		
		Object obj = OnlineUserBean.getUserLine(sessionId);
		
		if (obj != null) {
			@SuppressWarnings("unchecked")
			Map<String, String> map = (Map<String, String>) session.getAttribute("mapUserSession");
			
			String userno = map.get(sessionId);
			
			OnlineUserBean.removeRemoveUser(sessionId);
			OnlineUserBean.removeUserLineByUserno(userno);
		}
		
	}

}

/**
 * 
 */
package com.zlxq.rbac.base.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import pojo.ZlxqParty;

/**
 * @TODO 获取登录用户信息
 * @author zhangl
 *
 * @createtime 2019年5月19日
 * @version V1.0
 */
public class UserUtil {

	public static ZlxqParty getZlxqParty() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return getPubSysuser(request.getSession());
	}

	public static ZlxqParty getPubSysuser(HttpSession hs) {
		ZlxqParty pa = (ZlxqParty) hs.getAttribute("user");
		return pa;
	}
	
	public static Long getCompanyId() {
		return getZlxqParty().getCompanyId();
	}
	
	public static Long getCurDeptId() {
		return getZlxqParty().getCruDeptId();
	}
	

	public static Long getUserId() {
		return getZlxqParty().getId();
	}
	
	public static String getPartyno() {
		return getZlxqParty().getPartyno();
	}
	
	public static String getPartyName() {
		return getZlxqParty().getPartyname();
	}
}

package com.zlxq.rbac.login;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.framework.util.IPUtil;
import com.zlxq.rbac.base.bean.OnlineUserBean;
import com.zlxq.rbac.base.core.action.BaseAction;
import com.zlxq.rbac.base.util.ConstantRBAC;
import com.zlxq.rbac.party.service.ZlxqPartyService;

/**
 * @ClassName: LoginAction
 * @Description: 登录实现
 * @author: zhangl
 * @date: 2019年4月17日 下午10:30:24
 *
 * @param <T>
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 *
 */
public class LoginAction extends BaseAction {
	
	private static final Log logger = LogFactory.getLog(LoginAction.class);
	
	@Resource
	private ZlxqPartyService zlxqPartyService;

	/**
	 * @MethodName: login
	 * @Description: TODO(系统登录) 
	 * @author: PUB
	 * @date: 2019年5月5日 下午2:29:35
	 * @return
	 * @return: String
	 * @throws
	 */
	public String login() {
		String userno = this.getRequest().getParameter("userno");
		String password = this.getRequest().getParameter("password");
		
		if (StringUtils.isEmpty(userno) || StringUtils.isEmpty(password)) {
			setMessage("用户名或密码为空，请重新输入！");
			return SUCCESS;
		}
		
		String msg = zlxqPartyService.login(userno, password, this.getRequest());
		
		if (FAILURE.equals(msg)) {
			setMessage("用户名或密码错误，请重新输入？");
			return SUCCESS;
		} else if (ConstantRBAC.REDIECT.equals(msg)) {
		}
		
		
		System.out.println("\t\n" + "登陆人ip:" + IPUtil.getIpAddr(this.getRequest()) + "\t\n");
		
		setMessage("success");
		return SUCCESS;
	}
	
	/**
	 * @MethodName: layout
	 * @Description: TODO(退出登录) 
	 * @author: PUB
	 * @date: 2019年5月5日 下午2:38:01
	 * @return
	 * @return: String
	 * @throws
	 */
	public String layout() {
		System.out.println("退出登录");
		return SUCCESS;
	}
}

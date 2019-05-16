package com.zlxq.rbac.base.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.framework.web.filter.ZlxqFrameworkFilter;
import com.zlxq.rbac.base.bean.OnlineUserBean;

import pojo.ZlxqParty;

/**
 * url权限拦截过滤器
 * 
 * @author zhangl
 *
 * @createtime 2017年5月29日
 * @version V1.0
 */
public class UrlDispatchFilter extends ZlxqFrameworkFilter {
	private static final Log logger = LogFactory.getLog(UrlDispatchFilter.class);

	/**
	 * 过滤地址栏请求，必须通过系统登陆后，才能访问系统具体页面
	 */
	@SuppressWarnings("unused")
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		String uri = request.getRequestURI();

		HttpSession session = request.getSession();
		String newSid = session.getId();
		ZlxqParty zp = (ZlxqParty) OnlineUserBean.getUserBySessionId(session.getId());
		
		if (null == zp) {
			if (uri.indexOf(".jsp") != -1) {
				logger.debug("被拦截：跳转到login页面！");
				request.getRequestDispatcher("/").forward(request, response);
			} else {
				arg2.doFilter(request, response);
			}
		} else {
			arg2.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		if (logger.isDebugEnabled()) {
			logger.debug("调用 UrlAssertFilter init  ");
		}
	}

	@Override
	public void destroy() {
		if (logger.isDebugEnabled()) {
			logger.debug("调用 UrlAssertFilter destroy  ");
		}
	}

}

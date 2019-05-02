package com.zlxq.rbac.base.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.framework.web.filter.ZlxqFrameworkFilter;
import com.zlxq.rbac.base.bean.OnlineUserBean;

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
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		String uri = request.getRequestURI();

		Object object = OnlineUserBean.getUserLine(request.getSession().getId());

		if (uri.indexOf("api.jsp") != -1) {
			arg2.doFilter(request, response);
			return;
		}
		if (null == object) {

			if (uri.indexOf("index.jsp") == -1) {
				if (uri.contains(".css") || uri.contains(".js") || uri.contains(".png") || uri.contains(".jpg")
						|| uri.indexOf("getAllSchool.do") > 0 || uri.indexOf("InterfaceServlet") > 0) {
					if (uri.contains(".jsp")) {
						PrintWriter out = response.getWriter();
						out.println("<html>");
						out.println("<script>");
						out.println("window.open ('" + request.getContextPath() + "/index.jsp','_top')");
						out.println("</script>");
						out.println("</html>");
						// response.sendRedirect(request.getContextPath() +
						// "/index.jsp");
					}
				} else {
					PrintWriter out = response.getWriter();
					out.println("<html>");
					out.println("<script>");
					out.println("window.open ('" + request.getContextPath() + "/index.jsp','_top')");
					out.println("</script>");
					out.println("</html>");
					// response.sendRedirect(request.getContextPath() +
					// "/index.jsp");
				}
			}
		}
		arg2.doFilter(request, response);

		// if (uri.indexOf("getAllSchool.do") > 0) {
		// arg2.doFilter(request, response);
		// } else if (uri.indexOf("InterfaceServlet") > 0) {
		// arg2.doFilter(request, response);
		// } else if (uri.indexOf("login.do") > 0 || uri.indexOf("index.jsp") >
		// 0) {
		// arg2.doFilter(request, response);
		// } else if (null != object) {
		// arg2.doFilter(request, response);
		// } else if (uri.contains(".css") || uri.contains(".js") ||
		// uri.contains(".png") || uri.contains(".jpg")) {
		// // 如果发现是css或者js文件，直接放行
		// arg2.doFilter(request, response);
		//
		// } else {
		// response.sendRedirect(request.getContextPath() + "/index.jsp");
		// arg2.doFilter(request, response);
		// }

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

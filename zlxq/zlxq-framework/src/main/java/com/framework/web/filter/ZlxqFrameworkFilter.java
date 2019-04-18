/**
 * @Title: ZlxqFrameworkFilter.java
 * @Package: com.framework.web.filter
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: PUB
 * @date: 2019年4月18日 上午11:17:25
 * @version V1.0
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 */
package com.framework.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @ClassName: ZlxqFrameworkFilter
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: PUB
 * @date: 2019年4月18日 上午11:17:25
 *
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 *
 */
public class ZlxqFrameworkFilter implements Filter {
	
	private static final Log logger = LogFactory.getLog(ZlxqFrameworkFilter.class);

	/**
	 * <p>Title: doFilter</p>
	 * <p>Description: </p>
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws IOException
	 * @throws ServletException
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		if (logger.isDebugEnabled()) {
			logger.debug("调用 ZlxqFrameworkFilter init  ");
		}
	}

	@Override
	public void destroy() {
		if (logger.isDebugEnabled()) {
			logger.debug("调用 ZlxqFrameworkFilter destroy  ");
		}
	}

}

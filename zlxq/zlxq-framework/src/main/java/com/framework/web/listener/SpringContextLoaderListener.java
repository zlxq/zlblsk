package com.framework.web.listener;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import com.framework.util.WebAppUtil;

/**
 * web.xml启动时，启动springcontextloadlistener监听，初始化webapplicationcontext（web容器）
 * @author zhangl
 *
 * @createtime 2017年5月29日
 * @version V1.0
 */
public class SpringContextLoaderListener extends ContextLoaderListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
	  WebApplicationContext applicationContext=	initWebApplicationContext(event.getServletContext());
	  WebAppUtil.init(applicationContext);
	}
	
}

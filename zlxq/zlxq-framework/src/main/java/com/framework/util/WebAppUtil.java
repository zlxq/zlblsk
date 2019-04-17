package com.framework.util;

import java.io.Serializable;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;

/**
 * 系统启动类，初始化web容器参数
 * 
 * @author zhangl
 *
 * @description ApplicationContext ctx = new  ClassPathXmlApplicationContext("Spring.xml"); //获取IoC容器中JdbcTemplate实例 
 *              JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
 * @createtime 2017年3月2日
 * @version V1.0
 */
@SuppressWarnings("serial")
public class WebAppUtil implements Serializable {

	private static WebApplicationContext applicationContext;

	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

	public static <T> T getBean(Class<T> clazz) {

		return (T) applicationContext.getBean(clazz);
	}
	
	public static void init(WebApplicationContext applicationContext) {
		/*初始化applicationContext容器*/
		setApplicationContext(applicationContext);
	}

	public static WebApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static void setApplicationContext(WebApplicationContext applicationContext) {
		WebAppUtil.applicationContext = applicationContext;
	}

	public static String getGetCtxPath() {
		return getServletContext().getRealPath("/");
	}

	public static ServletContext getServletContext() {
		return applicationContext.getServletContext();
	}

}

package com.tools.socket.listener;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

import com.tools.socket.server.SocketServer;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年6月2日
 * @version V1.0
 */
public class SocketLoaderListener extends ContextLoaderListener {

	private SocketServer serverSocket;

	public void contextInitialized(ServletContextEvent sce) {
		if (null == serverSocket) {
			new SocketServer().start();
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
		if (null != serverSocket && !serverSocket.isInterrupted()) {
			serverSocket.closeSocketServer();
			serverSocket.interrupt();
		}

	}
}

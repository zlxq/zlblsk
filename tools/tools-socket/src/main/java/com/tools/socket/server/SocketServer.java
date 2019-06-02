/**
 * 
 */
package com.tools.socket.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.lang.StringUtils;

import com.framework.util.PropertiesUtil;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年6月2日
 * @version V1.0
 */
public class SocketServer extends Thread {

	private ServerSocket server = null;
	private Socket socket = null;
	
	public SocketServer() {
		try {
			int port = Integer.parseInt(StringUtils.isEmpty(PropertiesUtil.getPropertyFromConfig("SOCKET_POINT")) ? "20019" : PropertiesUtil.getPropertyFromConfig("SOCKET_POINT"));
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SocketServer(int port) {
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		System.out.println("socketserver启动，等待客户端发送连接请求......");
		while (true) {
			try {
				socket = server.accept();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			new Thread(new SocketTask(socket)).start();
		}
	}
	
	static class SocketTask implements Runnable {
		private Socket socket;
		
		public SocketTask(Socket socket) {
			this.socket = socket;
		}

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			// 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
			try {
				InputStream is = socket.getInputStream();
				byte[] bytes = new byte[1024];
				int len = -1;
				
				while ((len = is.read(bytes)) != -1) {
					String str = new String(bytes, 0, len, "GBK");
					
//					str = byteArrayToHexString(Arrays.copyOf(bytes, len));//字节转换成16进制字符串
					
					System.out.println("get message from client: " + str + "\n");
					
					OutputStream out = socket.getOutputStream();
					
					out.write(bytes, 0, len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private static final String HEX_CODE = "0123456789ABCDEF";
	
	private static String byteArrayToHexString(byte[] bs) {
		int _byteLen = bs.length;
		StringBuilder _result = new StringBuilder(_byteLen * 2);
		for (int i = 0; i < _byteLen; i++) {
			int n = bs[i] & 0xFF;
			_result.append(HEX_CODE.charAt(n >> 4));
			_result.append(HEX_CODE.charAt(n & 0x0F));
		}
		return String.valueOf(_result);
	}
	
	public void closeSocketServer() {
		try {
			if (null != server && !server.isClosed()) {
				server.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SocketServer(20019).run();
	}
}

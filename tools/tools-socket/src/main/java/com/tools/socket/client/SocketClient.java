/**
 * 
 */
package com.tools.socket.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
public class SocketClient {
	
	private static String host = "127.0.0.1";
	private static int port = 20019;
	
	public SocketClient() {
		port = Integer.parseInt(StringUtils.isEmpty(PropertiesUtil.getPropertyFromConfig("SOCKET_POINT")) ? port + "" : PropertiesUtil.getPropertyFromConfig("SOCKET_POINT"));
	}
	
	public SocketClient(String sp, int p) {
		host = sp;
		port = p;
	}
	
	@SuppressWarnings("static-access")
	public static String sendMsgFromClientToServer(String ip, int port, String msg) {
		try {
			return new SocketClient(ip, port).run(msg);
		} catch (IOException e) {
			e.printStackTrace();
			return "error, equip send message to pc server!";
		}
	}
	
	@SuppressWarnings("static-access")
	public static String sendMsgFromClientToServer(String msg) {
		try {
			return new SocketClient().run(msg);
		} catch (IOException e) {
			e.printStackTrace();
			return "error, equip send message to pc server!";
		}
	}

	private static String run(String message) throws IOException {
		// 与服务端建立连接
		Socket socket = new Socket(host, port);
		// 建立连接后获得输出流
		OutputStream outputStream = socket.getOutputStream();
		socket.getOutputStream().write(message.getBytes("UTF-8"));

		// 通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
		socket.shutdownOutput();

		InputStream inputStream = socket.getInputStream();
		byte[] bytes = new byte[1024];
		int len;
		StringBuilder sb = new StringBuilder();
		while ((len = inputStream.read(bytes)) != -1) {
			// 注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
			sb.append(new String(bytes, 0, len, "UTF-8"));
			System.out.println("client receive Message is come from server: " + sb);
		}

//		inputStream.close();
//		outputStream.close();
		socket.close();

		return sb.toString();
	}
	
	public static void main(String args[]) throws Exception {
		String ip = "127.0.0.1";
		int port = 20001;

		sendMsgFromClientToServer("123123");
	}
}

/**
 * 
 */
package com.blsk.api;

import com.tools.socket.client.SocketClient;
import com.zlxq.rbac.base.core.action.BaseAction;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年6月3日
 * @version V1.0
 */
public class BlskApiAction extends BaseAction {

	public String requestSocket() {
		String host = this.getRequest().getParameter("host");
		String port = this.getRequest().getParameter("port");
		String funcode = this.getRequest().getParameter("funcode");
		SocketClient sc = new SocketClient();
		String msg = sc.sendMsgFromClientToServer(funcode);
		setMessage(msg);
		return SUCCESS;
	}
}

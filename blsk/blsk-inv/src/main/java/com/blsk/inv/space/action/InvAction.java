package com.blsk.inv.space.action;

import java.io.IOException;

import javax.annotation.Resource;

import org.json.JSONException;

import com.blsk.inv.space.service.BlskInvSpaceService;
import com.zlxq.rbac.base.core.action.BaseAction;

import pojo.BlskInvSpace;


public class InvAction extends BaseAction {

	@Resource
	private BlskInvSpaceService blskInvSpaceService;
	
	private BlskInvSpace blskInvSpace;
	/**
	 * 保存巷道平面图信息
	 * @author sundd
	 *
	 * @return
	 * @createtime 2019年5月17日
	 * @version V1.0
	 * @throws JSONException 
	 * @throws IOException 
	 */
	public String saveInvSpaceInfo() throws JSONException, IOException {
		String dataArray = this.getRequest().getParameter("dataArray");
		String storeRoom = this.getRequest().getParameter("storeRoom");
		String storeRoom_unit = this.getRequest().getParameter("storeRoom_unit");
		String spacex = this.getRequest().getParameter("spacex");
		String spacey = this.getRequest().getParameter("spacey");
		String svg = this.getRequest().getParameter("svg");
		System.out.println(svg);
		String msg = this.blskInvSpaceService.saveInvSpaceInfo(dataArray, storeRoom, storeRoom_unit, svg, spacex, spacey);
		setMessage(msg);
		return SUCCESS;
	}
	/**
	 * 获取库房地址信息
	 * @author sundd
	 *
	 * @return
	 * @createtime 2019年6月1日
	 * @version V1.0
	 * @throws JSONException 
	 * @throws IOException 
	 */
	public String getSpaceAddress() throws JSONException, IOException {
		String json = this.blskInvSpaceService.getSpaceAddress();
		setJsonString(json);
		return SUCCESS;
	}

}

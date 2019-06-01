package com.blsk.inv.space.service;

import java.io.IOException;
import java.util.Map;

import org.json.JSONException;

import com.zlxq.rbac.base.core.service.BaseService;

import pojo.BlskInvSpace;

public abstract interface BlskInvSpaceService extends BaseService<BlskInvSpace> {

	/**
	 * 保存巷道平面图信息
	 * @author sundd
	 *
	 * @return
	 * @createtime 2019年5月17日
	 * @version V1.0
	 * @param spacey 
	 * @param spacex 
	 * @param svg2 
	 * @throws JSONException 
	 * @throws IOException 
	 */
	String saveInvSpaceInfo(String dataArray, String storeRoom, String storeRoom_unit, String svg, String spacex, String spacey) throws JSONException, IOException;

	/**
	 * 获取库房地址信息
	 * @author sundd
	 *
	 * @return
	 * @createtime 2019年6月1日
	 * @version V1.0
	 */
	String getSpaceAddress();

}

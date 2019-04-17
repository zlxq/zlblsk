package com.framework.util;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import flexjson.JSONSerializer;

/**
 * 
 * @ClassName: JsonUtil
 * @Description: json相关数据格式之间转换
 * @author: PUB
 * @date: 2019年4月17日 下午10:25:19
 *
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 *
 */
public class JsonUtil {
	
	protected static Log jsonUtilLogger = LogFactory.getLog(JsonUtil.class);

	public static String listTOJson(List<?> list) {
		JSONSerializer serializer = new JSONSerializer();
		return serializer.serialize(list);
	}
	
	public static String getJson(List<?> list) {
		if (list.size() == 0) {
			jsonUtilLogger.debug("=======输出结果=======\n" + "{success:true,rows:[]}");
			return "{success:true,total:0,rows:[]}";
		}
		
		String json = listTOJson(list);
		net.sf.json.JSONObject jsonObject = new net.sf.json.JSONObject();
		jsonObject.put("success", true);
		jsonObject.put("total", list.size());
		jsonObject.put("rows", json);
		jsonUtilLogger.debug("=======输出结果=======\n" + jsonObject.toString());
		return jsonObject.toString();
	}
	
	public static String getJson(List<?> list, int total) {
		if (list.size() == 0) {
			jsonUtilLogger.debug("=======输出结果=======\n" + "{success:true,rows:[]}");
			return "{success:true,total:0,rows:[]}";
		}
		
		String json = listTOJson(list);
		net.sf.json.JSONObject jsonObject = new net.sf.json.JSONObject();
		jsonObject.put("success", true);
		jsonObject.put("total", total);
		jsonObject.put("rows", json);
		jsonUtilLogger.debug("=======输出结果=======\n" + jsonObject.toString());
		return jsonObject.toString();
	}
}

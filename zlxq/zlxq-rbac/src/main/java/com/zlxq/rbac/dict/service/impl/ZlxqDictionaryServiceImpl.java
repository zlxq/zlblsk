package com.zlxq.rbac.dict.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.dict.dao.ZlxqDictionaryDao;
import com.zlxq.rbac.dict.service.ZlxqDictionaryService;

import pojo.ZlxqDictionary;

public class ZlxqDictionaryServiceImpl extends BaseServiceImpl<ZlxqDictionary> implements ZlxqDictionaryService {

	private ZlxqDictionaryDao zlxqDictionaryDao;
	public ZlxqDictionaryServiceImpl(ZlxqDictionaryDao zlxqDictionaryDao) {
		super(zlxqDictionaryDao);
		this.zlxqDictionaryDao = zlxqDictionaryDao;
	}
	@Override
	public String getDictTree(String id) {
		String json = this.zlxqDictionaryDao.getDictTree(id);
		try {
			JSONObject jo = new JSONObject(json);
			JSONArray ja = jo.getJSONArray("rows");
			json = ja.toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@Override
	public String getDictGrid(String id) {
		return this.zlxqDictionaryDao.getDictGrid(id);
	}
	@Override
	public String saveDict(ZlxqDictionary zlxqDictionary, String pid) {
		String diccode = zlxqDictionary.getDicCode();
		
		List list = this.zlxqDictionaryDao.getDictInfo(diccode);
		
		if (list.size() > 0) {
			return "编号已经存在,请重新输入！";
		}
		
		if (StringUtils.isNotEmpty(pid) && !"null".equals(pid)) {
			ZlxqDictionary zd = this.zlxqDictionaryDao.findByPk(Long.parseLong(pid));
			zd.setIsLeaf("closed");
			zd = this.zlxqDictionaryDao.save(zd);
			
			zlxqDictionary.setZlxqDictionary(zd);
			zlxqDictionary.setDicType("1");
		} else {
			zlxqDictionary.setDicType("0");
		}
		
		zlxqDictionary.setIsLeaf("open");
		zlxqDictionary.setCreatetime(new Date());
		zlxqDictionary.setIsvalidate("1");
		
		try {
			this.zlxqDictionaryDao.save(zlxqDictionary);
		} catch (Exception e) {
			e.printStackTrace();
			return "保存失败";
		}
 		return "保存成功";
	}
	
	public String editDict(ZlxqDictionary zlxqDictionary, String id) {
		ZlxqDictionary zd = this.zlxqDictionaryDao.findByPk(Long.parseLong(id));
		
		zd.setDicCode(zlxqDictionary.getDicCode());
		zd.setDicName(zlxqDictionary.getDicName());
		zd.setUpdatetime(new Date());
		
		try {
			this.zlxqDictionaryDao.save(zd);
		} catch (Exception e) {
			e.printStackTrace();
			return "保存失败";
		}
		return "保存成功";
	}
	@Override
	public String delDict(String ids) {
		try {
			JSONArray ja = new JSONArray(ids);
			
			ZlxqDictionary zlxqDictionary = null;
			for (int i = 0; i < ja.length(); i++) {
				String id = ja.getString(i);
				
				zlxqDictionary = this.zlxqDictionaryDao.findByPk(Long.parseLong(id));
				
				zlxqDictionary.setUpdatetime(new Date());
				zlxqDictionary.setIsvalidate("0");
				
				this.zlxqDictionaryDao.save(zlxqDictionary);
				
			}
			
			return "删除成功";
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "删除失败";
	}

}

package com.zlxq.rbac.dict.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.dict.dao.ZlxqDictionaryDao;

import pojo.ZlxqDictionary;

public class ZlxqDictionaryDaoImpl extends BaseDaoImpl<ZlxqDictionary> implements ZlxqDictionaryDao {

	public ZlxqDictionaryDaoImpl() {
		super(ZlxqDictionary.class);
	}

	@Override
	public String getDictTree(String id) {
		String sql = "SELECT d.id, CONCAT('[', d.DIC_CODE, ']', d.dic_name) text, d.isleaf state FROM zlxq_dictionary d WHERE 1 = 1";
		
		if (StringUtils.isNotEmpty(id)) {
			sql += " and d.pid = "+id+"";
		} else {
			sql += " and d.dic_type = '0'";
		}
		
		sql += " and d.isvalidate = '1' order by d.id asc";
		
		return findByJDBCReturnJSON(sql);
	}

	@Override
	public String getDictGrid(String id) {
		String sql = "SELECT d.id, d.dic_code, d.dic_name, d.dic_type, d.isleaf state FROM zlxq_dictionary d WHERE 1 = 1";
		
		if (StringUtils.isNotEmpty(id)) {
			sql += " and d.pid = "+id+"";
		} else {
			sql += " and d.dic_type = '0'";
		}
		
		sql += " and d.isvalidate = '1' order by d.id asc";
		
		return findByJDBCReturnJSON(sql);
	}

	@Override
	public List getDictInfo(String diccode) {
		String sql = "select t.* from zlxq_dictionary t where t.dic_code = '"+diccode+"'";
		return findByJDBCReturnList(sql);
	}

}

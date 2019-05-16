package com.zlxq.rbac.log.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.log.dao.ZlxqLogDao;

import pojo.ZlxqLog;

public class ZlxqLogDaoImpl extends BaseDaoImpl<ZlxqLog> implements ZlxqLogDao {

	public ZlxqLogDaoImpl() {
		super(ZlxqLog.class);
	}

	@Override
	public String getLogInfo(PagingBean pb, String loginno, String loginname) {
		String sql = "SELECT ID, LOGINNO, LOGINNAME, LOGINIP, LOGINTYPE, DATE_FORMAT(logintime, '%Y-%m-%d %H:%i:%s') LOGINTIME FROM ZLXQ_LOG WHERE ISVALIDATE = '1'";
		
		if (StringUtils.isNotEmpty(loginno)) {
			sql += " AND LOGINNO LIKE '%"+loginno+"%'";
		}
		if (StringUtils.isNotEmpty(loginname)) {
			sql += " AND LOGINNAME LIKE '%"+loginname+"%'";
		}
		
		sql += " ORDER BY LOGINTIME DESC";
		
		return findByJDBCReturnJSON(pb, sql);
	}

	@Override
	public List<ZlxqLog> getSysLog(String id) {
		String hql = "select t from ZlxqLog t where t.isvalidate = '1'";
		if (StringUtils.isNotEmpty(id)) {
			hql += " and t.id in ("+ id +")";
		}
		@SuppressWarnings("unchecked")
		List<ZlxqLog> list = (List<ZlxqLog>) this.findByHQL(hql);
		if (0 == list.size()) {
			return null;
		}
		return list;
	}
}

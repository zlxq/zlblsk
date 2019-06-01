package com.zlxq.rbac.log.dao.impl;

import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.log.dao.ZlxqLogOperationDao;

import pojo.ZlxqLogOperation;

public class ZlxqLogOperationDaoImpl extends BaseDaoImpl<ZlxqLogOperation> implements ZlxqLogOperationDao {

	public ZlxqLogOperationDaoImpl() {
		super(ZlxqLogOperation.class);
	}

}

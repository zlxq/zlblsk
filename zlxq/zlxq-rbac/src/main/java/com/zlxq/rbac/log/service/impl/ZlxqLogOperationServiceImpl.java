package com.zlxq.rbac.log.service.impl;

import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.log.dao.ZlxqLogOperationDao;
import com.zlxq.rbac.log.service.ZlxqLogOperationService;

import pojo.ZlxqLogOperation;

public class ZlxqLogOperationServiceImpl extends BaseServiceImpl<ZlxqLogOperation> implements ZlxqLogOperationService {

	private ZlxqLogOperationDao zlxqLogOperationDao;
	public ZlxqLogOperationServiceImpl(ZlxqLogOperationDao zlxqLogOperationDao) {
		super(zlxqLogOperationDao);
		this.zlxqLogOperationDao = zlxqLogOperationDao;
	}
	
	

}

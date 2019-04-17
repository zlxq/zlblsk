package com.framework.web.ssh.service.impl;

import java.io.Serializable;

import com.framework.web.ssh.dao.GenericDao;
import com.framework.web.ssh.service.BaseService;

public class BaseServiceImpl<T> extends GenericServiceImpl<T, Serializable> implements BaseService<T> {
	public BaseServiceImpl(GenericDao<T, Serializable> dao) {
		super(dao);
	}

}

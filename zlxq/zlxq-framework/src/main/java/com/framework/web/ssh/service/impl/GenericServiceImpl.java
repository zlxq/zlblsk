package com.framework.web.ssh.service.impl;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.framework.web.ssh.dao.GenericDao;
import com.framework.web.ssh.service.GenericService;

public class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {
	protected Log logger = LogFactory.getLog(GenericServiceImpl.class);
	protected GenericDao<T, Serializable> dao = null;

	public void setDao(GenericDao<T, Serializable> dao) {
		this.dao = dao;
	}

	public GenericServiceImpl(GenericDao<T, Serializable> dao) {
		this.dao = dao;
	}
}

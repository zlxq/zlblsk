package com.rbac.base.core.dao.impl;

import java.io.Serializable;

import com.framework.web.ssh.dao.impl.GenericDaoImpl;
import com.rbac.base.core.dao.BaseDao;

/**
 * 
 * @ClassName: BaseDaoImpl
 * @Description: 系统基础数据层接口实现
 * @author: PUB
 * @date: 2019年4月17日 下午10:30:24
 *
 * @param <T>
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 *
 */
public class BaseDaoImpl<T> extends GenericDaoImpl<T, Serializable> implements BaseDao<T> {
	public BaseDaoImpl(Class<?> persistType) {
		super(persistType);
	}
}
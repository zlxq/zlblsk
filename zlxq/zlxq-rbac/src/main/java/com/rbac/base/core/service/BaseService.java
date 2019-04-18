package com.rbac.base.core.service;

import java.io.Serializable;

import com.framework.web.ssh.service.GenericService;

/**
 * 
 * @ClassName: BaseService
 * @Description:基础抽象接口
 * @author: PUB
 * @date: 2019年4月17日 下午10:28:12
 *
 * @param <T>
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.	
 *
 */
public abstract interface BaseService<T> extends GenericService<T, Serializable> {

}

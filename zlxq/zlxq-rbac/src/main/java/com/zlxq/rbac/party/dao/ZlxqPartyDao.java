package com.zlxq.rbac.party.dao;

import com.zlxq.rbac.base.core.dao.BaseDao;

import pojo.ZlxqParty;

/**
 * @ClassName: ZlxqPartyDao.java
 * @Description: TODO(方法描述)
 * @author: PUB
 * @date: 2019年4月17日 下午10:30:24
 *
 * @param <T>
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 *
 */
public interface ZlxqPartyDao extends BaseDao<ZlxqParty>{

	/**
	 * @MethodName: getPartyByUserNo
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月5日 下午2:47:13
	 * @param userno
	 * @return
	 * @return: ZlxqParty
	 * @throws
	 */
	ZlxqParty getPartyByUser(String userno, String password);

}

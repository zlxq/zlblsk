package com.zlxq.rbac.party.dao.impl;

import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.party.dao.ZlxqPartyRelationDao;

import pojo.ZlxqPartyRelation;

/**
 * @ClassName: ZlxqPartyRelationDaoImpl.java
 * @Description: TODO(方法描述)
 * @author: PUB
 * @date: 2019年4月17日 下午10:30:24
 *
 * @param <T>
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 *
 */
public class ZlxqPartyRelationDaoImpl extends BaseDaoImpl<ZlxqPartyRelation> implements ZlxqPartyRelationDao {

	/**
	 * @Title: ZlxqPartyRelationDaoImpl
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param persistType
	 * @throws
	 */
	public ZlxqPartyRelationDaoImpl() {
		super(ZlxqPartyRelation.class);
	}

}

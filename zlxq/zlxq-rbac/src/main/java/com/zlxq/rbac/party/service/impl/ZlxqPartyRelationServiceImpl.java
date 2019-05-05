package com.zlxq.rbac.party.service.impl;

import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.party.dao.ZlxqPartyRelationDao;
import com.zlxq.rbac.party.service.ZlxqPartyRelationService;

import pojo.ZlxqPartyRelation;

/**
 * @ClassName: ZlxqPartyRelationServiceImpl.java
 * @Description: TODO(方法描述)
 * @author: PUB
 * @date: 2019年4月17日 下午10:30:24
 *
 * @param <T>
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 *
 */
public class ZlxqPartyRelationServiceImpl extends BaseServiceImpl<ZlxqPartyRelation> implements ZlxqPartyRelationService {

	private ZlxqPartyRelationDao zlxqPartyRelationDao;
	/**
	 * @Title: ZlxqPartyRelationServiceImpl
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param dao
	 * @throws
	 */
	public ZlxqPartyRelationServiceImpl(ZlxqPartyRelationDao zlxqPartyRelationDao) {
		super(zlxqPartyRelationDao);
		this.zlxqPartyRelationDao = zlxqPartyRelationDao;
	}

}

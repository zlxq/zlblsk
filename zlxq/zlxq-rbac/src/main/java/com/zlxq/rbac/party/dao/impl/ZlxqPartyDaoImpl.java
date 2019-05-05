package com.zlxq.rbac.party.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.party.dao.ZlxqPartyDao;

import pojo.ZlxqParty;

/**
 * @ClassName: ZlxqPartyDaoImpl.java
 * @Description: TODO(方法描述)
 * @author: PUB
 * @date: 2019年4月17日 下午10:30:24
 *
 * @param <T>
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 *
 */
public class ZlxqPartyDaoImpl extends BaseDaoImpl<ZlxqParty> implements ZlxqPartyDao {

	/**
	 * @Title: ZlxqPartyDaoImpl
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param persistType
	 * @throws
	 */
	public ZlxqPartyDaoImpl() {
		super(ZlxqParty.class);
	}

	/**
	 * @MethodName: getPartyByUserNo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: PUB
	 * @date: 2019年5月5日 下午2:47:23
	 * @param userno
	 * @return
	 * @throws
	 */
	
	@Override
	public ZlxqParty getPartyByUser(String userno, String password) {
		String hql = "select t from ZlxqParty t where t.isvalidate = '1'";
		
		if (StringUtils.isNotEmpty(userno)) {
			hql += " and t.loginno = '" + userno.toUpperCase() + "'";
		}
		if (StringUtils.isNotEmpty(password)) {
			hql += " and t.password = '" + password.toUpperCase() + "'";
		}
		@SuppressWarnings("unchecked")
		List<ZlxqParty> list = (List<ZlxqParty>) findByHQL(hql);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}

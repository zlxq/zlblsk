package com.zlxq.rbac.party.dao.impl;

import java.util.List;

import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;
import com.zlxq.rbac.party.dao.ZlxqPartyRelationDao;

import pojo.ZlxqPartyRelation;

public class ZlxqPartyRelationDaoImpl extends BaseDaoImpl<ZlxqPartyRelation> implements ZlxqPartyRelationDao {

	public ZlxqPartyRelationDaoImpl() {
		super(ZlxqPartyRelation.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zlxq.rbac.party.dao.ZlxqPartyRelationDao#getCPartyByPartyno(java.lang.
	 * String)
	 */
	@Override
	public List getCPartyByPartyno(String partyno) {
		String sql = "SELECT ZPR.* FROM ZLXQ_PARTY ZP, ZLXQ_PARTY_RELATION ZPR WHERE ZP.PARTYNO = '" + partyno
				+ " AND 'ZPR.PARTYID1 = ZP.ID AND ZP.ISVALIDATE = '" + ConstantRBAC.Y_ISVALIDATE
				+ "' AND ZPR.ISVALIDATE = '" + ConstantRBAC.Y_ISVALIDATE + "'";
		return findByJDBCReturnList(sql);
	}

}

package com.zlxq.rbac.party.dao.impl;

import java.util.List;

import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;
import com.zlxq.rbac.party.dao.ZlxqPartyRelationDao;

import pojo.ZlxqParty;
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

	/* (non-Javadoc)
	 * @see com.zlxq.rbac.party.dao.ZlxqPartyRelationDao#getPidByCid(java.lang.Long)
	 */
	@Override
	public ZlxqPartyRelation getPidByCid(Long cid) {
		String hql = "select t from ZlxqPartyRelation t where t.zlxqPartyByPartyid2.id = "+cid+" and t.isvalidate = '"+ConstantRBAC.Y_ISVALIDATE+"'";
		List<ZlxqPartyRelation> list = (List<ZlxqPartyRelation>) findByHQL(hql);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}

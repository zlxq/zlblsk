package com.zlxq.rbac.party.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;
import com.zlxq.rbac.party.dao.ZlxqPartyDao;

import pojo.ZlxqParty;

public class ZlxqPartyDaoImpl extends BaseDaoImpl<ZlxqParty> implements ZlxqPartyDao {

	public ZlxqPartyDaoImpl() {
		super(ZlxqParty.class);
	}

	@Override
	public ZlxqParty getPartyByUser(String userno, String password) {
		String hql = "select t from ZlxqParty t where t.isvalidate = '" + ConstantRBAC.Y_ISVALIDATE + "'";

		if (StringUtils.isNotEmpty(userno)) {
			hql += " and t.loginno = '" + userno.toUpperCase() + "'";
		}
		if (StringUtils.isNotEmpty(password)) {
			hql += " and t.password = '" + password.toUpperCase() + "'";
		}
//		Query<?> query = this.createQuery(hql);
//		query.setString("0", userno.toUpperCase());
//		query.setString("1", password.toUpperCase());
		@SuppressWarnings("unchecked")
		List<ZlxqParty> list = (List<ZlxqParty>) findByHQL(hql);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zlxq.rbac.party.dao.ZlxqPartyDao#getPartyByPartno(java.lang.String)
	 */
	@Override
	public List getPartyByPartno(String partyno) {
		String sql = "SELECT * FROM ZLXQ_PARTY WHERE PARTYNO = '" + partyno + "' AND ISVALIDATE = '"
				+ ConstantRBAC.Y_ISVALIDATE + "'";
		return findByJDBCReturnList(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zlxq.rbac.party.dao.ZlxqPartyDao#getCompanyPage(com.framework.util.
	 * PagingBean, java.lang.String)
	 */
	@Override
	public String getCompanyPage(PagingBean pb, String partytype) {
		String sql = "SELECT * FROM ZLXQ_PARTY ZP WHERE ZP.PARTYTYPE = '" + partytype + "' AND ZP.ISVALIDATE = '"
				+ ConstantRBAC.Y_ISVALIDATE + "'";
		return findByJDBCReturnJSON(pb, sql);
	}

}

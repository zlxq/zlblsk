package com.zlxq.rbac.party.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;
import com.zlxq.rbac.base.util.DictUtil;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zlxq.rbac.party.dao.ZlxqPartyDao#getDeptTree(java.lang.String)
	 */
	@Override
	public String getDeptTree(String id) {
		String sql = "select zp.id,\n" + "       concat('[', zp.partyno, ']', zp.partyname) text,\n"
				+ "       zp.isleaf state\n" + "  from zlxq_party_relation zpr, zlxq_party zp\n" + " where zpr.type = '"
				+ DictUtil.partyRel_lx.partyRel_gshzz + "' and zpr.isvalidate = '" + ConstantRBAC.Y_ISVALIDATE
				+ "' AND zp.isvalidate = '" + ConstantRBAC.Y_ISVALIDATE + "'\n" + "   and zp.id = zpr.partyid2";

		if (StringUtils.isNotEmpty(id)) {
			sql += " and zpr.partyid1 = " + id + "";
		} else {
			sql += " and zpr.partyid1 is null";

		}

		sql += " order by zp.id asc";
		return findByJDBCReturnJSON(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zlxq.rbac.party.dao.ZlxqPartyDao#getDeptGrid(com.framework.util.
	 * PagingBean, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String getDeptGrid(PagingBean pb, String id, String partyno, String partyname) {
		String sql = "SELECT zp.id, zp.partyno, zp.partyname FROM zlxq_party_relation zpr, zlxq_party zp WHERE zpr.partyid2 = zp.id AND zpr.type = '"
				+ DictUtil.partyRel_lx.partyRel_gshzz + "'  AND zpr.isvalidate = '" + ConstantRBAC.Y_ISVALIDATE
				+ "' AND zp.isvalidate = '" + ConstantRBAC.Y_ISVALIDATE + "'";

		if (StringUtils.isNotEmpty(id)) {
			sql += " and zpr.PARTYID1 = " + id + "";
		} else {
			sql += " and zpr.PARTYID1 is null";
		}

		if (StringUtils.isNotEmpty(partyno)) {
			sql += " and upper(zp.partyno) like '%" + partyno.toUpperCase() + "%'";
		}
		if (StringUtils.isNotEmpty(partyname)) {
			sql += " and upper(zp.partyname) like '%" + partyname.toUpperCase() + "%'";
		}

		sql += " order by zp.id asc";

		return findByJDBCReturnJSON(pb, sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zlxq.rbac.party.dao.ZlxqPartyDao#getUserPage(com.framework.util.
	 * PagingBean, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String getUserPage(PagingBean pb, String id, String partyno, String partyname) {
		String sql = "SELECT zp.id, zp.partyno, zp.partyname, zp.partytype,(CASE WHEN zp.sex = '1' THEN '女' ELSE '男' END) sex"
				+ ", zp.tel, zp.email FROM zlxq_party zp, zlxq_party_relation zpr WHERE zp.id = zpr.partyid2 AND zpr.type = '"
				+ DictUtil.partyRel_lx.partyRel_zzhr + "' AND zp.isvalidate = '" + ConstantRBAC.Y_ISVALIDATE
				+ "' AND zpr.isvalidate = '" + ConstantRBAC.Y_ISVALIDATE + "'";
		if (StringUtils.isEmpty(id) && "null".equals(id)) {
			sql += " AND zpr.partyid1 IS NULL";
		} else {
			sql += " AND zpr.partyid1 = '" + id + "'";
		}

		if (StringUtils.isNotEmpty(partyno)) {
			sql += " and upper(zp.partyno) like '%" + partyno.toUpperCase() + "%'";
		}
		if (StringUtils.isNotEmpty(partyname)) {
			sql += " and upper(zp.partyname) like '%" + partyname.toUpperCase() + "%'";
		}
		sql += " order by zp.id";
		return findByJDBCReturnJSON(pb, sql);
	}

}

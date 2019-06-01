/**
 * 
 */
package com.blsk.inv.invorder.dao.impl;

import org.apache.commons.lang.StringUtils;

import com.blsk.inv.invorder.dao.BlskBillInfoDao;
import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;

import pojo.BlskBillInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskBillInfoDaoImpl extends BaseDaoImpl<BlskBillInfo> implements BlskBillInfoDao {

	/**
	 * @author zhangl
	 *
	 * @param persistType
	 *
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public BlskBillInfoDaoImpl() {
		super(BlskBillInfo.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.blsk.inv.invorder.dao.BlskBillInfoDao#getOrderPage(com.framework.util.
	 * PagingBean, java.lang.String)
	 */
	@Override
	public String getOrderPage(PagingBean pb, String orderType) {
		String sql = "SELECT\n" + "  a.ID,\n" + "  A.BILLNO,\n" + "  A.BILLNAME,\n" + "  A.BILLTYPE,\n"
				+ "  FN_GETDICNAME(A.BILLTYPE) BILLTYPENAME,\n" + "  A.BILLSTATE,\n"
				+ "  FN_GETDICNAME(A.BILLSTATE) BILLSTATENAME,\n" + "  A.USERID,\n" + "  A.USERNAME,\n"
				+ "  DATE_FORMAT(a.REQ_TIME, '%Y-%m-%d %H:%i') REQTIME\n" + "FROM\n" + "  blsk_bill_info a\n"
				+ "WHERE a.isvalidate = '1'";
		if (StringUtils.isNotEmpty(orderType)) {
			sql += " AND BILLTYPE = '" + orderType + "'";
		}
		return findByJDBCReturnJSON(pb, sql);
	}

}

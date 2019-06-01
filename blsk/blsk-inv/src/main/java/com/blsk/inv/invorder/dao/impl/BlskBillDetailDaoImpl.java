/**
 * 
 */
package com.blsk.inv.invorder.dao.impl;

import java.util.List;

import com.blsk.inv.invorder.dao.BlskBillDetailDao;
import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;

import pojo.BlskBillDetail;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskBillDetailDaoImpl extends BaseDaoImpl<BlskBillDetail> implements BlskBillDetailDao {

	/**
	 * @author zhangl
	 *
	 * @param persistType
	 *
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public BlskBillDetailDaoImpl() {
		super(BlskBillDetail.class);
	}

	/* (non-Javadoc)
	 * @see com.blsk.inv.invorder.dao.BlskBillDetailDao#getOrderDetailPage(com.framework.util.PagingBean, java.lang.String)
	 */
	@Override
	public String getOrderDetailPage(PagingBean pb, String orderid) {
		String sql = "SELECT * FROM BLSK_BILL_DETAIL WHERE BILLID = '"+orderid+"' AND ISVALIDATE = '"+ConstantRBAC.Y_ISVALIDATE+"'";
		return findByJDBCReturnJSON(pb, sql);
	}

	/* (non-Javadoc)
	 * @see com.blsk.inv.invorder.dao.BlskBillDetailDao#getDetailByOrderid(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BlskBillDetail> getDetailByOrderid(Long id) {
		String hql = "SELECT t FROM BlskBillDetail t WHERE t.blskBillInfo.id = "+id+" AND t.isvalidate = '"+ConstantRBAC.Y_ISVALIDATE+"'";
		return (List<BlskBillDetail>) findByHQL(hql);
	}

}

/**
 * 
 */
package com.blsk.inv.qrcode.dao.impl;

import java.util.List;

import com.blsk.inv.qrcode.dao.BlskQrcodeInfoDao;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;

import pojo.BlskQrcodeInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskQrcodeInfoDaoImpl extends BaseDaoImpl<BlskQrcodeInfo> implements BlskQrcodeInfoDao {

	/**
	 * @author zhangl
	 *
	 * @param persistType
	 *
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public BlskQrcodeInfoDaoImpl() {
		super(BlskQrcodeInfo.class);
	}

	/* (non-Javadoc)
	 * @see com.blsk.inv.qrcode.dao.BlskQrcodeInfoDao#getQrcodeByCompanyId(java.lang.Long)
	 */
	@Override
	public List getQrcodeByCompanyId(Long companyId, String qrtype) {
		String sql = "SELECT * FROM BLSK_QRCODE_INFO WHERE DEPTID = '"+companyId+"' AND TYPE = '"+qrtype+"' AND ISVALIDATE = '"+ConstantRBAC.Y_ISVALIDATE+"'";
		return findByJDBCReturnList(sql);
	}

}

/**
 * 
 */
package com.blsk.inv.material.dao.impl;

import com.blsk.inv.material.dao.BlskMaterialInfoDao;
import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;

import pojo.BlskMaterialInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskMaterialInfoDaoImpl extends BaseDaoImpl<BlskMaterialInfo> implements BlskMaterialInfoDao {

	/**
	 * @author zhangl
	 *
	 * @param persistType
	 *
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public BlskMaterialInfoDaoImpl() {
		super(BlskMaterialInfo.class);
	}

	/* (non-Javadoc)
	 * @see com.blsk.inv.material.dao.BlskMaterialInfoDao#getMaterialPage(com.framework.util.PagingBean)
	 */
	@Override
	public String getMaterialPage(PagingBean pb) {
		String sql = "SELECT * FROM BLSK_MATERIAL_INFO WHERE ISVALIDATE = '"+ConstantRBAC.Y_ISVALIDATE+"'";
		return findByJDBCReturnJSON(pb, sql);
	}

}

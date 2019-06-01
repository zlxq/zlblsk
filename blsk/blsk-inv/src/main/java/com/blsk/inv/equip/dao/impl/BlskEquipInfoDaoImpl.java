/**
 * 
 */
package com.blsk.inv.equip.dao.impl;

import com.blsk.inv.equip.dao.BlskEquipInfoDao;
import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;

import pojo.BlskEquipInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月30日
 * @version V1.0
 */
public class BlskEquipInfoDaoImpl extends BaseDaoImpl<BlskEquipInfo> implements BlskEquipInfoDao {

	/**
	 * @author zhangl
	 *
	 * @param persistType
	 *
	 * @createtime 2019年5月30日
	 * @version V1.0
	 */
	public BlskEquipInfoDaoImpl() {
		super(BlskEquipInfo.class);
	}

	/* (non-Javadoc)
	 * @see com.blsk.inv.equip.dao.BlskEquipInfoDao#getEquipPage(com.framework.util.PagingBean)
	 */
	@Override
	public String getEquipPage(PagingBean pb) {
		String sql = "SELECT * FROM BLSK_EQUIP_INFO WHERE ISVALIDATE = '"+ConstantRBAC.Y_ISVALIDATE+"'";
		return findByJDBCReturnJSON(pb, sql);
	}

}

/**
 * 
 */
package com.blsk.inv.equip.dao.impl;

import com.blsk.inv.equip.dao.BlskEquipInfoDao;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;

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

}

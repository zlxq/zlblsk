/**
 * 
 */
package com.blsk.inv.equip.service.impl;

import com.blsk.inv.equip.dao.BlskEquipInfoDao;
import com.blsk.inv.equip.service.BlskEquipInfoService;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;

import pojo.BlskEquipInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月30日
 * @version V1.0
 */
public class BlskEquipInfoServiceImpl extends BaseServiceImpl<BlskEquipInfo> implements BlskEquipInfoService {

	private BlskEquipInfoDao blskEquipInfoDao;
	
	/**
	 * @author zhangl
	 *
	 * @param dao
	 *
	 * @createtime 2019年5月30日
	 * @version V1.0
	 */
	public BlskEquipInfoServiceImpl(BlskEquipInfoDao blskEquipInfoDao) {
		super(blskEquipInfoDao);
		this.blskEquipInfoDao = blskEquipInfoDao;
	}

}

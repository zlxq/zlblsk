/**
 * 
 */
package com.blsk.inv.equip.dao.impl;

import com.blsk.inv.equip.dao.BlskEquipItemDao;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;

import pojo.BlskEquipItem;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月30日
 * @version V1.0
 */
public class BlskEquipItemDaoImpl extends BaseDaoImpl<BlskEquipItem> implements BlskEquipItemDao {

	/**
	 * @author zhangl
	 *
	 * @param persistType
	 *
	 * @createtime 2019年5月30日
	 * @version V1.0
	 */
	public BlskEquipItemDaoImpl() {
		super(BlskEquipItem.class);
	}

}

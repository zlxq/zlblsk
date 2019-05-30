/**
 * 
 */
package com.blsk.inv.equip.service.impl;

import java.io.Serializable;

import com.blsk.inv.equip.dao.BlskEquipItemDao;
import com.blsk.inv.equip.service.BlskEquipItemService;
import com.framework.web.ssh.dao.GenericDao;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;

import pojo.BlskEquipItem;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月30日
 * @version V1.0
 */
public class BlskEquipItemServiceImpl extends BaseServiceImpl<BlskEquipItem> implements BlskEquipItemService {

	private BlskEquipItemDao blskEquipItemDao;
	
	/**
	 * @author zhangl
	 *
	 * @param dao
	 *
	 * @createtime 2019年5月30日
	 * @version V1.0
	 */
	public BlskEquipItemServiceImpl(BlskEquipItemDao blskEquipItemDao) {
		super(blskEquipItemDao);
		this.blskEquipItemDao = blskEquipItemDao;
	}

}

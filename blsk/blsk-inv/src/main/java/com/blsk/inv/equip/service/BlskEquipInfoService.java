/**
 * 
 */
package com.blsk.inv.equip.service;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.service.BaseService;

import pojo.BlskEquipInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月30日
 * @version V1.0
 */
public interface BlskEquipInfoService extends BaseService<BlskEquipInfo> {

	/**
	 * @TODO
	 * @author zhangl
	 *
	 * @param pb
	 * @return
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	String getEquipPage(PagingBean pb);

	/**
	 * @TODO
	 * @author zhangl
	 *
	 * @param blskEquipInfo
	 * @return
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	String saveEquip(BlskEquipInfo blskEquipInfo);

}

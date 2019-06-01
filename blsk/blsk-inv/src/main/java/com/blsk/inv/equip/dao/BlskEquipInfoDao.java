/**
 * 
 */
package com.blsk.inv.equip.dao;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.dao.BaseDao;

import pojo.BlskEquipInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月30日
 * @version V1.0
 */
public interface BlskEquipInfoDao extends BaseDao<BlskEquipInfo> {

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

}

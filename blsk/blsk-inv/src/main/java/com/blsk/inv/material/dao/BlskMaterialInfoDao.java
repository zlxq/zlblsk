/**
 * 
 */
package com.blsk.inv.material.dao;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.dao.BaseDao;

import pojo.BlskMaterialInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public interface BlskMaterialInfoDao extends BaseDao<BlskMaterialInfo> {

	/**
	 * @TODO
	 * @author zhangl
	 *
	 * @param pb
	 * @return
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	String getMaterialPage(PagingBean pb);

}

/**
 * 
 */
package com.blsk.inv.material.service;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.service.BaseService;

import pojo.BlskMaterialInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public interface BlskMaterialInfoService extends BaseService<BlskMaterialInfo> {

	/**
	 * @TODO 保存物料信息
	 * @author zhangl
	 *
	 * @param pb
	 * @return
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	String getMaterialPage(PagingBean pb);

	/**
	 * @TODO
	 * @author zhangl
	 *
	 * @param blskMaterialInfo
	 * @return
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	String saveMaterial(BlskMaterialInfo blskMaterialInfo);

}

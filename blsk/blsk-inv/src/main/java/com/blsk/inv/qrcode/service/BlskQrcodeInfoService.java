/**
 * 
 */
package com.blsk.inv.qrcode.service;

import com.zlxq.rbac.base.core.service.BaseService;

import pojo.BlskQrcodeInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public interface BlskQrcodeInfoService extends BaseService<BlskQrcodeInfo> {

	/**
	 * @TODO 通过单位查询执行码ID
	 * @author zhangl
	 *
	 * @param companyId
	 * @return
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	String getQrcodeByCompanyId(Long companyId);

}

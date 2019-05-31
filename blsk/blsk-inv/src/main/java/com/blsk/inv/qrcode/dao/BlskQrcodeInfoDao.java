/**
 * 
 */
package com.blsk.inv.qrcode.dao;

import java.util.List;

import com.zlxq.rbac.base.core.dao.BaseDao;

import pojo.BlskQrcodeInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public interface BlskQrcodeInfoDao extends BaseDao<BlskQrcodeInfo> {

	/**
	 * @TODO
	 * @author zhangl
	 *
	 * @param companyId
	 * @return
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	List getQrcodeByCompanyId(Long companyId);

}

/**
 * 
 */
package com.blsk.inv.material.service.impl;

import java.util.Date;

import com.blsk.inv.material.dao.BlskMaterialInfoDao;
import com.blsk.inv.material.service.BlskMaterialInfoService;
import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;
import com.zlxq.rbac.base.util.UserUtil;

import pojo.BlskMaterialInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskMaterialInfoServiceImpl extends BaseServiceImpl<BlskMaterialInfo> implements BlskMaterialInfoService {

	private BlskMaterialInfoDao blskMaterialInfoDao;
	
	/**
	 * @author zhangl
	 *
	 * @param dao
	 *
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public BlskMaterialInfoServiceImpl(BlskMaterialInfoDao blskMaterialInfoDao) {
		super(blskMaterialInfoDao);
		this.blskMaterialInfoDao = blskMaterialInfoDao;
	}

	/* (non-Javadoc)
	 * @see com.blsk.inv.material.service.BlskMaterialInfoService#getMaterialPage(com.framework.util.PagingBean)
	 */
	@Override
	public String getMaterialPage(PagingBean pb) {
		return this.blskMaterialInfoDao.getMaterialPage(pb);
	}

	/* (non-Javadoc)
	 * @see com.blsk.inv.material.service.BlskMaterialInfoService#saveMaterial(pojo.BlskMaterialInfo)
	 */
	@Override
	public String saveMaterial(BlskMaterialInfo blskMaterialInfo) {
		blskMaterialInfo.setDeptid(UserUtil.getCompanyId());
		blskMaterialInfo.setCreator(UserUtil.getUserId());
		blskMaterialInfo.setCreatetime(new Date());
		blskMaterialInfo.setIsvalidate(ConstantRBAC.Y_ISVALIDATE);
		
		try {
			this.blskMaterialInfoDao.save(blskMaterialInfo);
			return "保存成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "保存失败";
		}
	}

}

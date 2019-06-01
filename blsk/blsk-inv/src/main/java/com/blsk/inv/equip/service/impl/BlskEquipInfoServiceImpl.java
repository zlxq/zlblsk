/**
 * 
 */
package com.blsk.inv.equip.service.impl;

import java.util.Date;

import com.blsk.inv.equip.dao.BlskEquipInfoDao;
import com.blsk.inv.equip.service.BlskEquipInfoService;
import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;
import com.zlxq.rbac.base.util.UserUtil;

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

	/* (non-Javadoc)
	 * @see com.blsk.inv.equip.service.BlskEquipInfoService#getEquipPage(com.framework.util.PagingBean)
	 */
	@Override
	public String getEquipPage(PagingBean pb) {
		return this.blskEquipInfoDao.getEquipPage(pb);
	}

	/* (non-Javadoc)
	 * @see com.blsk.inv.equip.service.BlskEquipInfoService#saveEquip(pojo.BlskEquipInfo)
	 */
	@Override
	public String saveEquip(BlskEquipInfo blskEquipInfo) {
		blskEquipInfo.setDeptid(UserUtil.getCompanyId());
		blskEquipInfo.setCreator(UserUtil.getUserId());
		blskEquipInfo.setCreatetime(new Date());
		blskEquipInfo.setIsvalidate(ConstantRBAC.Y_ISVALIDATE);
		try {
			this.blskEquipInfoDao.save(blskEquipInfo);
			return "保存成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "保存失败";
		}
	}

}

/**
 * 
 */
package com.blsk.inv.equip.action;

import javax.annotation.Resource;

import com.blsk.inv.equip.service.BlskEquipInfoService;
import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.action.BaseAction;

import pojo.BlskEquipInfo;

/**
 * @TODO 设备基本信息处理类
 * @author zhangl
 *
 * @createtime 2019年5月30日
 * @version V1.0
 */
public class BlskEquipInfoAction extends BaseAction {

	@Resource
	private BlskEquipInfoService blskEquipInfoService;
	
	private BlskEquipInfo blskEquipInfo;
	/**
	 * @TODO 查询设备信息
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public String getEquipPage() {
		PagingBean pb = this.getInitPagingBean();
		String json = this.blskEquipInfoService.getEquipPage(pb);
		setJsonString(json);
		return SUCCESS;
	}
	
	public String saveEquip() {
		this.blskEquipInfo.setEquipState("1");
		String msg = this.blskEquipInfoService.saveEquip(this.blskEquipInfo);
		setMessage(msg);
		return SUCCESS;
	}

	/**
	 * @return the blskEquipInfo
	 */
	public BlskEquipInfo getBlskEquipInfo() {
		return blskEquipInfo;
	}

	/**
	 * @param blskEquipInfo the blskEquipInfo to set
	 */
	public void setBlskEquipInfo(BlskEquipInfo blskEquipInfo) {
		this.blskEquipInfo = blskEquipInfo;
	}
	
}

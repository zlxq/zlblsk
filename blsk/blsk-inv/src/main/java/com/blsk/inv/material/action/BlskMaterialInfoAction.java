/**
 * 
 */
package com.blsk.inv.material.action;

import javax.annotation.Resource;

import com.blsk.inv.material.service.BlskMaterialInfoService;
import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.action.BaseAction;

import pojo.BlskMaterialInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskMaterialInfoAction extends BaseAction {

	@Resource
	private BlskMaterialInfoService blskMaterialInfoService;
	
	private BlskMaterialInfo blskMaterialInfo;
	
	/**
	 * @TODO 查询物料信息
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public String getMaterialPage() {
		PagingBean pb = this.getInitPagingBean();
		String json = this.blskMaterialInfoService.getMaterialPage(pb);
		setJsonString(json);
		return SUCCESS;
	}
	
	/**
	 * @TODO 保存物料信息
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public String saveMaterial() {
		String msg = this.blskMaterialInfoService.saveMaterial(this.blskMaterialInfo);
		setMessage(msg);
		return SUCCESS;
	}

	/**
	 * @return the blskMaterialInfo
	 */
	public BlskMaterialInfo getBlskMaterialInfo() {
		return blskMaterialInfo;
	}

	/**
	 * @param blskMaterialInfo the blskMaterialInfo to set
	 */
	public void setBlskMaterialInfo(BlskMaterialInfo blskMaterialInfo) {
		this.blskMaterialInfo = blskMaterialInfo;
	}
}

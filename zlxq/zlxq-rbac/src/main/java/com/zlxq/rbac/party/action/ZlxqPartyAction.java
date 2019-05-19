package com.zlxq.rbac.party.action;

import javax.annotation.Resource;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.action.BaseAction;
import com.zlxq.rbac.base.util.DictUtil;
import com.zlxq.rbac.party.service.ZlxqPartyService;

import pojo.ZlxqParty;

/**
 * @author zhangl
 *
 * @createtime 2019年5月19日
 * @version V1.0
 */
public class ZlxqPartyAction extends BaseAction {

	@Resource
	private ZlxqPartyService zlxqPartyService;
	
	private ZlxqParty zlxqParty;
	
	/**
	 * @TODO 查询公司信息
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2019年5月20日
	 * @version V1.0
	 */
	public String getCompanyPage() {
		PagingBean pb = this.getInitPagingBean();
		String partytype = DictUtil.dept_lx.dept_gs;
		String json = this.zlxqPartyService.getCompanyPage(pb, partytype);
		setJsonString(json);
		return SUCCESS;
	}
	
	/**
	 * @todo(保存单位)
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2019年5月19日
	 * @version V1.0
	 */
	public String saveCompany() {
		
		String partytype = DictUtil.dept_lx.dept_gs;
		String relationType = DictUtil.partyRel_lx.partyRel_gs;
		String msg = this.zlxqPartyService.saveDept(this.zlxqParty, null, partytype, relationType);
		setMessage(msg);
		return SUCCESS;
	}

	/**
	 * @return the zlxqParty
	 */
	public ZlxqParty getZlxqParty() {
		return zlxqParty;
	}

	/**
	 * @param zlxqParty the zlxqParty to set
	 */
	public void setZlxqParty(ZlxqParty zlxqParty) {
		this.zlxqParty = zlxqParty;
	}
}

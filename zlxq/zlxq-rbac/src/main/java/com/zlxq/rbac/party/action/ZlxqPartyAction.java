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
		String relationType = DictUtil.partyRel_lx.partyRel_gshzz;
		String msg = this.zlxqPartyService.saveDept(this.zlxqParty, null, partytype, relationType);
		setMessage(msg);
		return SUCCESS;
	}
	
	/**
	 * @TODO 查询组织树
	 * 
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2017年7月5日
	 * @version V1.0
	 */
	public String getDeptTree() {
		String id = this.getRequest().getParameter("id");
		String json = this.zlxqPartyService.getDeptTree(id);
		setJsonString(json);
		return SUCCESS;
	}
	
	/**
	 * @TODO 点击组织树，平铺展示字典信息
	 * 
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2017年7月5日
	 * @version V1.0
	 */
	public String getDeptGrid() {
		String id = this.getRequest().getParameter("id");
		String partyno = this.getRequest().getParameter("partyno");
		String partyname = this.getRequest().getParameter("partyname");
		PagingBean pb = this.getInitPagingBean();
		String json = this.zlxqPartyService.getDeptGrid(pb, id, partyno, partyname);
		setJsonString(json);
		return SUCCESS;
	}
	
	/**
	 * @TODO 保存单位
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2019年5月24日
	 * @version V1.0
	 */
	public String saveDept() {
		String pid = this.getRequest().getParameter("pid");
		String partytype = DictUtil.dept_lx.dept_bm;
		String relationType = DictUtil.partyRel_lx.partyRel_gshzz;
		String msg = this.zlxqPartyService.saveDept(this.zlxqParty, pid, partytype, relationType);
		setMessage(msg);
		return SUCCESS;
	}
	
	/**
	 * @TODO 查询学生信息
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2017年7月9日
	 * @version V1.0
	 */
	public String getUserPage() {
		PagingBean pb = getInitPagingBean();
		String id = this.getRequest().getParameter("id");
		String partyno = this.getRequest().getParameter("partyno");
		String partyname = this.getRequest().getParameter("partyname");
		String json = this.zlxqPartyService.getUserPage(pb, id, partyno, partyname);
		setJsonString(json);
		return SUCCESS;
	}
	
	/**
	 * @TODO 保存用户
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2017年7月9日
	 * @version V1.0
	 */
	public String saveParty() {
		String pid = this.getRequest().getParameter("pid");
		String partytype = DictUtil.dept_lx.dept_ry;
		String relationType = DictUtil.partyRel_lx.partyRel_zzhr;
		this.zlxqParty.setLoginno(this.zlxqParty.getPartyno());
		String msg = this.zlxqPartyService.saveDept(this.zlxqParty, pid, partytype, relationType);
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

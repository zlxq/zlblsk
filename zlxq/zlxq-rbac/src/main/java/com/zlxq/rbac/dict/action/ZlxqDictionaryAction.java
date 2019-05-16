package com.zlxq.rbac.dict.action;

import javax.annotation.Resource;

import com.zlxq.rbac.base.core.action.BaseAction;
import com.zlxq.rbac.dict.service.ZlxqDictionaryService;

import pojo.ZlxqDictionary;


public class ZlxqDictionaryAction extends BaseAction {

	@Resource
	private ZlxqDictionaryService zlxqDictionaryService;
	
	private ZlxqDictionary zlxqDictionary;
	/**
	 * 查询字典树
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2017年7月5日
	 * @version V1.0
	 */
	public String getDictTree() {
		String id = this.getRequest().getParameter("id");
		String json = this.zlxqDictionaryService.getDictTree(id);
		setJsonString(json);
		return SUCCESS;
	}
	
	/**
	 * 点击字典树，平铺展示字典信息
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2017年7月5日
	 * @version V1.0
	 */
	public String getDictGrid() {
		String id = this.getRequest().getParameter("id");
		String json = this.zlxqDictionaryService.getDictGrid(id);
		setJsonString(json);
		return SUCCESS;
	}
	
	/**
	 * 保存字典
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2017年7月5日
	 * @version V1.0
	 */
	public String saveDict() {
		String pid = this.getRequest().getParameter("pid");
		String msg = this.zlxqDictionaryService.saveDict(this.zlxqDictionary, pid);
		setMessage(msg);
		return SUCCESS;
	}

	/**
	 * 修改字典数据
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2017年7月5日
	 * @version V1.0
	 */
	public String editDict() {
		String id = this.getRequest().getParameter("id");
		String msg = this.zlxqDictionaryService.editDict(this.zlxqDictionary, id);
		setMessage(msg);
		return SUCCESS;
	}
	
	/**
	 * 删除字典
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2017年7月20日
	 * @version V1.0
	 */
	public String delDict() {
		String ids = this.getRequest().getParameter("ids");
		String msg = this.zlxqDictionaryService.delDict(ids);
		setMessage(msg);
		return SUCCESS;
	}

	public ZlxqDictionary getZlxqDictionary() {
		return zlxqDictionary;
	}
	

	public void setZlxqDictionary(ZlxqDictionary zlxqDictionary) {
		this.zlxqDictionary = zlxqDictionary;
	}
}

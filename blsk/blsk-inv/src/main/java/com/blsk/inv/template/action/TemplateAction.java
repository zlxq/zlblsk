package com.blsk.inv.template.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONException;

import com.blsk.inv.template.service.BlskTemplateDetailService;
import com.blsk.inv.template.service.BlskTemplateMainService;
import com.zlxq.rbac.base.core.action.BaseAction;

public class TemplateAction extends BaseAction {

	@Resource
	private BlskTemplateDetailService blskTemplateDetailService;
	
	@Resource
	private BlskTemplateMainService blskTemplateMainService;
	/**
	 * 保存单据模板信息
	 * @author sundd
	 *
	 * @return
	 * @createtime 2019年5月17日
	 * @version V1.0
	 * @throws Exception 
	 */
	public String saveTemplate(){
		String data = this.getRequest().getParameter("data");
		String headInLine = this.getRequest().getParameter("headInLine");
		String orderName = this.getRequest().getParameter("orderName");
		String templatetype = this.getRequest().getParameter("templatetype");
		String choosefile = this.getRequest().getParameter("choosefile");
		String orderContxtInLine = this.getRequest().getParameter("orderContxtInLine");
		String templeteName = this.getRequest().getParameter("templeteName");
		String headName = this.getRequest().getParameter("headName");
		System.out.println(choosefile);
		Map<String, String> map = new HashMap<String, String>();
		map.put("data", data);
		map.put("headInLine", headInLine);
		map.put("orderName", orderName);
		map.put("templatetype", templatetype);
		map.put("choosefile", choosefile);
		map.put("orderContxtInLine", orderContxtInLine);
		map.put("templeteName", templeteName);
		map.put("headName", headName);
		String msg = "保存失败";
		try {
			msg = this.blskTemplateMainService.saveTemplate(map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.getMessage();
		}
		setMessage(msg);
		return SUCCESS;
	}

	
}

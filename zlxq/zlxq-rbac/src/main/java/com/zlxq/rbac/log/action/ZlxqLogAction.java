package com.zlxq.rbac.log.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.framework.util.IPUtil;
import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.action.BaseAction;
import com.zlxq.rbac.log.service.ZlxqLogService;

import pojo.ZlxqLog;

public class ZlxqLogAction extends BaseAction {

	@Resource
	private ZlxqLogService zlxqLogService;

	public String getUserIp() {
		String ip = IPUtil.getIpAddr(this.getRequest());
		return SUCCESS;
	}

	/**
	 * 查询用户登录信息
	 * 
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2017年10月30日
	 * @version V1.0
	 */
	public String getLogInfo() {
		PagingBean pb = this.getInitPagingBean();
		String loginno = this.getRequest().getParameter("loginno");
		String loginname = this.getRequest().getParameter("loginname");
		String json = this.zlxqLogService.getLogInfo(pb, loginno, loginname);
		setJsonString(json);
		return SUCCESS;
	}

	/**
	 * 导出系统日志
	 * 
	 * @author sundd
	 *
	 * @return
	 * @createtime 2018年03月02日
	 * @version V1.0
	 */
	public void exportSysLog() {
		try {
			String ids = this.getRequest().getParameter("ids");
			// 1.查找用户列表
			List<ZlxqLog> logList = zlxqLogService.getSysLog(ids);
			// 2.导出
			HttpServletResponse response = ServletActionContext.getResponse();
			// 这里设置的文件格式是application/x-excel
			response.setContentType("application/x-excel");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String("syslog.xls".getBytes(), "ISO-8859-1"));
			ServletOutputStream outputStream = response.getOutputStream();
			zlxqLogService.exportSysLog(logList, outputStream);
			if (outputStream != null)
				outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

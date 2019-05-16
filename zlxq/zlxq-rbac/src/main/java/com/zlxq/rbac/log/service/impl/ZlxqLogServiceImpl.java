package com.zlxq.rbac.log.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;

import com.framework.util.IPUtil;
import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.base.util.ReadExcelUtils;
import com.zlxq.rbac.log.dao.ZlxqLogDao;
import com.zlxq.rbac.log.service.ZlxqLogService;

import pojo.ZlxqLog;

public class ZlxqLogServiceImpl extends BaseServiceImpl<ZlxqLog> implements ZlxqLogService {

	private ZlxqLogDao zlxqLogDao;
	public ZlxqLogServiceImpl(ZlxqLogDao zlxqLogDao) {
		super(zlxqLogDao);
		this.zlxqLogDao = zlxqLogDao;
	}
	
	@Override
	public String getLogInfo(PagingBean pb, String loginno, String loginname) {
		return this.zlxqLogDao.getLogInfo(pb, loginno, loginname);
	}

	@Override
	public void saveLoginLog(HttpServletRequest request, String userno, String username, String logintype) {
		
		String loginip = IPUtil.getIpAddr(request);
		
		ZlxqLog zlxqLog = new ZlxqLog();
		
		zlxqLog.setLoginno(userno);
		zlxqLog.setLoginname(username);
		zlxqLog.setLogintime(new Date());
		zlxqLog.setLogintype(logintype);
		zlxqLog.setLoginip(loginip);
		zlxqLog.setCreatetime(new Date());
		zlxqLog.setIsvalidate("1");
		
		this.zlxqLogDao.save(zlxqLog);
		
	}

	@Override
	public List<ZlxqLog> getSysLog(String ids) {
		String id = null;
		if (null != ids && ids.length() > 0) {
			
			try {
				
				JSONArray ja = new JSONArray(ids);
				for(int i = 0; i < ja.length(); i++ ){
					String idd = ja.getString(i);
					if(i == 0){
						id = "'" + idd + "'";
					}else {
						id = id + "," + "'" + idd + "'";
					}
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return  this.zlxqLogDao.getSysLog(id);
	}
	
	@Override
	public void exportSysLog(List<ZlxqLog> logList, ServletOutputStream outputStream) {
		ReadExcelUtils.exportUserExcel(logList, outputStream);
	}

}

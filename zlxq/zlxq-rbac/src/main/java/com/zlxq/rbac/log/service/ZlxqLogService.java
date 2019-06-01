package com.zlxq.rbac.log.service;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.service.BaseService;

import pojo.ZlxqLog;

public interface ZlxqLogService extends BaseService<ZlxqLog> {

	/**
	 * 查询用户登录信息
	 * @author zhangl
	 *
	 * @param pb
	 * @return
	 * @createtime 2017年10月30日
	 * @version V1.0
	 * @param loginname 
	 * @param loginno 
	 */
	String getLogInfo(PagingBean pb, String loginno, String loginname);

	/**
	 * 保存登陆信息
	 * @author zhangl
	 *
	 * @param request
	 * @createtime 2017年10月30日
	 * @version V1.0
	 */
	void saveLoginLog(HttpServletRequest request, String userno, String username, String logintype);

	/**
	 * 查询日志
	 * @param ids
	 * @return
	 */
	List<ZlxqLog> getSysLog(String ids);

	/**
	 * @MethodName: exportSysLog
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月16日 下午11:45:10
	 * @param logList
	 * @param outputStream
	 * @return: void
	 * @throws
	 */
	void exportSysLog(List<ZlxqLog> logList, ServletOutputStream outputStream);

}

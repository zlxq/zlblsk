package com.zlxq.rbac.log.dao;

import java.util.List;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.dao.BaseDao;

import pojo.ZlxqLog;

public interface ZlxqLogDao extends BaseDao<ZlxqLog> {

	/**
	 * 查询日志登陆信息
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
	 * 查询日志
	 * @param id
	 * @return
	 */
	List<ZlxqLog> getSysLog(String id);

}

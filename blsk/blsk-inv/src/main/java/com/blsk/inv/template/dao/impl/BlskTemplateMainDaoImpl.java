package com.blsk.inv.template.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.blsk.inv.template.dao.BlskTemplateMainDao;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;

import pojo.BlskTemplateMain;

public class BlskTemplateMainDaoImpl extends BaseDaoImpl<BlskTemplateMain> implements BlskTemplateMainDao {

	public BlskTemplateMainDaoImpl() {
		super(BlskTemplateMain.class);
	}

	@Override
	public BlskTemplateMain getTemplate(String header, String orderName, String templeteName, String templatetype) {
		String hql = "select t from BlskTemplateMain t where t.isvalidate = '1'";
		
		if (StringUtils.isNotEmpty(header)) {
			hql += " and t.header = '" + header + "'";
		}
		if (StringUtils.isNotEmpty(orderName)) {
			hql += " and t.orderno = '" + orderName + "'";
		}
		if (StringUtils.isNotEmpty(templatetype)) {
			hql += " and t.type = '" + templatetype + "'";
		}
		if (StringUtils.isNotEmpty(templeteName)) {
			hql += " and t.no = '" + templeteName + "'";
		}
		@SuppressWarnings("unchecked")
		List<BlskTemplateMain> list = (List<BlskTemplateMain>) findByHQL(hql);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public String getTemplates() {
//		String sql = 
//				"SELECT D.ID, (@rowNum:=@rowNum+1) AS LINENO, D.TEMPLATEID, D.TPL_HEADER LINENAME, D.O_HEADER SYSNAME FROM "
//				+ "BLSK_TEMPLATE_MAIN M, BLSK_TEMPLATE_DETAIL D, (SELECT @rowNum:=0) b WHERE M.ID = D.TEMPLATEID AND M.ISVALIDATE = '1' AND D.ISVALIDATE = '1'";
		String sql = "select * from BLSK_TEMPLATE_DETAIL d where d.isvalidate = '0'";
		return findByJDBCReturnJSON(sql);
	}


}

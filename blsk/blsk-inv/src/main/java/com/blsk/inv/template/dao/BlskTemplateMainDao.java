package com.blsk.inv.template.dao;

import com.zlxq.rbac.base.core.dao.BaseDao;

import pojo.BlskTemplateMain;

public abstract interface BlskTemplateMainDao extends BaseDao<BlskTemplateMain> {

	BlskTemplateMain getTemplate(String header, String orderName, String templeteName, String templatetype);

	String getTemplates();


}

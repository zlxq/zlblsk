package com.blsk.inv.template.service.impl;

import com.blsk.inv.template.dao.BlskTemplateDetailDao;
import com.blsk.inv.template.service.BlskTemplateDetailService;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;

import pojo.BlskTemplateDetail;

public class BlskTemplateDetailServiceImpl extends BaseServiceImpl<BlskTemplateDetail> implements BlskTemplateDetailService {

	private BlskTemplateDetailDao blskTemplateDetailDao;
	public BlskTemplateDetailServiceImpl(BlskTemplateDetailDao blskTemplateDetailDao) {
		super(blskTemplateDetailDao);
		this.blskTemplateDetailDao = blskTemplateDetailDao;
	}

}

package com.blsk.inv.template.service;

import java.io.IOException;
import java.util.Map;

import org.json.JSONException;

import com.zlxq.rbac.base.core.service.BaseService;

import pojo.BlskTemplateMain;

public abstract interface BlskTemplateMainService extends BaseService<BlskTemplateMain> {

	String saveTemplate(Map<String, String> map) throws IOException, JSONException, Exception;

	String getTemplate();

}

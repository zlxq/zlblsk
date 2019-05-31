/**
 * 
 */
package com.blsk.inv.qrcode.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.blsk.inv.qrcode.dao.BlskQrcodeInfoDao;
import com.blsk.inv.qrcode.service.BlskQrcodeInfoService;
import com.framework.util.JsonUtil;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.base.util.QrcodeUtil;
import com.zlxq.rbac.base.util.SequenceUtil;

import pojo.BlskQrcodeInfo;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskQrcodeInfoServiceImpl extends BaseServiceImpl<BlskQrcodeInfo> implements BlskQrcodeInfoService {

	private BlskQrcodeInfoDao blskQrcodeInfoDao;
	
	/**
	 * @author zhangl
	 *
	 * @param dao
	 *
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public BlskQrcodeInfoServiceImpl(BlskQrcodeInfoDao blskQrcodeInfoDao) {
		super(blskQrcodeInfoDao);
		this.blskQrcodeInfoDao = blskQrcodeInfoDao;
	}

	/* (non-Javadoc)
	 * @see com.blsk.inv.qrcode.service.BlskQrcodeInfoService#getQrcodeByCompanyId(java.lang.Long)
	 */
	@Override
	public String getQrcodeByCompanyId(Long companyId) {
		List qrList = this.blskQrcodeInfoDao.getQrcodeByCompanyId(companyId);
		String qrcode = SequenceUtil.getQrcode();
		if (qrList.size() > 0) {
			String listTOJson = JsonUtil.listTOJson(qrList);
			try {
				JSONArray ja = new JSONArray(listTOJson);
				JSONObject jsonObject = ja.getJSONObject(0);
				qrcode = jsonObject.getString("QRCODE");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return qrcode;
	}

	/**
	 * @TODO
	 * @author zhangl
	 *
	 * @return
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	private String generalQrcode() {
		// TODO Auto-generated method stub
		return null;
	}

}
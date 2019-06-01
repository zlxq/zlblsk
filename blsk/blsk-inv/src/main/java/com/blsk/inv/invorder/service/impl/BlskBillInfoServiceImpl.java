/**
 * 
 */
package com.blsk.inv.invorder.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;

import com.blsk.inv.invorder.dao.BlskBillInfoDao;
import com.blsk.inv.invorder.service.BlskBillDetailService;
import com.blsk.inv.invorder.service.BlskBillInfoService;
import com.blsk.inv.invworkbench.dao.BlskInvIoDao;
import com.blsk.inv.invworkbench.dao.BlskInvItemDao;
import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;
import com.zlxq.rbac.base.util.DictUtil;
import com.zlxq.rbac.base.util.SequenceUtil;
import com.zlxq.rbac.base.util.UserUtil;

import pojo.BlskBillDetail;
import pojo.BlskBillInfo;
import pojo.BlskInvIo;
import pojo.BlskInvItem;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class BlskBillInfoServiceImpl extends BaseServiceImpl<BlskBillInfo> implements BlskBillInfoService {

	private BlskBillInfoDao blskBillInfoDao;
	
	@Resource
	private BlskBillDetailService blskBillDetailService;
	@Resource
	private BlskInvIoDao blskInvIoDao;
	@Resource
	private BlskInvItemDao blskInvItemDao;
	
	/**
	 * @author zhangl
	 *
	 * @param dao
	 *
	 * @createtime 2019年5月31日
	 * @version V1.0
	 */
	public BlskBillInfoServiceImpl(BlskBillInfoDao blskBillInfoDao) {
		super(blskBillInfoDao);
		this.blskBillInfoDao = blskBillInfoDao;
	}

	/* (non-Javadoc)
	 * @see com.blsk.inv.invorder.service.BlskBillInfoService#getOrderPage(com.framework.util.PagingBean, java.lang.String)
	 */
	@Override
	public String getOrderPage(PagingBean pb, String orderType) {
		return this.blskBillInfoDao.getOrderPage(pb, orderType);
	}

	/* (non-Javadoc)
	 * @see com.blsk.inv.invorder.service.BlskBillInfoService#nextRCOrder()
	 */
	@Override
	public String nextRCOrder(String ids) {
		BlskBillInfo blskBillInfo = null;
		List<BlskBillDetail> bldList = null;
		
		try {
			JSONArray ja = new JSONArray(ids);
			
			for (int i = 0; i < ja.length(); i++) {
				Long id = ja.getLong(i);
				
				blskBillInfo = this.blskBillInfoDao.findByPk(id);
				
				bldList = blskBillDetailService.getDetailByOrderid(id);
				
				updateBillState(blskBillInfo);
				saveIoAandItem(blskBillInfo, bldList);
			}
			return "下发成功";
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "下发失败";
	}

	/**
	 * @TODO 更新单据状态
	 * @author zhangl
	 *
	 * @param blskBillInfo
	 * @createtime 2019年6月2日
	 * @version V1.0
	 */
	private void updateBillState(BlskBillInfo blskBillInfo) {
		blskBillInfo.setBillstate(DictUtil.orderState_lx.orderState_yxf);
		blskBillInfo.setUpdatetime(new Date());
		this.blskBillInfoDao.save(blskBillInfo);
	}

	/**
	 * @TODO 保存执行单据及明细信息
	 * @author zhangl
	 *
	 * @param blskBillInfo
	 * @param bldList
	 * @createtime 2019年6月2日
	 * @version V1.0
	 */
	private void saveIoAandItem(BlskBillInfo blskBillInfo, List<BlskBillDetail> bldList) {
		BlskInvIo blskInvIo = new BlskInvIo();
		blskInvIo.setBlskBillInfo(blskBillInfo);
		blskInvIo.setBillno(blskBillInfo.getBillno());
		blskInvIo.setIono(SequenceUtil.getIoNo());
		blskInvIo.setIotype(blskBillInfo.getBilltype());
		blskInvIo.setIostate(DictUtil.orderState_lx.orderState_yxf);
		blskInvIo.setExecType(DictUtil.orderExecType_lx.orderExecType_xjhy);//从仓库配中获取
		blskInvIo.setDeptid(UserUtil.getCompanyId());
		blskInvIo.setCreator(UserUtil.getUserId());
		blskInvIo.setCreatetime(new Date());
		blskInvIo.setIsvalidate(ConstantRBAC.Y_ISVALIDATE);
		
		blskInvIo = this.blskInvIoDao.save(blskInvIo);
		
		BlskBillDetail blskBillDetail = null;
		BlskInvItem blskInvItem = null;
		for (int i = 0; i < bldList.size(); i++) {
			blskBillDetail = bldList.get(i);
			
			blskInvItem = new BlskInvItem();
			
			blskInvItem.setBlskInvIo(blskInvIo);
			blskInvItem.setMaterialid(blskBillDetail.getMaterialid());
			blskInvItem.setMno(blskBillDetail.getMno());
			blskInvItem.setMcode(blskBillDetail.getMcode());
			blskInvItem.setMno(blskBillDetail.getMname());
			blskInvItem.setUserid(UserUtil.getUserId());
			blskInvItem.setUsername(UserUtil.getPartyName());
			blskInvItem.setReqNum(blskBillDetail.getCount());
			blskInvItem.setItemState(DictUtil.orderState_lx.orderState_yxf);
			blskInvItem.setItemType(blskBillInfo.getBilltype());
			blskInvItem.setDeptid(UserUtil.getCompanyId());
			blskInvItem.setCreator(UserUtil.getUserId());
			blskInvItem.setCreatetime(new Date());
			blskInvItem.setIsvalidate(ConstantRBAC.Y_ISVALIDATE);
			
			this.blskInvItemDao.save(blskInvItem);
		}
		
		
	}

}

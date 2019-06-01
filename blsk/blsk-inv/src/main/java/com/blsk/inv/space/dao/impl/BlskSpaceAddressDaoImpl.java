package com.blsk.inv.space.dao.impl;

import com.blsk.inv.space.dao.BlskSpaceAddressDao;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;

import pojo.BlskSpaceAddress;

public class BlskSpaceAddressDaoImpl extends BaseDaoImpl<BlskSpaceAddress> implements BlskSpaceAddressDao {

	public BlskSpaceAddressDaoImpl() {
		super(BlskSpaceAddress.class);
	}

	@Override
	public String getSpaceAddress() {
		String sql = "SELECT DISTINCT A.LONGITUDE, A.LATITUDE, S.SAPCE_NAME FROM BLSK_SPACE_ADDRESS A, BLSK_INV_SPACE S WHERE A.ISVALIDATE = '"+ ConstantRBAC.Y_ISVALIDATE +"' AND S.ISVALIDATE = '"+ ConstantRBAC.Y_ISVALIDATE +"' AND A.SPACEID = S.ID";
		return findByJDBCReturnJSON(sql);
	
	}
}

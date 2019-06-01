package com.zlxq.rbac.party.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.framework.util.JsonUtil;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;
import com.zlxq.rbac.base.util.UserUtil;
import com.zlxq.rbac.party.dao.ZlxqPartyRelationDao;
import com.zlxq.rbac.party.service.ZlxqPartyRelationService;

import pojo.ZlxqParty;
import pojo.ZlxqPartyRelation;

public class ZlxqPartyRelationServiceImpl extends BaseServiceImpl<ZlxqPartyRelation> implements ZlxqPartyRelationService {

	private ZlxqPartyRelationDao zlxqPartyRelationDao;
	
	public ZlxqPartyRelationServiceImpl(ZlxqPartyRelationDao zlxqPartyRelationDao) {
		super(zlxqPartyRelationDao);
		this.zlxqPartyRelationDao = zlxqPartyRelationDao;
	}

	/* (non-Javadoc)
	 * @see com.zlxq.rbac.party.service.ZlxqPartyRelationService#getCPartyByPartyno(java.lang.String)
	 */
	@Override
	public List getCPartyByPartyno(String partyno) {
		return zlxqPartyRelationDao.getCPartyByPartyno(partyno);
	}

	/* (non-Javadoc)
	 * @see com.zlxq.rbac.party.service.ZlxqPartyRelationService#savePartyRelation(pojo.ZlxqParty, pojo.ZlxqParty, java.lang.String)
	 */
	@Override
	public void savePartyRelation(ZlxqParty pParty, ZlxqParty zlxqParty, String relationType) {
		ZlxqPartyRelation zpr = new ZlxqPartyRelation();
		zpr.setZlxqPartyByPartyid1(pParty);
		zpr.setZlxqPartyByPartyid2(zlxqParty);
		zpr.setType(relationType);
		zpr.setCreator(UserUtil.getUserId());
		zpr.setDeptid(zlxqParty.getDeptid());
		zpr.setCreatetime(new Date());
		zpr.setIsvalidate(ConstantRBAC.Y_ISVALIDATE);
		
		this.zlxqPartyRelationDao.save(zpr);
	}

	/* (non-Javadoc)
	 * @see com.zlxq.rbac.party.service.ZlxqPartyRelationService#getPidByCid(java.lang.Long)
	 */
	@Override
	public Long getPidByCid(Long cid) {
		ZlxqPartyRelation zpr = this.zlxqPartyRelationDao.getPidByCid(cid);
		if (null == zpr.getZlxqPartyByPartyid1()) {
			return null;
		}
		return zpr.getZlxqPartyByPartyid1().getId();
	}

}

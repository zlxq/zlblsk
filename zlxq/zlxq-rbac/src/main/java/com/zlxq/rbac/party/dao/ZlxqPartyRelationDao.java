package com.zlxq.rbac.party.dao;

import java.util.List;

import com.zlxq.rbac.base.core.dao.BaseDao;

import pojo.ZlxqPartyRelation;

public interface ZlxqPartyRelationDao extends BaseDao<ZlxqPartyRelation> {

	/**
	 * @TODO 通过partyno判断是否存在子项
	 * @author zhangl
	 *
	 * @param partyno
	 * @return
	 * @createtime 2019年5月20日
	 * @version V1.0
	 */
	List getCPartyByPartyno(String partyno);

}

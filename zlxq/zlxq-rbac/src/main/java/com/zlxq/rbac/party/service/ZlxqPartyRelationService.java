package com.zlxq.rbac.party.service;

import java.util.List;

import com.zlxq.rbac.base.core.service.BaseService;

import pojo.ZlxqParty;
import pojo.ZlxqPartyRelation;

public interface ZlxqPartyRelationService extends BaseService<ZlxqPartyRelation> {

	/**
	 * @TODO 通过partyno判断是否存在子项
	 * @author zhangl
	 *
	 * @param partyno
	 * @return
	 * @createtime 2019年5月19日
	 * @version V1.0
	 */
	List getCPartyByPartyno(String partyno);

	/**
	 * @TODO 保存父子关系
	 * @author zhangl
	 *
	 * @param pParty
	 * @param zlxqParty
	 * @param relationType
	 * @createtime 2019年5月20日
	 * @version V1.0
	 */
	void savePartyRelation(ZlxqParty pParty, ZlxqParty zlxqParty, String relationType);

}

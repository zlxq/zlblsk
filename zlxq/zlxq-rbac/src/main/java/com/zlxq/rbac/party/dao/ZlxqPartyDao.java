package com.zlxq.rbac.party.dao;

import java.util.List;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.dao.BaseDao;

import pojo.ZlxqParty;

/**
 * @ClassName: ZlxqPartyDao.java
 * @Description: TODO(方法描述)
 * @author: PUB
 * @date: 2019年4月17日 下午10:30:24
 *
 * @param <T>
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 *
 */
public interface ZlxqPartyDao extends BaseDao<ZlxqParty>{

	/**
	 * @MethodName: getPartyByUserNo
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月5日 下午2:47:13
	 * @param userno
	 * @return
	 * @return: ZlxqParty
	 * @throws
	 */
	ZlxqParty getPartyByUser(String userno, String password);

	/**
	 * @TODO 通过编号查询PartyLIst
	 * @author zhangl
	 *
	 * @param partyno
	 * @return
	 * @createtime 2019年5月19日
	 * @version V1.0
	 */
	List getPartyByPartno(String partyno);

	/**
	 * @TODO 通过类型查询party界面
	 * @author zhangl
	 *
	 * @param pb
	 * @param partytype
	 * @return
	 * @createtime 2019年5月20日
	 * @version V1.0
	 */
	String getCompanyPage(PagingBean pb, String partytype);

	/**
	 * @TODO 查询组织树
	 * @author zhangl
	 *
	 * @param id
	 * @return
	 * @createtime 2019年5月24日
	 * @version V1.0
	 */
	String getDeptTree(String id);

	/**
	 * @TODO 点击组织树，平铺展示字典信息
	 * @author zhangl
	 *
	 * @param pb
	 * @param id
	 * @param partyno
	 * @param partyname
	 * @return
	 * @createtime 2019年5月24日
	 * @version V1.0
	 */
	String getDeptGrid(PagingBean pb, String id, String partyno, String partyname);

	/**
	 * @TODO 查询用户信息
	 * @author zhangl
	 *
	 * @param pb
	 * @param id
	 * @param partyno
	 * @param partyname
	 * @return
	 * @createtime 2019年5月24日
	 * @version V1.0
	 */
	String getUserPage(PagingBean pb, String id, String partyno, String partyname);

}

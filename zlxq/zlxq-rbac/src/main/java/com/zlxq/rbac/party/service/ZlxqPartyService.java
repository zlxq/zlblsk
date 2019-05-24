package com.zlxq.rbac.party.service;

import javax.servlet.http.HttpServletRequest;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.service.BaseService;

import pojo.ZlxqParty;

/**
 * @ClassName: ZlxqPartyService.java
 * @Description: TODO(方法描述)
 * @author: PUB
 * @date: 2019年4月17日 下午10:30:24
 *
 * @param <T>
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 *
 */
public interface ZlxqPartyService extends BaseService<ZlxqParty> {

	/**
	 * @todo 查询用户通过用户编号
	 * @author zhangl
	 *
	 * @param userno
	 * @return
	 * @createtime 2019年5月19日
	 * @version V1.0
	 */
	ZlxqParty getPartyByUserNo(String userno);

	/**
	 * @TODO 通过用户对象查询用户
	 * @author zhangl
	 *
	 * @param userno
	 * @param password
	 * @return
	 * @createtime 2019年5月19日
	 * @version V1.0
	 */
	ZlxqParty getPartyByUser(String userno, String password);

	/**
	 * @TODO 登录方法
	 * @author zhangl
	 *
	 * @param userno
	 * @param password
	 * @param request
	 * @return
	 * @createtime 2019年5月19日
	 * @version V1.0
	 */
	String login(String userno, String password, HttpServletRequest request);

	/**
	 * @TODO 保存单位公有方法
	 * @author zhangl
	 *
	 * @param zlxqParty
	 * @param partytype
	 * @param relationType 
	 * @return
	 * @createtime 2019年5月19日
	 * @version V1.0
	 */
	String saveDept(ZlxqParty zlxqParty, String pid, String partytype, String relationType);

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

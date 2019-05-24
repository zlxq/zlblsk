package com.zlxq.rbac.party.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.framework.util.MD5Util;
import com.framework.util.PagingBean;
import com.framework.util.PropertiesUtil;
import com.zlxq.rbac.base.bean.OnlineUserBean;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;
import com.zlxq.rbac.base.util.DictUtil;
import com.zlxq.rbac.base.util.UserUtil;
import com.zlxq.rbac.menu.service.ZlxqMenuService;
import com.zlxq.rbac.party.dao.ZlxqPartyDao;
import com.zlxq.rbac.party.service.ZlxqPartyRelationService;
import com.zlxq.rbac.party.service.ZlxqPartyService;

import pojo.ZlxqMenu;
import pojo.ZlxqParty;

public class ZlxqPartyServiceImpl extends BaseServiceImpl<ZlxqParty> implements ZlxqPartyService {

	private ZlxqPartyDao zlxqPartyDao;
	
	@Resource
	private ZlxqMenuService zlxqMenuService;
	@Resource
	private ZlxqPartyRelationService zlxqPartyRelationService;
	
	public ZlxqPartyServiceImpl(ZlxqPartyDao zlxqPartyDao) {
		super(zlxqPartyDao);
		this.zlxqPartyDao = zlxqPartyDao;
	}

	public ZlxqParty getPartyByUserNo(String userno) {
		return this.zlxqPartyDao.getPartyByUser(userno, null);
	}
	
	@Override
	public ZlxqParty getPartyByUser(String userno, String password) {
		password = MD5Util.getMDString(password);
		return this.zlxqPartyDao.getPartyByUser(userno, password);
	}

	@Override
	public String login(String userno, String password, HttpServletRequest request) {
		ZlxqParty zlxqParty = zlxqPartyDao.getPartyByUser(userno, password);
		
		if (null == zlxqParty) {
			return ConstantRBAC.FAILURE;
		}
		
		String userType = DictUtil.role_lx.role_xtgly;
		if (ConstantRBAC.IS_SUPER.equals(zlxqParty.getIssuper())) {
			userType = DictUtil.role_lx.role_super;
		}
		List<ZlxqMenu> menuList = this.zlxqMenuService.getAllMenu(userno, userType);
		
		zlxqParty.setMenuList(menuList);
		
		String s = putOnlineUser(request, zlxqParty);
		
		if (null == s) {
			return ConstantRBAC.REDIECT;
		}
		
		pubSession(request, zlxqParty);
		
		return ConstantRBAC.SUCCESS;
	}

	private String putOnlineUser(HttpServletRequest request, ZlxqParty zlxqParty) {
		String newSid = request.getSession().getId();
//		String oldSid = OnlineUserBean.getUserById(zlxqParty.getId());
//		if (null != oldSid && !oldSid.equals(newSid)) {
//			return null;
//		} else {
//			OnlineUserBean.putUserBySessionId(newSid, zlxqParty);
//			OnlineUserBean.putUserById(zlxqParty.getId(), newSid);
//			return "success";
//		}
		
		OnlineUserBean.putUserBySessionId(newSid, zlxqParty);
		OnlineUserBean.putUserById(zlxqParty.getId(), newSid);
		return "success";
	}

	private void pubSession(HttpServletRequest request, ZlxqParty zlxqParty) {
		String sessionId = request.getSession().getId();
		String webAppName = PropertiesUtil.getPropertyFromConfig("WEB_APP_NAME");
		request.getSession().setAttribute("sessionId", sessionId);
		request.getSession().setAttribute(sessionId, zlxqParty);
		request.getSession().setAttribute("user", zlxqParty);
		request.getSession().setAttribute("rootPath", request.getContextPath());
		request.getSession().setAttribute("__ctxPath", request.getServletContext().getRealPath("/"));
		request.getSession().setAttribute("webAppName", webAppName);
	}

	@Override
	public String saveDept(ZlxqParty zlxqParty, String pid, String partytype, String relationType) {
		String partyno = zlxqParty.getPartyno();
		
		List list = this.zlxqPartyDao.getPartyByPartno(partyno);

		if (list.size() > 0) {
			return "编号已经存在,请重新输入！";
		}
		
		ZlxqParty pParty = null;
		if (StringUtils.isNotEmpty(pid) && !"null".equals(pid)) {
			pParty = this.zlxqPartyDao.findByPk(Long.parseLong(pid));
			pParty.setIsleaf(ConstantRBAC.IS_LEAF_C);

			pParty = this.zlxqPartyDao.save(pParty);
		}
		
		zlxqParty.setIsleaf(ConstantRBAC.IS_LEAF_O);
		zlxqParty.setIconcls(ConstantRBAC.ICONCLS_DEFAULT);
		zlxqParty.setPartytype(partytype);
		zlxqParty.setCreatetime(new Date());
		zlxqParty.setIsvalidate(ConstantRBAC.Y_ISVALIDATE);
		
		if (!partytype.equals(DictUtil.dept_lx.dept_gs)) {
			zlxqParty.setDeptid(UserUtil.getCompanyId());
		}
		
		try {
			zlxqParty = this.zlxqPartyDao.save(zlxqParty);
			
			if (partytype.equals(DictUtil.dept_lx.dept_gs)) {
				zlxqParty.setDeptid(zlxqParty.getId());
				zlxqParty = this.zlxqPartyDao.save(zlxqParty);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "保存失败";
		}
		
		try {
			this.zlxqPartyRelationService.savePartyRelation(pParty, zlxqParty, relationType);
		} catch (Exception e) {
			e.printStackTrace();
			return "保存关系失败";
		}
		
		return "保存成功";
	}

	/* (non-Javadoc)
	 * @see com.zlxq.rbac.party.service.ZlxqPartyService#getCompanyPage(com.framework.util.PagingBean, java.lang.String)
	 */
	@Override
	public String getCompanyPage(PagingBean pb, String partytype) {
		return zlxqPartyDao.getCompanyPage(pb, partytype);
	}

	/* (non-Javadoc)
	 * @see com.zlxq.rbac.party.service.ZlxqPartyService#getDeptTree(java.lang.String)
	 */
	@Override
	public String getDeptTree(String id) {
		String json = this.zlxqPartyDao.getDeptTree(id);
		try {
			JSONObject jo = new JSONObject(json);
			JSONArray ja = jo.getJSONArray("rows");
			json = ja.toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}

	/* (non-Javadoc)
	 * @see com.zlxq.rbac.party.service.ZlxqPartyService#getDeptGrid(com.framework.util.PagingBean, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String getDeptGrid(PagingBean pb, String id, String partyno, String partyname) {
		return this.zlxqPartyDao.getDeptGrid(pb, id, partyno, partyname);
	}

	/* (non-Javadoc)
	 * @see com.zlxq.rbac.party.service.ZlxqPartyService#getUserPage(com.framework.util.PagingBean, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String getUserPage(PagingBean pb, String id, String partyno, String partyname) {
		return this.zlxqPartyDao.getUserPage(pb, id, partyno, partyname);
	}


}

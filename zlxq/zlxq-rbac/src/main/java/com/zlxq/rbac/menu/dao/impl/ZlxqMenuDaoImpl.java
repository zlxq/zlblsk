/**
 * @Title: ZlxqMenuDaoImpl.java
 * @Package: com.rbac.menu.dao.impl
 * @Description: 系统菜单持久层接口实现
 * @author: PUB
 * @date: 2019年5月2日 下午12:41:05
 * @version V1.0
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 */
package com.zlxq.rbac.menu.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.menu.dao.ZlxqMenuDao;

import pojo.ZlxqMenu;

public class ZlxqMenuDaoImpl extends BaseDaoImpl<ZlxqMenu> implements ZlxqMenuDao {

	/**
	 * @Title: ZlxqMenuDaoImpl
	 * @Description: 无参构造方法
	 * @param persistType
	 * @throws
	 */
	public ZlxqMenuDaoImpl() {
		super(ZlxqMenu.class);
	}

	/**
	 * @MethodName: getAllMenu
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: PUB
	 * @date: 2019年5月5日 下午3:26:01
	 * @return
	 * @throws
	 */
	@Override
	public List<ZlxqMenu> getAllMenu() {
		String hql = "select t from ZlxqMenu t where t.isvalidate = '1' and t.zlxqMenu.id is null ORDER BY t.menusort";
		return (List<ZlxqMenu>) findByHQL(hql);
	}

	/**
	 * @MethodName: getMenuByUserNo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: PUB
	 * @date: 2019年5月5日 下午3:26:01
	 * @param userNo
	 * @return
	 * @throws
	 */
	@Override
	public List<ZlxqMenu> getMenuByUserNo(String userNo) {
		String roleid = this.getRoleByUserNo(userNo);
		String hql = "select t from ZlxqMenu t, ZlxqRolemenu zrm where t.zlxqMenu.id is null and t.id = zrm.zlxqMenu.id and zrm.zlxqRole.id in "+roleid+" and t.isvalidate = '1' and zrm.isvalidate = '1' ORDER BY t.menusort";
		return (List<ZlxqMenu>) findByHQL(hql);
	}

	/**
	 * @MethodName: getRoleByUserNo
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author: PUB
	 * @date: 2019年5月5日 下午3:28:20
	 * @param userNo
	 * @return
	 * @return: String
	 * @throws
	 */
	private String getRoleByUserNo(String userNo) {
		String sql = "SELECT\n" + "  zar.role_id\n" + "FROM\n" + "  zlxq_account za,\n" + "  zlxq_accountrole zar\n"
				+ "WHERE loginno = '"+userNo+"'\n" + "  AND za.id = zar.acount_id\n" + "  AND za.isvalidate = '1'\n"
				+ "  AND zar.isvalidate = '1'";
		String json = findByJDBCReturnJSON(sql);
		
		StringBuffer buff = new StringBuffer("(");
		try {
			JSONObject jo = new JSONObject(json);
			JSONArray ja = jo.getJSONArray("rows");
			for (int i = 0; i < ja.length(); i++) {
				JSONObject info = ja.getJSONObject(i);
				
				String roleid = info.getString("role_id");
				
				buff.append("'" + roleid + "'");
				
				if (i < ja.length() -1) {
					buff.append(",");
				}
			}
			buff.append(")");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return buff.toString();
	}

	/**
	 * @MethodName: getCMenuByMenuid
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: PUB
	 * @date: 2019年5月5日 下午3:26:01
	 * @param id
	 * @param userNo
	 * @return
	 * @throws
	 */
	
	@Override
	public List<ZlxqMenu> getCMenuByMenuid(Long id, String userNo) {
//		String roleid = this.getRoleByUserNo(userNo);
		if (1 == 1) {
			String hql = "select t from ZlxqMenu t where t.isvalidate = '1' and t.zlxqMenu.id = " + id + "";
			return (List<ZlxqMenu>) findByHQL(hql);
		}
		String hql = "select t from ZlxqMenu t, ZlxqRolemenu zrm where t.zlxqMenu.id = " + id + " and t.id = zrm.zlxqMenu.id and zrm.zlxqRole.id in ('') and t.isvalidate = '1' and zrm.isvalidate = '1' ORDER BY t.menusort";
		return (List<ZlxqMenu>) findByHQL(hql);
	}

	/**
	 * @MethodName: getMenuPage
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: PUB
	 * @date: 2019年5月6日 上午2:45:08
	 * @param pb
	 * @return
	 * @throws
	 */
	@Override
	public String getMenuPage(PagingBean pb) {
		String sql = "SELECT * FROM ZLXQ_MENU WHERE ISVALIDATE = '1'";
		return findByJDBCReturnJSON(pb, sql);
	}

	/**
	 * @MethodName: getMenuTree
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: PUB
	 * @date: 2019年5月6日 上午2:49:29
	 * @param id
	 * @return
	 * @throws
	 */
	@Override
	public String getMenuTree(String id) {
		String sql = "select t.id, t.menuname name, t.pid _parentId, t.isleaf state, t.iconCls iconCls, t.menucode, t.menuurl, t.menutype, t.menusort from zlxq_menu t where t.isvalidate = '1'";
		if (StringUtils.isNotEmpty(id)) {
			sql += " and t.id = '" + id + "'";
		}

		sql += " order by menusort";
		return findByJDBCReturnJSON(sql);
	}

}
package com.zlxq.rbac.menu.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.framework.util.PagingBean;
import com.zlxq.rbac.base.core.dao.impl.BaseDaoImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;
import com.zlxq.rbac.menu.dao.ZlxqMenuDao;

import pojo.ZlxqMenu;

public class ZlxqMenuDaoImpl extends BaseDaoImpl<ZlxqMenu> implements ZlxqMenuDao {

	public ZlxqMenuDaoImpl() {
		super(ZlxqMenu.class);
	}

	@Override
	public List<ZlxqMenu> getAllMenu() {
		String hql = "select t from ZlxqMenu t where t.isvalidate = '1' and t.zlxqMenu.id is null ORDER BY t.menusort";
		return (List<ZlxqMenu>) findByHQL(hql);
	}

	@Override
	public List<ZlxqMenu> getMenuByUserNo(String userNo) {
		String roleid = this.getRoleByUserNo(userNo);
		String hql = "select t from ZlxqMenu t, ZlxqRolemenu zrm where t.zlxqMenu.id is null and t.id = zrm.zlxqMenu.id and zrm.zlxqRole.id in "
				+ roleid + " and t.isvalidate = '1' and zrm.isvalidate = '1' ORDER BY t.menusort";
		return (List<ZlxqMenu>) findByHQL(hql);
	}

	private String getRoleByUserNo(String userNo) {
		String sql = "SELECT\n" + "  zur.role_id\n" + "FROM\n" + "  zlxq_party zp,\n" + "  zlxq_user_role zur\n"
				+ "WHERE zp.loginno = '" + userNo + "'\n" + "  AND zp.id = zur.userid\n" + "  AND zur.isvalidate = '"
				+ ConstantRBAC.Y_ISVALIDATE + "'\n" + "  AND zp.isvalidate = '" + ConstantRBAC.Y_ISVALIDATE + "'";
		String json = findByJDBCReturnJSON(sql);

		StringBuffer buff = new StringBuffer("(");
		try {
			JSONObject jo = new JSONObject(json);
			JSONArray ja = jo.getJSONArray("rows");
			for (int i = 0; i < ja.length(); i++) {
				JSONObject info = ja.getJSONObject(i);

				String roleid = info.getString("role_id");

				buff.append("'" + roleid + "'");

				if (i < ja.length() - 1) {
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
	 * @MethodName: getCMenuByMenuid @Description: TODO(这里用一句话描述这个方法的作用) @author:
	 * PUB @date: 2019年5月5日 下午3:26:01 @param id @param userNo @return @throws
	 */

	@Override
	public List<ZlxqMenu> getCMenuByMenuid(Long id, String userNo) {
//		String roleid = this.getRoleByUserNo(userNo);
		if (1 == 1) {
			String hql = "select t from ZlxqMenu t where t.isvalidate = '1' and t.zlxqMenu.id = " + id + "";
			return (List<ZlxqMenu>) findByHQL(hql);
		}
		String hql = "select t from ZlxqMenu t, ZlxqRolemenu zrm where t.zlxqMenu.id = " + id
				+ " and t.id = zrm.zlxqMenu.id and zrm.zlxqRole.id in ('') and t.isvalidate = '1' and zrm.isvalidate = '1' ORDER BY t.menusort";
		return (List<ZlxqMenu>) findByHQL(hql);
	}

	@Override
	public String getMenuPage(PagingBean pb) {
		String sql = "SELECT * FROM ZLXQ_MENU WHERE ISVALIDATE = '1'";
		return findByJDBCReturnJSON(pb, sql);
	}

	@Override
	public String getMenuTree(String id) {
		String sql = "select t.id, t.menuname name, t.pid _parentId, t.isleaf state, t.iconCls iconCls, t.menucode, t.menuurl, t.menutype, t.menusort from zlxq_menu t where t.isvalidate = '1'";
		if (StringUtils.isNotEmpty(id)) {
			sql += " and t.id = '" + id + "'";
		}

		sql += " order by menusort";
		return findByJDBCReturnJSON(sql);
	}

	@Override
	public String getRoleMenu(String id) {
		String sql = "select t.id,\n" + "       t.menuname name,\n" + "       t.pid      _parentId,\n"
				+ "       t.isleaf   state,\n" + "       t.iconcls  iconCls,\n" + "       t.menucode,\n"
				+ "       t.menuurl,\n" + "       t.menutype,\n" + "       t.menusort\n"
				+ "  from zlxq_menu t, zlxq_role_menu zrm\n" + " where t.id = zrm.menu_id\n"
				+ "   and t.isvalidate = '1'\n" + "   and zrm.isvalidate = '1'";
		if (StringUtils.isNotEmpty(id)) {
			sql += " and zrm.role_id = '" + id + "'";
		}

		sql += " order by menusort";
		return findByJDBCReturnJSON(sql);
	}

	@Override
	public String getNoRoleMenu(String id) {
		String sql = "SELECT\n" + "  t.id,\n" + "  t.menuname name,\n" + "  t.pid _parentId,\n" + "  t.isleaf state,\n"
				+ "  t.iconcls iconCls,\n" + "  t.menucode,\n" + "  t.menuurl,\n" + "  t.menutype,\n" + "  t.menusort\n"
				+ "FROM\n" + "  zlxq_menu t\n" + "WHERE t.id NOT IN\n" + "  (SELECT\n" + "    zm.id\n" + "  FROM\n"
				+ "    zlxq_role_menu zr,\n" + "    zlxq_menu zm\n" + "  WHERE zr.role_id = " + id + "\n"
				+ "    AND zm.id = zr.menu_id\n" + "    AND zm.pid IS NOT NULL\n" + "    AND zm.isvalidate = '1'\n"
				+ "    AND zr.isvalidate = '1')\n" + "  AND t.isvalidate = '1'\n" + "ORDER BY t.menusort";
		return findByJDBCReturnJSON(sql);
	}

}

package com.zlxq.rbac.pojo;
// Generated 2019-5-2 12:31:23 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ZlxqMenu generated by hbm2java
 */
public class ZlxqMenu implements java.io.Serializable {

	private Long id;
	private ZlxqMenu zlxqMenu;
	private String menucode;
	private String menuname;
	private String menuurl;
	private String menutype;
	private Integer menusort;
	private String isleaf;
	private String iconcls;
	private Long creator;
	private Date createtime;
	private Date updatetime;
	private String isvalidate;
	private Set zlxqRoleMenus = new HashSet(0);
	private Set zlxqMenus = new HashSet(0);

	public ZlxqMenu() {
	}

	public ZlxqMenu(ZlxqMenu zlxqMenu, String menucode, String menuname, String menuurl, String menutype,
			Integer menusort, String isleaf, String iconcls, Long creator, Date createtime, Date updatetime,
			String isvalidate, Set zlxqRoleMenus, Set zlxqMenus) {
		this.zlxqMenu = zlxqMenu;
		this.menucode = menucode;
		this.menuname = menuname;
		this.menuurl = menuurl;
		this.menutype = menutype;
		this.menusort = menusort;
		this.isleaf = isleaf;
		this.iconcls = iconcls;
		this.creator = creator;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.isvalidate = isvalidate;
		this.zlxqRoleMenus = zlxqRoleMenus;
		this.zlxqMenus = zlxqMenus;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ZlxqMenu getZlxqMenu() {
		return this.zlxqMenu;
	}

	public void setZlxqMenu(ZlxqMenu zlxqMenu) {
		this.zlxqMenu = zlxqMenu;
	}

	public String getMenucode() {
		return this.menucode;
	}

	public void setMenucode(String menucode) {
		this.menucode = menucode;
	}

	public String getMenuname() {
		return this.menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getMenuurl() {
		return this.menuurl;
	}

	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}

	public String getMenutype() {
		return this.menutype;
	}

	public void setMenutype(String menutype) {
		this.menutype = menutype;
	}

	public Integer getMenusort() {
		return this.menusort;
	}

	public void setMenusort(Integer menusort) {
		this.menusort = menusort;
	}

	public String getIsleaf() {
		return this.isleaf;
	}

	public void setIsleaf(String isleaf) {
		this.isleaf = isleaf;
	}

	public String getIconcls() {
		return this.iconcls;
	}

	public void setIconcls(String iconcls) {
		this.iconcls = iconcls;
	}

	public Long getCreator() {
		return this.creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getIsvalidate() {
		return this.isvalidate;
	}

	public void setIsvalidate(String isvalidate) {
		this.isvalidate = isvalidate;
	}

	public Set getZlxqRoleMenus() {
		return this.zlxqRoleMenus;
	}

	public void setZlxqRoleMenus(Set zlxqRoleMenus) {
		this.zlxqRoleMenus = zlxqRoleMenus;
	}

	public Set getZlxqMenus() {
		return this.zlxqMenus;
	}

	public void setZlxqMenus(Set zlxqMenus) {
		this.zlxqMenus = zlxqMenus;
	}

}

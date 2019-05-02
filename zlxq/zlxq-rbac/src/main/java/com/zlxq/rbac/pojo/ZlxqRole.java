package com.zlxq.rbac.pojo;
// Generated 2019-5-2 12:31:23 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ZlxqRole generated by hbm2java
 */
public class ZlxqRole implements java.io.Serializable {

	private Long id;
	private String roleno;
	private String rolename;
	private String roletype;
	private Long deptid;
	private Long creator;
	private Date createtime;
	private Date updatetime;
	private String isvalidate;
	private Set zlxqUserRoles = new HashSet(0);
	private Set zlxqRoleMenus = new HashSet(0);

	public ZlxqRole() {
	}

	public ZlxqRole(String roleno, String rolename, String roletype, Long deptid, Long creator, Date createtime,
			Date updatetime, String isvalidate, Set zlxqUserRoles, Set zlxqRoleMenus) {
		this.roleno = roleno;
		this.rolename = rolename;
		this.roletype = roletype;
		this.deptid = deptid;
		this.creator = creator;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.isvalidate = isvalidate;
		this.zlxqUserRoles = zlxqUserRoles;
		this.zlxqRoleMenus = zlxqRoleMenus;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleno() {
		return this.roleno;
	}

	public void setRoleno(String roleno) {
		this.roleno = roleno;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoletype() {
		return this.roletype;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	public Long getDeptid() {
		return this.deptid;
	}

	public void setDeptid(Long deptid) {
		this.deptid = deptid;
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

	public Set getZlxqUserRoles() {
		return this.zlxqUserRoles;
	}

	public void setZlxqUserRoles(Set zlxqUserRoles) {
		this.zlxqUserRoles = zlxqUserRoles;
	}

	public Set getZlxqRoleMenus() {
		return this.zlxqRoleMenus;
	}

	public void setZlxqRoleMenus(Set zlxqRoleMenus) {
		this.zlxqRoleMenus = zlxqRoleMenus;
	}

}

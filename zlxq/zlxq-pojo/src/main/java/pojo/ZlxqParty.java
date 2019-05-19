package pojo;

// Generated 2019-5-5 10:23:12 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ZlxqParty generated by hbm2java
 */
public class ZlxqParty implements java.io.Serializable {

	private Long id;	
	private Long companyId;
	private Long cruDeptId;
	private String partyno;
	private String loginno;
	private String partname;
	private String password;
	private String sex;
	private String partytype;
	private String email;
	private String tel;
	private String issuper;
	private String isleaf;
	private String iconcls;
	private Long deptid;
	private Long creator;
	private Date createtime;
	private Date updatetime;
	private String isvalidate;
	private Set zlxqUserRoles = new HashSet(0);
	private Set zlxqPartyRelationsForPartyid1 = new HashSet(0);
	private Set zlxqPartyRelationsForPartyid2 = new HashSet(0);
	
	private List<ZlxqMenu> menuList;

	public ZlxqParty() {
	}

	public ZlxqParty(String partyno, String loginno, String partname, String password, String sex, String partytype,
			String email, String tel,String isleaf, String iconcls, Long deptid, Long creator, Date createtime, Date updatetime, String isvalidate,
			Set zlxqUserRoles, Set zlxqPartyRelationsForPartyid1, Set zlxqPartyRelationsForPartyid2) {
		this.partyno = partyno;
		this.loginno = loginno;
		this.partname = partname;
		this.password = password;
		this.sex = sex;
		this.partytype = partytype;
		this.email = email;
		this.tel = tel;
		this.isleaf = isleaf;
		this.iconcls = iconcls;
		this.deptid = deptid;
		this.creator = creator;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.isvalidate = isvalidate;
		this.zlxqUserRoles = zlxqUserRoles;
		this.zlxqPartyRelationsForPartyid1 = zlxqPartyRelationsForPartyid1;
		this.zlxqPartyRelationsForPartyid2 = zlxqPartyRelationsForPartyid2;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPartyno() {
		return this.partyno;
	}

	public void setPartyno(String partyno) {
		this.partyno = partyno;
	}

	public String getLoginno() {
		return this.loginno;
	}

	public void setLoginno(String loginno) {
		this.loginno = loginno;
	}

	public String getPartname() {
		return this.partname;
	}

	public void setPartname(String partname) {
		this.partname = partname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPartytype() {
		return this.partytype;
	}

	public void setPartytype(String partytype) {
		this.partytype = partytype;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public Set getZlxqPartyRelationsForPartyid1() {
		return this.zlxqPartyRelationsForPartyid1;
	}

	public void setZlxqPartyRelationsForPartyid1(Set zlxqPartyRelationsForPartyid1) {
		this.zlxqPartyRelationsForPartyid1 = zlxqPartyRelationsForPartyid1;
	}

	public Set getZlxqPartyRelationsForPartyid2() {
		return this.zlxqPartyRelationsForPartyid2;
	}

	public void setZlxqPartyRelationsForPartyid2(Set zlxqPartyRelationsForPartyid2) {
		this.zlxqPartyRelationsForPartyid2 = zlxqPartyRelationsForPartyid2;
	}

	/**
	 * @Title: getIssuper <BR>
	 * @Description: please write your description <BR>
	 * @return: String <BR>
	 */
	public String getIssuper() {
		return issuper;
	}

	/**
	 * @Title: setIssuper <BR>
	 * @Description: please write your description <BR>
	 * @return: String <BR>
	 */
	public void setIssuper(String issuper) {
		this.issuper = issuper;
	}

	/**
	 * @Title: getMenuList <BR>
	 * @Description: please write your description <BR>
	 * @return: List<ZlxqMenu> <BR>
	 */
	public List<ZlxqMenu> getMenuList() {
		return menuList;
	}

	/**
	 * @Title: setMenuList <BR>
	 * @Description: please write your description <BR>
	 * @return: List<ZlxqMenu> <BR>
	 */
	public void setMenuList(List<ZlxqMenu> menuList) {
		this.menuList = menuList;
	}

	/**
	 * @return the companyId
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the cruDeptId
	 */
	public Long getCruDeptId() {
		return cruDeptId;
	}

	/**
	 * @param cruDeptId the cruDeptId to set
	 */
	public void setCruDeptId(Long cruDeptId) {
		this.cruDeptId = cruDeptId;
	}

	/**
	 * @return the isleaf
	 */
	public String getIsleaf() {
		return isleaf;
	}

	/**
	 * @param isleaf the isleaf to set
	 */
	public void setIsleaf(String isleaf) {
		this.isleaf = isleaf;
	}

	/**
	 * @return the iconcls
	 */
	public String getIconcls() {
		return iconcls;
	}

	/**
	 * @param iconcls the iconcls to set
	 */
	public void setIconcls(String iconcls) {
		this.iconcls = iconcls;
	}

}

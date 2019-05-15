package pojo;
// Generated 2019-5-15 17:43:01 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * BlskInvStore generated by hbm2java
 */
public class BlskInvStore implements java.io.Serializable {

	private Long id;
	private Long billid;
	private Long ioid;
	private Long materialid;
	private Long spaceid;
	private Long invunitid;
	private Long kwid;
	private String spacename;
	private String unitname;
	private String billno;
	private String iono;
	private String mno;
	private String mcode;
	private String mname;
	private Long invCount;
	private Long deptid;
	private Long creator;
	private Date createtime;
	private Date updatetime;
	private String isvalidate;

	public BlskInvStore() {
	}

	public BlskInvStore(Long billid, Long ioid, Long materialid, Long spaceid, Long invunitid, Long kwid,
			String spacename, String unitname, String billno, String iono, String mno, String mcode, String mname,
			Long invCount, Long deptid, Long creator, Date createtime, Date updatetime, String isvalidate) {
		this.billid = billid;
		this.ioid = ioid;
		this.materialid = materialid;
		this.spaceid = spaceid;
		this.invunitid = invunitid;
		this.kwid = kwid;
		this.spacename = spacename;
		this.unitname = unitname;
		this.billno = billno;
		this.iono = iono;
		this.mno = mno;
		this.mcode = mcode;
		this.mname = mname;
		this.invCount = invCount;
		this.deptid = deptid;
		this.creator = creator;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.isvalidate = isvalidate;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBillid() {
		return this.billid;
	}

	public void setBillid(Long billid) {
		this.billid = billid;
	}

	public Long getIoid() {
		return this.ioid;
	}

	public void setIoid(Long ioid) {
		this.ioid = ioid;
	}

	public Long getMaterialid() {
		return this.materialid;
	}

	public void setMaterialid(Long materialid) {
		this.materialid = materialid;
	}

	public Long getSpaceid() {
		return this.spaceid;
	}

	public void setSpaceid(Long spaceid) {
		this.spaceid = spaceid;
	}

	public Long getInvunitid() {
		return this.invunitid;
	}

	public void setInvunitid(Long invunitid) {
		this.invunitid = invunitid;
	}

	public Long getKwid() {
		return this.kwid;
	}

	public void setKwid(Long kwid) {
		this.kwid = kwid;
	}

	public String getSpacename() {
		return this.spacename;
	}

	public void setSpacename(String spacename) {
		this.spacename = spacename;
	}

	public String getUnitname() {
		return this.unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public String getBillno() {
		return this.billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public String getIono() {
		return this.iono;
	}

	public void setIono(String iono) {
		this.iono = iono;
	}

	public String getMno() {
		return this.mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getMcode() {
		return this.mcode;
	}

	public void setMcode(String mcode) {
		this.mcode = mcode;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Long getInvCount() {
		return this.invCount;
	}

	public void setInvCount(Long invCount) {
		this.invCount = invCount;
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

}

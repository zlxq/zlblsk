package pojo;
// Generated 2019-5-15 22:56:17 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * BlskBillDetail generated by hbm2java
 */
public class BlskBillDetail implements java.io.Serializable {

	private Long id;
	private BlskBillInfo blskBillInfo;
	private Long materialid;
	private String mno;
	private String mcode;
	private String mname;
	private String state;
	private String count;
	private String wcnum;
	private String unit;
	private Long deptid;
	private Long creator;
	private Date createtime;
	private Date updatetime;
	private String isvalidate;

	public BlskBillDetail() {
	}

	public BlskBillDetail(BlskBillInfo blskBillInfo, Long materialid, String mno, String mcode, String mname,
			String state, String count, String wcnum, String unit, Long deptid, Long creator, Date createtime, Date updatetime, String isvalidate) {
		this.blskBillInfo = blskBillInfo;
		this.materialid = materialid;
		this.mno = mno;
		this.mcode = mcode;
		this.mname = mname;
		this.state = state;
		this.count = count;
		this.wcnum = wcnum;
		this.unit = unit;
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

	public BlskBillInfo getBlskBillInfo() {
		return this.blskBillInfo;
	}

	public void setBlskBillInfo(BlskBillInfo blskBillInfo) {
		this.blskBillInfo = blskBillInfo;
	}

	public Long getMaterialid() {
		return this.materialid;
	}

	public void setMaterialid(Long materialid) {
		this.materialid = materialid;
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

	public String getCount() {
		return this.count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the wcnum
	 */
	public String getWcnum() {
		return wcnum;
	}

	/**
	 * @param wcnum the wcnum to set
	 */
	public void setWcnum(String wcnum) {
		this.wcnum = wcnum;
	}

}

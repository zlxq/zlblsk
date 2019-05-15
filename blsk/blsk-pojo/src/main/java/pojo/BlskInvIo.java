package pojo;
// Generated 2019-5-15 17:43:01 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * BlskInvIo generated by hbm2java
 */
public class BlskInvIo implements java.io.Serializable {

	private Long id;
	private BlskBillInfo blskBillInfo;
	private String billno;
	private String iono;
	private String iotype;
	private String level;
	private String execType;
	private Long deptid;
	private Long creator;
	private Date createtime;
	private Date updatetime;
	private String isvalidate;
	private Set blskInvItems = new HashSet(0);
	private Set blskSpaceItems = new HashSet(0);

	public BlskInvIo() {
	}

	public BlskInvIo(BlskBillInfo blskBillInfo, String billno, String iono, String iotype, String level,
			String execType, Long deptid, Long creator, Date createtime, Date updatetime, String isvalidate,
			Set blskInvItems, Set blskSpaceItems) {
		this.blskBillInfo = blskBillInfo;
		this.billno = billno;
		this.iono = iono;
		this.iotype = iotype;
		this.level = level;
		this.execType = execType;
		this.deptid = deptid;
		this.creator = creator;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.isvalidate = isvalidate;
		this.blskInvItems = blskInvItems;
		this.blskSpaceItems = blskSpaceItems;
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

	public String getIotype() {
		return this.iotype;
	}

	public void setIotype(String iotype) {
		this.iotype = iotype;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getExecType() {
		return this.execType;
	}

	public void setExecType(String execType) {
		this.execType = execType;
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

	public Set getBlskInvItems() {
		return this.blskInvItems;
	}

	public void setBlskInvItems(Set blskInvItems) {
		this.blskInvItems = blskInvItems;
	}

	public Set getBlskSpaceItems() {
		return this.blskSpaceItems;
	}

	public void setBlskSpaceItems(Set blskSpaceItems) {
		this.blskSpaceItems = blskSpaceItems;
	}

}

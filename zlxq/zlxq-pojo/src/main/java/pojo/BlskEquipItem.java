package pojo;
// Generated 2019-5-15 22:56:17 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * BlskEquipItem generated by hbm2java
 */
public class BlskEquipItem implements java.io.Serializable {

	private Long id;
	private BlskInvItem blskInvItem;
	private BlskEquipInfo blskEquipInfo;
	private String state;
	private Long deptid;
	private Long creator;
	private Date createtime;
	private Date updatetime;
	private String isvalidate;

	public BlskEquipItem() {
	}

	public BlskEquipItem(BlskInvItem blskInvItem, BlskEquipInfo blskEquipInfo, String state, Long deptid, Long creator,
			Date createtime, Date updatetime, String isvalidate) {
		this.blskInvItem = blskInvItem;
		this.blskEquipInfo = blskEquipInfo;
		this.state = state;
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

	public BlskInvItem getBlskInvItem() {
		return this.blskInvItem;
	}

	public void setBlskInvItem(BlskInvItem blskInvItem) {
		this.blskInvItem = blskInvItem;
	}

	public BlskEquipInfo getBlskEquipInfo() {
		return this.blskEquipInfo;
	}

	public void setBlskEquipInfo(BlskEquipInfo blskEquipInfo) {
		this.blskEquipInfo = blskEquipInfo;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
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

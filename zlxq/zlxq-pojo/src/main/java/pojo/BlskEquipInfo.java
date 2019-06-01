package pojo;
// Generated 2019-5-15 22:56:17 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * BlskEquipInfo generated by hbm2java
 */
public class BlskEquipInfo implements java.io.Serializable {

	private Long id;
	private String equipNo;
	private String equipCode;
	private String equipName;
	private String equipType;
	private String equipState;
	private String sort;
	private Long deptid;
	private Long creator;
	private Date createtime;
	private Date updatetime;
	private String isvalidate;
	private Set blskEquipItems = new HashSet(0);
	private Set blskSpaceEquips = new HashSet(0);

	public BlskEquipInfo() {
	}

	public BlskEquipInfo(String equipNo, String equipCode, String equipName, String equipType, String equipState,
			String sort, Long deptid, Long creator, Date createtime, Date updatetime, String isvalidate,
			Set blskEquipItems, Set blskSpaceEquips) {
		this.equipNo = equipNo;
		this.equipCode = equipCode;
		this.equipName = equipName;
		this.equipType = equipType;
		this.equipState = equipState;
		this.sort = sort;
		this.deptid = deptid;
		this.creator = creator;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.isvalidate = isvalidate;
		this.blskEquipItems = blskEquipItems;
		this.blskSpaceEquips = blskSpaceEquips;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEquipNo() {
		return this.equipNo;
	}

	public void setEquipNo(String equipNo) {
		this.equipNo = equipNo;
	}

	public String getEquipCode() {
		return this.equipCode;
	}

	public void setEquipCode(String equipCode) {
		this.equipCode = equipCode;
	}

	public String getEquipName() {
		return this.equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	public String getEquipType() {
		return this.equipType;
	}

	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}

	public String getEquipState() {
		return this.equipState;
	}

	public void setEquipState(String equipState) {
		this.equipState = equipState;
	}

	public String getSort() {
		return this.sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
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

	public Set getBlskEquipItems() {
		return this.blskEquipItems;
	}

	public void setBlskEquipItems(Set blskEquipItems) {
		this.blskEquipItems = blskEquipItems;
	}

	public Set getBlskSpaceEquips() {
		return this.blskSpaceEquips;
	}

	public void setBlskSpaceEquips(Set blskSpaceEquips) {
		this.blskSpaceEquips = blskSpaceEquips;
	}

}

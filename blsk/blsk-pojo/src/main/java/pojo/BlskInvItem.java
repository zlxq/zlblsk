package pojo;
// Generated 2019-5-15 17:43:01 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * BlskInvItem generated by hbm2java
 */
public class BlskInvItem implements java.io.Serializable {

	private Long id;
	private BlskInvIo blskInvIo;
	private Long materialid;
	private String mno;
	private String mcode;
	private String manme;
	private Long userid;
	private String username;
	private Long reqNum;
	private Long count;
	private Date exectime;
	private String itemState;
	private String itemType;
	private Long deptid;
	private Long creator;
	private Date createtime;
	private Date updatetime;
	private String isvalidate;

	public BlskInvItem() {
	}

	public BlskInvItem(BlskInvIo blskInvIo, Long materialid, String mno, String mcode, String manme, Long userid,
			String username, Long reqNum, Long count, Date exectime, String itemState, String itemType, Long deptid,
			Long creator, Date createtime, Date updatetime, String isvalidate) {
		this.blskInvIo = blskInvIo;
		this.materialid = materialid;
		this.mno = mno;
		this.mcode = mcode;
		this.manme = manme;
		this.userid = userid;
		this.username = username;
		this.reqNum = reqNum;
		this.count = count;
		this.exectime = exectime;
		this.itemState = itemState;
		this.itemType = itemType;
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

	public BlskInvIo getBlskInvIo() {
		return this.blskInvIo;
	}

	public void setBlskInvIo(BlskInvIo blskInvIo) {
		this.blskInvIo = blskInvIo;
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

	public String getManme() {
		return this.manme;
	}

	public void setManme(String manme) {
		this.manme = manme;
	}

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getReqNum() {
		return this.reqNum;
	}

	public void setReqNum(Long reqNum) {
		this.reqNum = reqNum;
	}

	public Long getCount() {
		return this.count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Date getExectime() {
		return this.exectime;
	}

	public void setExectime(Date exectime) {
		this.exectime = exectime;
	}

	public String getItemState() {
		return this.itemState;
	}

	public void setItemState(String itemState) {
		this.itemState = itemState;
	}

	public String getItemType() {
		return this.itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
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

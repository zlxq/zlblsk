package pojo;
// Generated 2019-5-2 12:31:23 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * ZlxqPartyRelation generated by hbm2java
 */
public class ZlxqPartyRelation implements java.io.Serializable {

	private long id;
	private ZlxqParty zlxqPartyByPartyid2;
	private ZlxqParty zlxqPartyByPartyid1;
	private String type;
	private Long deptid;
	private Long creator;
	private Date createtime;
	private Date updatetime;
	private String isvalidate;

	public ZlxqPartyRelation() {
	}

	public ZlxqPartyRelation(long id) {
		this.id = id;
	}

	public ZlxqPartyRelation(long id, ZlxqParty zlxqPartyByPartyid2, ZlxqParty zlxqPartyByPartyid1, String type,
			Long deptid, Long creator, Date createtime, Date updatetime, String isvalidate) {
		this.id = id;
		this.zlxqPartyByPartyid2 = zlxqPartyByPartyid2;
		this.zlxqPartyByPartyid1 = zlxqPartyByPartyid1;
		this.type = type;
		this.deptid = deptid;
		this.creator = creator;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.isvalidate = isvalidate;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ZlxqParty getZlxqPartyByPartyid2() {
		return this.zlxqPartyByPartyid2;
	}

	public void setZlxqPartyByPartyid2(ZlxqParty zlxqPartyByPartyid2) {
		this.zlxqPartyByPartyid2 = zlxqPartyByPartyid2;
	}

	public ZlxqParty getZlxqPartyByPartyid1() {
		return this.zlxqPartyByPartyid1;
	}

	public void setZlxqPartyByPartyid1(ZlxqParty zlxqPartyByPartyid1) {
		this.zlxqPartyByPartyid1 = zlxqPartyByPartyid1;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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

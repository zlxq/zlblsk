package pojo;
// Generated 2019-5-15 22:56:17 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * BlskTemplateDetail generated by hbm2java
 */
public class BlskTemplateDetail implements java.io.Serializable {

	private Long id;
	private BlskTemplateMain blskTemplateMain;
	private String tplHeader;
	private String OHeader;
	private String type;
	private Long deptid;
	private Long creator;
	private Date createtime;
	private Date updatetime;
	private String isvalidate;
	private Long lineno;

	public BlskTemplateDetail() {
	}

	public BlskTemplateDetail(BlskTemplateMain blskTemplateMain, String tplHeader, String OHeader, String type,
			Long deptid, Long creator, Date createtime, Date updatetime, String isvalidate, Long lineno) {
		this.blskTemplateMain = blskTemplateMain;
		this.tplHeader = tplHeader;
		this.OHeader = OHeader;
		this.type = type;
		this.deptid = deptid;
		this.creator = creator;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.isvalidate = isvalidate;
		this.lineno = lineno;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BlskTemplateMain getBlskTemplateMain() {
		return this.blskTemplateMain;
	}

	public void setBlskTemplateMain(BlskTemplateMain blskTemplateMain) {
		this.blskTemplateMain = blskTemplateMain;
	}

	public String getTplHeader() {
		return this.tplHeader;
	}

	public void setTplHeader(String tplHeader) {
		this.tplHeader = tplHeader;
	}

	public String getOHeader() {
		return this.OHeader;
	}

	public void setOHeader(String OHeader) {
		this.OHeader = OHeader;
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

	public Long getLineno() {
		return lineno;
	}

	public void setLineno(Long lineno) {
		this.lineno = lineno;
	}
	
	

}

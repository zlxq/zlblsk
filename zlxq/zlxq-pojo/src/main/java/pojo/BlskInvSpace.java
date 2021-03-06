package pojo;
// Generated 2019-5-15 22:56:17 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * BlskInvSpace generated by hbm2java
 */
public class BlskInvSpace implements java.io.Serializable {

	private Long id;
	private BlskInvSpace blskInvSpace;
	private String no;
	private String name;
	private String type;
	private String sapceName;
	private String unitname;
	private String allname;
	private String lor;
	private String invrow;
	private String invfloor;
	private String invcolumn;
	private String svgid;
	private String isclose;
	private Long length;
	private Long width;
	private Long hight;
	private Long rowFloors;
	private Long floorColumns;
	private Long deptid;
	private Long creator;
	private Date createtime;
	private Date updatetime;
	private String isvalidate;
	private Set blskInvSpaces = new HashSet(0);
	private Set blskSpaceAddresses = new HashSet(0);
	private Set blskSpaceEquips = new HashSet(0);
	private Set blskSpaceFiles = new HashSet(0);
	private Set blskSpaceProperties = new HashSet(0);

	public BlskInvSpace() {
	}

	public BlskInvSpace(BlskInvSpace blskInvSpace, String no, String name, String type, String sapceName,
			String unitname, String allname, String lor, String invrow, String invfloor, String invcolumn, String svgid,
			String isclose, Long length, Long width, Long hight, Long rowFloors, Long floorColumns, Long deptid,
			Long creator, Date createtime, Date updatetime, String isvalidate, Set blskInvSpaces,
			Set blskSpaceAddresses, Set blskSpaceEquips, Set blskSpaceFiles, Set blskSpaceProperties) {
		this.blskInvSpace = blskInvSpace;
		this.no = no;
		this.name = name;
		this.type = type;
		this.sapceName = sapceName;
		this.unitname = unitname;
		this.allname = allname;
		this.lor = lor;
		this.invrow = invrow;
		this.invfloor = invfloor;
		this.invcolumn = invcolumn;
		this.svgid = svgid;
		this.isclose = isclose;
		this.length = length;
		this.width = width;
		this.hight = hight;
		this.rowFloors = rowFloors;
		this.floorColumns = floorColumns;
		this.deptid = deptid;
		this.creator = creator;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.isvalidate = isvalidate;
		this.blskInvSpaces = blskInvSpaces;
		this.blskSpaceAddresses = blskSpaceAddresses;
		this.blskSpaceEquips = blskSpaceEquips;
		this.blskSpaceFiles = blskSpaceFiles;
		this.blskSpaceProperties = blskSpaceProperties;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BlskInvSpace getBlskInvSpace() {
		return this.blskInvSpace;
	}

	public void setBlskInvSpace(BlskInvSpace blskInvSpace) {
		this.blskInvSpace = blskInvSpace;
	}

	public String getNo() {
		return this.no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSapceName() {
		return this.sapceName;
	}

	public void setSapceName(String sapceName) {
		this.sapceName = sapceName;
	}

	public String getUnitname() {
		return this.unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public String getAllname() {
		return this.allname;
	}

	public void setAllname(String allname) {
		this.allname = allname;
	}

	public String getLor() {
		return this.lor;
	}

	public void setLor(String lor) {
		this.lor = lor;
	}

	public String getInvrow() {
		return this.invrow;
	}

	public void setInvrow(String invrow) {
		this.invrow = invrow;
	}

	public String getInvfloor() {
		return this.invfloor;
	}

	public void setInvfloor(String invfloor) {
		this.invfloor = invfloor;
	}

	public String getInvcolumn() {
		return this.invcolumn;
	}

	public void setInvcolumn(String invcolumn) {
		this.invcolumn = invcolumn;
	}

	public String getSvgid() {
		return this.svgid;
	}

	public void setSvgid(String svgid) {
		this.svgid = svgid;
	}

	public String getIsclose() {
		return this.isclose;
	}

	public void setIsclose(String isclose) {
		this.isclose = isclose;
	}

	public Long getLength() {
		return this.length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public Long getWidth() {
		return this.width;
	}

	public void setWidth(Long width) {
		this.width = width;
	}

	public Long getHight() {
		return this.hight;
	}

	public void setHight(Long hight) {
		this.hight = hight;
	}

	public Long getRowFloors() {
		return this.rowFloors;
	}

	public void setRowFloors(Long rowFloors) {
		this.rowFloors = rowFloors;
	}

	public Long getFloorColumns() {
		return this.floorColumns;
	}

	public void setFloorColumns(Long floorColumns) {
		this.floorColumns = floorColumns;
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

	public Set getBlskInvSpaces() {
		return this.blskInvSpaces;
	}

	public void setBlskInvSpaces(Set blskInvSpaces) {
		this.blskInvSpaces = blskInvSpaces;
	}

	public Set getBlskSpaceAddresses() {
		return this.blskSpaceAddresses;
	}

	public void setBlskSpaceAddresses(Set blskSpaceAddresses) {
		this.blskSpaceAddresses = blskSpaceAddresses;
	}

	public Set getBlskSpaceEquips() {
		return this.blskSpaceEquips;
	}

	public void setBlskSpaceEquips(Set blskSpaceEquips) {
		this.blskSpaceEquips = blskSpaceEquips;
	}

	public Set getBlskSpaceFiles() {
		return this.blskSpaceFiles;
	}

	public void setBlskSpaceFiles(Set blskSpaceFiles) {
		this.blskSpaceFiles = blskSpaceFiles;
	}

	public Set getBlskSpaceProperties() {
		return this.blskSpaceProperties;
	}

	public void setBlskSpaceProperties(Set blskSpaceProperties) {
		this.blskSpaceProperties = blskSpaceProperties;
	}

}

package pojo;
// Generated 2019-5-15 22:56:17 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * BlskDocInfo generated by hbm2java
 */
public class BlskDocInfo implements java.io.Serializable {

	private Long id;
	private String fileName;
	private String fileFix;
	private String fileSize;
	private String localPath;
	private String serverPath;
	private String fileVersion;
	private Long deptid;
	private Long creator;
	private Date createtime;
	private Date updatetime;
	private String isvalidate;
	private Set blskSpaceFiles = new HashSet(0);

	public BlskDocInfo() {
	}

	public BlskDocInfo(String fileName, String fileFix, String fileSize, String localPath, String serverPath, String fileVersion,
			Long deptid, Long creator, Date createtime, Date updatetime, String isvalidate, Set blskSpaceFiles) {
		this.fileName = fileName;
		this.fileFix = fileFix;
		this.fileSize = fileSize;
		this.localPath = localPath;
		this.serverPath = serverPath;
		this.fileVersion = fileVersion;
		this.deptid = deptid;
		this.creator = creator;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.isvalidate = isvalidate;
		this.blskSpaceFiles = blskSpaceFiles;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileFix() {
		return this.fileFix;
	}

	public void setFileFix(String fileFix) {
		this.fileFix = fileFix;
	}

	public String getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getLocalPath() {
		return this.localPath;
	}

	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}

	public String getServerPath() {
		return this.serverPath;
	}

	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
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

	public Set getBlskSpaceFiles() {
		return this.blskSpaceFiles;
	}

	public void setBlskSpaceFiles(Set blskSpaceFiles) {
		this.blskSpaceFiles = blskSpaceFiles;
	}

	/**
	 * @Title: getFileVersion <BR>
	 * @Description: please write your description <BR>
	 * @return: String <BR>
	 */
	public String getFileVersion() {
		return fileVersion;
	}

	/**
	 * @Title: setFileVersion <BR>
	 * @Description: please write your description <BR>
	 * @return: String <BR>
	 */
	public void setFileVersion(String fileVersion) {
		this.fileVersion = fileVersion;
	}
}

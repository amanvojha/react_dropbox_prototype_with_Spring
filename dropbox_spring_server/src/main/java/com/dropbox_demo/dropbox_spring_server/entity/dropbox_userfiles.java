package com.dropbox_demo.dropbox_spring_server.entity;

import java.util.List;

public class dropbox_userfiles {
	
	private String username;
	private Double fileId;
	private String file_name;
	private Boolean isStarred;
	private Boolean isOwner;
	private String isFile;
	private String parentId;
	private List sharedWith;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Double getFileId() {
		return fileId;
	}
	public void setFileId(Double fileId) {
		this.fileId = fileId;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public Boolean getIsStarred() {
		return isStarred;
	}
	public void setIsStarred(Boolean isStarred) {
		this.isStarred = isStarred;
	}
	public Boolean getIsOwner() {
		return isOwner;
	}
	public void setIsOwner(Boolean isOwner) {
		this.isOwner = isOwner;
	}
	public String getIsFile() {
		return isFile;
	}
	public void setIsFile(String isFile) {
		this.isFile = isFile;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public List getSharedWith() {
		return sharedWith;
	}
	public void setSharedWith(List sharedWith) {
		this.sharedWith = sharedWith;
	}
	
	
	
	

}

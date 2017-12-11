package com.dropbox_demo.dropbox_spring_server.entity;

import java.util.List;

public class dropbox_usergroups {
	
	private String username;
	private Double GroupId;
	private String group_name;
	private String isFile;
	private String parentId;
	private List members;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Double getGroupId() {
		return GroupId;
	}
	public void setGroupId(Double groupId) {
		GroupId = groupId;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
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
	public List getMembers() {
		return members;
	}
	public void setMembers(List members) {
		this.members = members;
	}
	
	

}

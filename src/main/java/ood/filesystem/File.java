package ood.filesystem;

import java.time.LocalDateTime;

public class File {

	private LocalDateTime modifiedTime;
	private String content;
	private User owner;
	private Permission ownerPermission;
	private Permission groupPermission;
	private Permission otherPermission;

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Permission getOwnerPermission() {
		return ownerPermission;
	}

	public void setOwnerPermission(Permission ownerPermission) {
		this.ownerPermission = ownerPermission;
	}

	public Permission getGroupPermission() {
		return groupPermission;
	}

	public void setGroupPermission(Permission groupPermission) {
		this.groupPermission = groupPermission;
	}

	public Permission getOtherPermission() {
		return otherPermission;
	}

	public void setOtherPermission(Permission otherPermission) {
		this.otherPermission = otherPermission;
	}

}

package com.shoe.test;
// Generated Dec 3, 2018 6:37:20 PM by Hibernate Tools 5.3.6.Final

/**
 * UserRolesId generated by hbm2java
 */
public class UserRolesId implements java.io.Serializable {

	private Integer userId;
	private Integer roleId;

	public UserRolesId() {
	}

	public UserRolesId(Integer userId, Integer roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserRolesId))
			return false;
		UserRolesId castOther = (UserRolesId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(castOther.getUserId())))
				&& ((this.getRoleId() == castOther.getRoleId()) || (this.getRoleId() != null
						&& castOther.getRoleId() != null && this.getRoleId().equals(castOther.getRoleId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result + (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		return result;
	}

}
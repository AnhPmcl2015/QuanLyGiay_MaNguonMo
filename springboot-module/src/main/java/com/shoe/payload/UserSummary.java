package com.shoe.payload;

import java.util.Set;

import com.shoe.entities.Role;

public class UserSummary {
    private Long id;
    private String username;
    private Set<Role> roles;

    public UserSummary(Long id, String username, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRole(Set<Role> roles) {
		this.roles = roles;
	}
    
}

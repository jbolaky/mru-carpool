package com.javaid.bolaky.domain.userregistration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.javaid.bolaky.domain.userregistration.entity.enumerated.Role;

@Embeddable
public class AuthorityKey implements Serializable {

	private static final long serialVersionUID = 5438856832065704859L;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "authority", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role = Role.ROLE_USER;

	public String getUsername() {
		return username;
	}

	public Role getRole() {
		return role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}

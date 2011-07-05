package com.javaid.bolaky.domain.userregistration.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.javaid.bolaky.domain.userregistration.entity.enumerated.Role;

@Entity
@Table(name = "authorities")
public class Authority implements Serializable {

	private static final long serialVersionUID = -5263266063018603641L;

	@EmbeddedId
	private AuthorityKey authorityKey = new AuthorityKey();

	@MapsId("username")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "username", nullable = false)
	private User user;

	public Role getRole() {
		return authorityKey != null ? authorityKey.getRole() : null;
	}

	public User getUser() {
		return user;
	}

	void setUser(User user) {
		this.user = user;
	}

	public void setRole(Role role) {

		if (authorityKey != null) {
			authorityKey.setRole(role);
		} else {
			this.authorityKey = new AuthorityKey();
			this.authorityKey.setRole(role);
		}
	}

}

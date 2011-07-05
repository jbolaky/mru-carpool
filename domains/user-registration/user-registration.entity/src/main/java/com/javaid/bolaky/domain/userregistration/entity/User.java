package com.javaid.bolaky.domain.userregistration.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.collections15.set.ListOrderedSet;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -3205779158441148487L;

	@Id
	@Column(name = "username",nullable=false)
	private String username;

	@Column(name = "password",nullable=false)
	private String password;

	@Column(name = "enabled",nullable=false)
	@Type(type = "boolean")
	private Boolean active;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Authority> authorities = new ListOrderedSet<Authority>();

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Boolean getActive() {
		return active;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void addAuthority(Authority authority) {

		if (authority != null) {
			authority.setUser(this);
		}

		this.authorities.add(authority);
	}

}

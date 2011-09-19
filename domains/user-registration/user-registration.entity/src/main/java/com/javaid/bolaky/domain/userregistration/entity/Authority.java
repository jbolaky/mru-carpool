package com.javaid.bolaky.domain.userregistration.entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.javaid.bolaky.domain.jpa.entity.AbstractTimestampUsernameEntity;
import com.javaid.bolaky.domain.userregistration.entity.enumerated.Role;

@Entity
@Table(name = "AUTHORITIES")
@TypeDefs({ @TypeDef(name = "hibernate_persistentDateTime", typeClass = org.joda.time.contrib.hibernate.PersistentDateTime.class) })
public class Authority extends AbstractTimestampUsernameEntity {

	private static final long serialVersionUID = -5263266063018603641L;

	@EmbeddedId
	private AuthorityKey authorityKey = new AuthorityKey();

	@MapsId("username")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USERNAME", nullable = false)
	private Person person;

	public Role getRole() {
		return authorityKey != null ? authorityKey.getRole() : null;
	}

	public Person getPerson() {
		return person;
	}

	void setPerson(Person person) {
		this.person = person;
	}

	public void setRole(Role role) {

		if (authorityKey != null) {
			authorityKey.setRole(role);
		} else {
			this.authorityKey = new AuthorityKey();
			this.authorityKey.setRole(role);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Authority other = (Authority) obj;
		if (authorityKey == null) {
			if (other.authorityKey != null)
				return false;
		} else if (!authorityKey.equals(other.authorityKey))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((authorityKey == null) ? 0 : authorityKey.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).toString();
	}

}

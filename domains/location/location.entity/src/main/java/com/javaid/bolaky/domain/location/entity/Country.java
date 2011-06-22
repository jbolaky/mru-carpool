package com.javaid.bolaky.domain.location.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.apache.commons.collections15.set.ListOrderedSet;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.javaid.bolaky.domain.jpa.entity.AbstractTimestampUsernameEntity;

@Entity
@Table(name = "COUNTRY")
@TypeDefs({ @TypeDef(name = "hibernate_persistentDateTime", typeClass = org.joda.time.contrib.hibernate.PersistentDateTime.class) })
public class Country extends AbstractTimestampUsernameEntity {

	private static final long serialVersionUID = 2093893125127380734L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COUNTRY_ID", nullable = false)
	private Long countryId;

	@Column(name = "COUNTRY_NAME")
	private String countryName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
	@OrderColumn
	private Set<Area> areas = new ListOrderedSet<Area>();

	public Long getCountryId() {
		return countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public Set<Area> getAreas() {
		return areas;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void addArea(Area area) {

		if (area != null) {
			area.setCountry(this);
		}

		this.areas.add(area);
	}

	public void removeArea(Area area) {
		this.areas.remove(area);
	}

}

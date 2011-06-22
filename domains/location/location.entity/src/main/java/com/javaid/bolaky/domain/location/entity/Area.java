package com.javaid.bolaky.domain.location.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.apache.commons.collections15.set.ListOrderedSet;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.javaid.bolaky.domain.jpa.entity.AbstractTimestampUsernameEntity;

@Entity
@Table(name = "AREA")
@TypeDefs({ @TypeDef(name = "hibernate_persistentDateTime", typeClass = org.joda.time.contrib.hibernate.PersistentDateTime.class) })
public class Area extends AbstractTimestampUsernameEntity {

	private static final long serialVersionUID = -4997500221880989748L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AREA_ID", nullable = false)
	private Long areaId;

	@Column(name = "AREA_NAME")
	private String areaName;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "COUNTRY_ID")
	private Country country;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
	@OrderColumn
	private Set<District> districts = new ListOrderedSet<District>();

	public Long getAreaId() {
		return areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public Country getCountry() {
		return country;
	}

	public Set<District> getDistricts() {
		return districts;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	protected void setCountry(Country country) {
		this.country = country;
	}

	public void addDistrict(District district) {

		if (district != null) {
			district.setArea(this);
		}

		this.districts.add(district);
	}

	public void removeDistrict(District district) {
		this.districts.remove(district);
	}

}

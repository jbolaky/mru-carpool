package com.javaid.bolaky.domain.location.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.javaid.bolaky.domain.jpa.entity.AbstractTimestampUsernameEntity;

@Entity
@Table(name = "DISTRICT")
@TypeDefs({ @TypeDef(name = "hibernate_persistentDateTime", typeClass = org.joda.time.contrib.hibernate.PersistentDateTime.class) })
public class District extends AbstractTimestampUsernameEntity {

	private static final long serialVersionUID = 7348043146336232945L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DISTRICT_ID", nullable = false)
	private Long districtId;

	@Column(name = "DISTRICT_NAME")
	private String districtName;

	@Column(name = "CITY_INDICATOR")
	@Type(type = "yes_no")
	private Boolean city;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AREA_ID")
	private Area area;

	public Long getDistrictId() {
		return districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public Boolean isCity() {
		return city;
	}

	public Area getArea() {
		return area;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public void setCity(Boolean city) {
		this.city = city;
	}

	protected void setArea(Area area) {
		this.area = area;
	}

}

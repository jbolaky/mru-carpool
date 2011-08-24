package com.javaid.bolaky.domain.pools.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.collections15.set.ListOrderedSet;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.javaid.bolaky.domain.jpa.entity.AbstractTimestampUsernameEntity;
import com.javaid.bolaky.domain.pools.entity.enumerated.StateStatus;

@Entity
@Table(name = "PASSENGER")
@TypeDefs({
		@TypeDef(name = "hibernate_persistentDateTime", typeClass = org.joda.time.contrib.hibernate.PersistentDateTime.class),
		@TypeDef(name = "state_status_user_types", typeClass = com.javaid.bolaky.domain.hibernate.jpa.enumeration.GenericEnumUserType.class, parameters = @Parameter(name = "type", value = "com.javaid.bolaky.domain.pools.entity.enumerated.StateStatus")) })
public class Passenger extends AbstractTimestampUsernameEntity {

	private static final long serialVersionUID = 596060287284076767L;

	@Id
	@Column(name = "USERNAME")
	private String username;

	@Type(type = "state_status_user_types")
	@Column(name = "STATE_STATUS_INDICATOR")
	private StateStatus stateStatus;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "passenger")
	private Set<PassengerRequestInfo> passengerRequestInfos = new ListOrderedSet<PassengerRequestInfo>();

	@JoinColumn(name = "POOL_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private Pool pool;

	public String getUsername() {
		return username;
	}

	public StateStatus getStateStatus() {
		return stateStatus;
	}

	public Pool getPool() {
		return pool;
	}

	public Set<PassengerRequestInfo> getPassengerRequestInfos() {
		return passengerRequestInfos;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setStateStatus(StateStatus stateStatus) {
		this.stateStatus = stateStatus;
	}

	public void addPassengerRequestInfo(PassengerRequestInfo passengerRequestInfo){
		
		if(passengerRequestInfo!=null){
			passengerRequestInfo.setPassenger(this);
		}
		
		passengerRequestInfos.add(passengerRequestInfo);
	}
	
	void setPool(Pool pool) {
		this.pool = pool;
	}

}

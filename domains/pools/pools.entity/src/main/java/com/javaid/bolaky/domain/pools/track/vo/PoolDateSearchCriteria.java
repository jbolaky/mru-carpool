package com.javaid.bolaky.domain.pools.track.vo;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class PoolDateSearchCriteria {

	private LocalDate startingPoolDateRange;

	private LocalDate endPoolDateRange;

	private LocalTime startingPoolTimeRange;

	private LocalTime endPoolTimeRange;

	public LocalDate getStartingPoolDateRange() {
		return startingPoolDateRange;
	}

	public LocalDate getEndPoolDateRange() {
		return endPoolDateRange;
	}

	public LocalTime getStartingPoolTimeRange() {
		return startingPoolTimeRange;
	}

	public LocalTime getEndPoolTimeRange() {
		return endPoolTimeRange;
	}

	public void setStartingPoolDateRange(LocalDate startingPoolDateRange) {
		this.startingPoolDateRange = startingPoolDateRange;
	}

	public void setEndPoolDateRange(LocalDate endPoolDateRange) {
		this.endPoolDateRange = endPoolDateRange;
	}

	public void setStartingPoolTimeRange(LocalTime startingPoolTimeRange) {
		this.startingPoolTimeRange = startingPoolTimeRange;
	}

	public void setEndPoolTimeRange(LocalTime endPoolTimeRange) {
		this.endPoolTimeRange = endPoolTimeRange;
	}

}

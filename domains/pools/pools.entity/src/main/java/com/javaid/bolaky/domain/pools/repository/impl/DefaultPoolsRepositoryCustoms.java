package com.javaid.bolaky.domain.pools.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.javaid.bolaky.domain.pools.entity.Pool;
import com.javaid.bolaky.domain.pools.track.vo.PoolSearchCriteria;

public class DefaultPoolsRepositoryCustoms implements
		com.javaid.bolaky.domain.pools.repository.api.PoolsRepositoryCustoms {

	private static final String ONE_WAY_RETURN = "oneWayTravel";
	private static final String GENDER = "gender";
	private static final String SHARE_COST = "shareCost";
	private static final String DRIVER_AGE_GROUP = "ageGroup";
	private static final String NUMBER_OF_PASSENGER = "numberOfCurrentPassengers";
	private static final String FROM_AREA_CODE = "startingPointInfo.fromAreaCode";
	private static final String FROM_DISTRICT_CODE = "startingPointInfo.fromDistrictCode";
	private static final String TO_AREA_CODE = "destinationInfo.toAreaCode";
	private static final String TO_DISTRICT_CODE = "destinationInfo.toDistictCode";

	@PersistenceContext(unitName = "javaid.bolaky")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Pool> findPool(PoolSearchCriteria poolSearchCriteria) {

		List<Pool> pools = null;

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Pool.class);

		if (poolSearchCriteria != null) {

			if (poolSearchCriteria.getOneWayReturn() != null) {
				criteria.add(Restrictions.eq(ONE_WAY_RETURN,
						poolSearchCriteria.getOneWayReturn()));
			}

			if (poolSearchCriteria.getDriverGender() != null) {
				criteria.add(Restrictions.eq(GENDER, poolSearchCriteria
						.getDriverGender().getCode()));
			}

			if (poolSearchCriteria.getShareCost() != null) {
				criteria.add(Restrictions.eq(SHARE_COST,
						poolSearchCriteria.getShareCost()));
			}

			if (poolSearchCriteria.getDriverAgeGroup() != null) {
				criteria.add(Restrictions.eq(DRIVER_AGE_GROUP,
						poolSearchCriteria.getDriverAgeGroup().getCode()));
			}

			if (poolSearchCriteria.getNumberOfCurrentPassengers() != null) {
				criteria.add(Restrictions.eq(NUMBER_OF_PASSENGER,
						poolSearchCriteria.getNumberOfCurrentPassengers()));
			}

			if (poolSearchCriteria.getStartingPointInfoPoolSearchCriteria() != null) {

				if (poolSearchCriteria.getStartingPointInfoPoolSearchCriteria()
						.getFromAreaCode() != null) {

					criteria.add(Restrictions.eq(FROM_AREA_CODE,
							poolSearchCriteria
									.getStartingPointInfoPoolSearchCriteria()
									.getFromAreaCode()));
				}

				if (poolSearchCriteria.getStartingPointInfoPoolSearchCriteria()
						.getFromDistrictCode() != null) {

					criteria.add(Restrictions.eq(FROM_DISTRICT_CODE,
							poolSearchCriteria
									.getStartingPointInfoPoolSearchCriteria()
									.getFromDistrictCode()));
				}
			}

			if (poolSearchCriteria.getDestinationInfoPoolSearchCriteria() != null) {

				if (poolSearchCriteria.getDestinationInfoPoolSearchCriteria()
						.getToAreaCode() != null) {

					criteria.add(Restrictions.eq(TO_AREA_CODE,
							poolSearchCriteria
									.getDestinationInfoPoolSearchCriteria()
									.getToAreaCode()));
				}

				if (poolSearchCriteria.getDestinationInfoPoolSearchCriteria()
						.getToDistictCode() != null) {

					criteria.add(Restrictions.eq(TO_DISTRICT_CODE,
							poolSearchCriteria
									.getDestinationInfoPoolSearchCriteria()
									.getToDistictCode()));
				}

				if (poolSearchCriteria.getPoolDays() != null
						&& !poolSearchCriteria.getPoolDays().isEmpty()) {

					// criteria.createAlias("travelDaysAndAvailableSeats",
					// "td");
					// criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
				}
			}
		}

		pools = criteria.list();

		return pools;
	}

}

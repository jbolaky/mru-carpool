package com.javaid.bolaky.domain.pools.entity.enumerated;

public enum PoolStatus {

	DRAFT(0), ACTIVE(1), COMPLETED(2), CANCELLED(3);

	private Integer code;

	private PoolStatus(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static PoolStatus convertCode(Integer code) {

		if (code != null) {

			for (PoolStatus poolStatus : values()) {

				if (poolStatus.getCode().equals(code)) {
					return poolStatus;
				}
			}
		}

		return null;
	}
}

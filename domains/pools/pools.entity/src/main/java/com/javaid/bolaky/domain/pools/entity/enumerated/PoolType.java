package com.javaid.bolaky.domain.pools.entity.enumerated;

public enum PoolType {

	CARPOOL(1), VANPOOL(2);

	private Integer code;

	private PoolType(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static PoolType convertCode(Integer code) {

		if (code != null) {

			for (PoolType poolType : values()) {

				if (poolType.getCode().equals(code)) {
					return poolType;
				}
			}
		}

		return null;
	}
}

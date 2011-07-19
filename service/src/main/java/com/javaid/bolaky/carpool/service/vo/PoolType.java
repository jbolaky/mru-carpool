package com.javaid.bolaky.carpool.service.vo;

public enum PoolType {

	CARPOOL("1"), VANPOOL("2");

	private String code;

	private PoolType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static PoolType convertCode(String code) {

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

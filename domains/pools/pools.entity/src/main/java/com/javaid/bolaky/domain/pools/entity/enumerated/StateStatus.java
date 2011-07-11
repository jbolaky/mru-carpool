package com.javaid.bolaky.domain.pools.entity.enumerated;

public enum StateStatus {

	ACCEPTED(0), REJECTED(1), PENDING(2);

	private Integer code;

	private StateStatus(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static StateStatus convertCode(Integer code) {

		if (code != null) {

			for (StateStatus stateStatus : values()) {

				if (stateStatus.getCode().equals(code)) {
					return stateStatus;
				}
			}
		}

		return null;
	}
}

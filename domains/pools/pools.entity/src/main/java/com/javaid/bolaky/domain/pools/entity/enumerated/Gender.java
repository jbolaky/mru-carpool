package com.javaid.bolaky.domain.pools.entity.enumerated;

public enum Gender {

	MALE('M'), FEMALE('F'), BOTH('B');

	private Character code;

	private Gender(Character code) {
		this.code = code;
	}

	public Character getCode() {
		return code;
	}

	public static Gender convertCode(Character code) {

		if (code != null) {

			for (Gender gender : values()) {

				if (gender.getCode().equals(code)) {
					return gender;
				}
			}
		}

		return null;
	}
}

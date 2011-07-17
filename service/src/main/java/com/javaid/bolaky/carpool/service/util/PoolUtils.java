package com.javaid.bolaky.carpool.service.util;

public class PoolUtils {

	public static Integer convertToInteger(String integerInString) {

		Integer integer = null;

		if (integerInString != null) {

			try {
				integer = Integer.parseInt(integerInString);
			} catch (NumberFormatException nfe) {
			}
		}

		return integer;
	}

	public static Boolean convertToBoolean(String booleanInString) {

		Boolean booleean = null;

		if (booleanInString != null) {

			booleean = Boolean.parseBoolean(booleanInString);
		}

		return booleean;
	}
}

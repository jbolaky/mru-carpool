package com.javaid.bolaky.carpool.service.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

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

	public static Character convertToCharacter(String characterInString) {

		Character character = null;

		if (characterInString != null && characterInString.length() > 0) {

			character = Character.valueOf(characterInString.charAt(0));
		}

		return character;
	}

	public static LocalDate convertToLocalDate(String localDateInString) {

		LocalDate localDate = null;

		if (localDateInString != null) {

			try {
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				localDate = LocalDate.fromDateFields(dateFormat
						.parse(localDateInString));
			} catch (ParseException pe) {
			}
		}

		return localDate;
	}

	public static LocalTime convertToLocalTime(String localTimeInString) {

		LocalTime localTime = null;

		if (localTimeInString != null) {

			try {
				DateFormat dateFormat = new SimpleDateFormat("HH:mm");
				localTime = LocalTime.fromDateFields(dateFormat
						.parse(localTimeInString));
			} catch (ParseException pe) {
			}
		}

		return localTime;
	}
}

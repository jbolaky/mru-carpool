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

	public static Character convertToCharacter(String characterInString) {

		Character character = null;

		if (characterInString != null && characterInString.length() > 0) {

			character = Character.valueOf(characterInString.charAt(0));
		}

		return character;
	}
	
}

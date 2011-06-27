package com.javaid.bolaky.carpool.web.controller.util;

import java.lang.reflect.Field;

import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

public class ControllerUtility {

	public static void assignAllEmptyStringTypeAttributeToNull(
			final Object object) {

		FieldCallback fieldCallback = new FieldCallback() {

			public void doWith(Field field) throws IllegalArgumentException,
					IllegalAccessException {
				
				field.setAccessible(true);
				if (field.getType() == String.class
						&& field.get(object) != null
						&& field.get(object).equals("")) {
					ReflectionUtils.makeAccessible(field);
					ReflectionUtils.setField(field, object, null);
				}
			}
		};

		ReflectionUtils.doWithFields(object.getClass(), fieldCallback);
	}
}

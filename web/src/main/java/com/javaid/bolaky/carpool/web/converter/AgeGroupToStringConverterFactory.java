package com.javaid.bolaky.carpool.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import com.javaid.bolaky.carpool.service.vo.enumerated.AgeGroup;

public class AgeGroupToStringConverterFactory implements
		ConverterFactory<AgeGroup, String> {

	public <T extends String> Converter<AgeGroup, T> getConverter(
			Class<T> targetType) {

		return new AgeGroupEnumToStingConverter<T>();
	}

	private final class AgeGroupEnumToStingConverter<T extends String>
			implements Converter<AgeGroup, T> {

		@SuppressWarnings("unchecked")
		public T convert(final AgeGroup ageGroup) {
			return ageGroup != null ? (T) ageGroup.getCode().toString() : null;
		}
	}

}

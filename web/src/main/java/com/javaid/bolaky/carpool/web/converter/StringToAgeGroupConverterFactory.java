package com.javaid.bolaky.carpool.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

import com.javaid.bolaky.carpool.service.vo.enumerated.AgeGroup;

@Component
public class StringToAgeGroupConverterFactory implements
		ConverterFactory<String, AgeGroup> {

	public <T extends AgeGroup> Converter<String, T> getConverter(
			Class<T> targetType) {

		return new StringToAgeGroupEnumConverter<T>();
	}

	private final class StringToAgeGroupEnumConverter<T extends Enum<AgeGroup>>
			implements Converter<String, T> {

		@SuppressWarnings("unchecked")
		public T convert(final String source) {
			return (T) AgeGroup.convertCode(Integer.parseInt(source));
		}
	}

}

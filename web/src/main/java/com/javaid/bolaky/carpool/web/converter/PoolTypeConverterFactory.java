package com.javaid.bolaky.carpool.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import com.javaid.bolaky.carpool.service.vo.PoolType;

public class PoolTypeConverterFactory implements
		ConverterFactory<String, PoolType> {

	public <T extends PoolType> Converter<String, T> getConverter(
			Class<T> targetType) {

		return new StringToPoolTypeEnumConverter<T>();
	}

	private final class StringToPoolTypeEnumConverter<T extends Enum<PoolType>>
			implements Converter<String, T> {

		public T convert(String source) {
			return (T) PoolType.convertCode(source);
		}
	}

}

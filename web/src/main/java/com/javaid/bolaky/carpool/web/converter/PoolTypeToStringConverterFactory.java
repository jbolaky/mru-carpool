package com.javaid.bolaky.carpool.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import com.javaid.bolaky.carpool.service.vo.PoolType;

public class PoolTypeToStringConverterFactory implements
		ConverterFactory<PoolType, String> {

	public <T extends String> Converter<PoolType, T> getConverter(
			Class<T> targetType) {

		return new PoolTypeEnumToStingConverter<T>();
	}

	private final class PoolTypeEnumToStingConverter<T extends String>
			implements Converter<PoolType, T> {

		@SuppressWarnings("unchecked")
		public T convert(final PoolType poolType) {
			return poolType != null ? (T) poolType.getCode() : null;
		}
	}

}

package com.javaid.bolaky.carpool.web.converter.support;

import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

import com.javaid.bolaky.carpool.web.converter.AgeGroupToStringConverterFactory;
import com.javaid.bolaky.carpool.web.converter.PoolTypeToStringConverterFactory;
import com.javaid.bolaky.carpool.web.converter.StringToPoolTypeConverterFactory;

public class PoolFormattingConversionServiceFactoryBean extends
		FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		
		registry.addConverterFactory(new StringToPoolTypeConverterFactory());
		registry.addConverterFactory(new PoolTypeToStringConverterFactory());
	
		registry.addConverterFactory(new StringToPoolTypeConverterFactory());
		registry.addConverterFactory(new AgeGroupToStringConverterFactory());
	}
}

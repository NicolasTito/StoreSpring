package com.nide_mel.store.store.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nide_mel.store.store.domain.PaymentCreditCard;
import com.nide_mel.store.store.domain.PaymentPayPal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {

	// https://stackoverflow.com/questions/41452598/overcome-can-not-construct-instance-ofinterfaceclass-without-hinting-the-pare
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(PaymentCreditCard.class);
				objectMapper.registerSubtypes(PaymentPayPal.class);
				super.configure(objectMapper);
			};
		};
		return builder;
	}
}

package com.nide_mel.store.store.config;

import java.text.ParseException;

import com.nide_mel.store.store.services.DBService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateDataBase() throws ParseException {

		dbService.instantiateTestDatabase();
		return true;
	}
}

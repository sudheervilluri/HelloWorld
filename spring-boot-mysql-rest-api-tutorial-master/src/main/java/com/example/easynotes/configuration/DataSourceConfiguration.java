package com.example.easynotes.configuration;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
public class DataSourceConfiguration {

	@Bean
    public DataSource jndiSqldataSource() {
		return DataSourceBuilder.create().build();
    }
	
	
	
}

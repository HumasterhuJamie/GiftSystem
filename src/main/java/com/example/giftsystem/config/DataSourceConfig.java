package com.example.giftsystem.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {

	
	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.official")
	public DataSourceProperties DataSourceProperties() {
		return new DataSourceProperties();
	}
	
	
	@Bean
	@Primary
    @ConfigurationProperties("spring.datasource.official")
    public DataSource OfficialDataSource() {
		return DataSourceProperties().initializeDataSourceBuilder().build();
    }

	
	 @Bean("officialJdbcTemplate")
	 @Primary
	 public JdbcTemplate JdbcTemplate(@Qualifier("OfficialDataSource") DataSource DataSource) {
	 return new JdbcTemplate(DataSource);
	 }
	 


}

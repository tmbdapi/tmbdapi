package com.bd.tm.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBMigrationStrategyConfig extends FlywayAutoConfiguration {
	
	
	/**
	 * Return empty flywayMigrationStrategy to disable auto-start of flyway.
	 * 
	 * @param flyway
	 * @return {@link FlywayMigrationInitializer}
	 */
	@Bean
	@ConditionalOnBean
	public FlywayMigrationInitializer flywayInitializer(Flyway flyway) {
		return new FlywayMigrationInitializer(flyway, (f)->{});
	}
}

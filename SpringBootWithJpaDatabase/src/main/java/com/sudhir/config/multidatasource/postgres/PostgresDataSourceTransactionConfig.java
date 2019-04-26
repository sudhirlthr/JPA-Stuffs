/**
 * 
 */
package com.sudhir.config.multidatasource.postgres;

import static java.util.Collections.singletonMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author sudhirk
 *
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "postgresEntityManagerFactoryBean", transactionManagerRef = "postgresTransactionManager", basePackages = "com.sudhir.config.multidatasource.postgres.repository")
@EnableTransactionManagement
public class PostgresDataSourceTransactionConfig {

	@Primary
	@Bean(name = "postgresEntityManagerFactoryBean")
	public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(
			final EntityManagerFactoryBuilder entityManagerFactoryBuilder,
			final @Qualifier("postgresDataSource") DataSource dataSource) {
		return entityManagerFactoryBuilder.dataSource(dataSource).packages("").persistenceUnit("")
				.properties(singletonMap("hibernate.hbm2ddl.auto", "create-drop")).build();
	}

	@Primary
	@Bean(name = "postgresTransactionManager")
	public PlatformTransactionManager postgresTransactionManager(
			@Qualifier("postgresEntityManagerFactoryBean") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}

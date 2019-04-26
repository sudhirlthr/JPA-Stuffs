/**
 * 
 */
package com.sudhir.config.multidatasource.mysql;

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
@EnableJpaRepositories(entityManagerFactoryRef = "mysqlEntityManagerFactoryBean", transactionManagerRef = "mysqlTransactionManager", basePackages = "com.sudhir.config.multidatasource.mysql.repository")
@EnableTransactionManagement
public class MySqlDataSourceTransactionConfig {

	@Bean(name = "mysqlEntityManagerFactoryBean")
	public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(
			final EntityManagerFactoryBuilder entityManagerFactoryBuilder,
			final @Qualifier("mysqlDataSource") DataSource dataSource) {
		return entityManagerFactoryBuilder.dataSource(dataSource).packages("").persistenceUnit("")
				.properties(singletonMap("hibernate.hbm2ddl.auto", "create-drop"))
				.properties(singletonMap("hibernate.show_sql", "true"))
				.properties(singletonMap("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"))
				.properties(singletonMap("hibernate.id.new_generator_mappings","false"))
				.build();
	}

	@Bean(name = "mysqlTransactionManager")
	public PlatformTransactionManager postgresTransactionManager(
			@Qualifier("mysqlEntityManagerFactoryBean") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}

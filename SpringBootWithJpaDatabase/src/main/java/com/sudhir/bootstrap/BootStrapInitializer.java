package com.sudhir.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.sudhir.config.multidatasource.mysql.domain.MysqlDomainPojo;
import com.sudhir.config.multidatasource.mysql.repository.MySqlRepository;
import com.sudhir.config.multidatasource.postgres.domain.PostgresDomainPojo;
import com.sudhir.config.multidatasource.postgres.repository.PostgresRepository;

public class BootStrapInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	MySqlRepository mysqlRepository;

	@Autowired
	private PostgresRepository postRepo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		init();

	}

	public void init() {

		MysqlDomainPojo mysqlDomainPojo = new MysqlDomainPojo("Bajaj Fans");
		MysqlDomainPojo save = mysqlRepository.save(mysqlDomainPojo);
		System.out.println("Name = " + save.getFan());

		PostgresDomainPojo postgresDomainPojo = new PostgresDomainPojo("Kumar");
		PostgresDomainPojo save2 = postRepo.save(postgresDomainPojo);
		System.out.println("Name = " + save2.getLastName());
	}

}

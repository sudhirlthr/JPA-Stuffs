/**
 * 
 */
package com.sudhir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sudhir.config.multidatasource.mysql.domain.MysqlDomainPojo;
import com.sudhir.config.multidatasource.mysql.repository.MySqlRepository;
import com.sudhir.config.multidatasource.postgres.domain.PostgresDomainPojo;
import com.sudhir.config.multidatasource.postgres.repository.PostgresRepository;

/**
 * @author sudhirk
 *
 */
@RestController
public class GenericController {
	
	@Autowired
	MySqlRepository mysqlRepository;
	
	@Autowired
	PostgresRepository postRepo;

	@RequestMapping(path = "/mysql", method = RequestMethod.GET)
	public String mysql() {
		MysqlDomainPojo mysqlDomainPojo = new MysqlDomainPojo("Bajaj Fans");
		MysqlDomainPojo save = mysqlRepository.save(mysqlDomainPojo);
		System.out.println("Name = " + save.getFan());
		return "mysql";
	}
	
	@RequestMapping(path = "/postgres", method = RequestMethod.GET)
	public String postgres() {
		

		PostgresDomainPojo postgresDomainPojo = new PostgresDomainPojo("Kumar");
		PostgresDomainPojo save2 = postRepo.save(postgresDomainPojo);
		System.out.println("Name = " + save2.getLastName());
		return "postgres";
	}
}

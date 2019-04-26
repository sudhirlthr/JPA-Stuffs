package com.sudhir.config.multidatasource.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhir.config.multidatasource.mysql.domain.MysqlDomainPojo;

public interface MySqlRepository extends JpaRepository<MysqlDomainPojo, Long>{

}

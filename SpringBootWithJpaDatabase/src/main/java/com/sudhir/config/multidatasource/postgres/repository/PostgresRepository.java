/**
 * 
 */
package com.sudhir.config.multidatasource.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhir.config.multidatasource.postgres.domain.PostgresDomainPojo;

/**
 * @author sudhirk
 *
 */
public interface PostgresRepository extends JpaRepository<PostgresDomainPojo, Long>{

}

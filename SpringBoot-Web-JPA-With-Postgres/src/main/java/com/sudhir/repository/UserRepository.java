/**
 * 
 */
package com.sudhir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudhir.model.Userdb;

/**
 * @author sudhirk
 *
 */
@Repository
public interface UserRepository extends JpaRepository<Userdb, Long> {

}

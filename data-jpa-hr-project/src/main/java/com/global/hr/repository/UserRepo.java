package com.global.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.hr.entity.Role;
import com.global.hr.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	@Modifying
	@Query("UPDATE User u SET u.role = :role")
	int updateAllUsersRole(@Param("role") Role role);
}

package com.global.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global.hr.entity.Role;
import com.global.hr.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	@Modifying
	@Query("UPDATE User u SET u.role = :role")
	int updateAllUsersRole(@Param("role") Role role);
	
@EntityGraph(attributePaths = {"role"})
	public List<User> findAll() ;
@Transactional
@Modifying
@Query("delete from User where role.roleId = :id")
int deleteByRoleId(Long id);
}

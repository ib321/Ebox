package com.ib.springlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ib.springlogin.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}

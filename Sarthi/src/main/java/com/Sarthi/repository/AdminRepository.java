package com.Sarthi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.Sarthi.controller.model.User;

@Repository
public interface AdminRepository extends JpaRepository<User , Long> {

	 List<User> findAll();
	 void deleteById(Long id);
}

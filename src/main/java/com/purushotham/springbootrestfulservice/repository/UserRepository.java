package com.purushotham.springbootrestfulservice.repository;


import com.purushotham.springbootrestfulservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

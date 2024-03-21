package com.petex.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petex.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long>{

}

package com.petex.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petex.entity.VaccinationEntity;

public interface VacctinationRepo extends JpaRepository<VaccinationEntity, Integer>{

}

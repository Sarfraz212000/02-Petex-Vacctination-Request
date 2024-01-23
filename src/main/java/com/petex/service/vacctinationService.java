package com.petex.service;

import java.util.List;

import com.petex.entity.VaccinationEntity;

public interface vacctinationService {

	public Boolean save(VaccinationEntity entity);

	public List<VaccinationEntity> getAllAppointmentData();

	public String deleteAppointmentById(Integer customerId);

	public VaccinationEntity getAppintmentById(Integer customerId);

	public Boolean updateAppointmentData(Integer customerId, VaccinationEntity entity);

}

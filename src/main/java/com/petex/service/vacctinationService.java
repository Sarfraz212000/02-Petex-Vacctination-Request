package com.petex.service;

import java.io.IOException;
import java.util.List;

import com.lowagie.text.DocumentException;
import com.petex.entity.VaccinationEntity;

public interface vacctinationService {

	public Boolean save(VaccinationEntity entity,Long userId) throws DocumentException, IOException;


	public List<VaccinationEntity> getAllAppointmentData();

	public String deleteAppointmentById(Integer customerId);

	public VaccinationEntity getAppintmentById(Integer customerId);

	public Boolean updateAppointmentData(Integer customerId, VaccinationEntity entity);

}

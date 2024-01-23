package com.petex.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petex.entity.VaccinationEntity;
import com.petex.repo.VacctinationRepo;
import com.petex.service.vacctinationService;

@Service
public class vacctinationServiceImpl implements vacctinationService{
	@Autowired
	private VacctinationRepo repo;

	@Override
	public Boolean save(VaccinationEntity entity) {
		repo.save(entity);
		return true;
	}

	@Override
	public List<VaccinationEntity> getAllAppointmentData() {
		return repo.findAll();
	}

	@Override
	public String deleteAppointmentById(Integer customerId) {

		repo.deleteById(customerId);
		return "deleted";
	}

	@Override
	public VaccinationEntity getAppintmentById(Integer customerId) {
		Optional<VaccinationEntity> appointmentId = repo.findById(customerId);

		if (appointmentId.isPresent()) {
			return appointmentId.get();
		}
		return null;
	}

	@Override
	public Boolean updateAppointmentData(Integer customerId, VaccinationEntity entity) {

		Optional<VaccinationEntity> optinalId = repo.findById(customerId);
		if (optinalId.isPresent()) {
			VaccinationEntity entites = optinalId.get();
			BeanUtils.copyProperties(entity, entites);
			entites.setCustomerId(customerId);
			repo.save(entites);
			return true;
		}
		return false;
	}

}

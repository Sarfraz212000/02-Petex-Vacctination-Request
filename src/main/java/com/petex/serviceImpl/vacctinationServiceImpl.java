package com.petex.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.DocumentException;
import com.petex.entity.UserEntity;
import com.petex.entity.VaccinationEntity;
import com.petex.repo.UserRepo;
import com.petex.repo.VacctinationRepo;
import com.petex.service.vacctinationService;
import com.petex.utils.EmailUtils;
import com.petex.utils.PdfGenerator;

@Service
public class vacctinationServiceImpl implements vacctinationService{
	
	@Autowired
	private VacctinationRepo repo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	

	@Override
	public Boolean save(VaccinationEntity entity,Long userId) throws DocumentException, IOException {
		
		Optional<UserEntity> optinalId = userRepo.findById(userId);
		if (optinalId.isPresent()) {
			UserEntity user = optinalId.get();
			
			entity.setUser(user);
			VaccinationEntity save = repo.save(entity);
			
			File f= new File("Vaccination.pdf");
			
			
			pdfGenerator.generate(save, f);
			
			String subject = "Vaccination Booking Report";
			String body = "Vaccination";
			String to = user.getEmail();

			emailUtils.sendEmail(subject, body, to, f);
			f.delete();
			
			return true;
		}
		
		return false;
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

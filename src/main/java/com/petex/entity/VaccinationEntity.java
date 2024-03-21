package com.petex.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity

@Table(name = "VACCINATION_TAB")
public class VaccinationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;

	private String customerName;

	private String customerEmail;
	
	private Long customerPhno;

	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate date;

	@JsonFormat(pattern = "H:mm")
	private LocalTime time;

	private String description;
	@ManyToOne
	@JoinColumn(name = "user-id")
	private UserEntity user;

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Long getCustomerPhno() {
		return customerPhno;
	}

	public void setCustomerPhno(Long customerPhno) {
		this.customerPhno = customerPhno;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public VaccinationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VaccinationEntity(Integer customerId, String customerName, String customerEmail, Long customerPhno,
			LocalDate date, LocalTime time, String description) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhno = customerPhno;
		this.date = date;
		this.time = time;
		this.description = description;
	}
	
	


}

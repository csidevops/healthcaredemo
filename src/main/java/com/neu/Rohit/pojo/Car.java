package com.neu.Rohit.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Car")
public class Car {
	
	@Id
	@GeneratedValue
	@Column(name="RegistrationNo", nullable=false, unique=true)
	private long registrationNo;
	
	@Column(name="name")
	private String name;
	
		
	@Column(name= "model")
	private String model;
	
	
	@Column(name="DailyRate")
	private String DailyRate;

	@Column(name="HWRefNumber")
	private String HWRefNumber;
	
	@Column(name="TaxesAndFees")
	private String TaxesAndFees;
	
	@Column(name="TotalPrice")
	private String TotalPrice;
	
	@Column(name="RentalDays")
	private String RentalDays;
	
	@Column(name="TypicalSeating")
	private String TypicalSeating;
	
	public Set<BookingDetails> getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(Set<BookingDetails> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="car", cascade=CascadeType.ALL)
	private Set<BookingDetails> bookingDetails = new HashSet<BookingDetails>();
	
public Car(){
		
	}

public Car(String name, String model) {
    this.name = name;
    this.model = model;

}

public long getRegistrationNo() {
	return registrationNo;
}

public void setRegistrationNo(long registrationNo) {
	this.registrationNo = registrationNo;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}


public String getDailyRate() {
	return DailyRate;
}

public void setDailyRate(String dailyRate) {
	DailyRate = dailyRate;
}

public String getHWRefNumber() {
	return HWRefNumber;
}

public void setHWRefNumber(String hWRefNumber) {
	HWRefNumber = hWRefNumber;
}


public String getTaxesAndFees() {
	return TaxesAndFees;
}

public void setTaxesAndFees(String taxesAndFees) {
	TaxesAndFees = taxesAndFees;
}

public String getTotalPrice() {
	return TotalPrice;
}

public void setTotalPrice(String totalPrice) {
	TotalPrice = totalPrice;
}

public String getRentalDays() {
	return RentalDays;
}

public void setRentalDays(String rentalDays) {
	RentalDays = rentalDays;
}

public String getTypicalSeating() {
	return TypicalSeating;
}

public void setTypicalSeating(String typicalSeating) {
	TypicalSeating = typicalSeating;
}


	
}

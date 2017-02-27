package com.neu.Rohit.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.neu.Rohit.pojo.User;

@Entity
@Table(name="BookingDetails")
public class BookingDetails {
	
	@Id
	@GeneratedValue
	@Column(name="bookingID", nullable=false, unique=true)
	private long bookingID;
	
	
	@Column(name= "sourceLocation")
	private String sourceLocation;
	
	@Column(name= "destination")
	private String destination;
	
	@Column(name= "bookingDate")
	private Date bookingDate;
	
	@Column(name= "bookingTime")
	private String bookingTime;
	
	@Column(name= "expiryDate")
	private Date expiryDate;
	
	@Column(name= "expiryTime")
	private String expiryTime;
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@ManyToOne
	@JoinColumn(name="carID")
    private Car car;
	
	@OneToOne
	@JoinColumn(name="paymentID")
    private Payment payment;
	
	/*@ManyToOne
	@JoinColumn(name="userID", nullable=true)
    private User user;*/
	
	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/

	public BookingDetails (String bookingType, String sourceLocation, String destination, Date bookingDate,
		String bookingTime, Date expiryDate, String expiryTime) {
        this.sourceLocation = sourceLocation;
        this.destination = destination;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.expiryDate = expiryDate;
        this.expiryTime = expiryTime;
    }

	BookingDetails() {
    }

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public long getBookingID() {
		return bookingID;
	}

	public void setBookingID(long bookingID) {
		this.bookingID = bookingID;
	}


	public String getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}


	
}

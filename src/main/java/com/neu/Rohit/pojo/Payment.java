package com.neu.Rohit.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Payment")
public class Payment {
	
	@Id
	@GeneratedValue
	@Column(name="paymentID", nullable=false, unique=true)
	private long paymentID;
	
	@Column(name="cardNo")
	private String cardNo;
	
	@Column(name= "expiryDate")
	private String expiryDate;
	
	@Column(name= "cvv")
	private String cvv;
	
	
	@Column(name="cardHolderName")
	private String cardHolderName;
	
	@ManyToOne
	@JoinColumn(name="userID")
    private User user;
	
	public BookingDetails getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(BookingDetails bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToOne(mappedBy="payment", cascade=CascadeType.ALL)
    private BookingDetails bookingDetails;
	
	public Payment (String cardNo, String expiryDate, String cvv,User user) {
        this.cardNo = cardNo;
        this.expiryDate = expiryDate;
        this.user = user;
        this.cvv = cvv;
    }

	Payment() {
    }

	public long getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(long paymentID) {
		this.paymentID = paymentID;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}


	
	

}

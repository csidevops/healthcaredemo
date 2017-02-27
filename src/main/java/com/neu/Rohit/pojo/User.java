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
@Table(name="user")
public class User {
	
	public User(String Name, String email, String password){
		this.Name = Name;
		this.email = email;
		this.password  = password;
	}
	
	@Id
	@GeneratedValue
	@Column(name="userID", nullable=false, unique=true)
	private long userID;
	
	@Column(name="password")
	private String password;
	
	@Column(name="Name")
	private String Name;
	
	
	@Column(name="email")
	private String email;
	
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="user", cascade=CascadeType.ALL)
	private Set<Payment> payment = new HashSet<Payment>();
	
public User(){
		
	}

public User(String Name) {
    //this.userID = id;
    
    this.Name = Name;
}

public Set<Payment> getPayment() {
	return payment;
}

public void setPayment(Set<Payment> payment) {
	this.payment = payment;
}

public long getUserID() {
	return userID;
}

public void setUserID(long userID) {
	this.userID = userID;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getName() {
	return Name;
}

public void setName(String Name) {
	this.Name = Name;
}


public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}



}

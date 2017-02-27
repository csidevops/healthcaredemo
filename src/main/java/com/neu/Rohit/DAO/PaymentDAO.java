package com.neu.Rohit.DAO;

import org.hibernate.HibernateException;

import com.neu.Rohit.Exception.AddException;
import com.neu.Rohit.pojo.Payment;

public class PaymentDAO extends DAO{
	public PaymentDAO(){
		
	}
	public void save(Payment payment) throws AddException {
	    try {
	        begin();
	        getSession().save(payment);
	        commit();
	    } catch (HibernateException e) {
	        rollback();
	        throw new AddException("Could not save the category", e);
	    }
	}
}

package com.neu.Rohit.DAO;

import org.hibernate.HibernateException;

import com.neu.Rohit.Exception.AddException;
import com.neu.Rohit.pojo.BookingDetails;

public class BookingDetailsDAO extends DAO {
public BookingDetailsDAO(){
	
}
public void save(BookingDetails bookingDeatils) throws AddException {
    try {
        begin();
        getSession().save(bookingDeatils);
        commit();
    } catch (HibernateException e) {
        rollback();
        throw new AddException("Could not save the category", e);
    }
}
}

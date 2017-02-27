package com.neu.Rohit.DAO;

import org.hibernate.HibernateException;

import com.neu.Rohit.Exception.AddException;
import com.neu.Rohit.pojo.Car;
import com.neu.Rohit.pojo.Payment;

public class CarDAO extends DAO {
public CarDAO(){
	
}
public void save(Car car) throws AddException {
    try {
        begin();
        getSession().save(car);
        commit();
    } catch (HibernateException e) {
        rollback();
        throw new AddException("Could not save the car", e);
    }
}
}

package com.neu.Rohit.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.Rohit.Exception.AddException;
import com.neu.Rohit.pojo.Payment;
import com.neu.Rohit.pojo.User;

import antlr.collections.List;

public class AccountDAO extends DAO {
	public List list(String userID) throws AddException {
	    try {
	        begin();
	        Query q = getSession().createQuery("from payment where userID = :userID");
	        q.setString("userID", userID);
	        List list = (List) q.list();
	        commit();
	        return list;
	    } catch (HibernateException e) {
	        rollback();
	        throw new AddException("Could not list the request table", e);
	    }
	}

}

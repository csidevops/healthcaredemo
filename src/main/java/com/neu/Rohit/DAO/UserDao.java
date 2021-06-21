package com.neu.Rohit.DAO;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.Rohit.Exception.AddException;
import com.neu.Rohit.pojo.User;
//Added as part of Gcloud Appengine setup
import com.google.api.client.json.jackson2.JacksonFactory;


public class UserDao extends DAO{

	public UserDao(){
		
	}
	public User createUser(String Name, String email, String password)throws AddException {
		try{
			
		    begin();
			User user = new User(Name, email, password);
			user.setName(Name);
			user.setEmail(email);
			user.setPassword(password);
			getSession().save(user);
			commit();
			return user;

	}
	 catch (HibernateException e) {
         rollback();
         throw new AddException("Could not get user " + Name);
     }
	}
	 public User checkUser(String email, String password)
	            throws AddException {
	        try {
	        	begin();
	            Query q = getSession().createQuery("from User where email = :email AND password = :password");
	            System.out.println("Query:" +q);
	            q.setString("email", email);
	            q.setString("password", password);
	            User user = (User) q.uniqueResult();
	            System.out.println("User:" +user);
	            commit();
	            return user;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AddException("Could not get user " + email, e);
	        }
	    }
}

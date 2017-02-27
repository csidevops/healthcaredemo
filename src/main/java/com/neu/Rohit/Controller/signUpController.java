package com.neu.Rohit.Controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.Rohit.DAO.UserDao;
import com.neu.Rohit.pojo.User;

@Controller


public class signUpController {
	
	@RequestMapping(value="/signUp.htm",method = RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String Name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		UserDao userDao = new UserDao();
		User u= userDao.createUser(Name, email, password);
		JSONObject obj = new JSONObject();
		obj.put("successmsg", "Registration Successful");
		PrintWriter out = res.getWriter();
		out.println(obj);
		return null;
        

   }
}

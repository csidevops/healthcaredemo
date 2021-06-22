package com.neu.Rohit.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.Rohit.DAO.AccountDAO;

import antlr.collections.List;


@Controller
public class AccountController {
	@RequestMapping(value="/account.htm",method = RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String userID = req.getParameter("userID");
		AccountDAO accountDAO = new AccountDAO();
		List paymentList = accountDAO;
		System.out.println(paymentList);
		return null;
        

   }
}

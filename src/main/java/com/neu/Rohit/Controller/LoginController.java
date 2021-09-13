package com.neu.Rohit.Controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.Rohit.DAO.UserDao;
import com.neu.Rohit.Exception.AddException;
import com.neu.Rohit.pojo.User;
//Added as part of Gcloud Appengine setup
import com.google.api.client.json.jackson2.JacksonFactory;


@Controller
@RequestMapping("login.htm")
public class LoginController extends HttpServlet{
	@RequestMapping(method=RequestMethod.POST) //mapping at method level- specifies the method name get or post
	
	protected ModelAndView doSubmitAction(@ModelAttribute("user") User user, BindingResult result,Model model, HttpServletRequest req, HttpServletResponse res) throws Exception, AddException{
		ModelAndView mv = new ModelAndView();
		try{
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String action = req.getParameter("action");
			System.out.println(action);
			HttpSession session =req.getSession(false);
			if(action.equalsIgnoreCase("login")){
				UserDao userDao = new UserDao();
				User u = userDao.checkUser(email, password);
				if(u != null){				
					session.setAttribute("User", u);
					mv.setViewName("loginPage");
				}
				else{
					String error = "Invalid Credentials!";
					req.setAttribute("error", error);
					mv.setViewName("home");
					
				}
			}
			else {
				session.invalidate();
				String error="Successfully Logout";
				req.setAttribute("error", error);
				mv.setViewName("home");
			}
		}
		finally{
			
		}
		
		

		return mv;
		
	}
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("person") User user, BindingResult result) {

		return "home";
	}
}

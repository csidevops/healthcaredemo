package com.neu.Rohit.Controller;

import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.Rohit.DAO.UserDao;
import com.neu.Rohit.Exception.AddException;
import com.neu.Rohit.pojo.BookingDetails;
import com.neu.Rohit.pojo.Car;
import com.neu.Rohit.pojo.User;

@Controller
@RequestMapping("/booking.htm")
public class BookingController extends HttpServlet{
@RequestMapping(method=RequestMethod.POST) //mapping at method level- specifies the method name get or post
	
	protected ModelAndView doSubmitAction(@ModelAttribute("booking") BookingDetails bookingDetails,Car car, BindingResult result,Model model, HttpServletRequest req, HttpServletResponse res) throws Exception, AddException{
		ModelAndView mv = new ModelAndView();
		String userID = req.getParameter("userID");
		String error= "Pease Login to Book";
		if(userID.equals("null")){
			req.setAttribute("error", error);
			mv.setViewName("home");
			
		}else{
			
			HttpSession session= req.getSession();
			User u = (User) session.getAttribute("User");
			session.setAttribute("car", car);
			session.setAttribute("bookingDetails", bookingDetails);
			mv.setViewName("booking");
		}
		return mv;
		
	}
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("person") User user, BindingResult result) {

		return "home";
	}
}

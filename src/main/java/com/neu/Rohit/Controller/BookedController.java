package com.neu.Rohit.Controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.Rohit.DAO.BookingDetailsDAO;
import com.neu.Rohit.DAO.CarDAO;
import com.neu.Rohit.DAO.PaymentDAO;
import com.neu.Rohit.Exception.AddException;
import com.neu.Rohit.pojo.BookingDetails;
import com.neu.Rohit.pojo.Car;
import com.neu.Rohit.pojo.Payment;
import com.neu.Rohit.pojo.User;

@Controller
@RequestMapping("/booked.htm")
public class BookedController extends HttpServlet{
@RequestMapping(method=RequestMethod.POST) //mapping at method level- specifies the method name get or post
	
	protected ModelAndView doSubmitAction(@ModelAttribute("booked") Payment payment, User user, BookingDetails bookingDeatils, BindingResult result,Model model, HttpServletRequest req, HttpServletResponse res) throws Exception, AddException{
		ModelAndView mv = new ModelAndView();
		try{
			String cardNo = req.getParameter("cardNo");
			String cvv = req.getParameter("cvv");
			String cardHolderName = req.getParameter("cardHolderName");
			String expiryDate = req.getParameter("cardHolderName");
			HttpSession session= req.getSession();
			BookingDetails bd = (BookingDetails) session.getAttribute("bookingDetails");
			PaymentDAO paymentDAO = new PaymentDAO();
			User u = (User) session.getAttribute("User");
			payment.setCardHolderName(cardHolderName);
			payment.setCardNo(cardNo);
			payment.setCvv(cvv);
			payment.setExpiryDate(expiryDate);
			payment.setUser(u);
			paymentDAO.save(payment);
			Car car = (Car) session.getAttribute("car");
			System.out.println("Model Name is"+ car.getModel());
			CarDAO carDao = new CarDAO();
			carDao.save(car);
			BookingDetailsDAO bookingDetailsDAO = new BookingDetailsDAO();
			bd.setPayment(payment);
			//bd.setUser(user);
			bd.setCar(car);
			bookingDetailsDAO.save(bd);
			String msg = "Thanks! Your Booking is Done";
			req.setAttribute("msg", msg);
			mv.setViewName("carBooked");
		}catch(HibernateException e){
			System.out.println(e);
		}
		
		return mv;
		
	}
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("person") User user, BindingResult result) {

		return "home";
	}

}

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.neu.Rohit.pojo.User" %>
<%@page import="com.neu.Rohit.pojo.Car" %>
<%@page import="com.neu.Rohit.pojo.BookingDetails" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="demo.css">
<style type="text/css">
	<%@include file="../../resources/css/demo.css"%>
   	<%@include file="../../resources/css/style.css"%>
  	<%@include file="../../resources/css/bootstrap.css"%>
</style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <script>
    <%@include file="../../resources/javascript/jquery.creditCardValidator.js"%>
    </script>
	<script>
      $(function() {
    $('.demo .numbers li').wrapInner('<a href="#"></a>').click(function(e) {
      e.preventDefault();
      $('.demo .numbers').slideUp(100);
      return $('#card_number').val($(this).text()).trigger('input');
    });
    $('body').click(function() {
      return $('.demo .numbers').slideUp(100);
    });
    $('.demo .numbers').click(function(e) {
      return e.stopPropagation();
    });
    $('.demo .numbers').hide();
    $('.vertical.maestro').hide().css({
      opacity: 0
    });
    return $('#card_number').validateCreditCard(function(result) {
      $(this).removeClass();
      if (result.card_type == null) {
        $('.vertical.maestro').slideUp({
          duration: 200
        }).animate({
          opacity: 0
        }, {
          queue: false,
          duration: 200
        });
        return;
      }
      $(this).addClass(result.card_type.name);
      if (result.card_type.name === 'maestro') {
        $('.vertical.maestro').slideDown({
          duration: 200
        }).animate({
          opacity: 1
        }, {
          queue: false
        });
      } else {
        $('.vertical.maestro').slideUp({
          duration: 200
        }).animate({
          opacity: 0
        }, {
          queue: false,
          duration: 200
        });
      }
      if (result.valid) {
        return $(this).addClass('valid');
      } else {
        return $(this).removeClass('valid');
      }
    }, {
      accept: ['visa', 'visa_electron', 'mastercard', 'maestro', 'discover']
    });
  });
</script>
</head>
<body>
<% User user= (User)session.getAttribute("User"); %> 
<% Car car = (Car)session.getAttribute("car"); %>
<% BookingDetails bookingDetails = (BookingDetails)session.getAttribute("bookingDetails"); %>
   <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand pull-left" href="index.html">
                	<img src="../../Rohit/resources/images/logo.png" style="margin-top:-16px;" class="img" alt="logo">
                </a>
               
            </div>
            <div class="navbar-header" style="padding-left: 20px; padding-top: 10px">
                <h4><font style="color:green">Welcome <%= user.getName()%></font></h4>
            </div>
            
            <div class="navbar-header" style="float: right; margin-top: 10px" id="LoginForm">
              <form class="form-inline" action="login.htm" method="POST">
             <input type="hidden"  class="btn btn-default" name="action" value="logout"/>
			  <input type="submit"  class="btn btn-default" name="Logout" value="Logout"/>
			   </form>
			</div>
			<div class="navbar-header" style="float: right; margin-top: 10px;margin-right: 10px" id="LoginForm">
              <form class="form-inline" action="account.htm" method="POST">
              <input type="hidden" name="userID" id="userID" value="<%= user.getUserID()%>"/>
              <input type="submit"  class="btn btn-default" name="MyAccount" value="My Account"/>
			   </form>
			</div>
        </div>
    </div>
    <div class="details" style="margin-left: 100px"><form class="form"><div style="float: left;"><label>Reference #</label></div>
    							<div style="float: right;"><%= car.getHWRefNumber() %></div>
    							<div style="padding-top: 10px; float: left;"><label><h4>Trip Summary</h4></label>
    								<div><div style="float: left;">Car Type</div> : <div style="float: right;"><%= car.getName() %></div></div>
    								<div><div style="float: left;">Model</div> : <div style="float: right;"><%= car.getModel() %></div></div>
    								<div><div style="float: left;">Number of Seats</div> : <div style="float: right;"><%= car.getTypicalSeating() %></div></div>
									<div><div style="float: left;">Car Daily Rate</div> : <div style="float: right;"><%= car.getDailyRate() %></div></div>
    								<div><div style="float: left;">Rental Days</div> : <div style="float: right;"><%= car.getRentalDays() %></div></div>
    								<div><div style="float: left;">Taxes & Fees</div> : <div style="float: right;"><%= car.getTaxesAndFees() %></div></div>
    								<div><div style="float: left;"><h4>Sub Total</h4></div> : <div style="float: right;"><h4><%= car.getTotalPrice() %></h4></div></div>
    							</div>
    							
    							<div style="padding-top: 10px; float: left;"><label><h4>Pick Up</h4></label>
    								<div><div ><%= bookingDetails.getBookingDate() %></div></div>
    								<div><div style="padding-top: 5px;"><%= bookingDetails.getBookingTime() %></div></div>
    								<div><div style="padding-top: 5px; "><%= bookingDetails.getSourceLocation() %></div></div>
    							</div>
    							<div style="padding-top: 10px; float: left;"><label><h4>Drop Off</h4></label>
    								<div><div><%= bookingDetails.getExpiryDate() %></div></div>
    								<div><div style="padding-top: 5px; "><%= bookingDetails.getExpiryTime() %></div></div>
    								<div><div style="padding-top: 5px;"><%= bookingDetails.getDestination() %></div></div>
    							</div>
    							</form>
</div>
<div class="demo">
		<form action="booked.htm" method="POST" class="form">
             <h4>Payment details</h4>

             <ul>
                 <li>
                     <label for="card_number">Card number</label>
                     <input type="text" name="cardNo" id="card_number" placeholder="1234 5678 9012 3456" class="">

                     <small class="help">This supports Visa, Visa Electron, Maestro, MasterCard and Discover. </small>
                 </li>

                 <li class="vertical">
                     <ul>
                         <li>
                             <label for="expiry_date">Expiry date</label>
                             <input type="text" name="expiryDate" id="expiry_date" maxlength="5" placeholder="mm/yy">
                         </li>

                         <li>
                             <label for="cvv">CVV</label>
                             <input type="text" name="cvv" id="cvv" maxlength="3" placeholder="123">
                         </li>
                     </ul>
                 </li>

                 <li>
                     <label for="name_on_card">Name on card</label>
                     <input type="text" name="cardHolderName" id="name_on_card" placeholder="Card Holder Name">
                 </li>
                 
                 <li>
                     <input type="submit" name="book" value="submit" />
                 </li>
             </ul>
         </form>
	</div>
</body>
</html>


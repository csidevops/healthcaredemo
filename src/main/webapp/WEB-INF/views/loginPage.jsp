<%@page import="com.neu.Rohit.pojo.User" %>
<%@page import="com.neu.Rohit.DAO.UserDao" %>
<%@page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.mapping.Value" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <meta name="viewport" content="width=device-width, intialscale=1">
    <title>Demo Health Care</title>
    <!-- JQuery & JQuery UI -->
    <style>
    	<%@include file="../../resources/css/style.css"%>
    	<%@include file="../../resources/css/bootstrap.css"%>
    </style>
    <script type="text/javascript">
    	<%@include file="../../resources/javascript/jquery-2.2.2.min.js"%>
    	<%@include file="../../resources/javascript/scripts.js"%>
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js" type="text/javascript"></script>
    <!-- JQuery UI Css -->
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
          
		
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
 <![endif]-->
<!-- 23/06/2021 - Creating a static list of patients -->
<style>
table {
  border-collapse: collapse;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #04AA6D;
  color: white;
}
	
table#table1 {
    width:100%; 
    margin-top:15%;
    margin-left:5%
    margin-right:5%
}
</style>
</head>
<body>

<% User user= (User)session.getAttribute("User"); %>

<!--Navigation Bar-->
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand pull-left" href="index.html">
                	<img src="../../resources/images/logo.png" style="margin-top:-16px;" class="img" alt="logo">
                </a>
                
            </div>
            <div class="navbar-header" style="padding-left: 20px; padding-top: 10px">
                <h4><font style="color:yellow">Welcome <%= user.getName()%></font></h4>
            </div>
           
            <div class="navbar-header" style="float: right; margin-top: 10px" id="LoginForm">
             <form class="form-inline" action="login.htm" method="POST">
             <input type="hidden"  class="btn btn-default" name="action" value="logout"/>
			  <input type="submit"  class="btn btn-default" name="Logout" value="Logout"/>
			   </form>
			</div>
         <div class="navbar-header" style="float: right; margin-top: 10px; margin-right: 10px" id="LoginForm">
              <form class="form-inline" action="account.htm" method="POST">
                <input type="hidden" id="userID" name="userID" value="<%= user.getUserID()%>"/>
       
              <input type="submit"  class="btn btn-default" name="MyAccount" value="My Account"/>
			   </form>
			</div>

         
        </div>
    </div>
    <!--Navigation Bar-->
    

    <table id="table1">
      <caption>Appointments for Today</caption>
	<tr>
	   <th>Token #</th> <th>Time</th> <th>Firstname</th> <th>Lastname</th> <th>Age</th>
	</tr>
	<tr>
	   <td>A001</td> <td>10:30 AM</td> <td>Jill</td> <td>Smith</td> <td>50</td>
	</tr>
	<tr> 
	   <td>A002</td> <td>11:00 AM</td> <td>Eve</td> <td>Jackson</td> <td>94</td>
	</tr>
	<tr>
	   <td>A003</td> <td>11:30 AM</td> <td>John</td> <td>Doe</td> <td>80</td>
        </tr>
	<tr>
	   <td>A004</td> <td>12:00 PM</td> <td>John</td> <td>Smith</td> <td>45</td>
        </tr>
	<tr>
	   <td>A005</td> <td> 1:00 PM</td> <td>Vijay</td> <td>Kumar</td> <td>60</td>
	</tr>
	<tr> 
	   <td>A006</td> <td> 1:30 PM</td> <td>Sam</td> <td>Jackson</td> <td>33</td>
	</tr>
	<tr>
	   <td>A007</td> <td> 2:00 PM</td> <td>Tom</td> <td>Holland</td> <td>65</td>
        </tr>
	<tr>
	   <td>A008</td> <td> 2:30 PM</td> <td>John</td> <td>Smith</td> <td>47</td>
        </tr>
    </table>
</body>
</html>

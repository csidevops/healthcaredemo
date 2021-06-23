
jQuery(document).ready(function() {
    /*Hide Result Divs*/
    $("#result").hide();
    $("#carResult").hide();
    $("#error").hide();
    $("#RegistrationFrom").hide();
    
    
    $("#register").click(function(){
    	$("#RegistrationFrom").show();
    	$("#LoginForm").hide();
    	$("#reg").empty();
    });
    
    /*Register User*/
    $("#register-user").click(function(){
    	$('#name,#email,#password,#cPassword').each(function () {
            if ($.trim($(this).val()) === '') {
                isValid = false;
                $(this).css({
                    "border": "1px solid red",
                    "background": "#FFCECE"
                });
            }
            else {
                $(this).css({
                    "border": "",
                    "background": ""
                    	
                });
                isValid = true;
               }
            });
    	if(isValid === true){registerUser();}

    });
    
    function registerUser(){
    	var name = $("#name").val();
    	var email = $("#email").val();
    	var password = $("#password").val();
    	var cPassword = $("#cPassword").val();
     	if(password != '' && password === cPassword){
    		var query = "action=register&name=" + name + "&email=" + email + "&password=" + password;
    		$("#err").hide();
    		$("#reg").hide();
    		$.ajax({
    			url:"signUp.htm",
    			data:query,
    			type:"post",
    			success:function(data, status, jqxhr){
    				var json = JSON.parse(jqxhr.responseText);
    				$("#reg").show();
    				$("#reg").append(
            				'<font style="color:green">'+ json.successmsg +'</font>'
            		);
    				$("#name").val("");
    		    	$("#email").val("");
    		    	$("#password").val("");
    		    	$("#cPassword").val("");
        		}
    		});
    	}
    	else{
    		$("#err").show();$("#err").append(
        				'<font style="color:red">Password Not Match</font>'
        		);
    		};
    		
}
    /*Log Click */
    $("#log").click(function(){
    	$("#RegistrationFrom").hide();
    	$("#LoginForm").show();
    });
    
    /*Validation Action Performed*/
    $('#btn').click(function(){
            $('#form-pick-up,#pickUpDate,#dropOffDate').each(function () {
                if ($.trim($(this).val()) === '') {
                    isValid = false;
                    $(this).css({
                        "border": "1px solid red",
                        "background": "#FFCECE"
                    });
                }
                else {
                    $(this).css({
                        "border": "",
                        "background": ""
                    });
                   isValid = true; 
                }
            });
            if(isValid === true){clickAction();}
          });

    

    
    /* button action performed */
function clickAction(){
	$('#loading').html('<img src="../../resources/images/loader.gif"> fetching...');
	$("#loading").show();
		var numRecord = "";
        var pickUp = $("#form-pick-up").val();
        var startDate = $("#pickUpDate").val();
        var startTime = $("#startTime").val();
        var endDate = $("#dropOffDate").val();
        var endTime = $("#endTime").val();
        var userID = $("#userID").val();
        if(userID === undefined){
        	userID = null;
        }
        var apiKey = "7eez6hvgkcgs5y3fc4px4mmb"; 
        var query = "http://api.hotwire.com/v1/search/car?apikey=" +apiKey+ "&dest=" +pickUp+ "&startdate=" +startDate+ "&enddate=" +endDate+ "&pickuptime=" +startTime+ "&dropofftime=" +endTime+ "&format=jsonp";
        $.ajax({
            type: 'GET',
            url: query,
            dataType: "jsonp",
            jsonpCallback: 'callback',
            success: function(data,status,jqxhr){
            	statusCode = data.StatusCode;
                statusDesc = data.StatusDesc;
                if(statusCode == 0){
                	 $("#loading").hide();
                	 $("#result").show();
                     $("#carResult").show();
                     $("#error").hide();

                    numRecord = data.Result.length;
                	var carMetaData = jqxhr.responseJSON.MetaData.CarMetaData.CarTypes;
                	console.log(carMetaData);
                	 var Result = jqxhr.responseJSON.Result;
                	 console.log(Result);
                     var count =1;
                     
                    /*For Car Details*/
                    $.each(carMetaData, function(index){
                    	console.log(index);
                        $("#result").append(
                        		'<div class="row">'+
                                '<div class="col-xs-6 col-sm-6">'+
                                '<img src="http://localhost:8095/Rohit/resources/images/Standard_SUV_correct.png" class="img-responsive" alt="car"/>'+
                                '<div class="car-type">'+carMetaData[index].CarTypeName+'</div>'+
                                '<div class="car-name">'+carMetaData[index].PossibleModels+'</div>'+
                                '<div class="car-name">'+carMetaData[index].TypicalSeating+'</div>'+
                                '</div>'+
                                '</div>'
                               );
                        $("#carResult").append(
                        		'<form:form action="booking.htm" method="POST" commandName="bookingDetails">'+
                        		'<div class="row">'+
                                '<div class="col-xs-6 col-sm-6">'+
                                '<div class="car-type price">'+'<p>'+'<b>'+Result[index].CurrencyCode+'<input type="hidden" name="DailyRate" value='+Result[index].DailyRate+'/>' +Result[index].DailyRate+ '</b>'+'<p>'+'</div>'+'<input type="hidden" name="TaxesAndFees" value='+Result[index].TaxesAndFees+'>'+'<input type="hidden" name="HWRefNumber" value='+Result[index].HWRefNumber+'>'+'<input type="hidden" name="bookingDate" value='+Result[index].PickupDay+'>'+'<input type="hidden" name="expiryDate" value='+Result[index].DropoffDay+'>'+'<input type="hidden" name="bookingTime" value='+Result[index].PickupTime+'>'+'<input type="hidden" name="expiryTime" value='+Result[index].DropoffTime+'>'+'<input type="hidden" name="sourceLocation" value='+Result[index].PickupAirport+'>'+'<input type="hidden" name="destination" value='+Result[index].PickupAirport+'>'+
                                '<div class="car-name">'+'<p>'+'<b>'+ 'Total Price'+ '<input type="hidden" name="TotalPrice" value='+Result[index].TotalPrice+'/>'+Result[index].TotalPrice+ 'FOR'+ ' '+ '<input type="hidden" name="RentalDays" value='+Result[index].RentalDays+'/>'+Result[index].RentalDays+ 'DAY'+'</b>'+'</p>'+'</div>'+
                                '<input type="submit" value="Book" id=book'+count+ '>'+
                                '</div>'+
                                '</div>'+
                                '<input type="hidden" name="userID" value='+userID+'>'+
                                '<input type="hidden" name="model" value='+carMetaData[index].PossibleModels+'>'+
                                '<input type="hidden" name="name" value='+carMetaData[index].CarTypeName+'>'+
                                '<input type="hidden" name="TypicalSeating" value='+carMetaData[index].TypicalSeating+'>'+
                                '</form:form>'
                                );
                          count++;
                      });

                    /* For currency details */
                      /* $.each(Result, function(index){
                          $("#carResult").append(
                        		'<form action="booking.htm" method="POST">'+
                          		'<div class="row">'+
                                '<div class="col-xs-6 col-sm-6">'+
                                '<div class="car-type price">'+'<p>'+'<b>'+Result[index].CurrencyCode+ +Result[index].DailyRate+ '</b>'+'<p>'+'</div>'+
                                '<div class="car-name">'+'<p>'+'<b>'+ 'Total Price'+ ''  +Result[index].TotalPrice+ 'FOR'+ ' ' +Result[index].RentalDays+ 'DAY'+'</b>'+'</p>'+'</div>'+
                                '<input type="submit" value="Book" class="btn-book" id=book'+count+ '>'+
                                '</div>'+
                                '</div>'+
                                '</form>'
                                );
                          count++;
                      });*/
                        for(var i=0; i<=numRecord; i++){
                        	$(document).on('click','[id^="book'+i+'"]',function(){
                        			
                            	});
                        };
                        
                }
                else{
                	
                    setTimeout(function () {
                    	$("#loading").hide();
                    	$("#error").show();
                    	$("#result").hide();
                        $("#carResult").hide();
                        error = $("#msg").text();
                        if(error === ''){
    	                	$("#error").append(
    	                    		'<p><h5 id="msg">!Unfortunately, you cannot travel in the past. Please adjust your pick-up Date & Time.</h5></p>'	
    	                    	);
                        }
                    }, 2000);
                	
                	
                }
                
            },
            error: function() { console.log('Not Success'); }
            
        });
        
        	
        }
        
/* Datepicker Jquery*/
$("#pickUpDate").datepicker({
    minDate: 0
});

$("#dropOffDate").datepicker({
    minDate: 0
});



    /*Autocomplete*/
$("#form-pick-up").autocomplete({
                source: function( request, response ) {
                $.ajax({
                    url: "http://localhost:8095/Rohit/resources/javascript/code.json",
                    dataType: "json",
                    data: {term: request.term},
                    success: function(data) {
                                response($.map(data, function(item) {
                                return {
                                    label: item.abbrev
                                   };
                            }));
                        }
                    });
                },
                minLength: 2
            });

});

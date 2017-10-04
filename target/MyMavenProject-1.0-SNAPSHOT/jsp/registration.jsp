
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html >

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
   
	<link href="css/registr_style.css" rel="stylesheet">
	<link href="css/bootstrap.min.css" rel="stylesheet">
    
  </head>
  
<body>
		<div class="container">  
  <form id="contact" action="" method="post">
    <h1>registration</h1>
	
      <input placeholder="Your Name" type="text"  required autofocus>
	  <input placeholder="Your Surname" type="text" required autofocus>
      <input placeholder="Your Email Address" type="email" required autofocus >
      <input placeholder="Your Phone Number " type="phone"required autofocus >
      <input placeholder="Your Country " type="text"required autofocus >
	  <input placeholder="Your Password)" type="password"required autofocus >
	  <input placeholder="Repeat Password" type="password" >
      
    <fieldset>
      <button name="registration" type="registration" >REGISTRATION</button>
    </fieldset>
  </form>
</div>
</body>
</html>
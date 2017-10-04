<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Replenish Account</title>
	<link rel="stylesheet"  href="css/replanish_style.css">
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>  <!--быстро открывает кнопку-->
	<script type="text/javascript" src="js/script.js"></script>
</head>

<body>

    </div>

<div id="main">

  <h1>replanish account</h1>
<form action="/controller" method="post">
  <ul class="container">
      <li class="menu">
          <ul>
		    <li class="button"><a href="#" class="blue">Choose card <span></span></a></li>
            <li class="dropdown">
                <ul>
                    <li><a href="#">card 1</a></li>
                    <li><a href="#">card 2</a></li>
                </ul>			
			</li>
          </ul>
      </li>
	  
	   <input placeholder="Sum" type="sum" required autofocus>	
		<button name="replanish" type="replanish" >REPLANISH</button>
  </ul>
</form>
</div>
</body>
</html>

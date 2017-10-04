<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Menu</title>
		<link rel="stylesheet" type="text/css" href="css/menu_style.css" />
		<script src="js/modernizr.custom.js"></script>
	</head>
	<body>
<!-- vladmaxi top bar -->
    <div class="vladmaxi-top">
      
        <span class="right">
            <a href="">
                <strong>exit</strong>
            </a>
			
        </span>
    </div>
<!--/ top bar -->
		<div class="container">	
			<header>
				<h1>menu <span>${user.getName} выберите операцию, которую хотите совершить </span></h1>
			</header>
			<form action="/controller" method="post">
			<div class="main clearfix">
				<nav id="menu" class="nav">					
					<ul>
						<li>
							<a href="#">
								<span>Главная</span>
							</a>
						</li>
						<li>
							<a href="#">
								</span>
								<span>Сервисы</span>
							</a>
						</li>
						<li>
							<a href="#">	
								<span>Портфолио</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span>Блог</span>
							</a>
						</li>						
					</ul>
				</nav>
			</div>
			</form>
		</div><!-- /container -->
	</body>
</html>
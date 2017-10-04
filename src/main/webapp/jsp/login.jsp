<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Login</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/login_style.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<!-- navbar -->
<header>
    <nav class="navbar navbar-default menu">
        <div class="container">
            <a class="navbar-brand" href="#">payment system</a>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">о нас </a></li>
                    <li class="active"><a href="#">контакты </a></li>
                    <li class="active"><a href="#">карта </a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</header>

<body>
<div id="login-form">
    <h1>АВТОРИЗАЦИЯ</h1>
    <fieldset>
        <form action="/controller" method="post">
            <input type="email" name="email" required value="Email" onBlur="if(this.value=='')this.value='Email'"
                   onFocus="if(this.value=='Email')this.value='' ">
            <input type="password" name="password" required value="Password" onBlur="if(this.value=='')this.value='Password'"
                   onFocus="if(this.value=='Password')this.value='' ">
            <button type="login">SIGN UP</button>
            <button type="registration">REGISTRATION</button>
        </form>
    </fieldset>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
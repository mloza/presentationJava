<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Logowanie do panelu administracyjnego</title>
    <meta charset="utf-8">
    
    <!-- Global stylesheets -->
    <link href="css/reset.css" rel="stylesheet" type="text/css">
    <link href="css/common.css" rel="stylesheet" type="text/css">
    <link href="css/form.css" rel="stylesheet" type="text/css">
    <link href="css/standard.css" rel="stylesheet" type="text/css">
    <link href="css/special-pages.css" rel="stylesheet" type="text/css">
    
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
    <link rel="icon" type="image/png" href="favicon-large.png">
    
    <!-- Generic libs -->
    <script type="text/javascript" src="js/html5.js"></script><!-- this has to be loaded before anything else -->
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/old-browsers.js"></script>       <!-- remove if you do not need older browsers detection -->
    
    <!-- Template core functions -->
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/standard.js"></script>
    <!--[if lte IE 8]><script type="text/javascript" src="js/standard.ie.js"></script><![endif]-->
    <script type="text/javascript" src="js/jquery.tip.js"></script>
    
</head>
<body class="special-page login-bg dark">
<!-- The template uses conditional comments to add wrappers div for ie8 and ie7 - just add .ie, .ie7 or .ie6 prefix to your css selectors when needed -->
<!--[if lt IE 9]><div class="ie"><![endif]-->
<!--[if lt IE 8]><div class="ie7"><![endif]-->
    
    <section id="login-block">
        <div class="block-border"><div class="block-content">
            
            <!--
            IE7 compatibility: if you want to remove the <h1>, 
            add style="zoom:1" to the above .block-content div
            -->
            <h1>Admin</h1>
            <div class="block-header">Please login</div>
            <c:if test="${not empty errorMsg}"> 
                <p class="message error no-margin">${errorMsg}</p>
            </c:if>
            
            <form class="form with-margin" name="login-form" id="login-form" method="post" action="/presentation/admin">
                <input type="hidden" name="a" id="a" value="send">
                <p class="inline-small-label">
                    <label for="login"><span class="big">User name</span></label>
                    <input type="text" name="login" id="login" class="full-width" value="${login}">
                </p>
                <p class="inline-small-label">
                    <label for="pass"><span class="big">Password</span></label>
                    <input type="password" name="password" id="pass" class="full-width" value="">
                </p>
                
                <button type="submit" class="float-right">Login</button>
            </form>
            
            <form class="form" id="password-recovery" method="post" action="">
                <fieldset class="grey-bg no-margin collapse">
                    <legend><a href="#">Lost password?</a></legend>
                    <p class="input-with-button">
                        <label for="recovery-mail">Enter your e-mail address</label>
                        <input type="text" name="recovery-mail" id="recovery-mail" value="">
                        <button type="button">Send</button>
                    </p>
                </fieldset>
            </form>
        </div></div>
    </section>

<!--[if lt IE 8]></div><![endif]-->
<!--[if lt IE 9]></div><![endif]-->
</body>
</html>
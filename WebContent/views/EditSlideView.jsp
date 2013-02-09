<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Global stylesheets -->
    <link href="css/reset.css" rel="stylesheet" type="text/css">
    <link href="css/common.css" rel="stylesheet" type="text/css">
    <link href="css/form.css" rel="stylesheet" type="text/css">
    <link href="css/standard.css" rel="stylesheet" type="text/css">
    
    <!-- Comment/uncomment one of these files to toggle between fixed and fluid layout -->
    <!--<link href="css/960.gs.css" rel="stylesheet" type="text/css">-->
    <link href="css/960.gs.fluid.css" rel="stylesheet" type="text/css">
    
    <!-- Custom styles -->
    <link href="css/simple-lists.css" rel="stylesheet" type="text/css">
    <link href="css/block-lists.css" rel="stylesheet" type="text/css">
    <link href="css/planning.css" rel="stylesheet" type="text/css">
    <link href="css/table.css" rel="stylesheet" type="text/css">
    <link href="css/calendars.css" rel="stylesheet" type="text/css">
    <link href="css/wizard.css" rel="stylesheet" type="text/css">
    <link href="css/gallery.css" rel="stylesheet" type="text/css">
    
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
    <link rel="icon" type="image/png" href="favicon-large.png">
    
    <!-- Generic libs -->
    <script type="text/javascript" src="js/html5.js"></script>              <!-- this has to be loaded before anything else -->
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/old-browsers.js"></script>       <!-- remove if you do not need older browsers detection -->
    
    <!-- Template libs -->
    <script type="text/javascript" src="js/jquery.accessibleList.js"></script>
    <script type="text/javascript" src="js/searchField.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/standard.js"></script>
    <!--[if lte IE 8]><script type="text/javascript" src="js/standard.ie.js"></script><![endif]-->
    <script type="text/javascript" src="js/jquery.hashchange.js"></script>
    <script type="text/javascript" src="js/jquery.contextMenu.js"></script>
    <script type="text/javascript" src="js/jquery.modal.js"></script>
    
    <!-- Custom styles lib -->
    <script type="text/javascript" src="js/list.js"></script>
    
    <!-- Plugins -->
    <script  type="text/javascript" src="js/jquery.dataTables.min.js"></script>
    <script  type="text/javascript" src="js/jquery.datepick/jquery.datepick.min.js"></script>
    
    <!-- Charts library -->
    <!--Load the AJAX API-->
    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript">
    
        // Load the Visualization API and the piechart package.
        google.load('visualization', '1', {'packages':['corechart']});
        
    </script>
<title>Zmień dane slajdu</title>
</head>
<body>
 <jsp:include page="/views/elements/header.jsp"/>
<div class="block-border">
    <div class="block-content">
        <h1>Edycja slajdu</h1>
        <!-- Add the class 'form' -->
<form method="post" class="form" action="/presentation/editslide">
	<input type="hidden" name="action" value="edittedSlide" />
	<input type="hidden" name="presentationID" value="${presentationID }" />
    <!-- inline-label class can be applied to an entire div, fieldset or even form -->
    <fieldset class="grey-bg inline-label">
    	
        <legend>Dane slajdu</legend>
        <p>
        	<label>ID slajdu: ${slide.id }</label>
        	<input type="hidden" name="slideID" value="${slide.id }"/>
        </p>
        <br>
        <p>
        	<label>Pozycja slajdu: ${slide.position }</label>
        </p>
        <br>
        <p>
        	<label>Typ slajdu: ${slide.type }</label>
        </p>
        <br>
       <p>
            <label for="opis">Opis</label>
            <textarea name="description" id="description" cols="50" rows="5">${slide.description } </textarea>
        </p>
        <p>
            <label for="opis">Czas trwania</label>
            <input type="text" name="duration" id="duration" value="${slide.duration }"/> sekund
        </p>
    </fieldset>  
    <button type="button" onclick="submit()">Wyślij</button>
</form>
    </div>
</div>
<jsp:include page="/views/elements/footer.jsp"/>
</body>
</html>
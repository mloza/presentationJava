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
    <script type="text/javascript" src="js/jquery.tip.js"></script>
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
<title>Lista prezentacji</title>
</head>
<body>

<table class="table" cellspacing="0" width="100%">
 
    <thead>
        <tr>
            <!-- This is a special cell for loading statuses - see below for more -->
            <th scope="col">ID</th> 
            <th scope="col">Nazwa</th>
            <th scope="col">Liczba slajdów</th>
            <th scope="col" class="table-actions">Działania</th>
        </tr>
    </thead>
 
    <tfoot>
        <tr>
            <td colspan="6"><img src="images/icons/fugue/arrow-curve-000-left.png" width="16" height="16" class="picto"> <b>Ilość wszystkich elementów:</b> 6 records found</td>
            
        </tr>
    </tfoot>
     
    <tbody> 
        <c:forEach var="presentation" items="${presentations}">
	         <tr>
		            <td>${presentation.id }</td>
		            <td>${presentation.name }</td>
		            <td>${presentation.getSlides().size() }</td>
					<!-- The class table-actions is designed for action icons -->
		            <td class="table-actions">
		                <a href="#" title="Przesuń w górę" class="with-tip"><img src="images/icons/fugue/navigation-090.png" width="16" height="16"></a>
		                <a href="#" title="Przesuń w dół" class="with-tip"><img src="images/icons/fugue/navigation-270.png" width="16" height="16"></a>
		                <a href="#" title="Edytuj" class="with-tip"><img src="images/icons/fugue/pencil.png" width="16" height="16"></a>
		                <a href="#" title="Usuń" class="with-tip"><img src="images/icons/fugue/cross-circle.png" width="16" height="16"></a>
		            </td>
	         </tr>
		</c:forEach>
         
         
        <tr>
            <td>1</td>
            <td>zdjęcie 1</td>
            <td>10</td>
            <td>zdjęcie</td>
            <td>przedstawia zdjęcie</td>
            
            <!-- The class table-actions is designed for action icons -->
            <td class="table-actions">
                <a href="#" title="Przesuń w górę" class="with-tip"><img src="images/icons/fugue/navigation-090.png" width="16" height="16"></a>
                <a href="#" title="Przesuń w dół" class="with-tip"><img src="images/icons/fugue/navigation-270.png" width="16" height="16"></a>
                <a href="#" title="Edytuj" class="with-tip"><img src="images/icons/fugue/pencil.png" width="16" height="16"></a>
                <a href="#" title="Usuń" class="with-tip"><img src="images/icons/fugue/cross-circle.png" width="16" height="16"></a>
            </td>
        </tr>

    </tbody>
 
</table>

</body>
</html>
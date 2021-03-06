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
    <script type="text/javascript" src="js/list.js"></script>
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
<title>Zmień kolejność slajdów</title>
</head>
<body>
<jsp:include page="/views/elements/header.jsp"/>
<table class="table" cellspacing="0" width="100%">
 
    <thead>
        <tr>
            <!-- This is a special cell for loading statuses - see below for more -->
            <th scope="col">Pozycja</th> 
            <th scope="col">Czas trwania</th>
            <th scope="col">Typ</th>
            <th scope="col">Opis</th>
            <th scope="col" class="table-actions">Działania</th>
        </tr>
    </thead>
 
    <tfoot>
        <tr>
            <td colspan="6"><img src="images/icons/fugue/arrow-curve-000-left.png" width="16" height="16" class="picto"> <b>Ilość wszystkich elementów:</b> ${slides.size() }</td>
        </tr>
    </tfoot>
    <tbody> 
        <c:forEach var="slide" items="${slides}" varStatus="idx">
	         <tr>
		            <td>${slide.position }</td>
		            <td>${slide.duration }</td>
		            <td>${slide.type }</td>
		            <td>${slide.description }</td>
					<!-- The class table-actions is designed for action icons -->
		            <td class="table-actions">
			            <c:if test="${idx.index != 0 }">
				             <form action="/presentation/slideorder" method="post" style="float: left">
				                <input type="hidden" name="action" value="up"/>
				                <input type="hidden" name="slideID" value="${slide.id}"/>
				                <input type="hidden" name="slidePos" value="${slide.position}"/>
				                <input type="hidden" name="presentationID" value="${presentationID}"/>
				                <input type="image" title="Przesuń w górę" class="with-tip" src="images/icons/fugue/navigation-090.png" width="16" height="16"/>
				            </form>
			            </c:if>
			            <c:if test="${idx.index != slides.size()-1 }">
				            <form action="/presentation/slideorder" method="post" style="float: left">
				                <input type="hidden" name="action" value="down"/>
				                <input type="hidden" name="slideID" value="${slide.id}"/>
				                <input type="hidden" name="slidePos" value="${slide.position}"/>
				                <input type="hidden" name="presentationID" value="${presentationID}"/>
				                <input type="image" title="Przesuń w dół" class="with-tip" src="images/icons/fugue/navigation-270.png" width="16" height="16"/>
				           </form>
			            </c:if>    
			            <form action="/presentation/editslide" method="post" style="float: left">
			            		<input type="hidden" name="presentationID" value="${presentationID}"/>
				                <input type="hidden" name="action" value="edit"/>
				                <input type="hidden" name="slideID" value="${slide.id}"/>
				                <input type="image" title="Edytuj" class="with-tip" src="images/icons/fugue/pencil.png" width="16" height="16"/>
				        </form>
				        <form action="/presentation/slideorder" method="post" style="float: left">
				                <input type="hidden" name="action" value="delete"/>
				                <input type="hidden" name="slideID" value="${slide.id}"/>
				                <input type="hidden" name="slidePos" value="${slide.position}"/>
				                <input type="hidden" name="presentationID" value="${presentationID}"/>
				                <input type="image" title="Usuń" class="with-tip" src="images/icons/fugue/cross-circle.png" width="16" height="16"/>
				        </form>   			                
		            </td>
	         </tr>
		</c:forEach>
    </tbody>
    
</table>
<jsp:include page="/views/elements/footer.jsp"/>
</body>
</html>
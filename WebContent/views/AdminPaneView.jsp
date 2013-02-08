<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

    <title>Panel Administracyjny</title>
    <meta charset="utf-8">
    
    <!-- Global stylesheets -->
    <link href="/presentation/css/reset.css" rel="stylesheet" type="text/css">
    <link href="/presentation/css/common.css" rel="stylesheet" type="text/css">
    <link href="/presentation/css/form.css" rel="stylesheet" type="text/css">
    <link href="/presentation/css/standard.css" rel="stylesheet" type="text/css">
    
    <!-- Comment/uncomment one of these files to toggle between fixed and fluid layout -->
    <!--<link href="/presentation/css/960.gs.css" rel="stylesheet" type="text/css">-->
    <link href="/presentation/css/960.gs.fluid.css" rel="stylesheet" type="text/css">
    
    <!-- Custom styles -->
    <link href="/presentation/css/simple-lists.css" rel="stylesheet" type="text/css">
    <link href="/presentation/css/block-lists.css" rel="stylesheet" type="text/css">
    <link href="/presentation/css/planning.css" rel="stylesheet" type="text/css">
    <link href="/presentation/css/table.css" rel="stylesheet" type="text/css">
    <link href="/presentation/css/calendars.css" rel="stylesheet" type="text/css">
    <link href="/presentation/css/wizard.css" rel="stylesheet" type="text/css">
    <link href="/presentation/css/gallery.css" rel="stylesheet" type="text/css">
    
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="/presentation/favicon.ico">
    <link rel="icon" type="image/png" href="/presentation/favicon-large.png">
    
    <!-- Generic libs -->
    <script type="text/javascript" src="/presentation/js/html5.js"></script>              <!-- this has to be loaded before anything else -->
    <script type="text/javascript" src="/presentation/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="/presentation/js/old-browsers.js"></script>       <!-- remove if you do not need older browsers detection -->
    
    <!-- Template libs -->
    <script type="text/javascript" src="/presentation/js/jquery.accessibleList.js"></script>
    <script type="text/javascript" src="/presentation/js/searchField.js"></script>
    <script type="text/javascript" src="/presentation/js/common.js"></script>
    <script type="text/javascript" src="/presentation/js/standard.js"></script>
    <!--[if lte IE 8]><script type="text/javascript" src="/presentation/js/standard.ie.js"></script><![endif]-->
    <script type="text/javascript" src="/presentation/js/jquery.tip.js"></script>
    <script type="text/javascript" src="/presentation/js/jquery.hashchange.js"></script>
    <script type="text/javascript" src="/presentation/js/jquery.contextMenu.js"></script>
    <script type="text/javascript" src="/presentation/js/jquery.modal.js"></script>
    
    <!-- Custom styles lib -->
    <script type="text/javascript" src="/presentation/js/list.js"></script>
    
    <!-- Plugins -->
    <script  type="text/javascript" src="/presentation/js/jquery.dataTables.min.js"></script>
    <script  type="text/javascript" src="/presentation/js/jquery.datepick/jquery.datepick.min.js"></script>
    
    <!-- Charts library -->
    <!--Load the AJAX API-->
    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript">
    
        // Load the Visualization API and the piechart package.
        google.load('visualization', '1', {'packages':['corechart']});
        
    </script>
    
</head>
<body>
<!-- The template uses conditional comments to add wrappers div for ie8 and ie7 - just add .ie or .ie7 prefix to your css selectors when needed -->
<!--[if lt IE 9]><div class="ie"><![endif]-->
<!--[if lt IE 8]><div class="ie7"><![endif]-->
    
    <jsp:include page="/views/header.jsp"></jsp:include>
    
    
</body>
</html>
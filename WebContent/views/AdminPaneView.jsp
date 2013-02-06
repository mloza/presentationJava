<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

    <title>Panel Administracyjny</title>
    <meta charset="utf-8">
    
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
    
</head>
<body>
<!-- The template uses conditional comments to add wrappers div for ie8 and ie7 - just add .ie or .ie7 prefix to your css selectors when needed -->
<!--[if lt IE 9]><div class="ie"><![endif]-->
<!--[if lt IE 8]><div class="ie7"><![endif]-->
    
    <!-- Header -->
    
    <!-- Server status -->
    <header><div class="container_12">
        
        <p id="skin-name"><small>Constellation<br> Admin Skin</small> <strong>1.2</strong></p>
        <div class="server-info">Server: <strong>Apache 2.2.14</strong></div>
        <div class="server-info">Php: <strong>5.3.1</strong></div>
        
    </div></header>
    <!-- End server status -->
    
    <!-- Main nav -->
    <nav id="main-nav">
        
        <ul class="container_12">
            <li class="home current"><a href="#" title="Home">Home</a>
                <ul>
                    <li class="current"><a href="#" title="Dashboard">Dashboard</a></li>
                    <li><a href="#" title="My profile">My profile</a></li>
                    <li class="with-menu"><a href="#" title="My settings">My settings</a>
                        <div class="menu">
                            <img src="images/menu-open-arrow.png" width="16" height="16">
                            <ul>
                                <li class="icon_address"><a href="#">Browse by</a>
                                    <ul>
                                        <li class="icon_blog"><a href="#">Blog</a>
                                            <ul>
                                                <li class="icon_alarm"><a href="#">Recents</a>
                                                    <ul>
                                                        <li class="icon_building"><a href="#">Corporate blog</a></li>
                                                        <li class="icon_newspaper"><a href="#">Press blog</a></li>
                                                    </ul>
                                                </li>
                                                <li class="icon_building"><a href="#">Corporate blog</a></li>
                                                <li class="icon_computer"><a href="#">Support blog</a></li>
                                                <li class="icon_search"><a href="#">Search...</a></li>
                                            </ul>
                                        </li>
                                        <li class="icon_server"><a href="#">Website</a></li>
                                        <li class="icon_network"><a href="#">Domain</a></li>
                                    </ul>
                                </li>
                                <li class="icon_export"><a href="#">Export</a>
                                    <ul>
                                        <li class="icon_doc_excel"><a href="#">Excel</a></li>
                                        <li class="icon_doc_csv"><a href="#">CSV</a></li>
                                        <li class="icon_doc_pdf"><a href="#">PDF</a></li>
                                        <li class="icon_doc_image"><a href="#">Image</a></li>
                                        <li class="icon_doc_web"><a href="#">Html</a></li>
                                    </ul>
                                </li>
                                <li class="sep"></li>
                                <li class="icon_refresh"><a href="#">Reload</a></li>
                                <li class="icon_reset">Reset</li>
                                <li class="icon_search"><a href="#">Search</a></li>
                                <li class="sep"></li>
                                <li class="icon_terminal"><a href="#">Custom request</a></li>
                                <li class="icon_battery"><a href="#">Stats server load</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </li>
            <li class="write"><a href="#" title="Write">Write</a>
                <ul>
                    <li><a href="#" title="Articles">Articles</a></li>
                    <li><a href="#" title="Add article">Add article</a></li>
                    <li><a href="#" title="Posts">Posts</a></li>
                    <li><a href="#" title="Add post">Add post</a></li>
                </ul>
            </li>
            <li class="comments"><a href="#" title="Comments">Comments</a>
                <ul>
                    <li><a href="#" title="Manage">Manage</a></li>
                    <li><a href="#" title="Spams">Spams</a></li>
                </ul>
            </li>
            <li class="medias"><a href="#" title="Medias">Medias</a>
                <ul>
                    <li><a href="#" title="Browse">Browse</a></li>
                    <li><a href="#" title="Add file">Add file</a></li>
                    <li><a href="#" title="Manage">Manage</a></li>
                    <li><a href="#" title="Settings">Settings</a></li>
                </ul>
            </li>
            <li class="users"><a href="#" title="Users">Users</a>
                <ul>
                    <li><a href="#" title="Browse">List</a></li>
                    <li><a href="#" title="Add user">Add user</a></li>
                    <li><a href="#" title="Settings">Settings</a></li>
                </ul>
            </li>
            <li class="stats"><a href="#" title="Stats">Stats</a></li>
            <li class="settings"><a href="#" title="Settings">Settings</a></li>
            <li class="backup"><a href="#" title="Backup">Backup</a></li>
        </ul>
    </nav>
    <!-- End main nav -->
    
    <!-- Sub nav -->
    <div id="sub-nav"><div class="container_12">
        
        <a href="#" title="Help" class="nav-button"><b>Help</b></a>
    
        <form id="search-form" name="search-form" method="post" action="search.html">
            <input type="text" name="s" id="s" value="" title="Search admin..." autocomplete="off">
        </form>
    
    </div></div>
    <!-- End sub nav -->
    
    <!-- Status bar -->
    <div id="status-bar"><div class="container_12">
    
        <ul id="status-infos">
            <li class="spaced">Logged as: <strong>Admin</strong></li>
            <li><a href="login.html" class="button red" title="Logout"><span class="smaller">LOGOUT</span></a></li>
        </ul>
        
        <ul id="breadcrumb">
            <li><a href="#" title="Home">Home</a></li>
            <li><a href="#" title="Dashboard">Dashboard</a></li>
        </ul>
    
    </div></div>
    <!-- End status bar -->
    
    <div id="header-shadow"></div>
    <!-- End header -->
    
    
</body>
</html>
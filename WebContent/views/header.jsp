<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
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
                    <li class="current"><a href="#" title="Dashboard">Dash	board</a></li>
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
            <li class="medias"><a href="#" title="Prezentacje">Prezentacje</a>
                <ul>
                    <li><a href="#" title="Lista prezentacji">Zarządzaj prezentacjami</a></li>
                    <li><a href="#" title="Dodaj prezentację">Dodaj prezentację</a></li>
                </ul>
            </li>
            <li class="comments"><a href="#" title="Aktualności">Aktualności</a>
                <ul>
                    <li><a href="/presentation/shownews" title="Zarządzaj newsami">Zarządzaj newsami</a></li>
                    <li><a href="/presentation/addnews" title="Dodaj newsa">Dodaj newsa</a></li>
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
    </div></div>
    <!-- End sub nav -->
    
    <!-- Status bar -->
    <div id="status-bar"><div class="container_12">
    
        <ul id="status-infos">
            <li class="spaced">Logged as: <strong>${sessionScope.user}</strong></li>
            <li><a href="/presentation/logout" class="button red" title="Logout"><span class="smaller">LOGOUT</span></a></li>
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
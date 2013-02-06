<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

	<title>Błąd!</title>
	<meta charset="utf-8">
	<meta name="robots" content="none">
	
	<!-- Mobile metas -->
	<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
	
	<!-- Global stylesheets -->
	<link href="../css/reset.css" rel="stylesheet" type="text/css">
	<link href="../css/common.css" rel="stylesheet" type="text/css">
	<link href="../css/form.css" rel="stylesheet" type="text/css">
	<link href="../css/standard.css" rel="stylesheet" type="text/css">
	<link href="../css/special-pages.css" rel="stylesheet" type="text/css">
	
	<!-- Custom styles -->
	<link href="../css/simple-lists.css" rel="stylesheet" type="text/css">
	
	<!-- Favicon -->
	<link rel="shortcut icon" type="image/x-icon" href="../favicon.ico">
	<link rel="icon" type="image/png" href="../favicon-large.png">
	
	<!-- Generic libs -->
	<script type="text/javascript" src="../js/html5.js"></script><!-- this has to be loaded before anything else -->
	<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
	
	<!-- Template core functions -->
	<script type="text/javascript" src="../js/common.js"></script>
	<script type="text/javascript" src="../js/standard.js"></script>
	<!--[if lte IE 8]><script type="text/javascript" src="../js/standard.ie.js"></script><![endif]-->
	<script type="text/javascript" src="../js/jquery.tip.js"></script>
	
	<!-- Template custom styles libs -->
	<script type="text/javascript" src="../js/list.js"></script>
	
</head>
    <body class="special-page error-bg red dark">
<!-- The template uses conditional comments to add wrappers div for ie8 and ie7 - just add .ie or .ie7 prefix to your css selectors when needed -->
<!--[if lt IE 9]><div class="ie"><![endif]-->
<!--[if lt IE 8]><div class="ie7"><![endif]-->
	
	<section id="error-desc">
		
		<ul class="action-tabs with-children-tip children-tip-left">
			<li><a href="javascript:history.back()" title="Go back"><img src="../images/icons/fugue/navigation-180.png" width="16" height="16"></a></li>
		</ul>
		<div class="block-border"><div class="block-content">
				
			<h1>Admin</h1>
			<div class="block-header">Wystąpił błąd!</div>
			
			<h2>Opis błędu</h2>
			
			<h5>Message</h5>
			<p>${msg}</p>

		</div></div>
	</section>
	
	<section id="error-log">
		<div class="block-border"><div class="block-content">
				
			<h1>Error details</h1>
			
			<div class="fieldset grey-bg with-margin">
				<p><b>Message</b><br>
				Undefined variable: test</p>
			</div>
			
			<ul class="picto-list">
				<li class="icon-tag-small"><b>Php error level:</b> 256</li>
				<li class="icon-doc-small"><b>File:</b> Constellation/html/error.html</li>
				<li class="icon-pin-small"><b>Line:</b> 51</li>
			</ul>
			
			<!--<h2>Stack backtrace</h2>
			<ul class="picto-list icon-top with-line-spacing">
				<li><b>Constellation/html/error.html</b> @ line <b>64</b>: checkLoadData(array(5))</li>
				<li><b>Constellation/html/error.html</b> @ line <b>68</b>: loadUser(42)</li>
				<li><b>Constellation/html/error.html</b> @ line <b>72</b>: initUser()</li>
			</ul>-->
			
		</div></div>
	</section>

<!--[if lt IE 8]></div><![endif]-->
<!--[if lt IE 9]></div><![endif]-->
</body>
</html>

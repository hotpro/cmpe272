<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName() +":"+request.getServerPort()+path +"/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" ng-app="adminApp">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  		<base href="<%=basePath%>"/> 
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  		<link href="resources/css" rel="stylesheet" type="text/css"/>
  		<title>Admin Management Home. Mobile Health Sensor, Group #1</title>
  		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="resources/bootstrap-custom.css" type="text/css"/>
       	<link rel="stylesheet" href="resources/icomoon.css" type="text/css"/>
       	<link rel="stylesheet" href="resources/font-awesome.css" type="text/css"/>
       	<link rel="stylesheet" href="resources/tipsy.css" type="text/css"/>
   		<link rel="stylesheet" href="resources/docs.css" type="text/css"/>
   		<link rel="stylesheet" href="resources/pygments.css" type="text/css"/>

		<script type="text/javascript">
		    var DOCUMENTATION_OPTIONS = {
		     URL_ROOT:    '#',
		     VERSION:     '3.0',
		     COLLAPSE_INDEX: false,
		     FILE_SUFFIX: '',
		     HAS_SOURCE:  false,
		    };
		</script>
  
	    <script type="text/javascript" src="resources/jquery.js"></script>
	    <script type="text/javascript" src="resources/underscore.js"></script>
	    <script type="text/javascript" src="resources/doctools.js"></script>
	    <script type="text/javascript" src="resources/bootstrap.js"></script>
	    <script type="text/javascript" src="resources/jquery.tipsy.js"></script>
	    <script type="text/javascript" src="resources/jquery.cookie.js"></script>
	    <script type="text/javascript" src="resources/navbar.js"></script>
	    <script type="text/javascript" src="resources/angular.js"></script>
	    <script type="text/javascript" src="resources/angular-route.js"></script>
	    <script type="text/javascript" src="resources/adminApp.js"></script>

	</head>
	<body ng-controller="MainContorller">
		<header id="header-db" class="row" role="navigation">
			<div class="header-content">
				<a class="icon-menu expand-toc-icon pull-left"></a>
				<div class="logo pull-left">
					<h1>Admin Health Sensor</h1>
				</div>
				<div class="logout pull-right">
					<a href="logout.html">
						<button class="btn">Logout</button>
					</a>
				</div>
			</div>
		</header>
	
		<aside class="sidebar">
			<div class="sphinxsidebar">
				<div class="sphinxsidebarwrapper" style="">
					<ul>
						<li class="toctree-l1"><a class="reference internal">Sensor List</a>
							<ul style="display: block;">
								<li class="toctree-l2 selected-item">
									<a class="reference internal"><span class="expand-icon"></span>Current Sensor List</a>
								</li>
							</ul>
						</li>

						<li class="toctree-l1"><a class="reference internal">User Management</a>
							<ul style="display: block;">
								<li class="toctree-l2">
									<a class="reference internal" href="admin/#/userListView/"><span class="expand-icon"></span>User Account List</a>
								</li>
							</ul>
						</li>
		
					</ul>
		
		
		
				</div>
			</div>
		
			</aside>
	
		<div class="content">
			<div class="main-column pull-left">
				<div class="document">
					<div class="documentwrapper">
						<div class="bodywrapper">
							<div class="body">
								
								<div ng-view></div>
								
								<div class="footer">
									<div class="copyright">
										<p>© Group #1, Health Mobile Sensor, 2015.</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
</body></html>
<!--wj create 12/08/2015  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>Food Smart -- group 6</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="resources/bootstrap-custom.css"
	type="text/css" />
<link rel="stylesheet" href="resources/icomoon.css" type="text/css" />
<link rel="stylesheet" href="resources/font-awesome.css" type="text/css" />
<link rel="stylesheet" href="resources/tipsy.css" type="text/css" />
<link rel="stylesheet" href="resources/docs.css" type="text/css" />
<link rel="stylesheet" href="resources/pygments.css" type="text/css" />
<link href="resources/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="resources/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="resources/bootstrap-theme.min.css" rel="stylesheet"
	type="text/css">
<link href="resources/templatemo_style.css" rel="stylesheet"
	type="text/css">

<script type="text/javascript">
	var DOCUMENTATION_OPTIONS = {
		URL_ROOT : '#',
		VERSION : '3.0',
		COLLAPSE_INDEX : false,
		FILE_SUFFIX : '',
		HAS_SOURCE : false,
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
</head>

<body class="templatemo-bg-image-1">
	<div class="container">
		<div class="col-md-12">
			<h1 class="index_title">Food Smart</h1>
			<!--<div class = ""><%= path %>  -->
			<form
				class="form-horizontal form-horizontal1 templatemo-container templatemo-login-form-1 margin-bottom-30"
				role="form" action="j_spring_security_check" method="post">
				<div class="form-group">
					<div class="col-xs-12">
						<div class="control-wrapper">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							<%--<input type='hidden' name='csrfmiddlewaretoken' value='{% csrf_token %}' />--%>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12">
						<div class="control-wrapper">
							<label for="username" class="control-label fa-label"><i
								class="fa fa-medium"></i></label> <input type="text"
																		 name="username"
								class="form-control" id="username" placeholder="Username">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<div class="control-wrapper">
							<label for="password" class="control-label fa-label"><i
								class="fa fa-medium"></i></label> <input type="password"
																		 name="password"
								class="form-control" id="password" placeholder="Password">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<div class="checkbox control-wrapper">
							<label> <input type="checkbox"> Remember me
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<div class="control-wrapper">
							<input type="submit" value="Log in" class="btn btn-info">
							<a href="forgot-password.html" class="text-right pull-right">Forgot
								password?</a>
						</div>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<div class="col-md-12">
						<label>Login with: </label>
						<div class="inline-block">
							<a href="https://www.facebook.com"><i
								class="fa fa-facebook-square login-with"></i></a> <a href="#"><i
								class="fa fa-twitter-square login-with"></i></a> <a href="#"><i
								class="fa fa-google-plus-square login-with"></i></a> <a href="#"><i
								class="fa fa-tumblr-square login-with"></i></a> <a href="#"><i
								class="fa fa-github-square login-with"></i></a>
						</div>
					</div>
				</div>
			</form>
			<div class="text-center">
				<a href="register-1.html" class="templatemo-create-new">Create new
					account <i class="fa fa-arrow-circle-o-right"></i>
				</a>
			</div>
			<div class="index_footer">
				<div class="copyright">
					<p>© Group 6, Food Management Platform, 2015.</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
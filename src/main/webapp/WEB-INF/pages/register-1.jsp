<!--wj create 12/08/2015  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<base href=" <%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="resources/css" rel="stylesheet" type="text/css" />
<title>Create Account</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="resources/bootstrap-custom.css"
	type="text/css" />
<!--<link rel="stylesheet" href="resources/icomoon.css" type="text/css" />
<link rel="stylesheet" href="resources/font-awesome.css" type="text/css" />
<link rel="stylesheet" href="resources/tipsy.css" type="text/css" />
<link rel="stylesheet" href="resources/docs.css" type="text/css" />
<link rel="stylesheet" href="resources/pygments.css" type="text/css" />  -->
<link href="resources/font-awesome.min.css" rel="stylesheet"
	type="text/css" />
<link href="resources/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="resources/bootstrap-theme.min.css" rel="stylesheet"
	type="text/css" />
<link href="resources/templatemo_style.css" rel="stylesheet"
	type="text/css" />

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
<body class="templatemo-bg-image-2">
	<!--<header id="header-db" class="row" role="navigation">
	<div class="header-content">
		<a class="icon-menu expand-toc-icon pull-left"></a>
		<div class="logo pull-left">
			<h1>Food Management Platform</h1>
		</div>

	</div>
	</header>-->



	<div class="content">
		<div class="container">
			<div class="col-md-12">
				<!--<div class="main-column pull-left">
			<div class="document">
				<div class="documentwrapper">
					<div class="bodywrapper">
						<div class="body">
							<div class="section" style="width: 460px;">-->
				<h1 class="title margin-bottom-15">Create Account</h1>
				<!--<div class="section" id="getting-started">-->

				<form
					class="templatemo-contact-form-1 form-position form-horizontal templatemo-contact-form-1"
					action="register" method="post">
					<div class="col-md-12">
						<label for="lastName" class="col-sm-6 control-label">Last
							Name:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control margin-bottom-8"
								id="lastName" placeholder="Last Name" name="lastname">
						</div>
					</div>
					<div class="col-md-12">
						<label for="firstName" class="col-sm-6 control-label">First
							Name:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control margin-bottom-8"
								id="firstName" placeholder="First Name" name="firstname">
						</div>
					</div>
					<div class="col-md-12">
						<label for="address" class="col-sm-6 control-label">Address:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control margin-bottom-8"
								id="address" placeholder="Address" name="address">
						</div>
					</div>
					<div class="col-md-12">
						<label for="email" class="col-sm-6 control-label">Email:</label>
						<div class="col-sm-6">
							<input type="email" class="form-control margin-bottom-8"
								id="email" placeholder="Email" name="email">
						</div>
					</div>
					<div class="col-md-12">
						<label for="phone" class="col-sm-6 control-label">Phone:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control margin-bottom-8"
								id="phone" placeholder="Phone" name="phone">
						</div>
					</div>
					<div class="col-md-12">
						<label for="password" class="col-sm-6 control-label">Password:</label>
						<div class="col-sm-6">
							<input type="password" class="form-control margin-bottom-8"
								id="password" placeholder="password" name="password">
						</div>
					</div>
					<div class="col-md-12">
						<label for="confirmPassword" class="col-sm-6 control-label">Confirm
							Password:</label>
						<div class="col-sm-6">
							<input type="password" class="form-control margin-bottom-8"
								id="confirmPassword" placeholder="confirmPassword"
								name="passwordConfirmPassword">
						</div>
					</div>
					<div class="col-md-12">
						<label for="creditCard" class="col-sm-6 control-label">Credit
							Card:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control margin-bottom-8"
								id="creditCard" placeholder="creditCard" name="creditCard">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-6 col-sm-6">
							<button type="submit" class="btn btn-default">Sign In</button>
						</div>
					</div>
				</form>

			</div>
		</div>
		<div class="footer">
			<div class="copyright">
				<p>© Group 6, Food Management Platform, 2015.</p>
			</div>
		</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>

</body>
</html>